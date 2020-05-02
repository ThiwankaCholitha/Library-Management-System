package UserInterfaces;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.User;
import Controller.AdminController;
import javafx.scene.control.ComboBox;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Scrollbar;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Window.Type;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField textUid;
	private JTextField textUname;
	private JTextField textPhone;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
					frame.setVisible(true);
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
	public AddUser() {
		setType(Type.UTILITY);
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 640);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 740, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(689, 547, 21, 33);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(656, 536, 15, 10);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setBounds(677, 509, 21, 25);
		contentPane.add(panel_3);
		
		textUid = new JTextField();
		textUid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textUid.setBounds(261, 75, 300, 33);
		contentPane.add(textUid);
		textUid.setColumns(10);
		
		textUname = new JTextField();
		textUname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textUname.setColumns(10);
		textUname.setBounds(262, 156, 300, 33);
		contentPane.add(textUname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(309, 98, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(370, 186, 1, 2);
		contentPane.add(separator_1);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPhone.setColumns(10);
		textPhone.setBounds(261, 318, 300, 33);
		contentPane.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(261, 231, 300, 33);
		contentPane.add(textEmail);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(155, 163, 95, 16);
		contentPane.add(lblUsername);
		
		JLabel lblUserId = new JLabel("USER ID :");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(173, 82, 95, 16);
		contentPane.add(lblUserId);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(124, 325, 114, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(195, 238, 114, 16);
		contentPane.add(lblEmail);
		
		JComboBox userType = new JComboBox();
		userType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userType.setForeground(Color.BLACK);
		userType.setBackground(Color.WHITE);
		userType.setBounds(261, 401, 300, 33);
		contentPane.add(userType);
		
		userType.addItem("Student");
		userType.addItem("Staff");
		
		
		Button button = new Button("Add User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Getting the eneterd information from the admin
				String uId = textUid.getText().toUpperCase();
				
				String uName = textUname.getText();
				String uEmail = textEmail.getText();
				String uMobile = textPhone.getText();
				String utype = userType.getSelectedItem().toString();
				
				String usrIdCheck = uId.substring(0, 2);
				System.out.println(usrIdCheck);
				
				if(uId.length()==10 &&(usrIdCheck.equals("IT")||usrIdCheck.equals("EN") || usrIdCheck.equals("BS"))) {
				
				//Creating the user type object with overloaded constructor
				User newUser = new User(uId,uName,uEmail,uMobile,utype);
				AdminController.addUser(newUser);
				JOptionPane.showMessageDialog(null, "User Sucessfully added ");
				
				//setting the user details to null
				textUid.setText(null);
				textUname.setText(null);
				textEmail.setText(null);
				textPhone.setText(null);
				}
			
			else {
				JOptionPane.showMessageDialog(null, "Enter a valid Reg number");
				textUid.setText(null);
			}
			}
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(112, 513, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Admin admin = new Admin();
			admin.setLocationRelativeTo(null);
			admin.setVisible(true);
			dispose();
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(505, 513, 126, 33);
		contentPane.add(button_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(339, 106, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(339, 186, 1, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(309, 266, 1, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(370, 335, 1, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(266, 421, 1, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(339, 501, 1, 2);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(210, 567, 1, 2);
		contentPane.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(540, 567, 1, 2);
		contentPane.add(separator_9);
		
		JLabel lblUserType = new JLabel("USER TYPE :");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserType.setBounds(155, 407, 95, 16);
		contentPane.add(lblUserType);
		
		
		
		
		
		
		
		
	}
}
