package BUS;

import java.util.ArrayList;
import DTO.*;
public class StoreBUS {
    public StaffsBUS manageStaffs ;
    public DanhSachHDBUS danhSachHD;
    public dsPhieuNhapBUS dsPhieuNhap;
    public dsPhieuXuatBUS dsPhieuXuat;
    public DanhSachNhaCCBUS danhSachNhaCC;
    public ListProductsBUS listProducts;
    public dsPhieuHuyBUS dsPhieuHuyBUS;

    public StoreBUS() {
       // loadStaffsToDB();
    //    load_Staffs_2();
    }

    

    // load tung doi tuong tu file
//     public Staffs loadStaffsToDB() {

//         Staffs tmp = (Staffs) Sys.load(manageStaffs, "dsNhanSu.txt");
//         if (tmp != null) {
//             this.manageStaffs = tmp;
//             return this.manageStaffs;
//         }
//         this.manageStaffs = new Staffs();
//         return this.manageStaffs;
//     }

//     // danh sach hoa don
//     public DanhSachHD load_DanhSachHD() {
//         DanhSachHD temp = (DanhSachHD) Sys.load(danhSachHD, "DanhSachHD.txt");
//         if (temp != null) {
//             this.danhSachHD = temp;
//             return this.danhSachHD;
//         }
//         this.danhSachHD = new DanhSachHD(listProducts);
//         return this.danhSachHD;
//     }

//     // danh sach phieu xuat
//     public dsPhieuXuat load_DsPhieuXuat() {
//         dsPhieuXuat temp = (dsPhieuXuat) Sys.load(dsPhieuXuat, "dsPhieuXuat.txt");
//         if (temp != null) {
//             this.dsPhieuXuat = temp;
//             return this.dsPhieuXuat;
//         }
//         this.dsPhieuXuat = new dsPhieuXuat(listProducts, danhSachHD);
//         return this.dsPhieuXuat;
//     }

//     // load phieu nhap
//     public dsPhieuNhap load_DsPhieuNhap() {
//         dsPhieuNhap temp = (dsPhieuNhap) Sys.load(dsPhieuNhap, "dsPhieuNhap.txt");
//         if (temp != null) {
//             this.dsPhieuNhap = temp;
//             return this.dsPhieuNhap;
//         }
//         this.dsPhieuNhap = new dsPhieuNhap();
//         return this.dsPhieuNhap;

//     }

//     // load listProduct
//     public ListProducts load_ListProducts() {
//         ListProducts temp = (ListProducts) Sys.load(listProducts, "ListProducts.txt");
//         if (temp != null) {
//             this.listProducts = temp;
//             return this.listProducts;
//         }
//         this.listProducts = new ListProducts();
//         return this.listProducts;
//     }

//     // load danh sach nha cc
//     public DanhSachNhaCC load_DanhSachNCC() {
//         DanhSachNhaCC temp = (DanhSachNhaCC) Sys.load(danhSachNhaCC, "DanhSachNhaCC.txt");
//         if (temp != null) {
//             this.danhSachNhaCC = temp;
//             return this.danhSachNhaCC;
//         }
//         this.danhSachNhaCC = new DanhSachNhaCC();
//         return this.danhSachNhaCC;
//     }

    // load danh sach tu database


    

    public DanhSachNhaCCBUS load_DanhSachNhaCC_2(){
        ArrayList<SupplierDTO> data = getDataFromDAOBUS.getList_Supplier_fromDATA();
        
        if( data != null){
            DanhSachNhaCCBUS temp = new DanhSachNhaCCBUS(data);
            temp.setlistNhaCungCap(data);
            this.danhSachNhaCC = temp;
            return this.danhSachNhaCC;
        }
        this.danhSachNhaCC = new DanhSachNhaCCBUS() ;
        return this.danhSachNhaCC;
    }
    public ListProductsBUS load_ListProducts_2(){
        ArrayList<FoodDTO> data_food = getDataFromDAOBUS.getList_Food_fromDATA();
        ArrayList<DrinkDTO> data_drink = getDataFromDAOBUS.getList_Drink_fromDATA();
        if( data_food == null && data_drink == null ){
            this.listProducts = new ListProductsBUS() ;
            return this.listProducts;
        }
        ListProductsBUS temp = new ListProductsBUS(data_food,data_drink);
        this.listProducts = temp;
        return this.listProducts;
    }
    public StaffsBUS load_Staffs_2(){
        ArrayList<ManagerDTO> data_Managers = getDataFromDAOBUS.getList_Manager_fromDATA();
        ArrayList<FullTimeStaffDTO> data_FullTimeStaffs = getDataFromDAOBUS.getList_FullTimeStaffs_fromDATA();
        ArrayList<SeasonalStaffDTO> data_SeasonalStaffs = getDataFromDAOBUS.getList_SeasonalStaffs_fromDATA();
        if(data_FullTimeStaffs == null && data_Managers == null && data_SeasonalStaffs == null){
            this.manageStaffs = new StaffsBUS();
            return this.manageStaffs;
        }
        StaffsBUS temp = new StaffsBUS();
        // add dung thu tu neu khong se bao loi !! 
        temp.addList_SeasonalStaff(data_SeasonalStaffs);
        temp.addList_Manager(data_Managers);
        temp.addList_FullTimeStaff(data_FullTimeStaffs);
        
        this.manageStaffs = temp;
        return this.manageStaffs;
        
    }
    public dsPhieuNhapBUS load_PhieuNhap_2(){
        ArrayList<PhieuNhapDTO> data_PhieuNhap = getDataFromDAOBUS.getList_PhieuNhap_fromDATA();
        if(data_PhieuNhap == null){
            this.dsPhieuNhap = new dsPhieuNhapBUS();
            return this.dsPhieuNhap;
        }
        this.dsPhieuNhap = new dsPhieuNhapBUS(data_PhieuNhap);
        return this.dsPhieuNhap;
    }
    public dsPhieuXuatBUS load_PhieuXuat_2(){
        ArrayList<PhieuXuatDTO> data_PhieuXuat = getDataFromDAOBUS.getList_PhieuXuat_fromDATA();
        if(data_PhieuXuat == null){
            this.dsPhieuXuat = new dsPhieuXuatBUS(listProducts, danhSachHD);
            return this.dsPhieuXuat;
        }
        this.dsPhieuXuat = new dsPhieuXuatBUS(data_PhieuXuat);
        return this.dsPhieuXuat;
    }
    public DanhSachHDBUS load_DanhSachHD_2(){
        ArrayList<HoaDonDTO> data_HoaDon = getDataFromDAOBUS.getList_HoaDon_fromDATA();
        if(data_HoaDon == null){
            this.danhSachHD = new DanhSachHDBUS(listProducts);
            return this.danhSachHD;
        }
        this.danhSachHD = new DanhSachHDBUS(data_HoaDon);
        return this.danhSachHD;
    }
    public dsPhieuHuyBUS load_DanhSachPhieuHuy_2(){
        ArrayList<PhieuHuyDTO> data = getDataFromDAOBUS.getList_PhieuHuy_fromDATA();
        
        if( data != null){
            dsPhieuHuyBUS temp = new dsPhieuHuyBUS(data);
            temp.setDsPhieunhap(data);
            this.dsPhieuHuyBUS = temp;
            return this.dsPhieuHuyBUS;
        }
        this.dsPhieuHuyBUS = new dsPhieuHuyBUS(listProducts) ;
        return this.dsPhieuHuyBUS;
    }



    // save doi tuong xuong file
    // save listproduct
//     public void save_ListProducts(ListProducts listProducts) {
//         Sys.save(listProducts, "ListProducts.txt");
//     }

    // save danh sach nha cc
//     public void save_DanhSachNCC(DanhSachNhaCC dSachNhaCC) {
//         Sys.save(danhSachNhaCC, "DanhSachNhaCC.txt");
//     }

//     // save danh sach phieu nhap
//     public void save_DsPhieuNhap(dsPhieuNhap dsPhieuNhap) {
//         Sys.save(dsPhieuNhap, "dsPhieuNhap.txt");
//     }

//     // save danh sach phieu xuat
//     public void save_DsPhieuXuat(dsPhieuXuat dsPhieuXuat) {
//         Sys.save(dsPhieuXuat, "dsPhieuXuat.txt");
//     }

//     // save danh sach hoa don
//     public void save_DanhSachHD(DanhSachHD danhSachHD) {
//         Sys.save(danhSachHD, "DanhSachHD.txt");
//     }

//     public void saveStaffsToDB(Staffs staffs) {
//         Sys.save(manageStaffs, "dsNhanSu.txt");
//     }
}
