package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Course;

public class EditCourse {

	private JFrame frame;
	private JTextField textField;
	private JTable tblModules;
	private JTable table;

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.constructor
	 */
	public EditCourse() {
		initialize();
	}

	public EditCourse(Course c) {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Add New Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 179, 38);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(10, 60, 72, 14);
		frame.getContentPane().add(lblCourseName);

		textField = new JTextField();
		textField.setBounds(82, 57, 168, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblModules = new JLabel("Modules");
		lblModules.setBounds(10, 108, 46, 14);
		frame.getContentPane().add(lblModules);

		JPanel panel = new JPanel();
		panel.setBounds(10, 133, 412, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tblModules = new JTable();
		panel.add(tblModules, BorderLayout.CENTER);

		JButton btnAddModule = new JButton("Add Module");
		btnAddModule.setBounds(69, 299, 109, 23);
		frame.getContentPane().add(btnAddModule);

		JButton btnRemoveModule = new JButton("Remove Module");
		btnRemoveModule.setBounds(254, 299, 109, 23);
		frame.getContentPane().add(btnRemoveModule);

		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(10, 603, 168, 23);
		frame.getContentPane().add(btnAddCourse);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(254, 603, 168, 23);
		frame.getContentPane().add(btnCancel);

		JLabel lblGroups = new JLabel("Groups");
		lblGroups.setBounds(10, 337, 46, 14);
		frame.getContentPane().add(lblGroups);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 362, 412, 155);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		panel_1.add(table, BorderLayout.CENTER);

		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setBounds(69, 528, 109, 23);
		frame.getContentPane().add(btnAddGroup);

		JButton btnRemoveGroup = new JButton("Remove Group");
		btnRemoveGroup.setBounds(254, 528, 109, 23);
		frame.getContentPane().add(btnRemoveGroup);
	}
}
