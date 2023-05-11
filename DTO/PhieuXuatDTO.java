package DTO;

import java.io.Serializable;
import BUS.*;

public class PhieuXuatDTO extends PhieuDTO implements Serializable {
       // private String IDNhanVFullTime;
       private String IDHoaDon;
       private String tinhTrang ;

       public PhieuXuatDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChitietphieu, int sumMoney, String IDNhanVien,
                        String iDHoaDon) {
              super(IDPhieu, date, dsChitietphieu, sumMoney, IDNhanVien);
              IDHoaDon = iDHoaDon;
              tinhTrang =  "CHƯA XUẤT";
       }
       public PhieuXuatDTO(String IDPhieu, String date, dsChiTietPhieuBUS dsChitietphieu, int sumMoney, String IDNhanVien,
                        String iDHoaDon,String TinhTrang) {
              super(IDPhieu, date, dsChitietphieu, sumMoney, IDNhanVien);
              IDHoaDon = iDHoaDon;
              this.tinhTrang = TinhTrang;
       }

       @Override
       public void inPhieu() {
              // System.out.printf("│%-10s┌%-60s┐%-5s│\n", Sys.repeatStr("", 10), Sys.repeatStr("─", 63),
              //         Sys.repeatStr("", 8));
              // System.out.printf("│%-10s│%-20s%-20s%-19s│%-5s│\n", Sys.repeatStr(" ", 10),
              //         "Chi tiết phiếu xuất " + getIDPhieu(),Sys.repeatStr("", 10), "Hoa Don: "+getIDHoaDon(),Sys.repeatStr(" ", 5));
              // System.out.printf("│%-10s├%-60s┤%-5s│\n", Sys.repeatStr("", 10), Sys.repeatStr("─", 63),
              //         Sys.repeatStr("", 8));
              // System.out.printf("│%-10s│%-20s%-20s%-23s│%-5s│\n", Sys.repeatStr("", 10),
              //         "ID nhân viên:" + getIDNhanVien() + Sys.repeatStr(" ", 2), "Date:" + getDate(),
              //         "Tình trạng:" + getTinhTrang(), Sys.repeatStr("", 8));
              // System.out.printf("│%-10s├%-15s┬%-15s┬%-15s┬%-15s┤%-5s│\n", Sys.repeatStr("", 10), Sys.repeatStr("─", 15),
              //         Sys.repeatStr("─", 15), Sys.repeatStr("─", 15), Sys.repeatStr("─", 15),
              //         Sys.repeatStr("", 8));
              // dsChitietphieu.Show();

       }

       @Override
       public void xemChiTietPhieu() {
              // TODO Auto-generated method stub

       }

       // public String getIDNhanVienThuKho() {
       // return IDNhanVienThuKho;
       // }
       public String getIDHoaDon() {
              return IDHoaDon;
       }
       @Override
       public String getIDPhieu() {
              // TODO Auto-generated method stub
              return super.getIDPhieu();
       }

       public String getTinhTrang() {
              return tinhTrang;
       }

       public void setTinhTrang(String tinhTrang) {
              this.tinhTrang = tinhTrang;
       }


}