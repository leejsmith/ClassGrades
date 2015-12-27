package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.MainWindowListener;
import controller.MenuListener;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ActionListener listener;
	private MenuListener ml;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
