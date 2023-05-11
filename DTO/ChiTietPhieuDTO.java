package DTO;

import java.io.Serializable;

public class ChiTietPhieuDTO implements Serializable {
    private String nameProduct;
    private String MaSP; // ma san pham
    private int soLuong; // so luong san pham
    private int donGia; // don gia tung sp
    public ChiTietPhieuDTO(String nameProdct,String MaSP, int soLuong, int donGia) {
        setMaSP(MaSP);
        setSoLuong(soLuong);
        setDonGia(donGia);
        setNameProduct(nameProdct);
    }

    // ┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
    public void inChiTietPhieu() {
        System.out.printf("│%-10s│%-15s│%-15s│%-15s│%-15s│%-5s│\n",Sys.repeatStr("", 10), MaSP,nameProduct, soLuong, donGia,Sys.repeatStr("", 8));
    }

    public String toString() {
        return "Masp: "+MaSP + "-"+"SL:" + soLuong + "-"+"Don gia: " + donGia+"\n";
    }
    public void setNameProduct(String nameProduct) {
           this.nameProduct = nameProduct;
    }
    public String getNameProduct() {
           return nameProduct;
    }
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
