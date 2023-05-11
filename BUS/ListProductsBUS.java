package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import DTO.*;
import DAO.*;

public class ListProductsBUS implements Serializable, DanhSachBUS {
       private ArrayList<ProductsDTO> arr;
       private int count_food = 0;
       private int count_drink = 0;
       FoodProductsDAO temp_food = new FoodProductsDAO();
       DrinkProductsDAO temp_drink = new DrinkProductsDAO();

       public ListProductsBUS() {
              this.arr = new ArrayList<ProductsDTO>();
              // set du lie truoc
              // Food food1 = new Food("Gà rán", false, false, 20, "2022", getMaSP_Food(),
              // "NCC001", 10, 2);
              // Food food2 = new Food("Cơm gà", false, false, 20, "2023", getMaSP_Food(),
              // "NCC001", 10, 3);

              // // count_food = 2;

              // Drink drink1 = new Drink("Coca", false, 20, "2021", 5, getMaSP_Drink(),
              // "NCC001", 10);
              // Drink drink2 = new Drink("Redbull", false, 50, "2021", 5, getMaSP_Drink(),
              // "NCC002", 10);
              // // count_drink = 2;

              // themFood_database(food1);
              // themFood_database(food2);
              // themDrink_database(drink1);
              // themDrink_database(drink2);

              // this.arr.add(drink1);
              // this.arr.add(drink2);
              // this.arr.add(food1);
              // this.arr.add(food2);

              setArr(arr);

       }

       public ListProductsBUS(ArrayList<FoodDTO> list_Foods, ArrayList<DrinkDTO> list_drink) {
              if (list_Foods == null && list_drink == null) {
                     new ListProductsBUS();
              } else {
                     this.arr = new ArrayList<ProductsDTO>();
                     this.count_drink = list_drink.size();
                     this.count_food = list_Foods.size();
                     for (FoodDTO food : list_Foods) {
                            this.arr.add(food);
                     }
                     for (DrinkDTO drink : list_drink) {
                            this.arr.add(drink);
                     }
                     setArr(arr);
              }

       }

       public void setArr(ArrayList<ProductsDTO> arr) {
              this.arr = arr;
       }

       public ArrayList<ProductsDTO> getArr() {
              return arr;
       }
       public ProductsDTO timkiemsp(String maSP) {
              for (ProductsDTO products : arr) {
                  if (products.getMaSP().equals(maSP)) {
                      return products;
                  }
              }
              return null;
          }

       public void setCount_drink(int count_drink) {
              this.count_drink = count_drink;
       }

       public void setCount_food(int count_food) {
              this.count_food = count_food;
       }

       @Override
       public String getMaSP_Drink() {
              count_drink++;
              Integer a = count_drink;
              String str = a.toString();
              while (str.length() != 3)
                     str = "0" + str;
              str = "D" + str;
              return str;
       }

       @Override
       public String getMaSP_Food() {
              count_food++;
              Integer a = count_food;
              String str = a.toString();
              while (str.length() != 3)
                     str = "0" + str;
              str = "F" + str;
              return str;
       }

       private float Thue(int gia) {
              return Math.round(gia * 0.5);
       }

       @Override
       public String getID() {
              return null;
       }

       @Override
       public void xuatTieuDe() {

       }

       @Override
       public void xuatDS() {

       }

       public ArrayList<ProductsDTO> timtheoKey_2(String tuKhoa) {
              ArrayList<ProductsDTO> list_search = new ArrayList<>();
              int gia;
              try {
                     gia = Integer.parseInt(tuKhoa);
              } catch (NumberFormatException e) {
                     gia = Integer.MIN_VALUE;
              }
              for (ProductsDTO products : this.arr) {
                     if (products.getMaSP().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                                   products.getNameProduct().toLowerCase(Locale.ROOT)
                                                 .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                   ||
                                   products.getExpiry_date().toLowerCase(Locale.ROOT)
                                                 .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                   ||
                                   products.getMaNCC().toLowerCase(Locale.ROOT)
                                                 .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                   ||
                                   products.getSoluong() == gia ||
                                   products.getPrice() == gia ||
                                   products.getTaxes() == gia) {
                            list_search.add(products);
                     }
              }
              return list_search;
       }

       public boolean Sua_2(ProductsDTO products) {
              if (products != null) {
                     if (products instanceof FoodDTO) {
                            if (updateFood_database((FoodDTO) products)) {
                                   return true;
                            } else {
                                   return false;
                            }
                     }
                     if (products instanceof DrinkDTO) {
                            if (updateDrink_database((DrinkDTO) products)) {
                                   return true;
                            } else {
                                   return false;
                            }
                     }
              }
              return false;
       }
       public void nhapvaokho(ChiTietPhieuDTO[] dsctp, int index, String maNSX, String date) {
              if (index == 0) {
                  return;
              }
              for (int i = 0; i < index; i++) {
                  int flag = -1;
                  String kt = dsctp[i].getMaSP();
                  for (ProductsDTO products : this.arr) {
                      if (products.getMaSP().equals(kt) == true) {
                          products.setSoluong(products.getSoluong() + dsctp[i].getSoLuong());
                          if (products instanceof FoodDTO) {
                              updateFood_database((FoodDTO) products);
                          }
                          if (products instanceof DrinkDTO) {
                              updateDrink_database((DrinkDTO) products);
                          }
                          flag = 0;
                          break;
                      }
                  }
                  if (flag == -1) {
                      // san pham moi
                      String expiry_date = Sys.takeDate_expiry(date);
                      String nameProduct = dsctp[i].getNameProduct();
                      String maSP = dsctp[i].getMaSP();
                      int soluong = dsctp[i].getSoLuong();
                      int price = dsctp[i].getDonGia();
                      Float taxes = Thue(price);
                      // kiem tra food hay drink
                      if (maSP.contains("F") == true) {
                          boolean vegetarian = false;
                          boolean Frozenfood = false;
                          FoodDTO moi = new FoodDTO(nameProduct, vegetarian, Frozenfood, price, expiry_date, maSP, maNSX, soluong,
                                  taxes);
                          this.arr.add(moi);
                          themFood_database(moi);
                      }
                      if (maSP.contains("D") == true) {
                          boolean alcoholic = false;
                          DrinkDTO moi = new DrinkDTO(nameProduct, alcoholic, price, expiry_date, taxes, maSP, maNSX, soluong);
                          this.arr.add(moi);
                          themDrink_database(moi);
                      }
                  }
              }
          }
      
          public void xuatkho(ChiTietPhieuDTO[] dsctp, int index) {
              if (index == 0) {
                  return;
              }
              for (int i = 0; i < index; i++) {
                  for (ProductsDTO sanpham : this.arr) {
                      if (dsctp[i].getMaSP().equals(sanpham.getMaSP())) {
                          sanpham.setSoluong(sanpham.getSoluong() - dsctp[i].getSoLuong());
                          if (sanpham instanceof FoodDTO) {
                              updateFood_database((FoodDTO) sanpham);
                          }
                          if (sanpham instanceof DrinkDTO) {
                              updateDrink_database((DrinkDTO) sanpham);
                          }
                          break;
                      }
                  }
              }
          }

          public boolean xoa_2(String maSP) {
            if (maSP.equals("") == false) {
                int flag = 0;
                for (ProductsDTO products : arr) {
                    if (products.getMaSP().equals(maSP)) {
                        if (products instanceof FoodDTO) {
                            if (xoaFood_database(maSP)) {
                                flag = 1;
    
                            }
                        }
                        if (products instanceof DrinkDTO) {
                            if (xoaDrink_database(maSP)) {
                                flag = 1;
    
                            }
                        }
                        break;
                    }
                }
                if (flag == 1) {
                    return true;
                }
                if (flag == 0) {
                    return false;
                }
            }
            return false;
        }
      
          // Lien quan den database , dem qua BUS
          public FoodDTO getFood(String idFood) {
             FoodDTO temp = null;
              try {
                  temp = temp_food.get(idFood);
                  return temp;
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return temp;
          }
      
          public DrinkDTO getDrink(String idDrink) {
              DrinkDTO temp = null;
              try {
                  temp = temp_drink.get(idDrink);
                  return temp;
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return temp;
          }
      
          private void themFood_database(FoodDTO food) {
              try {
                  temp_food.save(food);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      
          private void themDrink_database(DrinkDTO drink) {
              try {
                  temp_drink.save(drink);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      
          private boolean xoaFood_database(String id) {
              try {
                  if (temp_food.deleteById(id)) {
                      return true;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return false;
          }
      
          private boolean xoaDrink_database(String id) {
              try {
                  if (temp_drink.deleteById(id)) {
                      return true;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return false;
          }
      
          private boolean updateFood_database(FoodDTO food) {
              try {
                  if (temp_food.update(food)) {
                      return true;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return false;
          }
      
          private boolean updateDrink_database(DrinkDTO drink) {
              try {
                  if (temp_drink.update(drink)) {
                      return true;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return false;
          }
}
