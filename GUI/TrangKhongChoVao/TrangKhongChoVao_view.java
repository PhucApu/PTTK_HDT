package TrangKhongChoVao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DTO.*;

import javax.swing.ImageIcon;

public class TrangKhongChoVao_view extends JPanel {

	private int width_max = 749;		// contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private JLabel ThongBao_label;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private StaffDTO staff;
	public TrangKhongChoVao_view( StaffDTO staff) {
		this.staff = staff;
		setSize(width_max, height_max);
		setBackground(new Color(246,225,195));
		setLayout(null);
		
		ThongBao_label = new JLabel("BẠN KHÔNG CÓ QUYỀN TRUY CẬP ", SwingConstants.CENTER);
		ThongBao_label.setForeground(new Color(97, 113, 67));
		ThongBao_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		ThongBao_label.setBounds(10, 223, 729, 40);
		add(ThongBao_label);

		UserIcon_label = new JLabel("", JLabel.CENTER);
		UserIcon_label.setIcon(new ImageIcon("image_icon\\user.png"));
		UserIcon_label.setBounds(584, 10, 40, 40);
		add(UserIcon_label);

		TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
		TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		TenDN_label.setBounds(618, 10, 121, 30);
		add(TenDN_label);
		
		JLabel ThongBao_label_1 = new JLabel("TRANG NÀY", SwingConstants.CENTER);
		ThongBao_label_1.setForeground(new Color(97, 113, 67));
		ThongBao_label_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		ThongBao_label_1.setBounds(10, 273, 729, 40);
		add(ThongBao_label_1);
		
		JLabel IconSad_label = new JLabel("",JLabel.CENTER);
		IconSad_label.setIcon(new ImageIcon("image_icon\\sad.png"));
		IconSad_label.setBounds(279, 323, 190, 143);
		add(IconSad_label);

		TenDN(staff);
	}
	public void TenDN(StaffDTO staff) {
		this.TenDN_label.setText(staff.getName());
	}
}
