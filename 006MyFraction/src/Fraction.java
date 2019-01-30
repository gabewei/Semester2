/**
 * Add two fractions. Learn Javadocs. Enter the two fractions as Strings then use string methods to pull our numerator and denominator
 * @author Gabe W
 *
 */
public class Fraction {

	// field
	private int numerator1;    
	/**
	 * 
	 */
	private int denominator1;
	private int numerator2;
	private int denominator2;
	private int numerator3;
	private int denominator3;
	private String sum;

	// constructor or constructor stack
	public Fraction(String passFraction1, String passFraction2) {
		int separatorLocation1 = passFraction1.indexOf("/");
		String strNumerator1 = passFraction1.substring(0, separatorLocation1);
		String strDenominator1 = passFraction1.substring(separatorLocation1 + 1);

		this.numerator1 = Integer.parseInt(strNumerator1);
		this.denominator1 = Integer.parseInt(strDenominator1);
		
		int separatorLocation2 = passFraction2.indexOf("/");
		String strNumerator2 = passFraction2.substring(0, separatorLocation2);
		String strDenominator2 = passFraction2.substring(separatorLocation2 + 1);

		this.numerator2 = Integer.parseInt(strNumerator2);
		this.denominator2 = Integer.parseInt(strDenominator2);
	}

	// methods
	public int getNumerator1() {
		return numerator1;
	}

	public void setNumerator1(int numerator1) {
		this.numerator1 = numerator1;
	}

	public int getDenominator1() {
		return denominator1;
	}

	public void setDenominator1(int denominator1) {
		this.denominator1 = denominator1;
	}
	
	public int getNumerator2() {
		return numerator2;
	}

	public void setNumerator2(int numerator2) {
		this.numerator2 = numerator2;
	}

	public int getDenominator2() {
		return denominator2;
	}

	public void setDenominator2(int denominator2) {
		this.denominator2 = denominator2;
	}
	
	public int getNumerator3() {
		return numerator3;
	}

	public void setNumerator3(int numerator3) {
		this.numerator3 = numerator3;
	}

	public int getDenominator3() {
		return denominator3;
	}

	public void setDenominator3(int denominator3) {
		this.denominator3 = denominator3;
	}
	
	public String getSum() {
		return sum;
	}
	
	public String add() {
		this.numerator3 = (numerator1 * denominator2) + (denominator1 * numerator2);
		this.denominator3 = denominator1 * denominator2;
		this.sum = Integer.toString(numerator3) + "/" + Integer.toString(denominator3);
		return sum;
	}
}
