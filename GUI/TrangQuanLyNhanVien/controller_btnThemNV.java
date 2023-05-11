package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;
public class controller_btnThemNV extends MouseAdapter {
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;

       public controller_btnThemNV(TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
              this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
       }
       public TrangQuanLyNhanVien_view getTrangQuanLyNhanVien_view() {
              return trangQuanLyNhanVien_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            if(getTrangQuanLyNhanVien_view().getCheck_open_Jrame() == 0){
                                   getTrangQuanLyNhanVien_view().setCheck_open_Jrame(2);
                                   getTrangQuanLyNhanVien_view().ThemNV_Frame();
                            }
                            if(getTrangQuanLyNhanVien_view().getCheck_open_Jrame() == 1){
                                   // JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM NHÂN VIÊN", "Thông báo", JOptionPane.ERROR_MESSAGE);
                                   Sys.Warning_dialog("ĐANG MỞ XEM NHÂN VIÊN");
                                   Sys.Sound_Error();
                            }
                            if(getTrangQuanLyNhanVien_view().getCheck_open_Jrame() == 3){
                                   // JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA NHÂN VIÊN", "Thông báo", JOptionPane.ERROR_MESSAGE);
                                   Sys.Warning_dialog("ĐANG MỞ SỬA NHÂN VIÊN");Sys.Sound_Error();
                            }
                            
                     }
              }).start();      
       }
       
}
