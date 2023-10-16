package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_TimKiemCT_SuaPhieuFrame extends MouseAdapter {
       private SuaPhieuHuy_Frame suaPhieuHuy_Frame;

       public controller_TimKiemCT_SuaPhieuFrame(SuaPhieuHuy_Frame suaPhieuHuy_Frame) {
              this.suaPhieuHuy_Frame = suaPhieuHuy_Frame;
       }
       public SuaPhieuHuy_Frame getSuaPhieuHuy_Frame() {
              return suaPhieuHuy_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              getSuaPhieuHuy_Frame().TimKiem_CTPhieu();
       }
}
