package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnTKPhieuXuat extends MouseAdapter{
       private TrangThongKe_view trangThongKe_view;

       public controller_btnTKPhieuXuat(TrangThongKe_view trangThongKe_view) {
              this.trangThongKe_view = trangThongKe_view;
       }
       public TrangThongKe_view getTrangThongKe_view() {
              return trangThongKe_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            if(getTrangThongKe_view().getCheck_open_Jrame() == 0){
                                   getTrangThongKe_view().setCheck_open_Jrame(1);
                                   getTrangThongKe_view().btn_ThongKePhieuXuat();
                            }
                            else {
                                   Sys.Warning_dialog("ĐANG MỞ THỐNG KÊ KHÁC");
                                   Sys.Sound_Error();
                            }

                     }
              }).start();
       }
}
