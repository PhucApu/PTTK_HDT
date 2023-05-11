package TrangQuanLyKho;

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




public class TrangQuanLyKho_view extends JPanel {

	private int width_max = 749;		// contenPane - Menu = 1000 - 251
	private int height_max = 600;
	private DefaultTableModel model;
	private JLabel UserIcon_label;
	private JLabel TenDN_label;
	private JLabel QLKho_label;
	private JTextField textField;
	private Color mau_chu = new Color (97,113,67);
	private JLabel TimKiem_icon;
	private JScrollPane scrollPane;
	private JTable table;
	private button_custom btn_Xoa;
	private button_custom btn_Sua;
	private button_custom btn_Xem;
	private JLabel Refresh_icon;
	private int check_open_Jrame = 0;

	private StaffDTO staff;
	private ListProductsBUS listProducts;
	private DanhSachNhaCCBUS danhSachNhaCC;
	public TrangQuanLyKho_view(StaffDTO staff,ListProductsBUS listProducts, DanhSachNhaCCBUS danhSachNhaCC) {
		this.staff = staff;
		this.listProducts = listProducts;
		this.danhSachNhaCC = danhSachNhaCC;

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
		
		QLKho_label = new JLabel("QUẢN LÝ KHO", SwingConstants.CENTER);
		QLKho_label.setForeground(new Color(97, 113, 67));
		QLKho_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLKho_label.setBounds(60, 48, 630, 40);
		add(QLKho_label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
				"ID SẢN PHẨM", "TÊN", "ID NHÀ CC", "SỐ LƯỢNG", "ĐƠN GIÁ","THUẾ"
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
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232,57,95));
		
		table.setRowHeight(22);
		scrollPane.setViewportView(table);
		
		btn_Xoa = new button_custom("XÓA");
		btn_Xoa.setIcon(new ImageIcon("image_icon\\delete.png"));
		btn_Xoa.setRadius(10);
		btn_Xoa.setForeground(Color.WHITE);
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setBounds(303, 498, 113, 35);
		add(btn_Xoa);
		
		btn_Sua = new button_custom("SỬA");
		btn_Sua.setIcon(new ImageIcon("image_icon\\searching.png"));
		btn_Sua.setRadius(10);
		btn_Sua.setForeground(Color.WHITE);
		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Sua.setBorderPainted(false);
		btn_Sua.setBounds(525, 498, 113, 35);
		add(btn_Sua);
		
		btn_Xem = new button_custom("XEM");
		btn_Xem.setIcon(new ImageIcon("image_icon\\products.png"));
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
		Load_DSProducts_from_data_toTable();
		

		// controller
		controller_TimKiem controller_TimKiem = new controller_TimKiem(this);
		TimKiem_icon.addMouseListener(controller_TimKiem);
		controller_btnSua controller_btnSua = new controller_btnSua(this);
		btn_Sua.addMouseListener(controller_btnSua);
		controller_btnXem controller_btnXem = new controller_btnXem(this);
		btn_Xem.addMouseListener(controller_btnXem);
		controller_refresh controller_refresh = new controller_refresh(this);
		Refresh_icon.addMouseListener(controller_refresh);
		controller_btnXoa controller_btnXoa = new controller_btnXoa(this);
		btn_Xoa.addMouseListener(controller_btnXoa);


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
	public DanhSachNhaCCBUS getDanhSachNhaCC() {
		return danhSachNhaCC;
	}
	public ListProductsBUS getListProducts() {
		return listProducts;
	}
	public ArrayList<ProductsDTO> Load_DSProducts() {
		ArrayList<FoodDTO> data_Food = getDataFromDAOBUS.getList_Food_fromDATA();
		ArrayList<DrinkDTO> data_Drink = getDataFromDAOBUS.getList_Drink_fromDATA();

		ListProductsBUS temp = new ListProductsBUS(data_Food, data_Drink);
		ArrayList<ProductsDTO> data = temp.getArr();
		return data;
	}
	public void refresh_table() {
		model = (DefaultTableModel) table.getModel();
		int number_row = model.getRowCount();
		for (int i = number_row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Load_DSProducts_from_data_after_change();
	}
	public void Load_DSProducts_from_data_after_change() {
		ArrayList<ProductsDTO> data = Load_DSProducts();
		this.listProducts.setArr(data);
		// this.dSachNhaCC.setCount(data.size());
		for (ProductsDTO products : data) {
			add_data_Table(products);
		}
	}
	public void add_data_Table( ProductsDTO products) {
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				products.getMaSP(),products.getNameProduct(),products.getMaNCC(),products.getSoluong(),products.getPrice(),products.getTaxes()
		});
	}
	public void Load_DSProducts_from_data_toTable() {
		ArrayList<ProductsDTO> data = this.listProducts.getArr();
		for (ProductsDTO products : data) {
			add_data_Table(products);
		}
	}
	public boolean SuaProduct_vaoDATA(ProductsDTO products){
		if(this.listProducts.Sua_2(products)){
			// JOptionPane.showConfirmDialog(null, "SỬA THÀNH CÔNG", "Thông báo ", JOptionPane.YES_OPTION);
			Sys.Sound_Success();
			Sys.Success_dialog("SỬA THÀNH CÔNG");
			
				return true;
		}
		else{
			// JOptionPane.showConfirmDialog(null, "SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu)", "Thông báo ",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("SỬA KHÔNG THÀNH CÔNG (Lỗi dữ liệu)");
			
				return false;
		}
	}
	public void XoaProduct(String maSP){
		if( maSP.equals("") == false)
		{
			if(this.listProducts.xoa_2(maSP)){
				// JOptionPane.showConfirmDialog(null, "XÓA THÀNH CÔNG", "Thông báo",
				// 		JOptionPane.INFORMATION_MESSAGE);
				Sys.Sound_Success();
				Sys.Success_dialog("XÓA THÀNH CÔNG");
				
			}
			else {
				// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ XÓA PRODUCTS", "Thông báo",
				// 		JOptionPane.ERROR_MESSAGE);
				Sys.Sound_Error();
				Sys.Error_dialog("KHÔNG THỂ XÓA PRODUCTS");
				
			}
		}
	}
	public void TimKiem() {
		String tukhoa = this.textField.getText();
		if (tukhoa.equals("") == false) {
			ArrayList<ProductsDTO> list_search = this.listProducts.timtheoKey_2(tukhoa);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (ProductsDTO iterable_element : list_search) {
				add_data_Table(iterable_element);
			}
		}
	}
	public void SuaSP_Frame(){
		SuaSanPham_Frame suaSanPham_Frame = new SuaSanPham_Frame(this);
	}
	public void XemSP_Frame(){
		XemSanPham_Frame xemSanPham_Frame = new XemSanPham_Frame(this);
	}
	public void XoaSP_Frame(){
		try {
			String maSP = JOptionPane.showInputDialog(null, "Nhập mã", "Thông báo", JOptionPane.YES_OPTION);
			XoaProduct(maSP);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ProductsDTO Click_table() {
		try {
			int click = this.table.getSelectedRow();
			ProductsDTO products = this.listProducts.getArr().get(click);
			return products;
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG");
			
		}
		return null;
	}
	

}
