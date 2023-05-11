package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_AnhVn_SuaNhanVienFrame extends MouseAdapter {
	private SuaNhanVien_Frame suaNhanVien_Frame;
	public controller_AnhVn_SuaNhanVienFrame(SuaNhanVien_Frame suaNhanVien_Frame) {
		this.suaNhanVien_Frame = suaNhanVien_Frame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Sys.Sound_Click();
		this.suaNhanVien_Frame.chonAnh();
	}
}
