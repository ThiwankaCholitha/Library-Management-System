package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.UserAdmin;
import Controller.AdminController;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin frame = new AddAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddAdmin() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("Add Admin");
		setType(Type.UTILITY);
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
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(677, 509, 21, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(656, 536, 15, 10);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 128));
		panel_3.setBounds(689, 547, 21, 33);
		contentPane.add(panel_3);
		
		JLabel lblAdminId = new JLabel("ADMIN ID :");
		lblAdminId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminId.setBounds(155, 72, 95, 16);
		contentPane.add(lblAdminId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(243, 65, 300, 33);
		contentPane.add(textField);
		
		JLabel lblAdminname = new JLabel("ADMINNAME :");
		lblAdminname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminname.setBounds(137, 153, 95, 16);
		contentPane.add(lblAdminname);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(244, 146, 300, 33);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Email :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(177, 228, 114, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(243, 221, 300, 33);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("PHONE NUMBER :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(106, 315, 114, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(243, 308, 300, 33);
		contentPane.add(textField_3);
		
		Button button = new Button("Add User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAdmin ua = new UserAdmin();
				
				String aID = textField.getText();
				String aName = textField_1.getText();
				String aEmail = textField_2.getText();
				String aPhone = textField_3.getText();
				String password = passwordField.getText();
				
				
				System.out.println(aID);
				
				ua.setUserName(aID);
				System.out.println(aID);
				ua.setUserName(aName);
				ua.setUserEmail(aEmail);
				ua.setMobilenumber(aPhone);
				ua.setAdminPassword(password);
				
				AdminController.addAdmin(ua);
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(94, 503, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(487, 503, 126, 33);
		contentPane.add(button_1);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(106, 397, 114, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 380, 300, 33);
		contentPane.add(passwordField);
	}
}
