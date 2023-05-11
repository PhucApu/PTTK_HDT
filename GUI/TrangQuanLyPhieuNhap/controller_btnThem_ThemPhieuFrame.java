package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThem_ThemPhieuFrame extends MouseAdapter {
       private ThemPhieuNhap_Frame themPhieuNhap_Frame;
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;

       public controller_btnThem_ThemPhieuFrame(ThemPhieuNhap_Frame themPhieuNhap_Frame,
                     TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.themPhieuNhap_Frame = themPhieuNhap_Frame;
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
       }

       public ThemPhieuNhap_Frame getThemPhieuNhap_Frame() {
              return themPhieuNhap_Frame;
       }

       public TrangQuanLyPhieuNhap_view getTrangQuanLyPhieuNhap_view() {
              return trangQuanLyPhieuNhap_view;
       }

       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {Sys.Sound_Click();
                            getThemPhieuNhap_Frame().LayThongTinPhieu_Check();
                            getTrangQuanLyPhieuNhap_view().setCheck_open_Jrame(0);
                     }
              }).start();

       }
}
