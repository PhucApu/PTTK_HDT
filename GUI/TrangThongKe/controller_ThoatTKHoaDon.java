package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_ThoatTKHoaDon extends MouseAdapter {
       private ThongKeHoaDon thongKeHoaDon;

       public controller_ThoatTKHoaDon(ThongKeHoaDon thongKeHoaDon) {
              this.thongKeHoaDon = thongKeHoaDon;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.thongKeHoaDon.btn_Thoat();
       }
}
