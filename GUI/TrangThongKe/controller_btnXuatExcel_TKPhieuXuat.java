package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class controller_btnXuatExcel_TKPhieuXuat extends MouseAdapter {
       private ThongKePhieuXuat thongKePhieuXuat;

       public controller_btnXuatExcel_TKPhieuXuat(ThongKePhieuXuat thongKePhieuXuat) {
              this.thongKePhieuXuat = thongKePhieuXuat;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              try {
                     thongKePhieuXuat.btn_xuatFile_Excel();
              } catch (IOException e1) {
                     e1.printStackTrace();
              }
       }

}
