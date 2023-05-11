package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_XoaAllCT_ThemHDFrame extends MouseAdapter {
       private ThemHoaDon_Frame themHoaDon_Frame;

       public controller_XoaAllCT_ThemHDFrame(ThemHoaDon_Frame themHoaDon_Frame) {
              this.themHoaDon_Frame = themHoaDon_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.themHoaDon_Frame.xoaCTHD_all();
       }
}
