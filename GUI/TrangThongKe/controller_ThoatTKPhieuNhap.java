package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_ThoatTKPhieuNhap extends MouseAdapter {
       private ThongKePhieuNhap thongKePhieuNhap;

       public controller_ThoatTKPhieuNhap(ThongKePhieuNhap thongKePhieuNhap) {
              this.thongKePhieuNhap = thongKePhieuNhap;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.thongKePhieuNhap.btn_Thoat();
       }
}
