package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.User;
import Controller.AdminController;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView();
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
	public UserView() {
		setType(Type.UTILITY);
		setTitle("View User");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(260, 118, 300, 33);
		contentPane.add(textField);
		
		JLabel label = new JLabel("USER ID :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(172, 125, 95, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("USERNAME :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(154, 206, 95, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(261, 199, 300, 33);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Email :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(194, 289, 114, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(260, 282, 300, 33);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("PHONE NUMBER :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(123, 368, 114, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(260, 361, 300, 33);
		contentPane.add(textField_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(677, 509, 21, 25);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(689, 547, 21, 33);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(656, 536, 15, 10);
		contentPane.add(panel_2);
		
		Button button = new Button("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin();
				admin.setVisible(true);
				admin.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(469, 547, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Get Details");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String userId = textField.getText();
				User userdetails = new User();
				
				userdetails.setUserId(userId);
				
				boolean c = AdminController.checkUser(userdetails);
			
				
				if(c){
				userdetails = AdminController.getUserDetails(userdetails);
				
				textField_1.setText(userdetails.getUserName());
				textField.setEnabled(false);
				textField.setDisabledTextColor(Color.black);
				textField_2.setText(userdetails.getUserEmail());
				textField_3.setText(userdetails.getMobilenumber());
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Invalid User Id!");
					textField.setText(null);
				}
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(123, 484, 126, 33);
		contentPane.add(button_1);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(0, 0, 128));
		panel_3.setBounds(0, 0, 722, 43);
		contentPane.add(panel_3);
		
		Button button_2 = new Button("Update User");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userId = textField.getText();
				String userName = textField_1.getText();
				String userEmail = textField_2.getText();
				String userMobile = textField_3.getText();
				
				User adduser = new User();
				adduser.setUserId(userId);
				adduser.setUserName(userName);
				adduser.setUserEmail(userEmail);
				adduser.setMobilenumber(userMobile);
				
				AdminController.updateUserDetails(adduser);
				JOptionPane.showMessageDialog(null, "User Details Sucessfully Updated");
				
				textField.setText(null);
				textField.setEnabled(true);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				
			
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(123, 547, 126, 33);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Delete User");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setBounds(469, 484, 126, 33);
		contentPane.add(button_3);
	}
}
