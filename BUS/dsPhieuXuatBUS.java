package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import DAO.*;
import DTO.*;
public class dsPhieuXuatBUS implements DanhSachBUS, Serializable {
       private ArrayList<PhieuXuatDTO> dsPhieuxuat;
       private int count = 0;
       PhieuXuatDAO temp = new PhieuXuatDAO();

       public dsPhieuXuatBUS(ArrayList <PhieuXuatDTO> list){
              this.dsPhieuxuat = list;
              this.count = list.size();
       }
       public dsPhieuXuatBUS(ListProductsBUS listProducts, DanhSachHDBUS danhSachHD) {
              this.dsPhieuxuat = new ArrayList<>();
              for (HoaDonDTO hoaDon : danhSachHD.getHoaDonArrayList()) {
                     if (hoaDon.getTinhTrang().equals("Đã bán")) {
                            dsChiTietPhieuBUS dsChiTietPhieu = new dsChiTietPhieuBUS();
                            for (ChiTietHDDTO chiTietHD : hoaDon.getDsCTHD().getCthd()) {
                                   ProductsDTO products = listProducts.timkiemsp(chiTietHD.getMaSP());
                                   ChiTietPhieuDTO chiTietPhieu = new ChiTietPhieuDTO(products.getNameProduct(),
                                                 chiTietHD.getMaSP(), chiTietHD.getSoluong(), chiTietHD.gia);
                                   dsChiTietPhieu.add(chiTietPhieu);
                            }
                            String idPhieuXuat = getMaSP_Drink();
                            String idHoaDon = hoaDon.getMahd();
                            PhieuXuatDTO phieuXuat = new PhieuXuatDTO(idPhieuXuat, hoaDon.getTimexuat(), dsChiTietPhieu,
                                          dsChiTietPhieu.Sum_money(), hoaDon.getManv(), idHoaDon);
                            phieuXuat.setTinhTrang("Đã xuất kho");
                            this.dsPhieuxuat.add(phieuXuat);
                            themPhieuXuat_database(phieuXuat);
                     }
              }

       }



       @Override
       public String getID() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'getID'");
       }

       @Override
       public void xuatTieuDe() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'xuatTieuDe'");
       }

       @Override
       public void xuatDS() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'xuatDS'");
       }

       @Override
       public String getMaSP_Food() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'getMaSP_Food'");
       }

       @Override
       public String getMaSP_Drink() {
              count++;
              Integer a = count;
              String str = a.toString();
              while (str.length() != 3)
                     str = "0" + str;
              str = "X" + str;
              return str;
       }
       public void setDsPhieuxuat(ArrayList<PhieuXuatDTO> dsPhieuxuat) {
              this.dsPhieuxuat = dsPhieuxuat;
       }
       public void setCount(int count) {
              this.count = count;
       }
       public int sumMoneyDS() {
              int Tong = 0;
              for (PhieuXuatDTO phieuxuat : dsPhieuxuat) {
                     Tong += phieuxuat.getSumMoney();
              }
              return Tong;
       }
       public ArrayList<PhieuXuatDTO> TimkiemtheoKey_2( String tuKhoa){
              int tongTien = 0;
              ArrayList<PhieuXuatDTO> phieu = new ArrayList<PhieuXuatDTO>();
              try {
                     tongTien = Integer.parseInt(tuKhoa);
              } catch (NumberFormatException e) {
                     tongTien = -1;
              }
              for (PhieuXuatDTO phieuXuat : this.dsPhieuxuat) {
                     dsChiTietPhieuBUS dsctp = phieuXuat.getDsChitietphieu2();
                     ChiTietPhieuDTO[] temp = dsctp.getChiTietPhieu2s();
                     int i = dsctp.getIndex();
                     for (int j = 0; j < i; j++) {
                            if (phieuXuat.getDate().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieuXuat.getIDNhanVien().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieuXuat.getIDPhieu().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieuXuat.getTinhTrang().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieuXuat.getSumMoney() == tongTien
                                          || temp[j].getNameProduct().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getMaSP().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getDonGia() == tongTien || temp[j].getSoLuong() == tongTien) {
                                   phieu.add(phieuXuat);
                            }
                     }
              }
              
              return phieu;
       }

       public void add(HoaDonDTO hoadon, ListProductsBUS kho) {
              dsChiTietPhieuBUS dsChitietphieu2 = new dsChiTietPhieuBUS();
              DanhSachCTHDBUS dSachCTHD = hoadon.getDsCTHD();
              for (ChiTietHDDTO chiTietHD : dSachCTHD.getCthd()) {
                     String maSP = chiTietHD.getMaSP();
                     String nameProduct = "";
                     for (ProductsDTO products : kho.getArr()) {
                            if (products.getMaSP().equals(maSP)) {
                                   nameProduct = products.getNameProduct();
                                   break;
                            }
                     }
                     ChiTietPhieuDTO moi = new ChiTietPhieuDTO(nameProduct, maSP, chiTietHD.getSoluong(),
                                   chiTietHD.getGia());
                     dsChitietphieu2.add(moi);

              }
              String maPhieu = getMaSP_Drink();
              PhieuXuatDTO moi = new PhieuXuatDTO(maPhieu, hoadon.getTimexuat(), dsChitietphieu2,
              dsChitietphieu2.Sum_money(), hoadon.getManv(), hoadon.getMahd());
              dsPhieuxuat.add(moi);
              themPhieuXuat_database(moi);
       }

       public boolean XacnhanXuatko_2(StaffDTO nv, ListProductsBUS kho, String id){
              if(dsPhieuxuat.isEmpty()){
                     return false;
              }
              else{
                     // int flag = -1;
                     for (PhieuXuatDTO phieuXuat : dsPhieuxuat){
                            if (phieuXuat.getIDPhieu().equals(id)) {
                                   System.out.println(phieuXuat.getTinhTrang());
                                   if (phieuXuat.getTinhTrang().equals("Đã xuất kho") == false) {
                                          // Sys.printMessage("Đã xác nhận xuất thành công");
                                          phieuXuat.setTinhTrang("Đã xuất kho");
                                          ChiTietPhieuDTO[] temp = phieuXuat.getDsChitietphieu2().getChiTietPhieu2s();
                                          int index = phieuXuat.getDsChitietphieu2().getIndex();
                                          kho.xuatkho(temp, index);
                                          if(updatePhieuXuat_database(phieuXuat)){
                                                 return true;
                                          }
                                          
                                   } else {
                                          Sys.printError("Phiếu này đã xuất kho rồi !!");
                                          return false;
                                   }
                            }
                     }
                     return false;
              }
       }

       public boolean Xoa_2(String id) {
              
              for (PhieuXuatDTO phieuXuat : dsPhieuxuat) {
                     if (phieuXuat.getIDPhieu().equals(id)) {
                            if(phieuXuat.getTinhTrang().equals("Đã xuất kho")){
                                   return false;
                            }
                            else{
                                   if (xoaPhieuXuat_database(id)) {
                                          // Sys.printMessage("Đã xóa thành công");
                                          this.dsPhieuxuat.remove(phieuXuat);
                                          return true;
                                   
                                   }
                                   else{
                                          // Sys.printError("Không xóa phiếu xuất này !!");
                                          return false;
                                   }
                            }
                     }
              }
              return false;
       }
       public ArrayList<PhieuXuatDTO> getDsPhieuxuat() {
              return dsPhieuxuat;
       }

       public int getCount() {
              return count;
       }

       public PhieuXuatDTO getPhieuXuat_database(String id) {
              PhieuXuatDTO phieuXuat = null;
              try {
                     phieuXuat = temp.get(id);
                     return phieuXuat;
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return phieuXuat;
       }

       private void themPhieuXuat_database(PhieuXuatDTO phieuXuat) {
              try {
                     temp.save(phieuXuat);
              } catch (Exception e) {
                     e.printStackTrace();
              }
       }

       private boolean xoaPhieuXuat_database(String id) {
              try {
                     if (temp.deleteById(id)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       private boolean updatePhieuXuat_database(PhieuXuatDTO phieuXuat) {
              try {
                     if(temp.update(phieuXuat)){
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }


}
