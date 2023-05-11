package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_XemPhieuFrame extends MouseAdapter {
       private XemPhieuNhap_Frame xemPhieuNhap_Frame;
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
       public controller_btnThoat_XemPhieuFrame(XemPhieuNhap_Frame xemPhieuNhap_Frame,TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.xemPhieuNhap_Frame = xemPhieuNhap_Frame;
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuNhap_view.setCheck_open_Jrame(0);
              this.xemPhieuNhap_Frame.setVisible(false);
              this.xemPhieuNhap_Frame.dispose();
       }
       
}
