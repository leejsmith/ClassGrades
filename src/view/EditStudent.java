package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.Allergy;
import model.Sen;
import model.Student;

public class EditStudent {

	private JFrame frame;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtRegGroup;
	private JTextField txtExamNumber;
	private JTextField txtCatMean;
	private JTextField txtCATVerbal;
	private JTextField txtCATNonVerbal;
	private JTextField txtCATQuant;
	private JTextField txtCATAverage;
	private JTable tblSEN;
	private JTable tblAllergy;

	private TableModel senTable;
	private TableModel allergyTable;

	private ArrayList<Sen> senList;
	private ArrayList<Allergy> allergyList;

	private Student student;

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.constructor
	 */

	public EditStudent() {
		initialize();
		student = null;
	}

	public EditStudent(Student s) {
		initialize();
		txtForename.setText(s.getForname());
		txtSurname.setText(s.getSurname());
		txtRegGroup.setText(s.getRegGroup());
		txtExamNumber.setText(String.valueOf(s.getExamNumber()));
		txtCatMean.setText(String.valueOf(s.getCatMean()));
		txtCATVerbal.setText(String.valueOf(s.getCatVerbal()));
		txtCATNonVerbal.setText(String.valueOf(s.getCatNonVerbal()));
		txtCATQuant.setText(String.valueOf(s.getCatQuantative()));
		txtCATAverage.setText(String.valueOf(s.getCatAverage()));
		student = s;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Create Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 414, 29);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblForename = new JLabel("Forename");
		lblForename.setBounds(10, 51, 62, 14);
		frame.getContentPane().add(lblForename);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 76, 62, 14);
		frame.getContentPane().add(lblSurname);

		txtForename = new JTextField();
		txtForename.setBounds(100, 48, 153, 20);
		frame.getContentPane().add(txtForename);
		txtForename.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.setBounds(100, 73, 153, 20);
		frame.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);

		JLabel lblRegGroup = new JLabel("Reg Group");
		lblRegGroup.setBounds(10, 101, 62, 14);
		frame.getContentPane().add(lblRegGroup);

		txtRegGroup = new JTextField();
		txtRegGroup.setBounds(100, 98, 75, 20);
		frame.getContentPane().add(txtRegGroup);
		txtRegGroup.setColumns(10);

		JLabel lblExamNumber = new JLabel("Exam Number");
		lblExamNumber.setBounds(10, 126, 75, 14);
		frame.getContentPane().add(lblExamNumber);

		txtExamNumber = new JTextField();
		txtExamNumber.setBounds(100, 123, 75, 20);
		frame.getContentPane().add(txtExamNumber);
		txtExamNumber.setColumns(10);

		JLabel lblEal = new JLabel("EAL?");
		lblEal.setBounds(10, 150, 46, 14);
		frame.getContentPane().add(lblEal);

		JCheckBox ckbEAL = new JCheckBox("");
		ckbEAL.setBounds(100, 146, 97, 23);
		frame.getContentPane().add(ckbEAL);

		JLabel lblNewLabel_1 = new JLabel("Pupil Premium");
		lblNewLabel_1.setBounds(10, 175, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JCheckBox ckbPupilPremium = new JCheckBox("");
		ckbPupilPremium.setBounds(100, 171, 97, 23);
		frame.getContentPane().add(ckbPupilPremium);

		JLabel lblCatMean = new JLabel("CAT Mean");
		lblCatMean.setBounds(10, 216, 62, 14);
		frame.getContentPane().add(lblCatMean);

		txtCatMean = new JTextField();
		txtCatMean.setBounds(89, 213, 86, 20);
		frame.getContentPane().add(txtCatMean);
		txtCatMean.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CAT Verbal");
		lblNewLabel_2.setBounds(10, 241, 62, 14);
		frame.getContentPane().add(lblNewLabel_2);

		txtCATVerbal = new JTextField();
		txtCATVerbal.setBounds(89, 238, 86, 20);
		frame.getContentPane().add(txtCATVerbal);
		txtCATVerbal.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("CAT Non Verbal");
		lblNewLabel_3.setBounds(194, 216, 78, 14);
		frame.getContentPane().add(lblNewLabel_3);

		txtCATNonVerbal = new JTextField();
		txtCATNonVerbal.setBounds(282, 213, 86, 20);
		frame.getContentPane().add(txtCATNonVerbal);
		txtCATNonVerbal.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CAT Quantative");
		lblNewLabel_4.setBounds(194, 241, 78, 14);
		frame.getContentPane().add(lblNewLabel_4);

		txtCATQuant = new JTextField();
		txtCATQuant.setBounds(282, 238, 86, 20);
		frame.getContentPane().add(txtCATQuant);
		txtCATQuant.setColumns(10);

		JLabel lblCatAverage = new JLabel("CAT Average");
		lblCatAverage.setBounds(10, 266, 75, 14);
		frame.getContentPane().add(lblCatAverage);

		txtCATAverage = new JTextField();
		txtCATAverage.setBounds(89, 263, 86, 20);
		frame.getContentPane().add(txtCATAverage);
		txtCATAverage.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 200, 414, 2);
		frame.getContentPane().add(separator);

		JPanel panel = new JPanel();
		panel.setBounds(10, 325, 414, 84);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tblSEN = new JTable();
		senList = new ArrayList<Sen>();
		senTable = new TableModel();
		if (student != null) {

		}

		panel.add(tblSEN, BorderLayout.CENTER);

		JLabel lblNewLabel_5 = new JLabel("Special Education Needs");
		lblNewLabel_5.setBounds(10, 304, 128, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 291, 414, 2);
		frame.getContentPane().add(separator_1);

		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(10, 449, 128, 14);
		frame.getContentPane().add(lblAllergies);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 465, 414, 84);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tblAllergy = new JTable();
		panel_1.add(tblAllergy, BorderLayout.CENTER);

		JButton btnRemoveSEN = new JButton("Remove Special Educational Need");
		btnRemoveSEN.setBounds(218, 415, 193, 23);
		frame.getContentPane().add(btnRemoveSEN);

		JButton btnAddAllergy = new JButton("Add Allergy");
		btnAddAllergy.setBounds(20, 557, 193, 23);
		frame.getContentPane().add(btnAddAllergy);

		JButton btnAddSEN = new JButton("Add Special Educational Need");
		btnAddSEN.setBounds(20, 415, 193, 23);
		frame.getContentPane().add(btnAddSEN);

		JButton btnRemoveAllergy = new JButton("Remove Allergy");
		btnRemoveAllergy.setBounds(218, 557, 193, 23);
		frame.getContentPane().add(btnRemoveAllergy);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(56, 666, 128, 29);
		frame.getContentPane().add(btnAddStudent);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(251, 666, 128, 29);
		frame.getContentPane().add(btnCancel);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 591, 414, 2);
		frame.getContentPane().add(separator_2);

		JLabel lblAssignToGroup = new JLabel("Assign to Group");
		lblAssignToGroup.setBounds(10, 604, 86, 14);
		frame.getContentPane().add(lblAssignToGroup);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(35, 625, 358, 20);
		frame.getContentPane().add(comboBox);

	}

	public void addSEN(Sen s) {

	}

	public void addAllergy(Allergy a) {

	}

	class SENTableModel extends AbstractTableModel {
		private ArrayList<Sen> sen;
		private String[] columnNames;
		private Object[][] data;

		SENTableModel(ArrayList<Sen> sen) {
			this.sen = sen;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			return sen.get(arg1);
		}
		
		public 

	}
}
