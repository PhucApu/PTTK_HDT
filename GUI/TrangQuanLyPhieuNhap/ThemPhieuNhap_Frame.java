package TrangQuanLyPhieuNhap;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.*;
import BUS.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import TrangQuanLyNhaCC.button_custom;
import javax.swing.ImageIcon;

public class ThemPhieuNhap_Frame extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JLabel QLPhieuNhap_label;
	private Color mau_chu = new Color(97, 113, 67);
	private JLabel MaNV_label;
	private JLabel GanMaNV_label;
	private JLabel MaPN_label;
	private JLabel GanMaPN_label;
	private JLabel MaNCC_label;
	private JComboBox MaNCC_comboBox;
	private JLabel Ngay_label;
	private JLabel GanNgay_label;
	private JPanel KhungNhapCT_panel;
	private JLabel IPSanPham_label;
	private JTextField IDSanPham_textField;
	private JLabel TenSanPham_label;
	private JTextField TenSP_textField;
	private JLabel GiaSanPham_label;
	private JTextField GiaBan_textField;
	private JLabel SLSanPham_label;
	private JTextField SoLuong_textField;
	private JLabel ThemCTIcon_label;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel TongTien_label;
	private JLabel GanTongTien_label;
	private button_custom btn_ThemPN;
	private button_custom btn_ThoatPN;
	private TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private dsChiTietPhieuBUS dsChiTietPhieu;

	public ThemPhieuNhap_Frame(TrangQuanLyPhieuNhap_view trangQuanLyPhieuNhap_view) {
		this.trangQuanLyPhieuNhap_view = trangQuanLyPhieuNhap_view;
		this.dsChiTietPhieu = new dsChiTietPhieuBUS();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		// setBackground(new Color(246,225,195));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246, 225, 195));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		QLPhieuNhap_label = new JLabel("THÊM PHIẾU NHẬP", SwingConstants.CENTER);
		QLPhieuNhap_label.setForeground(new Color(97, 113, 67));
		QLPhieuNhap_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		QLPhieuNhap_label.setBounds(35, 10, 630, 40);
		contentPane.add(QLPhieuNhap_label);

		MaNV_label = new JLabel("MÃ NHÂN VIÊN :");
		MaNV_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		MaNV_label.setBounds(100, 66, 100, 30);
		contentPane.add(MaNV_label);

		GanMaNV_label = new JLabel("New label");
		GanMaNV_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanMaNV_label.setBounds(210, 66, 100, 30);
		contentPane.add(GanMaNV_label);

		MaPN_label = new JLabel("MÃ PHIẾU NHẬP :");
		MaPN_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		MaPN_label.setBounds(377, 66, 113, 30);
		contentPane.add(MaPN_label);

		GanMaPN_label = new JLabel("New label");
		GanMaPN_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanMaPN_label.setBounds(497, 66, 100, 30);
		contentPane.add(GanMaPN_label);

		MaNCC_label = new JLabel("MÃ NHÀ CC :");
		MaNCC_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		MaNCC_label.setBounds(100, 96, 100, 30);
		contentPane.add(MaNCC_label);

		MaNCC_comboBox = new JComboBox();
		// MaNCC_comboBox.setModel(new DefaultComboBoxModel(new String[] {"1","2"}));
		// DefaultComboBoxModel model = (DefaultComboBoxModel)
		// MaNCC_comboBox.getModel();
		setMaNCC();
		MaNCC_comboBox.setBounds(187, 102, 89, 21);
		contentPane.add(MaNCC_comboBox);

		Ngay_label = new JLabel("NGÀY :");
		Ngay_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Ngay_label.setBounds(377, 96, 63, 30);
		contentPane.add(Ngay_label);

		GanNgay_label = new JLabel("New label");
		GanNgay_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanNgay_label.setBounds(425, 96, 130, 30);
		contentPane.add(GanNgay_label);

		KhungNhapCT_panel = new JPanel();
		KhungNhapCT_panel.setBounds(91, 144, 433, 121);
		KhungNhapCT_panel.setBackground(new Color(246, 225, 195));
		KhungNhapCT_panel.setBorder(BorderFactory.createTitledBorder("NHẬP CHI TIẾT"));
		contentPane.add(KhungNhapCT_panel);
		KhungNhapCT_panel.setLayout(null);

		IPSanPham_label = new JLabel("ID SẢN PHẨM :");
		IPSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		IPSanPham_label.setBounds(10, 29, 100, 30);
		KhungNhapCT_panel.add(IPSanPham_label);

		IDSanPham_textField = new JTextField();
		IDSanPham_textField.setBounds(120, 29, 77, 30);
		KhungNhapCT_panel.add(IDSanPham_textField);
		IDSanPham_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDSanPham_textField.setColumns(10);
		IDSanPham_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));

		TenSanPham_label = new JLabel("TÊN SẢN PHẨM :");
		TenSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		TenSanPham_label.setBounds(10, 69, 100, 30);
		KhungNhapCT_panel.add(TenSanPham_label);

		TenSP_textField = new JTextField();
		TenSP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TenSP_textField.setColumns(10);
		TenSP_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		TenSP_textField.setBounds(120, 69, 77, 30);
		KhungNhapCT_panel.add(TenSP_textField);

		GiaSanPham_label = new JLabel("GIÁ BÁN  :");
		GiaSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GiaSanPham_label.setBounds(238, 29, 77, 30);
		KhungNhapCT_panel.add(GiaSanPham_label);

		GiaBan_textField = new JTextField();
		GiaBan_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GiaBan_textField.setColumns(10);
		GiaBan_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		GiaBan_textField.setBounds(311, 29, 77, 30);
		KhungNhapCT_panel.add(GiaBan_textField);

		SLSanPham_label = new JLabel("SỐ LƯỢNG :");
		SLSanPham_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		SLSanPham_label.setBounds(238, 69, 77, 30);
		KhungNhapCT_panel.add(SLSanPham_label);

		SoLuong_textField = new JTextField();
		SoLuong_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SoLuong_textField.setColumns(10);
		SoLuong_textField.setBorder(BorderFactory.createLineBorder(mau_chu, 2));
		SoLuong_textField.setBounds(311, 69, 77, 30);
		KhungNhapCT_panel.add(SoLuong_textField);

		ThemCTIcon_label = new JLabel("");
		ThemCTIcon_label.setIcon(new ImageIcon("image_icon\\plus.png"));
		ThemCTIcon_label.setBounds(534, 187, 32, 32);
		contentPane.add(ThemCTIcon_label);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 275, 600, 110);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID MÓN ĂN", "TÊN MÓN ĂN", "SỐ LƯỢNG", "GIÁ BÁN"
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

		// chinh sua table
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232, 57, 95));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

		table.setRowHeight(22);
		scrollPane.setViewportView(table);

		TongTien_label = new JLabel("Tổng tiền : ");
		TongTien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		TongTien_label.setBounds(246, 395, 83, 30);
		contentPane.add(TongTien_label);

		GanTongTien_label = new JLabel("0");
		GanTongTien_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanTongTien_label.setBounds(323, 395, 109, 30);
		contentPane.add(GanTongTien_label);

		btn_ThemPN = new button_custom("THÊM");
		btn_ThemPN.setIcon(new ImageIcon("image_icon\\add.png"));
		btn_ThemPN.setRadius(10);
		btn_ThemPN.setForeground(Color.WHITE);
		btn_ThemPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ThemPN.setBorderPainted(false);
		btn_ThemPN.setBounds(155, 435, 121, 35);
		contentPane.add(btn_ThemPN);

		btn_ThoatPN = new button_custom("THOÁT");
		btn_ThoatPN.setText("THOÁT");
		btn_ThoatPN.setRadius(10);
		btn_ThoatPN.setForeground(Color.WHITE);
		btn_ThoatPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ThoatPN.setBorderPainted(false);
		btn_ThoatPN.setBounds(358, 435, 121, 35);
		contentPane.add(btn_ThoatPN);

		// controller
		controller_btnThoat_ThemPhieuFrame controller_btnThem_ThemPhieuFrame = new controller_btnThoat_ThemPhieuFrame(
				this, trangQuanLyPhieuNhap_view);
		btn_ThoatPN.addMouseListener(controller_btnThem_ThemPhieuFrame);
		controller_btnThem_ThemPhieuFrame controller_btnThem_ThemPhieuFrame2 = new controller_btnThem_ThemPhieuFrame(
				this, trangQuanLyPhieuNhap_view);
		btn_ThemPN.addMouseListener(controller_btnThem_ThemPhieuFrame2);
		controller_addIcon_ThemPhieuFrame controller_addIcon_ThemPhieuFrame = new controller_addIcon_ThemPhieuFrame(
				this);
		ThemCTIcon_label.addMouseListener(controller_addIcon_ThemPhieuFrame);
		setVisible(true);
	}

	public JLabel getGanMaNV_label() {
		return GanMaNV_label;
	}

	public JLabel getGanMaPN_label() {
		return GanMaPN_label;
	}

	public JLabel getGanNgay_label() {
		return GanNgay_label;
	}

	public void LayThongTinPhieu_Check() {
		String ID_phieu = this.GanMaPN_label.getText();
		String ID_NV = this.GanMaNV_label.getText();
		String date = this.GanNgay_label.getText();

		// lay ma nha cc
		Object item = this.MaNCC_comboBox.getSelectedItem();
		String value = ((ComboItem) item).getValue();

		if (dsChiTietPhieu.getIndex() == 0) {
			// JOptionPane.showConfirmDialog(null, "KHÔNG THỂ THÊM PHIẾU RỖNG", "Thông báo",
			// 		JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("KHÔNG THỂ THÊM PHIẾU RỖNG");
			
		} else {
			PhieuNhapDTO moi = new PhieuNhapDTO(ID_phieu, date, dsChiTietPhieu, dsChiTietPhieu.Sum_money(), ID_NV,
					value);
			this.trangQuanLyPhieuNhap_view.ThemPhieuNhap_vaoDATA(moi);
			this.setVisible(false);
			this.dispose();
		}

	}

	public void them_chitietPhieu() {
		String ma_sp = this.IDSanPham_textField.getText();
		String name = this.TenSP_textField.getText();
		String soluong = this.SoLuong_textField.getText();
		String dongia = this.GiaBan_textField.getText();
		if (Sys.takeMaSP_2(ma_sp) == true && Sys.takeIntegerInput_2(soluong) == true
				&& Sys.takeIntegerInput_2(dongia) == true) {
			if (dsChiTietPhieu.getIndex() == 0) {
				// JOptionPane.showConfirmDialog(null, "THÊM CT THÀNH CÔNG", "Thông báo",
				// 		JOptionPane.INFORMATION_MESSAGE);
				Sys.Sound_Success();
				Sys.Success_dialog("THÊM CT THÀNH CÔNG");
				
				int sl = Integer.parseInt(soluong);
				int dg = Integer.parseInt(dongia);
				ChiTietPhieuDTO moi = new ChiTietPhieuDTO(name, ma_sp, sl, dg);
				dsChiTietPhieu.add(moi);
				model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { ma_sp, name, soluong, dongia });
				this.GanTongTien_label.setText(String.valueOf(dsChiTietPhieu.Sum_money()));
			}
			// khong cho them trung 
			else {
				int index = dsChiTietPhieu.getIndex();
				ChiTietPhieuDTO[] temp = dsChiTietPhieu.getChiTietPhieu2s();
				int flag = 0;
				for (int i = 0; i < index; i++) {
					if (temp[i].getMaSP().equals(ma_sp)) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					// JOptionPane.showConfirmDialog(null, "THÊM CT THÀNH CÔNG", "Thông báo",
					// 		JOptionPane.INFORMATION_MESSAGE);
					Sys.Sound_Success();
					Sys.Success_dialog("THÊM CT THÀNH CÔNG");
					
					int sl = Integer.parseInt(soluong);
					int dg = Integer.parseInt(dongia);
					ChiTietPhieuDTO moi = new ChiTietPhieuDTO(name, ma_sp, sl, dg);
					dsChiTietPhieu.add(moi);
					model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] { ma_sp, name, soluong, dongia });
					this.GanTongTien_label.setText(String.valueOf(dsChiTietPhieu.Sum_money()));
				}
			}

		} else {
			// JOptionPane.showConfirmDialog(null, "THÊM CT THẤT BẠI", "Thông báo", JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("THÊM CT THẤT BẠI");
			
		}
	}

	public void setMaNCC() {
		ArrayList<SupplierDTO> list = this.trangQuanLyPhieuNhap_view.getDanhSachNhaCC().getListNCC();
		for (SupplierDTO supplier : list) {
			addItem_in_combobox(supplier);
		}
	}

	public void addItem_in_combobox(SupplierDTO supplier) {
		this.MaNCC_comboBox.addItem(new ComboItem(supplier.getMa(), supplier.getMa()));
	}

	public static void main(String[] args) {
		// new ThemPhieuNhap_Frame();
	}
}
