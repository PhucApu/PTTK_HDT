package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_XemHDFrame extends MouseAdapter{
       private TrangQuanLyHoaDon_view trangQuanLyHoaDon_view;
       private XemHoaDon_Frame xemHoaDon_Frame;
       public controller_btnThoat_XemHDFrame(TrangQuanLyHoaDon_view trangQuanLyHoaDon_view, XemHoaDon_Frame xemHoaDon_Frame) {
              this.trangQuanLyHoaDon_view = trangQuanLyHoaDon_view;
              this.xemHoaDon_Frame = xemHoaDon_Frame;
       }
       public TrangQuanLyHoaDon_view getTrangQuanLyHoaDon_view() {
              return trangQuanLyHoaDon_view;
       }
       public XemHoaDon_Frame getXemHoaDon_Frame() {
              return xemHoaDon_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyHoaDon_view().setCheck_open_Jrame(0);
                            getXemHoaDon_Frame().setVisible(false);
                            getXemHoaDon_Frame().dispose();
                     }
              }).start();
       }
}
