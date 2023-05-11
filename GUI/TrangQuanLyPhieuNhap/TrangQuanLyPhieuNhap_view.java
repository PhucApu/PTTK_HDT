package TrangQuanLyPhieuNhap;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import TrangQuanLyNhaCC.button_custom;

public class TrangQuanLyPhieuNhap_view extends JPanel {

	private DefaultTableModel model;
	private int width_max = 749; // contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel QLPhieuNhap_label;
	private JTextField textField;
	private Color mau_chu = new Color(97, 113, 67);
	private JLabel TimKiem_icon;
	private JScrollPane scrollPane;
	private JTable table;
	private button_custom btn_Them;
	private button_custom btn_Xoa;
	private button_custom btn_Sua;
	private button_custom btn_Xem;
	private JLabel Refresh_icon;
	private int check_open_Jrame = 0;
	private button_custom btn_XacNhan;
	/**
	 * Create the panel.
	 */
	private dsPhieuNhapBUS dsPhieuNhap;
	private DanhSachNhaCCBUS danhSachNhaCC;
	private ListProductsBUS listProducts;
	private StaffDTO staff;

	public TrangQuanLyPhieuNhap_view(StaffDTO staff, dsPhieuNhapBUS dsPhieuNhap, DanhSachNhaCCBUS danhSachNhaCC,
			ListProductsBUS listProducts) {
		this.dsPhieuNhap = dsPhieuNhap;
		this.staff = staff;
		this.danhSachNhaCC = danhSachNhaCC;
		this.listProducts = listProducts;
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

		QLPhieuNhap_label = new JLabel("QUẢN LÝ PHIẾU NHẬP", SwingConstants.CENTER);
		QLPhieuNhap_label.setForeground(new Color(97, 113, 67));
		QLPhieuNhap_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLPhieuNhap_label.setBounds(60, 48, 630, 40);
		add(QLPhieuNhap_label);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		textField.setBounds(135, 98, 420, 30);
		add(textField);

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
				},
				new String[] {
						"ID PHIẾU NHẬP", "ID NHÂN VIÊN", "ID NHÀ CC", "NGÀY NHẬP", "TÌNH TRẠNG",
						"TỔNG TIỀN"
				}) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
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
		table.getColumnModel().getColumn(5).setResizable(false);

		// chinh sua table
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(Color.white);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setSelectionBackground(new Color(232, 57, 95));

		table.setRowHeight(22);
		scrollPane.setViewportView(table);

		btn_Them = new button_custom("THÊM");
		btn_Them.setIcon(new ImageIcon("image_icon\\add.png"));
		btn_Them.setRadius(10);
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Them.setBorderPainted(false);
		btn_Them.setBounds(169, 498, 121, 35);
		add(btn_Them);

		btn_Xoa = new button_custom("XÓA");
		btn_Xoa.setIcon(new ImageIcon("image_icon\\invoice_delete.png"));
		btn_Xoa.setRadius(10);
		btn_Xoa.setForeground(Color.WHITE);
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBounds(315, 498, 113, 35);
		add(btn_Xoa);

		btn_Sua = new button_custom("SỬA");
		btn_Sua.setIcon(new ImageIcon("image_icon\\searching.png"));
		btn_Sua.setRadius(10);
		btn_Sua.setForeground(Color.WHITE);
		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Sua.setBorderPainted(false);
		btn_Sua.setBounds(453, 498, 113, 35);
		add(btn_Sua);

		btn_Xem = new button_custom("XEM");
		btn_Xem.setIcon(new ImageIcon("image_icon\\invoice.png"));
		btn_Xem.setRadius(10);
		btn_Xem.setForeground(Color.WHITE);
		btn_Xem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xem.setBorderPainted(false);
		btn_Xem.setBounds(36, 498, 113, 35);
		add(btn_Xem);

		Refresh_icon = new JLabel("");
		Refresh_icon.setIcon(new ImageIcon("image_icon\\refresh.png"));
		Refresh_icon.setBounds(670, 437, 32, 32);
		add(Refresh_icon);

		btn_XacNhan = new button_custom("SỬA");
		btn_XacNhan.setIcon(new ImageIcon("image_icon\\import.png"));
		btn_XacNhan.setText("NHẬP");
		btn_XacNhan.setRadius(10);
		btn_XacNhan.setForeground(Color.WHITE);
		btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_XacNhan.setBorderPainted(false);
		btn_XacNhan.setBounds(592, 498, 121, 35);
		add(btn_XacNhan);
		TenDN(staff);
		Load_DSPhieuNhap_from_data_toTable();

		// controller
		controller_btnThem controller_btnThem = new controller_btnThem(this);
		btn_Them.addMouseListener(controller_btnThem);
		controller_btnXem controller_btnXem = new controller_btnXem(this);
		btn_Xem.addMouseListener(controller_btnXem);
		controller_btnSua controller_btnSua = new controller_btnSua(this);
		btn_Sua.addMouseListener(controller_btnSua);
		controller_refresh controller_refresh = new controller_refresh(this);
		Refresh_icon.addMouseListener(controller_refresh);
		controller_ClickTabel controller_ClickTabel = new controller_ClickTabel(this);
		table.addMouseListener(controller_ClickTabel);
		controller_btnXoa controller_btnXoa = new controller_btnXoa(this);
		btn_Xoa.addMouseListener(controller_btnXoa);
		controller_btnNhap controller_btnNhap = new controller_btnNhap(this);
		btn_XacNhan.addMouseListener(controller_btnNhap);
		controller_TimKiemIcon controller_TimKiem = new controller_TimKiemIcon(this);
		TimKiem_icon.addMouseListener(controller_TimKiem);
	}

	public void TenDN(StaffDTO staff) {
		this.TenDN_label.setText(staff.getName());
	}

	public void setCheck_open_Jrame(int check_open_Jrame) {
		this.check_open_Jrame = check_open_Jrame;
	}

	public int getCheck_open_Jrame() {
		return check_open_Jrame;
	}

	public ArrayList<PhieuNhapDTO> Load_DSPhieuNhap() {
		ArrayList<PhieuNhapDTO> data = getDataFromDAOBUS.getList_PhieuNhap_fromDATA();
		return data;
	}

	public dsPhieuNhapBUS getDsPhieuNhap() {
		return dsPhieuNhap;
	}

	public ListProductsBUS getListProducts() {
		return listProducts;
	}

	public DanhSachNhaCCBUS getDanhSachNhaCC() {
		return danhSachNhaCC;
	}

	// refresh
	public void refresh_table() {
		model = (DefaultTableModel) table.getModel();
		int number_row = model.getRowCount();
		for (int i = number_row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Load_DSPhieuNhap_from_data_after_change();
	}

	public void Load_DSPhieuNhap_from_data_after_change() {
		ArrayList<PhieuNhapDTO> data = Load_DSPhieuNhap();
		this.dsPhieuNhap.setDsPhieunhap(data);
		// this.dSachNhaCC.setCount(data.size());
		for (PhieuNhapDTO phieuNhap : data) {
			add_data_Table(phieuNhap);
		}
	}

	public boolean ThemPhieuNhap_vaoDATA(PhieuNhapDTO phieuNhap) {
		if (this.dsPhieuNhap.add_2(phieuNhap)) {
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

	public boolean SuaPhieuNhap_vaoDATA(PhieuNhapDTO phieuNhap) {
		if (phieuNhap.getTinh_trang().equals("Chưa nhập")) {
			if (this.dsPhieuNhap.Suachitiet_2(phieuNhap)) {
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
		} else {
			// JOptionPane.showConfirmDialog(null,
					// "SỬA KHÔNG THÀNH CÔNG (Không thể sửa phiếu nhập đã nhập vào kho)", "Thông báo ",
					// JOptionPane.ERROR_MESSAGE);
					Sys.Sound_Error();
					Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Không thể sửa phiếu nhập đã nhập vào kho)");
					
			return false;
		}

	}

	public void Xoa_PhieuNhap(String ma) {
		if (ma.equals("") == false) {
			if (this.dsPhieuNhap.Xoa_2(ma)) {
				// JOptionPane.showConfirmDialog(null, "XÓA THÀNH CÔNG", "Thông báo",
				// 		JOptionPane.INFORMATION_MESSAGE);
				Sys.Sound_Success();
				Sys.Success_dialog("XÓA THÀNH CÔNG");
				
			} else {
				// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ PHIẾU", "Thông báo",
				// 		JOptionPane.ERROR_MESSAGE);
				Sys.Sound_Error();
				Sys.Error_dialog("KHÔNG THỂ XÓA MÃ PHIẾU");
				
			}
		}
	}

	public void TimKiem() {
		String tukhoa = this.textField.getText();
		if (tukhoa.equals("") == false) {
			ArrayList<PhieuNhapDTO> list_search = this.dsPhieuNhap.TimkiemtheoKey_2(tukhoa);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (PhieuNhapDTO iterable_element : list_search) {
				add_data_Table(iterable_element);
			}
		}
	}
	public void nhapvaokho(String maPhieu){
		if(this.dsPhieuNhap.Capnhatvaokho_2(maPhieu, listProducts)){
			// JOptionPane.showConfirmDialog(null, "NHẬP VÀO KHO THÀNH CÔNG", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Success();
			Sys.Success_dialog("NHẬP VÀO KHO THÀNH CÔNG");
			
		}
		else{
			// JOptionPane.showConfirmDialog(null, "NHẬP VÀO KHO THẤT BẠI", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("NHẬP VÀO KHO THẤT BẠI");
			
		}
	}

	public void ThemPhieuNhap_Frame() {
		ThemPhieuNhap_Frame themPhieuNhap_Frame = new ThemPhieuNhap_Frame(this);
		themPhieuNhap_Frame.getGanMaNV_label().setText(this.staff.getId());
		themPhieuNhap_Frame.getGanMaPN_label().setText(this.dsPhieuNhap.getMaSP_Drink());
		themPhieuNhap_Frame.getGanNgay_label().setText(Sys.getDateNow());
	}

	public void SuaPhieuNhap_Frame() {
		SuaPhieuNhap_Frame suaPhieuNhap_Frame = new SuaPhieuNhap_Frame(this);
	}

	public void XemPhieuNhap_Frame() {
		XemPhieuNhap_Frame xemPhieuNhap_Frame = new XemPhieuNhap_Frame(this);
	}

	public void XoaPhieu_Frame() {
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xóa", "Thông báo", JOptionPane.YES_OPTION);
			Xoa_PhieuNhap(maPhieu);
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ PHIẾU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ XÓA MÃ PHIẾU");
			
		}

	}
	public void Nhapvaokho_Frame(){
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần nhập", "Thông báo", JOptionPane.YES_OPTION);
			nhapvaokho(maPhieu);

		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ NHẬP MÃ PHIẾU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ NHẬP MÃ PHIẾU");
			
			// e.printStackTrace();
		}
	}
	public PhieuNhapDTO Click_table() {
		try {
			int click = this.table.getSelectedRow();
			PhieuNhapDTO phieuNhap = this.dsPhieuNhap.getDsPhieuNhap().get(click);
			return phieuNhap;
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG");
			
		}
		return null;

	}

	public void Load_DSPhieuNhap_from_data_toTable() {
		ArrayList<PhieuNhapDTO> data = this.dsPhieuNhap.getDsPhieuNhap();
		for (PhieuNhapDTO phieuNhap : data) {
			add_data_Table(phieuNhap);
		}
	}

	public void add_data_Table(PhieuNhapDTO phieuNhap) {
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				phieuNhap.getIDPhieu(), phieuNhap.getIDNhanVien(), phieuNhap.getMaNXS(),
				phieuNhap.getDate(), String.format(Locale.ROOT, phieuNhap.getTinh_trang()) , phieuNhap.getSumMoney()
		});
	}
	

}
