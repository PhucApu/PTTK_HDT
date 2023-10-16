package DTO;

import BUS.dsChiTietPhieuBUS;

public class PhieuHuyDTO extends PhieuDTO{
       private String LyDoHuy;
       private String tinhTrang;
       public PhieuHuyDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney,
       String IDNhanVien, String LyDoHuy, String tinhTrang){
              super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
              this.LyDoHuy = LyDoHuy;
              this.tinhTrang = tinhTrang;
       }

       public PhieuHuyDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney,
       String IDNhanVien, String LyDoHuy){
              super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
              this.LyDoHuy = LyDoHuy;
              this.tinhTrang = "Chưa xác nhận";
       }
       public String getTinhTrang() {
              return tinhTrang;
       }
       public void setTinhTrang(String tinhTrang) {
              this.tinhTrang = tinhTrang;
       }
       @Override
       public void inPhieu() {
              // TODO Auto-generated method stub
              
       }
       @Override
       public void xemChiTietPhieu() {
              // TODO Auto-generated method stub
              
       }
       @Override
       public dsChiTietPhieuBUS getDsChitietphieu2() {
              // TODO Auto-generated method stub
              return super.getDsChitietphieu2();
       }
       @Override
       public String getIDPhieu() {
              // TODO Auto-generated method stub
              return super.getIDPhieu();
       }

       public String getLyDoHuy() {
              return LyDoHuy;
       }

       public void setLyDoHuy(String lyDoHuy) {
              LyDoHuy = lyDoHuy;
       }
       @Override
       public String toString() {
              return this.IDPhieu;
       }
}