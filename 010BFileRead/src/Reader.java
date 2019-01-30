import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	
	private static int[] array;
	private static int[] tempMergArr;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// Text file to sort
		String fileName = "/home/compsci/eclipse-workspace/textfiles/Kennedy_Cuba_Crisis.txt";

		// Temporary storage for each line of the text file
		String line;

		// String of characters and symbols to look for
		String alpha = "abcdefghijklmnopqrstuvwxyz0123456789.,:;?\"-[] ";

		// ArrayList made from all the alpha characters and symbols
		ArrayList<String> alphaList = new ArrayList<String>();

		// ArrayList made from all the lines in the text file
		ArrayList<String> aList = new ArrayList<String>();

		// ArrayList made from all the character and letter counts
		ArrayList<Integer> countList = new ArrayList<Integer>();

		// Count of unknown characters or symbols (i.e. not in alpha/alphaList)
		int unknown = 0;
		
	

		// Try/catch in case the file can't be read, error printed
		try {
			// Read the file and add each line to aList
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			if (!input.ready()) {
				throw new IOException();
			}
			while ((line = input.readLine()) != null) {
				aList.add(line);
			}

			input.close();

			// Print error if one arises
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

		// Populate counList with 0's initially and alphaList with the unsorted alpha
		// (for alpha.length())
		int alphaLen = alpha.length();
		for (int i = 0; i < alphaLen; i++) {
			countList.add(0);
			alphaList.add(Character.toString(alpha.charAt(i)));
		}

		// Iterate through each line in aList, change to lowercase, then iterate through
		// each character/symbol in the line
		int sz = aList.size();
		for (int i = 0; i < sz; i++) {
			aList.set(i, aList.get(i).toString().toLowerCase());
			int nameLen = aList.get(i).length();
			for (int j = 0; j < nameLen; j++) {
				char c = aList.get(i).charAt(j);
				if (!alpha.contains("" + c)) {
					unknown += 1;
				} else {
					int ind = alpha.indexOf(c);
					int count = countList.get(ind);
					count += 1;
					countList.set(ind, count);
				}

			}
		}
		//countList = bubbleSort(countList, alphaList);
		//countList = insertionSort(countList, alphaList);
		countList = selectionSort(countList, alphaList);
		for (int i = 0; i < alphaLen; i++) {
			System.out.println(alphaList.get(i) + "  " + countList.get(i));
		}
		System.out.println("unknown: " + unknown);

	} // end of main()

	// ArrayList Bubble Sort Method
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> countList, ArrayList<String> alphaList) {
		int i, j, temp = 0;
		String tempStr = "a";
		for (i = 0; i < countList.size() - 1; i++)
			for (j = 0; j < countList.size() - 1; j++)
				if (countList.get(j) < countList.get(j + 1)) {
					temp = countList.get(j);
					tempStr = alphaList.get(j);
					countList.set(j, countList.get(j + 1));
					alphaList.set(j, alphaList.get(j + 1));
					countList.set(j + 1, temp);
					alphaList.set(j + 1, tempStr);
				}
		return countList;
	}

	// ArrayList Insertion Sort Method
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> countList, ArrayList<String> alphaList) {
		int i, j, key, temp;
		String tempStr = "a";
		for (i = 1; i < countList.size(); i++) {
			key = countList.get(i);
			j = i - 1;
			while (j >= 0 && key > countList.get(j)) {
				temp = countList.get(j);
				tempStr = alphaList.get(j);
				countList.set(j, countList.get(j + 1));
				alphaList.set(j, alphaList.get(j + 1));
				countList.set(j + 1, temp);
				alphaList.set(j + 1, tempStr);
				j--;
			}
		}
		return countList;
	}
	
	// ArrayList Selection Sort Method
	public static ArrayList<Integer> selectionSort(ArrayList<Integer> countList, ArrayList<String> alphaList) {
		int i, j, minValue, minIndex, temp = 0;
		String tempStr = "a";
		for (i = 0; i < countList.size(); i++) {
			minValue = countList.get(i);
			minIndex = i;
			for (j = i; j < countList.size(); j++) {
				if (countList.get(j) < minValue) {
					minValue = countList.get(j);
					minIndex = j;
				}
			}
			if (minValue < countList.get(i)) {
				temp = countList.get(i);
				tempStr = alphaList.get(i);
				countList.set(i, countList.get(minIndex));
				alphaList.set(i, alphaList.get(minIndex));
				countList.set(minIndex, temp);
				alphaList.set(minIndex, tempStr);
			}
		}
		return countList;
	}

}
