import javax.swing.JOptionPane;

public class Rectangle {

	// class variables go here
	private double sideA, sideB;
	private double perimeter;
	private double area;
	private double diagonal;

	// constructor goes here
	public Rectangle() {

	}

	// methods go here

	public void setVarsToZero() {
		sideA = 0.0;
		sideB = 0.0;
		perimeter = 0.0;
		area = 0.0;
		diagonal = 0.0;

	} // end of setVarsToZero

	
	public void setSides() {
		boolean a = true;
		while(a) {
			try {
				sideA = Double.parseDouble(JOptionPane.showInputDialog("Please enter the value for side A: "));
				a = false;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Enter a Number");
			}
		}
		boolean b = true;
		while(b) {
			try {
				sideB = Double.parseDouble(JOptionPane.showInputDialog("Please enter the value for side B: "));
				b = false;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Enter a Number");
			}
		}
	}

	public void calcPerimeter() {
		perimeter = (2.0 * (sideA + sideB));
		
	}
	public void calcArea() {
		area = (sideA * sideB);
		
	}
	public void calcDiagonal() {
		double cSquared = (Math.pow(sideA, 2.0) + Math.pow(sideB, 2.0));
		diagonal = (Math.sqrt(cSquared));
	}
	
	public void showVars() {
		
		String msg = "side A = " + sideA + ", " + "side B = " + sideB + ", " + "perimeter = " + perimeter + ", " + "area = " + area + ", " + "diagonal = " + diagonal;
		JOptionPane.showMessageDialog(null, msg);
		
	} // end of showVars

} // end of class