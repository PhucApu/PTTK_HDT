package DTO;

import java.io.Serializable;

public class SupplierDTO implements Serializable {
   private String name;
   private AddressDTO address;
   private String sdt;
   private String email;
   private String ma;

    public SupplierDTO(String name, AddressDTO address, String sdt, String email, String ma) {
        this.name = name;
        this.address = address;
        this.sdt = sdt;
        this.email = email;
        this.ma = ma;
    }
    public SupplierDTO(){

    }

    public void xuatThongTin(){
        System.out.printf("│%-20s│%-20s│%-50s│%-20s│%-20s│ \n", ma, name, address.thongtin(), sdt, email);
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
   
}
