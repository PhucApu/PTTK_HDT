package TrangQuanLyKho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.Sys;

public class controller_btnSua_SuaFrame extends MouseAdapter {
       private SuaSanPham_Frame suaSanPham_Frame;
       public controller_btnSua_SuaFrame(SuaSanPham_Frame suaSanPham_Frame) {
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
                            Sys.Sound_Click();
                            getSuaSanPham_Frame().SuaSP_check();
                     }
              }).start();
       }
}
