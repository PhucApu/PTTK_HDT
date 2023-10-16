package TrangQuanPhieuHuy;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.DanhSachCTHDBUS;
import BUS.ListProductsBUS;
import BUS.dsChiTietPhieuBUS;
import DTO.ChiTietHDDTO;
import DTO.ChiTietPhieuDTO;
import DTO.PhieuHuyDTO;
import DTO.PhieuXuatDTO;
import DTO.ProductsDTO;
import TrangQuanLyHoaDon.button_custom;
import TrangQuanLyPhieuXuat.controller_btnThoat_XemPXFrame;

public class XemPhieuHetHan_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel XemHoaDon_label;
	private Color mau_chu = new Color (97,113,67);
	private JLabel MaNV_label;
	private JLabel GanMaNV_label;
	private JLabel MaHD_label;
	private JLabel GanMaHD_label;
	private JLabel MaNCC_label;
	private JLabel GanMaNCC_label;
	private JLabel Ngay_label;
	private JLabel GanNgay_label;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel TongTien_label;
	private JLabel GanTongTien_label;
	private button_custom btn_ThoatPN;
	private JLabel TinhTrang_label;
	private JLabel GanTinhTrang_label;
       private TrangQuanLyPhieuHuy trangQuanLyPhieuHuy;
       private DefaultTableModel model;


	public XemPhieuHetHan_Frame(TrangQuanLyPhieuHuy trangQuanLyPhieuHuy) {
              this.trangQuanLyPhieuHuy = trangQuanLyPhieuHuy;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
//		setBackground(new Color(246,225,195));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246,225,195));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		XemHoaDon_label = new JLabel("XEM PHIẾU HỦY", SwingConstants.CENTER);
		XemHoaDon_label.setForeground(new Color(97, 113, 67));
		XemHoaDon_label.setFont(new Font("Tahoma", Font.BOLD, 35));
		XemHoaDon_label.setBounds(35, 10, 630, 40);
		contentPane.add(XemHoaDon_label);
		
		MaNV_label = new JLabel("MÃ NHÂN VIÊN :");
		MaNV_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		MaNV_label.setBounds(100, 66, 100, 30);
		contentPane.add(MaNV_label);
		
		GanMaNV_label = new JLabel("New label");
		GanMaNV_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanMaNV_label.setBounds(210, 66, 100, 30);
		contentPane.add(GanMaNV_label);
		
		MaHD_label = new JLabel("MÃ PHIẾU HỦY :");
		MaHD_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		MaHD_label.setBounds(377, 66, 113, 30);
		contentPane.add(MaHD_label);
		
		GanMaHD_label = new JLabel("New label");
		GanMaHD_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanMaHD_label.setBounds(497, 66, 100, 30);
		contentPane.add(GanMaHD_label);
		
		Ngay_label = new JLabel("NGÀY :");
		Ngay_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		Ngay_label.setBounds(377, 96, 63, 30);
		contentPane.add(Ngay_label);
		
		GanNgay_label = new JLabel("New label");
		GanNgay_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanNgay_label.setBounds(425, 96, 130, 30);
		contentPane.add(GanNgay_label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 136, 600, 160);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID SẢN PHẨM", "TÊN", "SỐ LƯỢNG", "GIÁ BÁN", "NGÀY NHẬP"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		
		
		// chinh sua table
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(232,57,95));
		
		table.setRowHeight(22);
		scrollPane.setViewportView(table);
		
		TongTien_label = new JLabel("Tổng tiền : ");
		TongTien_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		TongTien_label.setBounds(430, 306, 83, 30);
		contentPane.add(TongTien_label);
		
		GanTongTien_label = new JLabel("New label");
		GanTongTien_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GanTongTien_label.setBounds(523, 306, 109, 30);
		contentPane.add(GanTongTien_label);
		
		TinhTrang_label = new JLabel("TÌNH TRẠNG :");
		TinhTrang_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		TinhTrang_label.setBounds(32, 306, 93, 30);
		contentPane.add(TinhTrang_label);
		
		GanTinhTrang_label = new JLabel("new label");
		GanTinhTrang_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		GanTinhTrang_label.setBounds(119, 306, 93, 30);
		contentPane.add(GanTinhTrang_label);
		
		btn_ThoatPN = new button_custom("THOÁT");
		btn_ThoatPN.setRadius(10);
		btn_ThoatPN.setForeground(Color.WHITE);
		btn_ThoatPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ThoatPN.setBorderPainted(false);
		btn_ThoatPN.setBounds(544, 368, 121, 35);
		contentPane.add(btn_ThoatPN);
		setVisible(true);
		ShowPhieu();

		controller_btnThoat_XemPHFrame controller_btnThoat_XemPXFrame = new controller_btnThoat_XemPHFrame(trangQuanLyPhieuHuy, this);
		btn_ThoatPN.addMouseListener(controller_btnThoat_XemPXFrame);

	}
       public void ShowPhieu(){
		PhieuHuyDTO phieuXuat = this.trangQuanLyPhieuHuy.Click_table();
		if(phieuXuat != null){
			this.GanMaHD_label.setText(String.format(Locale.ROOT, phieuXuat.getIDPhieu()));
			this.GanMaNV_label.setText(phieuXuat.getIDNhanVien());
			this.GanNgay_label.setText(phieuXuat.getDate());
			this.GanTinhTrang_label.setText(phieuXuat.getTinhTrang());
			this.GanTongTien_label.setText(String.valueOf(phieuXuat.getSumMoney()));
			dsChiTietPhieuBUS dsChiTietPhieu = phieuXuat.getDsChitietphieu2();
			show_CTphieu(dsChiTietPhieu);
		}
	}
       private void show_CTphieu(dsChiTietPhieuBUS dsChiTietPhieu){
		model = (DefaultTableModel) table.getModel();
		ChiTietPhieuDTO [] chiTietPhieus = dsChiTietPhieu.getChiTietPhieu2s();
		int index = dsChiTietPhieu.getIndex();
		for (int i = 0; i < index; i++) {
                     for (ProductsDTO productsDTO : this.trangQuanLyPhieuHuy.getListProducts().getArr() ) {
                            if(productsDTO.getMaSP().equals(chiTietPhieus[i].getMaSP())){
                                   model.addRow(new Object[]{chiTietPhieus[i].getMaSP(),chiTietPhieus[i].getNameProduct(),chiTietPhieus[i].getSoLuong(),chiTietPhieus[i].getDonGia(),productsDTO.getExpiry_date()});
                                   break;
                            }
                     } 
			
		}
	}

}

