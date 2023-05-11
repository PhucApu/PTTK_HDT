package TrangQuanLyNhaCC;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

public class TrangQuanLyNhaCC_view extends JPanel implements Serializable {

	private DefaultTableModel model;
	private int width_max = 749; // contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel QLNCC_label;
	private Color mau_chu = new Color(97, 113, 67);
	private JTextField TimKiem_textField;
	private JLabel TimKiem_icon;
	private JScrollPane scrollPane;
	private JTable table;
	private button_custom btn_Them;
	private button_custom btn_Xoa;
	private button_custom btn_Sua;
	private JLabel refresh_label;
	private int check_open_Jrame = 0;
	private DanhSachNhaCCBUS dSachNhaCC;

	public TrangQuanLyNhaCC_view(StaffDTO staff, DanhSachNhaCCBUS dsDanhSachNhaCC) {
		this.dSachNhaCC = dsDanhSachNhaCC;
		setSize(width_max, height_max);
		setBackground(new Color(246, 225, 195));
		setLayout(null);

		UserIcon_label = new JLabel("", JLabel.CENTER);
		UserIcon_label.setIcon(new ImageIcon("image_icon\\user.png"));
		UserIcon_label.setBounds(584, 10, 40, 40);
		add(UserIcon_label);

		TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
		TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		TenDN_label.setBounds(618, 10, 121, 30);
		add(TenDN_label);

		QLNCC_label = new JLabel("QUẢN LÝ NHÀ CUNG CẤP", JLabel.CENTER);
		QLNCC_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLNCC_label.setForeground(mau_chu);
		QLNCC_label.setBounds(60, 48, 630, 40);
		add(QLNCC_label);

		TimKiem_textField = new JTextField();
		TimKiem_textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		TimKiem_textField.setBounds(135, 98, 420, 30);
		TimKiem_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		add(TimKiem_textField);
		TimKiem_textField.setColumns(10);

		TimKiem_icon = new JLabel("");
		TimKiem_icon.setIcon(new ImageIcon("image_icon\\search.png"));
		TimKiem_icon.setBounds(565, 96, 32, 32);
		add(TimKiem_icon);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 155, 600, 300);
		add(scrollPane);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				// {null, null, null, null, null},
				},
				new String[] {
						"ID", "TÊN NHÀ CC", "ĐỊA CHỈ ", "ĐIỆN THOẠI", "EMAIL"
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
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setSelectionBackground(new Color(232, 57, 95));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));

		table.setRowHeight(25);
		scrollPane.setViewportView(table);

		btn_Them = new button_custom("THÊM");
		btn_Them.setIcon(new ImageIcon("image_icon\\add-user.png"));
		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setLocation(94, 507);
		btn_Them.setSize(113, 35);
		btn_Them.setRadius(10);
		btn_Them.setBorderPainted(false);
		add(btn_Them);

		btn_Xoa = new button_custom("XÓA");
		btn_Xoa.setIcon(new ImageIcon("image_icon\\delete-user.png"));
		btn_Xoa.setRadius(10);
		btn_Xoa.setForeground(Color.WHITE);
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBounds(291, 507, 113, 35);
		add(btn_Xoa);

		btn_Sua = new button_custom("SỬA");
		btn_Sua.setIcon(new ImageIcon("image_icon\\searching.png"));
		btn_Sua.setRadius(10);
		btn_Sua.setForeground(Color.WHITE);
		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Sua.setBorderPainted(false);
		btn_Sua.setBounds(484, 507, 113, 35);
		add(btn_Sua);

		refresh_label = new JLabel("");
		refresh_label.setIcon(new ImageIcon("image_icon\\refresh.png"));
		refresh_label.setBounds(658, 456, 32, 32);
		add(refresh_label);

		// controller
		controller_btnThem btnThem = new controller_btnThem(this);
		btn_Them.addMouseListener(btnThem);
		controller_btnSua btnSua = new controller_btnSua(this);
		btn_Sua.addMouseListener(btnSua);
		controller_refresh controller_refresh = new controller_refresh(this);
		refresh_label.addMouseListener(controller_refresh);
		controller_Xoa controller_Xoa = new controller_Xoa(this);
		btn_Xoa.addMouseListener(controller_Xoa);
		controller_TimKiem controller_TimKiem = new controller_TimKiem(this);
		TimKiem_icon.addMouseListener(controller_TimKiem);

		// set data ban dau cho table
		Load_DSNCC_from_data_toTable();
		TenDN(staff);
	}

	public int getCheck_open_Jrame() {
		return check_open_Jrame;
	}

	public void TenDN(StaffDTO staff) {
		this.TenDN_label.setText(staff.getName());
	}

	public void ThemNhaCC_Frame() {
		ThemNhaCC_Frame moi = new ThemNhaCC_Frame(this);
		String ma = this.dSachNhaCC.getID(); // 005
		moi.getGanMaNCC_label().setText(ma);
	}

	public void SuaNhaCC_Frame() {
		SuaNhaCC_Frame moi = new SuaNhaCC_Frame(this);
	}

	public void XoaNhaCc_Frame() {
		try {
			String maNCC = JOptionPane.showInputDialog(null, "Nhập mã", "Thông báo", JOptionPane.YES_OPTION);
			Xoa_NCC(maNCC);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// thao tac data voi table
	// du lieu ban dau trong data base
	public ArrayList<SupplierDTO> Load_DSNCC() {
		ArrayList<SupplierDTO> data = getDataFromDAOBUS.getList_Supplier_fromDATA();
		return data;
	}

	public DanhSachNhaCCBUS getdSachNhaCC() {
		return dSachNhaCC;
	}

	public void Load_DSNCC_from_data_toTable() {
		ArrayList<SupplierDTO> data = this.dSachNhaCC.getListNhaCungCap();
		for (SupplierDTO supplier : data) {
			add_data_Table(supplier);
		}

	}

	public void Xoa_NCC(String ma) {
		if (ma.equals("") == false) {
			ArrayList<SupplierDTO> list = this.dSachNhaCC.getListNCC();
			int flag = 0;
			for (SupplierDTO supplier : list) {
				if (supplier.getMa().equals(ma)) {
					flag = 1;
					if (this.dSachNhaCC.xoaNcc_2(supplier) == false) {
						flag = 2;
						break;
					}

				}
			}
			if (flag == 0) {
				// JOptionPane.showConfirmDialog(null, "KHÔNG TỒN TẠI MÃ NHÀ CUNG CẤP", "Thông báo",
				// 		JOptionPane.ERROR_MESSAGE);
				Sys.Sound_Error();
				Sys.Error_dialog("KHÔNG TỒN TẠI MÃ NHÀ CUNG CẤP");
				
			}
			if (flag == 1) {
				// JOptionPane.showConfirmDialog(null, "XÓA THÀNH CÔNG", "Thông báo",
				// 		JOptionPane.INFORMATION_MESSAGE);
				Sys.Sound_Success();
				Sys.Success_dialog("XÓA THÀNH CÔNG");
				
			}
			if (flag == 2) {
				// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ NHÀ CUNG CẤP", "Thông báo",
				// 		JOptionPane.ERROR_MESSAGE);
				Sys.Sound_Error();
				Sys.Error_dialog("KHÔNG THỂ XÓA MÃ NHÀ CUNG CẤP");
				
			}

		}
	}

	// them tung supplier vao table
	public void add_data_Table(SupplierDTO supplier) {
		model = (DefaultTableModel) table.getModel();
		String diachi = supplier.getAddress().thongtin();
		model.addRow(new Object[] {
				supplier.getMa(), supplier.getName(), diachi, supplier.getSdt(), supplier.getEmail()
		});
	}

	// load table neu co supplier bi chinh sua
	public void refresh_table() {
		model = (DefaultTableModel) table.getModel();
		int number_row = model.getRowCount();
		for (int i = number_row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Load_DSNCC_from_data_after_change();
	}

	public void Load_DSNCC_from_data_after_change() {
		ArrayList<SupplierDTO> data = Load_DSNCC();
		this.dSachNhaCC.setlistNhaCungCap(data);
		// this.dSachNhaCC.setCount(data.size());
		for (SupplierDTO supplier : data) {
			add_data_Table(supplier);
		}
	}

	public boolean ThemNV_vaoDATA(SupplierDTO supplier) {
		if (this.dSachNhaCC.themNCC_database(supplier)) {
			
			// JOptionPane.showConfirmDialog(null, "THÊM THÀNH CÔNG", "Thông báo ", JOptionPane.YES_OPTION);
			Sys.Sound_Success();
			Sys.Success_dialog("THÊM THÀNH CÔNG");
			
			return true;
		} else {
			// JOptionPane.showConfirmDialog(null, "THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu)", "Thông báo ",
			// 		JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("THÊM KHÔNG THÀNH CÔNG (Lỗi dữ liệu)");
			
			return false;
		}
	}

	public boolean SuaNCC_vaoDATA(SupplierDTO supplier) {
		if (this.dSachNhaCC.suaNCC_database(supplier)) {
			// JOptionPane.showConfirmDialog(null, "SỬA THÀNH CÔNG", "Thông báo ", JOptionPane.YES_OPTION);
			Sys.Sound_Success();
			Sys.Success_dialog("SỬA THÀNH CÔNG");
			
			return true;
		} else {
			// JOptionPane.showConfirmDialog(null, "SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu)", "Thông báo ",
			// 		JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu)");
			
			return false;
		}

	}

	public void setCheck_open_Jrame(int check_open_Jrame) {
		this.check_open_Jrame = check_open_Jrame;
	}

	public void TimKiem_NCC() {
		String key = this.TimKiem_textField.getText();
		if (key.equals("") == false) {
			ArrayList<SupplierDTO> list_timKiem = this.dSachNhaCC.timKiem_2(key);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (SupplierDTO supplier : list_timKiem) {
				add_data_Table(supplier);
			}
		}
	}
}
