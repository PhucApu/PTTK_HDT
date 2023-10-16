package DangNhap;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BUS.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import DTO.*;
// import TrangChinh.GiaoDienChinh_view;
// import TrangDangNhap.*;
import TrangChinh.GiaoDienChinh_view;

public class DangNhap_view extends JFrame {

	private JPanel contentPane;
	private JLabel BackGround_label;
	private JLabel DangNhap_label;
	private JLabel Username_label;
	private JTextField Username_textfield;
	private JLabel Password_label;
	private JPasswordField passwordField;
	private Button button_DN;
	private Button button_exit;

	private StaffsBUS staffs;
	private DanhSachNhaCCBUS danhSachNhaCC;
	private dsPhieuNhapBUS dsPhieuNhap;
	private ListProductsBUS listProducts;
	private dsPhieuXuatBUS dsPhieuXuat;
	private DanhSachHDBUS danhSachHD;
	private ThongKeDTO thongKe;
	private dsPhieuHuyBUS dsPhieuHuyBUS;
	private GioiThieu_panel gioiThieu_panel;
	private JPanel panel;

	public DangNhap_view(StaffsBUS staffs, DanhSachNhaCCBUS danhSachNhaCC, dsPhieuNhapBUS dsPhieuNhap,
			ListProductsBUS listProducts, dsPhieuXuatBUS dsPhieuXuat, DanhSachHDBUS danhSachHD,
			ThongKeDTO thongKe, dsPhieuHuyBUS dsPhieuHuyBUS) {
		this.staffs = staffs;
		this.danhSachNhaCC = danhSachNhaCC;
		this.dsPhieuNhap = dsPhieuNhap;
		this.listProducts = listProducts;
		this.dsPhieuXuat = dsPhieuXuat;
		this.danhSachHD = danhSachHD;
		this.thongKe = thongKe;
		this.dsPhieuHuyBUS = dsPhieuHuyBUS;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 809, 490);
		setResizable(false);
		setTitle("ĐĂNG NHẬP");
		setIconImage((new ImageIcon("image_icon\\user.png")).getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color mau = new Color(111, 164, 159);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		gioiThieu_panel = new GioiThieu_panel();
		gioiThieu_panel.setVisible(true);

		contentPane.add(gioiThieu_panel);

		panel = new JPanel();
		panel.setBounds(0, 0, 800, 450);
		panel.setVisible(false);
		contentPane.add(panel);
		panel.setLayout(null);

		button_exit = new Button("ĐĂNG NHẬP");
		button_exit.setBounds(588, 363, 147, 34);
		panel.add(button_exit);
		button_exit.setText("THOÁT");
		button_exit.setRadius(20);
		button_exit.setForeground(Color.WHITE);
		button_exit.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_exit.setBackground(new Color(111, 164, 159));
		button_exit.setBorderPainted(false);

		button_DN = new Button("ĐĂNG NHẬP");
		button_DN.setBounds(387, 363, 158, 34);
		panel.add(button_DN);
		button_DN.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_DN.setRadius(20);
		button_DN.setBackground(mau);
		button_DN.setForeground(Color.WHITE);
		button_DN.setBorderPainted(false);

		passwordField = new JPasswordField();
		passwordField.setBounds(512, 277, 198, 28);
		panel.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		// passwordField.setEnabled(false);
		passwordField.setBorder(new LineBorder(mau));

		Password_label = new JLabel("PASSWORD :", SwingConstants.CENTER);
		Password_label.setBounds(388, 271, 129, 34);
		panel.add(Password_label);
		Password_label.setForeground(new Color(111, 164, 159));
		Password_label.setFont(new Font("Tahoma", Font.BOLD, 18));

		Username_textfield = new JTextField();
		Username_textfield.setBounds(512, 156, 198, 27);
		panel.add(Username_textfield);
		Username_textfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		Username_textfield.setForeground(Color.BLACK);
		// Username_textfield.setEnabled(false);
		Username_textfield.setColumns(10);
		Username_textfield.setBorder(new LineBorder(mau)); // son mau vien cua boder

		Username_label = new JLabel("USERNAME :", JLabel.CENTER);
		Username_label.setBounds(388, 153, 129, 34);
		panel.add(Username_label);
		Username_label.setFont(new Font("Tahoma", Font.BOLD, 18));
		Username_label.setForeground(mau);

		DangNhap_label = new JLabel("ĐĂNG NHẬP", JLabel.CENTER);
		DangNhap_label.setBounds(446, 29, 275, 61);
		panel.add(DangNhap_label);
		DangNhap_label.setFont(new Font("Tahoma", Font.BOLD, 40));
		DangNhap_label.setForeground(mau);

		BackGround_label = new JLabel("");
		BackGround_label.setBounds(0, 0, 800, 450);
		panel.add(BackGround_label);
		BackGround_label.setFont(new Font("Tahoma", Font.BOLD, 18));
		BackGround_label.setIcon(new ImageIcon("image_icon\\Background_DN.jpg"));

		// controler
		// controller_UserTextField controller = new controller_UserTextField(this);
		Username_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						getUsername_textfield().setText("");
					}
				}).start();

			}
		});

		// controler_buttonThoat controler_buttonThoat = new
		// controler_buttonThoat(this);
		this.button_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sys.Sound_Click();
				int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (chon == 0) {
					setVisible(false);
					dispose();
					System.exit(0);
				}

			}
		});

		// controller_buttonDangNhap controller_buttonDangNhap = new
		// controller_buttonDangNhap(this);
		this.button_DN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						Sys.Sound_Click();
						DN();
					}
				}).start();
				;

			}
		});

		// controller_Music_GioiThieu controller_Music_GioiThieu = new
		// controller_Music_GioiThieu(this);
		gioiThieu_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Sys.Sound_GioiThieu().close();
				getGioiThieu_panel().setVisible(false);
				getPanel().setVisible(true);
			}
		});

		setVisible(true);
	}

	public GioiThieu_panel getGioiThieu_panel() {
		return gioiThieu_panel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JTextField getUsername_textfield() {
		return Username_textfield;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public ArrayList<StaffDTO> Check_DN() {
		ArrayList<StaffDTO> list_Staffs = staffs.getStaffs();
		return list_Staffs;
	}

	public void TrangChinh(StaffDTO staff) {
		// kich hoat giao dien chinh
		GiaoDienChinh_view giaoDienChinh_view = new GiaoDienChinh_view(staff,
		danhSachNhaCC, dsPhieuNhap,
		listProducts, staffs, dsPhieuXuat, danhSachHD, thongKe,dsPhieuHuyBUS, this);
	}

	public void DN() {
		String maNV = getUsername_textfield().getText();
		String passNV = getPasswordField().getText();
		System.out.println(maNV + " " + passNV);
		StaffDTO NguoiDN = this.staffs.checkDN(maNV, passNV);
		if (NguoiDN != null) {

			TrangChinh(NguoiDN);
			setVisible(false);
			dispose();
		} else {
			// JOptionPane.showConfirmDialog(null, "Sai thông tin đăng nhập", "Thông báo",
			// JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("Sai thông tin đăng nhập");
		}

	}
}
