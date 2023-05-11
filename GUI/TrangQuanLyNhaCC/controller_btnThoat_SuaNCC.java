package TrangQuanLyNhaCC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnThoat_SuaNCC extends MouseAdapter {
	private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
	private SuaNhaCC_Frame suaNhaCC_Frame;
	public controller_btnThoat_SuaNCC(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view,SuaNhaCC_Frame suaNhaCC_Frame) {
		this.suaNhaCC_Frame = suaNhaCC_Frame;
		this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Sys.Sound_Click();
		this.suaNhaCC_Frame.setVisible(false);
		this.suaNhaCC_Frame.dispose();
		this.trangQuanLyNhaCC_view.setCheck_open_Jrame(0);
	}
}
