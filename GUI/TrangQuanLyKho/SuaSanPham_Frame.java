package TrangQuanLyKho;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

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

import javax.swing.JCheckBox;

public class SuaSanPham_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel QLKho_label;
	private JTextField TenSP_textField;
	private Color mau_chu = new Color(97, 113, 67);
	private JLabel NgayNhapSP_label;
	private JTextField NgayNhapSP_textField;
	private JLabel Anh_label;
	private JLabel Ten_label;
	private JLabel IDnhaCC_label;
	private JTextField GiaSP_textField;

	private JPanel ThongTinSP_panel;

	private JComboBox LoaiSP_comboBox;
	private JTextField Luong_textField;

	private JPanel ThuocTinhSP_panel;
	private JTextField SoGio_textField;

	private button_custom btn_SuaSP;
	private JComboBox IDnhaCC_comboBox;
	private JTextField NgayHetHan_textField;
	private JLabel SoLuongSP_label;
	private JTextField SoLuongSP_textField;
	private JCheckBox DongLanh_CheckBox;
	private JCheckBox Chay_CheckBox;
	private JLabel LoaiSP_label;
	private JCheckBox Con_CheckBox;
	private button_custom btn_Thoat;
	private JLabel IDSanPham_label;
	private JLabel GanIDSanPham_label;
	private JLabel GanLoaiSP;

	/**
	 * Create the frame.
	 */
	private TrangQuanLyKho_view trangQuanLyKho_view;

	public SuaSanPham_Frame(TrangQuanLyKho_view trangQuanLyKho_view) {
		this.trangQuanLyKho_view = trangQuanLyKho_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 810, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		QLKho_label = new JLabel("SỬA SẢN PHẨM", SwingConstants.CENTER);
		QLKho_label.setForeground(new Color(97, 113, 67));
		QLKho_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLKho_label.setBounds(84, 10, 630, 40);
		contentPane.add(QLKho_label);

		Anh_label = new JLabel("", JLabel.CENTER);
		Anh_label.setIcon(new ImageIcon("image_icon\\picture.png"));
		Anh_label.setBounds(323, 60, 140, 185);
		contentPane.add(Anh_label);

		ThongTinSP_panel = new JPanel();
		ThongTinSP_panel.setBounds(54, 255, 681, 179);
		ThongTinSP_panel.setBackground(new Color(246, 225, 195));
		ThongTinSP_panel.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
		contentPane.add(ThongTinSP_panel);
		ThongTinSP_panel.setLayout(null);

		Ten_label = new JLabel("TÊN:");
		Ten_label.setBounds(32, 56, 71, 30);
		ThongTinSP_panel.add(Ten_label);
		Ten_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		TenSP_textField = new JTextField();
		TenSP_textField.setBounds(115, 59, 141, 23);
		ThongTinSP_panel.add(TenSP_textField);
		TenSP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenSP_textField.setColumns(10);
		TenSP_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		NgayNhapSP_label = new JLabel("NGÀY NHẬP:");
		NgayNhapSP_label.setBounds(32, 92, 88, 30);
		ThongTinSP_panel.add(NgayNhapSP_label);
		NgayNhapSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		NgayNhapSP_textField = new JTextField();
		NgayNhapSP_textField.setBounds(115, 95, 141, 23);
		ThongTinSP_panel.add(NgayNhapSP_textField);
		NgayNhapSP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NgayNhapSP_textField.setColumns(10);
		NgayNhapSP_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		IDnhaCC_label = new JLabel("NHÀ CUNG CẤP: ");
		IDnhaCC_label.setBounds(391, 56, 119, 30);
		ThongTinSP_panel.add(IDnhaCC_label);
		IDnhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		IDnhaCC_comboBox = new JComboBox();
		IDnhaCC_comboBox.setBounds(501, 59, 105, 25);
		ThongTinSP_panel.add(IDnhaCC_comboBox);
		IDnhaCC_comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		setIDnhaCC();

		JLabel GiaSP_label = new JLabel("GIÁ/CÁI:");
		GiaSP_label.setBounds(32, 124, 118, 30);
		ThongTinSP_panel.add(GiaSP_label);
		GiaSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		GiaSP_textField = new JTextField();
		GiaSP_textField.setBounds(115, 127, 141, 23);
		ThongTinSP_panel.add(GiaSP_textField);
		GiaSP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GiaSP_textField.setColumns(10);
		GiaSP_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		JLabel DonViTien_label = new JLabel("$");
		DonViTien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		DonViTien_label.setBounds(266, 124, 55, 30);
		ThongTinSP_panel.add(DonViTien_label);

		JLabel NgayHetHan_label = new JLabel("NGÀY HẾT HẠN:");
		NgayHetHan_label.setBounds(392, 92, 118, 30);
		ThongTinSP_panel.add(NgayHetHan_label);
		NgayHetHan_label.setFont(new Font("Tahoma", Font.BOLD, 12));

		NgayHetHan_textField = new JTextField();
		NgayHetHan_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NgayHetHan_textField.setColumns(10);
		NgayHetHan_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		NgayHetHan_textField.setBounds(501, 95, 141, 23);
		ThongTinSP_panel.add(NgayHetHan_textField);

		SoLuongSP_label = new JLabel("SỐ LƯỢNG:");
		SoLuongSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		SoLuongSP_label.setBounds(393, 124, 118, 30);
		ThongTinSP_panel.add(SoLuongSP_label);

		SoLuongSP_textField = new JTextField();
		SoLuongSP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SoLuongSP_textField.setColumns(10);
		SoLuongSP_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		SoLuongSP_textField.setBounds(501, 127, 141, 23);
		ThongTinSP_panel.add(SoLuongSP_textField);

		IDSanPham_label = new JLabel("ID SẢN PHẨM:");
		IDSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		IDSanPham_label.setBounds(32, 16, 118, 30);
		ThongTinSP_panel.add(IDSanPham_label);

		GanIDSanPham_label = new JLabel("....");
		GanIDSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanIDSanPham_label.setBounds(138, 16, 118, 30);
		ThongTinSP_panel.add(GanIDSanPham_label);

		// LoaiSP_comboBox = new JComboBox();
		// // ChucVu_comboBox.setModel(new DefaultComboBoxModel(new String[] {"",
		// // "SeasonalStaff", "FullTimeStaff", "Manager"}));
		// LoaiSP_comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		// LoaiSP_comboBox.setBounds(368, 444, 124, 26);
		// contentPane.add(LoaiSP_comboBox);
		GanLoaiSP = new JLabel("...");
		GanLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanLoaiSP.setBounds(368, 444, 118, 30);
		contentPane.add(GanLoaiSP);
		setLoaiSP();

		ThuocTinhSP_panel = new JPanel();
		ThuocTinhSP_panel.setBounds(187, 490, 460, 80);
		ThuocTinhSP_panel.setBackground(new Color(246, 225, 195));
		ThuocTinhSP_panel.setBorder(BorderFactory.createTitledBorder("Thuộc tính sản phẩm"));
		contentPane.add(ThuocTinhSP_panel);
		ThuocTinhSP_panel.setLayout(null);

		Chay_CheckBox = new JCheckBox("THỰC PHẨM CHAY");
		Chay_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		Chay_CheckBox.setBackground(new Color(246, 225, 195));
		Chay_CheckBox.setBounds(54, 28, 154, 28);

		ThuocTinhSP_panel.add(Chay_CheckBox);

		DongLanh_CheckBox = new JCheckBox("THỰC PHẨM ĐÔNG LẠNH");
		DongLanh_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		DongLanh_CheckBox.setBackground(new Color(246, 225, 195));
		DongLanh_CheckBox.setBounds(250, 28, 197, 28);
		ThuocTinhSP_panel.add(DongLanh_CheckBox);

		Con_CheckBox = new JCheckBox("ĐỒ UỐNG CÓ CỒN");
		Con_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		Con_CheckBox.setBackground(new Color(246, 225, 195));
		Con_CheckBox.setBounds(478, 28, 165, 28);
		ThuocTinhSP_panel.add(Con_CheckBox);

		LoaiSP_label = new JLabel("LOẠI SẢN PHẨM:");
		LoaiSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		LoaiSP_label.setBounds(240, 444, 118, 30);
		contentPane.add(LoaiSP_label);

		btn_SuaSP = new button_custom("SỬA");
		btn_SuaSP.setIcon(new ImageIcon("image_icon\\maintenance.png"));
		btn_SuaSP.setRadius(10);
		btn_SuaSP.setForeground(Color.WHITE);
		btn_SuaSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_SuaSP.setBorderPainted(false);
		btn_SuaSP.setBounds(187, 607, 121, 35);
		contentPane.add(btn_SuaSP);

		btn_Thoat = new button_custom("THOÁT");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(526, 607, 121, 35);
		contentPane.add(btn_Thoat);


		showThongTin();
		// controller
		// controller_LoaiSPCombobox controller_LoaiSPCombobox = new controller_LoaiSPCombobox(this);
		// LoaiSP_comboBox.addActionListener(controller_LoaiSPCombobox);
		controller_btnSua_SuaFrame controller_btnSua_SuaFrame = new controller_btnSua_SuaFrame(this);
		btn_SuaSP.addMouseListener(controller_btnSua_SuaFrame);
		controller_AnhSP_SuaSPFrame controller_AnhSP_SuaSPFrame = new controller_AnhSP_SuaSPFrame(this);
		Anh_label.addMouseListener(controller_AnhSP_SuaSPFrame);
		controller_btnThoat_SuaFrame controller_btnThoat_SuaFrame = new controller_btnThoat_SuaFrame(trangQuanLyKho_view, this);
		btn_Thoat.addMouseListener(controller_btnThoat_SuaFrame);
		setVisible(true);
	}

	public void chonAnh() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			String link_anh = "D:\\DO_AN_JAVA_TONG_KET\\DoAnOOP_Nhom10\\image_icon\\AnhSP\\"
					+ chooser.getSelectedFile().getName();
			this.Anh_label.setIcon(new ImageIcon(link_anh));

		}
	}

	public void setLoaiSP() {
		// this.LoaiSP_comboBox.addItem(new ComboItem("Food", "Food"));
		// this.LoaiSP_comboBox.addItem(new ComboItem("Drink", "Drink"));

	}

	public void setIDnhaCC() {
		ArrayList<SupplierDTO> data = this.trangQuanLyKho_view.getDanhSachNhaCC().getListNCC();
		for (SupplierDTO iterable_element : data) {
			this.IDnhaCC_comboBox.addItem(new ComboItem(iterable_element.getMa(), iterable_element.getMa()));
		}
	}

	public void ThuocTinhSP() {

		// x = 54 , y = 490 , width = 680 , height = 80
		// food --> x = 187 , y = 490 , width = 460, height = 80
		// drink --> x = 262 , y = 490 , width = 230 , height = 80
		Object item = this.LoaiSP_comboBox.getSelectedItem();
		String value = ((ComboItem) item).getValue();
		if (value.equals("Food")) {
			this.ThuocTinhSP_panel.setSize(460, 80);
			this.ThuocTinhSP_panel.setLocation(187, 490);
			this.Chay_CheckBox.setLocation(54, 28);
			this.Con_CheckBox.setLocation(478, 28);
		} else if (value.equals("Drink")) {
			this.ThuocTinhSP_panel.setLocation(262, 490);
			this.ThuocTinhSP_panel.setSize(230, 80);
			this.Chay_CheckBox.setLocation(54, 100);
			this.Con_CheckBox.setLocation(54, 28);

		}
	}
	public void check_loai(String loai){
		if (loai.equals("Food")) {
			this.ThuocTinhSP_panel.setSize(460, 80);
			this.ThuocTinhSP_panel.setLocation(187, 490);
			this.Chay_CheckBox.setLocation(54, 28);
			this.Con_CheckBox.setLocation(478, 28);
		} else if (loai.equals("Drink")) {
			this.ThuocTinhSP_panel.setLocation(262, 490);
			this.ThuocTinhSP_panel.setSize(230, 80);
			this.Chay_CheckBox.setLocation(54, 100);
			this.Con_CheckBox.setLocation(54, 28);

		}

	}

	public void showThongTin() {
		ProductsDTO product = this.trangQuanLyKho_view.Click_table();
		if (product != null) {
			// thong tin products
			String maSP = product.getMaSP();
			this.GanIDSanPham_label.setText(maSP);
			setAnh(maSP);
			this.TenSP_textField.setText(product.getNameProduct());
			this.GiaSP_textField.setText(String.valueOf(product.getPrice()));
			// gan ma nha cc
			ArrayList<SupplierDTO> data = this.trangQuanLyKho_view.getDanhSachNhaCC().getListNCC();
			int index= 0;
			for (SupplierDTO supplier : data) {
				if( supplier.getMa().equals(product.getMaNCC()) ){
					this.IDnhaCC_comboBox.setSelectedIndex(index);
					break;
				}
				index++;
			}

			this.NgayHetHan_textField.setText(product.getExpiry_date());
			this.NgayNhapSP_textField.setText(Sys.getDateNow());
			this.SoLuongSP_textField.setText(String.valueOf(product.getSoluong()));
			// gan loai sp
			if (product instanceof FoodDTO) {
				this.GanLoaiSP.setText("Food");
				// ThuocTinhSP();
				check_loai("Food");
				FoodDTO food = (FoodDTO) product;
				boolean chay = food.isVegetarian();
				boolean donglanh = food.isFrozenfood();
				if (chay == true) {
					this.Chay_CheckBox.setSelected(true);
				}
				if (chay == false) {
					this.Chay_CheckBox.setSelected(false);
				}
				if (donglanh == true) {
					this.DongLanh_CheckBox.setSelected(true);
				}
				if (donglanh == false) {
					this.DongLanh_CheckBox.setSelected(false);
				}
			}
			if (product instanceof DrinkDTO) {
				this.GanLoaiSP.setText("Drink");
				// ThuocTinhSP();
				check_loai("Drink");
				DrinkDTO drink = (DrinkDTO) product;
				boolean con = drink.isAlcoholic();
				if (con == true) {
					this.Con_CheckBox.setSelected(true);
				}
				if (con == false) {
					this.Con_CheckBox.setSelected(false);
				}
			}
		}
	}

	public void SuaSP_check(){
		String maSP = this.GanIDSanPham_label.getText();
		String TenSP = this.TenSP_textField.getText();
		Object item = this.IDnhaCC_comboBox.getSelectedItem();
		String maNCC = ((ComboItem) item).getValue();
		String NgayHetHan = this.NgayHetHan_textField.getText();
		String DonGia = this.GiaSP_textField.getText();
		String SoLuong = this.SoLuongSP_textField.getText();
		System.out.println("hello1");
		if(Sys.takeIntegerInput_2(SoLuong) == true && Sys.takeIntegerInput_2(DonGia) == true && Sys.takeDateInput_2(NgayHetHan) == true){
			String Loai = this.GanLoaiSP.getText();
			int price = Integer.parseInt(DonGia);
			int soluong = Integer.parseInt(SoLuong);
			float taxes = Sys.Thue(price);
			if( Loai.equals("Food")){
				boolean Chay = false,donglanh = false;
				if( this.Chay_CheckBox.isSelected()){
					Chay = true;
				}
				if(this.DongLanh_CheckBox.isSelected()){
					donglanh = true;
				}
				FoodDTO food = new FoodDTO(TenSP, Chay, donglanh, price, NgayHetHan, maSP, maNCC, soluong, taxes);
				if(this.trangQuanLyKho_view.SuaProduct_vaoDATA(food)){
					this.trangQuanLyKho_view.setCheck_open_Jrame(0);
					this.setVisible(false);
					this.dispose();
				}
			}
			if( Loai.equals("Drink")){
				// System.out.println("hello4");
				boolean con = false;
				if(this.Con_CheckBox.isSelected()){
					con = true;
				}
				DrinkDTO drink = new DrinkDTO(TenSP, con, price, NgayHetHan, taxes, maSP, maNCC, soluong);
					if(this.trangQuanLyKho_view.SuaProduct_vaoDATA(drink)){
						this.trangQuanLyKho_view.setCheck_open_Jrame(0);
						this.setVisible(false);
						this.dispose();
					}
			}
		}
		else{
			// JOptionPane.showConfirmDialog(null, "SAI DỮ LIỆU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("SAI DỮ LIỆU");
			
		}
	}

	public void setAnh(String maSP) {
		// dua vao ma de set anh
		String link_anh = "D:\\DO_AN_JAVA_TONG_KET\\DoAnOOP_Nhom10\\image_icon\\AnhSP\\" + maSP + ".jpg";
		this.Anh_label.setIcon(new ImageIcon(link_anh));
	}

	public static void main(String[] args) {
		// new SuaSanPham_Frame();
	}
}
