package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_SuaHDFrame extends MouseAdapter{
       private SuaHoaDon_Frame suaHoaDon_Frame;

       public controller_btnThoat_SuaHDFrame(SuaHoaDon_Frame suaHoaDon_Frame) {
              this.suaHoaDon_Frame = suaHoaDon_Frame;
       } 
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.suaHoaDon_Frame.btnThoat();
       }
}
