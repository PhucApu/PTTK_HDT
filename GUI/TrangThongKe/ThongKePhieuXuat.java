package TrangThongKe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

public class ThongKePhieuXuat extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel BangThongKeSP_label;
	private Color mau_chu = new Color (97,113,67);
	private JTextField DayBefore_textField;
	private JTextField DayAfter_textField;
	private JLabel GanPNTongTienLonNhat_label;
	private JLabel GanNVNhapMax_label;
	private JLabel TimKiemICon_label;
	private button_custom btn_ThoatPN;
	private button_custom btn_XuatExcel;
	private button_custom btn_DocExcel;
	private TrangThongKe_view trangThongKe_view;

	
	public ThongKePhieuXuat(TrangThongKe_view trangThongKe_view) {
		this.trangThongKe_view = trangThongKe_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 809, 525);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246,225,195));
		contentPane.setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 123, 356, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TÊN", "MÃ SP", "TỶ LỆ (%)"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		// chinh sua table
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232,57,95));
		
		table.setRowHeight(22);
		scrollPane.setViewportView(table);

		setContentPane(contentPane);
		
		JLabel ThongKePhieuXuat_label = new JLabel("THỐNG KÊ PHIẾU XUẤT", JLabel.CENTER);
		ThongKePhieuXuat_label.setForeground(new Color(97, 113, 67));
		ThongKePhieuXuat_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		ThongKePhieuXuat_label.setBounds(10, 23, 785, 40);
		contentPane.add(ThongKePhieuXuat_label);
		
		BangThongKeSP_label = new JLabel("Bảng thống kê phần trăm các sản phẩm được xuất",JLabel.CENTER);
		BangThongKeSP_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		BangThongKeSP_label.setBounds(23, 83, 370, 30);
		contentPane.add(BangThongKeSP_label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246,225,195));
		panel.setBounds(399, 123, 370, 193);
		panel.setBorder(BorderFactory.createLineBorder(mau_chu, 3));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel PXTongTienLonNhat_label = new JLabel("Phiếu xuất có tổng tiền lớn nhất :");
		PXTongTienLonNhat_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		PXTongTienLonNhat_label.setBounds(10, 28, 239, 30);
		panel.add(PXTongTienLonNhat_label);
		
		GanPNTongTienLonNhat_label = new JLabel("....");
		GanPNTongTienLonNhat_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanPNTongTienLonNhat_label.setBounds(230, 28, 130, 30);
		panel.add(GanPNTongTienLonNhat_label);
		
		JLabel NVXuatMax_label = new JLabel("Nhân viên xuất nhiều nhất :");
		NVXuatMax_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		NVXuatMax_label.setBounds(10, 91, 199, 30);
		panel.add(NVXuatMax_label);
		
		GanNVNhapMax_label = new JLabel("....");
		GanNVNhapMax_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanNVNhapMax_label.setBounds(195, 91, 165, 30);
		panel.add(GanNVNhapMax_label);
		
		JLabel BangThongKePX_label = new JLabel("Bảng thống kê phiếu xuất", JLabel.CENTER);
		BangThongKePX_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		BangThongKePX_label.setBounds(419, 83, 350, 30);
		contentPane.add(BangThongKePX_label);
		
		JLabel ThoiGianTK_label = new JLabel("Chọn khoảng thời gian thông kê :");
		ThoiGianTK_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		ThoiGianTK_label.setBounds(62, 339, 248, 30);
		contentPane.add(ThoiGianTK_label);
		
		DayBefore_textField = new JTextField();
		DayBefore_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DayBefore_textField.setColumns(10);
		DayBefore_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		DayBefore_textField.setBounds(309, 340, 123, 30);
		contentPane.add(DayBefore_textField);
		
		JLabel Den_label = new JLabel("──");
		Den_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Den_label.setBounds(442, 339, 38, 30);
		contentPane.add(Den_label);
		
		DayAfter_textField = new JTextField();
		DayAfter_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DayAfter_textField.setColumns(10);
		DayAfter_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		DayAfter_textField.setBounds(468, 340, 123, 30);
		contentPane.add(DayAfter_textField);
		
		TimKiemICon_label = new JLabel("");
		TimKiemICon_label.setIcon(new ImageIcon("image_icon\\search.png"));
		TimKiemICon_label.setBounds(616, 339, 38, 30);
		contentPane.add(TimKiemICon_label);
		
		btn_ThoatPN = new button_custom("THOÁT");
		btn_ThoatPN.setRadius(10);
		btn_ThoatPN.setForeground(Color.WHITE);
		btn_ThoatPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ThoatPN.setBorderPainted(false);
		btn_ThoatPN.setBounds(648, 423, 121, 35);
		contentPane.add(btn_ThoatPN);

		btn_XuatExcel = new button_custom("Xuất");
		btn_XuatExcel.setIcon(new ImageIcon("image_icon\\excel (1).png"));
		btn_XuatExcel.setRadius(10);
		btn_XuatExcel.setForeground(Color.WHITE);
		btn_XuatExcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_XuatExcel.setBorderPainted(false);
		btn_XuatExcel.setBounds(468, 423, 121, 35);
		contentPane.add(btn_XuatExcel);
		
		btn_DocExcel = new button_custom("Đọc");
		btn_DocExcel.setIcon(new ImageIcon("image_icon\\excel (1).png"));
		btn_DocExcel.setRadius(10);
		btn_DocExcel.setForeground(Color.WHITE);
		btn_DocExcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_DocExcel.setBorderPainted(false);
		btn_DocExcel.setBounds(309, 423, 121, 35);
		contentPane.add(btn_DocExcel);

		showThongKe();

		// controller
		controller_btnThongKeTGPhieuXuat controller_btnThongKeTGPhieuXuat = new controller_btnThongKeTGPhieuXuat(this);
		TimKiemICon_label.addMouseListener(controller_btnThongKeTGPhieuXuat);
		controller_ThoatTKPhieuXuat controller_ThoatTKPhieuXuat = new controller_ThoatTKPhieuXuat(this);
		btn_ThoatPN.addMouseListener(controller_ThoatTKPhieuXuat);
		controller_btnXuatExcel_TKPhieuXuat controller_btnXuatExcel_TKPhieuXuat = new controller_btnXuatExcel_TKPhieuXuat(this);
		btn_XuatExcel.addMouseListener(controller_btnXuatExcel_TKPhieuXuat);
		controller_btnDocExcel_TKPhieuXuat controller_btnDocExcel_TKPhieuXuat = new controller_btnDocExcel_TKPhieuXuat(this);
		btn_DocExcel.addMouseListener(controller_btnDocExcel_TKPhieuXuat);

		setVisible(true);
	}

	public void showThongKe() {
		this.DayBefore_textField.setText("1/1/2000");
		this.DayAfter_textField.setText(Sys.getDateNow());
		ListProductsBUS listProducts = trangThongKe_view.getThongKe().getListProducts();
		ArrayList <Double> phantram = trangThongKe_view.getThongKe().ThongKe_xuatProduct("1/1/2000", Sys.getDateNow());
		int index = 0;
		if( phantram != null){
			for (ProductsDTO products : listProducts.getArr()) {
				addDataTable(products.getNameProduct(), products.getMaSP(), phantram.get(index));
				index++;
			}
			this.GanPNTongTienLonNhat_label.setText(
					trangThongKe_view.getThongKe().ThongKe_PhieuXuatTongTienMax("1/1/2023", Sys.getDateNow()).toString());
			this.GanNVNhapMax_label.setText(
					trangThongKe_view.getThongKe().ThongKe_NhanVienXuatMax("1/1/2023", Sys.getDateNow()).toString());
		}
		
	}

	public void btn_ThongKeTG() {
		String dayBefore = this.DayBefore_textField.getText();
		String dayAfter = this.DayAfter_textField.getText();
		model = (DefaultTableModel) table.getModel();
		if (Sys.compareDay(dayBefore, dayAfter)) {
			ListProductsBUS listProducts = trangThongKe_view.getThongKe().getListProducts();
			ArrayList <Double> phantram = trangThongKe_view.getThongKe().ThongKe_nhapProduct(dayBefore, dayAfter);
			int index = 0;
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			if( phantram != null){
				for (ProductsDTO products : listProducts.getArr()) {
					addDataTable(products.getNameProduct(), products.getMaSP(), phantram.get(index));
					index++;
				}
			}
			
			this.GanPNTongTienLonNhat_label.setText(trangThongKe_view.getThongKe()
					.ThongKe_PhieuXuatTongTienMax(dayBefore, dayAfter).toString());
			
			this.GanNVNhapMax_label.setText(trangThongKe_view.getThongKe().ThongKe_NhanVienXuatMax(dayBefore, dayAfter).toString());

		} else {
			Sys.Warning_dialog("NHẬP NGÀY SAI");
			Sys.Sound_Error();
		}
	}
	public void btn_xuatFile_Excel() throws IOException{
		String dayBefore = this.DayBefore_textField.getText();
		String dayAfter = this.DayAfter_textField.getText();
		String pathname = "D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuXuat\\"+"TK_PX_("+Sys.takeDayFormat_(dayBefore)+"-"+Sys.takeDayFormat_(dayAfter)+").xlsx";
		if(Sys.createExcelFile(pathname)){
			// ngay thong ke
			ArrayList <String> ngaythongke = new ArrayList<>();
			ngaythongke.add(dayBefore);
			ngaythongke.add(dayAfter);
			// maSP nameSP
			ArrayList <String> maSP = new ArrayList<>();
			ArrayList <String> nameSP = new ArrayList<>();
			for (ProductsDTO iterable_element : trangThongKe_view.getThongKe().getListProducts().getArr()) {
				maSP.add(iterable_element.getMaSP());
				nameSP.add(iterable_element.getNameProduct());
			}
			// phan tram
			ArrayList<Double> phantram = trangThongKe_view.getThongKe().ThongKe_xuatProduct(dayBefore, dayAfter);
			// ma phieu
			ArrayList<String> maPhieu = trangThongKe_view.getThongKe()
			.ThongKe_PhieuXuatTongTienMax(dayBefore, dayAfter);
			// ma nhan vien
			ArrayList<String> maNV = trangThongKe_view.getThongKe().ThongKe_NhanVienXuatMax(dayBefore, dayAfter);
			

			if(Sys.writeExcel_TKPhieuXuat(pathname, ngaythongke, maSP, nameSP, phantram, maPhieu, maNV)){
				Sys.Success_dialog("Xuất file Excel thành công ");
			}
			else{
				Sys.Error_dialog("Lỗi xuất file");
			}
		}
		else{
			Sys.Error_dialog("Lỗi tạo file");
		}
	}
	public void btn_readExcelFile_and_check() throws IOException {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
			
			String pathname = "D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuXuat\\" + chooser.getSelectedFile().getName();
			ArrayList <String> ngayTK = Sys.readExcel_ngayTKPhieuNhap(pathname);
			String dayBefore = ngayTK.get(0);
			String dayAfter = ngayTK.get(1);

			// doc tat ca thong tin co trong file
			ArrayList<String> maSP = Sys.readExcel_maSPTKPhieuNhap(pathname);
			ArrayList<String> nameSP = Sys.readExcel_tenSPTKPhieuNhap(pathname);
			ArrayList<Double> phantram = Sys.readExcel_PhanTramSPPhieuNhap(pathname);
			ArrayList<String> phieuxuattongtienmax = Sys.readExcel_PhieuNhapCoTongTienLonNhat(pathname);
			ArrayList<String> maNV = Sys.readExcel_NhanVienNhapNhieuPhieuNhat(pathname);

			// du lieu co trong database
			ArrayList<String> maSP_data = new ArrayList<>();
			ArrayList<String> nameSP_data = new ArrayList<>();
			for (ProductsDTO iterable_element : trangThongKe_view.getThongKe().getListProducts().getArr()) {
				maSP_data.add(iterable_element.getMaSP());
				nameSP_data.add(iterable_element.getNameProduct());
			}
			// phan tram
			ArrayList<Double> phantram_data = trangThongKe_view.getThongKe().ThongKe_xuatProduct(dayBefore,
					dayAfter);
			// ma phieu
			ArrayList<String> maPhieu = trangThongKe_view.getThongKe()
					.ThongKe_PhieuXuatTongTienMax(dayBefore, dayAfter);
			// ma nhan vien
			ArrayList<String> maNV_data = trangThongKe_view.getThongKe().ThongKe_NhanVienXuatMax(dayBefore,
					dayAfter);
			

			// so sanh

			int flag = 0;		// kiem tra

			if(maSP.equals(maSP_data) == true && nameSP.equals(nameSP_data) ==  true && phantram.equals(phantram_data) ==  true && phieuxuattongtienmax.equals(maPhieu) == true && maNV.equals(maNV_data) == true){
				flag = 1;
			}

			if( flag == 1){
				Sys.Success_dialog("Đọc file Excel thành công ");
				this.DayBefore_textField.setText(dayBefore);
				this.DayAfter_textField.setText(dayAfter);
				btn_ThongKeTG();
			}
			else{
				Sys.Error_dialog("Đọc file thất bại file");
			}
		}
	}

	public void btn_Thoat() {
		
		this.trangThongKe_view.setCheck_open_Jrame(0);
		this.setVisible(false);
		this.dispose();
	}

	public void addDataTable(String nameSP, String maSP, double phantram) {
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				nameSP, maSP, phantram
		});
	}
	

}
