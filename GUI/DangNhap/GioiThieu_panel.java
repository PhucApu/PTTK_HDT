package DangNhap;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import DTO.*;



public class GioiThieu_panel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel contenPanel;
	private JLabel BackGround_label;
	private JLabel EmailIcon_label;
	private JLabel FacebookIcon_label;
	private JLabel PhoneIcon_label;
	private JLabel EmailName_label;
	private JLabel FaceBooklName_label;
	private JLabel PhoneName_label;
	private JLabel LogoIcon_label;
	private JLabel Welcome_label;

       // di chuyen chu welcome
       private int x_location = 480;
	private int y_location = 37;
	private int x_Move = 1;
	private int y_Move = 1;
	public GioiThieu_panel() {
		setSize(800,450);
		setLayout(null);
		
		contenPanel = new JPanel();
		contenPanel.setBounds(0, 0, 800, 450);
		add(contenPanel);
		contenPanel.setLayout(null);
		
		Welcome_label = new JLabel("");
		Welcome_label.setIcon(new ImageIcon("image_icon\\welcome-back-removebg-preview.png"));
		Welcome_label.setBounds(480, 37, 128, 0);
		contenPanel.add(Welcome_label);
		
		LogoIcon_label = new JLabel("");
		LogoIcon_label.setIcon(new ImageIcon("image_icon\\z4200822300696_1883a507d71843fb2dadab7cc0b1c8d8-removebg-preview (1).png"));
		LogoIcon_label.setBounds(168, 57, 493, 0);
		contenPanel.add(LogoIcon_label);
		
		PhoneName_label = new JLabel("0823072871", SwingConstants.CENTER);
		PhoneName_label.setFont(new Font("MV Boli", Font.BOLD, 15));
		PhoneName_label.setBounds(-300, 411, 135, 32);
		contenPanel.add(PhoneName_label);
		
		FaceBooklName_label = new JLabel("DSTB FASTFOOD", SwingConstants.CENTER);
		FaceBooklName_label.setFont(new Font("MV Boli", Font.BOLD, 15));
		FaceBooklName_label.setBounds(-300, 369, 168, 32);
		contenPanel.add(FaceBooklName_label);
		
		EmailName_label = new JLabel("DSTPFastFood@gmail.com",JLabel.CENTER);
		EmailName_label.setFont(new Font("MV Boli", Font.BOLD, 15));
		EmailName_label.setBounds(-300, 335, 230, 32);
		contenPanel.add(EmailName_label);
		
		PhoneIcon_label = new JLabel("");
		PhoneIcon_label.setIcon(new ImageIcon("image_icon\\telephone-call.png"));
		PhoneIcon_label.setBounds(-300, 411, 32, 32);
		contenPanel.add(PhoneIcon_label);
		
		FacebookIcon_label = new JLabel("");
		FacebookIcon_label.setIcon(new ImageIcon("image_icon\\facebook.png"));
		FacebookIcon_label.setBounds(-300, 369, 32, 32);
		contenPanel.add(FacebookIcon_label);
		
		EmailIcon_label = new JLabel("");
		EmailIcon_label.setIcon(new ImageIcon("image_icon\\gmail.png"));
		EmailIcon_label.setBounds(-300, 335, 32, 32);
		contenPanel.add(EmailIcon_label);
		
		BackGround_label = new JLabel("");
		BackGround_label.setIcon(new ImageIcon("image_icon\\BackGround_.jpg"));
		BackGround_label.setBounds(0, -78, 800, 528);
		contenPanel.add(BackGround_label);
		
	
		// controller_Email_GioiThieu controller_Email_GioiThieu = new controller_Email_GioiThieu(this);
              Move_Email();
		// controller_Facebook_Gioithieu controller_Facebook_Gioithieu = new controller_Facebook_Gioithieu(this);
              Move_Facebook();
		// controller_DT_GioiThieu controller_DT_GioiThieu = new controller_DT_GioiThieu(this);
              Move_Phone();
		// controller_Logo_GioiThieu controller_Logo_GioiThieu = new controller_Logo_GioiThieu(this);
              Move_Logo();
		// controller_Welcome_GioiThieu controller_Welcome_GioiThieu = new controller_Welcome_GioiThieu(this);
              Move_Welcome();
		// controllerMove_Welcome_GioiThieu controllerMove_Welcome_GioiThieu = new controllerMove_Welcome_GioiThieu(this);
              Move_Welcome_2();
	}

       public void Move_Email() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
                                   int x_Icon_last = 29;       // location cu
					Thread.sleep(1000);
					int x_Icon = getEmailIcon_label().getX();
					int x_Name = getEmailName_label().getX();
					
					for (int i = x_Icon; i <= x_Icon_last; i++) {
						try {
							Thread.sleep(2);
						} catch (Exception e) {
							// TODO: handle exception
						}
						getEmailIcon_label().setLocation(i, 335);
						getEmailName_label().setLocation(i + 30, 335);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}

       public void Move_Facebook() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
                                   int x_Icon_last = 29;
					Thread.sleep(2000);
					int x_Icon = getFacebookIcon_label().getX();
					int x_Name = getFaceBooklName_label().getX();
					
					for (int i = x_Icon; i <= x_Icon_last; i++) {
						try {
							Thread.sleep(2);
						} catch (Exception e) {
							// TODO: handle exception
						}
						getFacebookIcon_label().setLocation(i, 372);
						getFaceBooklName_label().setLocation(i + 30, 372);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		}).start();
	}

       public void Move_Phone() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					int x_Icon = getPhoneIcon_label().getX();
					int x_Name = getPhoneName_label().getX();
					
					for (int i = x_Icon; i <= 29; i++) {
						try {
							Thread.sleep(2);
						} catch (Exception e) {
							// TODO: handle exception
						}
						getPhoneIcon_label().setLocation(i, 411);
						getPhoneName_label().setLocation(i + 30, 411);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}

       public void Move_Logo() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
                            int height_label = 371;
				try {
					Thread.sleep(5000);
					for (int i = 0; i < height_label; i++) {
						try {
							Thread.sleep(2);
						} catch (Exception e) {
							// TODO: handle exception
						}
						getLogoIcon_label().setSize(493, i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}).start();
	}

       public void Move_Welcome() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
                            int height_label = 128;
				try {
					Thread.sleep(6000);
					for (int i = 0; i < height_label; i++) {
						try {
							Thread.sleep(2);
						} catch (Exception e) {
							// TODO: handle exception
						}
						getWelcome_label().setSize(128, i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}).start();
	}

       public void Move_Welcome_2() {
              
		new Thread(new Runnable() {
			
			@Override
			public void run() {
                            
				try {
					Thread.sleep(7000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				Timer timer = new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if( y_location == 20) {
							y_Move = y_Move * -1;
						}
						else if( y_location == 60) {
							y_Move = y_Move * -1;
						}
						
						y_location = y_location + y_Move;
						getWelcome_label().setLocation(x_location, y_location);
					}
				});
				timer.start();
				
			}
		}).start();
		
	}
	
	public JLabel getEmailIcon_label() {
		return EmailIcon_label;
	}
	public JLabel getEmailName_label() {
		return EmailName_label;
	}

	public JLabel getFacebookIcon_label() {
		return FacebookIcon_label;
	}

	public void setFacebookIcon_label(JLabel facebookIcon_label) {
		FacebookIcon_label = facebookIcon_label;
	}

	public JLabel getPhoneIcon_label() {
		return PhoneIcon_label;
	}

	public void setPhoneIcon_label(JLabel phoneIcon_label) {
		PhoneIcon_label = phoneIcon_label;
	}

	public JLabel getFaceBooklName_label() {
		return FaceBooklName_label;
	}

	public void setFaceBooklName_label(JLabel faceBooklName_label) {
		FaceBooklName_label = faceBooklName_label;
	}

	public JLabel getPhoneName_label() {
		return PhoneName_label;
	}

	public void setPhoneName_label(JLabel phoneName_label) {
		PhoneName_label = phoneName_label;
	}

	public JLabel getLogoIcon_label() {
		return LogoIcon_label;
	}

	public void setLogoIcon_label(JLabel logoIcon_label) {
		LogoIcon_label = logoIcon_label;
	}

	public JLabel getWelcome_label() {
		return Welcome_label;
	}

	public void setWelcome_label(JLabel welcome_label) {
		Welcome_label = welcome_label;
	}
	
	
}
