package DTO;

import java.util.ArrayList;
import BUS.*;
public class ThongKeDTO {
       private ListProductsBUS listProducts;
       private dsPhieuNhapBUS dsPhieuNhap;
       private dsPhieuXuatBUS dsPhieuXuat;
       private DanhSachHDBUS danhSachHD;
       private StaffsBUS staffs;
       private DanhSachNhaCCBUS danhSachNhaCC;

       public ThongKeDTO(ListProductsBUS listProducts, dsPhieuNhapBUS dsPhieuNhap, dsPhieuXuatBUS dsPhieuXuat,
       DanhSachHDBUS danhSachHD, StaffsBUS staffs, DanhSachNhaCCBUS danhSachNhaCC) {
              this.listProducts = listProducts;
              this.dsPhieuNhap = dsPhieuNhap;
              this.dsPhieuXuat = dsPhieuXuat;
              this.danhSachHD = danhSachHD;
              this.staffs = staffs;
              this.danhSachNhaCC = danhSachNhaCC;
       }

       // phieu nhap
       // thực phẩm nhập số lượng nhiều nhất và ít nhất,
       public ArrayList<Double> ThongKe_nhapProduct(String dayBefore, String dayAfter) {
              // doc ma sp
              ArrayList<ProductsDTO> list_products = this.listProducts.getArr();
              ArrayList<String> maSp = new ArrayList<>();
              for (ProductsDTO products : list_products) {
                     maSp.add(products.getMaSP());
              }
              // lay so luong nhap tung san pham
              int[] soluongNhap = new int[maSp.size()];
              ArrayList<PhieuNhapDTO> list_PhieuNhap = this.dsPhieuNhap.getDsPhieuNhap();
              for (int index = 0; index < maSp.size(); index++) {
                     String maSP = maSp.get(index);
                     for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuNhap.getDate(), dayAfter) && phieuNhap.getTinh_trang().equals("Chưa nhập") == false) {
                                   ChiTietPhieuDTO[] chiTietPhieus = phieuNhap.getDsChitietphieu2().getChiTietPhieu2s();
                                   int sl_CT = phieuNhap.getDsChitietphieu2().getIndex();
                                   for (int i = 0; i < sl_CT; i++) {
                                          if (chiTietPhieus[i].getMaSP().equals(maSP)) {
                                                 soluongNhap[index] += chiTietPhieus[i].getSoLuong();
                                          }
                                   }
                            }

                     }
              }
              // tinh ty le phan tram tung san pham
              // double[] phanTram = new double[maSp.size()];
              ArrayList <Double> phanTram = new ArrayList<>();
              int tong = 0;
              for (int index = 0; index < maSp.size(); index++) {
                     tong += soluongNhap[index];
              }
              if (tong > 0) {
                     double ty_le = 100 / tong;
                     for (int i = 0; i < maSp.size(); i++) {
                            phanTram.add(soluongNhap[i] * ty_le);
                     }
                     
                     return phanTram;
              }
              return null;
       }
       // phieu co tong tien lon nhat
       public ArrayList<String> ThongKe_PhieuNhapTongTienMax(String dayBefore, String dayAfter){
              float tongtienMax = 0;
              ArrayList<String> maphieuNhap = new ArrayList<>();
              ArrayList<PhieuNhapDTO> list_PhieuNhap = this.dsPhieuNhap.getDsPhieuNhap();
              for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                     if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuNhap.getDate(), dayAfter) && phieuNhap.getTinh_trang().equals("Chưa nhập") == false){
                            if(tongtienMax <= phieuNhap.getSumMoney() ){
                                   tongtienMax = phieuNhap.getSumMoney();
                                   
                            }
                     }
                     
              }
              for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                     if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuNhap.getDate(), dayAfter) && phieuNhap.getTinh_trang().equals("Chưa nhập") == false){
                            if(tongtienMax == phieuNhap.getSumMoney() ){
                                   // maPhieu = maPhieu + phieuNhap.getIDPhieu()+" ";
                                   maphieuNhap.add(phieuNhap.getIDPhieu());
                            }
                     }
                     
              }

              return maphieuNhap;
       }
       public ArrayList<String> ThongKe_NhanVienNhapMax(String dayBefore, String dayAfter){
              float soLanMax = 0;
              ArrayList<StaffDTO> list_NhanVien = this.staffs.getStaffs();
              int [] soLanThucHien = new int[ list_NhanVien.size()];
              ArrayList<PhieuNhapDTO> list_PhieuNhap = this.dsPhieuNhap.getDsPhieuNhap();
              
              for (int i = 0; i < list_NhanVien.size(); i++) {
                     String maNv = list_NhanVien.get(i).getId();
                     for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuNhap.getDate(), dayAfter) && phieuNhap.getTinh_trang().equals("Chưa nhập") == false){
                                   if(phieuNhap.getIDNhanVien().equals(maNv)){
                                          soLanThucHien[i]++;
                                   }
                            }
                            
                     }
              }
              ArrayList <String> maNV = new ArrayList<>();
              for (int index = 0; index < list_NhanVien.size(); index++) {
                     if(soLanThucHien[index] > soLanMax){
                            soLanMax = soLanThucHien[index];
                     }
              }
              for (int i = 0; i < list_NhanVien.size(); i++) {
                     String maNv = list_NhanVien.get(i).getId();
                     if(soLanThucHien[i] == soLanMax){
                            maNV.add(maNv);
                     }
              }
              return maNV;
       }
       public ArrayList <String> ThongKe_nhapNCCmax(String dayBefore, String dayAfter){
              ArrayList<SupplierDTO> list_NCC = this.danhSachNhaCC.getListNCC();
              int [] soLanThucHien = new int[ list_NCC.size()];
              ArrayList<PhieuNhapDTO> list_PhieuNhap = this.dsPhieuNhap.getDsPhieuNhap();
              for (int index = 0; index < list_NCC.size(); index++) {
                     String maNCC = list_NCC.get(index).getMa();
                     for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuNhap.getDate(), dayAfter) && phieuNhap.getTinh_trang().equals("Chưa nhập") == false){
                                   if(phieuNhap.getMaNXS().equals(maNCC)){
                                          soLanThucHien[index]++;
                                   }
                            }
                            
                     }
              }
              ArrayList< String> mancc = new ArrayList<>();
              float soLanMax = 0;
              for (int index = 0; index < list_NCC.size(); index++) {
                     if(soLanThucHien[index] > soLanMax){
                            soLanMax = soLanThucHien[index];
                     }
              }
              for (int i = 0; i < list_NCC.size(); i++) {
                     String maNCC = list_NCC.get(i).getMa();
                     if(soLanThucHien[i] == soLanMax){
                            // mancc = mancc + maNCC+" ";
                            mancc.add(maNCC);
                     }
              }
              return mancc;

       }
       // phieu xuat
       public ArrayList <Double> ThongKe_xuatProduct(String dayBefore, String dayAfter) {
              // doc ma sp
              ArrayList<ProductsDTO> list_products = this.listProducts.getArr();
              ArrayList<String> maSp = new ArrayList<>();
              for (ProductsDTO products : list_products) {
                     maSp.add(products.getMaSP());
              }
              // lay so luong nhap tung san pham
              int[] soluongXuat = new int[maSp.size()];
              ArrayList<PhieuXuatDTO> list_PhieuXuat = this.dsPhieuXuat.getDsPhieuxuat();
              for (int index = 0; index < maSp.size(); index++) {
                     String maSP = maSp.get(index);
                     for (PhieuXuatDTO phieuXuat : list_PhieuXuat) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuXuat.getDate(), dayAfter) && phieuXuat.getTinhTrang().equals("Đã xuất kho")) {
                                   ChiTietPhieuDTO[] chiTietPhieus = phieuXuat.getDsChitietphieu2().getChiTietPhieu2s();
                                   int sl_CT = phieuXuat.getDsChitietphieu2().getIndex();
                                   for (int i = 0; i < sl_CT; i++) {
                                          if (chiTietPhieus[i].getMaSP().equals(maSP)) {
                                                 soluongXuat[index] += chiTietPhieus[i].getSoLuong();
                                          }
                                   }
                            }

                     }
              }
              // tinh ty le phan tram tung san pham
              // double[] phanTram = new double[maSp.size()];
              ArrayList <Double> phanTram = new ArrayList<>();
              int tong = 0;
              for (int index = 0; index < maSp.size(); index++) {
                     tong += soluongXuat[index];
              }
              if (tong > 0) {
                     double ty_le = 100 / tong;
                     for (int i = 0; i < maSp.size(); i++) {
                            phanTram.add(soluongXuat[i] * ty_le);
                     }
                     return phanTram;
              }
              return null;
       }
       public ArrayList< String > ThongKe_NhanVienXuatMax(String dayBefore, String dayAfter){
              float soLanMax = 0;
              ArrayList<StaffDTO> list_NhanVien = this.staffs.getStaffs();
              int [] soLanThucHien = new int[ list_NhanVien.size()];
              ArrayList<PhieuXuatDTO> list_PhieuNhap = this.dsPhieuXuat.getDsPhieuxuat();
              
              for (int i = 0; i < list_NhanVien.size(); i++) {
                     String maNv = list_NhanVien.get(i).getId();
                     for (PhieuXuatDTO phieuXuat : list_PhieuNhap) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuXuat.getDate(), dayAfter) && phieuXuat.getTinhTrang().equals("Đã xuất kho")) {
                                   if(phieuXuat.getIDNhanVien().equals(maNv)){
                                          soLanThucHien[i]++;
                                   }
                            }
                            
                     }
              }
              ArrayList< String>  manv = new ArrayList<>();
              for (int index = 0; index < list_NhanVien.size(); index++) {
                     if(soLanThucHien[index] > soLanMax){
                            soLanMax = soLanThucHien[index];
                     }
              }
              for (int i = 0; i < list_NhanVien.size(); i++) {
                     String maNv = list_NhanVien.get(i).getId();
                     if(soLanThucHien[i] == soLanMax){
                            // manv = manv + maNv+" ";
                            manv.add(maNv);
                     }
              }
              return manv;
       }
       public ArrayList< String> ThongKe_PhieuXuatTongTienMax(String dayBefore, String dayAfter){
              float tongtienMax = 0;
              ArrayList <String> maPhieu = new ArrayList<>() ;
              ArrayList<PhieuXuatDTO> list_PhieuXuat = this.dsPhieuXuat.getDsPhieuxuat();
              for (PhieuXuatDTO phieuXuat : list_PhieuXuat) {
                     if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuXuat.getDate(), dayAfter) && phieuXuat.getTinhTrang().equals("Đã xuất kho")) {
                            if(tongtienMax <= phieuXuat.getSumMoney() ){
                                   tongtienMax = phieuXuat.getSumMoney();      
                            }
                     }
                     
              }
              for (PhieuXuatDTO phieuXuat : list_PhieuXuat) {
                     if (Sys.kiemTraKhoangThoiGian(dayBefore, phieuXuat.getDate(), dayAfter) && phieuXuat.getTinhTrang().equals("Đã xuất kho")) {
                            if(tongtienMax == phieuXuat.getSumMoney() ){
                                   // maPhieu = maPhieu + phieuXuat.getIDPhieu()+" ";
                                   maPhieu.add(phieuXuat.getIDPhieu());
                            }
                     }
                     
              }
              return maPhieu;
       }
       // hoa don
       public ArrayList <Double> ThongKe_HoaDonTongTienTheoNV(String dayBefore, String dayAfter){
              
              // ma nhan vien
              ArrayList<String> maNV = new ArrayList<>();
              for (StaffDTO staff : this.staffs.getStaffs()) {
                     maNV.add(staff.getId());
              }

              ArrayList<HoaDonDTO> list_HoaDon = this.danhSachHD.getHoaDonArrayList();
              // float [] tongtungHD = new float[maNV.size()];
              ArrayList <Double> tongtungHD = new ArrayList<>();
              for (String manv : maNV) {
                     double tongtien = 0;
                     for (HoaDonDTO hoaDon : list_HoaDon) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, hoaDon.getTimexuat(),dayAfter) ==  true && hoaDon.getTinhTrang().equals("Đang chờ xác nhận") == false ) {
                                   if(hoaDon.getManv().equals(manv)){
                                          tongtien += hoaDon.getTongtien();
                                   }
                            }
                            
                     }
                     tongtungHD.add(tongtien);
              }
              return tongtungHD;
       }
       public ArrayList <Double> ThongKe_NhanVienHDMax(String dayBefore, String dayAfter){
              ArrayList<StaffDTO> list_NhanVien = this.staffs.getStaffs();
              // int [] soLanThucHien = new int[ list_NhanVien.size()];
              ArrayList <Double> soLanThucHien = new ArrayList<>();
              ArrayList<HoaDonDTO> list_HoaDon = this.danhSachHD.getHoaDonArrayList();
              
              for (int i = 0; i < list_NhanVien.size(); i++) {
                     double thuchien = 0;
                     String maNv = list_NhanVien.get(i).getId();
                     for (HoaDonDTO hoaDon : list_HoaDon) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, hoaDon.getTimexuat(),dayAfter) ==  true && hoaDon.getTinhTrang().equals("Đang chờ xác nhận") == false ){
                                   if(hoaDon.getManv().equals(maNv)){
                                          thuchien ++;
                                   }
                            }
                            
                     }
                     soLanThucHien.add(thuchien);
              }
              return soLanThucHien;
       }
       public ArrayList <String> thongKeCacHDTheoNV(String dayBefore, String dayAfter) {
              // ma nhan vien
              ArrayList<String> maNV = new ArrayList<>();
              for (StaffDTO staff : this.staffs.getStaffs()) {
                     maNV.add(staff.getId());
              }

              ArrayList<HoaDonDTO> list_HoaDon = this.danhSachHD.getHoaDonArrayList();
              // String [] cachoadon = new String[maNV.size()];
              ArrayList <String> cachoadon = new ArrayList<>();
              int index = 0;
              for (String manv : maNV) {
                     String mahd = "";
                     for (HoaDonDTO hoaDon : list_HoaDon) {
                            if (Sys.kiemTraKhoangThoiGian(dayBefore, hoaDon.getTimexuat(),dayAfter) ==  true && hoaDon.getTinhTrang().equals("Đang chờ xác nhận") == false){
                                   if(hoaDon.getManv().equals(manv)){
                                          mahd = mahd + hoaDon.getMahd() + " ";
                                    }
                            }
                            
                     }
                     cachoadon.add(mahd);
                     index ++;
              }
              return cachoadon;
       }

       public ListProductsBUS getListProducts() {
              return listProducts;
       }

       public dsPhieuNhapBUS getDsPhieuNhap() {
              return dsPhieuNhap;
       }

       public dsPhieuXuatBUS getDsPhieuXuat() {
              return dsPhieuXuat;
       }

       public DanhSachHDBUS getDanhSachHD() {
              return danhSachHD;
       }

       public StaffsBUS getStaffs() {
              return staffs;
       }

       public DanhSachNhaCCBUS getDanhSachNhaCC() {
              return danhSachNhaCC;
       }

       

       






}
