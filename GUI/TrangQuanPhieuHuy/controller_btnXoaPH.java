package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;
public class controller_btnXoaPH extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;

       public controller_btnXoaPH(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
       }
       public TrangQuanLyPhieuHuy trangQuanLyPhieuHuy2(){
              return trangQuanLyPhieuHuy;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            trangQuanLyPhieuHuy2().XoaPhieu_Frame();
                     }
              }).start();
       }   
}
