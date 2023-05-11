package TrangQuanLyHoaDon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_TimKiemSPDanhMuc_ThemHDFrame implements ActionListener {
       private ThemHoaDon_Frame themHoaDon_Frame;

       public controller_TimKiemSPDanhMuc_ThemHDFrame(ThemHoaDon_Frame themHoaDon_Frame) {
              this.themHoaDon_Frame = themHoaDon_Frame;
       }
       @Override
       public void actionPerformed(ActionEvent e) {
              this.themHoaDon_Frame.TimKiemSP_DanhMuc();
              
       }

}
