package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import DAO.PhieuHuyDAO;
import DTO.ChiTietPhieuDTO;
import DTO.PhieuHuyDTO;
import DTO.PhieuNhapDTO;
import DTO.PhieuXuatDTO;
import DTO.ProductsDTO;
import DTO.StaffDTO;
import DTO.Sys;

public class dsPhieuHuyBUS implements DanhSachBUS, Serializable{
       private ArrayList<PhieuHuyDTO> dsPhieuhuy;
       private int count = 0;
       PhieuHuyDAO temp = new PhieuHuyDAO();

       public dsPhieuHuyBUS(ListProductsBUS list){
              System.out.println("1");
              this.dsPhieuhuy = new ArrayList<>();
              for (ProductsDTO iterable_element : list.getArr()) {
                     String date = iterable_element.getExpiry_date();
                     if(Sys.CheckExpire(date)){
                            dsChiTietPhieuBUS dsChiTietPhieuBUS = new dsChiTietPhieuBUS();
                            ChiTietPhieuDTO chiTietPhieuDTO = new ChiTietPhieuDTO(iterable_element.getNameProduct(), iterable_element.getMaSP(), iterable_element.getSoluong(), iterable_element.getPrice());
                            dsChiTietPhieuBUS.add(chiTietPhieuDTO);
                            PhieuHuyDTO phieuHuyDTO = new PhieuHuyDTO(getID(), Sys.getDateNow(), dsChiTietPhieuBUS, dsChiTietPhieuBUS.Sum_money() , "NV001", "Hết hạn");
                            dsPhieuhuy.add(phieuHuyDTO);
                            themPhieuNhap_database(phieuHuyDTO);
                     
                     }
              }
              System.out.println(dsPhieuhuy);
       

       }

       public dsPhieuHuyBUS(ArrayList<PhieuHuyDTO> listPhieuHuy) {
              
              this.dsPhieuhuy = listPhieuHuy;
              this.count = dsPhieuhuy.size();
       }

       public void setDsPhieunhap(ArrayList<PhieuHuyDTO> dsPhieunhap) {
              this.dsPhieuhuy = dsPhieunhap;
       }
       @Override
       public String getID() {
              count++;
              Integer a = count;
              String str = a.toString();
              while (str.length() != 3)
                     str = "0" + str;
              str = "H" + str;
              return str;
       }
       @Override
       public String getMaSP_Drink() {
              // TODO Auto-generated method stub
              return null;
       }
       @Override
       public String getMaSP_Food() {
              // TODO Auto-generated method stub
              return null;
       }
       @Override
       public void xuatDS() {
              // TODO Auto-generated method stub
              
       }
       @Override
       public void xuatTieuDe() {
              // TODO Auto-generated method stub
              
       }
       public ArrayList<PhieuHuyDTO> getDsPhieuhuy() {
              return dsPhieuhuy;
       }
       public boolean add_2(PhieuHuyDTO phieuNhap) {
              int flag = 0;
              for (PhieuHuyDTO iterable_element : this.dsPhieuhuy) {
                     if (iterable_element.getIDPhieu().equals(phieuNhap.getIDPhieu())) {
                            flag = 1;
                     }
              }
              if (flag == 0) {
                     themPhieuNhap_database(phieuNhap);
                     return true;
              } else {
                     return false;
              }
       }

       public boolean Xoa_2(String idPhieu){
              for (PhieuHuyDTO phieunhap : dsPhieuhuy) {
                     if (phieunhap.getIDPhieu().equals(idPhieu)) {
                            dsPhieuhuy.remove(phieunhap);
                            xoaPhieuNhap_database(idPhieu);
                            return true;
                     }
              }
              return false;
       }

       public ArrayList<PhieuHuyDTO> TimkiemtheoKey_2(String tuKhoa){
              int tongTien = 0;
              ArrayList<PhieuHuyDTO> phieu = new ArrayList<>();
              // int index = 0;
              for (PhieuHuyDTO phieunhap : dsPhieuhuy) {
                     try {
                            tongTien = Integer.parseInt(tuKhoa);
                     } catch (NumberFormatException e) {
                            tongTien = -1;
                     }
                     dsChiTietPhieuBUS dsctp = phieunhap.getDsChitietphieu2();
                     ChiTietPhieuDTO[] temp = dsctp.getChiTietPhieu2s();
                     int i = dsctp.getIndex();
                     for (int j = 0; j < i; j++) {
                            if (phieunhap.getDate().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieunhap.getIDNhanVien().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieunhap.getIDPhieu().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieunhap.getLyDoHuy().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieunhap.getSumMoney() == tongTien
                                          || temp[j].getNameProduct().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getMaSP().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getDonGia() == tongTien || temp[j].getSoLuong() == tongTien) {
                                   phieu.add(phieunhap);
                            }
                     }
              }
              return phieu;
       }
       public boolean XacnhanXuatko_2(StaffDTO nv, ListProductsBUS kho, String id){
              if(dsPhieuhuy.isEmpty()){
                     return false;
              }
              else{
                     // int flag = -1;
                     for (PhieuHuyDTO phieuXuat : dsPhieuhuy){
                            if (phieuXuat.getIDPhieu().equals(id)) {
                                   System.out.println(phieuXuat.getTinhTrang());
                                   if (phieuXuat.getTinhTrang().equals("Đã xác nhận") == false) {
                                          // Sys.printMessage("Đã xác nhận xuất thành công");
                                          phieuXuat.setTinhTrang("Đã xác nhận");
                                          ChiTietPhieuDTO[] temp = phieuXuat.getDsChitietphieu2().getChiTietPhieu2s();
                                          int index = phieuXuat.getDsChitietphieu2().getIndex();
                                          kho.xuatkho(temp, index);
                                          if(updatePhieuNhap_database(phieuXuat)){
                                                 return true;
                                          }
                                          
                                   } else {
                                          Sys.printError("Phiếu này đã xác nhận rồi !!");
                                          return false;
                                   }
                            }
                     }
                     return false;
              }
       }


       
       public boolean Suachitiet_2(PhieuHuyDTO phieuNhap){
              if(updatePhieuNhap_database(phieuNhap)){
                     return true;
              }
              return false;
       }

       public PhieuHuyDTO getPhieuNhap_database(String id) {
              PhieuHuyDTO phieuNhap = null;
              try {
                     phieuNhap = temp.get(id);
                     return phieuNhap;
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return phieuNhap;
       }

       public boolean themPhieuNhap_database(PhieuHuyDTO phieuNhap) {
              try {
                     if (temp.save(phieuNhap)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       public boolean xoaPhieuNhap_database(String id) {
              try {
                     if (temp.deleteById(id)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       public boolean updatePhieuNhap_database(PhieuHuyDTO phieuNhap) {
              try {
                     if (temp.update(phieuNhap)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       

}
