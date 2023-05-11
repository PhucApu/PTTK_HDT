package TrangThongKe;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class controller_btnDocExcel_TKPhieuNhap extends MouseAdapter {
       private ThongKePhieuNhap thongKePhieuNhap;

       public controller_btnDocExcel_TKPhieuNhap(ThongKePhieuNhap thongKePhieuNhap) {
              this.thongKePhieuNhap = thongKePhieuNhap;
       }
       public ThongKePhieuNhap getThongKePhieuNhap() {
              return thongKePhieuNhap;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              try {
                     thongKePhieuNhap.btn_readExcelFile_and_check();
              } catch (IOException e1) {
                     e1.printStackTrace();
              }
       }

}
