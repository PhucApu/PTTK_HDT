package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_SuaNVFrame extends MouseAdapter {
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;
       private SuaNhanVien_Frame suaNhanVien_Frame;
       public controller_btnThoat_SuaNVFrame(SuaNhanVien_Frame suaNhanVien_Frame, TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
              this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
              this.suaNhanVien_Frame = suaNhanVien_Frame;
       }
       public TrangQuanLyNhanVien_view getTrangQuanLyNhanVien_view() {
              return trangQuanLyNhanVien_view;
       }
       public SuaNhanVien_Frame getSuaNhanVien_Frame() {
              return suaNhanVien_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              getTrangQuanLyNhanVien_view().setCheck_open_Jrame(0);
              getSuaNhanVien_Frame().setVisible(false);
              getSuaNhanVien_Frame().dispose();    
       }
}
