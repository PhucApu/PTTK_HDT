package TrangQuanLyKho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controller_AnhSP_SuaSPFrame  extends MouseAdapter{
       private SuaSanPham_Frame suaSanPham_Frame;

       public controller_AnhSP_SuaSPFrame(SuaSanPham_Frame suaSanPham_Frame) {
              this.suaSanPham_Frame = suaSanPham_Frame;
       }
       public SuaSanPham_Frame getSuaSanPham_Frame() {
              return suaSanPham_Frame;
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              new Thread( new Runnable() {
                     @Override
                     public void run() {
                            getSuaSanPham_Frame().chonAnh();
                     }
              }).start();
       }
}
