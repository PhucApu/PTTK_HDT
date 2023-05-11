package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_TimKiem extends MouseAdapter {
       private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;

       public controller_TimKiem(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
              this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
       }
       public TrangQuanLyNhaCC_view getTrangQuanLyNhaCC_view() {
              return trangQuanLyNhaCC_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                           getTrangQuanLyNhaCC_view().TimKiem_NCC(); 
                     }
              }).start();      
       }
}
