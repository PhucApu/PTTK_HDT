package TrangThongKe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DTO.*;
import BUS.*;

public class TrangThongKe_view extends JPanel {

	private int width_max = 749;		// contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel ThongKe_label;
	private Color mau_chu = new Color (97,113,67);
	private button_custom btn_PhieuNhap;
	private button_custom btn_PhieuXuat;
	private button_custom btn_HoaDon;
	private int check_open_Jrame = 0;
	private ThongKeDTO thongKe;
	private StaffDTO staff;
	public TrangThongKe_view(StaffDTO staff, ThongKeDTO thongKe) {
		this.thongKe = thongKe;
		this.staff = staff;
		setSize(width_max, height_max);
		setBackground(new Color(246,225,195));
		setLayout(null);
		
		UserIcon_label = new JLabel("", JLabel.CENTER);
		UserIcon_label.setIcon(new ImageIcon("image_icon\\user.png"));
		UserIcon_label.setBounds(584, 10, 40, 40);
		add(UserIcon_label);
		
		TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
		TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		TenDN_label.setBounds(618, 10, 121, 30);
		add(TenDN_label);
		
		ThongKe_label = new JLabel("THỐNG KÊ", SwingConstants.CENTER);
		ThongKe_label.setForeground(new Color(97, 113, 67));
		ThongKe_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		ThongKe_label.setBounds(60, 48, 630, 40);
		add(ThongKe_label);
		
		btn_PhieuNhap = new button_custom("Thống kê phiếu nhập");
		btn_PhieuNhap.setRadius(10);
		btn_PhieuNhap.setForeground(Color.WHITE);
		btn_PhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_PhieuNhap.setBorderPainted(false);
		btn_PhieuNhap.setBounds(272, 180, 220, 54);
		add(btn_PhieuNhap);
		
		btn_PhieuXuat = new button_custom("Thống kê phiếu xuất");
		btn_PhieuXuat.setRadius(10);
		btn_PhieuXuat.setForeground(Color.WHITE);
		btn_PhieuXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_PhieuXuat.setBorderPainted(false);
		btn_PhieuXuat.setBounds(272, 285, 220, 54);
		add(btn_PhieuXuat);
		
		btn_HoaDon = new button_custom("Thống kê hóa đơn");
		btn_HoaDon.setRadius(10);
		btn_HoaDon.setForeground(Color.WHITE);
		btn_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_HoaDon.setBorderPainted(false);
		btn_HoaDon.setBounds(272, 387, 220, 54);
		add(btn_HoaDon);

		TenDN(staff);
		// controller
		controller_btnTKPhieuNhap controller_btnTKPhieuNhap = new controller_btnTKPhieuNhap(this);
		btn_PhieuNhap.addMouseListener(controller_btnTKPhieuNhap);
		controller_btnTKPhieuXuat controller_btnTKPhieuXuat = new controller_btnTKPhieuXuat(this);
		btn_PhieuXuat.addMouseListener(controller_btnTKPhieuXuat);
		controller_TKHoaDon controller_TKHoaDon = new controller_TKHoaDon(this);
		btn_HoaDon.addMouseListener(controller_TKHoaDon);
	}
	public void setCheck_open_Jrame(int check_open_Jrame) {
		this.check_open_Jrame = check_open_Jrame;
	}
	public int getCheck_open_Jrame() {
		return check_open_Jrame;
	}
	public void TenDN(StaffDTO staff) {
		this.TenDN_label.setText(staff.getName());
	}
	public ThongKeDTO getThongKe() {
		return thongKe;
	}
	public void btn_ThongKePhieuNhap(){
		ThongKePhieuNhap thongKePhieuNhap = new ThongKePhieuNhap(this);
	}
	public void btn_ThongKePhieuXuat(){
		ThongKePhieuXuat thongKePhieuXuat = new ThongKePhieuXuat(this);
	}
	public void btn_ThongKeHoaDon(){
		ThongKeHoaDon thongKeHoaDon = new ThongKeHoaDon(this);
	}
	
	
}
