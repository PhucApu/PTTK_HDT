package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_refreshIcon_SuaPhieuFrame extends MouseAdapter{
       private SuaPhieuNhap_Frame suaPhieuNhap_Frame;

       public controller_refreshIcon_SuaPhieuFrame(SuaPhieuNhap_Frame suaPhieuNhap_Frame) {
              this.suaPhieuNhap_Frame = suaPhieuNhap_Frame;
       }
       public SuaPhieuNhap_Frame getSuaPhieuNhap_Frame() {
              return suaPhieuNhap_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getSuaPhieuNhap_Frame().Refresh_icon();
                     }
              }).start();
       }
}
