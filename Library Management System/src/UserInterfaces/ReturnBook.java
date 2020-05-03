package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


import Classes.BookReturn;
import Classes.User;
import Controller.AdminController;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setTitle("Return Book");
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 722, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(677, 378, 21, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(689, 416, 21, 33);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(656, 405, 15, 10);
		contentPane.add(panel_3);
		
		JLabel label = new JLabel("USER ID :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(159, 111, 95, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(247, 104, 300, 33);
		contentPane.add(textField);
		
		JLabel lblBookTitle = new JLabel("BOOK TITLE :");
		lblBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookTitle.setBounds(135, 186, 95, 16);
		contentPane.add(lblBookTitle);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(247, 178, 300, 33);
		contentPane.add(textField_1);
		textField_1.enable(false);
		textField_1.setDisabledTextColor(Color.BLACK);
		
		
		Button button = new Button("Return Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user = new User();
				BookReturn rb = new BookReturn();
				
				user.setUserId(textField.getText());
				
				boolean c = AdminController.checkUser(user);
				
				UIManager um=new UIManager();
				
				 um.put("OptionPane.background",Color.white);
				 um.put("Panel.background",Color.white);
				 UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
				 
				
				
				
				if(c){
					
					rb= AdminController.returnBookTitleAndDate(user);
					
					textField_1.setText(rb.getBookTitle());
					
				
					
					if(rb.getDateDifference()>0) {
						
						
						int fine = 0;
						fine = rb.getDateDifference() * 100;
						JOptionPane.showMessageDialog(null, "You have to pay a fine of Rs: "+fine
								+"\nBook Returning date delayed by: "+rb.getDateDifference());
						
					}
					else {
					AdminController.updateReturnBook(rb);
					AdminController.updateIssuedStatus(user);
					JOptionPane.showMessageDialog(null, "Book Returned Sucessfully!");
					textField.setText(null);
					
					}
				}
				else {
//						UIManager um=new UIManager();
//						um.put("OptionPane.background",Color.white);
//						um.put("Panel.background",Color.white);
						UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
						JOptionPane.showMessageDialog(null, "User Does not exsist");
						textField.setText(null);
				}
				
			
		
				
				
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(119, 282, 126, 33);
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
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(512, 282, 126, 33);
		contentPane.add(button_1);
	}
}
