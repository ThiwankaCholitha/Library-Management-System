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
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 0, 722, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -3, 723, 192);
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/Admin 1.jpg")));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		panel.add(lblNewLabel);
		
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
		button.setBounds(118, 257, 180, 40);
		contentPane.add(button);
		
		Button button_1 = new Button("View Users");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(436, 257, 180, 40);
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
		button_2.setBounds(118, 335, 180, 40);
		contentPane.add(button_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(160, 278, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(553, 295, 1, 2);
		contentPane.add(separator_1);
		
		Button button_3 = new Button("View Books");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setBounds(436, 335, 180, 40);
		contentPane.add(button_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(511, 373, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(175, 390, 1, 2);
		contentPane.add(separator_3);
		
		Button button_4 = new Button("Issue Books");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBackground(SystemColor.textHighlight);
		button_4.setBounds(118, 418, 180, 40);
		contentPane.add(button_4);
		
		Button button_5 = new Button("View Issued Books");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_5.setBackground(SystemColor.textHighlight);
		button_5.setBounds(436, 418, 180, 40);
		contentPane.add(button_5);
		
		Button button_6 = new Button("Return Books");
		button_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_6.setBackground(SystemColor.textHighlight);
		button_6.setBounds(118, 502, 180, 40);
		contentPane.add(button_6);
		
		Button button_7 = new Button("Remove User");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_7.setBackground(SystemColor.textHighlight);
		button_7.setBounds(436, 502, 180, 40);
		contentPane.add(button_7);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(191, 456, 1, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(530, 456, 1, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(175, 540, 1, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(530, 540, 1, 2);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(175, 295, 1, 2);
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
	}
}
