package TrangQuanLyPhieuKiem;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_refresh  extends MouseAdapter{
       private TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view;

       public controller_refresh(TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view) {
              this.trangQuanLyPhieuKiem_view = trangQuanLyPhieuKiem_view;
       }

       public TrangQuanLyPhieuKiem_view getTrangQuanLyPhieuKiem_view() {
              return trangQuanLyPhieuKiem_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyPhieuKiem_view().refresh_table();
                     }
              }).start();
       }
}
