import java.io.*;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OutWriteArrayList {

	public static void main(String[] args) {
		File fileName = new File("MyFriends.txt");
		ArrayList<String> aList = new ArrayList<String>();
		String friend = " ";

		while (!friend.isEmpty()) {
			friend = JOptionPane.showInputDialog("Name a friend, please.");
			if (!friend.isEmpty())
				aList.add(friend);
		}

		// Write the names of the friends to a file.
		try {
			FileWriter fw = new FileWriter(fileName);
			Writer output = new BufferedWriter(fw);
			int sz = aList.size();
			for (int i = 0; i < sz; i++) {
				output.write(aList.get(i).toString() + "\n");
			}
			output.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "I cannot create that file.");
		}
	}
	
}
