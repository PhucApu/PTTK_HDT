package TrangQuanLyNhanVien;

import java.awt.Color;

import java.awt.Font;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import DTO.*;
import BUS.*;

public class SuaNhanVien_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel QLPhieuNhanVien_label;
	private JTextField TenNV_textField;
	private Color mau_chu = new Color(97, 113, 67);
	private JLabel NgaySinh_label;
	private JTextField NgaySinh_textField;
	private JLabel Anh_label;
	private JLabel Ten_label;
	private JLabel GioiTinh_label;
	private JTextField ThanhPho_textField;
	private JTextField Quan_textField;
	private JTextField Xa_textField;
	private JTextField CMND_textField;
	private JPanel ThongTinNV_panel;
	private JPanel ThongTinDN_panel;
	private JLabel IDNhanVien_label;
	private JLabel GanIDNhanVien_label;
	// private JTextField IDNV_textField;
	private JLabel Pass_label;
	private JTextField Pass_textField;
	private JLabel ChucVu_label;
	private JLabel LuongCB_label;
	private JTextField Luong_textField;
	private JLabel SoGioLam_label;
	private JPanel ThongTinLuong_panel;
	private JTextField SoGio_textField;
	private JLabel SoNgayLam_label;
	private JTextField SongayLam_textField;
	private JLabel PhuCap_label;
	private JTextField PhuCap_textField;
	private button_custom btn_SuaNV;
	private JComboBox GioiTinh_comboBox;
	private JLabel GanChucVu_label;

	/**
	 * Create the frame.
	 */
	private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;

	public SuaNhanVien_Frame(TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
		this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 810, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		QLPhieuNhanVien_label = new JLabel("SỬA NHÂN VIÊN", SwingConstants.CENTER);
		QLPhieuNhanVien_label.setForeground(new Color(97, 113, 67));
		QLPhieuNhanVien_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLPhieuNhanVien_label.setBounds(84, 10, 630, 40);
		contentPane.add(QLPhieuNhanVien_label);

		Anh_label = new JLabel("", JLabel.CENTER);
		Anh_label.setIcon(new ImageIcon("image_icon\\picture.png"));
		Anh_label.setBounds(323, 60, 140, 185);
		contentPane.add(Anh_label);

		ThongTinNV_panel = new JPanel();
		ThongTinNV_panel.setBounds(54, 255, 681, 156);
		ThongTinNV_panel.setBackground(new Color(246, 225, 195));
		ThongTinNV_panel.setBorder(BorderFactory.createTitledBorder("Thông tin cá nhân"));
		contentPane.add(ThongTinNV_panel);
		ThongTinNV_panel.setLayout(null);

		Ten_label = new JLabel("HỌ TÊN:");
		Ten_label.setBounds(32, 22, 71, 30);
		ThongTinNV_panel.add(Ten_label);
		Ten_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		TenNV_textField = new JTextField();
		TenNV_textField.setBounds(115, 25, 141, 23);
		ThongTinNV_panel.add(TenNV_textField);
		TenNV_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenNV_textField.setColumns(10);
		TenNV_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		NgaySinh_label = new JLabel("NGÀY SINH:");
		NgaySinh_label.setBounds(32, 62, 88, 30);
		ThongTinNV_panel.add(NgaySinh_label);
		NgaySinh_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		NgaySinh_textField = new JTextField();
		NgaySinh_textField.setBounds(115, 65, 141, 23);
		ThongTinNV_panel.add(NgaySinh_textField);
		NgaySinh_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NgaySinh_textField.setColumns(10);
		NgaySinh_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		GioiTinh_label = new JLabel("GIỚI TÍNH: ");
		GioiTinh_label.setBounds(437, 22, 88, 30);
		ThongTinNV_panel.add(GioiTinh_label);
		GioiTinh_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		GioiTinh_comboBox = new JComboBox();
		GioiTinh_comboBox.setBounds(513, 27, 61, 21);
		ThongTinNV_panel.add(GioiTinh_comboBox);
		GioiTinh_comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		// GioiTinh_comboBox.setModel(new DefaultComboBoxModel(new String[] { "Nam",
		// "Nu" }));
		setGioiTinh();

		JLabel ThanhPho_label = new JLabel("TỈNH/THÀNH PHỐ: ");
		ThanhPho_label.setBounds(10, 102, 118, 30);
		ThongTinNV_panel.add(ThanhPho_label);
		ThanhPho_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		ThanhPho_textField = new JTextField();
		ThanhPho_textField.setBounds(128, 105, 106, 23);
		ThongTinNV_panel.add(ThanhPho_textField);
		ThanhPho_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ThanhPho_textField.setColumns(10);
		ThanhPho_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		JLabel Quan_label = new JLabel("QUẬN/HUYỆN: ");
		Quan_label.setBounds(244, 98, 118, 30);
		ThongTinNV_panel.add(Quan_label);
		Quan_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		Quan_textField = new JTextField();
		Quan_textField.setBounds(337, 105, 95, 23);
		ThongTinNV_panel.add(Quan_textField);
		Quan_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Quan_textField.setColumns(10);
		Quan_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		JLabel Xa_label = new JLabel("XÃ/PHƯỜNG:");
		Xa_label.setBounds(454, 102, 106, 30);
		ThongTinNV_panel.add(Xa_label);
		Xa_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		Xa_textField = new JTextField();
		Xa_textField.setBounds(547, 105, 95, 23);
		ThongTinNV_panel.add(Xa_textField);
		Xa_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Xa_textField.setColumns(10);
		Xa_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		JLabel CMND_label = new JLabel("CMND: ");
		CMND_label.setBounds(437, 62, 106, 30);
		ThongTinNV_panel.add(CMND_label);
		CMND_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		CMND_textField = new JTextField();
		CMND_textField.setBounds(486, 65, 155, 23);
		ThongTinNV_panel.add(CMND_textField);
		CMND_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CMND_textField.setColumns(10);
		CMND_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		ThongTinDN_panel = new JPanel();
		ThongTinDN_panel.setBounds(136, 432, 497, 65);
		ThongTinDN_panel.setBorder(BorderFactory.createTitledBorder("Thông tin đăng nhập"));
		ThongTinDN_panel.setBackground(new Color(246, 225, 195));
		contentPane.add(ThongTinDN_panel);
		ThongTinDN_panel.setLayout(null);

		IDNhanVien_label = new JLabel("ID NHÂN VIÊN: ");
		IDNhanVien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		IDNhanVien_label.setBounds(33, 18, 106, 30);
		ThongTinDN_panel.add(IDNhanVien_label);

		GanIDNhanVien_label = new JLabel("..... ");
		GanIDNhanVien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanIDNhanVien_label.setBounds(128, 21, 106, 23);
		ThongTinDN_panel.add(GanIDNhanVien_label);

		// IDNV_textField = new JTextField();
		// IDNV_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		// IDNV_textField.setColumns(10);
		// IDNV_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		// IDNV_textField.setBounds(128, 21, 106, 23);
		// ThongTinDN_panel.add(IDNV_textField);

		Pass_label = new JLabel("PASSWORD:");
		Pass_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Pass_label.setBounds(270, 18, 106, 30);
		ThongTinDN_panel.add(Pass_label);

		Pass_textField = new JTextField();
		Pass_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Pass_textField.setColumns(10);
		Pass_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		Pass_textField.setBounds(351, 21, 106, 23);
		ThongTinDN_panel.add(Pass_textField);

		ChucVu_label = new JLabel("CHỨC VỤ: ");
		ChucVu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ChucVu_label.setBounds(282, 520, 83, 30);
		contentPane.add(ChucVu_label);

		btn_SuaNV = new button_custom("SỬA");
		btn_SuaNV.setIcon(new ImageIcon("image_icon\\maintenance.png"));
		btn_SuaNV.setRadius(10);
		btn_SuaNV.setForeground(Color.WHITE);
		btn_SuaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_SuaNV.setBorderPainted(false);
		btn_SuaNV.setBounds(145, 648, 121, 35);
		contentPane.add(btn_SuaNV);

		button_custom btn_Thoat = new button_custom("THOÁT");
		btn_Thoat.setText("THOÁT");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(497, 648, 121, 35);

		contentPane.add(btn_Thoat);

		ThongTinLuong_panel = new JPanel();
		ThongTinLuong_panel.setBounds(64, 562, 671, 65);
		ThongTinLuong_panel.setBackground(new Color(246, 225, 195));
		ThongTinLuong_panel.setBorder(BorderFactory.createTitledBorder("Thông tin lương"));
		contentPane.add(ThongTinLuong_panel);
		ThongTinLuong_panel.setLayout(null);

		LuongCB_label = new JLabel("LƯƠNG CƠ BẢN:");
		LuongCB_label.setBounds(10, 15, 111, 30);
		ThongTinLuong_panel.add(LuongCB_label);
		LuongCB_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		Luong_textField = new JTextField();
		Luong_textField.setBounds(116, 18, 45, 23);
		ThongTinLuong_panel.add(Luong_textField);
		Luong_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Luong_textField.setColumns(10);
		Luong_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		SoGioLam_label = new JLabel("SỐ GIỜ LÀM: ");
		SoGioLam_label.setBounds(184, 15, 92, 30);
		ThongTinLuong_panel.add(SoGioLam_label);
		SoGioLam_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		SoGio_textField = new JTextField();
		SoGio_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SoGio_textField.setColumns(10);
		SoGio_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		SoGio_textField.setBounds(271, 18, 45, 23);
		ThongTinLuong_panel.add(SoGio_textField);

		SoNgayLam_label = new JLabel("SỐ NGÀY LÀM VIỆC:");
		SoNgayLam_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		SoNgayLam_label.setBounds(340, 15, 134, 30);
		ThongTinLuong_panel.add(SoNgayLam_label);

		SongayLam_textField = new JTextField();
		SongayLam_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SongayLam_textField.setColumns(10);
		SongayLam_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		SongayLam_textField.setBounds(473, 18, 45, 23);
		ThongTinLuong_panel.add(SongayLam_textField);

		PhuCap_label = new JLabel("PHỤ CẤP: ");
		PhuCap_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		PhuCap_label.setBounds(527, 15, 72, 30);
		ThongTinLuong_panel.add(PhuCap_label);

		PhuCap_textField = new JTextField();
		PhuCap_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PhuCap_textField.setColumns(10);
		PhuCap_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		PhuCap_textField.setBounds(595, 18, 45, 23);
		ThongTinLuong_panel.add(PhuCap_textField);

		GanChucVu_label = new JLabel("....");
		GanChucVu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanChucVu_label.setBounds(357, 520, 106, 30);
		contentPane.add(GanChucVu_label);

		// controller
		controller_AnhVn_SuaNhanVienFrame controller_AnhNV_ThemNhanVienFrame = new controller_AnhVn_SuaNhanVienFrame(
				this);
		this.Anh_label.addMouseListener(controller_AnhNV_ThemNhanVienFrame);
		controller_btnThoat_SuaNVFrame controller_btnThoat_SuaNVFrame = new controller_btnThoat_SuaNVFrame(this,
				trangQuanLyNhanVien_view);
		btn_Thoat.addMouseListener(controller_btnThoat_SuaNVFrame);
		controller_btnSuaNV_SuaNVFrame controller_btnSuaNV_SuaNVFrame = new controller_btnSuaNV_SuaNVFrame(this);
		btn_SuaNV.addMouseListener(controller_btnSuaNV_SuaNVFrame);
		controller_AnhVn_SuaNhanVienFrame controller_AnhVn_SuaNhanVienFrame = new controller_AnhVn_SuaNhanVienFrame(this);
		Anh_label.addMouseListener(controller_AnhVn_SuaNhanVienFrame);

		showThongtin();

		setVisible(true);
	}

	public void chonAnh() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			String link_anh = "D:\\DO_AN_JAVA_TONG_KET\\DoAnOOP_Nhom10\\image_icon\\AnhNV\\"
					+ chooser.getSelectedFile().getName();
			this.Anh_label.setIcon(new ImageIcon(link_anh));
		}
	}

	public void setAnh(String maNV) {
		String link_anh = "D:\\DO_AN_JAVA_TONG_KET\\DoAnOOP_Nhom10\\image_icon\\AnhNV\\" + maNV + ".jpg";
		this.Anh_label.setIcon(new ImageIcon(link_anh));
	}

	public void setGioiTinh() {
		this.GioiTinh_comboBox.addItem(new ComboItem("Nam", "Nam"));
		this.GioiTinh_comboBox.addItem(new ComboItem("Nu", "Nu"));
	}

	public void setThongtinLuong(String chucVu) {
		if (chucVu.equals("Manager")) {
			this.ThongTinLuong_panel.setLocation(64, 562);
			this.ThongTinLuong_panel.setSize(671, 65);
			this.SoGioLam_label.setText("THƯỞNG:");
		} else if (chucVu.equals("FullTimeStaff")) {
			this.ThongTinLuong_panel.setLocation(130, 562);
			this.ThongTinLuong_panel.setSize(525, 65);
			this.SoGioLam_label.setText("THƯỞNG:");
		} else if (chucVu.equals("SeasonalStaff")) {
			this.ThongTinLuong_panel.setLocation(230, 562);
			this.ThongTinLuong_panel.setSize(332, 65);
			this.SoGioLam_label.setText("SỐ GIỜ LÀM: ");
		}
	}

	public void showThongtin() {
		StaffDTO staff = this.trangQuanLyNhanVien_view.Click_table();
		if (staff != null) {
			// thong tin nhan vien
			String maNv = staff.getId();
			setAnh(maNv);
			this.TenNV_textField.setText(staff.getName());
			this.CMND_textField.setText(staff.getCmnd());

			// goi tinh
			String gender = staff.getGender();
			if (gender.equals("Nam")) {
				this.GioiTinh_comboBox.addItem(new ComboItem("Nam", "Nam"));
				this.GioiTinh_comboBox.addItem(new ComboItem("Nu", "Nu"));
			}
			if (gender.equals("Nu")) {
				this.GioiTinh_comboBox.addItem(new ComboItem("Nu", "Nu"));
				this.GioiTinh_comboBox.addItem(new ComboItem("Nam", "Nam"));
			}

			this.NgaySinh_textField.setText(staff.getDate());
			this.ThanhPho_textField.setText(staff.getAddress().getCity());
			this.Quan_textField.setText(staff.getAddress().getDistrict());
			this.Xa_textField.setText(staff.getAddress().getStreet());
			// thong tin dang nhap
			this.GanIDNhanVien_label.setText(maNv);
			this.Pass_textField.setText(staff.getPassWord());
			// thong tin luong
			// kiem tra chuc vu
			if (staff instanceof ManagerDTO) {
				ManagerDTO manager = (ManagerDTO) staff;
				this.GanChucVu_label.setText("Manager");
				setThongtinLuong("Manager");
				this.Luong_textField.setText(String.valueOf(manager.getBaseSalary()));
				this.SongayLam_textField.setText(String.valueOf(manager.getWorkDays()));
				this.SoGio_textField.setText(String.valueOf(manager.getBonusRate()));
				this.PhuCap_textField.setText(String.valueOf(manager.getAllowance()));
			} else if (staff instanceof FullTimeStaffDTO) {
				FullTimeStaffDTO fullTimeStaff = (FullTimeStaffDTO) staff;
				this.GanChucVu_label.setText("FullTimeStaff");
				setThongtinLuong("FullTimeStaff");
				this.Luong_textField.setText(String.valueOf(fullTimeStaff.getBaseSalary()));
				this.SongayLam_textField.setText(String.valueOf(fullTimeStaff.getWorkDays()));
				this.SoGio_textField.setText(String.valueOf(fullTimeStaff.getBonusRate()));

			} else {
				SeasonalStaffDTO seasonalStaff = (SeasonalStaffDTO) staff;
				this.GanChucVu_label.setText("SeasonalStaff");
				setThongtinLuong("SeasonalStaff");
				this.Luong_textField.setText(String.valueOf(seasonalStaff.getHourlyWage()));
				this.SoGio_textField.setText(String.valueOf(seasonalStaff.getWorkHours()));
			}
		}
	}

	public void SuaThongtinNV_check() {
		String Id = this.GanIDNhanVien_label.getText();

		int check_them = 0;

		String name = this.TenNV_textField.getText();
		String CMND = this.CMND_textField.getText();
		String date = this.NgaySinh_textField.getText();

		Object item = this.GioiTinh_comboBox.getSelectedItem();
		String gender = ((ComboItem) item).getValue();

		String city = this.ThanhPho_textField.getText();
		String district = this.Quan_textField.getText();
		String pass = this.Pass_textField.getText();
		String street = this.Xa_textField.getText();
		AddressDTO diachi = new AddressDTO(city, district, street);

		if (Sys.takeCMND_2(CMND) == true && Sys.takeStaffIDInput_2(Id) == true
				&& Sys.takeDateInput_2(date) == true) {
			String chucVu = this.GanChucVu_label.getText();
			if (chucVu.equals("Manager")) {
				String LuongCB = this.Luong_textField.getText();
				String SoNgayLam = this.SongayLam_textField.getText();
				String PhuCap = this.PhuCap_textField.getText();
				String LuongThuong = this.SoGio_textField.getText();
				if (Sys.takeFloatInput_2(LuongThuong) == true
						&& Sys.takeIntegerInput_2(LuongCB) == true
						&& Sys.takeIntegerInput_2(SoNgayLam) == true
						&& Sys.takeIntegerInput_2(PhuCap) == true) {
					int baseSalary = Integer.parseInt(LuongCB);
					int workDays = Integer.parseInt(SoNgayLam);
					float bonusRate = Float.parseFloat(LuongThuong);
					int allowance = Integer.parseInt(PhuCap);

					ManagerDTO manager = new ManagerDTO(Id, CMND, name, gender, diachi, date, pass, baseSalary,
							bonusRate, workDays, allowance);
					this.trangQuanLyNhanVien_view.SuaNhanVien_vaoDATA(manager);
					check_them = 1;
				} else {
					// JOptionPane.showConfirmDialog(null, "SAI DỮ LIỆU", "Thông báo",
					// 		JOptionPane.ERROR_MESSAGE);
					Sys.Sound_Error();
					Sys.Error_dialog("SAI DỮ LIỆU");
					
				}
			} else if (chucVu.equals("FullTimeStaff")) {
				String LuongCB = this.Luong_textField.getText();
				String SoNgayLam = this.SongayLam_textField.getText();
				String LuongThuong = this.SoGio_textField.getText();
				if (Sys.takeFloatInput_2(LuongThuong) == true
						&& Sys.takeIntegerInput_2(LuongCB) == true
						&& Sys.takeIntegerInput_2(SoNgayLam) == true) {
					int baseSalary = Integer.parseInt(LuongCB);
					int workDays = Integer.parseInt(SoNgayLam);
					float bonusRate = Float.parseFloat(LuongThuong);

					FullTimeStaffDTO fullTimeStaff = new FullTimeStaffDTO(Id, CMND, name, gender, diachi, date,
							pass, baseSalary, bonusRate, workDays);
					this.trangQuanLyNhanVien_view.SuaNhanVien_vaoDATA(fullTimeStaff);
					check_them = 1;
				} else {
					Sys.Sound_Error();
					Sys.Error_dialog("SAI DỮ LIỆU");
					
				}
			} else if (chucVu.equals("SeasonalStaff")) {
				String LuongCB = this.Luong_textField.getText();
				String SoGioLam = this.SoGio_textField.getText();
				if (Sys.takeIntegerInput_2(LuongCB) == true && Sys.takeIntegerInput_2(SoGioLam) == true) {
					int hourlyWage = Integer.parseInt(LuongCB);
					int workHours = Integer.parseInt(SoGioLam);

					SeasonalStaffDTO seasonalStaff = new SeasonalStaffDTO(Id, CMND, name, gender, diachi, date,
							pass, hourlyWage, workHours);
					this.trangQuanLyNhanVien_view.SuaNhanVien_vaoDATA(seasonalStaff);
					check_them = 1;
				} else {
					Sys.Sound_Error();
					Sys.Error_dialog("SAI DỮ LIỆU");
					
				}
			}

		} else {
			Sys.Sound_Error();
			Sys.Error_dialog("SAI DỮ LIỆU");
			
		}

		if (check_them == 1) {
			this.setVisible(false);
			this.dispose();
			this.trangQuanLyNhanVien_view.setCheck_open_Jrame(0);
		}

	}

	public static void main(String[] args) {
		// new SuaNhanVien_Frame();
	}

}
