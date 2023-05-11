package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_ThemNCCFrame extends MouseAdapter {
	private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
	private ThemNhaCC_Frame themNhaCC_Frame;
	public controller_btnThoat_ThemNCCFrame(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view,ThemNhaCC_Frame themNhaCC_Frame) {
		this.themNhaCC_Frame = themNhaCC_Frame;
		this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Sys.Sound_Click();
		this.themNhaCC_Frame.setVisible(false);
		this.themNhaCC_Frame.dispose();
		this.trangQuanLyNhaCC_view.setCheck_open_Jrame(0);
	}
}
