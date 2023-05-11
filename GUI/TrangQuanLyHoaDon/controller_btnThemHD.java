package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;


public class controller_btnThemHD extends MouseAdapter {
       private TrangQuanLyHoaDon_view trangQuanLyHoaDon_view;

       public controller_btnThemHD(TrangQuanLyHoaDon_view trangQuanLyHoaDon_view) {
              this.trangQuanLyHoaDon_view = trangQuanLyHoaDon_view;
       }
       public TrangQuanLyHoaDon_view getTrangQuanLyHoaDon_view() {
              return trangQuanLyHoaDon_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 0){
                                   getTrangQuanLyHoaDon_view().setCheck_open_Jrame(2);
                                   getTrangQuanLyHoaDon_view().ThemHoaDon_Frame();
                            }
                            else if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 1){
                                   // JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM HÓA ĐƠN", "Thông báo",
					// 	JOptionPane.ERROR_MESSAGE);
                                   Sys.Sound_Error();
                                   Sys.Warning_dialog("ĐANG MỞ XEM HÓA ĐƠN");
                            }
                            else if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 3){
                                   // JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA HÓA ĐƠN", "Thông báo",
					// 	JOptionPane.ERROR_MESSAGE);
                                   Sys.Sound_Error();
                                   Sys.Warning_dialog("ĐANG MỞ SỬA HÓA ĐƠN");
                            }
                     }
              }).start();
       }
}
