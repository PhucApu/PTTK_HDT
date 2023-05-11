package DTO;

import java.io.Serializable;
import BUS.*;
/**
 *
 * @author User
 */
public class HoaDonDTO implements Serializable {
    private String maHd;
    private String manv;
    private String timexuat;
    private int tongtien;
    private DanhSachCTHDBUS dsCTHD;
    private String tinhTrang;

    public HoaDonDTO() {
        this.maHd = null;
        this.tongtien=0;
        this.dsCTHD = null;
    }

    public HoaDonDTO(String maHd, String manv, String timexuat, int tongtien, DanhSachCTHDBUS dsCTHD, String tinhTrang) {
        this.maHd = maHd;
        this.manv = manv;
        this.timexuat = timexuat;
        this.tongtien = tongtien;
        this.dsCTHD = dsCTHD;
        this.tinhTrang = tinhTrang;
    }
    //┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │
    public void xuatThongTin()
    {
        String tinhTrang = null;
        if(getTinhTrang().equals("Đang chờ xác nhận"))
            tinhTrang = Sys.TEXT_BLUE + getTinhTrang() + Sys.TEXT_RESET;
        else if(getTinhTrang().equals("Đã bán"))
            tinhTrang = Sys.TEXT_GREEN + getTinhTrang() + Sys.TEXT_RESET;
        System.out.printf("│%-20s│%-20s│%-10s│%-15s│%-34s│ \n", getMahd() , getManv(), getTimexuat(), getTongtien(), getTinhTrang());
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTimexuat() {
        return timexuat;
    }

    public void setTimexuat(String timexuat) {
        this.timexuat = timexuat;
    }

    public DanhSachCTHDBUS getDsCTHD() {
        return dsCTHD;
    }

    public void setDsCTHD(DanhSachCTHDBUS dsCTHD) {
        this.dsCTHD = dsCTHD;
    }

    public String getMahd() {
        return maHd;
    }

    public void setMahd(String maHd) {
        this.maHd = maHd;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
