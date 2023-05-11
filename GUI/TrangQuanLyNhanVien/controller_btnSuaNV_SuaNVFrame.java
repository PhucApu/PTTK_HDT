package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnSuaNV_SuaNVFrame extends MouseAdapter {
       private SuaNhanVien_Frame suaNhanVien_Frame;

       public controller_btnSuaNV_SuaNVFrame(SuaNhanVien_Frame suaNhanVien_Frame) {
              this.suaNhanVien_Frame = suaNhanVien_Frame;
       }
       public SuaNhanVien_Frame getSuaNhanVien_Frame() {
              return suaNhanVien_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            getSuaNhanVien_Frame().SuaThongtinNV_check();
                     }
              }).start();
       }
}
