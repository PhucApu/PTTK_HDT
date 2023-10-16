package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import DTO.Sys;

public class controller_btnThoat_XemPHFrame extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;
       private XemPhieuHetHan_Frame xemPhieuHetHan_Frame;
       public controller_btnThoat_XemPHFrame(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy,
                     XemPhieuHetHan_Frame xemPhieuHetHan_Frame) {
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
              this.xemPhieuHetHan_Frame = xemPhieuHetHan_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuHuy.setCheck_open_Jrame(0);
              this.xemPhieuHetHan_Frame.setVisible(false);
              this.xemPhieuHetHan_Frame.dispose();
       }
}
