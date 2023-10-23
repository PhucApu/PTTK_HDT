package TrangQuanLyHoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_btnChonVi extends MouseAdapter{
       private ThemHoaDon_Frame themHoaDon_Frame;

       public controller_btnChonVi(ThemHoaDon_Frame themHoaDon_Frame) {
              this.themHoaDon_Frame = themHoaDon_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              themHoaDon_Frame.btnChonVi();
       }
}
