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

import javax.swing.JTable;
import javax.swing.JScrollPane;

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
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 722, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(689, 547, 21, 33);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(677, 509, 21, 25);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(656, 536, 15, 10);
		contentPane.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 59, 700, 447);
		contentPane.add(scrollPane);
		
		table = new JTable();
		 
		DefaultTableModel dtm = new DefaultTableModel(0, 0);

		// add header of the table
		String header[] = new String[] { "User Id", "User Name","Email","Phone","Fine","Book Id"};
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		scrollPane.getViewport().setBackground(Color.WHITE);
		table.getTableHeader().setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		
		
		ArrayList<String[]>users = new ArrayList<>();
		
		for(int i=0; i<users.size(); i++) {
			
			users = AdminController.getUserDetails();
			dtm =(DefaultTableModel) table.getModel();
			dtm.addRow(users.get(i));
		
		}
	}
}
