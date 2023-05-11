package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;



public class controller_btnThoat_ThemNVFrame extends MouseAdapter {
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;
       private ThemNhanVien_Frame themNhanVien_Frame;
       public controller_btnThoat_ThemNVFrame(ThemNhanVien_Frame themNhanVien_Frame, TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
              this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
              this.themNhanVien_Frame = themNhanVien_Frame;
       }
       public TrangQuanLyNhanVien_view getTrangQuanLyNhanVien_view() {
              return trangQuanLyNhanVien_view;
       }
       public ThemNhanVien_Frame getThemNhanVien_Frame() {
              return themNhanVien_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              getTrangQuanLyNhanVien_view().setCheck_open_Jrame(0);
              getThemNhanVien_Frame().setVisible(false);
              getThemNhanVien_Frame().dispose();    
       }
}
