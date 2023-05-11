package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThongKeTGPhieuXuat extends MouseAdapter{
       private ThongKePhieuXuat thongKePhieuXuat;

       public controller_btnThongKeTGPhieuXuat(ThongKePhieuXuat thongKePhieuXuat) {
              this.thongKePhieuXuat = thongKePhieuXuat;
       }
       public ThongKePhieuXuat getThongKePhieuXuat() {
              return thongKePhieuXuat;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {Sys.Sound_Click();
                            getThongKePhieuXuat().btn_ThongKeTG();
                     }
              }).start();
       }
}
