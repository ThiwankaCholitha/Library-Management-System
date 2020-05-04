package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AdminController;
import javafx.scene.control.ComboBox;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ViewBooks extends JFrame {
	String type = null;
	int number;
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooks frame = new ViewBooks();
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
	public ViewBooks() {
		setTitle("View Books");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 640);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 196, 698, 280);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//Setting the scrollpane to the table.
				scrollPane.setViewportView(table);
				
				//Setting the table properties.
				table.getTableHeader().setResizingAllowed(false);
				table.getTableHeader().setReorderingAllowed(false);
				table.setBackground(Color.white);
				table.getTableHeader().setBackground(Color.white);
				table.getTableHeader().setBackground(Color.decode("#87cefa"));
				
				
				//Creating the default table model to put data.
				 DefaultTableModel dtm = new DefaultTableModel(0, 0);
			

				// adding header of the table
				String header[] = new String[] { "ISBN", "Book Title","Author", "Book Type","No Of Coppies","All Books"};
			
				// add header to the table model     
				 dtm.setColumnIdentifiers(header);
				    table.setModel(dtm);
				    table.setEnabled(false);
				    table.getColumnModel().getColumn(0).setPreferredWidth(120);
				    table.getColumnModel().getColumn(1).setPreferredWidth(200);
				    table.getColumnModel().getColumn(2).setPreferredWidth(120);
				    table.getColumnModel().getColumn(3).setPreferredWidth(70);
				    table.getColumnModel().getColumn(4).setPreferredWidth(100);
				  
				    
		
		JLabel label = new JLabel("BOOK TYPE :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(24, 83, 95, 16);
		contentPane.add(label);
		
		
		JComboBox comboBox_1 = new JComboBox();
		
		
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setEditable(true);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(130, 77, 119, 33);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("I.T");
		type = "I.T";
		comboBox_1.addItem("B.S");
		comboBox_1.addItem("E.N");
		
		
	
		
		JLabel lblPage = new JLabel("PAGE :");
		lblPage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPage.setBounds(527, 83, 95, 16);
		contentPane.add(lblPage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == e.SELECTED) {
					
					number = (int) e.getItem();
					System.out.println(number);
					addDataToTable(type,number,dtm);
					
				}
			}
		});
	

	
		
		
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == e.SELECTED) {
					type = e.getItem().toString();
					test(comboBox,type);
					
					addDataToTable(type,number,dtm);
				}
				
			}
		});
		
		
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setEditable(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(591, 77, 119, 33);
		contentPane.add(comboBox);
		
		
	
	 test(comboBox,type);
	 addDataToTable(type,number,dtm);
	}
	

	private void test(JComboBox cb, String type) {
	System.out.println(type);
	
	cb.removeAllItems();
		int n1 = AdminController.numberOFpages(type);
		
		
		if((n1%3) > 0) {
			n1+=1;
		}
		
		
		
		
	 n1 = n1/2;
	 //System.out.println(n1);
		for(int i=1; i<=n1;i++){
			
			cb.addItem(i);
	}
		//number eka add krgnna
	
	}
	
	private void addDataToTable(String type,int number, DefaultTableModel dt) {
		
		ArrayList<String[]> books = null;
		
		
	
		int num;
		
			 num =(number-1)*3;
			//System.out.println(num);
			
			//Calling the method
			    books = AdminController.getBookDetails(num, type);
			    dt.setRowCount(0);
			    //iterating via a loop to get the last data row of the data table.
			    for(int r=0; r<books.size(); r++) {
			    	
			    	dt.addRow(books.get(r));
			    }

			}
}

