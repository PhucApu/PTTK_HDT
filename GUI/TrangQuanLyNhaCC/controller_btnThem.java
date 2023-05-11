package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnThem extends MouseAdapter {
	private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
	public controller_btnThem(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
		this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
	}
	public TrangQuanLyNhaCC_view getTrangQuanLyNhaCC_view() {
		return trangQuanLyNhaCC_view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Sys.Sound_Click();
		if(this.trangQuanLyNhaCC_view.getCheck_open_Jrame() == 0) {
			new Thread( new Runnable() {
				
				@Override
				public void run() {
					getTrangQuanLyNhaCC_view().setCheck_open_Jrame(1);
					getTrangQuanLyNhaCC_view().ThemNhaCC_Frame();
				}
			}).start();
		}
		else if(this.trangQuanLyNhaCC_view.getCheck_open_Jrame() == 1) {
			// JOptionPane.showConfirmDialog(null, "ĐANG MỞ THÊM NHÀ CUNG CẤP","CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("ĐANG MỞ THÊM NHÀ CUNG CẤP");
		}
		else if(this.trangQuanLyNhaCC_view.getCheck_open_Jrame() == 2) {
			// JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA NHÀ CUNG CẤP","CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("ĐANG MỞ SỬA NHÀ CUNG CẤP");
		}
		
	}
}
