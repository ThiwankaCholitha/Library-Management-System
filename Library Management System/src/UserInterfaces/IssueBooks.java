package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import Classes.Book;
import Classes.IssueBook;
import Classes.User;
import Controller.AdminController;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class IssueBooks extends JFrame {

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
					IssueBooks frame = new IssueBooks();
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
	public IssueBooks() {
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
		panel.setBounds(0, 0, 740, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(689, 382, 21, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(701, 420, 21, 33);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(668, 409, 15, 10);
		contentPane.add(panel_3);
		
		JLabel label = new JLabel("USER ID :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(167, 133, 95, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(255, 126, 300, 33);
		contentPane.add(textField);
		
		JLabel lblBookIsbn = new JLabel("BOOK ISBN :");
		lblBookIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookIsbn.setBounds(149, 213, 95, 16);
		contentPane.add(lblBookIsbn);
		
		Button button = new Button("Issue Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book issuebook = new Book();
				
				String userid = textField.getText(); 
				String bookISBN = textField_1.getText();
				
				issuebook.setBookISBN(bookISBN);
				
				
				try {
					
					
				boolean c= AdminController.ckISBN(issuebook);	
				
			if(c) {
				IssueBook ib = new IssueBook();
				ib = AdminController.getBookISBN(issuebook);
				ib.setClientId(userid);
				
				if(ib.getNoOfCopies() >0){
				
				boolean b1 = AdminController.insertIntoBook(ib);
				
				if(b1) {
					
					
					AdminController.updateBook(ib);
					JOptionPane.showMessageDialog(null,"Book was Issued");
					textField.setText(null);
					textField_1.setText(null);
				}
				else {
					System.out.println("Book is not issued");
				}
				
				}else{
				JOptionPane.showMessageDialog(null, "This book is not available!");
				}
			}else {JOptionPane.showMessageDialog(null, "Enter a valid ISBN");
				}
		}catch(SQLException e1) {//--Catch if any sql exception occurred
			            
			            if(e1.getErrorCode()==1452) {
			            	JOptionPane.showMessageDialog(null, "Invalid User ID");
			            }
			            else {
			            	e1.printStackTrace();
			            }
			            	
				}
			}
				
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(112, 332, 126, 33);
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
		button_1.setBounds(505, 332, 126, 33);
		contentPane.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(255, 205, 300, 33);
		contentPane.add(textField_1);
		
		Button button_2 = new Button("Check");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User u1 = new User();
				u1.setUserId("IT19206806");
				//AdminController.chkUserHasBook(u1)
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(new Color(0, 0, 128));
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(575, 126, 79, 31);
		contentPane.add(button_2);
		
		ArrayList <String> issuedBooks = new ArrayList<>();
		String bookTitle;
		
	}
}

