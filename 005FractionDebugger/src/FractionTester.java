import javax.swing.JOptionPane;

public class FractionTester {

	public static void main(String[] args) {
		
		String msg1 = "Please enter your first fraction (num/den): ";
		String answer1 = JOptionPane.showInputDialog(msg1);
		
		String msg2 = "Would you like to add, subtract, multiply, or divide?: ";
		String answer2 = JOptionPane.showInputDialog(msg2);
		
		Fraction fraction1 = new Fraction(answer1);
		Fraction[] myFractions = new Fraction[6];

		if(answer2.equals("Add") || (answer2.equals("add"))) {
			
			String msg3 = "Please enter your second fraction (num/den): ";
			String answer3 = JOptionPane.showInputDialog(msg3);
			Fraction fraction2 = new Fraction(answer3);
			
			Fraction sum = fraction1.add(fraction2);

			myFractions[0] = fraction1;
			myFractions[1] = fraction2;
			myFractions[2] = sum;

			// Print the result
			JOptionPane.showMessageDialog(null, myFractions[2].toPrettyString());
		}
		
		else if(answer2.equals("Subtract") || (answer2.equals("subtract"))) {
			
			String msg3 = "Please enter your second fraction (num/den): ";
			String answer3 = JOptionPane.showInputDialog(msg3);
			Fraction fraction2 = new Fraction(answer3);
			
			Fraction difference = fraction1.subtract(fraction2);
			
			myFractions[0] = fraction1;
			myFractions[1] = fraction2;
			myFractions[3] = difference;
	
			// Print the result
			JOptionPane.showMessageDialog(null, myFractions[3].toPrettyString());
		}
		
		else if(answer2.equals("Multiply") || (answer2.equals("multiply"))) {
			
			String msg3 = "Please enter your second fraction (num/den): ";
			String answer3 = JOptionPane.showInputDialog(msg3);
			Fraction fraction2 = new Fraction(answer3);
			
			Fraction product = fraction1.multiply(fraction2);
			
			myFractions[0] = fraction1;
			myFractions[1] = fraction2;
			myFractions[4] = product;
	
			// Print the result
			JOptionPane.showMessageDialog(null, myFractions[4].toPrettyString());
			
		}
		
		else if(answer2.equals("Divide") || (answer2.equals("divide"))) {
			
			String msg3 = "Please enter your second fraction (num/den): ";
			String answer3 = JOptionPane.showInputDialog(msg3);
			Fraction fraction2 = new Fraction(answer3);
			
			Fraction quotient = fraction1.divide(fraction2);
			
			myFractions[0] = fraction1;
			myFractions[1] = fraction2;
			myFractions[5] = quotient;
	
			// Print the result
			JOptionPane.showMessageDialog(null, myFractions[5].toPrettyString());
	
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Please re-type your selection");
		}
	}
}