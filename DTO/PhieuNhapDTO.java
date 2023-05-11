package DTO;

import java.io.Serializable;
import BUS.*;
public class PhieuNhapDTO extends PhieuDTO implements Serializable {
       private String MaNXS;
       private String Tinh_trang;

       public PhieuNhapDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney,
                        String IDNhanVien, String MaNSX) {
              super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
              this.MaNXS = MaNSX;
              this.Tinh_trang = "Chưa nhập";
       }
       public PhieuNhapDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChiTietPhieu, int sumMoney,
                        String IDNhanVien, String MaNSX,String TinhTrang) {
              super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
              this.MaNXS = MaNSX;
              this.Tinh_trang = TinhTrang;
       }

       @Override
       public void xemChiTietPhieu() {

              // dsChitietphieu2.Show();

       }

       // public void Themchitietphieu()
       // {
       // dsChitietphieu2.Nhap();
       // System.out.println(dsChitietphieu2.Show());
       // }
       @Override
       public void inPhieu() {
              // System.out.printf("│%-10s┌%-60s┐%-5s│\n", Sys.repeatStr("", 10), Sys.repeatStr("─", 63),
              //         Sys.repeatStr("", 8));
              // System.out.printf("│%-10s│%-20s%-19s%-18s│%-5s│\n", Sys.repeatStr("", 10),
              //         "Chi tiết phiếu nhập " + getIDPhieu(), Sys.repeatStr("", 5),
              //         "Tinh trang:" + getTinh_trang(), Sys.repeatStr("", 10));
              // System.out.printf("│%-10s├%-60s┤%-5s│\n", Sys.repeatStr("", 10), Sys.repeatStr("─", 63),
              //         Sys.repeatStr("", 8));
              // System.out.printf("│%-10s│%-20s%-20s%-20s│%-5s│\n", Sys.repeatStr("", 10),
              //         "ID nhân viên:" + getIDNhanVien() + Sys.repeatStr(" ", 3), "Date:" + getDate(),
              //         "ID Nhà cung cấp:" + getMaNXS(), Sys.repeatStr("", 8));
              // System.out.printf("│%-10s├%-15s┬%-15s┬%-15s┬%-15s┤%-5s│\n", Sys.repeatStr("", 10), Sys.repeatStr("─", 15),
              //         Sys.repeatStr("─", 15), Sys.repeatStr("─", 15), Sys.repeatStr("─", 15),
              //         Sys.repeatStr("", 8));
              // dsChitietphieu.Show();
       }

       public void Sua_chitiet(String maSP) {
              dsChitietphieu.remove(maSP);
       }

       // public ChiTietPhieu2[] laymangchitietphieu()
       // {
       // return dsChitietphieu2.getChiTietPhieu2s();
       // }
       // public int index_chitietphieu()
       // {
       // return dsChitietphieu2.getIndex();
       // }
       public String getMaNXS() {
              return MaNXS;
       }

       public void setMaNXS(String maNXS) {
              MaNXS = maNXS;
       }

       public void setTinh_trang(String tinh_trang) {
              Tinh_trang = tinh_trang;
       }
       // Tinh_trang = "da nhap  ";

       public String getTinh_trang() {
              return Tinh_trang;
       }

       public static void main(String[] args) {

       }

}