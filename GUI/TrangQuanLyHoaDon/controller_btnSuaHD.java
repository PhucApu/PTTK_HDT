package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnSuaHD extends MouseAdapter {
       private TrangQuanLyHoaDon_view trangQuanLyHoaDon_view;

       public controller_btnSuaHD(TrangQuanLyHoaDon_view trangQuanLyHoaDon_view) {
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
                                   getTrangQuanLyHoaDon_view().setCheck_open_Jrame(3);

                                   
                                   new Thread( new Runnable() {
                                          @Override
                                          public void run() {
                                                 System.out.println("hell");
                                          }
                                   }).start();
                                   if( getTrangQuanLyHoaDon_view().Click_table().getTinhTrang().equals("Đang chờ xác nhận")){
                                          System.out.println("hello");
                                          getTrangQuanLyHoaDon_view().SuaHoaDon_Frame();
                                   }
                                   else if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 1){
                                          // JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM HÓA ĐƠN", "Thông báo",
                                          // 	JOptionPane.ERROR_MESSAGE);
                                          Sys.Sound_Error();
                                          Sys.Warning_dialog("ĐANG MỞ XEM HÓA ĐƠN");
                                   }
                                   else if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 2){
                                          Sys.Sound_Error();
                                          // JOptionPane.showConfirmDialog(null, "ĐANG MỞ THÊM HÓA ĐƠN", "Thông báo",
                                          // 	JOptionPane.ERROR_MESSAGE);
                                          Sys.Warning_dialog("ĐANG MỞ THÊM HÓA ĐƠN");
                                   }
                            }
                            else if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 1){
                                   // JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM HÓA ĐƠN", "Thông báo",
					// 	JOptionPane.ERROR_MESSAGE);
                                   Sys.Sound_Error();
                                   Sys.Warning_dialog("ĐANG MỞ XEM HÓA ĐƠN");
                            }
                            else if(getTrangQuanLyHoaDon_view().getCheck_open_Jrame() == 2){
                                   Sys.Sound_Error();
                                   // JOptionPane.showConfirmDialog(null, "ĐANG MỞ THÊM HÓA ĐƠN", "Thông báo",
					// 	JOptionPane.ERROR_MESSAGE);
                                   Sys.Warning_dialog("ĐANG MỞ THÊM HÓA ĐƠN");
                            }
                     }
              }).start();
       }
}
