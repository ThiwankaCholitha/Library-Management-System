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
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 722, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -3, 723, 192);
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/Admin 1.jpg")));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		panel.add(lblNewLabel);
		
		Button button = new Button("Add User");
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
	}

}
