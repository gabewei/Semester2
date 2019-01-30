package findtreasure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class FindTreasure extends JFrame {
	private int row = 5;
	private int col = 5;
	private int difficulty = row * col;
	private int point = 0;
	JLabel[] choiceLabel = new JLabel[difficulty];
	ImageIcon echidna = new ImageIcon("echidna.jpg");
	ImageIcon rex = new ImageIcon("rex.png");
	JButton newButton = new JButton();
	JButton attempts = new JButton();
	int echidnaLocation;
	int rexLocation;
	Random myRandom = new Random();

	public FindTreasure() {
		setTitle("Find the Echidna! Created by Gabe Weible");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints;

		for (int i = 0; i < difficulty; i++) {
			choiceLabel[i] = new JLabel();
		}

		for (int j = 0; j < row; j++) {
			for (int i = 0; i < col; i++) {
				gridConstraints = new GridBagConstraints();
				choiceLabel[col * j + i].setPreferredSize(new Dimension(echidna.getIconWidth(), echidna.getIconHeight()));
				choiceLabel[col * j + i].setOpaque(true);
				choiceLabel[col * j + i].setBackground(Color.GREEN);
				gridConstraints.gridx = i;
				gridConstraints.gridy = j;
				gridConstraints.insets = new Insets(10, 10, 10, 10);
				getContentPane().add(choiceLabel[col * j + i], gridConstraints);
				choiceLabel[col * j + i].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						labelMouseClicked(e);
					}
				});
			}
		}
		newButton.setText("Play Again");
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = (col / 2);
		gridConstraints.gridy = 5;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(newButton, gridConstraints);
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newButtonActionPerformed(e);
			}
		});
		attempts.setText(Integer.toString(point));
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = ((col / 2) + 1);
		gridConstraints.gridy = 5;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(attempts, gridConstraints);
		
		getContentPane().setBackground(Color.BLUE);
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())),
				getWidth(), getHeight());
		newButton.doClick();
	}

	private void labelMouseClicked(MouseEvent e) {
		Component clickedComponent = e.getComponent();

		int choice;
		for (choice = 0; choice < difficulty; choice++) {
			if (clickedComponent == choiceLabel[choice]) {
				break;
			}
		}
		choiceLabel[choice].setBackground(Color.BLUE);
		if (choice == echidnaLocation) {
			choiceLabel[choice].setIcon(echidna);
			newButton.setEnabled(true);
			point += 1;
			attempts.setText(Integer.toString(point));
			JOptionPane.showMessageDialog(null, "You've won! Attempts: " + point);
			for (int i = 0; i < difficulty; i++) {
				choiceLabel[i].setIcon(null);
				choiceLabel[i].setBackground(Color.BLUE);
			}
			echidnaLocation = myRandom.nextInt(difficulty);
			rexLocation = myRandom.nextInt(difficulty);
			newButton.setEnabled(true);
		} else if (choice == rexLocation) {
			choiceLabel[choice].setIcon(rex);
			newButton.setEnabled(true);
			point += 1;
			attempts.setText(Integer.toString(point));
			JOptionPane.showMessageDialog(null, "You've lost, Attempts: " + point);
			for (int i = 0; i < difficulty; i++) {
				choiceLabel[i].setIcon(null);
				choiceLabel[i].setBackground(Color.GREEN);
			}
			echidnaLocation = myRandom.nextInt(difficulty);
			rexLocation = myRandom.nextInt(difficulty);
			newButton.setEnabled(true);
		} else
			point += 1;
			attempts.setText(Integer.toString(point));
	}

	private void newButtonActionPerformed(ActionEvent e) {
		for (int i = 0; i < difficulty; i++) {
			choiceLabel[i].setIcon(null);
			choiceLabel[i].setBackground(Color.GREEN);
		}
		echidnaLocation = myRandom.nextInt(difficulty);
		rexLocation = myRandom.nextInt(difficulty);
		newButton.setEnabled(false);
		point = 0;
		attempts.setText(Integer.toString(point));
	}

	private void exitForm(WindowEvent evt) {
		System.exit(0);
	}
}
