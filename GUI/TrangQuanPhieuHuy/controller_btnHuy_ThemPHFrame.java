package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnHuy_ThemPHFrame extends MouseAdapter {
       private ThemPhieuHuy_Frame themPhieuHuy_Frame;

       public controller_btnHuy_ThemPHFrame(ThemPhieuHuy_Frame themPhieuHuy_Frame) {
              this.themPhieuHuy_Frame = themPhieuHuy_Frame;
       }

       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              themPhieuHuy_Frame.btnHuyHoaDon();
       }
}
