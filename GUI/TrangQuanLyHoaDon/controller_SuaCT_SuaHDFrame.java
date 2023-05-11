package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_SuaCT_SuaHDFrame extends MouseAdapter {
       private SuaHoaDon_Frame suaHoaDon_Frame;

       public controller_SuaCT_SuaHDFrame(SuaHoaDon_Frame suaHoaDon_Frame) {
              this.suaHoaDon_Frame = suaHoaDon_Frame;
       }
       public SuaHoaDon_Frame getSuaHoaDon_Frame() {
              return suaHoaDon_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getSuaHoaDon_Frame().Sua_chitietPhieu();
                     }
              }).start();
       }
}
