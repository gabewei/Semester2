
public class FractionTester {

	public static void main(String[] args) {

		//								" " is string, ' ' is char
		Fraction myFraction = new Fraction("1/5", "2/10");
		System.out.println("Numerator 1: " + myFraction.getNumerator1() + ", Denominator 1: " + myFraction.getDenominator1());
		System.out.println("Numerator 2: " + myFraction.getNumerator2() + ", Denominator 2: " + myFraction.getDenominator2());
		myFraction.add();
		System.out.println("Sum: " + myFraction.getSum());

	}

}
