package UserInterfaces;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.UserAdmin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Panel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.AdminController;
import java.awt.Window.Type;



public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					
					//Cant maximize the size of the window
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setType(Type.UTILITY);
		setTitle("Login");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 346, 400);
		panel.setBackground(new Color(0, 0, 128));
		panel.setForeground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Getting the user input to variables.
				UserAdmin ua = new UserAdmin();
				ua.setUserName(txtUsername.getText());
				ua.setAdminPassword(txtPassword.getText());
				
				//Declaring a variable as login to retrive the status from 
				boolean login; 
				login = AdminController.chkLogin(ua) ;
				
				UIManager um=new UIManager();
				um.put("OptionPane.background",Color.white);
				um.put("Panel.background",Color.white);
				
				UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
				if(login==true) { 
				
					Admin ad1 = new Admin();
					dispose();
					ad1.setVisible(true);
					ad1.setLocationRelativeTo(null);
					
					
					
					
					JOptionPane.showMessageDialog(null, "Login Sucessful");
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
				}
				
				
			
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setForeground(SystemColor.text);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(391, 258, 253, 39);
		contentPane.add(button);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(391, 68, 251, 32);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(393, 149, 251, 32);
		contentPane.add(txtPassword);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(391, 39, 75, 16);
		contentPane.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(481, 93, 1, 2);
		contentPane.add(separator);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(391, 120, 75, 16);
		contentPane.add(lblPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(681, 350, 21, 33);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(648, 339, 15, 10);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setBounds(669, 312, 21, 25);
		contentPane.add(panel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(433, 179, 1, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/Main.jpg")));
		lblNewLabel.setBounds(-235, -62, 581, 493);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel);
		
		Image(lblNewLabel);
	}
	public void Image(JLabel l1) {
		Thread imageCarousel = new Thread() {
			public void run() {
				ImageIcon s[] = new ImageIcon[3];
				int i=0;
				s[0]=new ImageIcon("G:\\Oxygen Workspace\\Library\\Library Management System\\src\\Images\\lg2.png");
				l1.setBounds(0, -10, 406, 410);
				
				s[1]=new ImageIcon("G:\\Oxygen Workspace\\Library\\Library Management System\\src\\Images\\lg1.png");
				l1.setBounds(0, -10, 406, 410);
		
				s[2]=new ImageIcon("G:\\Oxygen Workspace\\Library\\Library Management System\\src\\Images\\lg3.png");
				l1.setBounds(0, -10, 406, 410);
			
				
				for(;;) {
				try {
					
					l1.setIcon(s[i]);
				
				
					
					
					i++;
					
					
					
					
					if(i == 3) {
					
					
					i = 0;
					}
					
					Thread.sleep(2000); 
				}
				catch(Exception e){
					
				}
			}
		}
				
		};
		imageCarousel.start();
	}
}
