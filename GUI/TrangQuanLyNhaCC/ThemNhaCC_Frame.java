package TrangQuanLyNhaCC;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import DTO.*;
public class ThemNhaCC_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel ThemNCC_label; 
	private Color mau_chu = new Color (97,113,67);
	private JTextField TenNhaCC_textField;
	private JLabel MaNhaCC_label;
	private JLabel GanMaNCC_label;
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
	private button_custom btn_Them;
	private button_custom btn_Thoat;
	
	private TrangQuanLyNhaCC_view trangQuanLyNhaCC_view;
	public ThemNhaCC_Frame(TrangQuanLyNhaCC_view trangQuanLyNhaCC_view) {
		this.trangQuanLyNhaCC_view = trangQuanLyNhaCC_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 660, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246,225,195));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ThemNCC_label = new JLabel("THÊM MỘT NHÀ CUNG CẤP",JLabel.CENTER);
		ThemNCC_label.setFont(new Font("Tahoma", Font.BOLD, 30));
		ThemNCC_label.setBounds(69, 20, 500, 50);
		ThemNCC_label.setForeground(mau_chu);
		contentPane.add(ThemNCC_label);
		
		TenNhaCC_textField = new JTextField();
		TenNhaCC_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenNhaCC_textField.setColumns(10);
		TenNhaCC_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		TenNhaCC_textField.setBounds(175, 127, 134, 30);
		contentPane.add(TenNhaCC_textField);
		
		MaNhaCC_label = new JLabel("MÃ NHÀ CC: ",JLabel.CENTER);
		MaNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		MaNhaCC_label.setBounds(74, 90, 90, 30);
		contentPane.add(MaNhaCC_label);
		
		GanMaNCC_label = new JLabel("New label",JLabel.CENTER);
		GanMaNCC_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		GanMaNCC_label.setBounds(175, 89, 122, 30);
		contentPane.add(GanMaNCC_label);
		
		TenNhaCC_label = new JLabel("TÊN NHÀ CC :",JLabel.CENTER);
		TenNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		TenNhaCC_label.setBounds(74, 127, 90, 30);
		contentPane.add(TenNhaCC_label);
		
		SoDTNhaCC_label = new JLabel("SỐ PHONE : ",JLabel.CENTER);
		SoDTNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		SoDTNhaCC_label.setBounds(74, 167, 90, 30);
		contentPane.add(SoDTNhaCC_label);
		
		EmailNCC_label = new JLabel("EMAIL :",JLabel.CENTER);
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
		
		btn_Them = new button_custom("THÊM NHÀ CUNG CẤP");
		btn_Them.setRadius(10);
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Them.setBorderPainted(false);
		btn_Them.setBounds(90, 277, 219, 35);
		contentPane.add(btn_Them);
		
		btn_Thoat = new button_custom("THOÁT");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(368, 277, 219, 35);
		contentPane.add(btn_Thoat);
		
		// controller
		controller_btnThoat_ThemNCCFrame btnThoat_ThemNCCFrame = new controller_btnThoat_ThemNCCFrame(trangQuanLyNhaCC_view, this);
		btn_Thoat.addMouseListener(btnThoat_ThemNCCFrame);
		controller_btnThem_ThemNCCFrame btnThem_ThemNCCFrame = new controller_btnThem_ThemNCCFrame(this,trangQuanLyNhaCC_view);
		btn_Them.addMouseListener(btnThem_ThemNCCFrame);
		setVisible(true);
	}
	public JLabel getGanMaNCC_label() {
		return GanMaNCC_label;
	}
	public JTextField getTenNhaCC_textField() {
		return TenNhaCC_textField;
	}
	public JLabel getMaNhaCC_label() {
		return MaNhaCC_label;
	}
	public JTextField getPhone_textField() {
		return Phone_textField;
	}
	public JTextField getThanhPho_textField() {
		return ThanhPho_textField;
	}
	public JTextField getEmail_textField() {
		return Email_textField;
	}
	public JTextField getXa_textField() {
		return Xa_textField;
	}
	public JTextField getQuan_textField() {
		return Quan_textField;
	}
	
	public void LayThongTinNCC_Check(){
		String MaNCC = getGanMaNCC_label().getText();
              String TenNCC = getTenNhaCC_textField().getText();
              String SoDTNCC = getPhone_textField().getText();
              String EmailNCC = getEmail_textField().getText();
              String XaNCC = getXa_textField().getText();
              String ThanhPho = getThanhPho_textField().getText();
              String Quan = getQuan_textField().getText();
		AddressDTO diachi = new AddressDTO(ThanhPho, Quan, XaNCC);
		if(Sys.Check_email_2(EmailNCC) ==  true && Sys.takePhoneNumberInput_2(SoDTNCC) == true ){
			SupplierDTO supplier = new SupplierDTO(TenNCC, diachi, SoDTNCC, EmailNCC, MaNCC);
			if(this.trangQuanLyNhaCC_view.ThemNV_vaoDATA(supplier)){
				this.setVisible(false);
				this.dispose();
			}

			
		}
		else{
			// JOptionPane.showConfirmDialog(null, "THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu nhập vào)","Thông báo ", JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu nhập vào)");
			
		}
		
	}
}
