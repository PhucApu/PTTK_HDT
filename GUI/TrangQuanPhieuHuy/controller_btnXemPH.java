package TrangQuanPhieuHuy;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;
import TrangQuanLyPhieuXuat.TrangQuanLyPhieuXuat_view;
public class controller_btnXemPH extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;
       public controller_btnXemPH(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
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
					getTrangQuanLyPhieuHuy().setCheck_open_Jrame(1);
					getTrangQuanLyPhieuHuy().XemPhieuXuat_Frame();
				}
				else if(getTrangQuanLyPhieuHuy().getCheck_open_Jrame() == 2) {
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ XÁC NHẬN PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ XÁC NHẬN PHIẾU");Sys.Sound_Error();
				}
				
			}
		}).start();
	}
}
