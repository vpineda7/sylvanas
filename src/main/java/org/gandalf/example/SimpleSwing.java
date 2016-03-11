package org.gandalf.example;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleSwing extends JFrame {

	private static final long serialVersionUID = 1L;

	public SimpleSwing() {

		super();

		this.setSize(800, 600);
		this.getContentPane().setLayout(null);
		
		this.setTitle("HelloWorld");
		this.add(getJButton(), null);
	}
	
	private JButton jButton;

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
