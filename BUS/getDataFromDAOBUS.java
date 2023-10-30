package BUS;

import java.io.Serializable;
import java.util.ArrayList;

import DAO.*;
import DTO.*;

public class getDataFromDAOBUS implements Serializable {

    // phieu KIEM
    public static ArrayList<PhieuKiemDTO> getList_PhieuKiem_fromDATA() {

        ArrayList<PhieuKiemDTO> list = null;
        try {
            PhieuKiemDAO data = new PhieuKiemDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA PHIEU KIEM THAT BAI !!!");
            // e.printStackTrace();
        }
        Sys.printMessage("LOAD DATA PHIEU KIEM THANH CONG !!");
        return list;
    }



    // phieu huy
    public static ArrayList<PhieuHuyDTO> getList_PhieuHuy_fromDATA() {

        ArrayList<PhieuHuyDTO> list = null;
        try {
            PhieuHuyDAO data = new PhieuHuyDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA PHIEU HUY THAT BAI !!!");
            // e.printStackTrace();
        }
        Sys.printMessage("LOAD DATA PHIEU HUY THANH CONG !!");
        return list;
    }

    // nha cung cap
    public static ArrayList<SupplierDTO> getList_Supplier_fromDATA() {

        ArrayList<SupplierDTO> list = null;
        try {
            SupplierDAO data = new SupplierDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA SUPPLIER THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA SUPPLIER THANH CONG !!");
        return list;
    }

    // Products
    public static ArrayList<FoodDTO> getList_Food_fromDATA() {
        ArrayList<FoodDTO> list = null;
        try {
            FoodProductsDAO data = new FoodProductsDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST FOOD THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST FOOD THANH CONG !!");
        return list;

    }

    public static ArrayList<DrinkDTO> getList_Drink_fromDATA() {
        ArrayList<DrinkDTO> list = null;
        try {
            DrinkProductsDAO data = new DrinkProductsDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST DRINK THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST DRINK THANH CONG !!");
        return list;

    }

    // staff
    public static ArrayList<SeasonalStaffDTO> getList_SeasonalStaffs_fromDATA() {
        ArrayList<SeasonalStaffDTO> list = null;
        try {
            SeasonalStaffDAO data = new SeasonalStaffDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST SEASONSTAFFS THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST SEASONSTAFFS THANH CONG !!");
        return list;
    }

    public static ArrayList<FullTimeStaffDTO> getList_FullTimeStaffs_fromDATA() {
        ArrayList<FullTimeStaffDTO> list = null;
        try {
            FullTimeStaffDAO data = new FullTimeStaffDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST FULLTIMESTAFFS THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST FULLTIMESTAFFS THANH CONG !!");
        return list;
    }

    public static ArrayList<ManagerDTO> getList_Manager_fromDATA() {
        ArrayList<ManagerDTO> list = null;
        try {
            ManagerDAO data = new ManagerDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST MANAGERS THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST MANAGERS THANH CONG !!");
        return list;
    }

    // Phieu nhap
    public static ArrayList<PhieuNhapDTO> getList_PhieuNhap_fromDATA() {
        ArrayList<PhieuNhapDTO> list = null;
        try {
            PhieuNhapDAO data = new PhieuNhapDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST PHIEU NHAP THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST PHIEU NHAP THANH CONG !!");
        return list;
    }

    // Phieu xuat
    public static ArrayList<PhieuXuatDTO> getList_PhieuXuat_fromDATA() {
        ArrayList<PhieuXuatDTO> list = null;
        try {
            PhieuXuatDAO data = new PhieuXuatDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST PHIEU XUAT THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST PHIEU XUAT THANH CONG !!");
        return list;
    }

    // hoa don
    public static ArrayList<HoaDonDTO> getList_HoaDon_fromDATA() {
        ArrayList<HoaDonDTO> list = null;
        try {
            HoaDonDAO data = new HoaDonDAO();
            list = data.getList();
        } catch (Exception e) {
            Sys.printError("LOAD DATA LIST HOA DON THAT BAI !!!");
        }
        Sys.printMessage("LOAD DATA LIST HOA DON THANH CONG !!");
        return list;
    }
}
