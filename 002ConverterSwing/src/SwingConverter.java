import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingConverter implements ActionListener {

	private JPanel inputPanel = initinputPanel();

	private JTextField inputTextBase;
	private JTextArea resultAreaBase;
	private JButton enterButtonBase;

	private JTextField inputTextSphere;
	private JTextArea resultAreaSphere;
	private JButton enterButtonSphere;

	public SwingConverter() {
		javax.swing.JFrame myWindow = new javax.swing.JFrame("Base Converter - Created by Gabriel W.");
		myWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.add(inputPanel);
		myWindow.setSize(600, 800);
		myWindow.setVisible(true);

	}

	private JPanel initinputPanel() {

		JPanel panel = new JPanel();

		panel.setPreferredSize(new java.awt.Dimension(600, 800));
		panel.setLayout(null);
		Color myNavy = new Color(18, 53, 91);
		Color myRed = new Color(215, 38, 56);
		Color myMustard = new Color(255, 209, 102);
		Color myWhite = new Color(255, 255, 255);
		panel.setBackground(myNavy);

		// Base code
		JLabel baselabel = new JLabel("Enter a base-10 number: ");
		baselabel.setBounds(50, 50, 220, 30);
		baselabel.setForeground(myWhite);
		panel.add(baselabel);

		JTextField basetext;
		basetext = inputTextBase = new JTextField();
		basetext.setBounds(230, 50, 100, 30);
		panel.add(basetext);

		JButton button = new JButton("Enter");
		button.setActionCommand("Enter");
		button.setBounds(340, 50, 80, 30);
		button.addActionListener(this);
		button.setBackground(myMustard);
		panel.add(button);
		// save to the class variable, to be used in other methods
		enterButtonBase = button; // assign it to a class var to be used in other methods

		button = new JButton("Reset");
		button.setForeground(myRed);
		button.setActionCommand("Reset");
		button.setBounds(430, 50, 80, 30);
		button.addActionListener(this);
		button.setBackground(myMustard);
		panel.add(button);

		resultAreaBase = new JTextArea();
		resultAreaBase.setBounds(50, 180, 500, 200);
		resultAreaBase.setEditable(false);
		resultAreaBase.setBackground(myWhite);
		panel.add(resultAreaBase);

		// Sphere code
		JLabel spherelabel = new JLabel("Enter the radius of your sphere: ");
		spherelabel.setBounds(50, 400, 300, 30);
		spherelabel.setForeground(myWhite);
		panel.add(spherelabel);

		JTextField spheretext;
		spheretext = inputTextSphere = new JTextField();
		spheretext.setBounds(280, 400, 100, 30);
		panel.add(spheretext);

		button = new JButton(" Enter");
		button.setActionCommand(" Enter");
		button.setBounds(390, 400, 80, 30);
		button.addActionListener(this);
		button.setBackground(myMustard);
		panel.add(button);
		// save to the class variable, to be used in other methods
		enterButtonSphere = button; // assign it to a class var to be used in other methods

		button = new JButton(" Reset");
		button.setForeground(myRed);
		button.setActionCommand(" Reset");
		button.setBounds(480, 400, 80, 30);
		button.addActionListener(this);
		button.setBackground(myMustard);
		panel.add(button);

		resultAreaSphere = new JTextArea();
		resultAreaSphere.setBounds(50, 530, 500, 200);
		resultAreaSphere.setEditable(false);
		resultAreaSphere.setBackground(myWhite);
		panel.add(resultAreaSphere);

		return panel;
	}

	public static void main(String[] args) throws Exception {
		// SwingConverter baseConverter = new SwingConverter();
		new SwingConverter();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String command = ev.getActionCommand();
		if (command.equals("Enter")) {
			showResult();
		} else if (command.equals("Reset")) {
			reset();
		} else if (command.equals(" Reset")) {
			resetSphere();
		} else if (command.equals(" Enter")) {
			showResultSphere();
		}
	}

	private void reset() {
		// System.out.println("reset entered");
		inputTextBase.setText("");
		resultAreaBase.setText("");
		inputTextBase.setEnabled(true);
		enterButtonBase.setEnabled(true);
		inputTextBase.requestFocus();

	}

	private void showResult() {
		// System.out.println("showResult entered");

		String hexUpperCase;
		inputTextBase.setEnabled(false);
		enterButtonBase.setEnabled(false);

		Integer n = getInputNumberBase();
		if (n == null) {
			resultAreaBase.append("Invalid number!");
			return;
		}

		int baseTen = n.intValue();
		resultAreaBase.append("base 10 = " + baseTen + "\n");
		resultAreaBase.append("binary = " + Integer.toString(baseTen, 2) + "\n");
		resultAreaBase.append("octal = " + Integer.toString(baseTen, 8) + "\n");
		resultAreaBase.append("hexadecimal = " + Integer.toString(baseTen, 16) + "\n");

		hexUpperCase = Integer.toString(baseTen, 16).toUpperCase();
		resultAreaBase.append("hexadecimal = " + hexUpperCase + "\n");

	}

	private Integer getInputNumberBase() {
		try {
			Integer n = Integer.parseInt(inputTextBase.getText());
			return n;
		} catch (Exception e) {
			/*
			 * oops! problem with number entry this traps that error, now tell user the
			 * error and let them try an entry again return null is to prevent a total
			 * crash, but it really is not fixing the problem NOT GOOD!
			 */
			return null;
		} // end of exception
	} // end of getInputNumber() base method

	public void actionPerformed1(ActionEvent ev) {
		String command = ev.getActionCommand();
		if (command.equals("EnterSphere")) {
			showResultSphere();
		} else if (command.equals("ResetSphere")) {
			resetSphere();
		}
	}

	private void resetSphere() {
		// System.out.println("reset entered");
		inputTextSphere.setText("");
		resultAreaSphere.setText("");
		inputTextSphere.setEnabled(true);
		enterButtonSphere.setEnabled(true);
		inputTextSphere.requestFocus();

	}

	private void showResultSphere() {
		// System.out.println("showResult entered");

		inputTextSphere.setEnabled(false);
		enterButtonSphere.setEnabled(false);

		Integer n = getInputNumberSphere();
		if (n == null) {
			resultAreaSphere.append("Invalid number!");
			return;
		}

		double radius = n;
		double volume;
		volume = ((4.0 * (Math.PI) * (Math.pow(radius, 3.0))) / 3.0);

		double surfaceArea;
		surfaceArea = (4.0 * (Math.PI) * (Math.pow(radius, 2.0)));

		resultAreaSphere.append("Volume = " + volume + "\n");
		resultAreaSphere.append("Surface Area = " + surfaceArea + "\n");
	}

	private Integer getInputNumberSphere() {
		try {
			Integer n = Integer.parseInt(inputTextSphere.getText());
			return n;
		} catch (Exception e) {
			/*
			 * oops! problem with number entry this traps that error, now tell user the
			 * error and let them try an entry again return null is to prevent a total
			 * crash, but it really is not fixing the problem NOT GOOD!
			 */
			return null;
		} // end of exception
	} // end of getInputNumber() sphere method
} // end of SwingConverter
