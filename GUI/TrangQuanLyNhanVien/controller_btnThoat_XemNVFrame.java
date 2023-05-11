package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_XemNVFrame extends MouseAdapter {
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;
       private XemNhanVien_Frame xemNhanVien_Frame;
       public controller_btnThoat_XemNVFrame(XemNhanVien_Frame xemNhanVien_Frame, TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
              this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
              this.xemNhanVien_Frame = xemNhanVien_Frame;
       }
       public TrangQuanLyNhanVien_view getTrangQuanLyNhanVien_view() {
              return trangQuanLyNhanVien_view;
       }
       public XemNhanVien_Frame getXemNhanVien_Frame() {
              return xemNhanVien_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              getTrangQuanLyNhanVien_view().setCheck_open_Jrame(0);
              getXemNhanVien_Frame().setVisible(false);
              getXemNhanVien_Frame().dispose();    
       }
}
