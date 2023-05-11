package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_ClickTabel extends MouseAdapter {
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;

       public controller_ClickTabel(TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              this.trangQuanLyPhieuNhap_view.Click_table();
       }
}
