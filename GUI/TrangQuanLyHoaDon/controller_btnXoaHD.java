package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnXoaHD extends MouseAdapter{
       private TrangQuanLyHoaDon_view trangQuanLyHoaDon_view;

       public controller_btnXoaHD(TrangQuanLyHoaDon_view trangQuanLyHoaDon_view) {
              this.trangQuanLyHoaDon_view = trangQuanLyHoaDon_view;
       }
       public TrangQuanLyHoaDon_view getTrangQuanLyHoaDon_view() {
              return trangQuanLyHoaDon_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyHoaDon_view().XoaHoaDon_Frame();
                     }
              }).start();
       }
}
