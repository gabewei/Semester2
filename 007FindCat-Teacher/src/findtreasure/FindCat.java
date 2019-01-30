
package findtreasure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class FindCat extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label0 = new JLabel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel[] choiceLabel = new JLabel[3];
	ImageIcon cat = new ImageIcon("cat.gif");
	JButton newButton = new JButton();
	int catLocation;
	Random myRandom = new Random();
	int x = 5;
	int y = 5;

	public static void main(String args[]) {
		// create frame
		new FindCat().setVisible(true);
	}

	public FindCat() {
		// frame constructor
		setTitle("Find the Cat");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints;

		choiceLabel[0] = label0;
		choiceLabel[1] = label1;
		choiceLabel[2] = label2;
		for (int i = 0; i < 3; i++) {
			gridConstraints = new GridBagConstraints();
			choiceLabel[i].setPreferredSize(new Dimension(cat.getIconWidth(), cat.getIconHeight()));
			choiceLabel[i].setOpaque(true);
			choiceLabel[i].setBackground(Color.RED);
			gridConstraints.gridx = i;
			gridConstraints.gridy = 0;
			gridConstraints.insets = new Insets(10, 10, 10, 10);
			getContentPane().add(choiceLabel[i], gridConstraints);
			choiceLabel[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					labelMouseClicked(e);
				}
			});
		}

		newButton.setText("Play Again");
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(newButton, gridConstraints);
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newButtonActionPerformed(e);
			}
		});
		getContentPane().setBackground(Color.YELLOW);
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())),
				getWidth(), getHeight());
		// start first game
		newButton.doClick();
	}

	private void labelMouseClicked(MouseEvent e) {
		Component clickedComponent = e.getComponent();
		int choice;
		for (choice = 0; choice < 3; choice++) {
			if (clickedComponent == choiceLabel[choice]) {
				break;
			}
		}
		choiceLabel[choice].setBackground(Color.WHITE);
		if (choice == catLocation) {
			choiceLabel[choice].setIcon(cat);
			newButton.setEnabled(true);
		}
	}

	private void newButtonActionPerformed(ActionEvent e) {
		// clear boxes and hide cat
		for (int i = 0; i < 3; i++) {
			choiceLabel[i].setIcon(null);
			choiceLabel[i].setBackground(Color.RED);
		}
		catLocation = myRandom.nextInt(3);
		newButton.setEnabled(false);
	}

	private void exitForm(WindowEvent evt) {
		System.exit(0);
	}
}