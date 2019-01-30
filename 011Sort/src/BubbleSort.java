public class BubbleSort {
	public static void main(String[] args) {
		int[] list = { 5, 8, 1, 6, 9, 2 };
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		list = bubbleSort(list);
		System.out.println("");
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

	public static int[] bubbleSort(int[] list) {
		int i, j, temp = 0;
		for (i = 0; i < list.length - 1; i++)
			for (j = 0; j < list.length - 1; j++)
				if (list[j] < list[j + 1]) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
		return list;
	}
}
