package TrangQuanLyPhieuKiem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnXem extends MouseAdapter {
       private TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view;

       public controller_btnXem(TrangQuanLyPhieuKiem_view trangQuanLyPhieuKiem_view) {
              this.trangQuanLyPhieuKiem_view = trangQuanLyPhieuKiem_view;
       }

       public TrangQuanLyPhieuKiem_view getTrangQuanLyPhieuKiem_view() {
              return trangQuanLyPhieuKiem_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            getTrangQuanLyPhieuKiem_view().XemPhieuKiem_Frame();
                            
                     }
              }).start();
       }
}
