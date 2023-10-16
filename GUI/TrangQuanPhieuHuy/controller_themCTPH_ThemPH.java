package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_themCTPH_ThemPH extends MouseAdapter {
       public ThemPhieuHuy_Frame themPhieuHuy_Frame;

       public controller_themCTPH_ThemPH(ThemPhieuHuy_Frame themPhieuHuy_Frame) {
              this.themPhieuHuy_Frame = themPhieuHuy_Frame;
       }
       
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThemPhieuHuy_Frame().ChonSLProducts_addCTHoaDon();
                     }
              }).start();
       }

       public ThemPhieuHuy_Frame getThemPhieuHuy_Frame() {
              return themPhieuHuy_Frame;
       }
}
