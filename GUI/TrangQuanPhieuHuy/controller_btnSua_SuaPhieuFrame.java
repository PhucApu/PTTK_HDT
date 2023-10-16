package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnSua_SuaPhieuFrame extends MouseAdapter {
       private SuaPhieuHuy_Frame suaPhieuHuy_Frame;
       private TrangQuanLyPhieuHuy trangQuanLyPhieuNhap_view;
       public controller_btnSua_SuaPhieuFrame(SuaPhieuHuy_Frame suaPhieuNhap_Frame, TrangQuanLyPhieuHuy trangQuanLyPhieuNhap_view) {
              this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
              this.suaPhieuHuy_Frame = suaPhieuNhap_Frame;
       }
       public SuaPhieuHuy_Frame getSuaPhieuHuy_Frame() {
              return suaPhieuHuy_Frame;
       }
       public TrangQuanLyPhieuHuy get_TrangQuanLyPhieuHuy() {
              return trangQuanLyPhieuNhap_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            get_TrangQuanLyPhieuHuy().setCheck_open_Jrame(0);
                            getSuaPhieuHuy_Frame().SuaThongTinPhieu_Check();
                     }
              }).start();
       }
}
