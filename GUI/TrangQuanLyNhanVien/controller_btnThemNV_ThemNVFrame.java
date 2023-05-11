package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThemNV_ThemNVFrame extends MouseAdapter{
       private ThemNhanVien_Frame themNhanVien_Frame;
       
       
       public controller_btnThemNV_ThemNVFrame(ThemNhanVien_Frame themNhanVien_Frame) {
              this.themNhanVien_Frame = themNhanVien_Frame;
       }
       public ThemNhanVien_Frame getThemNhanVien_Frame() {
              return themNhanVien_Frame;
       }

       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              new Thread(
                     new Runnable() {
                            public void run() {
                                   getThemNhanVien_Frame().LayThongtinNV_check();
                            };
                     }
              ).start();
       }
}
