package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Scrollbar;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.SystemColor;

public class AddUser extends JFrame {

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
					AddUser frame = new AddUser();
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
	public AddUser() {
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
		panel.setBounds(0, 0, 722, 43);
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
		
		textField = new JTextField();
		textField.setBounds(221, 75, 300, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(221, 155, 300, 33);
		contentPane.add(textField_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(309, 98, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(370, 186, 1, 2);
		contentPane.add(separator_1);
		
		Choice choice = new Choice();
		choice.setBounds(221, 246, 300, 116);
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(221, 315, 300, 22);
		contentPane.add(choice_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(221, 390, 300, 33);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(221, 470, 300, 33);
		contentPane.add(textField_3);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(114, 82, 95, 16);
		contentPane.add(lblUsername);
		
		JLabel lblUserId = new JLabel("USER ID :");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(133, 162, 95, 16);
		contentPane.add(lblUserId);
		
		JLabel lblFaculty = new JLabel("FACULTY :");
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaculty.setBounds(133, 252, 95, 16);
		contentPane.add(lblFaculty);
		
		JLabel lblYear = new JLabel("YEAR :");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(155, 315, 95, 16);
		contentPane.add(lblYear);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(84, 397, 114, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(155, 477, 114, 16);
		contentPane.add(lblEmail);
		
		Button button = new Button("Add User");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(155, 536, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(457, 536, 126, 33);
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
	}
}
