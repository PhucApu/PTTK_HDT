package TrangQuanLyPhieuXuat;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

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
import TrangQuanLyNhaCC.button_custom;

public class TrangQuanLyPhieuXuat_view extends JPanel {
	private DefaultTableModel model;
	private int width_max = 749;		// contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel QLPhieuXuat_label;
	private JTextField textField;
	private Color mau_chu = new Color (97,113,67);
	private JLabel TimKiem_icon;
	private JScrollPane scrollPane;
	private JTable table;
	// private button_custom btn_Them;
	private button_custom btn_Xoa;
	private button_custom btn_Xem;
	private JLabel Refresh_icon;
	private int check_open_Jrame = 0;

	private StaffDTO staff;
	private dsPhieuXuatBUS dsPhieuXuat;
	private DanhSachHDBUS danhSachHD;
	private ListProductsBUS listProducts;
	
	public TrangQuanLyPhieuXuat_view(StaffDTO staff, dsPhieuXuatBUS dsPhieuXuat, DanhSachHDBUS danhSachHD, ListProductsBUS listProducts) {
		this.staff = staff;
		this.dsPhieuXuat = dsPhieuXuat;
		this.danhSachHD = danhSachHD;
		this.listProducts = listProducts;
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
		
		QLPhieuXuat_label = new JLabel("QUẢN LÝ PHIẾU XUẤT", SwingConstants.CENTER);
		QLPhieuXuat_label.setForeground(new Color(97, 113, 67));
		QLPhieuXuat_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLPhieuXuat_label.setBounds(60, 48, 630, 40);
		add(QLPhieuXuat_label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
				"ID PHIẾU XUẤT", "ID HÓA ĐƠN", "ID NHÂN VIÊN","NGÀY XUẤT", "TÌNH TRẠNG","TỔNG TIỀN"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false,false
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
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232,57,95));
		
		table.setRowHeight(22);
		scrollPane.setViewportView(table);
		
		btn_Xoa = new button_custom("XÓA");
		btn_Xoa.setIcon(new ImageIcon("image_icon\\invoice_delete.png"));
		btn_Xoa.setRadius(10);
		btn_Xoa.setForeground(Color.WHITE);
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBounds(309, 498, 113, 35);
		add(btn_Xoa);
		
		btn_Xem = new button_custom("XEM");
		btn_Xem.setIcon(new ImageIcon("image_icon\\invoice.png"));
		btn_Xem.setRadius(10);
		btn_Xem.setForeground(Color.WHITE);
		btn_Xem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xem.setBorderPainted(false);
		btn_Xem.setBounds(94, 498, 113, 35);
		add(btn_Xem);
		
		Refresh_icon = new JLabel("");
		Refresh_icon.setIcon(new ImageIcon("image_icon\\refresh.png"));
		Refresh_icon.setBounds(670, 437, 32, 32);
		add(Refresh_icon);
		
		button_custom btn_XacNhan = new button_custom("XUẤT");
		btn_XacNhan.setIcon(new ImageIcon("image_icon\\import_2.png"));
		btn_XacNhan.setRadius(10);
		btn_XacNhan.setForeground(Color.WHITE);
		btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_XacNhan.setBorderPainted(false);
		btn_XacNhan.setBounds(521, 498, 121, 35);
		add(btn_XacNhan);

		TenDN(staff);
		Load_DSPhieuXuat_from_data_toTable();

		// controller
		controller_TimKiemIcon controller_TimKiemIcon = new controller_TimKiemIcon(this);
		TimKiem_icon.addMouseListener(controller_TimKiemIcon);
		controller_refresh controller_refresh = new controller_refresh(this);
		Refresh_icon.addMouseListener(controller_refresh);
		controller_btnXemPX controller_btnXemPX = new controller_btnXemPX(this);
		btn_Xem.addMouseListener(controller_btnXemPX);
		controller_btnXoaPX controller_btnXoaPX = new controller_btnXoaPX(this);
		btn_Xoa.addMouseListener(controller_btnXoaPX);
		controller_btnXacNhanPX controller_btnXacNhanPX = new controller_btnXacNhanPX(this);
		btn_XacNhan.addMouseListener(controller_btnXacNhanPX);
		controller_ClickTable clickTable = new controller_ClickTable(this);
		table.addMouseListener(clickTable);
		
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
	public ArrayList<PhieuXuatDTO> Load_DSPhieuXuat() {
		ArrayList<PhieuXuatDTO> data = getDataFromDAOBUS.getList_PhieuXuat_fromDATA();
		return data;
	}
	public dsPhieuXuatBUS getDsPhieuXuat() {
		return dsPhieuXuat;
	}
	public DanhSachHDBUS getDanhSachHD() {
		return danhSachHD;
	}
	public ListProductsBUS getListProducts() {
		return listProducts;
	}
	// refresh
	public void refresh_table() {
		model = (DefaultTableModel) table.getModel();
		int number_row = model.getRowCount();
		for (int i = number_row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Load_DSPhieuXuat_from_data_after_change();
	}

	public void Load_DSPhieuXuat_from_data_after_change() {
		ArrayList<PhieuXuatDTO> data = Load_DSPhieuXuat();
		this.dsPhieuXuat.setDsPhieuxuat(data);
		// this.dSachNhaCC.setCount(data.size());
		for (PhieuXuatDTO phieuXuat : data) {
			add_data_Table(phieuXuat);
		}
	}
	public void add_data_Table(PhieuXuatDTO phieuXuat) {
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				phieuXuat.getIDPhieu(),phieuXuat.getIDHoaDon(),phieuXuat.getIDNhanVien(),phieuXuat.getDate(),phieuXuat.getTinhTrang(),phieuXuat.getSumMoney()
		});
	}
	public void Load_DSPhieuXuat_from_data_toTable() {
		ArrayList<PhieuXuatDTO> data = this.dsPhieuXuat.getDsPhieuxuat();
		for (PhieuXuatDTO phieuXuat : data) {
			add_data_Table(phieuXuat);
		}
	}
	public PhieuXuatDTO Click_table() {
		try {
			int click = this.table.getSelectedRow();
			PhieuXuatDTO phieuXuat = this.dsPhieuXuat.getDsPhieuxuat().get(click);
			return phieuXuat;
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG");
			
		}
		return null;
	}
	public void Xuatkho(String maPhieu){
		if(this.dsPhieuXuat.XacnhanXuatko_2(this.staff,this.listProducts, maPhieu)){
			// JOptionPane.showConfirmDialog(null, "XUẤT KHO THÀNH CÔNG", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Success();
			Sys.Success_dialog("XUẤT KHO THÀNH CÔNG");
			
		}
		else{
			// JOptionPane.showConfirmDialog(null, "XUẤT KHO THẤT BẠI", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("XUẤT KHO THẤT BẠI");
			
		}
	}
	public void Xoa_PhieuXuat(String ma) {
		if (ma.equals("") == false) {
			if (this.dsPhieuXuat.Xoa_2(ma)) {
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
			ArrayList<PhieuXuatDTO> list_search = this.dsPhieuXuat.TimkiemtheoKey_2(tukhoa);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (PhieuXuatDTO iterable_element : list_search) {
				add_data_Table(iterable_element);
			}
		}
	}

	public void XemPhieuXuat_Frame() {
		XemPhieuXuat_Frame xemPhieuXuat_Frame = new XemPhieuXuat_Frame(this);
	}
	public void Xuatkho_Frame(){
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xuất", "Thông báo", JOptionPane.YES_OPTION);
			Xuatkho(maPhieu);

		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ NHẬP MÃ PHIẾU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ NHẬP MÃ PHIẾU");
			
			// e.printStackTrace();
		}
	}
	public void XoaPhieu_Frame() {
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xóa", "Thông báo", JOptionPane.YES_OPTION);
			Xoa_PhieuXuat(maPhieu);
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ PHIẾU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ XÓA MÃ PHIẾU");
			
		}

	}


	

}
