package UserInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.SystemColor;

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
		
		Button button = new Button("Return Book");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(119, 282, 126, 33);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(512, 282, 126, 33);
		contentPane.add(button_1);
	}
}
