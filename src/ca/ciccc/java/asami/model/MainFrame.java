package ca.ciccc.java.asami.model;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dateTextField;
	private JButton okButton;

	private JLabel result;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][]"));

		// label
		JLabel label = new JLabel("New label");
		label.setText("Type a date (yyyy-mm-dd) or “quit” to exit");

		contentPane.add(label, "cell 2 0");

		// text field
		dateTextField = new JTextField();
		contentPane.add(dateTextField, "cell 2 1,growx");
		dateTextField.setColumns(10);

		okButton = new JButton("OK");
		contentPane.add(okButton, "cell 2 2");

		result = new JLabel("");
		contentPane.add(result, "cell 2 3");

	}

	public String getInputValue() {
		return dateTextField.getText();
	}

	public final void setResult(String text) {
		result.setText(text);
	}

	public void setOkButtonListener(ActionListener a) {
		okButton.addActionListener(a);
	}
}
