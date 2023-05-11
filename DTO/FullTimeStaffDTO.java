package DTO;

import java.io.Serializable;


public class FullTimeStaffDTO extends StaffDTO implements Serializable {
        protected int baseSalary;
        protected float bonusRate;
        protected  int workDays;
        public FullTimeStaffDTO(){
            super();
        }

        public FullTimeStaffDTO(String id ){
            super(id);
        }
        public FullTimeStaffDTO(String id ,String cmnd , String name,String gender, AddressDTO address,String date,String passWord ,int baseSalary, float bonusRate, int workDays){
            super(id,cmnd,name,gender,address,date,passWord);
            this.baseSalary = baseSalary;
            this.bonusRate = bonusRate;
            this.workDays = workDays;
        }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public float getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(float bonusRate) {
        this.bonusRate = bonusRate;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }
    public void nhap(){
            super.nhap();
            baseSalary = Sys.takeIntegerInput("Lương cơ bản : ");
            bonusRate = Sys.takeFloatInput("Hệ số lương : ");
            workDays = Sys.takeIntegerInput("Số ngày làm việc : ");
    }

    public float tinhLuong(){
            int bounusMoney = 0;
            if ( this.workDays > 21 )
            {
                bounusMoney = (this.workDays -21 )*100000;
            }
            return Math.round(baseSalary*bonusRate + bounusMoney);
    }
    public  void xuat(){
            float luong = tinhLuong();
        System.out.printf("│%-10s│%-14s│%-30s│%-14s│%-50s│%-14s│%-14s│%-14.0f│%-14s│\n",this.id,this.cmnd,this.name,this.gender,this.address.thongtin(),this.date,this.passWord,luong,"Full Time");
    }
    public void xuatChiTiet(){
        System.out.printf("│%-10s│%-14s│%-30s│%-50s│%-14s│%-14s│%-14.0f│%-14d│%-14d│%-14s│\n",this.id,this.cmnd,this.name,this.address.thongtin(),this.date,this.passWord,this.bonusRate,this.baseSalary,this.workDays,"Full Time");
    }
}

