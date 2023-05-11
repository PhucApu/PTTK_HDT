package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class controller_btnDocExcel_TKPhieuXuat extends MouseAdapter {
       private ThongKePhieuXuat thongKePhieuXuat;

       public controller_btnDocExcel_TKPhieuXuat(ThongKePhieuXuat thongKePhieuXuat) {
              this.thongKePhieuXuat = thongKePhieuXuat;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              try {
                     thongKePhieuXuat.btn_readExcelFile_and_check();
              } catch (IOException e1) {
                     e1.printStackTrace();
              }
       }

}
