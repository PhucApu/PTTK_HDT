package TrangThongKe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class controller_btnXuatExcel_TKHoaDon extends MouseAdapter {
       private ThongKeHoaDon thongKeHoaDon;

       public controller_btnXuatExcel_TKHoaDon(ThongKeHoaDon thongKeHoaDon) {
              this.thongKeHoaDon = thongKeHoaDon;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              try {
                     thongKeHoaDon.btn_xuatFile_Excel();
              } catch (IOException e1) {
                     e1.printStackTrace();
              }
       }

}
