package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import DTO.Sys;

public class controller_refreshSP_ThemPHFrame  extends MouseAdapter{
       private ThemPhieuHuy_Frame themPhieuHuy_Frame;

       public controller_refreshSP_ThemPHFrame(ThemPhieuHuy_Frame themPhieuHuy_Frame) {
              this.themPhieuHuy_Frame = themPhieuHuy_Frame;
       }

       public ThemPhieuHuy_Frame getThemPhieuHuy_Frame() {
              return themPhieuHuy_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThemPhieuHuy_Frame().refresh_table_SP();
                     }
              }).start();
       }
}
