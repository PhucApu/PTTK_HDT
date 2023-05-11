package TrangQuanLyNhaCC;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DTO.*;
import BUS.*;

import javax.swing.ImageIcon;

public class SuaNhaCC_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel SuaNCC_label;
	private Color mau_chu = new Color(97, 113, 67);
	private JTextField TenNhaCC_textField;
	private JLabel MaNhaCC_label;
	private JLabel TenNhaCC_label;
	private JLabel SoDTNhaCC_label;
	private JLabel EmailNCC_label;
	private JTextField Phone_textField;
	private JTextField Email_textField;
	private JLabel ThanhPho_label;
	private JTextField ThanhPho_textField;
	private JLabel Quan_label;
	private JTextField Quan_textField;
	private JLabel Xa_label;
	private JTextField Xa_textField;
	private button_custom btn_Sua;
	private button_custom btn_Thoat;
	private JTextField textField;
	private JLabel TimKiemIcon_label;
	private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;

	public SuaNhaCC_Frame(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
		this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 660, 370);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		SuaNCC_label = new JLabel("SỬA THÔNG TIN NHÀ CUNG CẤP", JLabel.CENTER);
		SuaNCC_label.setFont(new Font("Tahoma", Font.BOLD, 30));
		SuaNCC_label.setBounds(69, 10, 500, 50);
		SuaNCC_label.setForeground(mau_chu);
		contentPane.add(SuaNCC_label);

		TenNhaCC_textField = new JTextField();
		TenNhaCC_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenNhaCC_textField.setColumns(10);
		TenNhaCC_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		TenNhaCC_textField.setBounds(175, 127, 134, 30);
		contentPane.add(TenNhaCC_textField);

		MaNhaCC_label = new JLabel("MÃ NHÀ CC: ", JLabel.CENTER);
		MaNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		MaNhaCC_label.setBounds(137, 70, 90, 30);
		contentPane.add(MaNhaCC_label);

		TenNhaCC_label = new JLabel("TÊN NHÀ CC :", JLabel.CENTER);
		TenNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		TenNhaCC_label.setBounds(74, 127, 90, 30);
		contentPane.add(TenNhaCC_label);

		SoDTNhaCC_label = new JLabel("SỐ PHONE : ", JLabel.CENTER);
		SoDTNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		SoDTNhaCC_label.setBounds(74, 167, 90, 30);
		contentPane.add(SoDTNhaCC_label);

		EmailNCC_label = new JLabel("EMAIL :", JLabel.CENTER);
		EmailNCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		EmailNCC_label.setBounds(74, 207, 90, 30);
		contentPane.add(EmailNCC_label);

		Phone_textField = new JTextField();
		Phone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Phone_textField.setColumns(10);
		Phone_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		Phone_textField.setBounds(175, 167, 139, 30);
		contentPane.add(Phone_textField);

		Email_textField = new JTextField();
		Email_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Email_textField.setColumns(10);
		Email_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		Email_textField.setBounds(164, 207, 168, 30);
		contentPane.add(Email_textField);

		ThanhPho_label = new JLabel("THÀNH PHỐ/TỈNH :", SwingConstants.CENTER);
		ThanhPho_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		ThanhPho_label.setBounds(358, 127, 129, 30);
		contentPane.add(ThanhPho_label);

		ThanhPho_textField = new JTextField();
		ThanhPho_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ThanhPho_textField.setColumns(10);
		ThanhPho_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		ThanhPho_textField.setBounds(487, 127, 134, 30);
		contentPane.add(ThanhPho_textField);

		Quan_label = new JLabel("QUẬN/HUYỆN :", SwingConstants.CENTER);
		Quan_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Quan_label.setBounds(358, 167, 129, 30);
		contentPane.add(Quan_label);

		Quan_textField = new JTextField();
		Quan_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Quan_textField.setColumns(10);
		Quan_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		Quan_textField.setBounds(487, 167, 134, 30);
		contentPane.add(Quan_textField);

		Xa_label = new JLabel("XÃ/PHƯỜNG :", SwingConstants.CENTER);
		Xa_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Xa_label.setBounds(358, 207, 129, 30);
		contentPane.add(Xa_label);

		Xa_textField = new JTextField();
		Xa_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Xa_textField.setColumns(10);
		Xa_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		Xa_textField.setBounds(487, 207, 134, 30);
		contentPane.add(Xa_textField);

		btn_Sua = new button_custom("THÊM NHÀ CUNG CẤP");
		btn_Sua.setText("SỬA NHÀ CUNG CẤP");
		btn_Sua.setRadius(10);
		btn_Sua.setForeground(Color.WHITE);
		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Sua.setBorderPainted(false);
		btn_Sua.setBounds(89, 277, 220, 35);
		contentPane.add(btn_Sua);

		btn_Thoat = new button_custom("THOÁT");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(368, 277, 220, 35);
		contentPane.add(btn_Thoat);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		textField.setBounds(240, 70, 173, 30);
		contentPane.add(textField);

		TimKiemIcon_label = new JLabel("");
		TimKiemIcon_label.setIcon(new ImageIcon("image_icon\\search.png"));
		TimKiemIcon_label.setBounds(423, 70, 32, 32);
		contentPane.add(TimKiemIcon_label);

		// controller
		controller_btnThoat_SuaNCC controller_btnThoat_SuaNCC = new controller_btnThoat_SuaNCC(
				trangQuanLyNhaCC_view, this);
		btn_Thoat.addMouseListener(controller_btnThoat_SuaNCC);
		controller_btnSua_SuaNCCFrame controller_btnSua_SuaNCCFrame = new controller_btnSua_SuaNCCFrame(this,trangQuanLyNhaCC_view);
		btn_Sua.addMouseListener(controller_btnSua_SuaNCCFrame);
		controller_TimKiem_SuaNCCFrame controller_TimKiem_SuaNCCFrame = new controller_TimKiem_SuaNCCFrame(this);
		TimKiemIcon_label.addMouseListener(controller_TimKiem_SuaNCCFrame);
		setVisible(true);
	}

	public void TimKiem() {
		String maNCC = this.textField.getText();
		ArrayList<SupplierDTO> list = this.trangQuanLyNhaCC_view.getdSachNhaCC().getListNCC();
		int flag = 0;
		for (SupplierDTO supplier : list) {
			if (supplier.getMa().equals(maNCC)) {
				flag = 1;
				this.TenNhaCC_textField.setText(supplier.getName());
				this.Email_textField.setText(supplier.getEmail());
				this.Phone_textField.setText(supplier.getSdt());
				this.Quan_textField.setText(supplier.getAddress().getDistrict());
				this.ThanhPho_textField.setText(supplier.getAddress().getCity());
				this.Xa_textField.setText(supplier.getAddress().getStreet());
			}
		}
		if (flag == 0) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG TÌM THẤY MÃ NHÀ CC", "Thông báo",
			// 		JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("KHÔNG TÌM THẤY MÃ NHÀ CC");
			
		}
	}

	public void Sua() {
		String maNCC = this.textField.getText();
		String name = this.TenNhaCC_textField.getText();
		String email = this.Email_textField.getText();
		String phone = this.Phone_textField.getText();
		String Quan = this.Quan_textField.getText();
		String city = this.ThanhPho_textField.getText();
		String soNha = this.Xa_textField.getText();
		if(Sys.Check_email_2(email) == true && Sys.takePhoneNumberInput_2(phone) == true){
			AddressDTO diachi = new AddressDTO(city, Quan, soNha);
			SupplierDTO sua = new SupplierDTO(name, diachi, phone, email, maNCC);
			if(this.trangQuanLyNhaCC_view.SuaNCC_vaoDATA(sua)){
				this.setVisible(false);
				this.dispose();
			}
			
		}
		else{
			// JOptionPane.showConfirmDialog(null, "SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu sửa)","Thông báo ", JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu sửa)");
			
		}
	}

}
