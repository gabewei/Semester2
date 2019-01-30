import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Caesar openCaesar = new Caesar();

		// first, ask if they want to encrypt or decrypt
		char answerLetter = openCaesar.encryptDecrypt();
		//JOptionPane.showMessageDialog(null, "main, returned: " + answerLetter);
		switch (answerLetter) {
		case 'E':
			JOptionPane.showMessageDialog(null, "You have chosen to encrypt");
			openCaesar.getPlainText();
			openCaesar.getKey();
			openCaesar.encrypt();
			break;

		case 'D':
			JOptionPane.showMessageDialog(null, "You have chosen to decrypt");
			openCaesar.getEncodedText();
			openCaesar.getKey();
			openCaesar.decrypt();
			break;
		}

	}

}
