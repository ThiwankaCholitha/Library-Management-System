package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Classes.Book;
import Controller.AdminController;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtBookTitle;
	private JTextField author;
	private JTextField noOfCopies;
	private JTextField coppies;

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
		setTitle("Add Book");
		setType(Type.UTILITY);
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
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(258, 61, 300, 33);
		contentPane.add(txtIsbn);
		
		JComboBox txtBookType = new JComboBox();
		txtBookType.setForeground(Color.BLACK);
		txtBookType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBookType.setEditable(true);
		txtBookType.setBackground(Color.WHITE);
		txtBookType.setBounds(258, 210, 300, 33);
		contentPane.add(txtBookType);
		txtBookType.addItem("I.T");
		txtBookType.addItem("B.S");
		txtBookType.addItem("E.N");
		
		
		JLabel lblBookType = new JLabel("BOOK TYPE :");
		lblBookType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookType.setBounds(152, 216, 95, 16);
		contentPane.add(lblBookType);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(191, 68, 95, 16);
		contentPane.add(lblIsbn);
		
		txtBookTitle = new JTextField();
		txtBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBookTitle.setColumns(10);
		txtBookTitle.setBounds(258, 133, 300, 33);
		contentPane.add(txtBookTitle);
		
		JLabel lblBookTitle = new JLabel("BOOK TITLE :");
		lblBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookTitle.setBounds(152, 140, 95, 16);
		contentPane.add(lblBookTitle);
		
		Button button = new Button("Add Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bookISBN = txtIsbn.getText();
				String bookName = txtBookTitle.getText();
				String booktype = txtBookType.getSelectedItem().toString();	
				String bookAuthor =author.getText();
				int copies = Integer.parseInt(noOfCopies.getText());
				
				
				Book addbook = new Book(bookISBN,bookName,booktype,bookAuthor,copies);
				AdminController.addBook(addbook);
				
				UIManager um=new UIManager();
				um.put("OptionPane.background",Color.white);
				um.put("Panel.background",Color.white);
				UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
				
				
				JOptionPane.showMessageDialog(null, "Book Sucessfully added");
				txtIsbn.setText(null);
				txtBookTitle.setText(null);
				author.setText(null);
				noOfCopies.setText(null);
				
				
				}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(118, 470, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin admin = new Admin();
				admin.setLocationRelativeTo(null);
				admin.setVisible(true);
				//admin.setResizable(false);
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(525, 470, 126, 33);
		contentPane.add(button_1);
		
		JLabel lblBookAuthor = new JLabel("BOOK AUTHOR :");
		lblBookAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookAuthor.setBounds(132, 291, 115, 25);
		contentPane.add(lblBookAuthor);
		
		author = new JTextField();
		author.setFont(new Font("Tahoma", Font.PLAIN, 14));
		author.setColumns(10);
		author.setBounds(258, 287, 300, 33);
		contentPane.add(author);
		
		JLabel lblNumberOfCopies = new JLabel("NUMBER OF COPIES :");
		lblNumberOfCopies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfCopies.setBounds(99, 361, 141, 25);
		contentPane.add(lblNumberOfCopies);
		
		noOfCopies = new JTextField();
		noOfCopies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noOfCopies.setColumns(10);
		noOfCopies.setBounds(258, 357, 173, 33);
		contentPane.add(noOfCopies);
		
		Button button_2 = new Button("ISBN Check");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = txtIsbn.getText();
				
				Book bk = new Book();
				bk.setBookISBN(ISBN);
				
				//AdminController.checkISBN(bk);
				Boolean c = AdminController.ckISBN(bk);
				System.out.println(bk);
				
				if(c == true) {
					JOptionPane.showMessageDialog(null, "This book is available.Update the quantity");
					
					
					txtIsbn.setEnabled(false);
					txtIsbn.setDisabledTextColor(Color.black);
					txtBookTitle.setText(bk.getBooktitle());
					txtBookType.setSelectedItem(bk.getBookType());
					txtBookType.setEnabled(false);
					author.setText(bk.getAuthor());
					noOfCopies.setText(Integer.toString(bk.getNoOfCopies()));
					noOfCopies.setEnabled(false);
					noOfCopies.setDisabledTextColor(Color.BLACK);
					
					
				}else {
					JOptionPane.showMessageDialog(null, "This book is not available. Add the book Details");
					txtIsbn.setText(null);
					coppies.setEnabled(false);
				
				}
				
			}
		});
		button_2.setBackground(new Color(0, 0, 128));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(583, 61, 88, 33);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Update Book");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ISBN = txtIsbn.getText();
				String bookTitle = txtBookTitle.getText();
				String bookType = txtBookType.getSelectedItem().toString(); 
				String authorname = author.getText();
				int noOfcpy = Integer.parseInt(noOfCopies.getText());
				int addCpy = Integer.parseInt(coppies.getText());
				
				int totalCoppies = noOfcpy+addCpy;
				
				Book bk = new Book(ISBN,bookTitle,bookType,authorname,totalCoppies);
				
				AdminController.updatebook2(bk);
				
				
				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setBounds(320, 470, 126, 33);
		contentPane.add(button_3);
		
		JLabel lblAddCoppies = new JLabel("ADD COPPIES:");
		lblAddCoppies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddCoppies.setBounds(145, 424, 141, 25);
		contentPane.add(lblAddCoppies);
		
		coppies = new JTextField();
		coppies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		coppies.setColumns(10);
		coppies.setBounds(258, 420, 173, 33);
		contentPane.add(coppies);
		coppies.setText("0");
	}
}
