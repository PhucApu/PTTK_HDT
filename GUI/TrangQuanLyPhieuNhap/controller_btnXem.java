package TrangQuanLyPhieuNhap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnXem extends MouseAdapter {
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
	public controller_btnXem(TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
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
				if(getTrangQuanLyPhieuNhap_view().getCheck_open_Jrame() == 0) {
					getTrangQuanLyPhieuNhap_view().setCheck_open_Jrame(1);
					getTrangQuanLyPhieuNhap_view().XemPhieuNhap_Frame();
				}
				else if(getTrangQuanLyPhieuNhap_view().getCheck_open_Jrame() == 2) {
					// JOptionPane.showConfirmDialog(null, "ĐANG THÊM XEM PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG THÊM XEM PHIẾU");Sys.Sound_Error();
				}
				
				else if(getTrangQuanLyPhieuNhap_view().getCheck_open_Jrame() == 3) {
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ SỬA PHIẾU");Sys.Sound_Error();
				}
				
			}
		}).start();
	}
}
