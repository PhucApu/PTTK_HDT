package TrangQuanLyPhieuXuat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnXoaPX  extends MouseAdapter{
       private TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view;

       public controller_btnXoaPX(TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view) {
              this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
       }
       public TrangQuanLyPhieuXuat_view getTrangQuanLyPhieuXuat_view() {
              return trangQuanLyPhieuXuat_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyPhieuXuat_view().XoaPhieu_Frame();
                     }
              }).start();
       }      
}
