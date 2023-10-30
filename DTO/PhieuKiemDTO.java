package DTO;

import java.io.Serializable;

import BUS.dsChiTietPhieuBUS;

public class PhieuKiemDTO extends PhieuDTO implements Serializable {

       private String IDPhieuNhap;
       private String Tinh_trang;
       private String MaNSX;

       public PhieuKiemDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney,
                        String IDNhanVien, String IDPhieuNhap,String MaNSX) {
              super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
              this.IDPhieuNhap = IDPhieuNhap;
              this.Tinh_trang = "Chưa nhập";
              this.MaNSX = MaNSX;
       }
       public PhieuKiemDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney,
                        String IDNhanVien, String IDPhieuNhap,String TinhTrang,String MaNSX) {
              super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
              this.IDPhieuNhap = IDPhieuNhap;
              this.MaNSX = MaNSX;
              this.Tinh_trang = TinhTrang;
       }


       @Override
       public void inPhieu() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'inPhieu'");
       }

       @Override
       public void xemChiTietPhieu() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'xemChiTietPhieu'");
       }
       public String getIDPhieuNhap() {
              return IDPhieuNhap;
       }
       public String getTinh_trang() {
              return Tinh_trang;
       }
       public void setTinh_trang(String tinh_trang) {
              Tinh_trang = tinh_trang;
       }
       public String getMaNSX() {
              return MaNSX;
       }
       
}
