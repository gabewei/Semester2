import javax.swing.JOptionPane;

public class Cuboid {

	// class variables go here
	private double sideA, sideB, sideC;
	private double volume;
	private double surfaceArea;

	// constructor goes here
	public Cuboid() {

	}

	// methods go here

	public void setVarsToZero() {

		sideA = 0.0;
		sideB = 0.0;
		sideC = 0.0;

	} // end of setVarsToZero

	
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

	public void calcVolume() {
		volume = (sideA * sideB * sideC);
		
	}
	public void calcSurfaceArea() {
		surfaceArea = 2.0 * ((sideA * sideB) + (sideB * sideC) + (sideC * sideA));
		
	}
	
	public void showVars() {
		
		String msg = "side A = " + sideA + ", " + "side B = " + sideB + ", " + "side C = " + sideC + ", " + "volume = " + volume + ", " + "surface area = " + surfaceArea;
		JOptionPane.showMessageDialog(null, msg);
		
	} // end of showVars

} // end of class