package TrangQuanLyHoaDon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class ThemHoaDon_Frame extends JFrame {

       private JPanel contentPane;
       private DefaultTableModel modelSP;
       private DefaultTableModel modelCTHD;
       private Color mau_chu = new Color(97, 113, 67);
       private JPanel CTHD_panel;
       private JScrollPane CTHD_scrollPane;
       private JTable CTHD_table;
       private JLabel QLHoaDon_label;
       private button_custom btn_XoaCT;
       private button_custom btn_XoaAllCT;
       private JPanel ThongTinHD_panel;
       private JLabel MaHD_label;
       private JLabel GanMaHD_label;
       private JLabel Ngay_label;
       private JLabel GanNgay_label;
       private JLabel MaNV_label;
       private JLabel GanMaNV_label;
       private JLabel TienKhach_label;
       private JTextField TienKhach_textField;
       private JLabel TienIcon_label;
       private JLabel TongTien_label;
       private JLabel GanTongTien_label;
       private JLabel TienDu_label;
       private JLabel GanTienDu_label;
       private button_custom btn_ThanhToan;
       private button_custom btn_LamMoiHD;
       private button_custom btn_HuyHD;
       private JPanel ThongTinSP_panel;
       private JScrollPane SanPham_scrollPane;
       private JTable SanPham_table;
       private JTextField TimKiemSP_textField;
       private JLabel TimKiemCTIcon_label;
       private JLabel ThemCTIcon_label;
       private JLabel LoaiSP_label;
       private JComboBox LoaiSP_comboBox;
       private JLabel RefreshSPIcon_label;

       private TrangQuanLyHoaDon_view trangQuanLyHoaDon_view;
       private DanhSachCTHDBUS danhSachCTHD;

       /**
        * Create the frame.
        */
       public ThemHoaDon_Frame(TrangQuanLyHoaDon_view trangQuanLyHoaDon_view) {
              // this.listProducts = listProducts;
              this.trangQuanLyHoaDon_view = trangQuanLyHoaDon_view;
              this.danhSachCTHD = new DanhSachCTHDBUS();
              setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              setBounds(100, 100, 1200, 750);
              setResizable(false);
              // setBackground(new Color(246,225,195));
              contentPane = new JPanel();
              contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
              contentPane.setBackground(new Color(246, 225, 195));
              setContentPane(contentPane);
              contentPane.setLayout(null);

              QLHoaDon_label = new JLabel("THÊM HÓA ĐƠN", SwingConstants.CENTER);
              QLHoaDon_label.setForeground(new Color(97, 113, 67));
              QLHoaDon_label.setFont(new Font("Tahoma", Font.BOLD, 35));
              QLHoaDon_label.setBounds(10, 10, 1176, 40);
              contentPane.add(QLHoaDon_label);

              CTHD_panel = new JPanel();
              CTHD_panel.setBounds(45, 85, 652, 251);
              CTHD_panel.setBackground(new Color(246, 225, 195));
              CTHD_panel.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
              contentPane.add(CTHD_panel);
              CTHD_panel.setLayout(null);

              CTHD_scrollPane = new JScrollPane();
              CTHD_scrollPane.setBounds(25, 40, 418, 176);
              CTHD_panel.add(CTHD_scrollPane);

              CTHD_table = new JTable();
              CTHD_table.setShowVerticalLines(false);
              CTHD_table.setModel(new DefaultTableModel(
                            new Object[][] {
                            },
                            new String[] {
                                          "ID MÓN ĂN", "TÊN MÓN ĂN", "SỐ LƯỢNG", "GIÁ BÁN"
                            }) {
                     boolean[] columnEditables = new boolean[] {
                                   false, false, false, false
                     };

                     public boolean isCellEditable(int row, int column) {
                            return columnEditables[column];
                     }
              });
              CTHD_table.getColumnModel().getColumn(0).setResizable(false);
              CTHD_table.getColumnModel().getColumn(1).setResizable(false);
              CTHD_table.getColumnModel().getColumn(2).setResizable(false);
              CTHD_table.getColumnModel().getColumn(3).setResizable(false);

              // chinh sua table
              CTHD_table.setBackground(Color.white);
              CTHD_table.getTableHeader().setBackground(new Color(32, 136, 203));
              CTHD_table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
              CTHD_table.setFont(new Font("Tahoma", Font.BOLD, 12));
              CTHD_table.getTableHeader().setForeground(Color.white);
              CTHD_table.setSelectionBackground(new Color(232, 57, 95));

              CTHD_table.setRowHeight(22);
              CTHD_scrollPane.setViewportView(CTHD_table);

              btn_XoaCT = new button_custom("Xóa chi tiết");
              btn_XoaCT.setRadius(10);
              btn_XoaCT.setForeground(Color.WHITE);
              btn_XoaCT.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_XoaCT.setBorderPainted(false);
              btn_XoaCT.setBounds(477, 58, 121, 35);
              CTHD_panel.add(btn_XoaCT);

              btn_XoaAllCT = new button_custom("Xóa tất cả");
              btn_XoaAllCT.setRadius(10);
              btn_XoaAllCT.setForeground(Color.WHITE);
              btn_XoaAllCT.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_XoaAllCT.setBorderPainted(false);
              btn_XoaAllCT.setBounds(477, 153, 121, 35);
              CTHD_panel.add(btn_XoaAllCT);

              ThongTinHD_panel = new JPanel();
              ThongTinHD_panel.setBounds(720, 85, 404, 569);
              ThongTinHD_panel.setBackground(new Color(246, 225, 195));
              ThongTinHD_panel.setBorder(BorderFactory.createTitledBorder("Hóa đơn"));
              contentPane.add(ThongTinHD_panel);
              ThongTinHD_panel.setLayout(null);

              MaHD_label = new JLabel("MÃ HÓA ĐƠN :");
              MaHD_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              MaHD_label.setBounds(10, 44, 113, 30);
              ThongTinHD_panel.add(MaHD_label);

              GanMaHD_label = new JLabel("New label");
              GanMaHD_label.setFont(new Font("Tahoma", Font.BOLD, 13));
              GanMaHD_label.setBounds(231, 44, 100, 30);
              ThongTinHD_panel.add(GanMaHD_label);

              Ngay_label = new JLabel("NGÀY :");
              Ngay_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              Ngay_label.setBounds(10, 88, 113, 30);
              ThongTinHD_panel.add(Ngay_label);

              GanNgay_label = new JLabel("New label");
              GanNgay_label.setFont(new Font("Tahoma", Font.BOLD, 13));
              GanNgay_label.setBounds(231, 88, 100, 30);
              ThongTinHD_panel.add(GanNgay_label);

              MaNV_label = new JLabel("MÃ NHÂN VIÊN :");
              MaNV_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              MaNV_label.setBounds(10, 138, 100, 30);
              ThongTinHD_panel.add(MaNV_label);

              GanMaNV_label = new JLabel("New label");
              GanMaNV_label.setFont(new Font("Tahoma", Font.BOLD, 13));
              GanMaNV_label.setBounds(231, 138, 100, 30);
              ThongTinHD_panel.add(GanMaNV_label);

              TienKhach_label = new JLabel("TIỀN KHÁCH ĐƯA :");
              TienKhach_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              TienKhach_label.setBounds(10, 248, 138, 30);
              ThongTinHD_panel.add(TienKhach_label);

              TienKhach_textField = new JTextField();
              TienKhach_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
              TienKhach_textField.setColumns(10);
              TienKhach_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
              TienKhach_textField.setBounds(204, 248, 127, 30);
              ThongTinHD_panel.add(TienKhach_textField);

              TienIcon_label = new JLabel("VND");
              TienIcon_label.setIcon(new ImageIcon("image_icon\\salary.png"));
              TienIcon_label.setFont(new Font("Tahoma", Font.BOLD, 13));
              TienIcon_label.setBounds(338, 248, 66, 30);
              ThongTinHD_panel.add(TienIcon_label);

              TongTien_label = new JLabel("TỔNG TIỀN :");
              TongTien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              TongTien_label.setBounds(10, 191, 113, 30);
              ThongTinHD_panel.add(TongTien_label);

              GanTongTien_label = new JLabel("0");
              GanTongTien_label.setFont(new Font("Tahoma", Font.BOLD, 13));
              GanTongTien_label.setBounds(231, 191, 109, 30);
              ThongTinHD_panel.add(GanTongTien_label);

              TienDu_label = new JLabel("TIỀN DƯ :");
              TienDu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              TienDu_label.setBounds(10, 313, 113, 30);
              ThongTinHD_panel.add(TienDu_label);

              GanTienDu_label = new JLabel("0");
              GanTienDu_label.setFont(new Font("Tahoma", Font.BOLD, 13));
              GanTienDu_label.setBounds(231, 313, 109, 30);
              ThongTinHD_panel.add(GanTienDu_label);

              btn_HuyHD = new button_custom("Xóa chi tiết");
              btn_HuyHD.setText("Hủy hóa đơn");
              btn_HuyHD.setRadius(10);
              btn_HuyHD.setForeground(Color.WHITE);
              btn_HuyHD.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_HuyHD.setBorderPainted(false);
              btn_HuyHD.setBounds(27, 382, 169, 27);
              ThongTinHD_panel.add(btn_HuyHD);

              btn_LamMoiHD = new button_custom("Xóa chi tiết");
              btn_LamMoiHD.setText("Làm mới");
              btn_LamMoiHD.setRadius(10);
              btn_LamMoiHD.setForeground(Color.WHITE);
              btn_LamMoiHD.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_LamMoiHD.setBorderPainted(false);
              btn_LamMoiHD.setBounds(204, 382, 169, 27);
              ThongTinHD_panel.add(btn_LamMoiHD);

              btn_ThanhToan = new button_custom("Xóa chi tiết");
              btn_ThanhToan.setIcon(new ImageIcon("image_icon\\trolley.png"));
              btn_ThanhToan.setText("THANH TOÁN");
              btn_ThanhToan.setRadius(10);
              btn_ThanhToan.setForeground(Color.WHITE);
              btn_ThanhToan.setFont(new Font("Tahoma", Font.BOLD, 22));
              btn_ThanhToan.setBorderPainted(false);
              btn_ThanhToan.setBounds(22, 430, 365, 117);
              ThongTinHD_panel.add(btn_ThanhToan);

              ThongTinSP_panel = new JPanel();
              ThongTinSP_panel.setBounds(45, 356, 652, 298);
              ThongTinSP_panel.setBorder(BorderFactory.createTitledBorder("Danh mục sản phẩm"));
              ThongTinSP_panel.setBackground(new Color(246, 225, 195));
              contentPane.add(ThongTinSP_panel);
              ThongTinSP_panel.setLayout(null);

              SanPham_scrollPane = new JScrollPane();
              SanPham_scrollPane.setBounds(44, 89, 554, 176);
              ThongTinSP_panel.add(SanPham_scrollPane);

              SanPham_table = new JTable();
              SanPham_table.setShowVerticalLines(false);
              SanPham_table.setModel(new DefaultTableModel(
                            new Object[][] {
                            },
                            new String[] {
                                          "MÃ SP", "TÊN", "SỐ LƯỢNG TỒN", "GIÁ BÁN"
                            }) {
                     boolean[] columnEditables = new boolean[] {
                                   false, false, false, false
                     };

                     public boolean isCellEditable(int row, int column) {
                            return columnEditables[column];
                     }
              });
              SanPham_table.getColumnModel().getColumn(0).setResizable(false);
              SanPham_table.getColumnModel().getColumn(1).setResizable(false);
              SanPham_table.getColumnModel().getColumn(2).setResizable(false);
              SanPham_table.getColumnModel().getColumn(3).setResizable(false);

              // chinh sua table
              SanPham_table.setBackground(Color.white);
              SanPham_table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
              SanPham_table.getTableHeader().setBackground(new Color(32, 136, 203));
              SanPham_table.getTableHeader().setForeground(Color.white);
              SanPham_table.setFont(new Font("Tahoma", Font.BOLD, 12));
              SanPham_table.setSelectionBackground(new Color(232, 57, 95));

              SanPham_table.setRowHeight(22);
              SanPham_scrollPane.setViewportView(SanPham_table);

              TimKiemSP_textField = new JTextField();
              TimKiemSP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
              TimKiemSP_textField.setColumns(10);
              TimKiemSP_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
              TimKiemSP_textField.setBounds(55, 35, 154, 30);
              ThongTinSP_panel.add(TimKiemSP_textField);

              TimKiemCTIcon_label = new JLabel("");
              TimKiemCTIcon_label
                            .setIcon(new ImageIcon("image_icon\\search.png"));
              TimKiemCTIcon_label.setBounds(219, 35, 32, 32);
              ThongTinSP_panel.add(TimKiemCTIcon_label);

              ThemCTIcon_label = new JLabel("");
              ThemCTIcon_label.setIcon(new ImageIcon("image_icon\\plus.png"));
              ThemCTIcon_label.setBounds(294, 35, 32, 32);
              ThongTinSP_panel.add(ThemCTIcon_label);

              LoaiSP_comboBox = new JComboBox();
              LoaiSP_comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
              LoaiSP_comboBox.setBounds(437, 38, 114, 27);
              ThongTinSP_panel.add(LoaiSP_comboBox);

              LoaiSP_label = new JLabel("Loại SP :");
              LoaiSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
              LoaiSP_label.setBounds(362, 35, 113, 30);
              ThongTinSP_panel.add(LoaiSP_label);

              RefreshSPIcon_label = new JLabel("");
              RefreshSPIcon_label
                            .setIcon(new ImageIcon("image_icon\\refresh.png"));
              RefreshSPIcon_label.setBounds(608, 233, 32, 32);
              ThongTinSP_panel.add(RefreshSPIcon_label);

              setLoaiSP();
              refresh_table_SP();
              controller_XoaAllCT_ThemHDFrame controller_XoaAllCT_ThemHDFrame = new controller_XoaAllCT_ThemHDFrame(this);
		btn_XoaAllCT.addMouseListener(controller_XoaAllCT_ThemHDFrame);
		controller_XoaClickCT_ThemHDFrame controller_XoaClickCT_ThemHDFrame = new controller_XoaClickCT_ThemHDFrame(this);
		btn_XoaCT.addMouseListener(controller_XoaClickCT_ThemHDFrame);
		controller_TimKiemSPDanhMuc_ThemHDFrame timKiemSPDanhMuc_ThemHDFrame = new controller_TimKiemSPDanhMuc_ThemHDFrame(this);
		LoaiSP_comboBox.addActionListener(timKiemSPDanhMuc_ThemHDFrame);
		controller_TimKiemSP_ThemHDFrame controller_TimKiemSP_ThemHDFrame = new controller_TimKiemSP_ThemHDFrame(this);
		TimKiemCTIcon_label.addMouseListener(controller_TimKiemSP_ThemHDFrame);
		controller_themCTHD_ThemHD controller_themCTHD_ThemHD = new controller_themCTHD_ThemHD(this);
		ThemCTIcon_label.addMouseListener(controller_themCTHD_ThemHD);
		controller_btnHuy_ThemHDFrame controller_btnHuy_ThemHDFrame = new controller_btnHuy_ThemHDFrame(this);
		btn_HuyHD.addMouseListener(controller_btnHuy_ThemHDFrame);
		controller_btnLamMoi_ThemHD controller_btnLamMoi_ThemHD = new controller_btnLamMoi_ThemHD(this);
		btn_LamMoiHD.addMouseListener(controller_btnLamMoi_ThemHD);
		controller_btnThanhToan_ThemHD controller_btnThanhToan_ThemHD = new controller_btnThanhToan_ThemHD(this);
		btn_ThanhToan.addMouseListener(controller_btnThanhToan_ThemHD);
		controller_TinhTienDu_ThemHD controller_TinhTienDu_ThemHD = new controller_TinhTienDu_ThemHD(this);
		TienKhach_textField.addKeyListener(controller_TinhTienDu_ThemHD);
		controller_refreshSP_ThemHDFrame controller_refreshSP_ThemHDFrame = new controller_refreshSP_ThemHDFrame(this);
		RefreshSPIcon_label.addMouseListener(controller_refreshSP_ThemHDFrame);
		setVisible(true);
              
       }

       public void setLoaiSP() {
              this.LoaiSP_comboBox.addItem(new ComboItem("", ""));
              this.LoaiSP_comboBox.addItem(new ComboItem("Food", "Food"));
              this.LoaiSP_comboBox.addItem(new ComboItem("Drink", "Drink"));
       }

       public JLabel getGanMaHD_label() {
              return GanMaHD_label;
       }

       public JLabel getGanMaNV_label() {
              return GanMaNV_label;
       }

       public JLabel getGanNgay_label() {
              return GanNgay_label;
       }

       // danh muc san pham
       public void TimKiemSP_TuKhoa() {
              String tuKhoa = this.TimKiemSP_textField.getText();
              modelSP = (DefaultTableModel) SanPham_table.getModel();
              if (tuKhoa != null) {
                     ArrayList<ProductsDTO> list_search = this.trangQuanLyHoaDon_view.getListProducts()
                                   .timtheoKey_2(tuKhoa);
                     int number_row = modelSP.getRowCount();
                     for (int i = number_row - 1; i >= 0; i--) {
                            modelSP.removeRow(i);
                     }
                     for (ProductsDTO products : list_search) {
                            add_dataSP_Table(products);
                     }

              }
       }

       public void TimKiemSP_DanhMuc() {
              ComboItem item = (ComboItem) this.LoaiSP_comboBox.getSelectedItem();
              String value = item.getValue();
              modelSP = (DefaultTableModel) SanPham_table.getModel();
              if (value.equals("Food")) {
                     int number_row = modelSP.getRowCount();
                     for (int i = number_row - 1; i >= 0; i--) {
                            modelSP.removeRow(i);
                     }
                     for (ProductsDTO products : this.trangQuanLyHoaDon_view.getListProducts().getArr()) {
                            if (products instanceof FoodDTO) {
                                   add_dataSP_Table(products);
                            }
                     }
              } else if (value.equals("Drink")) {
                     int number_row = modelSP.getRowCount();
                     for (int i = number_row - 1; i >= 0; i--) {
                            modelSP.removeRow(i);
                     }
                     for (ProductsDTO products : this.trangQuanLyHoaDon_view.getListProducts().getArr()) {
                            if (products instanceof DrinkDTO) {
                                   add_dataSP_Table(products);
                            }
                     }
              }
       }

       public void refresh_table_SP() {
              modelSP = (DefaultTableModel) SanPham_table.getModel();
              int number_row = modelSP.getRowCount();
              for (int i = number_row - 1; i >= 0; i--) {
                     modelSP.removeRow(i);
              }
              Load_DSProducts_from_data_after_change();
       }

       public void Load_DSProducts_from_data_after_change() {

              // this.dSachNhaCC.setCount(data.size());
              for (ProductsDTO products : this.trangQuanLyHoaDon_view.getListProducts().getArr()) {
                     add_dataSP_Table(products);
              }
       }

       public ProductsDTO Click_table_SP() {
              try {
                     int click = this.SanPham_table.getSelectedRow();
                     ProductsDTO products = this.trangQuanLyHoaDon_view.getListProducts().getArr().get(click);
                     return products;
              } catch (Exception e) {
                     // JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT SẢN PHẨM TRONG BẢNG",
                     // "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Warning_dialog("HÃY CLICK CHỌN MỘT SẢN PHẨM TRONG BẢNG");

              }
              return null;

       }

       public void ChonSLProducts_addCTHoaDon() {
              ProductsDTO sp = Click_table_SP();
              modelCTHD = (DefaultTableModel) CTHD_table.getModel();
              if (sp != null) {
                     try {
                            String soluong = JOptionPane.showInputDialog(null, "Nhập số lượng cần mua", "Thông báo",
                                          JOptionPane.OK_OPTION);
                            if (Sys.takeIntegerInput_2(soluong)) {
                                   int soluongMua = Integer.parseInt(soluong);
                                   if (sp.sell(soluongMua)) {
                                          ChiTietHDDTO moi = new ChiTietHDDTO(sp.getMaSP(), soluongMua, sp.getPrice());
                                          int flag = 0;

                                          for (ChiTietHDDTO chiTietHD : danhSachCTHD.getCthd()) {
                                                 if (moi.getMaSP().equals(chiTietHD.getMaSP())) {
                                                        flag = 1;
                                                        chiTietHD.setSoluong(chiTietHD.getSoluong() + moi.getSoluong());
                                                        break;
                                                 }
                                          }
                                          if (flag == 0) {
                                                 this.danhSachCTHD.add(moi);
                                          }
                                          setTongTien(this.danhSachCTHD.tinhTongTien());
                                          String nameSP = "";
                                          for (ProductsDTO iterable_element : this.trangQuanLyHoaDon_view
                                                        .getListProducts().getArr()) {
                                                 if (sp.getMaSP().equals(iterable_element.getMaSP())) {
                                                        nameSP = iterable_element.getNameProduct();
                                                        break;
                                                 }
                                          }
                                          int number_row = modelCTHD.getRowCount();
                                          for (int i = number_row - 1; i >= 0; i--) {
                                                 modelCTHD.removeRow(i);
                                          }
                                          for (ChiTietHDDTO chiTietHD : this.danhSachCTHD.getCthd()) {
                                                 String nameSp = "";
                                                 for (ProductsDTO products : this.trangQuanLyHoaDon_view
                                                               .getListProducts().getArr()) {
                                                        if (chiTietHD.getMaSP().equals(products.getMaSP())) {
                                                               nameSp = products.getNameProduct();
                                                               break;
                                                        }
                                                 }
                                                 add_dataCTHD_Table(chiTietHD, nameSp);
                                          }

                                   } else {
                                          // JOptionPane.showConfirmDialog(null, "SỐ LƯỢNG TỒN KHO KHÔNG ĐỦ", "Thông
                                          // báo",
                                          // JOptionPane.ERROR_MESSAGE);
                                          Sys.Sound_Error();
                                          Sys.Warning_dialog("SỐ LƯỢNG TỒN KHO KHÔNG ĐỦ");

                                   }
                            } else {
                                   // JOptionPane.showConfirmDialog(null, "SAI DỮ LIỆU", "Thông báo",
                                   // JOptionPane.ERROR_MESSAGE);
                                   Sys.Sound_Error();
                                   Sys.Error_dialog("SAI DỮ LIỆU");

                            }

                     } catch (Exception e) {
                            Sys.Sound_Error();
                            Sys.Error_dialog("SAI DỮ LIỆU");

                     }
              }
       }

       public void add_dataSP_Table(ProductsDTO products) {
              modelSP = (DefaultTableModel) SanPham_table.getModel();
              modelSP.addRow(new Object[] {
                            products.getMaSP(), products.getNameProduct(), products.getSl_conlai(), products.getPrice()
              });
       }

       public void add_dataCTHD_Table(ChiTietHDDTO chiTietHD, String nameSP) {
              refresh_table_SP();
              modelCTHD = (DefaultTableModel) CTHD_table.getModel();
              modelCTHD.addRow(new Object[] {
                            chiTietHD.getMaSP(), nameSP, chiTietHD.getSoluong(), chiTietHD.getGia()
              });
       }

       // CTHD
       public ChiTietHDDTO Click_table_CTHD() {
              try {
                     int click = this.CTHD_table.getSelectedRow();
                     ChiTietHDDTO chiTietHD = this.danhSachCTHD.getCthd().get(click);
                     return chiTietHD;
              } catch (Exception e) {
                     // JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT SẢN PHẨM TRONG BẢNG",
                     // "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Warning_dialog("HÃY CLICK CHỌN MỘT SẢN PHẨM TRONG BẢNG");

              }
              return null;

       }

       public void xoaCTHD_duocchon() {
              ChiTietHDDTO chiTietHD = Click_table_CTHD();
              modelCTHD = (DefaultTableModel) CTHD_table.getModel();
              if (chiTietHD != null) {
                     int click = this.CTHD_table.getSelectedRow();
                     String maSP = chiTietHD.getMaSP();
                     for (ProductsDTO products : this.trangQuanLyHoaDon_view.getListProducts().getArr()) {
                            if (products.getMaSP().equals(maSP)) {
                                   products.setSl_conlai(products.getSoluong());
                                   refresh_table_SP();
                                   break;
                            }
                     }
                     modelCTHD.removeRow(click);
                     this.danhSachCTHD.getCthd().remove(chiTietHD);
              } else {
                     // JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT CHI TIẾT TRONG BẢNG",
                     // "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Warning_dialog("HÃY CLICK CHỌN MỘT CHI TIẾT TRONG BẢNG");

              }
       }

       public void xoaCTHD_all() {
              modelCTHD = (DefaultTableModel) CTHD_table.getModel();
              int number_row = modelCTHD.getRowCount();
              for (int i = number_row - 1; i >= 0; i--) {
                     modelCTHD.removeRow(i);
              }
              this.danhSachCTHD.getCthd().clear();
              for (ProductsDTO products : this.trangQuanLyHoaDon_view.getListProducts().getArr()) {
                     products.setSl_conlai(products.getSoluong());
              }
              refresh_table_SP();
       }

       // thong tin hoa don
       public void setTongTien(int tongtien) {
              this.GanTongTien_label.setText(String.valueOf(tongtien));
              this.GanTienDu_label.setText("-" + String.valueOf(tongtien));
              this.TienKhach_textField.setText("0");
       }

       public void TinhTienDu() {
              try {
                     float tongtien = Float.parseFloat(this.GanTongTien_label.getText());
                     float tienkhachdua = Float.parseFloat(this.TienKhach_textField.getText());
                     float tiendu = tienkhachdua - tongtien;
                     this.GanTienDu_label.setText(String.valueOf(tiendu));

              } catch (Exception e) {
                     // JOptionPane.showConfirmDialog(null, "HÃY NHẬP SỐ", "Thông báo",
                     // JOptionPane.ERROR_MESSAGE);
                     Sys.Error_dialog("HÃY NHẬP SỐ");
                     Sys.Sound_Error();
                     this.TienKhach_textField.setText("0");
              }
       }

       public void btnHuyHoaDon() {
              for (ProductsDTO products : this.trangQuanLyHoaDon_view.getListProducts().getArr()) {
                     products.setSl_conlai(products.getSoluong());
              }
              this.trangQuanLyHoaDon_view.setCheck_open_Jrame(0);
              this.setVisible(false);
              this.dispose();
       }

       public void btnLamMoiHD() {
              setTongTien(0);
              xoaCTHD_all();
       }

       public void btnThanhToan() {

              float tinhtien = Float.valueOf(this.GanTienDu_label.getText());
              String maHd = this.GanMaHD_label.getText();
              String maNv = this.GanMaNV_label.getText();
              String date = this.GanNgay_label.getText();

              HoaDonDTO moi = new HoaDonDTO(maHd, maNv, date, this.danhSachCTHD.tinhTongTien(), danhSachCTHD,
                            "Đang chờ xác nhận");

              if (tinhtien >= 0) {
                     if (moi.getDsCTHD().getCthd() != null) {
                            if (this.trangQuanLyHoaDon_view.ThemHoaDon_vaoDATA(moi)) {
                                   this.trangQuanLyHoaDon_view.setCheck_open_Jrame(0);
                                   this.trangQuanLyHoaDon_view
                                                 .setTienkhachdua(Float.valueOf(this.TienKhach_textField.getText()));
                                   this.setVisible(false);
                                   this.dispose();
                            }
                     } else {
                            // JOptionPane.showConfirmDialog(null, "THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu)",
                            // "Thông báo ",
                            // JOptionPane.INFORMATION_MESSAGE);
                            Sys.Sound_Error();
                            Sys.Error_dialog("THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu)");

                     }
              } else {
                     // JOptionPane.showConfirmDialog(null, "KHÁCH ĐƯA KHÔNG ĐỦ TIỀN", "Thông báo ",
                     // JOptionPane.INFORMATION_MESSAGE);
                     Sys.Sound_Error();
                     Sys.Error_dialog("KHÁCH ĐƯA KHÔNG ĐỦ TIỀN");

              }

       }
}