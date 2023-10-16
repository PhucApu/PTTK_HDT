package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_refresh extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuXuat_view;

       public controller_refresh(TrangQuanLyPhieuHuy trangQuanLyPhieuXuat_view) {
              this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
       }
       public TrangQuanLyPhieuHuy getTrangQuanLyPhieuXuat_view() {
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