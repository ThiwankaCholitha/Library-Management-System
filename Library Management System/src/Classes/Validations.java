package Classes;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Validations {

	public static void validateName(JTextField textFild) {
		String txt = textFild.getText();
		int caretPosition = textFild.getCaretPosition();
		if (!txt.isEmpty()) {
			if (!txt.matches("^[a-zA-Z ]+?$")) {
				txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
				textFild.setText(txt);
				textFild.setCaretPosition(caretPosition - 1);
			}

			if (txt.matches("^[a-zA-Z ]+?$")) {

				textFild.setBackground(Color.WHITE);
				textFild.setForeground(Color.black);
			} else {

				textFild.setBackground(Color.RED);
				textFild.setForeground(Color.WHITE);
			}
		}
	}

	public static void validateUserName(JTextField textFild) {
		String txt = textFild.getText();
		int caretPosition = textFild.getCaretPosition();
		if (!txt.isEmpty()) {
			if (textFild.getText().length() > 10) {

				txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
				textFild.setText(txt);
				textFild.setCaretPosition(caretPosition - 1);
			}

			if (txt.matches("^(IT|BS|EN)*[0-9]{8}$")) {

				textFild.setBackground(Color.WHITE);
				textFild.setForeground(Color.black);
			} else {

				textFild.setBackground(Color.RED);
				textFild.setForeground(Color.WHITE);
			}
		}
	}

	public static void phoneValidation(JTextField phoneTextField) {

		String text = phoneTextField.getText();
		int caretPosition = phoneTextField.getCaretPosition();
		if (!text.matches("[0-9]{0,10}?")) {
			text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
			phoneTextField.setBackground(Color.red);
			phoneTextField.setForeground(Color.WHITE);
			phoneTextField.setText(text);
			phoneTextField.setCaretPosition(caretPosition - 1);
		} else {

			phoneTextField.setForeground(Color.BLACK);
			phoneTextField.setBackground(Color.WHITE);
		}

	}

	public static void emailValidate(JTextField textField) {
		String text = textField.getText();
		int caretPosition = textField.getCaretPosition();
		if (!text.matches("^[a-z]([a-z0-9]+\\.)*[a-z0-9]+@[a-z0-9]+([a-z0-9]+\\.)*(\\.[a-z0-9]+)+$")) {
			// textField.setText(textField.getText().substring(0, textField.getText
			// ().length() - 1));
			textField.setForeground(Color.red);
		} else {
			textField.setForeground(Color.black);
		}
	}

	public static void nicValidation(JTextField nicTextField) {

		String text = nicTextField.getText();
		int caretPosition = nicTextField.getCaretPosition();
		if (!text.matches("[0-9]{0,10}?")) {
			text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
			nicTextField.setBackground(Color.red);
			nicTextField.setForeground(Color.WHITE);
			nicTextField.setText(text);
			nicTextField.setCaretPosition(caretPosition - 1);
		} else {

			nicTextField.setForeground(Color.BLACK);
			nicTextField.setBackground(Color.WHITE);
		}

	}

	public static void validatePhoneNumber(JTextField textField) {
		String text = textField.getText();

		if (!text.matches("\\d{3}\\-\\d{7}")) {
			textField.setForeground(Color.red);
		} else {
			textField.setForeground(Color.black);
		}
	}

	public static void validateAutoId(JTextField textFild) {
		String txt = textFild.getText();
		int caretPosition = textFild.getCaretPosition();
		if (!txt.matches("[S][0-9]{0,3}?")) {
			txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
			textFild.setText(txt);
			textFild.setCaretPosition(caretPosition - 1);
		}

		if (txt.matches("[S][0-9]{0,3}?")) {

			textFild.setBackground(Color.WHITE);
			textFild.setForeground(Color.black);
		} else {

			textFild.setBackground(Color.RED);
			textFild.setForeground(Color.WHITE);
		}
	}

}
