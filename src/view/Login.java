/**
 * 
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.DatabaseQueryException;
import controller.GeneralDAO;
import model.InvalidUserException;

/**
 * @author Lee John Smith
 *
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() {
	 * 
	 * @Override public void run() { try { Login frame = new Login();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		setPreferredSize(new Dimension(400, 600));
		setName("Login");
		setResizable(false);
		setSize(new Dimension(400, 600));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 94, 208));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBounds(168, 321, 188, 28);
		contentPane.add(txtUsername);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(67, 324, 84, 22);
		contentPane.add(lblUsername);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txtPassword = new JPasswordField();
		txtPassword.setBounds(168, 362, 188, 28);
		contentPane.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassword.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(67, 365, 80, 22);
		contentPane.add(lblPassword);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSubmit = new JButton("Log In");
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					GeneralDAO.checkUser(txtUsername.getText(), txtPassword.getPassword());
				} catch (InvalidUserException | DatabaseQueryException e) {
					JOptionPane.showMessageDialog(null, "Invalid Username/Password");
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(113, 414, 167, 31);
		contentPane.add(btnSubmit);

		JLabel lblTitle = new JLabel("Class Monitor");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(0, 244, 394, 34);
		contentPane.add(lblTitle);
	}
}
