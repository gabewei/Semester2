import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	// class variables a.k.a. instance variables a.k.a. field variables
	JFrame frame;

	// ADD SPHERE STUFF HERE TO FIX!!
	JTextField textField;

	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdec, badd, bsub, bmul, bdiv, beq, bclr, bksp, bsqr, bcbe, bsqt,
			blog;

	Double firstNumber;
	Double secondNumber;
	Double result;
	int operator;

	// constructor

	public Calculator() {
		Color myBlack = new Color(0, 0, 0);
		Color myWhite = new Color(255, 255, 255);
		Color myNavy = new Color(18, 53, 91);
		Color myRed = new Color(215, 38, 56);
		Color myMustard = new Color(255, 209, 102);

		frame = new JFrame("Calculator, Created by Gabe W.");
		frame.setLayout(null);

		textField = new JTextField();
		textField.setBounds(30, 40, 410, 30);
		frame.add(textField);

		// column 1
		b7 = new JButton("7");
		b7.setBounds(60, 100, 50, 65);
		b7.setBackground(myNavy);
		b7.setForeground(myWhite);
		frame.add(b7);

		b4 = new JButton("4");
		b4.setBounds(60, 165, 50, 65);
		b4.setBackground(myNavy);
		b4.setForeground(myWhite);
		frame.add(b4);

		b1 = new JButton("1");
		b1.setBounds(60, 230, 50, 65);
		b1.setBackground(myNavy);
		b1.setForeground(myWhite);
		frame.add(b1);

		bdec = new JButton(".");
		bdec.setBounds(60, 295, 50, 65);
		bdec.setBackground(myNavy);
		bdec.setForeground(myWhite);
		frame.add(bdec);

		// column 2
		b8 = new JButton("8");
		b8.setBounds(110, 100, 50, 65);
		b8.setBackground(myNavy);
		b8.setForeground(myWhite);
		frame.add(b8);

		b5 = new JButton("5");
		b5.setBounds(110, 165, 50, 65);
		b5.setBackground(myNavy);
		b5.setForeground(myWhite);
		frame.add(b5);

		b2 = new JButton("2");
		b2.setBounds(110, 230, 50, 65);
		b2.setBackground(myNavy);
		b2.setForeground(myWhite);
		frame.add(b2);

		b0 = new JButton("0");
		b0.setBounds(110, 295, 50, 65);
		b0.setBackground(myNavy);
		b0.setForeground(myWhite);
		frame.add(b0);

		// column 3
		b9 = new JButton("9");
		b9.setBounds(160, 100, 50, 65);
		b9.setBackground(myNavy);
		b9.setForeground(myWhite);
		frame.add(b9);

		b6 = new JButton("6");
		b6.setBounds(160, 165, 50, 65);
		b6.setBackground(myNavy);
		b6.setForeground(myWhite);
		frame.add(b6);

		b3 = new JButton("3");
		b3.setBounds(160, 230, 50, 65);
		b3.setBackground(myNavy);
		b3.setForeground(myWhite);
		frame.add(b3);

		beq = new JButton("=");
		beq.setBounds(160, 295, 50, 65);
		beq.setBackground(myNavy);
		beq.setForeground(myWhite);
		frame.add(beq);

		// column 4
		bdiv = new JButton("/");
		bdiv.setBounds(210, 100, 50, 65);
		bdiv.setBackground(myNavy);
		bdiv.setForeground(myWhite);
		frame.add(bdiv);

		bmul = new JButton("*");
		bmul.setBounds(210, 165, 50, 65);
		bmul.setBackground(myNavy);
		bmul.setForeground(myWhite);
		frame.add(bmul);

		bsub = new JButton("-");
		bsub.setBounds(210, 230, 50, 65);
		bsub.setBackground(myNavy);
		bsub.setForeground(myWhite);
		frame.add(bsub);

		badd = new JButton("+");
		badd.setBounds(210, 295, 50, 65);
		badd.setBackground(myNavy);
		badd.setForeground(myWhite);
		frame.add(badd);

		// column 5
		bclr = new JButton("CLEAR");
		bclr.setBounds(260, 100, 100, 65);
		bclr.setBackground(myWhite);
		bclr.setForeground(myRed);
		frame.add(bclr);

		bksp = new JButton("<--");
		bksp.setBounds(260, 165, 100, 65);
		bksp.setBackground(myWhite);
		bksp.setForeground(myRed);
		frame.add(bksp);

		bsqr = new JButton("x^2");
		bsqr.setBounds(260, 230, 100, 65);
		bsqr.setBackground(myMustard);
		bsqr.setForeground(myBlack);
		frame.add(bsqr);

		bcbe = new JButton("x^3");
		bcbe.setBounds(260, 295, 100, 65);
		bcbe.setBackground(myMustard);
		bcbe.setForeground(myBlack);
		frame.add(bcbe);

		// column 6
		bsqt = new JButton("Sq. Root");
		bsqt.setBounds(360, 100, 100, 65);
		bsqt.setBackground(myMustard);
		bsqt.setForeground(myBlack);
		frame.add(bsqt);

		blog = new JButton("Log(10)");
		blog.setBounds(360, 165, 100, 65);
		blog.setBackground(myMustard);
		blog.setForeground(myBlack);
		frame.add(blog);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(800, 600);
		frame.setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bdec.addActionListener(this);
		beq.addActionListener(this);
		badd.addActionListener(this);
		bsub.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		bclr.addActionListener(this);
		bksp.addActionListener(this);
		bsqr.addActionListener(this);
		bcbe.addActionListener(this);
		bsqt.addActionListener(this);
		blog.addActionListener(this);

	}

	// Listener -- waiting for an event, mouse click, mouse over ...
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)
			textField.setText(textField.getText().concat("1"));
		if (e.getSource() == b2)
			textField.setText(textField.getText().concat("2"));
		if (e.getSource() == b3)
			textField.setText(textField.getText().concat("3"));
		if (e.getSource() == b4)
			textField.setText(textField.getText().concat("4"));
		if (e.getSource() == b5)
			textField.setText(textField.getText().concat("5"));
		if (e.getSource() == b6)
			textField.setText(textField.getText().concat("6"));
		if (e.getSource() == b7)
			textField.setText(textField.getText().concat("7"));
		if (e.getSource() == b8)
			textField.setText(textField.getText().concat("8"));
		if (e.getSource() == b9)
			textField.setText(textField.getText().concat("9"));
		if (e.getSource() == b0)
			textField.setText(textField.getText().concat("0"));
		if (e.getSource() == bdec)
			textField.setText(textField.getText().concat("."));

		if (e.getSource() == bclr) {
			textField.setText("");
		}

		if (e.getSource() == badd) {
			firstNumber = Double.parseDouble(textField.getText());
			operator = 1;
			textField.setText("");
		}

		if (e.getSource() == bsub) {
			firstNumber = Double.parseDouble(textField.getText());
			operator = 2;
			textField.setText("");
		}

		if (e.getSource() == bmul) {
			firstNumber = Double.parseDouble(textField.getText());
			operator = 3;
			textField.setText("");
		}

		if (e.getSource() == bdiv) {
			firstNumber = Double.parseDouble(textField.getText());
			operator = 4;
			textField.setText("");
		}

		if (e.getSource() == beq) {
			secondNumber = Double.parseDouble(textField.getText());

			switch (operator) {
			case 1:
				result = firstNumber + secondNumber;
				break;
			case 2:
				result = firstNumber - secondNumber;
				break;
			case 3:
				result = firstNumber * secondNumber;
				break;
			case 4:
				result = firstNumber / secondNumber;
				break;

			default:
				result = 0.0;
			} // end of basic operator operations

			textField.setText("" + result);
		} // end of beq if statement

		if (e.getSource() == bsqr) {
			firstNumber = Double.parseDouble(textField.getText());
			secondNumber = Math.pow(firstNumber, 2.0);
			textField.setText("" + secondNumber);
		}

		if (e.getSource() == bcbe) {
			firstNumber = Double.parseDouble(textField.getText());
			secondNumber = Math.pow(firstNumber, 3.0);
			textField.setText("" + secondNumber);
		}

		if (e.getSource() == bsqt) {
			firstNumber = Double.parseDouble(textField.getText());
			secondNumber = Math.pow(firstNumber, 0.5);
			textField.setText("" + secondNumber);
		}

		if (e.getSource() == blog) {
			firstNumber = Double.parseDouble(textField.getText());
			secondNumber = Math.log10(firstNumber);
			textField.setText("" + secondNumber);
		}

		if (e.getSource() == bksp) {
			// s is what was in the text field
			String s = textField.getText();
			// clear text field
			textField.setText("");
			// for every character in s minus 1,
			for (int i = 0; i < s.length() - 1; i++)
				// add that character from s into the text field
				textField.setText(textField.getText() + s.charAt(i));
		}

	} // end of ActionEvents

} // end of Calculator class