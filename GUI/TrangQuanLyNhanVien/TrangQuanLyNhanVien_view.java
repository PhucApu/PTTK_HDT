package TrangQuanLyNhanVien;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

public class TrangQuanLyNhanVien_view extends JPanel {

	private int width_max = 749; // contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private DefaultTableModel model;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel QLPhieuNhanVien_label;
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
	/**
	 * Create the panel.
	 */
	private StaffsBUS staffs;
	private StaffDTO staff;

	public TrangQuanLyNhanVien_view(StaffDTO staff, StaffsBUS staffs) {
		this.staffs = staffs;
		this.staff = staff;
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

		QLPhieuNhanVien_label = new JLabel("QUẢN LÝ NHÂN VIÊN", SwingConstants.CENTER);
		QLPhieuNhanVien_label.setForeground(new Color(97, 113, 67));
		QLPhieuNhanVien_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLPhieuNhanVien_label.setBounds(60, 48, 630, 40);
		add(QLPhieuNhanVien_label);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		textField.setBounds(135, 98, 447, 30);
		add(textField);

		TimKiem_icon = new JLabel("");
		TimKiem_icon.setIcon(new ImageIcon("image_icon\\search.png"));
		TimKiem_icon.setBounds(592, 98, 32, 32);
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
						"ID NHÂN VIÊN", "TÊN", "GIỚI TÍNH", "ĐỊA CHỈ", "PASSWORD", "LOẠI"
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
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232, 57, 95));

		table.setRowHeight(22);
		scrollPane.setViewportView(table);

		btn_Them = new button_custom("THÊM");
		btn_Them.setIcon(new ImageIcon("image_icon\\add-user.png"));
		btn_Them.setRadius(10);
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Them.setBorderPainted(false);
		btn_Them.setBounds(238, 498, 121, 35);
		add(btn_Them);

		btn_Xoa = new button_custom("XÓA");
		btn_Xoa.setIcon(new ImageIcon("image_icon\\delete-user.png"));
		btn_Xoa.setRadius(10);
		btn_Xoa.setForeground(Color.WHITE);
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBounds(404, 498, 113, 35);
		add(btn_Xoa);

		btn_Sua = new button_custom("SỬA");
		btn_Sua.setIcon(new ImageIcon("image_icon\\searching.png"));
		btn_Sua.setRadius(10);
		btn_Sua.setForeground(Color.WHITE);
		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Sua.setBorderPainted(false);
		btn_Sua.setBounds(547, 498, 113, 35);
		add(btn_Sua);

		btn_Xem = new button_custom("XEM");
		btn_Xem.setIcon(new ImageIcon("image_icon\\profile.png"));
		btn_Xem.setRadius(10);
		btn_Xem.setForeground(Color.WHITE);
		btn_Xem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xem.setBorderPainted(false);
		btn_Xem.setBounds(87, 498, 113, 35);
		add(btn_Xem);

		Refresh_icon = new JLabel("");
		Refresh_icon.setIcon(new ImageIcon("image_icon\\refresh.png"));
		Refresh_icon.setBounds(670, 437, 32, 32);
		add(Refresh_icon);

		TenDN(staff);
		Load_DSStaffs_from_data_toTable();

		// controller
		controller_refresh controller_refresh = new controller_refresh(this);
		Refresh_icon.addMouseListener(controller_refresh);
		controller_btnThemNV controller_btnThemNV = new controller_btnThemNV(this);
		btn_Them.addMouseListener(controller_btnThemNV);
		controller_btnXemNV controller_btnXemNV = new controller_btnXemNV(this);
		btn_Xem.addMouseListener(controller_btnXemNV);
		controller_btnSua controller_btnSua = new controller_btnSua(this);
		btn_Sua.addMouseListener(controller_btnSua);
		controller_btnXoaNV controller_btnXoaNV = new controller_btnXoaNV(this);
		btn_Xoa.addMouseListener(controller_btnXoaNV);
		controller_ClickTable controller_ClickTable = new controller_ClickTable(this);
		table.addMouseListener(controller_ClickTable);
		controller_TimKiem controller_TimKiem = new controller_TimKiem(this);
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

	public ArrayList<StaffDTO> Load_DSStaffs() {
		ArrayList<SeasonalStaffDTO> data_SeasonalStaffs = getDataFromDAOBUS.getList_SeasonalStaffs_fromDATA();
		ArrayList<FullTimeStaffDTO> data_FullTimeStaffs = getDataFromDAOBUS.getList_FullTimeStaffs_fromDATA();
		ArrayList<ManagerDTO> data_Managers = getDataFromDAOBUS.getList_Manager_fromDATA();

		StaffsBUS temp = new StaffsBUS();
		// phai dat dung thu tu neu khong se bao loi
		temp.addList_SeasonalStaff(data_SeasonalStaffs);
		temp.addList_Manager(data_Managers);
		temp.addList_FullTimeStaff(data_FullTimeStaffs);
		ArrayList<StaffDTO> data = temp.getStaffs();
		return data;
	}

	public StaffsBUS getStaffs() {
		return staffs;
	}

	// refresh
	public void refresh_table() {
		model = (DefaultTableModel) table.getModel();
		int number_row = model.getRowCount();
		for (int i = number_row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Load_DSStaffs_from_data_after_change();
	}

	public void Load_DSStaffs_from_data_after_change() {
		ArrayList<StaffDTO> data = Load_DSStaffs();
		this.staffs.setStaffs(data);
		// this.dSachNhaCC.setCount(data.size());
		for (StaffDTO staff : data) {
			add_data_Table(staff);
		}
	}

	public void add_data_Table(StaffDTO staff) {
		model = (DefaultTableModel) table.getModel();
		String diachi = staff.getAddress().thongtin();
		String loai = "";
		if (staff instanceof ManagerDTO) {
			loai = "Manager";
		} else if (staff instanceof FullTimeStaffDTO) {
			loai = "FullTimeStaff";
		} else if (staff instanceof SeasonalStaffDTO) {
			loai = "SeasonalStaff";
		}
		model.addRow(new Object[] {
				staff.getId(), staff.getName(), staff.getGender(), diachi, staff.getPassWord(), loai
		});
	}

	public void Load_DSStaffs_from_data_toTable() {
		ArrayList<StaffDTO> data = this.staffs.getStaffs();
		for (StaffDTO staff : data) {
			add_data_Table(staff);
		}
	}

	public boolean ThemNhanVien_vaoDATA(StaffDTO staff) {
		if (this.staffs.themNhanVien_2(staff)) {
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

	public boolean SuaNhanVien_vaoDATA(StaffDTO staff) {

		if (this.staffs.suaNhanVien_2(staff)) {
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
	public void Xoa_NhanVien(String ma) {
		if (ma.equals("") == false) {
			int flag = 0;
			for (StaffDTO staff : this.staffs.getStaffs()) {
				if( staff.getId().equals(ma)){
					flag = 1;
					if (this.staffs.xoaNhanVien_2(staff)) {
						// JOptionPane.showConfirmDialog(null, "XÓA THÀNH CÔNG", "Thông báo",
						// 		JOptionPane.INFORMATION_MESSAGE);
						Sys.Sound_Success();
						Sys.Success_dialog("XÓA THÀNH CÔNG");
						
					} else {
						// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA NHÂN VIÊN", "Thông báo",
						// 		JOptionPane.ERROR_MESSAGE);
						Sys.Sound_Error();
						Sys.Error_dialog("KHÔNG THỂ XÓA NHÂN VIÊN");
						
					}
					break;
				}
			}
			if(flag == 0){
				Sys.Sound_Error();
				Sys.Error_dialog("KHÔNG TỒN TẠI NHÂN VIÊN ");
			}

			
		}
	}
	public void TimKiem() {
		String tukhoa = this.textField.getText();
		if (tukhoa.equals("") == false) {
			ArrayList<StaffDTO> list_search = this.staffs.timtheoKey_2(tukhoa);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (StaffDTO iterable_element : list_search) {
				add_data_Table(iterable_element);
			}
		}
	}
	public StaffDTO Click_table() {
		try {
			int click = this.table.getSelectedRow();
			StaffDTO staff = this.staffs.getStaffs().get(click);
			return staff;
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT NHÂN VIÊN TRONG BẢNG", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("HÃY CLICK CHỌN MỘT NHÂN VIÊN TRONG BẢNG");
			
		}
		return null;

	}
	public void ThemNV_Frame(){
		ThemNhanVien_Frame themNhanVien_Frame = new ThemNhanVien_Frame(this);
	}
	public void SuaNV_Frame(){
		SuaNhanVien_Frame suaNhanVien_Frame = new SuaNhanVien_Frame(this);
	}
	public void XoaNV_Frame(){
		try {
			String maNV = JOptionPane.showInputDialog(null, "Nhập mã cần xóa", "Thông báo", JOptionPane.YES_OPTION);
			Xoa_NhanVien(maNV);
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ NHÂN VIÊN", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ XÓA MÃ NHÂN VIÊN");
			
		}
	}
	public void XemNV_Frame(){
		XemNhanVien_Frame xemNhanVien_Frame = new XemNhanVien_Frame(this);
	}

}
