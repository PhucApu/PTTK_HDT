package TrangQuanPhieuHuy;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnXacNhanPH  extends MouseAdapter{
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;

       public controller_btnXacNhanPH(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
       }
       public TrangQuanLyPhieuHuy getTrangQuanLyPhieuHuy(){
              return trangQuanLyPhieuHuy;
       }
       @Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sys.Sound_Click();
					getTrangQuanLyPhieuHuy().Xuatkho_Frame();
				
				
			}
		}).start();
	}
}
