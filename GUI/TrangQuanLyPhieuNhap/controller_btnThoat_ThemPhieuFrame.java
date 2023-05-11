package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_ThemPhieuFrame extends MouseAdapter{
       private ThemPhieuNhap_Frame themPhieuNhap_Frame;
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
       public controller_btnThoat_ThemPhieuFrame(ThemPhieuNhap_Frame themPhieuNhap_Frame,TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.themPhieuNhap_Frame = themPhieuNhap_Frame;
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuNhap_view.setCheck_open_Jrame(0);
              this.themPhieuNhap_Frame.setVisible(false);
              this.themPhieuNhap_Frame.dispose();
       }
}
