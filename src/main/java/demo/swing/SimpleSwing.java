package demo.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SimpleSwing extends JFrame {

	private static final long serialVersionUID = 1L;

	public SimpleSwing() {

		super();

		this.setSize(800, 600);
		this.getContentPane().setLayout(null);
		
		this.add(getJLabel(), null);
		this.add(getJTextField(), null);
		this.add(getJButton(), null);
		
		this.setTitle("HelloWorld");
	}
	
	private JButton jButton;
	
	private JTextField jTextField;
	
	private JLabel jLabel;
	
	private JLabel getJLabel() {

		if (jLabel == null) {

			jLabel = new JLabel();
			jLabel.setBounds(34, 49, 53, 18);
			jLabel.setText("Name:");
		}

		return jLabel;
	}

	private JTextField getJTextField() {
		
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(96, 49, 160, 20);
		}
		
		return jTextField;
	}

	private JButton getJButton() {
		
		if (jButton == null) {
			
			jButton = new JButton();
			jButton.setBounds(103, 110, 71, 27);
			jButton.setText("OK");
		}
		
		return jButton;
	}

	public static void main(String[] args) {
		
		SimpleSwing ss = new SimpleSwing();
		
		ss.setVisible(true);
	}
}
