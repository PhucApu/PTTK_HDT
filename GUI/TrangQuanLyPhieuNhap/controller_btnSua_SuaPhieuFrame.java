package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnSua_SuaPhieuFrame extends MouseAdapter {
       private SuaPhieuNhap_Frame suaPhieuNhap_Frame;
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
       public controller_btnSua_SuaPhieuFrame(SuaPhieuNhap_Frame suaPhieuNhap_Frame, TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
              this.suaPhieuNhap_Frame = suaPhieuNhap_Frame;
       }
       public SuaPhieuNhap_Frame getSuaPhieuNhap_Frame() {
              return suaPhieuNhap_Frame;
       }
       public TrangQuanLyPhieuNhap_view getTrangQuanLyPhieuNhap_view() {
              return trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getTrangQuanLyPhieuNhap_view().setCheck_open_Jrame(0);
                            getSuaPhieuNhap_Frame().SuaThongTinPhieu_Check();
                     }
              }).start();
       }
}
