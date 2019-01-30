import javax.swing.JOptionPane;

public class Sphere {

	// class variables go here
	private double radius;
	private double volume;
	private double surfaceArea;

	// constructor goes here
	public Sphere() {

	}

	// methods go here

	public void setVarsToZero() {

		radius = 0.0;

	} // end of setVarsToZero

	
	public void setRadius() {
		
		boolean r = true;
		while(r) {
			try {
				radius = Double.parseDouble(JOptionPane.showInputDialog("Please enter the value of the radius: "));
				r = false;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Enter a Number");
			}
		}
	}

	public void calcVolume() {
		volume = ((4.0 * (Math.PI) * (Math.pow(radius, 3.0)))/3.0);
		
	}
	public void calcSurfaceArea() {
		surfaceArea = (4.0 * (Math.PI) * (Math.pow(radius, 2.0)));
		
	}
	
	public void showVars() {
		
		String msg = "radius = " + radius + ", " + "volume = " + volume + ", " + "surface area = " + surfaceArea;
		JOptionPane.showMessageDialog(null, msg);
		
	} // end of showVars

} // end of class