package BUS;
import java.io.Serializable;
import java.util.Arrays;
import DTO.*;
public class dsChiTietPhieuBUS implements Serializable {
       private ChiTietPhieuDTO[] chiTietPhieus;
       private int index;
       private int capacity;
       

       public dsChiTietPhieuBUS() {
              this.capacity = 2;
              this.index = 0;
              this.chiTietPhieus = new ChiTietPhieuDTO[capacity];
       }

       public void add(ChiTietPhieuDTO other) {
              if (index + 1 > capacity) {
                     reSizeArray();
              }
              chiTietPhieus[index] = other;
              index++;
       }

       public void remove(String maSP) {
              int flag = -1;
              for (int i = 0; i < index; i++) {
                     if (chiTietPhieus[i].getMaSP().equals(maSP) == true) {
                            flag = i;
                     }
              }
              if (flag == -1) {
                     Sys.printError("Không tìm thấy mã sản phẩm!!");
                     return;
              } else {
                     index--;
                     for (int j = flag; j < index; j++) {
                            chiTietPhieus[j] = chiTietPhieus[j + 1];
                     }
                     Sys.printMessage("Xóa thành công");
                     return;
              }

       }

       public void Sua(String maSP) {
              int flag = -1;
              for (int i = 0; i < index; i++) {
                     if (chiTietPhieus[i].getMaSP().equals(maSP) == true) {
                            flag = i;
                            break;
                     }
              }
              if (flag == -1) {
                     Sys.printError("Không tìm thấy mã sản phẩm!!");
                     return;
              } else {
                     System.out.println(Sys.toGreenText("1.Tên sản phẩm"));
                     System.out.println(Sys.toGreenText("2.Số lượng"));
                     System.out.println(Sys.toGreenText("3.Đơn giá"));
                     System.out.println(Sys.toGreenText("0.Thoát"));
                     int chon = Sys.takeInputChoice(0, 3);
                     switch (chon) {
                            case 1 : {
                                   String nameProduct = Sys.takeStringInput("Nhập tên sản phẩm: ");
                                   chiTietPhieus[flag].setNameProduct(nameProduct);
                                   break;
                            }
                            case 2 : {
                                   int soluong = Sys.takeIntegerInput("Nhập số lượng mới: ");
                                   chiTietPhieus[flag].setSoLuong(soluong);
                                   break;
                            }
                            case 3 : {
                                   int gia = Sys.takeIntegerInput("Nhập giá mới: ");
                                   chiTietPhieus[flag].setDonGia(gia);
                                   break;
                            }
                            case 0 : {
                                   Sys.clearScreen();
                                   break;
                            }
                     }
              }
       }

       // tong tien
       public int Sum_money() {
              int sum = 0;
              for (int i = 0; i < index; i++) {
                     sum += chiTietPhieus[i].getDonGia() * chiTietPhieus[i].getSoLuong();
              }
              return sum;

       }

       public void reSizeArray() {
              this.capacity = this.capacity * 2;
              chiTietPhieus = Arrays.copyOf(chiTietPhieus, capacity);
       }

       public boolean Isemtpy() {
              if (index == 0) {
                     return true;
              }
              return false;
       }

       // public void Show() {
       //        xuatTuaDe();
       //        for (int i = 0; i < index; i++) {
       //               this.chiTietPhieus[i].inChiTietPhieu();
       //        }
       //        chanTuade();

       // }

       public ChiTietPhieuDTO[] getChiTietPhieu2s() {
              return chiTietPhieus;
       }

       public int getIndex() {
              return index;
       }

       // public void xuatTuaDe() {
       //        // // System.out.printf("├%-15s│%-15s│%-15s│%-15s┤\n", Lib.repeatStr("─", 16),
       //        // // Lib.repeatStr("─", 16),
       //        // // Lib.repeatStr("─", 16));
       //        // System.out.printf("│%-10s│%-15s│%-15s│%-15s│%-15s│%-5s│\n",Sys.repeatStr("", 10),"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá",Sys.repeatStr("", 8));
       //        // System.out.printf("│%-10s├%-15s┼%-15s┼%-15s┼%-15s┤%-5s│%n",Sys.repeatStr("", 10),Sys.repeatStr("─", 15), Sys.repeatStr("─", 15),
       //        //               Sys.repeatStr("─", 15), Sys.repeatStr("─", 15),Sys.repeatStr("", 8));

       // }

       // public void chanTuade() {
       //        System.out.format("│%-10s├%-15s┴%-15s┴%-15s┴%-15s┤%-5s│%n",Sys.repeatStr("", 10), Sys.repeatStr("─", 15), Sys.repeatStr("─", 15),
       //                      Sys.repeatStr("─", 15), Sys.repeatStr("─", 15),Sys.repeatStr("", 8));
       //        System.out.printf("│%-10s│%-15s%-15s%-15s%-15s│%-5s│\n",Sys.repeatStr("", 10),Sys.repeatStr(" ", 15),Sys.repeatStr(" ", 15),Sys.repeatStr(" ", 18),"Sum money: " + Sum_money(),Sys.repeatStr("", 8));
       //        System.out.printf("│%-10s└%-60s┘%-5s│\n", Sys.repeatStr("", 10),Sys.repeatStr("─", 63),Sys.repeatStr("", 8));
       // }
}
