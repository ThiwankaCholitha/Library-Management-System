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
import java.text.SimpleDateFormat;
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
					
					
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin(){
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(161, 214, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(554, 231, 1, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(512, 309, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(176, 326, 1, 2);
		contentPane.add(separator_3);
		
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
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 740, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 118, 125, 16);
		panel.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 255));
		panel_4.setBounds(0, 189, 740, 430);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		Button button_8 = new Button("Add Admin");
		button_8.setBounds(437, 199, 180, 40);
		button_8.setForeground(Color.WHITE);
		panel_4.add(button_8);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_8.setBackground(SystemColor.textHighlight);
		
		Button button_9 = new Button("Log Out");
		button_9.setBounds(437, 286, 180, 40);
		button_9.setForeground(Color.WHITE);
		panel_4.add(button_9);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login1 = new Login();
				login1.setVisible(true);
				login1.setLocationRelativeTo(null);
				login1.setResizable(false);
				dispose();
				
			
			}
		});
		button_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_9.setBackground(SystemColor.textHighlight);
		
		Button button_6 = new Button("Return Books");
		button_6.setForeground(Color.WHITE);
		button_6.setBounds(118, 286, 180, 40);
		panel_4.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook returnbook = new ReturnBook();
				returnbook.setLocationRelativeTo(null);
				returnbook.setVisible(true);
				dispose();
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_6.setBackground(SystemColor.textHighlight);
		
		Button button_4 = new Button("Issue Books");
		button_4.setForeground(Color.WHITE);
		button_4.setBounds(118, 199, 180, 40);
		panel_4.add(button_4);
		button_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				IssueBooks issuebook = new IssueBooks();
				issuebook.setLocationRelativeTo(null);
				issuebook.setVisible(true);
				issuebook.setResizable(false);
				dispose();
				
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBackground(SystemColor.textHighlight);
		
		Button button_2 = new Button("Add Books");
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(118, 112, 180, 40);
		panel_4.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook addbook = new AddBook();
				addbook.setLocationRelativeTo(null);
				addbook.setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(SystemColor.textHighlight);
		
		Button button_3 = new Button("View Books");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks vb = new ViewBooks();
				vb.setVisible(true);
				vb.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setBounds(437, 112, 180, 40);
		panel_4.add(button_3);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBackground(SystemColor.textHighlight);
		
		Button button_1 = new Button("View / Update Users");
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(437, 30, 180, 40);
		panel_4.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView viewuser = new UserView();
				viewuser.setVisible(true);
				viewuser.setLocationRelativeTo(null);
				dispose();
				
				
				}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(SystemColor.textHighlight);
		
		Button button = new Button("Add User");
		button.setForeground(Color.WHITE);
		button.setBounds(118, 30, 180, 40);
		panel_4.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddUser newuser = new AddUser();
				newuser.setLocationRelativeTo(null);
				newuser.setVisible(true);
			
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(SystemColor.textHighlight);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(12, 158, 155, 16);
		panel.add(label);
		
		dateTime(lblNewLabel_1,label);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 763, 187);
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/Admin 1.jpg")));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
	}
	


	public void dateTime(JLabel l1,JLabel l2) {
		
		SimpleDateFormat simpledateformat1 = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat simpledateformat2 = new SimpleDateFormat("YYYY-MM-dd");
		Thread dateTime = new Thread() {
			public void run() {
				for(;;) {
				try {
					Calendar cal = new GregorianCalendar();
					
					
					
					l1.setText("Time: "+simpledateformat1.format(cal.getTime()));
					l2.setText("Date: "+simpledateformat2.format(cal.getTime()));
					Thread.sleep(1000);
					 
				}
				catch(Exception e){
					
				}
			}
		}
				
		};
		dateTime.start();
	}
}

