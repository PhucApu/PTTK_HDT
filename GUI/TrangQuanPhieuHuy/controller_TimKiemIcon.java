package TrangQuanPhieuHuy;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_TimKiemIcon extends MouseAdapter{
       private TrangQuanLyPhieuHuy trangQuanLyPhieuXuat_view;

       public controller_TimKiemIcon(TrangQuanLyPhieuHuy trangQuanLyPhieuXuat_view) {
              this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
       }
       public TrangQuanLyPhieuHuy getTrangQuanLyPhieuXuat_view() {
              return trangQuanLyPhieuXuat_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyPhieuXuat_view().TimKiem();
                     }
              }).start();
       }
}