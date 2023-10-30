package BUS;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import DTO.*;
import DAO.*;

public class dsPhieuNhapBUS implements DanhSachBUS, Serializable {
       private ArrayList<PhieuNhapDTO> dsPhieunhap;
       private int count = 0;
       PhieuNhapDAO temp = new PhieuNhapDAO();
       PhieuKiemDAO temp2 = new PhieuKiemDAO();

       public dsPhieuNhapBUS() {
              this.dsPhieunhap = new ArrayList<PhieuNhapDTO>();
              // ListProducts kho = new ListProducts();
              // // Products a = kho.getArr().get(0);
              // // Products b = kho.getArr().get(1);
              // // // Products c = kho.getArr().get(2);
              // Products a = new Food("Gà Rán", false, false, 10, "2022",kho.getMaSP_Food() ,
              // "NCC001", 10, 5);

              // dsChiTietPhieu temp1 = new dsChiTietPhieu();
              // temp1.add(new ChiTietPhieu(a.getNameProduct(), a.getMaSP(), a.getSoluong(),
              // a.getPrice()));
              // PhieuNhap o = new PhieuNhap(getMaSP_Drink(),"2022", temp1, temp1.Sum_money(),
              // "NV002", "NCC001");
              // dsPhieunhap.add(o);
              // themPhieuNhap_database(o);
              // dsPhieunhap.add(
              // new PhieuNhap(getMaSP_Drink(), "12/10/2002", temp1, temp1.Sum_money(),
              // "NV001", "NCC001"));

              // dsChiTietPhieu temp2 = new dsChiTietPhieu();
              // temp2.add(new ChiTietPhieu(b.getNameProduct(), b.getMaSP(), b.getSoluong(),
              // b.getPrice()));
              // dsPhieunhap.add(
              // new PhieuNhap(getMaSP_Drink(), "12/10/2002", temp2, temp2.Sum_money(),
              // "NV002", "NCC001"));

       }

       public dsPhieuNhapBUS(ArrayList<PhieuNhapDTO> listPhieuNhap) {
              this.dsPhieunhap = listPhieuNhap;
              this.count = listPhieuNhap.size();
       }

       public void setDsPhieunhap(ArrayList<PhieuNhapDTO> dsPhieunhap) {
              this.dsPhieunhap = dsPhieunhap;
       }

       @Override
       public String getID() {
              // TODO Auto-generated method stub
              return null;
       }

       @Override
       public String getMaSP_Drink() {
              count++;
              Integer a = count;
              String str = a.toString();
              while (str.length() != 3)
                     str = "0" + str;
              str = "N" + str;
              return str;
       }

       @Override
       public String getMaSP_Food() {
              // TODO Auto-generated method stub
              return null;
       }

       public ArrayList<PhieuNhapDTO> getDsPhieuNhap() {
              return dsPhieunhap;
       }

       @Override
       public void xuatDS() {
              // System.out.printf("┌%-80s┐\n", Sys.repeatStr("─", 80));
              // System.out.printf("│%-10s%-40s%-10s│\n", Sys.repeatStr(" ", 25), "DANH SÁCH
              // PHIẾU NHẬP",
              // Sys.repeatStr(" ", 15));
              // System.out.printf("├%-80s┤\n", Sys.repeatStr("─", 80));
              // // System.out.printf("%-20s",Sys.repeatStr(" ", 20));
              // if (dsPhieunhap.isEmpty() == false) {
              // for (PhieuNhap phieunhap : dsPhieunhap) {
              // phieunhap.inPhieu();
              // }
              // }
              // System.out.printf("├%-80s┤\n", Sys.repeatStr("─", 80));
              // System.out.printf("│%-20s%-20s%-40s│\n", Sys.repeatStr("", 20),
              // Sys.repeatStr("", 20),
              // "Tổng hóa đơn nhập: " + sumMoneyDS());
              // System.out.printf("└%-80s┘\n", Sys.repeatStr("─", 80));

       }

       // xuat có lọc
       // public void xuatcoloc(PhieuNhap[] phieunhap, int index) {
       // if (index == 0) {
       // Sys.printError("Không tìm thấy kết quả");
       // return;
       // }
       // System.out.printf("┌%-80s┐\n", Sys.repeatStr("─", 80));
       // System.out.printf("│%-10s%-40s%-10s│\n", Sys.repeatStr(" ", 25), "DANH SÁCH
       // TÌM KIẾM",
       // Sys.repeatStr(" ", 15));
       // System.out.printf("├%-80s┤\n", Sys.repeatStr("─", 80));
       // for (int i = 0; i < index; i++) {
       // phieunhap[i].inPhieu();
       // }
       // System.out.printf("├%-80s┤\n", Sys.repeatStr("─", 80));
       // System.out.printf("└%-80s┘\n", Sys.repeatStr("─", 80));
       // }

       public int sumMoneyDS() {
              int sum = 0;
              for (PhieuNhapDTO phieunhap2 : dsPhieunhap) {
                     sum += phieunhap2.getSumMoney();
              }
              return sum;
       }

       @Override
       public void xuatTieuDe() {

       }

       public boolean add_2(PhieuNhapDTO phieuNhap) {
              int flag = 0;
              for (PhieuNhapDTO iterable_element : this.dsPhieunhap) {
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
       // public boolean Capnhatvaokho_2(String maPhieu, ListProductsBUS kho) {
       // for (PhieuNhapDTO phieuNhap : this.dsPhieunhap) {
       // if (phieuNhap.getIDPhieu().equals(maPhieu)) {
       // if (phieuNhap.getTinh_trang().equals("Chưa nhập")) {
       // phieuNhap.setTinh_trang("đã nhập");
       // ChiTietPhieuDTO[] temp = phieuNhap.getDsChitietphieu2().getChiTietPhieu2s();
       // int index = phieuNhap.getDsChitietphieu2().getIndex();
       // String maNCC = phieuNhap.getMaNXS();
       // String day = phieuNhap.getDate();
       // kho.nhapvaokho(temp, index, maNCC, day);
       // updatePhieuNhap_database(phieuNhap);
       // return true;
       // }
       // else {
       // return false;
       // }

       // }
       // }
       // return false;
       // }
       public boolean send_NXS(String maPhieu) {
              try {
                     PhieuNhapDTO phieuNhapDTO = null;
                     for (PhieuNhapDTO iterable_element : dsPhieunhap) {
                            if(iterable_element.getIDPhieu().equals(maPhieu)){
                                   phieuNhapDTO = iterable_element;
                            }
                     }
                     if(phieuNhapDTO == null){
                            return false;
                     }
                     if (phieuNhapDTO.getTinh_trang().equals("Chưa gửi")) {
                            phieuNhapDTO.setTinh_trang("Đã gửi");
                            updatePhieuNhap_database(phieuNhapDTO);
                            String IDPhieu = phieuNhapDTO.getIDPhieu();
                            String date = phieuNhapDTO.getDate();
                            dsChiTietPhieuBUS dsChiTietPhieuBUS = phieuNhapDTO.getDsChitietphieu2();
                            int sumMoney = dsChiTietPhieuBUS.Sum_money();
                            String ID_NV = phieuNhapDTO.getIDNhanVien();
                            String ID_PhieuKiem = IDPhieu.replace('N', 'K');
                            String MaNSX = phieuNhapDTO.getMaNXS();
                            PhieuKiemDTO phieuKiemDTO = new PhieuKiemDTO(ID_PhieuKiem, date, dsChiTietPhieuBUS,
                                          sumMoney,
                                          ID_NV, IDPhieu, MaNSX);
                            temp2.save(phieuKiemDTO);
                            return true;
                     }
                     return false;

              } catch (SQLException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                     return false;
              }
       }

       public boolean Xoa_2(String idPhieu) {
              for (PhieuNhapDTO phieunhap : dsPhieunhap) {
                     if (phieunhap.getIDPhieu().equals(idPhieu) && phieunhap.getTinh_trang().equals("Chưa gửi")) {
                            dsPhieunhap.remove(phieunhap);
                            xoaPhieuNhap_database(idPhieu);
                            return true;
                     }
              }
              return false;
       }

       public ArrayList<PhieuNhapDTO> TimkiemtheoKey_2(String tuKhoa) {
              int tongTien = 0;
              ArrayList<PhieuNhapDTO> phieu = new ArrayList<>();
              // int index = 0;
              for (PhieuNhapDTO phieunhap : dsPhieunhap) {
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
                                          phieunhap.getMaNXS().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          phieunhap.getSumMoney() == tongTien ||
                                          phieunhap.getTinh_trang().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
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

       public boolean Suachitiet_2(PhieuNhapDTO phieuNhap) {
              if (updatePhieuNhap_database(phieuNhap)) {
                     return true;
              }
              return false;
       }

       public PhieuNhapDTO getPhieuNhap_database(String id) {
              PhieuNhapDTO phieuNhap = null;
              try {
                     phieuNhap = temp.get(id);
                     return phieuNhap;
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return phieuNhap;
       }

       public boolean themPhieuNhap_database(PhieuNhapDTO phieuNhap) {
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

       public boolean updatePhieuNhap_database(PhieuNhapDTO phieuNhap) {
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
