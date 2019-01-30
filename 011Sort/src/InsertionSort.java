import java.util.ArrayList;
import java.util.Random;



public class InsertionSort {

	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> test = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			test.add(0);
			test.set(i, rand.nextInt(10));
		}
		System.out.println(test);
		test = insertionSort(test);
		System.out.println(test);
	}

	public static int[] insertionSort(int[] list) {
		int i, j, key, temp;
		for (i = 1; i < list.length; i++) {
			key = list[i];
			j = i - 1;
			while (j >= 0 && key < list[j]) {
				temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
				j--;
			}
		}
		return (list);
	}

	public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
		int i, j, key, temp;
		for (i = 1; i < list.size(); i++) {
			key = list.get(i);
			j = i - 1;
			while (j >= 0 && key < list.get(j)) {
				temp = list.get(j);
				list.set(j, list.get(j + 1));
				list.set(j + 1, temp);
				j--;
			}
		}
		return (list);
	}
}
