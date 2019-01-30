import javax.swing.JOptionPane;

public class Caesar {

	private String alpha = "zebracdfghijklmnopqstuvwxy0123456789.:";
	private String plainText = "";
	private String encodedText = "";
	private int key = 0;
	private String answer = "";
	private char answerLetter = 'n';
	private String msg;

	public Caesar() {


	}

	public void getPlainText() {
		msg = "Please enter the plain text message: ";
		plainText = JOptionPane.showInputDialog(msg);
		JOptionPane.showMessageDialog(null, "You have entered: " + plainText);
	}

	public void getEncodedText() {
		msg = "Please enter the encoded text message: ";
		encodedText = JOptionPane.showInputDialog(msg);
		JOptionPane.showMessageDialog(null, "You have entered: " + encodedText);
	}

	public void getKey() {
		msg = "Please enter the shift key";
		key = Integer.parseInt(JOptionPane.showInputDialog(msg));
		JOptionPane.showMessageDialog(null, "You have entered a shift key of: " + key);
	}

	public void encrypt() {
		for (int i = 0; i < plainText.length(); i++) {
			if (!alpha.contains(String.valueOf(plainText.charAt(i)))) {
				encodedText += " ";
			} else {
				encodedText += alpha.charAt((alpha.indexOf(plainText.charAt(i)) + key) % alpha.length());
			}
		}
		JOptionPane.showMessageDialog(null, encodedText);
		System.out.println(encodedText);
		
	}

	public char encryptDecrypt() {
		while (true) {
			msg = "Would you like to encrypt or decrypt a message? ";
			answer = JOptionPane.showInputDialog(msg);
			//JOptionPane.showMessageDialog(null, "Choice: " + answer);
			answerLetter = Character.toUpperCase(answer.charAt(0));
			if (answerLetter == 'E' || answerLetter == 'D') {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "I don't recognize that operator, please try again");
			}

		}
		return (answerLetter);
	}

	public void decrypt() {
		for (int i = 0; i < encodedText.length(); i++) {
			if (String.valueOf(encodedText.charAt(i)).equals(" ")) {
				plainText += " ";
			} else {
				plainText += alpha.charAt((alpha.indexOf(encodedText.charAt(i)) - key) % alpha.length());
			}
		}
		JOptionPane.showMessageDialog(null, plainText);
		System.out.println(plainText);
	}
}
