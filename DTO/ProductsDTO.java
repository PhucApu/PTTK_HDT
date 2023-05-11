package DTO;

import java.io.Serializable;

public abstract class ProductsDTO implements Serializable {
    protected int price;
    protected String expiry_date;
    protected float taxes;
    protected String maSP;
    protected String maNCC;
    private String nameProduct;
    private int soluong;
    private int sl_conlai;

    public ProductsDTO(){}
    public ProductsDTO(String nameProduct,int price, String expiry_date, float taxes,String maSP, String maNCC, int soluong) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.expiry_date = expiry_date;
        this.taxes = taxes;
        this.maSP = maSP;
        this.maNCC= maNCC;
        this.soluong = soluong;
        this.sl_conlai = soluong;
        setSl_conlai(soluong);
    }

    public int getPrice() {
        return price;
    }
    public int getSl_conlai() {
           return sl_conlai;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getExpiry_date() {
        return expiry_date;
    }
    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
    public double getTaxes() {
        return taxes;
    }
    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }
    public String getMaSP() {
        return maSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public void setSl_conlai(int sl_conlai) {
           this.sl_conlai = sl_conlai;
    }
    public boolean sell(int soluong){
        if(getSl_conlai() < soluong) return false;
        else{
            // this.sl_conlai = sl_conlai - soluong;
            setSl_conlai(getSl_conlai()-soluong);
            // setSoluong(this.soluong - soluong);
            return true;
        }
        
        
    }

    public void xuatThongTin(){
        System.out.format("│%-15s│%-15s│%-15s│%-15s│%-15s│%-15s│%-15s",maSP,nameProduct,maNCC,expiry_date,taxes,price,soluong);
    }

    @Override
    public String toString() {
        return "name: "+getNameProduct()+" price=" + price + ", expiry_date=" + expiry_date + ", taxes=" + taxes + ", maSP=" + maSP + ", maNCC=" + maNCC +"so luong" + getSoluong();
    }

}
