package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_SuaPhieuFrame extends MouseAdapter {
       private SuaPhieuNhap_Frame suaPhieuNhap_Frame;
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
       public controller_btnThoat_SuaPhieuFrame(SuaPhieuNhap_Frame suaPhieuNhap_Frame,TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.suaPhieuNhap_Frame = suaPhieuNhap_Frame;
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuNhap_view.setCheck_open_Jrame(0);
              this.suaPhieuNhap_Frame.setVisible(false);
              this.suaPhieuNhap_Frame.dispose();
       }
}
