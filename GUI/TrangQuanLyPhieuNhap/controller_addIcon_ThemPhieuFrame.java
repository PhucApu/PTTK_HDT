package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_addIcon_ThemPhieuFrame extends MouseAdapter{
       private ThemPhieuNhap_Frame themPhieuNhap_Frame;

       public controller_addIcon_ThemPhieuFrame(ThemPhieuNhap_Frame themPhieuNhap_Frame) {
              this.themPhieuNhap_Frame = themPhieuNhap_Frame;
       }
       public ThemPhieuNhap_Frame getThemPhieuNhap_Frame() {
              return themPhieuNhap_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThemPhieuNhap_Frame().them_chitietPhieu();
                     }
              }).start();
       }
       
}
