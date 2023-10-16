package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThanhToan_ThemPH extends MouseAdapter{
       private ThemPhieuHuy_Frame themPhieuHuy_Frame;

       public controller_btnThanhToan_ThemPH(ThemPhieuHuy_Frame themPhieuHuy_Frame) {
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
                            getThemPhieuHuy_Frame().btnLapPhieu();
                     }
              }).start();
       }
}
