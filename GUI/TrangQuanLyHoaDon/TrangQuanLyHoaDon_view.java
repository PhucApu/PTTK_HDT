package TrangQuanLyHoaDon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

public class TrangQuanLyHoaDon_view extends JPanel {

       private DefaultTableModel model;
       private int width_max = 749; // contenPane - Menu = 1000 - 251
       private int height_max = 600;
       private JLabel UserIcon_label;
       private JLabel TenDN_label;
       private JLabel QLHoaDon_label;
       private JTextField textField;
       private Color mau_chu = new Color(97, 113, 67);
       private JLabel TimKiem_icon;
       private JScrollPane scrollPane;
       private JTable table;
       private button_custom btn_Them;
       private button_custom btn_Xoa;
       private button_custom btn_Xem;
       private JLabel Refresh_icon;
       private int check_open_Jrame = 0;
       private float tienkhachdua = 0;
       private button_custom btn_Sua;

       private StaffDTO staff;
       private ListProductsBUS listProducts;
       private DanhSachHDBUS danhSachHD;
       private dsPhieuXuatBUS dsPhieuXuat;

       public TrangQuanLyHoaDon_view(StaffDTO staff, DanhSachHDBUS danhSachHD, ListProductsBUS listProducts,
                     dsPhieuXuatBUS dsPhieuXuat) {
              this.staff = staff;
              this.listProducts = listProducts;
              this.danhSachHD = danhSachHD;
              this.dsPhieuXuat = dsPhieuXuat;

              setSize(width_max, height_max);
              setBackground(new Color(246, 225, 195));
              setLayout(null);

              UserIcon_label = new JLabel("", JLabel.CENTER);
              UserIcon_label.setIcon(new ImageIcon("image_icon\\user.png"));
              UserIcon_label.setBounds(584, 10, 40, 40);
              add(UserIcon_label);

              TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
              TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
              TenDN_label.setBounds(618, 10, 121, 30);
              add(TenDN_label);

              QLHoaDon_label = new JLabel("QUẢN LÝ HÓA ĐƠN", SwingConstants.CENTER);
              QLHoaDon_label.setForeground(new Color(97, 113, 67));
              QLHoaDon_label.setFont(new Font("Tahoma", Font.BOLD, 35));
              QLHoaDon_label.setBounds(60, 48, 630, 40);
              add(QLHoaDon_label);

              textField = new JTextField();
              textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
              textField.setColumns(10);
              textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
              textField.setBounds(135, 98, 420, 30);
              add(textField);

              TimKiem_icon = new JLabel("");
              TimKiem_icon.setIcon(new ImageIcon("image_icon\\search.png"));
              TimKiem_icon.setBounds(565, 96, 32, 32);
              add(TimKiem_icon);

              scrollPane = new JScrollPane();
              scrollPane.setBounds(60, 155, 600, 300);
              add(scrollPane);

              table = new JTable();
              table.setShowVerticalLines(false);
              table.setModel(new DefaultTableModel(
                            new Object[][] {
                            },
                            new String[] {
                                          "ID HÓA ĐƠN", "ID NHÂN VIÊN", "NGÀY TẠO", "TÌNH TRẠNG", "TỔNG TIỀN"
                            }) {
                     boolean[] columnEditables = new boolean[] {
                                   false, false, false, false, false
                     };

                     public boolean isCellEditable(int row, int column) {
                            return columnEditables[column];
                     }
              });
              table.getColumnModel().getColumn(0).setResizable(false);
              table.getColumnModel().getColumn(1).setResizable(false);
              table.getColumnModel().getColumn(2).setResizable(false);
              table.getColumnModel().getColumn(3).setResizable(false);
              table.getColumnModel().getColumn(4).setResizable(false);

              // chinh sua table
              table.setBackground(Color.white);
              table.getTableHeader().setBackground(new Color(32, 136, 203));
              table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
              table.setFont(new Font("Tahoma", Font.BOLD, 12));
              table.getTableHeader().setForeground(Color.white);
              table.setSelectionBackground(new Color(232, 57, 95));

              table.setRowHeight(22);
              scrollPane.setViewportView(table);

              btn_Them = new button_custom("THÊM");
              btn_Them.setIcon(new ImageIcon("image_icon\\add.png"));
              btn_Them.setRadius(10);
              btn_Them.setForeground(Color.WHITE);
              btn_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Them.setBorderPainted(false);
              btn_Them.setBounds(169, 498, 121, 35);
              add(btn_Them);

              btn_Xoa = new button_custom("XÓA");
              btn_Xoa.setIcon(new ImageIcon("image_icon\\invoice_delete.png"));
              btn_Xoa.setRadius(10);
              btn_Xoa.setForeground(Color.WHITE);
              btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Xoa.setBorderPainted(false);
              btn_Xoa.setBounds(315, 498, 113, 35);
              add(btn_Xoa);

              btn_Sua = new button_custom("SỬA");
              btn_Sua.setIcon(new ImageIcon("image_icon\\searching.png"));
              btn_Sua.setRadius(10);
              btn_Sua.setForeground(Color.WHITE);
              btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Sua.setBorderPainted(false);
              btn_Sua.setBounds(453, 498, 113, 35);
              add(btn_Sua);

              Refresh_icon = new JLabel("");
              Refresh_icon.setIcon(new ImageIcon("image_icon\\refresh.png"));
              Refresh_icon.setBounds(670, 437, 32, 32);
              add(Refresh_icon);

              button_custom btn_XacNhan = new button_custom("XÁC NHẬN");
              btn_XacNhan.setText("");
              btn_XacNhan.setIcon(new ImageIcon("image_icon\\pay.png"));
              btn_XacNhan.setRadius(10);
              btn_XacNhan.setForeground(Color.WHITE);
              btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_XacNhan.setBorderPainted(false);
              btn_XacNhan.setBounds(592, 498, 121, 35);
              add(btn_XacNhan);

              btn_Xem = new button_custom("XEM");
              btn_Xem.setIcon(new ImageIcon("image_icon\\invoice.png"));
              btn_Xem.setRadius(10);
              btn_Xem.setForeground(Color.WHITE);
              btn_Xem.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Xem.setBorderPainted(false);
              btn_Xem.setBounds(36, 498, 113, 35);
              add(btn_Xem);

              TenDN(staff);
              Load_DSHoaDon_from_data_toTable();

              // controller
              // controller_TimKiemHD controller_TimKiemHD = new controller_TimKiemHD(this);
              TimKiem_icon.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          TimKiem();
                                   }
                            }).start();
                     }
              });
              // controller_refresh controller_refresh = new controller_refresh(this);
              Refresh_icon.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          refresh_table();
                                   }
                            }).start();
                     }
              });

              // controller_btnXemHD controller_btnXemHD = new controller_btnXemHD(this);
              btn_Xem.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          if (getCheck_open_Jrame() == 0) {
                                                 setCheck_open_Jrame(1);
                                                 XemHoaDon_Frame();
                                          } else if (getCheck_open_Jrame() == 2) {
                                                 // JOptionPane.showConfirmDialog(null, "ĐANG MỞ THÊM HÓA ĐƠN", "Thông
                                                 // báo",
                                                 // JOptionPane.ERROR_MESSAGE);
                                                 Sys.Sound_Error();
                                                 Sys.Warning_dialog("ĐANG MỞ THÊM HÓA ĐƠN");
                                          } else if (getCheck_open_Jrame() == 3) {
                                                 // JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA HÓA ĐƠN", "Thông
                                                 // báo",
                                                 // JOptionPane.ERROR_MESSAGE);
                                                 Sys.Sound_Error();
                                                 Sys.Warning_dialog("ĐANG MỞ SỬA HÓA ĐƠN");
                                          }
                                   }
                            }).start();
                     }
              });
              // controller_btnThemHD controller_btnThemHD = new controller_btnThemHD(this);
              btn_Them.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          if (getCheck_open_Jrame() == 0) {
                                                 setCheck_open_Jrame(2);
                                                 ThemHoaDon_Frame();
                                          } else if (getCheck_open_Jrame() == 1) {
                                                 // JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM HÓA ĐƠN", "Thông
                                                 // báo",
                                                 // JOptionPane.ERROR_MESSAGE);
                                                 Sys.Sound_Error();
                                                 Sys.Warning_dialog("ĐANG MỞ XEM HÓA ĐƠN");
                                          } else if (getCheck_open_Jrame() == 3) {
                                                 // JOptionPane.showConfirmDialog(null, "ĐANG MỞ SỬA HÓA ĐƠN", "Thông
                                                 // báo",
                                                 // JOptionPane.ERROR_MESSAGE);
                                                 Sys.Sound_Error();
                                                 Sys.Warning_dialog("ĐANG MỞ SỬA HÓA ĐƠN");
                                          }
                                   }
                            }).start();
                     }
              });
              // controller_btnXoaHD controller_btnXoaHD = new controller_btnXoaHD(this);
              btn_Xoa.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          XoaHoaDon_Frame();
                                   }
                            }).start();
                     }
              });
              // controller_btnSuaHD controller_btnSuaHD = new controller_btnSuaHD(this);
              btn_Sua.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          if (getCheck_open_Jrame() == 0) {
                                                 setCheck_open_Jrame(3);
                                                 SuaHoaDon_Frame();
                                          } else if (getCheck_open_Jrame() == 1) {
                                                 // JOptionPane.showConfirmDialog(null, "ĐANG MỞ XEM HÓA ĐƠN", "Thông
                                                 // báo",
                                                 // JOptionPane.ERROR_MESSAGE);
                                                 Sys.Sound_Error();
                                                 Sys.Warning_dialog("ĐANG MỞ XEM HÓA ĐƠN");
                                          } else if (getCheck_open_Jrame() == 2) {
                                                 Sys.Sound_Error();
                                                 // JOptionPane.showConfirmDialog(null, "ĐANG MỞ THÊM HÓA ĐƠN", "Thông
                                                 // báo",
                                                 // JOptionPane.ERROR_MESSAGE);
                                                 Sys.Warning_dialog("ĐANG MỞ THÊM HÓA ĐƠN");
                                          }
                                   }
                            }).start();
                     }
              });
              // controller_XacNhanHD controller_XacNhanHD = new controller_XacNhanHD(this);
              btn_XacNhan.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          XacNhanHoaDon_Frame();
                                   }
                            }).start();
                     }
              });

       }

       public void setCheck_open_Jrame(int check_open_Jrame) {
              this.check_open_Jrame = check_open_Jrame;
       }

       public int getCheck_open_Jrame() {
              return check_open_Jrame;
       }

       public void setTienkhachdua(float tienkhachdua) {
              this.tienkhachdua = tienkhachdua;
       }

       public float getTienkhachdua() {
              return tienkhachdua;
       }

       public void TenDN(StaffDTO staff) {
              this.TenDN_label.setText(staff.getName());
       }

       public ListProductsBUS getListProducts() {
              return listProducts;
       }

       public DanhSachHDBUS getDanhSachHD() {
              return danhSachHD;
       }

       public dsPhieuXuatBUS getDsPhieuXuat() {
              return dsPhieuXuat;
       }

       public ArrayList<HoaDonDTO> Load_DSHoaDon() {
              ArrayList<HoaDonDTO> data = getDataFromDAOBUS.getList_HoaDon_fromDATA();
              return data;
       }

       public void Load_DSHoaDon_from_data_toTable() {
              ArrayList<HoaDonDTO> data = this.danhSachHD.getHoaDonArrayList();
              for (HoaDonDTO hoaDon : data) {
                     add_data_Table(hoaDon);
              }
       }

       // refresh
       public void refresh_table() {
              model = (DefaultTableModel) table.getModel();
              int number_row = model.getRowCount();
              for (int i = number_row - 1; i >= 0; i--) {
                     model.removeRow(i);
              }
              Load_DSHoaDon_from_data_after_change();
       }

       public void Load_DSHoaDon_from_data_after_change() {
              ArrayList<HoaDonDTO> data = Load_DSHoaDon();
              this.danhSachHD.setHoaDonArrayList(data);
              // this.dSachNhaCC.setCount(data.size());
              for (HoaDonDTO hoaDon : data) {
                     add_data_Table(hoaDon);
              }
       }

       public void add_data_Table(HoaDonDTO hoaDon) {
              model = (DefaultTableModel) table.getModel();
              model.addRow(new Object[] {
                            hoaDon.getMahd(), hoaDon.getManv(), hoaDon.getTimexuat(), hoaDon.getTinhTrang(),
                            hoaDon.getTongtien()
              });
       }

       public boolean ThemHoaDon_vaoDATA(HoaDonDTO hoaDon) {
              if (this.danhSachHD.themHDCuaKhachHang_2(hoaDon)) {
                     // JOptionPane.showConfirmDialog(null, "THÊM THÀNH CÔNG", "Thông báo ",
                     // JOptionPane.YES_OPTION);
                     Sys.Sound_Success();
                     Sys.Success_dialog("THÊM THÀNH CÔNG");

                     return true;
              } else {
                     // JOptionPane.showConfirmDialog(null, "THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu)",
                     // "Thông báo ",
                     // JOptionPane.INFORMATION_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Error_dialog("THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu)");

                     return false;
              }
       }

       public boolean SuaHoaDon_vaoDATA(HoaDonDTO hoaDon) {
              if (hoaDon.getTinhTrang().equals("Đang chờ xác nhận")) {
                     if (this.danhSachHD.suaHD_2(hoaDon)) {
                            // JOptionPane.showConfirmDialog(null, "SỬA THÀNH CÔNG", "Thông báo ",
                            // JOptionPane.YES_OPTION);
                            Sys.Sound_Success();
                            Sys.Success_dialog("SỬA THÀNH CÔNG");

                            return true;
                     } else {
                            // JOptionPane.showConfirmDialog(null, "SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu)",
                            // "Thông báo ",
                            // JOptionPane.ERROR_MESSAGE);
                            Sys.Sound_Error();
                            Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu)");

                            return false;
                     }
              } else {
                     // JOptionPane.showConfirmDialog(null,
                     // "SỬA KHÔNG THÀNH CÔNG (Không thể sửa hóa đơn đã xác nhận)", "Thông báo ",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();

                     Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Không thể sửa hóa đơn đã xác nhận)");
                     return false;
              }

       }

       public void Xoa_HoaDon(String ma) {
              if (ma.equals("") == false) {
                     if (this.danhSachHD.xoaHD_2(ma)) {
                            // JOptionPane.showConfirmDialog(null, "XÓA THÀNH CÔNG", "Thông báo",
                            // JOptionPane.INFORMATION_MESSAGE);
                            Sys.Sound_Success();
                            Sys.Success_dialog("XÓA THÀNH CÔNG");
                            for (HoaDonDTO hoaDon : this.danhSachHD.getHoaDonArrayList()) {
                                   if (hoaDon.getMahd().equals(ma)) {
                                          DanhSachCTHDBUS danhSachCTHD = hoaDon.getDsCTHD();
                                          for (ChiTietHDDTO chiTietHD : danhSachCTHD.getCthd()) {
                                                 for (ProductsDTO products : this.listProducts.getArr()) {
                                                        if (products.getMaSP().equals(chiTietHD.getMaSP())) {
                                                               products.setSl_conlai(products.getSoluong());
                                                        }
                                                 }
                                          }
                                   }
                            }

                     } else {
                            // JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ PHIẾU", "Thông báo",
                            // JOptionPane.ERROR_MESSAGE);
                            Sys.Sound_Error();
                            Sys.Error_dialog("KHÔNG THỂ XÓA MÃ PHIẾU");

                     }
              }
       }

       public void TimKiem() {
              String tukhoa = this.textField.getText();
              if (tukhoa.equals("") == false) {
                     ArrayList<HoaDonDTO> list_search = this.danhSachHD.timHD_2(tukhoa);
                     model = (DefaultTableModel) table.getModel();
                     int number_row = model.getRowCount();
                     for (int i = number_row - 1; i >= 0; i--) {
                            model.removeRow(i);
                     }
                     for (HoaDonDTO iterable_element : list_search) {
                            add_data_Table(iterable_element);
                     }
              }
       }

       public void XacNhanHoaDon(String maPhieu) {
              if (this.danhSachHD.xacNhanHoaDon_2(maPhieu, staff, dsPhieuXuat, listProducts)) {
                     // JOptionPane.showConfirmDialog(null, "XÁC NHẬN THÀNH CÔNG ĐÃ CHUYỂN QUA BỘ
                     // PHẬN XUẤT HÀNG",
                     // "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                     Sys.Sound_Success();
                     Sys.Success_dialog("XÁC NHẬN THÀNH CÔNG ĐÃ CHUYỂN QUA BỘ PHẬN XUẤT HÀNG");

                     int xacnhanInHD = Integer.valueOf(
                                   JOptionPane.showConfirmDialog(null, "Bạn có cần in hóa đơn không", "Thông báo",
                                                 JOptionPane.YES_OPTION));
                     InHoaDon(xacnhanInHD, maPhieu);
              } else {
                     // JOptionPane.showConfirmDialog(null, "XÁC NHẬN THẤT BẠI", "Thông báo",
                     // JOptionPane.INFORMATION_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Error_dialog("XÁC NHẬN THẤT BẠI");

              }
       }

       public void InHoaDon(int x, String maHD) {
              if (x == 0) {
                     for (HoaDonDTO hoaDon : this.danhSachHD.getHoaDonArrayList()) {
                            if (hoaDon.getMahd().equals(maHD)) {
                                   Sys.PrintBill(hoaDon, listProducts, getTienkhachdua());
                            }
                     }
              }
       }

       public HoaDonDTO Click_table() {
              try {
                     int click = this.table.getSelectedRow();
                     HoaDonDTO hoaDon = this.danhSachHD.getHoaDonArrayList().get(click);
                     return hoaDon;
              } catch (Exception e) {
                     // JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG",
                     // "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Warning_dialog("HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG");

              }
              return null;

       }

       public void XemHoaDon_Frame() {
              XemHoaDon_Frame xemHoaDon_Frame = new XemHoaDon_Frame(this);
       }

       public void ThemHoaDon_Frame() {
              ThemHoaDon_Frame themHoaDon_Frame = new ThemHoaDon_Frame(this);
              themHoaDon_Frame.getGanMaNV_label().setText(this.staff.getId());
              themHoaDon_Frame.getGanMaHD_label().setText(this.danhSachHD.getID());
              themHoaDon_Frame.getGanNgay_label().setText(Sys.getDateNow());
       }

       public void SuaHoaDon_Frame() {

              SuaHoaDon_Frame suaHoaDon_Frame = new SuaHoaDon_Frame(this);

       }

       public void XoaHoaDon_Frame() {
              try {
                     String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xóa", "Thông báo",
                                   JOptionPane.YES_OPTION);
                     Xoa_HoaDon(maPhieu);
              } catch (Exception e) {
                     // JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ PHIẾU", "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Error_dialog("KHÔNG THỂ XÓA MÃ PHIẾU");

              }
       }

       public void XacNhanHoaDon_Frame() {
              try {
                     String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xác nhận", "Thông báo",
                                   JOptionPane.YES_OPTION);
                     XacNhanHoaDon(maPhieu);

              } catch (Exception e) {
                     // JOptionPane.showConfirmDialog(null, "KHÔNG THỂ NHẬP MÃ PHIẾU", "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Error_dialog("KHÔNG THỂ NHẬP MÃ PHIẾU");

                     // e.printStackTrace();
              }
       }

}
