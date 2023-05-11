package TrangQuanLyKho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_XemSPFrame extends MouseAdapter {
       private TrangQuanLyKho_view trangQuanLyKho_view;
       private XemSanPham_Frame xemSanPham_Frame;
       public controller_btnThoat_XemSPFrame(TrangQuanLyKho_view trangQuanLyKho_view,
                     XemSanPham_Frame xemSanPham_Frame) {
              this.trangQuanLyKho_view = trangQuanLyKho_view;
              this.xemSanPham_Frame = xemSanPham_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.xemSanPham_Frame.setVisible(false);
              this.xemSanPham_Frame.dispose();
              this.trangQuanLyKho_view.setCheck_open_Jrame(0);
       }
}
