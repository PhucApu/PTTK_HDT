package TrangQuanLyPhieuKiem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_ClickTable extends MouseAdapter {
       private TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view;

       public controller_ClickTable(TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view) {
              this.trangQuanLyPhieuKiem_view = trangQuanLyPhieuKiem_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              this.trangQuanLyPhieuKiem_view.Click_table();
       }
}
