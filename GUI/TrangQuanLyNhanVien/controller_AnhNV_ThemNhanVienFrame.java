package TrangQuanLyNhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_AnhNV_ThemNhanVienFrame extends MouseAdapter {
	private ThemNhanVien_Frame themNhanVien_Frame;
	public controller_AnhNV_ThemNhanVienFrame(ThemNhanVien_Frame themNhanVien_Frame) {
		this.themNhanVien_Frame = themNhanVien_Frame;
	}
	public ThemNhanVien_Frame getThemNhanVien_Frame() {
		return themNhanVien_Frame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Sys.Sound_Click();
		this.themNhanVien_Frame.chonAnh();
	}
	
}
