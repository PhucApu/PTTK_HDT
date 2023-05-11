package TrangQuanLyPhieuXuat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DTO.Sys;

public class controller_btnXemPX extends MouseAdapter{
       private TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view;
	public controller_btnXemPX(TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view) {
		this.trangQuanLyPhieuXuat_view = trangQuanLyPhieuXuat_view;
	}
	public TrangQuanLyPhieuXuat_view getTrangQuanLyPhieuXuat_view() {
              return trangQuanLyPhieuXuat_view;
       }
	@Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sys.Sound_Click();
				if(getTrangQuanLyPhieuXuat_view().getCheck_open_Jrame() == 0) {
					getTrangQuanLyPhieuXuat_view().setCheck_open_Jrame(1);
					getTrangQuanLyPhieuXuat_view().XemPhieuXuat_Frame();
				}
				else if(getTrangQuanLyPhieuXuat_view().getCheck_open_Jrame() == 2) {
					// JOptionPane.showConfirmDialog(null, "ĐANG MỞ XÁC NHẬN PHIẾU", "Thông báo", JOptionPane.ERROR_MESSAGE);
					Sys.Warning_dialog("ĐANG MỞ XÁC NHẬN PHIẾU");Sys.Sound_Error();
				}
				
			}
		}).start();
	}
}
