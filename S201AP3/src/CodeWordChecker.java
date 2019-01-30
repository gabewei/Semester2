/**
 * These are 2 AP points (public class CodeWordChecker implements StringChecker and declares private instance variables)
 * @author Gabriel W.
 */
public class CodeWordChecker implements StringChecker {

	private int minLength;
	private int maxLength;
	private String notAllowed;
	
	/** These are two AP points (declares header and initializes instance variables with 3 parameters)
	 * @param minLen
	 * @param maxLen
	 * @param symbol
	 */
	public CodeWordChecker(int minLen, int maxLen, String symbol) {

		minLength = minLen;
		maxLength = maxLen;
		notAllowed = symbol;

	}

	/** This is one AP point (declares header and initializes instance variables with 1 parameters)
	 * @param symbol
	 */
	public CodeWordChecker(String symbol) {

		minLength = 6;
		maxLength = 20;
		notAllowed = symbol;

	}

/** These are 4 AP points (declares header, checks length, checks for unwanted string, returns true or false)
 * @param str
 */
	public boolean isValid(String str) {

		return str.length() >= minLength && str.length() <= maxLength && str.indexOf(notAllowed) == -1;

	}

/** Checks use cases in main()
 * @param args
 */
	public static void main(String[] args) {
		StringChecker sc1 = new CodeWordChecker(5, 8, "$");
		System.out.println(sc1.isValid("happy"));
		System.out.println(sc1.isValid("happy$"));
		System.out.println(sc1.isValid("Code"));
		System.out.println(sc1.isValid("happyCode"));
		
		StringChecker sc2 = new CodeWordChecker("pass");
		System.out.println(sc2.isValid("MyPass"));
		System.out.println(sc2.isValid("Mypassport"));
		System.out.println(sc2.isValid("happy"));
		System.out.println(sc2.isValid("1,000,000,000,000,000"));
	}
}
