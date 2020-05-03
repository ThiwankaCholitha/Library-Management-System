package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import Controller.AdminController;
import javafx.scene.text.Font;

import java.awt.Color;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ViewUser extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUser frame = new ViewUser();
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
	public ViewUser() {
		setType(Type.UTILITY);
		setTitle("View User");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 640 );
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 746, 43);
		panel.setBackground(new Color(0, 0, 128));
		contentPane.add(panel);
		
		TextField textField = new TextField();
		textField.setBounds(56, 71, 204, 33);
		textField.setForeground(Color.BLACK);
		textField.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
		contentPane.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(689, 547, 21, 33);
		panel_1.setBackground(new Color(0, 0, 128));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(677, 509, 21, 25);
		panel_2.setBackground(new Color(30, 144, 255));
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(656, 536, 15, 10);
		panel_3.setBackground(Color.BLUE);
		contentPane.add(panel_3);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 131, 698, 361);
		contentPane.add(scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		
		//------------------------------------------Creation of the Jtable ------------------------------------------------------------------------
		table = new JTable();
	
		
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
		String header[] = new String[] { "UserId", "User Name", "Email",
		      "Phone","User Type" };
	
		// add header to the table model     
		 dtm.setColumnIdentifiers(header);
		    table.setModel(dtm);
		    
		    table.setEnabled(false);
		    
		 //Setting the colums accoring to the neeeded size.
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    
		    Button button = new Button("Back");
		    button.setBounds(80, 494, 180, 40);
		    button.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
		    button.setBackground(SystemColor.textHighlight);
		    button.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		setVisible(false);
		    		Admin admin = new Admin();
		    		admin.setVisible(true);
		    		admin.setLocationRelativeTo(null);
		    		admin.setResizable(false);
		    		
		    	}
		    });
		    contentPane.add(button);
		    
		    Button button_1 = new Button("Remove User");
		    button_1.setBounds(456, 494, 180, 40);
		    button_1.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		RemoveUser removeUser = new RemoveUser();
		    		removeUser.setLocationRelativeTo(null);
		    		removeUser.setVisible(true);
		    		setVisible(false);
		    	}
		    });
		    button_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
		    button_1.setBackground(SystemColor.textHighlight);
		    contentPane.add(button_1);
		    
		    JPanel panel_4 = new JPanel();
		    panel_4.setBackground(Color.WHITE);
		    panel_4.setBounds(-11, 49, 80, 69);
		    contentPane.add(panel_4);
		    panel_4.setLayout(null);
		    
		    JLabel lblNewLabel = new JLabel("New label");
		    lblNewLabel.setForeground(Color.WHITE);
		    lblNewLabel.setBounds(12, 13, 112, 49);
		    lblNewLabel.setIcon(new ImageIcon(ViewUser.class.getResource("/Images/search (2).png")));
		    panel_4.add(lblNewLabel);
		    table.getColumnModel().getColumn(0).setPreferredWidth(120);
		    table.getColumnModel().getColumn(1).setPreferredWidth(180);
		    table.getColumnModel().getColumn(2).setPreferredWidth(160);
		    table.getColumnModel().getColumn(3).setPreferredWidth(162);
		 
		    
	
//-------------------------------Calling the AdminController.getUserdetails() to an Array List--------------------------------------------------------
		    
		    //Creating the Array List Which has a String[]
		   ArrayList<String[]> user = null;
	
		   //Calling the method
		    user = AdminController.getUserList();
		    
		    //iterating via a loop to get the last data row of the data table.
		    for(int i=0; i<user.size(); i++) {
		    	dtm.addRow(user.get(i));

		    }
	
	}
}

