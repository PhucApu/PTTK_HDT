package TrangQuanLyPhieuKiem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;
public class controller_btnThoatXemPK extends MouseAdapter {
       private XemPhieuKiem_Frame xemPhieuKiem_Frame;
       private TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view;
       public controller_btnThoatXemPK(XemPhieuKiem_Frame xemPhieuKiem_Frame,
                     TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view) {
              this.xemPhieuKiem_Frame = xemPhieuKiem_Frame;
              this.trangQuanLyPhieuKiem_view = trangQuanLyPhieuKiem_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuKiem_view.setCheck_open_Jrame(0);
              this.xemPhieuKiem_Frame.setVisible(false);
              this.xemPhieuKiem_Frame.dispose();
       }
}
