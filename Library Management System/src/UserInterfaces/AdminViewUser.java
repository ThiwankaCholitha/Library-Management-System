package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AdminController;

import java.awt.Color;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import javax.swing.JButton;
import javax.swing.JTable;

public class AdminViewUser extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewUser frame = new AdminViewUser();
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
	public AdminViewUser() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 10, 722, 43);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(689, 547, 21, 33);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setBounds(677, 509, 21, 25);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(656, 536, 15, 10);
		panel.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 698, 354);
		panel.add(scrollPane);
	
		
		table = new JTable();
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		scrollPane.setBorder( null );
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		//table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(Color.white);


		
		
		
		
		
		
		

		 DefaultTableModel dtm = new DefaultTableModel(0, 0);
		 
	

		// add header of the table
		String header[] = new String[] { "UserId", "User Name", "Email",
		      "Phone","User Type" };
		
		
		 dtm.setColumnIdentifiers(header);
		    table.setModel(dtm);
		    
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			 table.getColumnModel().getColumn(0).setPreferredWidth(120);
			 table.getColumnModel().getColumn(1).setPreferredWidth(180);
			 table.getColumnModel().getColumn(2).setPreferredWidth(160);
			 table.getColumnModel().getColumn(3).setPreferredWidth(160);
			
		    
		    ArrayList<String[]> user = null;
			
			
			user = AdminController.getUserList();
		
			for(int i=0; i<user.size(); i++) {
			dtm.addRow(user.get(i));
	
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
