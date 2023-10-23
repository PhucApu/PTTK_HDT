package TrangQuanLyHoaDon;



import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ChonVi_Frame extends JFrame{
       private JPanel contentPane;
       private button_custom btn_Thoat;
       private ThemHoaDon_Frame themHoaDon_Frame;
       public ChonVi_Frame(ThemHoaDon_Frame themHoaDon_Frame) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 567, 407);
              this.themHoaDon_Frame = themHoaDon_Frame;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(246,225,195));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel QR_image = new JLabel("");
		QR_image.setIcon(new ImageIcon("image_icon\\frame.png"));
		QR_image.setBounds(118, 23, 307, 251);
		contentPane.add(QR_image);
		
		JLabel lblNewLabel = new JLabel("MOMO",JLabel.CENTER);
		lblNewLabel.setIcon(new ImageIcon("image_icon\\digital-wallet.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel.setBounds(189, 298, 170, 33);
              contentPane.add(lblNewLabel);

              btn_Thoat = new button_custom("Xóa chi tiết");
		btn_Thoat.setText("Thoát");
		btn_Thoat.setRadius(10);
		btn_Thoat.setForeground(Color.WHITE);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBorderPainted(false);
		btn_Thoat.setBounds(409, 325, 121, 35);
              btn_Thoat.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            setVisible(false);
                            dispose();
                            getThemHoaDon_Frame().setVisible(true);
                     }
              });
		contentPane.add(btn_Thoat);

              setVisible(true);
		
	}
       public ThemHoaDon_Frame getThemHoaDon_Frame() {
              return themHoaDon_Frame;
       }

}
