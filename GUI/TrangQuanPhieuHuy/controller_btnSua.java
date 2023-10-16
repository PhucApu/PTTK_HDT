package TrangQuanPhieuHuy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnSua extends MouseAdapter {
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;
	public controller_btnSua(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
		this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
	}
	public TrangQuanLyPhieuHuy getTrangQuanLyPhieuHuy_view() {
		return trangQuanLyPhieuHuy;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sys.Sound_Click();
				if(getTrangQuanLyPhieuHuy_view().getCheck_open_Jrame() == 0) {Sys.Sound_Click();
					getTrangQuanLyPhieuHuy_view().setCheck_open_Jrame(3);
					getTrangQuanLyPhieuHuy_view().SuaPhieuHuy_Frame();
				}
				else if(getTrangQuanLyPhieuHuy_view().getCheck_open_Jrame() == 1) {Sys.Sound_Error();
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ XEM PHIẾU");
				}
				else if(getTrangQuanLyPhieuHuy_view().getCheck_open_Jrame() == 2) {Sys.Sound_Error();
					// JOptionPane.showConfirmDialog(null, "ĐANG THÊM SỬA PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG THÊM SỬA PHIẾU");
				}
				
			}
		}).start();
	}
}

