package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import DTO.*;

public class DanhSachCTHDBUS implements Serializable {
       private ArrayList<ChiTietHDDTO> cthd = new ArrayList<>();

       public ChiTietHDDTO timKiemTheoIDHoaDon(String id) {
              return cthd.stream().filter(x -> x.getMaSP().equals(id)).findFirst().orElse(null);
       }

       public void add(ChiTietHDDTO ct) {
              this.cthd.add(ct);
       }

       public int tinhTongTien() {
              int sumMoney = 0;
              for (ChiTietHDDTO ChiTietHDHoaDon : cthd) {
                     sumMoney += ChiTietHDHoaDon.getGia() * ChiTietHDHoaDon.getSoluong();
              }
              return sumMoney;
       }

       public ArrayList<ChiTietHDDTO> getCthd() {
              return cthd;
       }

       public void setCthd(ArrayList<ChiTietHDDTO> cthd) {
              this.cthd = cthd;
       }
}
