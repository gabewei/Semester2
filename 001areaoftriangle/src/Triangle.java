import javax.swing.JOptionPane;

public class Triangle {

	// class variables go here
	private double sideA, sideB, sideC;
	private double perimeter;
	private double theArea;

	// constructor goes here
	public Triangle() {

	}

	// methods go here

	public void setVarsToZero() {

		sideA = 0.0;
		sideB = 0.0;
		sideC = 0.0;
		perimeter = 0.0;
		theArea = 0.0;

	} // end of setVarsToZero

	public void showVars() {
		
		String msg = "Side A, B, C = " + sideA + ", " + sideB + ", " + sideC + "; perimeter = "
				+ perimeter + "; area = " + theArea;
		
		JOptionPane.showMessageDialog(null, msg);
		
	} // end of showVars

	public void setSides() {
		
		// Try side A, loop continues if caught (value entered that isn't a #)
		boolean a = true;
		while(a) {
			try {
				sideA = Double.parseDouble(JOptionPane.showInputDialog("Please enter the value for side A: "));
				a = false;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Enter a Number");
			}
		}
		
		// Try side B, loop continues if caught (value entered that isn't a #)
		boolean b = true;
		while(b) {
			try {
				sideB = Double.parseDouble(JOptionPane.showInputDialog("Please enter the value for side B: "));
				b = false;
			}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please Enter a Number");
			}
		}
		
		// Try side C, loop continues if caught (value entered that isn't a #)
		boolean c = true;
		while(c) {
			try {
				sideC = Double.parseDouble(JOptionPane.showInputDialog("Please enter the value for side C: "));
				c = false;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Enter a Number");
			}
		}
		
	}

	public void calcPerimeter() {
		perimeter = sideA + sideB + sideC;
		
	}

	public void calcArea() {
		double p = 0.0;
		p = (sideA + sideB + sideC)/2.0;
		theArea = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
		
	}
	
	public void calcAndShowAngles() {
		double cosA = 0.0, cosB = 0.0, cosC = 0.0, acosA = 0.0, acosB = 0.0, acosC = 0.0, acosAdeg = 0.0, acosBdeg = 0.0, acosCdeg = 0.0;
		
		// Cos, arcCos, and arcCos in deg for angle A
		
			cosA = (Math.pow(sideB, 2.0) + Math.pow(sideC, 2.0) - Math.pow(sideA, 2.0))/ (2.0 * sideB * sideC);
			acosA = Math.acos(cosA);
			acosAdeg = Math.toDegrees(acosA);
				
		// Cos, arcCos, and arcCos in deg for angle B
		
			cosB = (Math.pow(sideC, 2.0) + Math.pow(sideA, 2.0) - Math.pow(sideB, 2.0))/ (2.0 * sideC * sideA);
			acosB = Math.acos(cosB);
			acosBdeg = Math.toDegrees(acosB);;
		
		// Cos, arcCos, and arcCos in deg for angle C
		
			cosC = (Math.pow(sideA, 2.0) + Math.pow(sideB, 2.0) - Math.pow(sideC, 2.0))/ (2.0 * sideA * sideB);
			acosC = Math.acos(cosC);
			acosCdeg = Math.toDegrees(acosC);
			
			String msg = "Angle A, B, C = " + acosAdeg + ", " + acosBdeg + ", " + acosCdeg;
			JOptionPane.showMessageDialog(null, msg);
			
	}

} // end of class