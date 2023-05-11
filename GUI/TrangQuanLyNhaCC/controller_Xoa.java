package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_Xoa extends MouseAdapter {
       private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;

       public controller_Xoa(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
              this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.trangQuanLyNhaCC_view.XoaNhaCc_Frame();
       }
}
