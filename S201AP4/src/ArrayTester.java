import java.util.Arrays;

public class ArrayTester {

	public static int[] getColumn(int[][] arr2D, int c) {
		int[] result = new int[arr2D.length];

		for (int r = 0; r < arr2D.length; r++) {
			result[r] = arr2D[r][c];
		}
		return result;
	}

	public static boolean isLatin(int[][] square) {
		if (containsDuplicates(square[0])) {
			return false;
		}

		for (int r = 1; r < square.length; r++) {

			if (!hasAllValues(square[0], square[r])) {
				return false;
			}
		}

		for (int c = 0; c < square[0].length; c++) {

			if (!hasAllValues(square[0], getColumn(square, c))) {
				return false;
			}
		}
		return true;

	}

	private static boolean hasAllValues(int[] arr1, int[] arr2) {

		return false;
	}

	private static boolean containsDuplicates(int[] arr) {
		boolean duplicate = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					duplicate = true;
				}
			}
		}
		return duplicate;
	}

	public static void main(String[] args) {
		int[][] arr2D = {	{ 0, 1, 2},
							{ 3, 4, 5},
							{ 6, 7, 8},
							{ 9, 5, 3} };
		int[] result = ArrayTester.getColumn(arr2D, 1);
		System.out.println(Arrays.toString(result));
		}

	}


