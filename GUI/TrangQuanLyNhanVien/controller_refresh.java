package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_refresh extends MouseAdapter{
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;

       public controller_refresh(TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
              this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
       }
       public TrangQuanLyNhanVien_view getTrangQuanLyNhanVien_view() {
              return trangQuanLyNhanVien_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyNhanVien_view().refresh_table();
                     }
              }).start();
       }
}
