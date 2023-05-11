package TrangQuanLyPhieuXuat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_XemPXFrame extends MouseAdapter {
       private TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view;
       private XemPhieuXuat_Frame xemPhieuXuat_Frame;
       public controller_btnThoat_XemPXFrame(TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view,
                     XemPhieuXuat_Frame xemPhieuXuat_Frame) {
              this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
              this.xemPhieuXuat_Frame = xemPhieuXuat_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuXuat_view.setCheck_open_Jrame(0);
              this.xemPhieuXuat_Frame.setVisible(false);
              this.xemPhieuXuat_Frame.dispose();
       }
}
