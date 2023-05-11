package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_refreshSP_ThemHDFrame extends MouseAdapter {
       private ThemHoaDon_Frame themHoaDon_Frame;

       public controller_refreshSP_ThemHDFrame(ThemHoaDon_Frame themHoaDon_Frame) {
              this.themHoaDon_Frame = themHoaDon_Frame;
       }
       public ThemHoaDon_Frame getThemHoaDon_Frame() {
              return themHoaDon_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThemHoaDon_Frame().refresh_table_SP();
                     }
              }).start();
       }
}
