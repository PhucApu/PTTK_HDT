package TrangQuanLyKho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller_LoaiSPCombobox implements ActionListener {
	private SuaSanPham_Frame suaSanPham_Frame;
	public controller_LoaiSPCombobox(SuaSanPham_Frame suaSanPham_Frame) {
		this.suaSanPham_Frame = suaSanPham_Frame;
	}
	public SuaSanPham_Frame getSuaSanPham_Frame() {
		return suaSanPham_Frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				getSuaSanPham_Frame().ThuocTinhSP();
				
			}
		}).start();
		
	}
}
