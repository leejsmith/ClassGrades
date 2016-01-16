package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.MainWindowListener;
import controller.MenuListener;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ActionListener listener;
	private MenuListener ml;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public MainWindow(MainWindowListener l, MenuListener ml) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		listener = l;
		this.ml = ml;
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);

		JMenuItem mntmStudent = new JMenuItem("Student");
		mnNew.add(mntmStudent);
		mntmStudent.addActionListener(ml);

		JMenuItem mntmGroup = new JMenuItem("Group");
		mnNew.add(mntmGroup);
		mntmGroup.addActionListener(ml);

		JMenuItem mntmCourse = new JMenuItem("Course");
		mnNew.add(mntmCourse);
		mntmCourse.addActionListener(ml);

		JMenuItem mntmAllergy = new JMenuItem("Allergy");
		mnNew.add(mntmAllergy);
		mntmAllergy.addActionListener(ml);

		JMenuItem mntmSpecialEducationalNeed = new JMenuItem("Special Educational Need (SEN)");
		mnNew.add(mntmSpecialEducationalNeed);
		mntmSpecialEducationalNeed.addActionListener(ml);

		JMenuItem mntmPreferences = new JMenuItem("Preferences");
		mnFile.add(mntmPreferences);
		mntmPreferences.addActionListener(ml);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(ml);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmUpdateStudentDetails = new JMenuItem("Update Student Details");
		mnEdit.add(mntmUpdateStudentDetails);
		mntmUpdateStudentDetails.addActionListener(ml);

		JMenuItem mntmAddStudentGrades = new JMenuItem("Add Student Grades");
		mnEdit.add(mntmAddStudentGrades);
		mntmAddStudentGrades.addActionListener(ml);

		JMenuItem mntmAddModuleResults = new JMenuItem("Add Student Module Results");
		mnEdit.add(mntmAddModuleResults);
		mntmAddModuleResults.addActionListener(ml);

		JMenuItem mntmEditCourse = new JMenuItem("Edit Course");
		mnEdit.add(mntmEditCourse);
		mntmEditCourse.addActionListener(ml);

		JMenuItem mntmEditGroups = new JMenuItem("Edit Groups");
		mnEdit.add(mntmEditGroups);
		mntmEditGroups.addActionListener(ml);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
		mntmHelp.addActionListener(ml);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
		mntmAbout.addActionListener(ml);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 12));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		JButton btnAddStudentResult = new JButton("Add Student Results");
		btnAddStudentResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditStudent();
			}
		});
		btnAddStudentResult.setBounds(10, 11, 180, 43);
		panel.add(btnAddStudentResult);

		JButton btnViewCourses = new JButton("View Courses");
		btnViewCourses.setBounds(10, 65, 180, 43);
		panel.add(btnViewCourses);

		JButton btnViewGroups = new JButton("View Groups");
		btnViewGroups.setBounds(10, 119, 180, 43);
		panel.add(btnViewGroups);

		JButton btnCreateNewCourse = new JButton("Create New Course");
		btnCreateNewCourse.setBounds(10, 173, 180, 43);
		panel.add(btnCreateNewCourse);

		JButton btnCreateNewGroup = new JButton("Create New Group");
		btnCreateNewGroup.setBounds(10, 227, 180, 43);
		panel.add(btnCreateNewGroup);

		JButton btnCreateNewStudent = new JButton("Create New Student");
		btnCreateNewStudent.setBounds(10, 281, 180, 43);
		panel.add(btnCreateNewStudent);

		JButton btnImport = new JButton("Import Students From CSV");
		btnImport.setBounds(10, 335, 180, 43);
		panel.add(btnImport);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 60));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Display");
		lblNewLabel.setBounds(27, 26, 46, 14);
		panel_2.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Courses", "Groups" }));
		comboBox.setBounds(68, 23, 137, 20);
		panel_2.add(comboBox);

		table = new JTable();
		panel_1.add(table, BorderLayout.CENTER);
	}
}
