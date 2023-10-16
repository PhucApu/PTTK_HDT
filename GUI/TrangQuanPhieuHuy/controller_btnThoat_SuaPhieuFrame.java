package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_SuaPhieuFrame extends MouseAdapter {
       private SuaPhieuHuy_Frame suaPhieuHuy_Frame;
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;
       public controller_btnThoat_SuaPhieuFrame(SuaPhieuHuy_Frame suaPhieuHuy_Frame,
                     TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
              this.suaPhieuHuy_Frame = suaPhieuHuy_Frame;
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
       }
       @Override
       public void mouseClicked(MouseEvent e) {Sys.Sound_Click();
              this.trangQuanLyPhieuHuy.setCheck_open_Jrame(0);
              this.suaPhieuHuy_Frame.setVisible(false);
              this.suaPhieuHuy_Frame.dispose();
       }
}
