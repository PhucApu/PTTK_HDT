package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_refreshIcon_SuaPhieuFrame extends MouseAdapter{
       private SuaPhieuHuy_Frame suaPhieuHuy_Frame;

       public controller_refreshIcon_SuaPhieuFrame(SuaPhieuHuy_Frame suaPhieuNhap_Frame) {
              this.suaPhieuHuy_Frame = suaPhieuNhap_Frame;
       }
       public SuaPhieuHuy_Frame getSuaPhieuHuy_Frame() {
              return suaPhieuHuy_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getSuaPhieuHuy_Frame().Refresh_icon();
                     }
              }).start();
       }
}