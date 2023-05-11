package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThem_ThemNCCFrame extends MouseAdapter {
       private ThemNhaCC_Frame themNhaCC_Frame;
       private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
       public controller_btnThem_ThemNCCFrame(ThemNhaCC_Frame themNhaCC_Frame,TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
              this.themNhaCC_Frame = themNhaCC_Frame;
              this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
       }
       public ThemNhaCC_Frame getThemNhaCC_Frame() {
              return themNhaCC_Frame;
       }
       public TrangQuanLyNhaCC_view getTrangQuanLyNhaCC_view() {
              return trangQuanLyNhaCC_view;
       }
       @Override
       public void mouseClicked(MouseEvent arg0) {
              new Thread(new Runnable() {
                     @Override
                     public void run() {
                            Sys.Sound_Click();
                            getThemNhaCC_Frame().LayThongTinNCC_Check();
                            getTrangQuanLyNhaCC_view().setCheck_open_Jrame(0);
                     }
              }).start();
       }

}
