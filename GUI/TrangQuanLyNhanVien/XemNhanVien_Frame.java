package TrangQuanLyNhanVien;

import java.awt.Color;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DTO.*;
import BUS.*;

public class XemNhanVien_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel QLPhieuNhanVien_label;
	private JLabel Anh_label;
	private Color mau_chu = new Color(97, 113, 67);
	private JLabel NgaySinh_label;
	private JLabel Ten_label;
	private JLabel GioiTinh_label;
	private JPanel ThongTinNV_panel;
	private JPanel ThongTinDN_panel;
	private JLabel IDNhanVien_label;
	private JLabel Pass_label;
	private JLabel ChucVu_label;
	private JLabel LuongCB_label;
	private JLabel SoGioLam_label;
	private JPanel ThongTinLuong_panel;
	private JLabel SoNgayLam_label;
	private JLabel PhuCap_label;
	private JLabel GanTen_label;
	private JLabel GanGioiTinh_label;
	private JLabel GanNgaySinh_label;
	private JLabel GanCMND_label;
	private JLabel GanThanhPho_label;
	private JLabel GanQuan_label;
	private JLabel GanXa_label;
	private JLabel GanIDNhanVien_label;
	private JLabel GanPass_label;
	private JLabel GanLuong_label;
	private JLabel GanGioLam_label;
	private JLabel GanNgayLam_label;
	private JLabel GanPhuCap_label;
	private JLabel GanChucVu_label;


	/**
	 * Create the frame.
	 */
	private TrangQuanLyNhanVien_view trangQuanLyNhanVien_view;
	public XemNhanVien_Frame(TrangQuanLyNhanVien_view trangQuanLyNhanVien_view) {
		this.trangQuanLyNhanVien_view = trangQuanLyNhanVien_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 810, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Anh_label = new JLabel("", SwingConstants.CENTER);
		Anh_label.setIcon(new ImageIcon("image_icon\\picture.png"));
		Anh_label.setBounds(323, 60, 140, 185);
		contentPane.add(Anh_label);

		QLPhieuNhanVien_label = new JLabel("XEM NHÂN VIÊN", SwingConstants.CENTER);
		QLPhieuNhanVien_label.setForeground(new Color(97, 113, 67));
		QLPhieuNhanVien_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLPhieuNhanVien_label.setBounds(84, 10, 630, 40);
		contentPane.add(QLPhieuNhanVien_label);
		

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

		NgaySinh_label = new JLabel("NGÀY SINH:");
		NgaySinh_label.setBounds(32, 62, 88, 30);
		ThongTinNV_panel.add(NgaySinh_label);
		NgaySinh_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		GioiTinh_label = new JLabel("GIỚI TÍNH: ");
		GioiTinh_label.setBounds(437, 22, 88, 30);
		ThongTinNV_panel.add(GioiTinh_label);
		GioiTinh_label.setFont(new Font("Tahoma", Font.BOLD, 12));
//		GioiTinh_comboBox.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nu" }));

		JLabel ThanhPho_label = new JLabel("TỈNH/THÀNH PHỐ: ");
		ThanhPho_label.setBounds(10, 102, 118, 30);
		ThongTinNV_panel.add(ThanhPho_label);
		ThanhPho_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel Quan_label = new JLabel("QUẬN/HUYỆN: ");
		Quan_label.setBounds(244, 98, 118, 30);
		ThongTinNV_panel.add(Quan_label);
		Quan_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel Xa_label = new JLabel("XÃ/PHƯỜNG:");
		Xa_label.setBounds(454, 102, 106, 30);
		ThongTinNV_panel.add(Xa_label);
		Xa_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel CMND_label = new JLabel("CMND: ");
		CMND_label.setBounds(437, 62, 106, 30);
		ThongTinNV_panel.add(CMND_label);
		CMND_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		GanTen_label = new JLabel(".....");
		GanTen_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanTen_label.setBounds(88, 22, 150, 30);
		ThongTinNV_panel.add(GanTen_label);

		GanGioiTinh_label = new JLabel(".....");
		GanGioiTinh_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanGioiTinh_label.setBounds(509, 22, 106, 30);
		ThongTinNV_panel.add(GanGioiTinh_label);

		GanNgaySinh_label = new JLabel(".....");
		GanNgaySinh_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanNgaySinh_label.setBounds(109, 62, 106, 30);
		ThongTinNV_panel.add(GanNgaySinh_label);

		GanCMND_label = new JLabel(".....");
		GanCMND_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanCMND_label.setBounds(486, 62, 129, 30);
		ThongTinNV_panel.add(GanCMND_label);

		GanThanhPho_label = new JLabel(".....");
		GanThanhPho_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanThanhPho_label.setBounds(128, 102, 106, 30);
		ThongTinNV_panel.add(GanThanhPho_label);

		GanQuan_label = new JLabel(".....");
		GanQuan_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanQuan_label.setBounds(338, 98, 106, 30);
		ThongTinNV_panel.add(GanQuan_label);

		GanXa_label = new JLabel(".....");
		GanXa_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanXa_label.setBounds(542, 102, 106, 30);
		ThongTinNV_panel.add(GanXa_label);

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

		Pass_label = new JLabel("PASSWORD:");
		Pass_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Pass_label.setBounds(270, 18, 106, 30);
		ThongTinDN_panel.add(Pass_label);

		GanIDNhanVien_label = new JLabel(".....");
		GanIDNhanVien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanIDNhanVien_label.setBounds(125, 18, 106, 30);
		ThongTinDN_panel.add(GanIDNhanVien_label);

		GanPass_label = new JLabel(".....");
		GanPass_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanPass_label.setBounds(356, 18, 106, 30);
		ThongTinDN_panel.add(GanPass_label);

		ChucVu_label = new JLabel("CHỨC VỤ: ");
		ChucVu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ChucVu_label.setBounds(282, 520, 83, 30);
		contentPane.add(ChucVu_label);

		button_custom btn_Thoat = new button_custom("THOÁT");
		btn_Thoat.setText("THOÁT");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(342, 647, 121, 35);

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

		SoGioLam_label = new JLabel("THƯỞNG: ");
		SoGioLam_label.setBounds(184, 15, 92, 30);
		ThongTinLuong_panel.add(SoGioLam_label);
		SoGioLam_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		SoNgayLam_label = new JLabel("SỐ NGÀY LÀM VIỆC:");
		SoNgayLam_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		SoNgayLam_label.setBounds(340, 15, 134, 30);
		ThongTinLuong_panel.add(SoNgayLam_label);

		PhuCap_label = new JLabel("PHỤ CẤP: ");
		PhuCap_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		PhuCap_label.setBounds(527, 15, 72, 30);
		ThongTinLuong_panel.add(PhuCap_label);

		GanLuong_label = new JLabel(".....");
		GanLuong_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanLuong_label.setBounds(116, 15, 58, 30);
		ThongTinLuong_panel.add(GanLuong_label);

		GanGioLam_label = new JLabel(".....");
		GanGioLam_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanGioLam_label.setBounds(272, 15, 58, 30);
		ThongTinLuong_panel.add(GanGioLam_label);

		GanNgayLam_label = new JLabel(".....");
		GanNgayLam_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanNgayLam_label.setBounds(467, 15, 58, 30);
		ThongTinLuong_panel.add(GanNgayLam_label);

		GanPhuCap_label = new JLabel(".....");
		GanPhuCap_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanPhuCap_label.setBounds(590, 15, 58, 30);
		ThongTinLuong_panel.add(GanPhuCap_label);

		GanChucVu_label = new JLabel(".....");
		GanChucVu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanChucVu_label.setBounds(357, 520, 106, 30);
		contentPane.add(GanChucVu_label);

		// controller
		controller_btnThoat_XemNVFrame controller_btnThoat_XemNVFrame = new controller_btnThoat_XemNVFrame(this, trangQuanLyNhanVien_view);
		btn_Thoat.addMouseListener(controller_btnThoat_XemNVFrame);
		// controller
		showThongtin();
		setVisible(true);
	}

	public void setAnh(String maNV) {
		// dua vao ma de set anh
		String link_anh = "image_icon\\AnhNV\\" + maNV + ".jpg";
		
		this.Anh_label.setIcon(new ImageIcon(link_anh));
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
	public void showThongtin(){
		StaffDTO staff = this.trangQuanLyNhanVien_view.Click_table();
		if( staff != null){
			// thong tin nhan vien
			String maNv = staff.getId();
			setAnh(maNv);
			this.GanTen_label.setText(staff.getName());
			this.GanCMND_label.setText(staff.getCmnd());
			this.GanGioiTinh_label.setText(staff.getGender());
			this.GanNgaySinh_label.setText(staff.getDate());
			this.GanThanhPho_label.setText(staff.getAddress().getCity());
			this.GanQuan_label.setText(staff.getAddress().getDistrict());
			this.GanXa_label.setText(staff.getAddress().getStreet());
			// thong tin dang nhap
			this.GanIDNhanVien_label.setText(maNv);
			this.GanPass_label.setText(staff.getPassWord());
			// thong tin luong
			// kiem tra chuc vu
			if( staff instanceof ManagerDTO){
				ManagerDTO manager = (ManagerDTO) staff;
				this.GanChucVu_label.setText("Manager");
				setThongtinLuong("Manager");
				this.GanLuong_label.setText( String.valueOf( manager.getBaseSalary() ));
				this.GanNgayLam_label.setText( String.valueOf( manager.getWorkDays()));
				this.GanGioLam_label.setText( String.valueOf( manager.getBonusRate()));
				this.GanPhuCap_label.setText( String.valueOf( manager.getAllowance()));
			}
			else if( staff instanceof FullTimeStaffDTO){
				FullTimeStaffDTO fullTimeStaff = (FullTimeStaffDTO) staff;
				this.GanChucVu_label.setText("FullTimeStaff");
				setThongtinLuong("FullTimeStaff");
				this.GanLuong_label.setText( String.valueOf( fullTimeStaff.getBaseSalary() ));
				this.GanNgayLam_label.setText( String.valueOf( fullTimeStaff.getWorkDays()));
				this.GanGioLam_label.setText( String.valueOf( fullTimeStaff.getBonusRate()));

			}
			else{
				SeasonalStaffDTO seasonalStaff = (SeasonalStaffDTO) staff;
				this.GanChucVu_label.setText("SeasonalStaff");
				setThongtinLuong("SeasonalStaff");
				this.GanLuong_label.setText( String.valueOf( seasonalStaff.getHourlyWage() ));
				this.GanGioLam_label.setText( String.valueOf( seasonalStaff.getWorkHours() ));
			}
		}
	}

	public static void main(String[] args) {
		// new XemNhanVien_Frame();
	}
}
