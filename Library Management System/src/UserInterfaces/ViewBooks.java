package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ViewBooks extends JFrame {
	String type = null;
	String number = null;
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
		
		
		comboBox_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				type = comboBox_1.getSelectedItem().toString();
				test(comboBox,type);
				;
				
			}
		});
		
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == e.SELECTED) {
				System.out.println(e.getItem());
				}
				type = comboBox_1.getSelectedItem().toString();
				test(comboBox,type);
			}
		});
		
		
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setEditable(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(591, 77, 119, 33);
		contentPane.add(comboBox);
		
		
	
	test(comboBox,type);
	}
	

private void test(JComboBox cb, String type) {
	//System.out.println();
	cb.removeAllItems();
		int n1 = AdminController.numberOFpages(type);
		
		
		if((n1%2) == 1) {
			n1+=1;
		}
		
		
		
		
	 n1 = n1/2;
	 //System.out.println(n1);
		for(int i=1; i<=n1;i++){
			
			cb.addItem(i);
	}
	
	}

}

