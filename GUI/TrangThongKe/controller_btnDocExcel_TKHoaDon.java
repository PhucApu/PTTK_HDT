package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class controller_btnDocExcel_TKHoaDon extends MouseAdapter {
       private ThongKeHoaDon thongKeHoaDon;

       public controller_btnDocExcel_TKHoaDon(ThongKeHoaDon thongKeHoaDon) {
              this.thongKeHoaDon = thongKeHoaDon;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              try {
                     thongKeHoaDon.btn_readExcelFile_and_check();
              } catch (IOException e1) {
                     e1.printStackTrace();
              }
       }

}