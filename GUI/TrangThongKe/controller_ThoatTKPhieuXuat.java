package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_ThoatTKPhieuXuat  extends MouseAdapter{
       private ThongKePhieuXuat thongKePhieuXuat;

       public controller_ThoatTKPhieuXuat(ThongKePhieuXuat thongKePhieuXuat) {
              this.thongKePhieuXuat = thongKePhieuXuat;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.thongKePhieuXuat.btn_Thoat();
       }      
}
