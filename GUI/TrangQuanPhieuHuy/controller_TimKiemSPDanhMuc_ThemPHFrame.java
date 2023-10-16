package TrangQuanPhieuHuy;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javafx.event.ActionEvent;

public class controller_TimKiemSPDanhMuc_ThemPHFrame implements ActionListener {
       private ThemPhieuHuy_Frame themPhieuHuy_Frame;

       public controller_TimKiemSPDanhMuc_ThemPHFrame(ThemPhieuHuy_Frame themPhieuHuy_Frame) {
              this.themPhieuHuy_Frame = themPhieuHuy_Frame;
       }
       @Override
       public void actionPerformed(java.awt.event.ActionEvent e) {
              this.themPhieuHuy_Frame.TimKiemSP_DanhMuc();
       }
}
