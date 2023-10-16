package TrangQuanPhieuHuy;

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

import BUS.ListProductsBUS;
import BUS.dsPhieuHuyBUS;
import BUS.getDataFromDAOBUS;
import DTO.PhieuHuyDTO;
import DTO.StaffDTO;
import DTO.Sys;
import TrangQuanLyNhaCC.button_custom;


public class TrangQuanLyPhieuHuy extends JPanel {
	private DefaultTableModel model;
       private int width_max = 749;		// contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel QLHetHan_label;
	private JTextField textField;
	private Color mau_chu = new Color (97,113,67);
	private JLabel TimKiem_icon;
	private JScrollPane scrollPane;
	private JTable table;
	private button_custom btn_Them;
	private button_custom btn_Xoa;
	private button_custom btn_Xem;
	private JLabel Refresh_icon;
	private int check_open_Jrame = 0;
	private button_custom btn_Sua;

	private ListProductsBUS listProductsBUS;
	private dsPhieuHuyBUS dsPhieuHuyBUS;
	private StaffDTO staffDTO;

       public TrangQuanLyPhieuHuy(StaffDTO staff, dsPhieuHuyBUS dsPhieuHuyBUS, ListProductsBUS listProductsBUS){
              setSize(width_max, height_max);
		setBackground(new Color(246,225,195));
		setLayout(null);
		this.dsPhieuHuyBUS = dsPhieuHuyBUS;
		this.listProductsBUS = listProductsBUS;
		this.staffDTO = staff;
		
		UserIcon_label = new JLabel("", JLabel.CENTER);
		UserIcon_label.setIcon(new ImageIcon("image_icon\\user.png"));
		UserIcon_label.setBounds(584, 10, 40, 40);
		add(UserIcon_label);
		
		TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
		TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		TenDN_label.setBounds(618, 10, 121, 30);
		add(TenDN_label);
		
		QLHetHan_label = new JLabel("QUẢN LÝ PHIẾU HẾT HẠN", SwingConstants.CENTER);
		QLHetHan_label.setForeground(new Color(97, 113, 67));
		QLHetHan_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLHetHan_label.setBounds(60, 48, 630, 40);
		add(QLHetHan_label);
		
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
				"ID PHIẾU HỦY", "ID NHÂN VIÊN", "NGÀY TẠO", "TÌNH TRẠNG","TỔNG TIỀN"
			}
		) {
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
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232,57,95));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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

		button_custom btn_XacNhan = new button_custom("XÁC NHẬN");
		btn_XacNhan.setText("");
		btn_XacNhan.setIcon(new ImageIcon("image_icon\\file.png"));
		btn_XacNhan.setRadius(10);
		btn_XacNhan.setForeground(Color.WHITE);
		btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_XacNhan.setBorderPainted(false);
		btn_XacNhan.setBounds(592, 498, 121, 35);
		add(btn_XacNhan);
		
		Refresh_icon = new JLabel("");
		Refresh_icon.setIcon(new ImageIcon("image_icon\\refresh.png"));
		Refresh_icon.setBounds(670, 437, 32, 32);
		add(Refresh_icon);
		
		btn_Xem = new button_custom("XEM");
		btn_Xem.setIcon(new ImageIcon("mage_icon\\invoice.png"));
		btn_Xem.setRadius(10);
		btn_Xem.setForeground(Color.WHITE);
		btn_Xem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xem.setBorderPainted(false);
		btn_Xem.setBounds(36, 498, 113, 35);
		add(btn_Xem); 

		TenDN(staff);
		Load_DSPhieuHuy_from_data_toTable();

		controller_TimKiemIcon controller_TimKiemIcon = new controller_TimKiemIcon(this);
		TimKiem_icon.addMouseListener(controller_TimKiemIcon);
		controller_refresh controller_refresh = new controller_refresh(this);
		Refresh_icon.addMouseListener(controller_refresh);
		controller_btnXemPH controller_btnXemPX = new controller_btnXemPH(this);
		btn_Xem.addMouseListener(controller_btnXemPX);
		controller_btnXoaPH controller_btnXoaPX = new controller_btnXoaPH(this);
		btn_Xoa.addMouseListener(controller_btnXoaPX);

		controller_btnXacNhanPH controller_btnXacNhanPX = new controller_btnXacNhanPH(this);
		btn_XacNhan.addMouseListener(controller_btnXacNhanPX);

		controller_ClickTable clickTable = new controller_ClickTable(this);
		table.addMouseListener(clickTable);

		controller_btnSua controller_btnSua = new controller_btnSua(this);
		btn_Sua.addMouseListener(controller_btnSua);

		controller_btnThem controller_btnThem = new controller_btnThem(this);
		btn_Them.addMouseListener(controller_btnThem);

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
	public ArrayList<PhieuHuyDTO> Load_DSPhieuHuy() {
		ArrayList<PhieuHuyDTO> data = getDataFromDAOBUS.getList_PhieuHuy_fromDATA();
		return data;
	}
	public ListProductsBUS getListProducts() {
		return listProductsBUS;
	}
	public dsPhieuHuyBUS getDsPhieuHuyBUS() {
		return dsPhieuHuyBUS;
	}
	public void setDsPhieuHuyBUS(dsPhieuHuyBUS dsPhieuHuyBUS) {
		this.dsPhieuHuyBUS = dsPhieuHuyBUS;
	}
	public void Load_DSPhieuHuy_from_data_toTable() {
		ArrayList<PhieuHuyDTO> data = this.dsPhieuHuyBUS.getDsPhieuhuy();
		for (PhieuHuyDTO phieuXuat : data) {
			add_data_Table(phieuXuat);
		}
	}

	public void refresh_table() {
		model = (DefaultTableModel) table.getModel();
		int number_row = model.getRowCount();
		for (int i = number_row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Load_DSPhieuHuy_from_data_after_change();
	}
	public void Load_DSPhieuHuy_from_data_after_change() {
		ArrayList<PhieuHuyDTO> data = getDataFromDAOBUS.getList_PhieuHuy_fromDATA();
		for (PhieuHuyDTO phieuXuat : data) {
			add_data_Table(phieuXuat);
		}
	}
	public void add_data_Table(PhieuHuyDTO phieuXuat) {
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				phieuXuat.getIDPhieu(),phieuXuat.getIDNhanVien(),phieuXuat.getDate(),phieuXuat.getTinhTrang(),phieuXuat.getSumMoney()
		});
	}
	public PhieuHuyDTO Click_table() {
		try {
			int click = this.table.getSelectedRow();
			PhieuHuyDTO phieuXuat = this.dsPhieuHuyBUS.getDsPhieuhuy().get(click);
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
		if(this.dsPhieuHuyBUS.XacnhanXuatko_2(this.staffDTO,this.listProductsBUS, maPhieu)){
			// JOptionPane.showConfirmDialog(null, "XUẤT KHO THÀNH CÔNG", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Success();
			Sys.Success_dialog("XÁC NHẬN THÀNH CÔNG");
			
		}
		else{
			// JOptionPane.showConfirmDialog(null, "XUẤT KHO THẤT BẠI", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("XÁC NHẬN THẤT BẠI");
			
		}
	}
	public void Xoa_PhieuHuy(String ma) {
		if (ma.equals("") == false) {
			if (this.dsPhieuHuyBUS.Xoa_2(ma)) {
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
			ArrayList<PhieuHuyDTO> list_search = this.dsPhieuHuyBUS.TimkiemtheoKey_2(tukhoa);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (PhieuHuyDTO iterable_element : list_search) {
				add_data_Table(iterable_element);
			}
		}
	}

	public void XemPhieuXuat_Frame() {
		XemPhieuHetHan_Frame xemPhieuXuat_Frame = new XemPhieuHetHan_Frame(this);
	}
	public void SuaPhieuHuy_Frame() {
		SuaPhieuHuy_Frame suaPhieuNhap_Frame = new SuaPhieuHuy_Frame(this);
	}
	public void XoaPhieu_Frame() {
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xóa", "Thông báo", JOptionPane.YES_OPTION);
			Xoa_PhieuHuy(maPhieu);
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA MÃ PHIẾU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ XÓA MÃ PHIẾU");
			
		}
	}
	public void ThemPhieuHuy_Frame() {
		ThemPhieuHuy_Frame themPhieuHuy_Frame = new ThemPhieuHuy_Frame(this);
		themPhieuHuy_Frame.getGanMaNV_label().setText(this.staffDTO.getId());
		themPhieuHuy_Frame.getGanMaHD_label().setText(this.dsPhieuHuyBUS.getID());
		themPhieuHuy_Frame.getGanNgay_label().setText(Sys.getDateNow());
	}
	public void Xuatkho_Frame(){
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xuất", "Thông báo", JOptionPane.YES_OPTION);
			Xuatkho(maPhieu);

		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ NHẬP MÃ PHIẾU", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("KHÔNG THỂ XÁC NHẬN MÃ PHIẾU");
			
			// e.printStackTrace();
		}
	}
	public boolean SuaPhieuHuy_vaoDATA(PhieuHuyDTO phieuHuy) {
		if (phieuHuy.getTinhTrang().equals("Chưa xác nhận")) {
			if (this.dsPhieuHuyBUS.Suachitiet_2(phieuHuy)) {
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
					Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Không thể sửa phiếu hủy đã xác nhận vào kho)");
					
			return false;
		}

	}


	



}
