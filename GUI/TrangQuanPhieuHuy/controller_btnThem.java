package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThem extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;

       public controller_btnThem(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
       }

       public TrangQuanLyPhieuHuy getTrangQuanLyPhieuHuy() {
              return trangQuanLyPhieuHuy;
       }
       
       @Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sys.Sound_Click();
				if(getTrangQuanLyPhieuHuy().getCheck_open_Jrame() == 0) {
					getTrangQuanLyPhieuHuy().setCheck_open_Jrame(2);
					getTrangQuanLyPhieuHuy().ThemPhieuHuy_Frame();
				}
				else if(getTrangQuanLyPhieuHuy().getCheck_open_Jrame() == 1) {Sys.Sound_Error();
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ XEM PHIẾU");
				}
				else if(getTrangQuanLyPhieuHuy().getCheck_open_Jrame() == 3) {Sys.Sound_Error();
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ SỬA PHIẾU");
				}
				
			}
		}).start();
	}
}
