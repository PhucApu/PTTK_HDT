package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThongKeTGHoaDon extends MouseAdapter {
       private ThongKeHoaDon thongKeHoaDon;

       public controller_btnThongKeTGHoaDon(ThongKeHoaDon thongKeHoaDon) {
              this.thongKeHoaDon = thongKeHoaDon;
       }
       public ThongKeHoaDon getThongKeHoaDon() {
              return thongKeHoaDon;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThongKeHoaDon().btn_ThongKeTG();
                     }
              }).start();
       }
}
