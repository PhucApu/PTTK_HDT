package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThongKeTGPhieuNhap extends MouseAdapter {
       private ThongKePhieuNhap thongKePhieuNhap;

       public controller_btnThongKeTGPhieuNhap(ThongKePhieuNhap thongKePhieuNhap) {
              this.thongKePhieuNhap = thongKePhieuNhap;
       }
       public ThongKePhieuNhap getThongKePhieuNhap() {
              return thongKePhieuNhap;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {Sys.Sound_Click();
                            getThongKePhieuNhap().btn_ThongKeTG();
                     }
              }).start();
       }
}
