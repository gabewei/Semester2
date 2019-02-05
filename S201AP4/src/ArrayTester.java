import java.util.Arrays;
/**
 * 
 * @author Gabe W
 *
 */
public class ArrayTester {

	/**
	 * 4 AP Points (creates new array)
	 * @param arr2D
	 * @param c
	 * @return
	 */
	public static int[] getColumn(int[][] arr2D, int c) {
		int[] result = new int[arr2D.length];

		for (int r = 0; r < arr2D.length; r++) {
			result[r] = arr2D[r][c];
		}
		return result;
	}

	/**
	 * 5 AP Points (calls, applies, and returns)
	 * @param square
	 * @return
	 */
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
/**
 * 
 * @param arr1
 * @param arr2
 * @return
 */
	private static boolean hasAllValues(int[] arr1, int[] arr2) {
		    for (int a : arr1) {
		        if (!contains(arr2, a)) {
		            return false;
		        }
		    }
		    return true;
		    
		}
/**
 * 
 * @param list
 * @param i
 * @return
 */
	private static boolean contains(int[] list, int i) {
        for (int a : list) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }
	/**
	 * 
	 * @param arr
	 * @return
	 */
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
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		int[][] arr2D = {	{ 0, 1, 2},
							{ 3, 4, 5},
							{ 6, 7, 8},
							{ 9, 5, 3} };
		
		int[][] Latin = {	{ 1, 2, 3},
							{ 2, 3, 1},
							{ 3, 1, 2} };
						
		int[] result = ArrayTester.getColumn(arr2D, 1);
		System.out.println(isLatin(arr2D));
		System.out.println(isLatin(Latin));
		}

	}


