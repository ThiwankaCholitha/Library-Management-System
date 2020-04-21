package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.User;
import Controller.AdminController;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class RemoveUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveUser frame = new RemoveUser();
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
	public RemoveUser() {
		setType(Type.UTILITY);
		setTitle("Remove User");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 403);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 720, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(657, 272, 21, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(669, 310, 21, 33);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(636, 299, 15, 10);
		contentPane.add(panel_3);
		
		Button button = new Button("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewUser viewUser = new ViewUser();
				viewUser.setVisible(true);
				viewUser.setLocationRelativeTo(null);
				viewUser.setResizable(false);
				setVisible(false);
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(65, 252, 180, 40);
		contentPane.add(button);
		
		Button button_1 = new Button("Remove User");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userId = txtUserId.getText();
				
				User removeUser = new User("",userId,"","","");
				
				AdminController.removeUser(removeUser);
				txtUserId.setText(null);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(441, 252, 180, 40);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("USER ID :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(144, 128, 95, 16);
		contentPane.add(label);
		
		txtUserId = new JTextField();
		txtUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserId.setColumns(10);
		txtUserId.setBounds(232, 121, 300, 33);
		contentPane.add(txtUserId);
	}
}
