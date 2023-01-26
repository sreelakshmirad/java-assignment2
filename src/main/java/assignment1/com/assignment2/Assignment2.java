// This assignment was completed by me with no help other than that was approved by my professor. I understand that copying assignments from others to complete these question is a violation of academic integrity which can have significant consequences on my grade, my reputation and future work life.
// @author : Sreelakshmi Sreenarayanapurath Radhakrishnan - 8788732


package assignment1.com.assignment2;

public class Assignment2 {

	/**
	 * Returns true if word is a palindrome or false.
	 * 
	 * @param word
	 * @return
	 */

	static Boolean isPalindrome(String word) {

		if (word == null || word.length() < 1) {
			return false;
		}
		word = word.replaceAll("\\s", "");
		word = word.replaceAll("[^a-zA-Z0-9]", "");
		word = word.toLowerCase();
		int l = word.length();

		for (int i = 0; i <= l / 2; i++) {
			if (word.charAt(i) == word.charAt(l - 1 - i)) {
				continue;
			} else {
				return false;

			}
		}
		return true;

	}

	/**
	 * Provides the transpose of a matrix. A transposed matrix is one where that
	 * replaces the
	 * columns with the rows. So, the transpose of matrix A
	 * {{1, 2, 3}, {4, 5, 6}} is matrix A^T {{1, 4}, {2, 5}, {3, 6}}.
	 * 
	 * @param matrix
	 * @return the transposed matrix
	 * @throws MatrixException
	 */

	static int[][] transposeMatrix(int[][] matrix) throws MatrixException {

		if (matrix == null) {
			throw new MatrixException("A matrix cannot contain empty arrays or null.");
		}

		System.out.println(matrix.length);
		if ((matrix.length < 1) || (matrix[0].length < 1)) {
			throw new MatrixException("A matrix cannot contain empty arrays or null.");

		}

		int transposeMat[][] = new int[matrix[0].length][matrix.length];
		int mCount;
		mCount = matrix[0].length;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != mCount) {
				throw new MatrixException("Matrix rows must be the same length.");
			}

			for (int j = 0; j < matrix[i].length; j++) {

				transposeMat[j][i] = matrix[i][j];

			}

		}

		return transposeMat;
	}

	/**
	 * Provides the minimum value for an array.
	 * 
	 * @param array
	 * @return an integer that is the smallest value in the array.
	 */
	static int getMinValue(int[] array) {

		int min = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}

		}

		return min;
	}

	/**
	 * Provides the maximum value of an array.
	 * 
	 * @param array
	 * @return an integer that is the greatest value in the array.
	 */

	static int getMaxValue(int[] array) {

		int max = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}

		}

		return max;
	}

	/**
	 * Provide the normalized values for a list of integers from bottomOfRange to
	 * topOfRange.
	 * 
	 * Normalized values are values that are scaled across a range of values. For
	 * example, the array {1, 3, 9, 10}
	 * normalized between 0 and 10 would be {0, ~2.2223, ~8.88889, 10}. The formula
	 * for normalization is as follows:
	 * 
	 * let a = bottom of desired range.
	 * Let b = top of desired range.
	 * Let x = list vector.
	 * Let x' = given value in a list.
	 * Let n = the normalized value.
	 * 
	 * n = (b - a) (x' - min(x)) / (max(x) - min(x)) + a
	 * 
	 * A word of caution: when integers are divided, they are rounded. You will need
	 * to explore the Java
	 * documentation to uncover how to
	 * 
	 * @param values        - a list of integers to be normalized
	 * @param bottomOfRange - the lowest normalized value desired.
	 * @param topOfRange    - the highest normalized value desired.
	 * @return - a new list with the normalized values.
	 */

	static double[] normalizeBetween(int[] values, int bottomOfRange, int topOfRange) {

		double[] normalizedArray = new double[values.length];
		double n = 0;

		for (int i = 0; i < values.length; i++) {

			int x = values[i];
			double dataLow = getMinValue(values);
			double dataHigh = getMaxValue(values);
			double normalizedHigh = topOfRange;
			double normalizedLow = bottomOfRange;

			n = ((x - dataLow) / (dataHigh - dataLow)) * (normalizedHigh - normalizedLow) + normalizedLow;
			normalizedArray[i] = n;
		}

		return normalizedArray;
	}

}
