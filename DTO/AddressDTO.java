package DTO;

import java.io.Serializable;


public class AddressDTO implements Serializable {
    private String city;
    private String district;
    private String street;

    public AddressDTO(){
        this.city = "?";
        this.district="?";
        this.street="?";
    }
    public AddressDTO(String city,String district,String street){

        this.city = city;
        this.district = district;
        this.street = street;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public void nhap(){
        this.city =  Sys.takeStringInput("Tỉnh/Thành phố : ");
        this.district = Sys.takeStringInput("Quận/Huyện : ");
        this.street = Sys.takeStringInput("Đường : ");
    }
    public String thongtin(){
         return this.city+" "+this.district+" "+this.street;
    }
}