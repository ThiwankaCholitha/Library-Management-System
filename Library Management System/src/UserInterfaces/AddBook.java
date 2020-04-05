package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Book;
import Controller.AdminController;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookId;
	private JTextField txtIsbn;
	private JTextField txtBookTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
					frame.setVisible(true);
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
	public AddBook() {
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
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 722, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(656, 536, 15, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(677, 509, 21, 25);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 128));
		panel_3.setBounds(689, 547, 21, 33);
		contentPane.add(panel_3);
		
		txtBookId = new JTextField();
		txtBookId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBookId.setColumns(10);
		txtBookId.setBounds(255, 119, 300, 33);
		contentPane.add(txtBookId);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(256, 200, 300, 33);
		contentPane.add(txtIsbn);
		
		JComboBox txtBookType = new JComboBox();
		txtBookType.setForeground(Color.BLACK);
		txtBookType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBookType.setEditable(true);
		txtBookType.setBackground(Color.WHITE);
		txtBookType.setBounds(255, 367, 300, 33);
		contentPane.add(txtBookType);
		txtBookType.addItem("I.T");
		txtBookType.addItem("B.S");
		txtBookType.addItem("E.N");
		
		
		JLabel lblBookType = new JLabel("BOOK TYPE :");
		lblBookType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookType.setBounds(149, 373, 95, 16);
		contentPane.add(lblBookType);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(189, 207, 95, 16);
		contentPane.add(lblIsbn);
		
		JLabel lblBookId = new JLabel("BOOK ID :");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookId.setBounds(167, 126, 95, 16);
		contentPane.add(lblBookId);
		
		txtBookTitle = new JTextField();
		txtBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBookTitle.setColumns(10);
		txtBookTitle.setBounds(255, 286, 300, 33);
		contentPane.add(txtBookTitle);
		
		JLabel lblBookTitle = new JLabel("BOOK TITLE :");
		lblBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookTitle.setBounds(149, 293, 95, 16);
		contentPane.add(lblBookTitle);
		
		Button button = new Button("Add Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookId = txtBookId.getText();
				String bookISBN = txtIsbn.getText();
				String bookName = txtBookTitle.getText();
				String booktype = txtBookType.getSelectedItem().toString();	
				
				Book addbook = new Book(bookId,bookISBN,bookName,booktype);
				
				AdminController.addBook(addbook);
				
				
				txtBookId.setText(null);
				txtIsbn.setText(null);
				txtBookTitle.setText(null);
				JOptionPane.showMessageDialog(null, "Book Sucessfully added");
				
				
				}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(133, 477, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				Admin admin = new Admin();
				admin.setVisible(true);
				admin.setLocationRelativeTo(null);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(526, 477, 126, 33);
		contentPane.add(button_1);
	}
}
