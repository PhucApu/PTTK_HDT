package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_ClickTable extends MouseAdapter {
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;

       public controller_ClickTable(TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
              this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              this.trangQuanLyNhanVien_view.Click_table();
       }
}
