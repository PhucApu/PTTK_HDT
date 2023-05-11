package DTO;

public class FoodDTO extends ProductsDTO{
       private boolean vegetarian;
       private boolean Frozenfood;
       //private static int soluongcuthe=0;
   
       public FoodDTO(){}
       public FoodDTO(String nameFood,boolean vegetarian, boolean Frozenfood, int price, String expiry_date, String maSP, String maNCC,int soluong,float taxes) {
           super(nameFood, price, expiry_date, taxes, maSP, maNCC, soluong);
           this.vegetarian = vegetarian;
           this.Frozenfood = Frozenfood;
           // soluongcuthe+=soluong;
           //this.NameFood = nameFood;
       }
       public boolean isVegetarian() {
           return vegetarian;
       }
       public void setVegetarian(boolean vegetarian) {
           this.vegetarian = vegetarian;
       }
       public boolean isFrozenfood() {
           return Frozenfood;
       }
       public void setFrozenfood(boolean Frozenfood) {
           this.Frozenfood = Frozenfood;
       }
       
   
       // public static int getSoluongcuthe() {
       //     return soluongcuthe;
       // }
   
       // public static void setSoluongcuthe(int soluongcuthe) {
       //     Food.soluongcuthe = soluongcuthe;
       // }
       public void xuatThongTin(){
           super.xuatThongTin();
           System.out.format("│%-15s│%-15s│%n",vegetarian,Frozenfood);
       }
   
   
       @Override
       public String toString() {
           return "Food{" + super.toString()+ "vegetarian=" + isVegetarian() + ", Frozenfood=" + isFrozenfood() + super.toString()+ "}\n";
       }
   
   }
