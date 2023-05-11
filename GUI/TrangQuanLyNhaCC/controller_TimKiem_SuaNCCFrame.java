package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_TimKiem_SuaNCCFrame extends MouseAdapter {
       private SuaNhaCC_Frame suaNhaCC_Frame;

       public controller_TimKiem_SuaNCCFrame(SuaNhaCC_Frame suaNhaCC_Frame) {
              this.suaNhaCC_Frame = suaNhaCC_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              Sys.Sound_Click();
              this.suaNhaCC_Frame.TimKiem();;
       }
}
