import javax.swing.JOptionPane;

public class Circle {

	// class variables go here
	private double radius;
	private double circumference;
	private double area;

	// constructor goes here
	public Circle() {

	}

	// methods go here

	public void setVarsToZero() {

		radius = 0.0;
		area = 0.0;
		circumference = 0.0;

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

	public void calcCircumference() {
		circumference = (2.0 * Math.PI * radius);
		
	}
	public void calcArea() {
		area = (Math.PI * (Math.pow(radius, 2.0)));
		
	}
	
	public void showVars() {
		String msg = "radius = " + radius + ", " + "area = " + area + ", " + "circumference = " + circumference;
		JOptionPane.showMessageDialog(null, msg);
		
	} // end of showVars

} // end of class