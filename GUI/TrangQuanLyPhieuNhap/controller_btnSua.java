package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnSua extends MouseAdapter {
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
	public controller_btnSua(TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
		this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
	}
	public TrangQuanLyPhieuNhap_view getTrangQuanLyPhieuNhap_view() {
		return trangQuanLyPhieuNhap_view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sys.Sound_Click();
				if(getTrangQuanLyPhieuNhap_view().getCheck_open_Jrame() == 0) {Sys.Sound_Click();
					getTrangQuanLyPhieuNhap_view().setCheck_open_Jrame(3);
					getTrangQuanLyPhieuNhap_view().SuaPhieuNhap_Frame();
				}
				else if(getTrangQuanLyPhieuNhap_view().getCheck_open_Jrame() == 1) {Sys.Sound_Error();
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ XEM PHIẾU");
				}
				else if(getTrangQuanLyPhieuNhap_view().getCheck_open_Jrame() == 2) {Sys.Sound_Error();
					// JOptionPane.showConfirmDialog(null, "ĐANG THÊM SỬA PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG THÊM SỬA PHIẾU");
				}
				
			}
		}).start();
	}
}
