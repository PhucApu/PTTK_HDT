package TrangQuanLyPhieuXuat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_ClickTable extends MouseAdapter {
       private TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view;

       public controller_ClickTable(TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view) {
              this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              this.trangQuanLyPhieuXuat_view.Click_table();
       }
}
