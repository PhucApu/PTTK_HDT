package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnXoa extends MouseAdapter  {
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;

       public controller_btnXoa(TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
       }
       public TrangQuanLyPhieuNhap_view getTrangQuanLyPhieuNhap_view() {
              return trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {Sys.Sound_Click();
                            getTrangQuanLyPhieuNhap_view().XoaPhieu_Frame();
                     }
              }).start();
       }
}
