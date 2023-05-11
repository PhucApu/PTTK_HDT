package TrangQuanLyHoaDon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import DTO.Sys;

public class controller_TinhTienDu_ThemHD extends KeyAdapter{
       private ThemHoaDon_Frame themHoaDon_Frame;

       public controller_TinhTienDu_ThemHD(ThemHoaDon_Frame themHoaDon_Frame) {
              this.themHoaDon_Frame = themHoaDon_Frame;
       }
       public ThemHoaDon_Frame getThemHoaDon_Frame() {
              return themHoaDon_Frame;
       }
       @Override
       public void keyTyped(KeyEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThemHoaDon_Frame().TinhTienDu();
                     }
              }).start();
       }
}
