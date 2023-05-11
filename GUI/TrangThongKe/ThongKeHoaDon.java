package TrangThongKe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.lang.reflect.Array;
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

public class ThongKeHoaDon extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel BangThongKeHD_label;
	private Color mau_chu = new Color(97, 113, 67);
	private JTextField DayBefore_textField;
	private JTextField DayAfter_textField;
	private JLabel TimKiemICon_label;
	private button_custom btn_ThoatPN;
	private button_custom btn_XuatExcel;
	private button_custom btn_DocExcel;
	private TrangThongKe_view trangThongKe_view;

	public ThongKeHoaDon(TrangThongKe_view trangThongKe_view) {
		this.trangThongKe_view = trangThongKe_view;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 809, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 123, 672, 193);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"MÃ NV", "TÊN", "SỐ LẦN GIAO DỊCH", "SỐ HÓA ĐƠN", "TỔNG TIỀN"
				}) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);

		// chinh sua table
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232, 57, 95));

		table.setRowHeight(22);
		scrollPane.setViewportView(table);

		setContentPane(contentPane);

		JLabel ThongKeHoaDon_label = new JLabel("THỐNG KÊ HÓA ĐƠN", JLabel.CENTER);
		ThongKeHoaDon_label.setForeground(new Color(97, 113, 67));
		ThongKeHoaDon_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		ThongKeHoaDon_label.setBounds(10, 23, 785, 40);
		contentPane.add(ThongKeHoaDon_label);

		BangThongKeHD_label = new JLabel("Bảng thống kê nhân viên bán hàng", JLabel.CENTER);
		BangThongKeHD_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		BangThongKeHD_label.setBounds(62, 83, 666, 30);
		contentPane.add(BangThongKeHD_label);

		JLabel ThoiGianTK_label = new JLabel("Chọn khoảng thời gian thông kê :");
		ThoiGianTK_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		ThoiGianTK_label.setBounds(107, 338, 248, 30);
		contentPane.add(ThoiGianTK_label);

		DayBefore_textField = new JTextField();
		DayBefore_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DayBefore_textField.setColumns(10);
		DayBefore_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		DayBefore_textField.setBounds(354, 339, 123, 30);
		contentPane.add(DayBefore_textField);

		JLabel Den_label = new JLabel("──");
		Den_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Den_label.setBounds(487, 338, 38, 30);
		contentPane.add(Den_label);

		DayAfter_textField = new JTextField();
		DayAfter_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DayAfter_textField.setColumns(10);
		DayAfter_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		DayAfter_textField.setBounds(513, 339, 123, 30);
		contentPane.add(DayAfter_textField);

		TimKiemICon_label = new JLabel("");
		TimKiemICon_label.setIcon(new ImageIcon("image_icon\\search.png"));
		TimKiemICon_label.setBounds(661, 338, 38, 30);
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
		controller_btnThongKeTGHoaDon controller_btnThongKeTGHoaDon = new controller_btnThongKeTGHoaDon(this);
		TimKiemICon_label.addMouseListener(controller_btnThongKeTGHoaDon);
		controller_ThoatTKHoaDon controller_ThoatTKHoaDon = new controller_ThoatTKHoaDon(this);
		btn_ThoatPN.addMouseListener(controller_ThoatTKHoaDon);
		controller_btnXuatExcel_TKHoaDon controller_btnXuatExcel_TKHoaDon = new controller_btnXuatExcel_TKHoaDon(this);
		btn_XuatExcel.addMouseListener(controller_btnXuatExcel_TKHoaDon);
		controller_btnDocExcel_TKHoaDon controller_btnDocExcel_TKHoaDon = new controller_btnDocExcel_TKHoaDon(this);
		btn_DocExcel.addMouseListener(controller_btnDocExcel_TKHoaDon);
		setVisible(true);
	}

	public void showThongKe() {
		this.DayBefore_textField.setText("1/1/2000");
		this.DayAfter_textField.setText(Sys.getDateNow());

		ArrayList<Double> tongtienhoadon = trangThongKe_view.getThongKe().ThongKe_HoaDonTongTienTheoNV("1/1/2000",
				Sys.getDateNow());
		ArrayList<Double> solan_giaodich = trangThongKe_view.getThongKe().ThongKe_NhanVienHDMax("1/1/2000",
				Sys.getDateNow());
		ArrayList<String> hoadon_theoNV = trangThongKe_view.getThongKe().thongKeCacHDTheoNV("1/1/2000",
				Sys.getDateNow());
		int index = 0;

		StaffsBUS staffs = trangThongKe_view.getThongKe().getStaffs();

		for (StaffDTO staff : staffs.getStaffs()) {
			addDataTable(staff.getId(), staff.getName(), solan_giaodich.get(index), hoadon_theoNV.get(index),
					tongtienhoadon.get(index));
			index++;
		}
	}

	public void btn_ThongKeTG() {
		String dayBefore = this.DayBefore_textField.getText();
		String dayAfter = this.DayAfter_textField.getText();
		model = (DefaultTableModel) table.getModel();
		if (Sys.compareDay(dayBefore, dayAfter) == true) {
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			ArrayList<Double> tongtienhoadon = trangThongKe_view.getThongKe().ThongKe_HoaDonTongTienTheoNV(
					dayBefore,
					dayAfter);
			ArrayList<Double> solan_giaodich = trangThongKe_view.getThongKe().ThongKe_NhanVienHDMax(dayBefore,
					dayAfter);
			ArrayList<String> hoadon_theoNV = trangThongKe_view.getThongKe().thongKeCacHDTheoNV(dayBefore,
					dayAfter);
			int index = 0;

			StaffsBUS staffs = trangThongKe_view.getThongKe().getStaffs();
			if (tongtienhoadon != null && solan_giaodich != null && hoadon_theoNV != null) {
				for (StaffDTO staff : staffs.getStaffs()) {
					addDataTable(staff.getId(), staff.getName(), solan_giaodich.get(index),
							hoadon_theoNV.get(index),
							tongtienhoadon.get(index));
					index++;
				}
			}

		} else {
			// JOptionPane.showConfirmDialog(null, "NHẬP NGÀY SAI", "Thông báo",
			// JOptionPane.ERROR_MESSAGE);
			Sys.Warning_dialog("NHẬP NGÀY SAI");
			Sys.Sound_Error();
		}
	}

	public void btn_xuatFile_Excel() throws IOException{
		String dayBefore = this.DayBefore_textField.getText();
		String dayAfter = this.DayAfter_textField.getText();
		String pathname = "D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_HoaDon\\"+"TK_HD_("+Sys.takeDayFormat_(dayBefore)+"-"+Sys.takeDayFormat_(dayAfter)+").xlsx";

		if(Sys.createExcelFile(pathname)){

			// ngay thong ke
			ArrayList <String> ngaythongke = new ArrayList<>();
			ngaythongke.add(dayBefore);
			ngaythongke.add(dayAfter);

			// ma nv
			ArrayList<String> maNV = new ArrayList<>();
			ArrayList<String> nameNV = new ArrayList<>();
			for (StaffDTO iterable_element : trangThongKe_view.getThongKe().getStaffs().getStaffs()) {
				maNV.add(iterable_element.getId());
				nameNV.add(iterable_element.getName());
			}

			// so lan giao dich
			ArrayList<Double> solangiaodich = trangThongKe_view.getThongKe().ThongKe_NhanVienHDMax(dayBefore,dayAfter);
			// so hoa don
			ArrayList<String> soHD = trangThongKe_view.getThongKe().thongKeCacHDTheoNV(dayBefore,
			dayAfter);
			// tong tien
			ArrayList<Double> tongtienhoadon = trangThongKe_view.getThongKe().ThongKe_HoaDonTongTienTheoNV(
					dayBefore,dayAfter);

			if(Sys.writeExcel_TKHoaDon(pathname, ngaythongke, maNV, nameNV, solangiaodich, soHD, tongtienhoadon)){
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

	public void btn_readExcelFile_and_check() throws IOException{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
			
			String pathname = "D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_HoaDon\\" + chooser.getSelectedFile().getName();
			ArrayList <String> ngayTK = Sys.readExcel_ngayTKPhieuNhap(pathname);
			String dayBefore = ngayTK.get(0);
			String dayAfter = ngayTK.get(1);

			// doc tat ca thong tin co trong file
			ArrayList<String> maNV = Sys.readExcel_maNVTKHoaDon(pathname);
			ArrayList<String> nameNV = Sys.readExcel_nameNVTKHoaDon(pathname);
			ArrayList<Double> solangiaodich = Sys.readExcel_SoLanGiaDich(pathname);
			ArrayList<String> soHD = Sys.readExcel_nameHoaDonTKHoaDon(pathname);
			ArrayList<Double> tongtien = Sys.readExcel_TongTienTKHoaDon(pathname);

			// du lieu co trong database
			ArrayList<String> maNV_data = new ArrayList<>();
			ArrayList<String> nameNV_data = new ArrayList<>();
			for (StaffDTO iterable_element : trangThongKe_view.getThongKe().getStaffs().getStaffs()) {
				maNV_data.add(iterable_element.getId());
				nameNV_data.add(iterable_element.getName());
			}
			ArrayList<Double> solangiaodich_data = trangThongKe_view.getThongKe().ThongKe_NhanVienHDMax(dayBefore,dayAfter);
			ArrayList<String> soHD_data = trangThongKe_view.getThongKe().thongKeCacHDTheoNV(dayBefore,
			dayAfter);
			ArrayList<Double> tongtien_data = trangThongKe_view.getThongKe().ThongKe_HoaDonTongTienTheoNV(
				dayBefore,dayAfter);

			// so sanh

			int flag = 0;		// kiem tra

			if(maNV.equals(maNV_data) == true && nameNV.equals(nameNV_data) == true && solangiaodich.equals(solangiaodich_data) == true && soHD.equals(soHD_data) == true && tongtien.equals(tongtien_data)){
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

	public void addDataTable(String maNV, String nameNV, double solan_giaodich, String soHD, double tongtien) {
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				maNV, nameNV, solan_giaodich, soHD, tongtien
		});
	}

}
