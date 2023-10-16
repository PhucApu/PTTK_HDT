package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_ClickTable extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;

       public controller_ClickTable(TrangQuanLyPhieuHuy trangQuanLyPhieuXuat_view) {
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuXuat_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              this.trangQuanLyPhieuHuy.Click_table();
       }
}
