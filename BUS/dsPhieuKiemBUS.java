package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import DAO.PhieuKiemDAO;
import DTO.ChiTietPhieuDTO;
import DTO.PhieuKiemDTO;
import DTO.PhieuNhapDTO;

public class dsPhieuKiemBUS implements DanhSachBUS,Serializable {

       private ArrayList<PhieuKiemDTO> dsPhieukiem;
       private int count = 0;
       PhieuKiemDAO temp = new PhieuKiemDAO();

       public dsPhieuKiemBUS(){
              this.dsPhieukiem = new ArrayList<>();
       }
       public dsPhieuKiemBUS(ArrayList<PhieuKiemDTO> list){
              this.dsPhieukiem = list;
              this.count = list.size();
       }

       public void initData(ArrayList<PhieuNhapDTO> list_PN){
              for (PhieuNhapDTO iterable_element : list_PN) {
                     if(iterable_element.getTinh_trang().equals("Đã gửi")){
                            String ID_PhieuKiem = transfer_IDPN_to_IDPK(iterable_element.getIDPhieu());
                            String date = iterable_element.getDate();
                            String ID_NV = iterable_element.getIDNhanVien();
                            dsChiTietPhieuBUS dsChiTietPhieuBUS = iterable_element.getDsChitietphieu2();
                            int sumMoney = iterable_element.getSumMoney();
                            String ID_PhieuNhap = iterable_element.getIDPhieu();
                            String TinhTrang = "Đã nhập";
                            PhieuKiemDTO phieuKiemDTO = new PhieuKiemDTO(ID_PhieuKiem, date, dsChiTietPhieuBUS, sumMoney, ID_NV, ID_PhieuNhap, TinhTrang,iterable_element.getMaNXS());
                            dsPhieukiem.add(phieuKiemDTO);
                            themPhieuKiem_database(phieuKiemDTO);
                     }
              }
       }
       public ArrayList<PhieuKiemDTO> getDsPhieukiem() {
              return dsPhieukiem;
       }

       public String transfer_IDPN_to_IDPK(String ID_PhieuNhap){
              String ID_PhieuKiem = ID_PhieuNhap.replace('N', 'K');
              return ID_PhieuKiem;
       }
       public void setDsPhieukiem(ArrayList<PhieuKiemDTO> dsPhieukiem) {
              this.dsPhieukiem = dsPhieukiem;
       }
       public int sumMoneyDS() {
              int sum = 0;
              for (PhieuKiemDTO phieu : dsPhieukiem) {
                     sum += phieu.getSumMoney();
              }
              return sum;
       }

       public boolean Capnhatvaokho_2(String maPhieu, ListProductsBUS kho) {
              for (PhieuKiemDTO phieuKiem : this.dsPhieukiem) {
                     if (phieuKiem.getIDPhieu().equals(maPhieu)) {
                            if (phieuKiem.getTinh_trang().equals("Chưa nhập")) {
                                   phieuKiem.setTinh_trang("đã nhập");
                                   ChiTietPhieuDTO[] temp = phieuKiem.getDsChitietphieu2().getChiTietPhieu2s();
                                   int index = phieuKiem.getDsChitietphieu2().getIndex();
                                   String maNCC = phieuKiem.getMaNSX();
                                   String day = phieuKiem.getDate();
                                   kho.nhapvaokho(temp, index, maNCC, day);
                                   updatePhieuKiem_database(phieuKiem);
                                   return true;
                            }
                            else {
                                   return false;
                            }

                     }
              }
              return false;
       }

       public boolean Xoa_2(String idPhieu) {
              for (PhieuKiemDTO phieukiem : dsPhieukiem) {
                     if (phieukiem.getIDPhieu().equals(idPhieu) && phieukiem.getTinh_trang().equals("Chưa nhập")) {
                            dsPhieukiem.remove(phieukiem);
                            xoaPhieuKiem_database(idPhieu);
                            return true;
                     }
              }
              return false;
       }

       public ArrayList<PhieuKiemDTO> TimkiemtheoKey_2(String tuKhoa) {
              int tongTien = 0;
              ArrayList<PhieuKiemDTO> phieu = new ArrayList<>();
              // int index = 0;
              for (PhieuKiemDTO phieukiem : dsPhieukiem) {
                     try {
                            tongTien = Integer.parseInt(tuKhoa);
                     } catch (NumberFormatException e) {
                            tongTien = -1;
                     }
                     dsChiTietPhieuBUS dsctp = phieukiem.getDsChitietphieu2();
                     ChiTietPhieuDTO[] temp = dsctp.getChiTietPhieu2s();
                     int i = dsctp.getIndex();
                     for (int j = 0; j < i; j++) {
                            if (phieukiem.getDate().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieukiem.getIDNhanVien().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieukiem.getIDPhieu().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieukiem.getMaNSX().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieukiem.getSumMoney() == tongTien ||
                                          phieukiem.getTinh_trang().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getNameProduct().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getMaSP().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          || temp[j].getDonGia() == tongTien || temp[j].getSoLuong() == tongTien) {
                                   phieu.add(phieukiem);
                            }
                     }
              }
              return phieu;
       }

       


       public PhieuKiemDTO getPhieuKiem_database(String id) {
              PhieuKiemDTO phieuKiem = null;
              try {
                     phieuKiem = temp.get(id);
                     return phieuKiem;
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return phieuKiem;
       }

       public boolean themPhieuKiem_database(PhieuKiemDTO phieuKiem) {
              try {
                     if (temp.save(phieuKiem)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       public boolean xoaPhieuKiem_database(String id) {
              try {
                     if (temp.deleteById(id)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       public boolean updatePhieuKiem_database(PhieuKiemDTO phieuKiem) {
              try {
                     if (temp.update(phieuKiem)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }
       @Override
       public String getID() {
              // TODO Auto-generated method stub
              return null;
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
       
}
