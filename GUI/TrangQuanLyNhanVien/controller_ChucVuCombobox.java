package TrangQuanLyNhanVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_ChucVuCombobox implements ActionListener {
	private ThemNhanVien_Frame themNhanVien_Frame;
	public controller_ChucVuCombobox(ThemNhanVien_Frame themNhanVien_Frame) {
		this.themNhanVien_Frame = themNhanVien_Frame;
	}
	public ThemNhanVien_Frame getThemNhanVien_Frame() {
		return themNhanVien_Frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				getThemNhanVien_Frame().ThongtinLuong();
			}
		}).start();
		
	}
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				getThemNhanVien_Frame().ThongtinLuong();
//			}
//		}).start();
//	}
}
