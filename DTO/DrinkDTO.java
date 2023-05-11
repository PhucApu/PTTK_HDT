package DTO;

public class DrinkDTO extends ProductsDTO{
       private boolean alcoholic;
       //private static int soluongcuthe=0;
       // private String nameDrink;
       public DrinkDTO(){}
       public DrinkDTO(String nameDrink,boolean alcoholic, int price, String expiry_date, float taxes, String maSP,String maNCC, int soluong) {
           super(nameDrink,price, expiry_date, taxes, maSP, maNCC, soluong);
           this.alcoholic = alcoholic;
           // soluongcuthe+=soluong;
       }
       public boolean isAlcoholic() {
           return alcoholic;
       }
       public void setAlcoholic(boolean alcoholic) {
           this.alcoholic = alcoholic;
       }
   
       public void xuatThongTin(){
           super.xuatThongTin();
           System.out.format("│%-15s│%n",alcoholic);
       }
   
       @Override
       public String toString() {
           return "Drink{" +super.toString()+ "alcoholic=" + isAlcoholic() + '}';
       }
   
   
   }
