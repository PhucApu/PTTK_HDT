package DTO;

import java.io.Serializable;


public class ManagerDTO extends FullTimeStaffDTO implements Serializable {
    private  int allowance;

    public ManagerDTO(){
        super();
    }
    public ManagerDTO(String id){
        super(id);
    }
    public ManagerDTO(String id,String cmnd,String name,String gender, AddressDTO address,String date,String passWord, int baseSalary, float bonusRate, int workDays, int allowance){
        super(id,cmnd,name,gender,address,date,passWord,baseSalary,bonusRate,workDays);
        this.allowance = allowance;

    }
    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public void nhap(){
        super.nhap();
        this.allowance = Sys.takeIntegerInput("Nhập phụ cấp : ");
    }

    public void xuat(){
        float luong = tinhLuong();
        System.out.printf("│%-10s│%-14s│%-30s│%-14s│%-50s│%-14s│%-14s│%-14.0f│%-14s│\n",this.id,this.cmnd,this.name,this.gender,this.address.thongtin(),this.date,this.passWord,luong,"Manager");
    }
    public void xuatChiTiet(){
        System.out.printf("│%-10s│%-14s│%-30s│%-50s│%-14s│%-14s│%-14.0f│%-14d│%-14d│%-14d│%-14s│\n",this.id,this.cmnd,this.name,this.address.thongtin(),this.date,this.passWord,this.bonusRate,this.baseSalary,this.workDays,this.allowance,"Full Time");
    }
    public float tinhLuong(){
        return super.tinhLuong() + allowance;
    }

}

