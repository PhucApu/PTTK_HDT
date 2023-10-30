package TrangQuanLyPhieuKiem;

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

import BUS.ListProductsBUS;
import BUS.dsPhieuKiemBUS;
import BUS.getDataFromDAOBUS;
import DTO.PhieuKiemDTO;
import DTO.PhieuNhapDTO;
import DTO.StaffDTO;
import DTO.Sys;
import TrangQuanLyNhaCC.button_custom;
import TrangQuanLyPhieuNhap.XemPhieuNhap_Frame;

public class TrangQuanLyPhieuKiem_view extends JPanel {
       private DefaultTableModel model;

       private int width_max = 749; // contenPane - Menu = 1000 - 251
       private int height_max = 600;
       private JLabel UserIcon_label;
       private JLabel TenDN_label;
       private JLabel QLPhieuKiem_label;
       private JTextField textField;
       private Color mau_chu = new Color(97, 113, 67);
       private JLabel TimKiem_icon;
       private JScrollPane scrollPane;
       private JTable table;
       private button_custom btn_Xoa;
       private button_custom btn_Xem;
       private JLabel Refresh_icon;
       private int check_open_Jrame = 0;
       private button_custom btn_Sua;

       private ListProductsBUS listProductsBUS;
       private dsPhieuKiemBUS dsPhieuKiemBUS;

       private StaffDTO staff;

       public TrangQuanLyPhieuKiem_view(StaffDTO staff, dsPhieuKiemBUS dsPhieuKiemBUS,
                     ListProductsBUS listProductsBUS) {
              this.listProductsBUS = listProductsBUS;
              this.staff = staff;
              this.dsPhieuKiemBUS = dsPhieuKiemBUS;

              setSize(width_max, height_max);
              setBackground(new Color(246, 225, 195));
              setLayout(null);

              UserIcon_label = new JLabel("", JLabel.CENTER);
              UserIcon_label.setIcon(new ImageIcon("D:\\esclip\\project1\\Do_An_Java\\src\\image_icon\\user.png"));
              UserIcon_label.setBounds(584, 10, 40, 40);
              add(UserIcon_label);

              TenDN_label = new JLabel("TÊN ĐĂNG NHẬP", JLabel.CENTER);
              TenDN_label.setFont(new Font("Tahoma", Font.BOLD, 10));
              TenDN_label.setBounds(618, 10, 121, 30);
              add(TenDN_label);

              QLPhieuKiem_label = new JLabel("QUẢN LÝ PHIẾU KIỂM", SwingConstants.CENTER);
              QLPhieuKiem_label.setForeground(new Color(97, 113, 67));
              QLPhieuKiem_label.setFont(new Font("Tahoma", Font.BOLD, 35));
              QLPhieuKiem_label.setBounds(60, 48, 630, 40);
              add(QLPhieuKiem_label);

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
                                          "ID PHIẾU KIỂM", "MÃ NSX", "NGÀY GỬI", "TÌNH TRẠNG", "PHIẾU YÊU CẦU",
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
              table.setFont(new Font("Tahoma", Font.BOLD, 12));
              table.getTableHeader().setBackground(new Color(32, 136, 203));
              table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
              table.getTableHeader().setForeground(Color.white);
              table.setSelectionBackground(new Color(232, 57, 95));
              table.setRowHeight(22);
              scrollPane.setViewportView(table);

              btn_Xoa = new button_custom("XÓA");
              btn_Xoa.setIcon(new ImageIcon("image_icon\\invoice_delete.png"));
              btn_Xoa.setRadius(10);
              btn_Xoa.setForeground(Color.WHITE);
              btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Xoa.setBorderPainted(false);
              btn_Xoa.setBounds(304, 498, 113, 35);
              add(btn_Xoa);

              btn_Sua = new button_custom("SỬA");
              btn_Sua.setText("NHẬP");
              btn_Sua.setIcon(new ImageIcon("image_icon\\pay.png"));
              btn_Sua.setRadius(10);
              btn_Sua.setForeground(Color.WHITE);
              btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Sua.setBorderPainted(false);
              btn_Sua.setBounds(520, 498, 113, 35);
              add(btn_Sua);

              Refresh_icon = new JLabel("");
              Refresh_icon.setIcon(new ImageIcon("image_icon\\refresh.png"));
              Refresh_icon.setBounds(670, 437, 32, 32);
              add(Refresh_icon);

              btn_Xem = new button_custom("XEM");
              btn_Xem.setIcon(new ImageIcon("image_icon\\invoice.png"));
              btn_Xem.setRadius(10);
              btn_Xem.setForeground(Color.WHITE);
              btn_Xem.setFont(new Font("Tahoma", Font.BOLD, 15));
              btn_Xem.setBorderPainted(false);
              btn_Xem.setBounds(82, 498, 113, 35);
              add(btn_Xem);

              TenDN(staff);
              refresh_table();

              controller_refresh controller_refresh = new controller_refresh(this);
              Refresh_icon.addMouseListener(controller_refresh);
              controller_TimKiemIcon controller_TimKiemIcon = new controller_TimKiemIcon(this);
              TimKiem_icon.addMouseListener(controller_TimKiemIcon);
              controller_ClickTable controller_ClickTable = new controller_ClickTable(this);
              table.addMouseListener(controller_ClickTable);
              controller_btnXem controller_btnXem = new controller_btnXem(this);
              btn_Xem.addMouseListener(controller_btnXem);

              controller_btnNhap controller_btnNhap = new controller_btnNhap(this);
              btn_Sua.addMouseListener(controller_btnNhap);

              controller_btnXoa controller_btnXoa = new controller_btnXoa(this);
              btn_Xoa.addMouseListener(controller_btnXoa);



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

       public ListProductsBUS getListProductsBUS() {
              return listProductsBUS;
       }

       public dsPhieuKiemBUS getDsPhieuKiemBUS() {
              return dsPhieuKiemBUS;
       }

       public ArrayList<PhieuKiemDTO> Load_DSPhieuKiem() {
              ArrayList<PhieuKiemDTO> data = getDataFromDAOBUS.getList_PhieuKiem_fromDATA();
              return data;
       }

       // refresh
       public void refresh_table() {
              model = (DefaultTableModel) table.getModel();
              int number_row = model.getRowCount();
              for (int i = number_row - 1; i >= 0; i--) {
                     model.removeRow(i);
              }
              Load_DSPhieuKiem_from_data_after_change();
       }

       public void Load_DSPhieuKiem_from_data_after_change() {
              ArrayList<PhieuKiemDTO> data = Load_DSPhieuKiem();
              this.dsPhieuKiemBUS.setDsPhieukiem(data);
              // this.dSachNhaCC.setCount(data.size());
              for (PhieuKiemDTO phieukiem : data) {
                     add_data_Table(phieukiem);
              }
       }

       public void add_data_Table(PhieuKiemDTO phieukiem) {
              model = (DefaultTableModel) table.getModel();
              System.out.println(phieukiem.getMaNSX());
              model.addRow(new Object[] {
                            phieukiem.getIDPhieu(), phieukiem.getMaNSX(),
                            phieukiem.getDate(), String.format(Locale.ROOT, phieukiem.getTinh_trang()),
                            phieukiem.getIDPhieuNhap(), phieukiem.getSumMoney()
              });
       }

       public void Xoa_PhieuKiem(String ma) {
		if (ma.equals("") == false) {
			if (this.dsPhieuKiemBUS.Xoa_2(ma)) {
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
			ArrayList<PhieuKiemDTO> list_search = this.dsPhieuKiemBUS.TimkiemtheoKey_2(tukhoa);
			model = (DefaultTableModel) table.getModel();
			int number_row = model.getRowCount();
			for (int i = number_row - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for (PhieuKiemDTO iterable_element : list_search) {
				add_data_Table(iterable_element);
			}
		}
	}
       public void nhapvaokho(String maPhieu){
		if(this.dsPhieuKiemBUS.Capnhatvaokho_2(maPhieu,listProductsBUS)){
			// JOptionPane.showConfirmDialog(null, "NHẬP VÀO KHO THÀNH CÔNG", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Success();
			Sys.Success_dialog("NHẬP VÀO KHO THÀNH CÔNG");
			
		}
		else{
			// JOptionPane.showConfirmDialog(null, "NHẬP VÀO KHO THẤT BẠI", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			Sys.Sound_Error();
			Sys.Error_dialog("NHẬP VÀO KHO THẤY BẠI");
			
		}
	}
       public void XemPhieuKiem_Frame() {
		XemPhieuKiem_Frame xemPhieuNhap_Frame = new XemPhieuKiem_Frame(this);
	}
       public void XoaPhieu_Frame() {
		try {
			String maPhieu = JOptionPane.showInputDialog(null, "Nhập mã cần xóa", "Thông báo", JOptionPane.YES_OPTION);
			Xoa_PhieuKiem(maPhieu);
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
       public PhieuKiemDTO Click_table() {
		try {
			int click = this.table.getSelectedRow();
			PhieuKiemDTO phieuNhap = this.dsPhieuKiemBUS.getDsPhieukiem().get(click);
			return phieuNhap;
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, "HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG", "Thông báo",
			// 			JOptionPane.ERROR_MESSAGE);
			Sys.Sound_Error();
			Sys.Warning_dialog("HÃY CLICK CHỌN MỘT PHIẾU TRONG BẢNG");
			
		}
		return null;

	}



}
