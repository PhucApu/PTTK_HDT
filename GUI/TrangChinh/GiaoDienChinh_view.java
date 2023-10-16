package TrangChinh;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import DTO.*;
import DangNhap.DangNhap_view;
import TrangChinh_Menu.TrangChinh_Menu_view_2;
import BUS.*;

public class GiaoDienChinh_view extends JFrame {

       private JPanel contentPane;
       private JPanel BackGround_panel;
       private JLabel picture_label;
       private JLabel QLBTAN_label;
       private JLabel UserIcon_label;
       private JLabel TenDN_label;
       private Button btnQunLNhn;
       private Button btnQLHD;
       private Button btnQunLPhiu;
       private JLabel ThoatIcon_label;
       private Button btn_ThongKe;
       private Button btnQunLPhiu_2;
       private Button btn_QLNCC;
       private Button btn_QLKho;
       /**
        * Create the frame.
        */

       private StaffDTO staff;
       private DanhSachNhaCCBUS danhSachNhaCC;
       private dsPhieuNhapBUS dsPhieuNhap;
       private ListProductsBUS listProducts;
       private StaffsBUS staffs;
       private dsPhieuXuatBUS dsPhieuXuat;
       private DanhSachHDBUS danhSachHD;
       private ThongKeDTO thongKe;
       private dsPhieuHuyBUS dsPhieuHuyBUS;
       private DangNhap_view dangNhap_view;

       private TrangChinh_Menu_view_2 tranhChinh_Menu_view_2;

       public GiaoDienChinh_view(StaffDTO staff, DanhSachNhaCCBUS danhSachNhaCC, dsPhieuNhapBUS dsPhieuNhap,
                     ListProductsBUS listProducts, StaffsBUS staffs, dsPhieuXuatBUS dsPhieuXuat,
                     DanhSachHDBUS danhSachHD, ThongKeDTO thongKe,dsPhieuHuyBUS dsPhieuHuyBUS, DangNhap_view dangNhap_view) {
              this.staff = staff;
              this.danhSachNhaCC = danhSachNhaCC;
              this.dsPhieuNhap = dsPhieuNhap;
              this.listProducts = listProducts;
              this.dangNhap_view = dangNhap_view;
              this.staffs = staffs;
              this.dsPhieuXuat = dsPhieuXuat;
              this.danhSachHD = danhSachHD;
              this.thongKe = thongKe;
              this.dsPhieuHuyBUS = dsPhieuHuyBUS;
              setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              setBounds(100, 100, 1219, 619);
              setResizable(false);
              contentPane = new JPanel();
              contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

              Color mau = new Color(111, 164, 159);

              setContentPane(contentPane);
              contentPane.setLayout(null);

              setIconImage(new ImageIcon(
                            "image_icon\\z4200822300696_1883a507d71843fb2dadab7cc0b1c8d8-removebg-preview (1).png")
                            .getImage());
              BackGround_panel = new JPanel();
              BackGround_panel.setToolTipText("");
              BackGround_panel.setBounds(0, 0, 1219, 619);
              BackGround_panel.setBackground(new Color(246, 225, 195));
              contentPane.add(BackGround_panel);
              BackGround_panel.setLayout(null);

              picture_label = new JLabel("");
              picture_label.setIcon(new ImageIcon("image_icon\\z4200822290317_799026ea31313a80d3dc913d27731c7d.jpg"));
              picture_label.setBounds(0, 0, 0, 617);
              BackGround_panel.add(picture_label);

              QLBTAN_label = new JLabel("QUẢN LÝ BÁN THỨC ĂN NHANH", JLabel.CENTER);
              QLBTAN_label.setFont(new Font("Tahoma", Font.BOLD, 35));
              QLBTAN_label.setBounds(1200, 55, 620, 60);
              QLBTAN_label.setForeground(mau);
              BackGround_panel.add(QLBTAN_label);

              UserIcon_label = new JLabel("", JLabel.CENTER);
              UserIcon_label.setIcon(new ImageIcon("image_icon\\user.png"));
              UserIcon_label.setBounds(1051, 10, 40, 40);
              BackGround_panel.add(UserIcon_label);

              TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
              TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
              TenDN_label.setBounds(1084, 15, 106, 30);
              BackGround_panel.add(TenDN_label);

              this.btnQunLNhn = new Button("QUẢN LÝ NHÂN VIÊN");
              btnQunLNhn.setIcon(new ImageIcon("image_icon\\teamwork.png"));
              btnQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 11));
              btnQunLNhn.setText("QUẢN LÝ NHÂN VIÊN");
              btnQunLNhn.setBounds(555, -148, 202, 60);
              btnQunLNhn.setForeground(Color.white);
              btnQunLNhn.setBorderPainted(false);
              btnQunLNhn.setHorizontalAlignment(JButton.CENTER);
              btnQunLNhn.setRadius(20);
              BackGround_panel.add(btnQunLNhn);

              btnQLHD = new Button("QUẢN LÝ HÓA ĐƠN");
              btnQLHD.setIcon(new ImageIcon("image_icon\\payment.png"));
              btnQLHD.setRadius(20);
              btnQLHD.setForeground(Color.WHITE);
              btnQLHD.setFont(new Font("Tahoma", Font.BOLD, 11));
              btnQLHD.setBorderPainted(false);
              btnQLHD.setHorizontalAlignment(JButton.CENTER);
              btnQLHD.setBounds(555, -235, 202, 60);
              BackGround_panel.add(btnQLHD);

              btnQunLPhiu = new Button("QUẢN LÝ HÓA ĐƠN");
              btnQunLPhiu.setIcon(new ImageIcon("image_icon\\invoice.png"));
              btnQunLPhiu.setText("QUẢN LÝ PHIẾU NHẬP");
              btnQunLPhiu.setRadius(20);
              btnQunLPhiu.setHorizontalAlignment(SwingConstants.CENTER);
              btnQunLPhiu.setForeground(Color.WHITE);
              btnQunLPhiu.setFont(new Font("Tahoma", Font.BOLD, 11));
              btnQunLPhiu.setBorderPainted(false);
              btnQunLPhiu.setBounds(555, -322, 202, 60);
              BackGround_panel.add(btnQunLPhiu);

              btnQunLPhiu_2 = new Button("");
              btnQunLPhiu_2.setIcon(new ImageIcon("image_icon\\import_2.png"));
              btnQunLPhiu_2.setText("QUẢN LÝ PHIẾU HỦY");
              btnQunLPhiu_2.setRadius(20);
              btnQunLPhiu_2.setHorizontalAlignment(SwingConstants.CENTER);
              btnQunLPhiu_2.setForeground(Color.WHITE);
              btnQunLPhiu_2.setFont(new Font("Tahoma", Font.BOLD, 11));
              btnQunLPhiu_2.setBorderPainted(false);
              btnQunLPhiu_2.setBounds(555, -409, 202, 60);
              BackGround_panel.add(btnQunLPhiu_2);

              btn_QLNCC = new Button("");
              btn_QLNCC.setIcon(new ImageIcon("image_icon\\supplier.png"));
              btn_QLNCC.setText("QUẢN LÝ NHÀ CUNG CẤP");
              btn_QLNCC.setRadius(20);
              btn_QLNCC.setHorizontalAlignment(SwingConstants.CENTER);
              btn_QLNCC.setForeground(Color.WHITE);
              btn_QLNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
              btn_QLNCC.setBorderPainted(false);
              btn_QLNCC.setBounds(939, 1174, 222, 60);
              BackGround_panel.add(btn_QLNCC);

              btn_QLKho = new Button("");
              btn_QLKho.setIcon(new ImageIcon("image_icon\\products.png"));
              btn_QLKho.setText("QUẢN LÝ KHO HÀNG");
              btn_QLKho.setRadius(20);
              btn_QLKho.setHorizontalAlignment(SwingConstants.CENTER);
              btn_QLKho.setForeground(Color.WHITE);
              btn_QLKho.setFont(new Font("Tahoma", Font.BOLD, 11));
              btn_QLKho.setBorderPainted(false);
              btn_QLKho.setBounds(939, 1087, 222, 60);
              BackGround_panel.add(btn_QLKho);

              btn_ThongKe = new Button("");
              btn_ThongKe.setIcon(new ImageIcon("image_icon\\analytics.png"));
              btn_ThongKe.setText("THỐNG KÊ");
              btn_ThongKe.setRadius(20);
              btn_ThongKe.setHorizontalAlignment(SwingConstants.CENTER);
              btn_ThongKe.setForeground(Color.WHITE);
              btn_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
              btn_ThongKe.setBorderPainted(false);
              btn_ThongKe.setBounds(939, 1000, 222, 60);
              BackGround_panel.add(btn_ThongKe);

              ThoatIcon_label = new JLabel("");
              ThoatIcon_label.setIcon(new ImageIcon("image_icon\\back.png"));
              ThoatIcon_label.setBounds(1126, 509, 64, 64);
              BackGround_panel.add(ThoatIcon_label);

              // controler
              // controllerBackground controllerBackground = new controllerBackground(this);
              MoveBackGround();
              // controller_TieuDe controller_TieuDe = new controller_TieuDe(this);
              MoveTieuDe();
              // controller_buttonNV controller_buttonNV = new controller_buttonNV(this);
              Move_btnNV();
              btnQunLNhn.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {

                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_NhanVien();
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();

                     }
              });

              // controller_buttonHD controller_buttonHD = new controller_buttonHD(this);
              Move_btnHoaDon();
              btnQLHD.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {

                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_HoaDon();
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();

                     }
              });

              // controller_buttonPN controller_buttonPN = new controller_buttonPN(this);
              Move_btnPN();
              btnQunLPhiu.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {

                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_PhieuNhap();
                                          ;
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();

                     }
              });
              // controller_buttonPX controller_buttonPX = new controller_buttonPX(this);
              Move_btnPX();
              btnQunLPhiu_2.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {

                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_PhieuXuat();
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();

                     }
              });
              // controller_buttonTK controller_buttonTK = new controller_buttonTK(this);
              Move_btnTK();
              btn_ThongKe.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {

                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_ThongKe();
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();
                     }
              });
              // controller_buttonKho controller_buttonKho = new controller_buttonKho(this);
              Move_btnKho();
              btn_QLKho.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_Kho();
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();

                     }
              });
              // controller_buttonNCC controller_buttonNCC = new controller_buttonNCC(this);
              Move_btnNCC();
              btn_QLNCC.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {

                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          btn_NhaCC();
                                          setVisible(false);
                                          dispose();

                                   }
                            }).start();

                     }
              });
              // controller_buttonBack controller_buttonBack = new
              // controller_buttonBack(this);
              ThoatIcon_label.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            new Thread(new Runnable() {
                                   @Override
                                   public void run() {
                                          Sys.Sound_Click();
                                          int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất",
                                                        "Xác nhận", JOptionPane.YES_NO_OPTION);
                                          if (chon == 0) {
                                                 setVisible(false);
                                                 dispose();
                                                 getDangNhap_view().setVisible(true);
                                          }
                                   }
                            }).start();

                     }
              });

              TenDN();
              setVisible(true);
       }

       public void MoveBackGround() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            JLabel jLabel = getPicture_label();
                            int width_picture = jLabel.getWidth();
                            int height_picture = jLabel.getHeight();
                            int width_max = 493;
                            if (width_picture <= 500) {
                                   for (int i = width_picture; i <= width_max; i++) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jLabel.setSize(i, height_picture);
                                   }
                            }

                     }
              }).start();
       }

       public void MoveTieuDe() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 555;
                            JLabel jLabel = getQLBTAN_label();
                            int x = jLabel.getX();
                            int y = jLabel.getY();

                            if (x >= 500) {
                                   for (int i = x; i >= x_location; i--) {
                                          try {
                                                 Thread.sleep(1);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jLabel.setLocation(i, y);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnNV() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 555;
                            int y_location = 148;
                            JButton jButton = getBtnQunLNhn();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y <= y_location) {
                                   for (int i = y; i <= y_location; i++) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnHoaDon() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 555;
                            int y_location = 235;
                            JButton jButton = getBtnQLHD();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y <= y_location) {
                                   for (int i = y; i <= y_location; i++) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnPN() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 555;
                            int y_location = 322;
                            JButton jButton = getBtnQunLPhiu();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y <= y_location) {
                                   for (int i = y; i <= y_location; i++) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnPX() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 555;
                            int y_location = 409;
                            JButton jButton = getBtnQunLPhiu_2();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y <= y_location) {
                                   for (int i = y; i <= y_location; i++) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnTK() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 939;
                            int y_location = 322;
                            JButton jButton = getBtn_ThongKe();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y >= y_location) {
                                   for (int i = y; i >= y_location; i--) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnKho() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 939;
                            int y_location = 235;
                            JButton jButton = getBtn_QLKho();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y >= y_location) {
                                   for (int i = y; i >= y_location; i--) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void Move_btnNCC() {
              new Thread(new Runnable() {

                     @Override
                     public void run() {
                            int x_location = 939;
                            int y_location = 148;
                            JButton jButton = getBtn_QLNCC();
                            int x = x_location;
                            int y = jButton.getY();

                            if (y >= y_location) {
                                   for (int i = y; i >= y_location; i--) {
                                          try {
                                                 Thread.sleep(2);
                                          } catch (Exception e) {
                                                 e.printStackTrace();
                                          }
                                          jButton.setLocation(x, i);
                                   }
                            }

                     }
              }).start();
       }

       public void TenDN() {
              String tenDN = this.staff.getName();
              this.TenDN_label.setText(tenDN);
       }

       public JLabel getPicture_label() {
              return picture_label;
       }

       public JLabel getQLBTAN_label() {
              return QLBTAN_label;
       }

       public Button getBtnQunLNhn() {
              return btnQunLNhn;
       }

       public Button getBtnQLHD() {
              return btnQLHD;
       }

       public Button getBtnQunLPhiu() {
              return btnQunLPhiu;
       }

       public Button getBtnQunLPhiu_2() {
              return btnQunLPhiu_2;
       }

       public Button getBtn_QLKho() {
              return btn_QLKho;
       }

       public Button getBtn_QLNCC() {
              return btn_QLNCC;
       }

       public Button getBtn_ThongKe() {
              return btn_ThongKe;
       }

       public DangNhap_view getDangNhap_view() {
              return dangNhap_view;
       }

       // di chuyen giua cac page
       public void btn_NhaCC() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(3, staff, this.danhSachNhaCC, this.dsPhieuNhap,
                            this.listProducts, this.staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public void btn_PhieuNhap() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(4, staff, this.danhSachNhaCC, this.dsPhieuNhap,
                            this.listProducts, this.staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public void btn_NhanVien() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(1, staff, danhSachNhaCC, dsPhieuNhap,
                            listProducts, staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public void btn_Kho() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(6, staff, danhSachNhaCC, dsPhieuNhap,
                            listProducts, staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public void btn_PhieuXuat() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(5, staff, danhSachNhaCC, dsPhieuNhap,
                            listProducts, staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public void btn_HoaDon() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(2, staff, danhSachNhaCC, dsPhieuNhap,
                            listProducts, staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public void btn_ThongKe() {
              this.tranhChinh_Menu_view_2 = new TrangChinh_Menu_view_2(7, staff, danhSachNhaCC, dsPhieuNhap,
                            listProducts, staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
       }

       public static void main(String[] args) {

       }
}
