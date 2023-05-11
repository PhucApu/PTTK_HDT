package TrangQuanLyKho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_SuaFrame extends MouseAdapter {
       private TrangQuanLyKho_view trangQuanLyKho_view;
       private SuaSanPham_Frame suaSanPham_Frame;
       public controller_btnThoat_SuaFrame(TrangQuanLyKho_view trangQuanLyKho_view,
                     SuaSanPham_Frame suaSanPham_Frame) {
              this.trangQuanLyKho_view = trangQuanLyKho_view;
              this.suaSanPham_Frame = suaSanPham_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.suaSanPham_Frame.setVisible(false);
              this.suaSanPham_Frame.dispose();
              this.trangQuanLyKho_view.setCheck_open_Jrame(0);
       }
}
