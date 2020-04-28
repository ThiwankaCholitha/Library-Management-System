package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.Window.Type;
import java.awt.Label;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setType(Type.UTILITY);
		setTitle("Admin ");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Add User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser newuser = new AddUser();
				newuser.setVisible(true);
				newuser.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(119, 193, 180, 40);
		contentPane.add(button);
		
		Button button_1 = new Button("View Users");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewUser viewuser = new ViewUser();
				viewuser.setVisible(true);
				viewuser.setLocationRelativeTo(null);
				setVisible(false);
				
				}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(437, 193, 180, 40);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Add Books");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook addbook = new AddBook();
				setVisible(false);
				addbook.setVisible(true);
				addbook.setLocationRelativeTo(null);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(119, 271, 180, 40);
		contentPane.add(button_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(161, 214, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(554, 231, 1, 2);
		contentPane.add(separator_1);
		
		Button button_3 = new Button("View Books");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setBounds(437, 271, 180, 40);
		contentPane.add(button_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(512, 309, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(176, 326, 1, 2);
		contentPane.add(separator_3);
		
		Button button_4 = new Button("Issue Books");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBackground(SystemColor.textHighlight);
		button_4.setBounds(119, 354, 180, 40);
		contentPane.add(button_4);
		
		Button button_5 = new Button("View Issued Books");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_5.setBackground(SystemColor.textHighlight);
		button_5.setBounds(437, 354, 180, 40);
		contentPane.add(button_5);
		
		Button button_6 = new Button("Return Books");
		button_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_6.setBackground(SystemColor.textHighlight);
		button_6.setBounds(119, 438, 180, 40);
		contentPane.add(button_6);
		
		Button button_7 = new Button("Remove User");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_7.setBackground(SystemColor.textHighlight);
		button_7.setBounds(437, 438, 180, 40);
		contentPane.add(button_7);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(192, 392, 1, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(531, 392, 1, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(176, 476, 1, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(531, 476, 1, 2);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(176, 231, 1, 2);
		contentPane.add(separator_8);
		
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
		
		Panel panel = new Panel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 740, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 740, 187);
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/Admin 1.jpg")));
		lblNewLabel.setForeground(new Color(135, 206, 250));
		panel.add(lblNewLabel);
		
		Button button_8 = new Button("Add Admin");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_8.setBackground(SystemColor.textHighlight);
		button_8.setBounds(119, 522, 180, 40);
		contentPane.add(button_8);
		
		Button button_9 = new Button("Log Out");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login1 = new Login();
				setVisible(false);
				login1.setVisible(true);
				login1.setLocationRelativeTo(null);
				//Cant maximize the size of the window
				
//				login1.setResizable(false);
//				setVisible(false);
				
			
			}
		});
		button_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_9.setBackground(SystemColor.textHighlight);
		button_9.setBounds(437, 522, 180, 40);
		contentPane.add(button_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 255));
		panel_4.setBounds(0, 189, 740, 430);
		contentPane.add(panel_4);
		
	}
}

