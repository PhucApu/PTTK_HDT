package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnSua_SuaNCCFrame extends MouseAdapter{
       private SuaNhaCC_Frame suaNhaCC_Frame;
       private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
       public controller_btnSua_SuaNCCFrame(SuaNhaCC_Frame suaNhaCC_Frame,TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
              this.suaNhaCC_Frame = suaNhaCC_Frame;
              this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.suaNhaCC_Frame.Sua();
              this.trangQuanLyNhaCC_view.setCheck_open_Jrame(0);
       }
       
}
