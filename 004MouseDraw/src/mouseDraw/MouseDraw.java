package mouseDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class MouseDraw extends JFrame {

	JMenuBar mainMenuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem newMenuItem = new JMenuItem("New");
	JMenuItem exitMenuItem = new JMenuItem("Exit");
	JPanel drawPanel = new JPanel();
	JLabel leftColorLabel = new JLabel();
	JLabel rightColorLabel = new JLabel();
	JPanel colorPanel = new JPanel();
	JLabel[] colorLabel = new JLabel[18];
	Graphics2D g2D;
	double xPrevious, yPrevious;
	Color drawColor, leftColor, rightColor;

	JMenu boardColorMenu = new JMenu("BoardColor");
	JMenu penSizeMenu = new JMenu("PenSize");
	JMenuItem blackMenuItem = new JMenuItem("Black");
	JMenuItem yellowMenuItem = new JMenuItem("Yellow");
	JMenuItem redMenuItem = new JMenuItem("Red");
	JMenuItem grayMenuItem = new JMenuItem("Gray");
	JMenuItem fineMenuItem = new JMenuItem("Fine");
	JMenuItem smallMenuItem = new JMenuItem("Small");
	JMenuItem mediumMenuItem = new JMenuItem("Medium");
	JMenuItem largeMenuItem = new JMenuItem("Large");

	public static void main(String args[]) {
		// construct frame
		new MouseDraw().setVisible(true);
	}

	public MouseDraw() {

		// JFrame constructor
		setTitle("Artistic Creations by Gabriel W. October 2018");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}
		});
		getContentPane().setLayout(new GridBagLayout());

		// build menu
		setJMenuBar(mainMenuBar);
		fileMenu.setMnemonic('F');
		mainMenuBar.add(fileMenu);
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMenuItemActionPerformed(e);
			}
		});
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitMenuItemActionPerformed(e);
			}
		});

		drawPanel.setPreferredSize(new Dimension(500, 400));
		drawPanel.setBackground(new Color(200, 200, 200)); // RGB 0-255

		boardColorMenu.setMnemonic('B');
		mainMenuBar.add(boardColorMenu);
		boardColorMenu.add(blackMenuItem);
		boardColorMenu.addSeparator();
		boardColorMenu.add(yellowMenuItem);
		boardColorMenu.addSeparator();
		boardColorMenu.add(redMenuItem);
		boardColorMenu.addSeparator();
		boardColorMenu.add(grayMenuItem);
		blackMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blackMenuItemActionPerformed(e);
			}
		});
		yellowMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yellowMenuItemActionPerformed(e);
			}
		});
		redMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redMenuItemActionPerformed(e);
			}
		});
		grayMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grayMenuItemActionPerformed(e);
			}
		});
		penSizeMenu.setMnemonic('P');
		mainMenuBar.add(penSizeMenu);
		penSizeMenu.add(fineMenuItem);
		penSizeMenu.addSeparator();
		penSizeMenu.add(smallMenuItem);
		penSizeMenu.addSeparator();
		penSizeMenu.add(mediumMenuItem);
		penSizeMenu.addSeparator();
		penSizeMenu.add(largeMenuItem);
		fineMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g2D.setStroke(new BasicStroke(1));
			}
		});
		smallMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g2D.setStroke(new BasicStroke(2));
			}
		});
		mediumMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g2D.setStroke(new BasicStroke(7));
			}
		});
		largeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g2D.setStroke(new BasicStroke(15));
			}
		});

		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridheight = 2;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(drawPanel, gridConstraints);

		drawPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				drawPanelMousePressed(e);
			}
		});

		drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				drawPanelMouseDragged(e);
			}
		});

		drawPanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				drawPanelMouseReleased(e);
			}
		});

		leftColorLabel.setPreferredSize(new Dimension(40, 40));
		leftColorLabel.setOpaque(true);
		leftColorLabel.setBackground(Color.YELLOW);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 5, 10, 10);
		getContentPane().add(leftColorLabel, gridConstraints);

		rightColorLabel.setPreferredSize(new Dimension(40, 40));
		rightColorLabel.setOpaque(true);
		rightColorLabel.setBackground(Color.RED);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 5, 10, 10);
		getContentPane().add(rightColorLabel, gridConstraints);

		colorPanel.setPreferredSize(new Dimension(80, 320));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 2;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(colorPanel, gridConstraints);

		colorPanel.setLayout(new GridBagLayout());
		int j = 0;
		for (int i = 0; i < 18; i++) {
			colorLabel[i] = new JLabel();
			colorLabel[i].setPreferredSize(new Dimension(30, 30));
			colorLabel[i].setOpaque(true);
			gridConstraints = new GridBagConstraints();
			gridConstraints.gridx = j;
			gridConstraints.gridy = i - j * 9;
			colorPanel.add(colorLabel[i], gridConstraints);
			if (i == 8) {
				j++;
			}

			colorLabel[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					colorMousePressed(e);
				}

			});
		} // end of the color grids loop

		// lred, mred, dred
		colorLabel[0].setBackground(new Color(255, 128, 128));
		colorLabel[1].setBackground(new Color(255, 0, 0));
		colorLabel[2].setBackground(new Color(128, 0, 0));

		// lgreen, mgreen, dgreen
		colorLabel[3].setBackground(new Color(128, 255, 128));
		colorLabel[4].setBackground(new Color(0, 255, 0));
		colorLabel[5].setBackground(new Color(0, 128, 0));

		// lblue, mblue, dblue
		colorLabel[6].setBackground(new Color(128, 128, 255));
		colorLabel[7].setBackground(new Color(0, 0, 255));
		colorLabel[8].setBackground(new Color(0, 0, 128));

		// lcyan, mcyan, dcyan
		colorLabel[9].setBackground(new Color(128, 255, 255));
		colorLabel[10].setBackground(new Color(0, 255, 255));
		colorLabel[11].setBackground(new Color(0, 128, 128));

		// lmagenta, mmagenta, dmagenta
		colorLabel[12].setBackground(new Color(255, 128, 255));
		colorLabel[13].setBackground(new Color(255, 0, 255));
		colorLabel[14].setBackground(new Color(128, 0, 128));

		// lyellow, myellow, dyellow
		colorLabel[15].setBackground(new Color(255, 255, 128));
		colorLabel[16].setBackground(new Color(255, 255, 0));
		colorLabel[17].setBackground(new Color(128, 128, 0));

		leftColor = colorLabel[1].getBackground();
		leftColorLabel.setBackground(leftColor);
		rightColor = colorLabel[7].getBackground();
		rightColorLabel.setBackground(rightColor);

		pack();
		setLocationRelativeTo(null);

		g2D = (Graphics2D) drawPanel.getGraphics();
	} // end of constructor

	private void exitForm(WindowEvent e) {

		g2D.dispose();
		System.exit(0);

	}

	private void newMenuItemActionPerformed(ActionEvent e) {
		int response;
		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new drawing?", "NEW DRAWING",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			g2D.setPaint(drawPanel.getBackground());
			g2D.fill(new Rectangle2D.Double(0, 0, drawPanel.getWidth(), drawPanel.getHeight()));
		}

	}

	private void exitMenuItemActionPerformed(ActionEvent e) {
		int response;
		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Exit Program",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {
			return;
		} else {
			exitForm(null);
		}

	}

		// Board color menu item methods
	private void blackMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(0, 0, 0));

	}

	private void yellowMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(255, 255, 0));

	}

	private void redMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(255, 0, 0));

	}

	private void grayMenuItemActionPerformed(ActionEvent e) {
		drawPanel.setBackground(new Color(200, 200, 200));
		
	}
	
		// Pen size menu item methods
	private void fineMenuItemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void smallMenuItemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void mediumMenuItemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void largeMenuItemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawPanelMousePressed(MouseEvent e) {
		// if left button or right button clicked, set color and start drawing process
		if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
			xPrevious = e.getX();
			yPrevious = e.getY();
			if (e.getButton() == MouseEvent.BUTTON1) {
				drawColor = leftColor;
			} else {
				drawColor = rightColor;
			}
		}
		System.out.println(xPrevious + ", " + yPrevious);
	} // end of drawPanelMousePressed

	private void drawPanelMouseDragged(MouseEvent e) {
		// if drawing, connect previous point with new point
		Line2D.Double myLine = new Line2D.Double(xPrevious, yPrevious, e.getX(), e.getY());
		g2D.setPaint(drawColor);
	
		g2D.draw(myLine);
		xPrevious = e.getX();
		yPrevious = e.getY();
		System.out.println(xPrevious + ", " + yPrevious);

	}

	private void drawPanelMouseReleased(MouseEvent e) {
		// if left or right button is released, connect last point
		if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
			Line2D.Double myLine = new Line2D.Double(xPrevious, yPrevious, e.getX(), e.getY());

		}

	}

	private void colorMousePressed(MouseEvent e) {
		// Decide which color was selected and which button was used
		Component clickedColor = e.getComponent();

		if (e.getButton() == MouseEvent.BUTTON1) {
			leftColor = clickedColor.getBackground();
			leftColorLabel.setBackground(leftColor);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightColor = clickedColor.getBackground();
			rightColorLabel.setBackground(rightColor);
		}

	} // end of colorMousePressed
} // end of class MouseDraw