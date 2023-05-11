package BUS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import DAO.*;
import DTO.*;
public class DanhSachHDBUS implements Serializable, DanhSachBUS {
       private ArrayList<HoaDonDTO> hoaDonArrayList = new ArrayList<>();
       private int count = 0;
       HoaDonDAO temp = new HoaDonDAO();
       public DanhSachHDBUS(ListProductsBUS A) {
              this.hoaDonArrayList = new ArrayList<>();
              A = new ListProductsBUS();
              DanhSachCTHDBUS a = new DanhSachCTHDBUS();
              ProductsDTO sp1 = A.getArr().get(0);
              ProductsDTO sp2 = A.getArr().get(1);
              ProductsDTO sp3 = A.getArr().get(2);

              a.getCthd().add(new ChiTietHDDTO(sp1.getMaSP(), 10, sp1.getPrice()));
              a.getCthd().add(new ChiTietHDDTO(sp2.getMaSP(), 3, sp2.getPrice()));
              a.getCthd().add(new ChiTietHDDTO(sp3.getMaSP(), 6, sp3.getPrice()));

              HoaDonDTO mot = new HoaDonDTO(getID(), "NV001", "12/12/2020", a.tinhTongTien(), a, "Đã bán");
              hoaDonArrayList.add(mot);
              themHoaDon_database(mot);

              DanhSachCTHDBUS b = new DanhSachCTHDBUS();
              b.getCthd().add(new ChiTietHDDTO(sp2.getMaSP(), 6, sp2.getPrice()));
              b.getCthd().add(new ChiTietHDDTO(sp3.getMaSP(), 4, sp3.getPrice()));

              HoaDonDTO hai = new HoaDonDTO(getID(), "NV004", "1/2/2021", b.tinhTongTien(), b, "Đã bán");
              hoaDonArrayList.add(hai);
              themHoaDon_database(hai);

              DanhSachCTHDBUS c = new DanhSachCTHDBUS();
              c.getCthd().add(new ChiTietHDDTO(sp1.getMaSP(), 22, sp1.getPrice()));
              c.getCthd().add(new ChiTietHDDTO(sp3.getMaSP(), 40, sp3.getPrice()));

              HoaDonDTO ba = new HoaDonDTO(getID(), "NV004", "11/2/2021", c.tinhTongTien(), c, "Đã bán");
              hoaDonArrayList.add(ba);
              themHoaDon_database(ba);

              DanhSachCTHDBUS d = new DanhSachCTHDBUS();
              d.getCthd().add(new ChiTietHDDTO(sp1.getMaSP(), 55, sp1.getPrice()));
              d.getCthd().add(new ChiTietHDDTO(sp3.getMaSP(), 11, sp3.getPrice()));

              HoaDonDTO bon = new HoaDonDTO(getID(), "NV003", "26/5/2021", d.tinhTongTien(), d, "Đã bán");
              hoaDonArrayList.add(bon);
              themHoaDon_database(bon);

              // DanhSachCTHD e = new DanhSachCTHD();
              // e.getCthd().add(new ChiTietHD(sp1.getMaSP(), 33, sp1.getPrice()));
              // e.getCthd().add(new ChiTietHD(sp2.getMaSP(), 61, sp2.getPrice()));

              // hoaDonArrayList.add(new HoaDon(getID(), "NV002", "30/7/2021",
              // e.tinhTongTien(), e, "Đã bán"));

              // DanhSachCTHD f = new DanhSachCTHD();
              // f.getCthd().add(new ChiTietHD(sp1.getMaSP(), 11, sp3.getPrice()));

              // hoaDonArrayList.add(new HoaDon(getID(), "NV001", "29/8/2021",
              // f.tinhTongTien(), f, "Đã bán"));

              
       }
       public DanhSachHDBUS(ArrayList<HoaDonDTO> list) {
              this.hoaDonArrayList = list;
              this.count = list.size();
       }
       public void setCount(int count) {
              this.count = count;
       }
       private HoaDonDTO timKiemHoaDonTheoID(String id) {
              return hoaDonArrayList.stream().filter(x -> x.getMahd().equals(id)).findAny().orElse(null);
       }

       public String  getID() {
              count++;
              Integer a = count;
              String str = a.toString();
              while (str.length() != 3)
                     str = "0" + str;
              str = "HD" + str;
              return str;
       }

       public boolean themHDCuaKhachHang_2(HoaDonDTO don) {

              if (themHoaDon_database(don)) {
                     return true;
              }
              return false;
       }

       public boolean suaHD_2(HoaDonDTO don) {
              if (updatePhieuXuat_database(don)) {
                     return true;
              }
              return false;
       }
       public ArrayList<HoaDonDTO> getHoaDonArrayList() {
              return hoaDonArrayList;
       }

       public ArrayList<HoaDonDTO> timHD_2(String tuKhoa) {
              ArrayList<HoaDonDTO> filter = new ArrayList<>();
              int gia;
              try {
                     gia = Integer.parseInt(tuKhoa);
              } catch (NumberFormatException ignored) {
                     gia = Integer.MIN_VALUE;
              }
              for (HoaDonDTO hoaDon : hoaDonArrayList) {
                     {
                            if (hoaDon.getMahd().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                                          hoaDon.getTinhTrang().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))
                                          ||
                                          hoaDon.getTongtien() == gia ||
                                          hoaDon.getTimexuat().toLowerCase(Locale.ROOT)
                                                        .contains(tuKhoa.toLowerCase(Locale.ROOT))) {
                                   filter.add(hoaDon);
                            }
                     }
              }
              return filter;
       }
       public boolean xoaHD_2(String idHoaDon) {
              HoaDonDTO hoaDon = timKiemHoaDonTheoID(idHoaDon);
              if (hoaDon != null) {
                     if (xoaHoaDon_database(idHoaDon)) {
                            return true;
                     } else {
                            return false;
                     }

              } else {
                     return false;
              }
       }
       public boolean xacNhanHoaDon_2(String id,StaffDTO nguoi,dsPhieuXuatBUS dsPhieuXuat, ListProductsBUS kho){
              HoaDonDTO hoaDon = hoaDonArrayList.stream().filter(x -> x.getMahd().equals(id)).findAny().orElse(null);
              if (hoaDon == null)
                     return false;
              else {
                     if (hoaDon.getTinhTrang().equals("Đang chờ xác nhận")) {
                            
                            hoaDon.setManv(nguoi.getId());
                            hoaDon.setTinhTrang("Đã bán");
                            if(updatePhieuXuat_database(hoaDon)){
                                   dsPhieuXuat.add(hoaDon, kho);
                                   return true;
                            }
                            
                            
                     } else
                            return false;
                     return false;
              }
       }
       public HoaDonDTO getHoaDon_database(String id) {
              HoaDonDTO hoaDon = null;
              try {
                     hoaDon = temp.get(id);
                     return hoaDon;
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return hoaDon;
       }

       private boolean themHoaDon_database(HoaDonDTO hoaDon) {
              try {
                     if (temp.save(hoaDon)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       private boolean xoaHoaDon_database(String id) {
              try {
                     if (temp.deleteById(id)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       private boolean updatePhieuXuat_database(HoaDonDTO hoaDon) {
              try {
                     if (temp.update(hoaDon)) {
                            return true;
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }
       public void setHoaDonArrayList(ArrayList<HoaDonDTO> hoaDonArrayList) {
              this.hoaDonArrayList = hoaDonArrayList;
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
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'getMaSP_Drink'");
       }


}
