package TrangQuanLyPhieuXuat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_refresh extends MouseAdapter {
       private TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view;

       public controller_refresh(TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view) {
              this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
       }
       public TrangQuanLyPhieuXuat_view getTrangQuanLyPhieuXuat_view() {
              return trangQuanLyPhieuXuat_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     public void run() {
                            getTrangQuanLyPhieuXuat_view().refresh_table();
                     }
              }).start();
       }
}
