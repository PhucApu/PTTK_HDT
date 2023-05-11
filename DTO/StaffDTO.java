package DTO;

import java.io.Serializable;

public abstract class StaffDTO implements Serializable {
    protected String id;
    protected String name;

    protected AddressDTO address = new AddressDTO();

    protected String date ;

    protected String gender;
    protected String cmnd;



    protected String passWord;
    public StaffDTO(){}
    public StaffDTO(String id){
        this.id = id;
    }
    public StaffDTO(String id , String cmnd,String name,String gender,AddressDTO address,String date,String passWord){
        this.id = id;
        this.cmnd = cmnd;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.passWord = passWord;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void nhap(){
        this.cmnd = Sys.takeCMND("Nhập CMND/CCCD: ");
        this.name = Sys.takeStringInput("Nhập họ và tên nhân viên: ");
        this.date = Sys.takeDateInput("Nhập ngày sinh (dd/MM/yyyy): ");
        this.gender = Sys.takeGenderInput("Nhập giới tính: ");
        address.nhap();
        this.passWord = Sys.takeStringInput("Nhập password: ");
    }
    public  void xuat(){
        System.out.printf("%-10s%-30s%-50s\n",this.id,this.name,this.address.thongtin());
    }
    public float tinhLuong(){
        return 0;
    }
}
