package TrangChinh_Menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.*;
import TrangChinh.GiaoDienChinh_view;
import TrangKhongChoVao.TrangKhongChoVao_view;
import TrangQuanLyHoaDon.TrangQuanLyHoaDon_view;
import TrangQuanLyKho.TrangQuanLyKho_view;
import TrangQuanLyNhaCC.TrangQuanLyNhaCC_view;
import TrangQuanLyNhanVien.TrangQuanLyNhanVien_view;
import TrangQuanLyPhieuNhap.TrangQuanLyPhieuNhap_view;
import TrangQuanLyPhieuXuat.TrangQuanLyPhieuXuat_view;
import TrangThongKe.TrangThongKe_view;
import BUS.*;

public class TrangChinh_Menu_view_2 extends JFrame {

       private JPanel contentPane;
       private JPanel panel;
       private JLabel logo_label;
       private JPanel Trangchu_panel;
       private JLabel Trangchu_label;
       private JPanel HoaDon_panel;
       private JLabel HoaDon_label;
       private JPanel PhieuNhap_panel;
       private JLabel PhieuNhap_label;
       private JPanel PhieuXuat_panel;
       private JLabel PhieuXuat_label;
       private JPanel QLKH_panel;
       private JLabel QLKH_label;
       private JPanel NhanVien_panel;
       private JLabel NhanVien_label;
       private JPanel NhaCC_panel;
       private JLabel NhanCC_label;
       private JPanel ThongKe_panel;
       private JLabel ThongKe_label;
       private JPanel BackGround_panel;
       /**
        * THÊM CÁC TRANG
        */
       private GiaoDienChinh_view giaoDienChinh_view;
       private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
       private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
       private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;
       private TrangQuanLyKho_view trangQuanLyKho_view;
       private TrangQuanLyPhieuXuat_view trangQuanLyPhieuXuat_view;
       private TrangQuanLyHoaDon_view trangQuanLyHoaDon_view;
       private TrangThongKe_view trangThongKe_view;
       private TrangKhongChoVao_view trangKhongChoVao_view;
       private int numberpage;
       private int Chucvu = 0; // 0: manager ; 1 : fulltime ; 2 : parttime

       /**
        * DU lieu data
        */
       private DanhSachNhaCCBUS danhSachNhaCC;
       private dsPhieuNhapBUS dsPhieuNhap;
       private ListProductsBUS listProducts;
       private StaffsBUS staffs;
       private dsPhieuXuatBUS dsPhieuXuat;
       private DanhSachHDBUS danhSachHD;
       private ThongKeDTO thongKe;

       private Color mau_nen_menu = new Color(223, 120, 87);
       private Color colorOver = new Color(249, 81, 19);
       private Color colorClick = new Color(152, 184, 144);

       public TrangChinh_Menu_view_2(int number_page, StaffDTO staff, DanhSachNhaCCBUS danhSachNhaCC,
                     dsPhieuNhapBUS dsPhieuNhap,
                     ListProductsBUS listProducts, StaffsBUS staffs, dsPhieuXuatBUS dsPhieuXuat,
                     DanhSachHDBUS danhSachHD,
                     ThongKeDTO thongKe, GiaoDienChinh_view giaoDienChinh_view) {
              this.giaoDienChinh_view = giaoDienChinh_view;
              this.danhSachNhaCC = danhSachNhaCC;
              this.dsPhieuNhap = dsPhieuNhap;
              this.listProducts = listProducts;
              this.staffs = staffs;
              this.dsPhieuXuat = dsPhieuXuat;
              this.danhSachHD = danhSachHD;
              this.thongKe = thongKe;
              this.numberpage = number_page;
              setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              setBounds(100, 100, 1000, 615);
              setResizable(false);
              setIconImage(new ImageIcon(
                            "image_icon\\z4200822300696_1883a507d71843fb2dadab7cc0b1c8d8-removebg-preview (1).png")
                            .getImage());
              setTitle("Giao diện chính");
              contentPane = new JPanel();
              contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

              setContentPane(contentPane);
              contentPane.setLayout(null);
              Color mau_nen_menu = new Color(223, 120, 87);
              Color mau_boder = new Color(97, 113, 67);
              Font chu = new Font("Tahoma", Font.BOLD, 15);

              panel = new JPanel();
              panel.setBounds(0, 0, 0, 600);
              contentPane.add(panel);
              panel.setLayout(null);

              logo_label = new JLabel("", JLabel.CENTER);
              logo_label.setIcon(new ImageIcon(
                            "image_icon\\z4208924539887_e2f96cca6b33e33d2403055319893a81.jpg"));
              logo_label.setBackground(Color.WHITE);
              logo_label.setBounds(0, 0, 250, 167);
              logo_label.setOpaque(true);
              panel.add(logo_label);

              Trangchu_panel = new JPanel();
              Trangchu_panel.setBounds(0, 168, 250, 50);
              Trangchu_panel.setBackground(mau_nen_menu);
              Trangchu_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(Trangchu_panel);
              Trangchu_panel.setLayout(null);

              Trangchu_label = new JLabel("TRANG CHỦ", JLabel.CENTER);
              Trangchu_label.setIcon(new ImageIcon("image_icon\\home.png"));
              Trangchu_label.setFont(chu);
              Trangchu_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              Trangchu_label.setForeground(Color.WHITE);
              Trangchu_label.setBounds(0, 0, 250, 50);
              Trangchu_panel.add(Trangchu_label);

              HoaDon_panel = new JPanel();
              HoaDon_panel.setBounds(0, 218, 250, 50);
              HoaDon_panel.setBackground(mau_nen_menu);
              HoaDon_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(HoaDon_panel);
              HoaDon_panel.setLayout(null);

              HoaDon_label = new JLabel("HÓA ĐƠN", JLabel.CENTER);
              HoaDon_label.setIcon(new ImageIcon("image_icon\\payment.png"));
              HoaDon_label.setBounds(0, 0, 250, 50);
              HoaDon_label.setFont(chu);
              HoaDon_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              HoaDon_label.setForeground(Color.white);
              HoaDon_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              HoaDon_panel.add(HoaDon_label);

              PhieuNhap_panel = new JPanel();
              PhieuNhap_panel.setLayout(null);
              PhieuNhap_panel.setBackground(new Color(223, 120, 87));
              PhieuNhap_panel.setBounds(0, 268, 250, 50);
              PhieuNhap_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(PhieuNhap_panel);

              PhieuNhap_label = new JLabel("PHIẾU NHẬP", JLabel.CENTER);
              PhieuNhap_label.setIcon(new ImageIcon("image_icon\\import_2.png"));
              PhieuNhap_label.setForeground(Color.WHITE);
              PhieuNhap_label.setFont(chu);
              PhieuNhap_label.setBounds(0, 0, 250, 50);
              PhieuNhap_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              PhieuNhap_panel.add(PhieuNhap_label);

              PhieuXuat_panel = new JPanel();
              PhieuXuat_panel.setLayout(null);
              PhieuXuat_panel.setBackground(new Color(223, 120, 87));
              PhieuXuat_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              PhieuXuat_panel.setBounds(0, 318, 250, 50);
              panel.add(PhieuXuat_panel);

              PhieuXuat_label = new JLabel("PHIẾU XUẤT", JLabel.CENTER);
              PhieuXuat_label.setIcon(new ImageIcon("image_icon\\invoice.png"));
              PhieuXuat_label.setForeground(Color.WHITE);
              PhieuXuat_label.setFont(chu);
              PhieuXuat_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              PhieuXuat_label.setBounds(0, 0, 250, 50);
              PhieuXuat_panel.add(PhieuXuat_label);

              QLKH_panel = new JPanel();
              QLKH_panel.setLayout(null);
              QLKH_panel.setBackground(new Color(223, 120, 87));
              QLKH_panel.setBounds(0, 368, 250, 50);
              QLKH_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(QLKH_panel);

              QLKH_label = new JLabel("KHO HÀNG", JLabel.CENTER);
              QLKH_label.setIcon(new ImageIcon("image_icon\\products.png"));
              QLKH_label.setForeground(Color.WHITE);
              QLKH_label.setFont(chu);
              QLKH_label.setBounds(0, 0, 250, 50);
              QLKH_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              QLKH_panel.add(QLKH_label);

              NhanVien_panel = new JPanel();
              NhanVien_panel.setLayout(null);
              NhanVien_panel.setBackground(new Color(223, 120, 87));
              NhanVien_panel.setBounds(0, 418, 250, 50);
              NhanVien_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(NhanVien_panel);

              NhanVien_label = new JLabel("NHÂN VIÊN", JLabel.CENTER);
              NhanVien_label.setIcon(new ImageIcon("image_icon\\teamwork.png"));
              NhanVien_label.setForeground(Color.WHITE);
              NhanVien_label.setFont(chu);
              NhanVien_label.setBounds(0, 0, 250, 50);
              NhanVien_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              NhanVien_panel.add(NhanVien_label);

              NhaCC_panel = new JPanel();
              NhaCC_panel.setLayout(null);
              NhaCC_panel.setBackground(new Color(223, 120, 87));
              NhaCC_panel.setBounds(0, 468, 250, 50);
              NhaCC_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(NhaCC_panel);

              NhanCC_label = new JLabel("NHÀ CUNG CẤP", JLabel.CENTER);
              NhanCC_label.setIcon(new ImageIcon("image_icon\\supplier.png"));
              NhanCC_label.setForeground(Color.WHITE);
              NhanCC_label.setFont(new Font("Tahoma", Font.BOLD, 15));
              NhanCC_label.setBounds(0, 0, 250, 50);
              NhanCC_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              NhaCC_panel.add(NhanCC_label);

              ThongKe_panel = new JPanel();
              ThongKe_panel.setLayout(null);
              ThongKe_panel.setBackground(new Color(223, 120, 87));
              ThongKe_panel.setBounds(0, 518, 250, 50);
              ThongKe_panel.setBorder(BorderFactory.createLineBorder(mau_boder));
              panel.add(ThongKe_panel);

              ThongKe_label = new JLabel("THỐNG KÊ", JLabel.CENTER);
              ThongKe_label.setIcon(new ImageIcon("image_icon\\analytics.png"));
              ThongKe_label.setForeground(Color.WHITE);
              ThongKe_label.setFont(new Font("Tahoma", Font.BOLD, 15));
              ThongKe_label.setBounds(0, 0, 250, 50);
              ThongKe_label.setBorder(BorderFactory.createLineBorder(mau_boder));
              ThongKe_panel.add(ThongKe_label);

              BackGround_panel = new JPanel();
              BackGround_panel.setBounds(0, 0, 1000, 605);
              BackGround_panel.setBackground(new Color(246, 225, 195));
              BackGround_panel.setOpaque(true);
              contentPane.add(BackGround_panel);
              BackGround_panel.setLayout(null);

              trangQuanLyNhaCC_view = new TrangQuanLyNhaCC_view(staff, danhSachNhaCC);
              trangQuanLyNhaCC_view.setBounds(255, 0, 732, 600);
              trangQuanLyNhaCC_view.setVisible(false);
              BackGround_panel.add(trangQuanLyNhaCC_view);

              trangQuanLyPhieuNhap_view = new TrangQuanLyPhieuNhap_view(staff, dsPhieuNhap, danhSachNhaCC,
                            listProducts);
              trangQuanLyPhieuNhap_view.setBounds(255, 0, 732, 600);
              trangQuanLyPhieuNhap_view.setVisible(false);
              BackGround_panel.add(trangQuanLyPhieuNhap_view);

              trangQuanLyNhanVien_view = new TrangQuanLyNhanVien_view(staff, staffs);
              trangQuanLyNhanVien_view.setBounds(255, 0, 732, 600);
              trangQuanLyNhanVien_view.setVisible(false);
              BackGround_panel.add(trangQuanLyNhanVien_view);

              trangQuanLyKho_view = new TrangQuanLyKho_view(staff, listProducts, danhSachNhaCC);
              trangQuanLyKho_view.setBounds(255, 0, 732, 600);
              trangQuanLyKho_view.setVisible(false);
              BackGround_panel.add(trangQuanLyKho_view);

              trangQuanLyPhieuXuat_view = new TrangQuanLyPhieuXuat_view(staff, dsPhieuXuat, danhSachHD, listProducts);
              trangQuanLyPhieuXuat_view.setBounds(255, 0, 732, 600);
              trangQuanLyPhieuXuat_view.setVisible(false);
              BackGround_panel.add(trangQuanLyPhieuXuat_view);

              trangQuanLyHoaDon_view = new TrangQuanLyHoaDon_view(staff, danhSachHD, listProducts, dsPhieuXuat);
              trangQuanLyHoaDon_view.setBounds(255, 0, 732, 600);
              trangQuanLyHoaDon_view.setVisible(false);
              BackGround_panel.add(trangQuanLyHoaDon_view);

              trangThongKe_view = new TrangThongKe_view(staff, thongKe);
              trangThongKe_view.setBounds(255, 0, 732, 600);
              trangThongKe_view.setVisible(false);
              BackGround_panel.add(trangThongKe_view);

              trangKhongChoVao_view = new TrangKhongChoVao_view(staff);
              trangKhongChoVao_view.setBounds(255, 0, 732, 600);
              trangKhongChoVao_view.setVisible(false);
              BackGround_panel.add(trangKhongChoVao_view);

              // controller
              setChucvu(staff);
              Page(staff);
              // controller_menuSize controller_menuSize = new controller_menuSize(this);
              Move_menuSize();
              // controller_TrangChuMenu controller_TrangChuMenu = new
              // controller_TrangChuMenu(this);
              Trangchu_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getTrangchu_label().setBackground(colorOver);
                            getTrangchu_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getTrangchu_label().setBackground(mau_nen_menu);
                            getTrangchu_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getTrangchu_label().setBackground(colorClick);
                            getTrangchu_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getTrangchu_label().setBackground(mau_nen_menu);
                            getTrangchu_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            setVisible(false);
                            dispose();
                            TrangChinh_open();
                            // this.trangChinh_Menu_view.TrangNhaCC_close();
                            // this.trangChinh_Menu_view.TrangPhieuNhap_close();
                            // this.trangChinh_Menu_view.TrangQuanLyNhanVien_close();
                            // this.trangChinh_Menu_view.TrangQuanLyKho_close();
                            // this.trangChinh_Menu_view.TrangPhieuXuat_close();
                            // this.trangChinh_Menu_view.TrangQuanLyHoaDon_close();
                     }
              });

              // controller_HoaDonMenu controller_HoaDonMenu = new
              // controller_HoaDonMenu(this);
              HoaDon_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getHoaDon_label().setBackground(colorOver);
                            getHoaDon_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getHoaDon_label().setBackground(mau_nen_menu);
                            getHoaDon_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getHoaDon_label().setBackground(colorClick);
                            getHoaDon_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getHoaDon_label().setBackground(mau_nen_menu);
                            getHoaDon_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            TrangQuanLyHoaDon_open();
                            TrangNhaCC_close();
                            TrangPhieuNhap_close();
                            TrangQuanLyNhanVien_close();
                            TrangQuanLyKho_close();
                            TrangPhieuXuat_close();
                            TrangThongKe_close();
                            TrangKhongChoVao_close();
                     }
              });

              // controller_PhieuNhapMenu controller_PhieuNhapMenu = new
              // controller_PhieuNhapMenu(this);
              PhieuNhap_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getPhieuNhap_label().setBackground(colorOver);
                            getPhieuNhap_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getPhieuNhap_label().setBackground(mau_nen_menu);
                            getPhieuNhap_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getPhieuNhap_label().setBackground(colorClick);
                            getPhieuNhap_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getPhieuNhap_label().setBackground(mau_nen_menu);
                            getPhieuNhap_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            if (getChucvu() == 0) {
                                   TrangPhieuNhap_open();
                                   //
                                   TrangNhaCC_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangKhongChoVao_close();
                            }

                            else if (getChucvu() == 1) {
                                   TrangPhieuNhap_open();
                                   //
                                   TrangNhaCC_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangKhongChoVao_close();
                            } else if (getChucvu() == 2) {
                                   TrangKhongChoVao_open();
                                   TrangNhaCC_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangPhieuNhap_close();

                            }
                     }
              });

              // controller_PhieuXuatMenu controller_PhieuXuatMenu = new
              // controller_PhieuXuatMenu(this);
              PhieuXuat_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getPhieuXuat_label().setBackground(colorOver);
                            getPhieuXuat_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getPhieuXuat_label().setBackground(mau_nen_menu);
                            getPhieuXuat_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getPhieuXuat_label().setBackground(colorClick);
                            getPhieuXuat_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getPhieuXuat_label().setBackground(mau_nen_menu);
                            getPhieuXuat_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            if (getChucvu() == 0
                                          || getChucvu() == 1) {
                                   TrangPhieuXuat_open();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangKhongChoVao_close();

                            } else if (getChucvu() == 2) {
                                   TrangKhongChoVao_open();
                                   TrangPhieuXuat_close();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                            }

                     }
              });
              // controller_NhaCCMenu nhaCCMenu = new controller_NhaCCMenu(this);
              NhanCC_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getNhanCC_label().setBackground(colorOver);
                            getNhanCC_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getNhanCC_label().setBackground(mau_nen_menu);
                            getNhanCC_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getNhanCC_label().setBackground(colorClick);
                            getNhanCC_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getNhanCC_label().setBackground(mau_nen_menu);
                            getNhanCC_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            Sys.Sound_Click();
                            if (getChucvu() == 0) {
                                   TrangNhaCC_open();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangKhongChoVao_close();
                            } else if (getChucvu() == 1) {
                                   TrangKhongChoVao_open();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                            } else if (getChucvu() == 2) {
                                   TrangKhongChoVao_open();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                            }

                     }
              });
              // controller_QLKHMenu controller_QLKHMenu = new controller_QLKHMenu(this);
              QLKH_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getQLKH_label().setBackground(colorOver);
                            getQLKH_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getQLKH_label().setBackground(mau_nen_menu);
                            getQLKH_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getQLKH_label().setBackground(colorClick);
                            getQLKH_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getQLKH_label().setBackground(mau_nen_menu);
                            getQLKH_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            if (getChucvu() == 0) {
                                   TrangQuanLyKho_open();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangKhongChoVao_close();
                            } else if (getChucvu() == 1
                                          || getChucvu() == 2) {
                                   TrangKhongChoVao_open();
                                   TrangQuanLyKho_close();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                            }

                     }
              });
              // controller_ThongKeMenu controller_ThongKeMenu = new
              // controller_ThongKeMenu(this);
              ThongKe_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getThongKe_label().setBackground(colorOver);
                            getThongKe_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getThongKe_label().setBackground(mau_nen_menu);
                            getThongKe_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getThongKe_label().setBackground(colorClick);
                            getThongKe_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getThongKe_label().setBackground(mau_nen_menu);
                            getThongKe_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            if (getChucvu() == 0) {
                                   TrangThongKe_open();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangKhongChoVao_close();
                            } else if (getChucvu() == 1
                                          && getChucvu() == 2) {
                                   TrangKhongChoVao_open();
                                   TrangThongKe_close();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyNhanVien_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                            }

                     }
              });
              // controller_NhanVienMenu controller_NhanVienMenu = new
              // controller_NhanVienMenu(this);
              NhanVien_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                            getNhanVien_label().setBackground(colorOver);
                            getNhanVien_label().setOpaque(true);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                            getNhanVien_label().setBackground(mau_nen_menu);
                            getNhanVien_label().setOpaque(true);
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {
                            getNhanVien_label().setBackground(colorClick);
                            getNhanVien_label().setOpaque(true);
                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {
                            getNhanVien_label().setBackground(mau_nen_menu);
                            getNhanVien_label().setOpaque(true);
                     }

                     @Override
                     public void mouseClicked(MouseEvent e) {
                            // di chuyen giua cac trang
                            Sys.Sound_Click();
                            if (getChucvu() == 0) {
                                   TrangQuanLyNhanVien_open();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                                   TrangKhongChoVao_close();
                            } else if (getChucvu() == 1 || getChucvu() == 2) {
                                   TrangKhongChoVao_open();
                                   TrangQuanLyNhanVien_close();
                                   TrangNhaCC_close();
                                   TrangPhieuNhap_close();
                                   TrangQuanLyKho_close();
                                   TrangPhieuXuat_close();
                                   TrangQuanLyHoaDon_close();
                                   TrangThongKe_close();
                            } 
                     }
              });
              setVisible(true);
       }

       public int getChucvu() {
              return Chucvu;
       }

       public void setChucvu(StaffDTO staff) {
              if (staff instanceof SeasonalStaffDTO) {
                     this.Chucvu = 2;
              } else if (staff instanceof ManagerDTO) {
                     this.Chucvu = 0;
              } else if (staff instanceof FullTimeStaffDTO) {
                     this.Chucvu = 1;
              }
       }

       public void Move_menuSize() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int width_max = 251;
                            int height_max = 600;
                            JPanel jPanel = getPanel();
                            int width = jPanel.getWidth();
                            if (width <= width_max) {
                                   for (int i = width; i <= width_max; i++) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jPanel.setSize(i, height_max);
                                   }
                            }
                     }
              }).start();
       }

       public JPanel getPanel() {
              return panel;
       }

       public JLabel getTrangchu_label() {
              return Trangchu_label;
       }

       public JLabel getHoaDon_label() {
              return HoaDon_label;
       }

       public JLabel getPhieuNhap_label() {
              return PhieuNhap_label;
       }

       public JLabel getPhieuXuat_label() {
              return PhieuXuat_label;
       }

       public JLabel getQLKH_label() {
              return QLKH_label;
       }

       public JLabel getNhanVien_label() {
              return NhanVien_label;
       }

       public JLabel getNhanCC_label() {
              return NhanCC_label;
       }

       public JLabel getThongKe_label() {
              return ThongKe_label;
       }

       // chuyen giua cac trang
       public void Page(StaffDTO staff) {

              if (staff instanceof SeasonalStaffDTO) {
                     switch (numberpage) {
                            case 1: {
                                   // quan ly nhan vien
                                   // TrangQuanLyNhanVien_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 2: {
                                   // quan ly hoa don
                                   TrangQuanLyHoaDon_open();
                                   break;
                            }
                            case 3: {
                                   // quan ly nha cung cap
                                   // TrangNhaCC_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 4: {
                                   TrangKhongChoVao_open();
                                   // TrangPhieuNhap_open();
                                   break;
                            }
                            case 5: {
                                   // quan ly phieu xuat
                                   // TrangPhieuXuat_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 6: {
                                   // quan ly kho
                                   // TrangQuanLyKho_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 7: {
                                   // thong ke
                                   // TrangThongKe_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                     }
              } else if (staff instanceof ManagerDTO) {
                     switch (numberpage) {
                            case 1: {
                                   // quan ly nhan vien
                                   TrangQuanLyNhanVien_open();
                                   break;
                            }
                            case 2: {
                                   // quan ly hoa don
                                   TrangQuanLyHoaDon_open();
                                   break;
                            }
                            case 3: {
                                   // quan ly nha cung cap
                                   TrangNhaCC_open();
                                   break;
                            }
                            case 4: {
                                   TrangPhieuNhap_open();
                                   break;
                            }
                            case 5: {
                                   // quan ly phieu xuat
                                   TrangPhieuXuat_open();
                                   break;
                            }
                            case 6: {
                                   // quan ly kho
                                   TrangQuanLyKho_open();
                                   break;
                            }
                            case 7: {
                                   // thong ke
                                   TrangThongKe_open();
                                   break;
                            }
                     }
              } else if (staff instanceof FullTimeStaffDTO) {
                     switch (numberpage) {
                            case 1: {
                                   // quan ly nhan vien
                                   // TrangQuanLyNhanVien_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 2: {
                                   // quan ly hoa don
                                   TrangQuanLyHoaDon_open();
                                   break;
                            }
                            case 3: {
                                   // quan ly nha cung cap
                                   // TrangNhaCC_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 4: {
                                   TrangPhieuNhap_open();
                                   break;
                            }
                            case 5: {
                                   // quan ly phieu xuat
                                   TrangPhieuXuat_open();
                                   break;
                            }
                            case 6: {
                                   // quan ly kho
                                   // TrangQuanLyKho_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                            case 7: {
                                   // thong ke
                                   // TrangThongKe_open();
                                   TrangKhongChoVao_open();
                                   break;
                            }
                     }
              }

       }

       public void TrangChinh_open() {
              this.giaoDienChinh_view.setVisible(true);
       }

       public void TrangChinh_close() {
              this.giaoDienChinh_view.setVisible(false);
       }

       public void TrangNhaCC_open() {
              this.trangQuanLyNhaCC_view.setVisible(true);
       }

       public void TrangNhaCC_close() {
              this.trangQuanLyNhaCC_view.setVisible(false);
       }

       public void TrangPhieuNhap_open() {
              this.trangQuanLyPhieuNhap_view.setVisible(true);
       }

       public void TrangPhieuNhap_close() {
              this.trangQuanLyPhieuNhap_view.setVisible(false);
       }

       public void TrangQuanLyNhanVien_open() {
              this.trangQuanLyNhanVien_view.setVisible(true);
       }

       public void TrangQuanLyNhanVien_close() {
              this.trangQuanLyNhanVien_view.setVisible(false);
       }

       public void TrangQuanLyKho_open() {
              this.trangQuanLyKho_view.setVisible(true);
       }

       public void TrangQuanLyKho_close() {
              this.trangQuanLyKho_view.setVisible(false);
       }

       public void TrangPhieuXuat_open() {
              this.trangQuanLyPhieuXuat_view.setVisible(true);
       }

       public void TrangPhieuXuat_close() {
              this.trangQuanLyPhieuXuat_view.setVisible(false);
       }

       public void TrangQuanLyHoaDon_open() {
              this.trangQuanLyHoaDon_view.setVisible(true);
       }

       public void TrangQuanLyHoaDon_close() {
              this.trangQuanLyHoaDon_view.setVisible(false);
       }

       public void TrangThongKe_open() {
              this.trangThongKe_view.setVisible(true);
       }

       public void TrangThongKe_close() {
              this.trangThongKe_view.setVisible(false);
       }

       public void TrangKhongChoVao_open() {
              this.trangKhongChoVao_view.setVisible(true);
       }

       public void TrangKhongChoVao_close() {
              this.trangKhongChoVao_view.setVisible(false);
       }

       public static void main(String[] args) {
              // new TranhChinh_Menu_view_2(1);
       }

}
