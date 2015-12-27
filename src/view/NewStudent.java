package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public NewStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 7680);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
