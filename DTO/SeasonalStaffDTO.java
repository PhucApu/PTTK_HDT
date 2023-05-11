package DTO;

import java.io.Serializable;


public class SeasonalStaffDTO extends StaffDTO implements Serializable {

    private int hourlyWage;
    private int workHours;

    public SeasonalStaffDTO(){
        super();
    }

    public SeasonalStaffDTO(String id){
        super(id);
    }
    public SeasonalStaffDTO(String id,String cmnd  , String name,String gender, AddressDTO address,String date,String passWord,int hourlyWage,int workHours){
         super(id,cmnd,name,gender,address,date,passWord);
        this.hourlyWage = hourlyWage;
        this.workHours = workHours;
    }
    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
    public void nhap(){
         super.nhap();
         this.hourlyWage = Sys.takeIntegerInput("Nhập lương theo giờ : ");
         this.workHours = Sys.takeIntegerInput("Nhập số giờ làm : ");
    }
    public  void xuat(){
        float luong = tinhLuong();
        System.out.printf("│%-10s│%-14s│%-30s│%-14s│%-50s│%-14s│%-14s│%-14.0f│%-14s│\n",this.id,this.cmnd,this.name,this.gender,this.address.thongtin(),this.date,this.passWord,luong,"Part Time");
    }
    public void xuatChiTiet(){
        System.out.printf("│%-10s│%-14s│%-30s│%-50s│%-14s│%-14s│%-14d│%-14d│%-14s│\n",this.id,this.cmnd,this.name,this.address.thongtin(),this.date,this.passWord,this.hourlyWage,this.workHours,"Full Time");

    }
    public float tinhLuong(){
        return Math.round( workHours*hourlyWage);
    }
}
