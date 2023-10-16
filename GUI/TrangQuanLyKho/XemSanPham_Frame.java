package TrangQuanLyKho;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DTO.*;
import BUS.*;

public class XemSanPham_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel QLKho_label;
	private Color mau_chu = new Color(97, 113, 67);
	private JLabel NgayNhapSP_label;
	private JLabel Anh_label;
	private JLabel Ten_label;
	private JLabel IDnhaCC_label;

	private JPanel ThongTinSP_panel;
	private JTextField Luong_textField;

	private JPanel ThuocTinhSP_panel;
	private JTextField SoGio_textField;
	private JLabel SoLuongSP_label;
	private JLabel LoaiSP_label;
	private button_custom btn_Thoat;
	private JLabel IDSanPham_label;
	private JLabel GanIDSanPham_label;
	private JLabel GanTen_label;
	private JLabel GanNgayNhap_label;
	private JLabel GanNgayHetHan_label;
	private JLabel GanNhaCC_label;
	private JLabel GanGia_label;
	private JLabel GanSoLuong_label;
	private JLabel GanLoai_label;
	private JLabel ChaySP_label;
	private JLabel DongLanhSP_label;
	private JLabel GanDongLanh_label;
	private JLabel CoConSP_label;
	private JLabel GanCocon_label;
	
	private JLabel GanChaySP_label;

	

	/**
	 * Create the frame.
	 */
	private TrangQuanLyKho_view trangQuanLyKho_view;
	public XemSanPham_Frame(TrangQuanLyKho_view trangQuanLyKho_view) {
		this.trangQuanLyKho_view = trangQuanLyKho_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 810, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		QLKho_label = new JLabel("XEM SẢN PHẨM", SwingConstants.CENTER);
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
		
		NgayNhapSP_label = new JLabel("NGÀY NHẬP:");
		NgayNhapSP_label.setBounds(32, 92, 88, 30);
		ThongTinSP_panel.add(NgayNhapSP_label);
		NgayNhapSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		IDnhaCC_label = new JLabel("NHÀ CUNG CẤP: ");
		IDnhaCC_label.setBounds(391, 56, 119, 30);
		ThongTinSP_panel.add(IDnhaCC_label);
		IDnhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel GiaSP_label = new JLabel("GIÁ/CÁI:");
		GiaSP_label.setBounds(32, 124, 118, 30);
		ThongTinSP_panel.add(GiaSP_label);
		GiaSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel DonViTien_label = new JLabel("$");
		DonViTien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		DonViTien_label.setBounds(201, 124, 55, 30);
		ThongTinSP_panel.add(DonViTien_label);
		
		JLabel NgayHetHan_label = new JLabel("NGÀY HẾT HẠN:");
		NgayHetHan_label.setBounds(392, 92, 118, 30);
		ThongTinSP_panel.add(NgayHetHan_label);
		NgayHetHan_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		SoLuongSP_label = new JLabel("SỐ LƯỢNG:");
		SoLuongSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		SoLuongSP_label.setBounds(393, 124, 118, 30);
		ThongTinSP_panel.add(SoLuongSP_label);
		
		IDSanPham_label = new JLabel("ID SẢN PHẨM:");
		IDSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		IDSanPham_label.setBounds(32, 16, 118, 30);
		ThongTinSP_panel.add(IDSanPham_label);
		
		GanIDSanPham_label = new JLabel("....");
		GanIDSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanIDSanPham_label.setBounds(138, 16, 118, 30);
		ThongTinSP_panel.add(GanIDSanPham_label);
		
		GanTen_label = new JLabel("....");
		GanTen_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanTen_label.setBounds(79, 56, 124, 30);
		ThongTinSP_panel.add(GanTen_label);
		
		GanNgayNhap_label = new JLabel("....");
		GanNgayNhap_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanNgayNhap_label.setBounds(116, 92, 140, 30);
		ThongTinSP_panel.add(GanNgayNhap_label);
		
		GanNgayHetHan_label = new JLabel("....");
		GanNgayHetHan_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanNgayHetHan_label.setBounds(494, 92, 140, 30);
		ThongTinSP_panel.add(GanNgayHetHan_label);
		
		GanNhaCC_label = new JLabel("....");
		GanNhaCC_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanNhaCC_label.setBounds(494, 56, 140, 30);
		ThongTinSP_panel.add(GanNhaCC_label);
		
		GanGia_label = new JLabel("....");
		GanGia_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanGia_label.setBounds(91, 124, 88, 30);
		ThongTinSP_panel.add(GanGia_label);
		
		GanSoLuong_label = new JLabel("....");
		GanSoLuong_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanSoLuong_label.setBounds(467, 124, 140, 30);
		ThongTinSP_panel.add(GanSoLuong_label);
//		setLoaiSP();
		
		ThuocTinhSP_panel = new JPanel();
		ThuocTinhSP_panel.setBounds(132, 490, 530, 80);
		ThuocTinhSP_panel.setBackground(new Color(246, 225, 195));
		ThuocTinhSP_panel.setBorder(BorderFactory.createTitledBorder("Thuộc tính sản phẩm"));
		contentPane.add(ThuocTinhSP_panel);
		ThuocTinhSP_panel.setLayout(null);
		
		ChaySP_label = new JLabel("ĐỒ ĂN CHAY:");
		ChaySP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ChaySP_label.setSize(118, 30);
		
		GanChaySP_label = new JLabel("....");
		GanChaySP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanChaySP_label.setSize(118, 30);
		
		DongLanhSP_label = new JLabel("ĐÔNG LẠNH:");
		DongLanhSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		DongLanhSP_label.setSize(118, 30);
		
		GanDongLanh_label = new JLabel("....");
		GanDongLanh_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanDongLanh_label.setSize(118, 30);
		
		CoConSP_label = new JLabel("CÓ CỒN:");
		CoConSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		CoConSP_label.setSize(118, 30);
		
		GanCocon_label = new JLabel("....");
		GanCocon_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanCocon_label.setSize(118, 30);
		
		
		
		LoaiSP_label = new JLabel("LOẠI SẢN PHẨM:");
		LoaiSP_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		LoaiSP_label.setBounds(240, 444, 118, 30);
		contentPane.add(LoaiSP_label);
		
		btn_Thoat = new button_custom("THOÁT");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(353, 618, 121, 35);
		contentPane.add(btn_Thoat);
		
		GanLoai_label = new JLabel("....");
		GanLoai_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanLoai_label.setBounds(353, 444, 140, 30);
		contentPane.add(GanLoai_label);
		
		showThongTin();
		
		// controller
		controller_btnThoat_XemSPFrame controller_btnThoat_XemSPFrame = new controller_btnThoat_XemSPFrame(trangQuanLyKho_view, this);
		btn_Thoat.addMouseListener(controller_btnThoat_XemSPFrame);
		
		setVisible(true);
	}
	
	public void setThuocTinh(String loai) {
		// truyen vao string loai sp 
		if(loai.equals("Food")) {
			this.ThuocTinhSP_panel.add(ChaySP_label);
			this.ThuocTinhSP_panel.add(GanChaySP_label);
			this.ChaySP_label.setLocation(74, 27);
			this.GanChaySP_label.setLocation(165,27);
			
			
			this.ThuocTinhSP_panel.add(DongLanhSP_label);
			this.GanDongLanh_label.setLocation(379, 27);
			this.DongLanhSP_label.setLocation(288, 27);
			this.ThuocTinhSP_panel.add(GanDongLanh_label);
		}
		else if(loai.equals("Drink")) {
			this.ThuocTinhSP_panel.add(CoConSP_label);
			this.ThuocTinhSP_panel.add(GanCocon_label);
			this.CoConSP_label.setLocation(164, 27);
			this.GanCocon_label.setLocation(260, 27);
		}
			
	}
	public void setAnh(String maSP) {
		// dua vao ma de set anh
		String link_anh = "image_icon\\AnhSP\\" + maSP + ".jpg";
		this.Anh_label.setIcon(new ImageIcon(link_anh));
	}
	public void showThongTin(){
		ProductsDTO product = this.trangQuanLyKho_view.Click_table();
		if( product != null){
			// thong tin products
			String maSP = product.getMaSP();
			this.GanIDSanPham_label.setText(maSP);
			setAnh(maSP);
			this.GanTen_label.setText(product.getNameProduct());
			this.GanGia_label.setText(String.valueOf(product.getPrice()) );
			this.GanNhaCC_label.setText(product.getMaNCC());
			this.GanNgayHetHan_label.setText(product.getExpiry_date());
			this.GanNgayNhap_label.setText(Sys.getDateNow());
			this.GanSoLuong_label.setText(String.valueOf( product.getSoluong()));
			// gan loai sp
			if( product instanceof FoodDTO){
				this.GanLoai_label.setText("Food");
				setThuocTinh("Food");
				FoodDTO food = (FoodDTO) product;
				boolean chay = food.isVegetarian();
				boolean donglanh = food.isFrozenfood();
				if( chay == true){
					this.GanChaySP_label.setText("YES");
				}
				if(chay == false){
					this.GanChaySP_label.setText("NO");
				}
				if( donglanh == true)
				{
					this.GanDongLanh_label.setText("YES");
				}
				if( donglanh == false){
					this.GanDongLanh_label.setText("NO");
				}
			}
			if( product instanceof DrinkDTO){
				this.GanLoai_label.setText("Drink");
				setThuocTinh("Drink");
				DrinkDTO drink = (DrinkDTO) product;
				boolean con = drink.isAlcoholic();
				if( con == true){
					this.GanCocon_label.setText("YES");
				}
				if(con == false){
					this.GanCocon_label.setText("NO");
				}
			}	
		}
	}
	public static void main(String[] args) {
		// new XemSanPham_Frame();
	}

}
