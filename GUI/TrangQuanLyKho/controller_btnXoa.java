package TrangQuanLyKho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnXoa extends MouseAdapter {
       private TrangQuanLyKho_view trangQuanLyKho_view;

       public controller_btnXoa(TrangQuanLyKho_view trangQuanLyKho_view) {
              this.trangQuanLyKho_view = trangQuanLyKho_view;
       }

       public TrangQuanLyKho_view getTrangQuanLyKho_view() {
              return trangQuanLyKho_view;
       }

       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              getTrangQuanLyKho_view().XoaSP_Frame();

       }
}
