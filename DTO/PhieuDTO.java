package DTO;

import java.io.Serializable;
import BUS.*;
public abstract class PhieuDTO implements Serializable {
       protected String IDPhieu;
       protected String date;
       protected String IDNhanVien; // id nhan vien
       protected dsChiTietPhieuBUS dsChitietphieu;
       protected int sumMoney; // tong tien

    public PhieuDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney, String IDNhanVien){
        setIDPhieu(IDPhieu);
        setDate(date);
        this.dsChitietphieu = dsChiTietPhieu;
        this.sumMoney = sumMoney;
        this.IDNhanVien = IDNhanVien;
    }

       public abstract void inPhieu(); // phieu nhap va xuat se trien khia

       public abstract void xemChiTietPhieu(); // phieu nhap va xuat se trien khia

       
       public ChiTietPhieuDTO[] laymangchitietphieu()
       {
              return dsChitietphieu.getChiTietPhieu2s();
       }
       public int index_chitietphieu()
       {
              return dsChitietphieu.getIndex();
       }
       
       public String getIDPhieu() {
              return IDPhieu;
       }

       public void setIDPhieu(String IDPhieu) {
              this.IDPhieu = IDPhieu;
       }

       public String getDate() {
              return date;
       }

       public void setDate(String date) {
              this.date = date;
       }

       public int getSumMoney() {
              return sumMoney;
       }

       public void setSumMoney(int sumMoney) {
              this.sumMoney = sumMoney;
       }

       

       public String getIDNhanVien() {
              return IDNhanVien;
       }

       public void setIDNhanVien(String IDNhanVien) {
              this.IDNhanVien = IDNhanVien;
       }

       public dsChiTietPhieuBUS getDsChitietphieu2() {
              return dsChitietphieu;
       }

       public void setDsChitietphieu(dsChiTietPhieuBUS dsChitietphieu) {
              this.dsChitietphieu = dsChitietphieu;
       }
}
