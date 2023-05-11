package TrangQuanLyKho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnXem extends MouseAdapter {
       private TrangQuanLyKho_view trangQuanLyKho_view;

       public controller_btnXem(TrangQuanLyKho_view trangQuanLyKho_view) {
              this.trangQuanLyKho_view = trangQuanLyKho_view;
       }
       public TrangQuanLyKho_view getTrangQuanLyKho_view() {
              return trangQuanLyKho_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              if(getTrangQuanLyKho_view().getCheck_open_Jrame() == 0){
                     getTrangQuanLyKho_view().XemSP_Frame();
                     getTrangQuanLyKho_view().setCheck_open_Jrame(1);
              }
              else{
                     Sys.Sound_Error();
                     Sys.Warning_dialog("ĐANG MỞ TRANG KHÁC");
              }
       }
}
