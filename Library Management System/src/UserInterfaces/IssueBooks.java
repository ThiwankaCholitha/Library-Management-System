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
		setBounds(100, 100, 740, 640);
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
		panel_1.setBounds(677, 509, 21, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(689, 547, 21, 33);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(656, 536, 15, 10);
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
		
		JLabel label_1 = new JLabel("BOOK TITLE :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(149, 213, 95, 16);
		contentPane.add(label_1);
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setEditable(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(254, 211, 300, 33);
		contentPane.add(comboBox);
		
		Button button = new Button("Issue Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book issuebook = new Book();
				
				String userid = textField.getText(); 
				String bookName = comboBox.getSelectedItem().toString();
			
				issuebook.setBooktitle(bookName);
				
				
				try {
				IssueBook ib = new IssueBook();
				ib = AdminController.getBookISBN(issuebook);
				ib.setClientId(userid);
				
				if(ib.getNoOfCopies() >0){
				
				boolean b1 = AdminController.insertIntoBook(ib);
				
				if(b1) {
					
					
					AdminController.updateBook(ib);
					JOptionPane.showMessageDialog(null,ib.getBookTitle()+" was Issued");
				}
				else {
					System.out.println("Book is not issued");
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "This book is not available!");
			}
		}
				catch(SQLException e1) {//--Catch if any sql exception occurred
			            
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
		button.setBounds(119, 494, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(512, 494, 126, 33);
		contentPane.add(button_1);
		
		ArrayList <String> issuedBooks = new ArrayList<>();
		String bookTitle;
		
		issuedBooks = AdminController.getBookList();
		for(int i=0; i<issuedBooks.size(); i++) {
			comboBox.addItem(issuedBooks.get(i));
			
		}
	

		}
	}

