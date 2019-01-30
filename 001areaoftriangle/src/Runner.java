import javax.swing.JOptionPane;
public class Runner {
	
	/***********************
	 * Circle: input r, calculate circumference, area
	 * Rectangle: input side A, B, calculate perimeter, area, and diagonal
	 * Triangle: Input sides A, B, C, calculate perimeter, area, all angles
	 * Cuboid: Input sides A, B, C, calculate volume, total surface area
	 * Sphere: Input radius, calculate volume, and surface area
	 * TOTAL celebration dance for tons of great Java
	 */
	
	public static void main(String[] args) {
		
		
		// Instantiate each class
		
		Triangle myTriangle = new Triangle();
		Circle myCircle = new Circle();
		Rectangle myRectangle = new Rectangle();
		Cuboid myCuboid = new Cuboid();
		Sphere mySphere = new Sphere();
		
		JOptionPane.showMessageDialog(null, "Gabe W. - P3A - 9/14/18 ");
		
		int goAgain = 1;
		
		while(goAgain == 1) {
		String msg = "Please enter your selection: Triangle, Circle, Rectangle, Cuboid, Sphere";
		String answer = JOptionPane.showInputDialog(msg);
		JOptionPane.showMessageDialog(null, answer);
		
		// When comparing strings, == is unreliable - do not use ==
		// Instead, use String class methods .equals
		
		if(answer.equals("Triangle") || (answer.equals("triangle"))) {
			JOptionPane.showMessageDialog(null, "YES! We are in Triangle!");
			myTriangle.setVarsToZero();
			myTriangle.setSides();;
			myTriangle.calcPerimeter();
			myTriangle.calcArea();
			myTriangle.showVars();
			myTriangle.calcAndShowAngles();
		}
		
		else if(answer.equals("Circle") || (answer.equals("circle"))) {
			JOptionPane.showMessageDialog(null, "YES! We are in Circle!");
			myCircle.setVarsToZero();
			myCircle.setRadius();
			myCircle.calcCircumference();
			myCircle.calcArea();
			myCircle.showVars();
		}
		
		else if(answer.equals("Rectangle") || (answer.equals("rectangle"))) {
			JOptionPane.showMessageDialog(null, "YES! We are in Rectangle!");
			myRectangle.setVarsToZero();
			myRectangle.setSides();
			myRectangle.calcPerimeter();
			myRectangle.calcArea();
			myRectangle.calcDiagonal();
			myRectangle.showVars();
			
		}
		
		else if(answer.equals("Cuboid") || (answer.equals("cuboid"))) {
			JOptionPane.showMessageDialog(null, "YES! We are in Cuboid!");
			myCuboid.setVarsToZero();
			myCuboid.setSides();
			myCuboid.calcVolume();
			myCuboid.calcSurfaceArea();
			myCuboid.showVars();
		}
		
		else if(answer.equals("Sphere") || (answer.equals("sphere"))) {
			JOptionPane.showMessageDialog(null, "YES! We are in Sphere!");
			mySphere.setVarsToZero();
			mySphere.setRadius();
			mySphere.calcVolume();
			mySphere.calcSurfaceArea();
			mySphere.showVars();
		}
		
		else {
			JOptionPane.showMessageDialog(null, "YIKES! I do not know what you ask");
		}
		
		msg = "Would you like to go again (Y/N)";
		answer = JOptionPane.showInputDialog(msg);
		JOptionPane.showMessageDialog(null, answer);
		
		if (answer.equals("Y") || answer.equals("y") || answer.equals("Yes") || answer.equals("yes")) {
			goAgain = 1;
		}
		
		else {
			goAgain = 0;
		}
		
		} // end of while loop
		
	} //end of main
	
}// end of runner