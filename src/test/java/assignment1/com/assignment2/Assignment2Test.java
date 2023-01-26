package assignment1.com.assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class Assignment2Test {

	@Test
	void testIsPalindromeWithSimpleWord() {
		String simple = "bob";
		String camelCase = "Bob";
		String withSpaces = "able was i ere i saw elba";
		String empty = "";
		assertTrue(assignment1.com.assignment2.Assignment2.isPalindrome(simple), "isPalindrome does not work " +
				"for a simple word");
		assertTrue(assignment1.com.assignment2.Assignment2.isPalindrome(camelCase), "isPalindrome does not work for " +
				"words with mixed cases.");
		assertFalse(assignment1.com.assignment2.Assignment2.isPalindrome(empty), "isPalindrome should return false for " +
				"empty strings");
		assertFalse(assignment1.com.assignment2.Assignment2.isPalindrome(null), "isPalindrome should return false for null " +
				"values");
		assertTrue(assignment1.com.assignment2.Assignment2.isPalindrome(withSpaces), "isPalindrome does not work for " +
				"phrases or sentence palindromes");
	}
	
	
    @Test
    void testTransposeMatrix() throws MatrixException {
        String nullMessage = "A matrix cannot contain empty arrays or null.";
        String badMessage = "Matrix rows must be the same length.";

        int[][] matrixA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrixB = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] matrixATranspose = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
        int[][] matrixBTranspose = { { 1, 3, 5 }, { 2, 4, 6 } };
        int[][] badMatrixA = { {} };
        int[][] badMatrixB = { { 1, 2 }, { 3, 4, 5 }, { 6 }, { 7, 8, 9, 10 } };

        MatrixException nullThrown = Assertions.assertThrows(MatrixException.class, () -> {
            assignment1.com.assignment2.Assignment2.transposeMatrix(null);
        });
        MatrixException badThrown = Assertions.assertThrows(MatrixException.class, () -> {
            assignment1.com.assignment2.Assignment2.transposeMatrix(badMatrixA);
        });
        MatrixException badThrownB = Assertions.assertThrows(MatrixException.class, () -> {
            assignment1.com.assignment2.Assignment2.transposeMatrix(badMatrixB);
        });

        assertTrue(matrixA[0].length == assignment1.com.assignment2.Assignment2.transposeMatrix(matrixA).length,
                "Test failure " +
                        "because the transposed matrix column is not the same size as original matrix first row.");
        assertTrue(matrixA.length == assignment1.com.assignment2.Assignment2.transposeMatrix(matrixA)[0].length,
                "Test failure " +
                        "because transposed matrix row is not the same size as original matrix first column");
        assertTrue(
                Arrays.deepEquals(assignment1.com.assignment2.Assignment2.transposeMatrix(matrixA), matrixATranspose),
                "transposeMatrix" +
                        "does not work for square matrix");

        assertTrue(
                Arrays.deepEquals(assignment1.com.assignment2.Assignment2.transposeMatrix(matrixB), matrixBTranspose),
                "transposeMatrix " +
                        "does not work for n X m matrix");

        assertEquals(nullThrown.getMessage(), nullMessage);
        assertEquals(badThrown.getMessage(), nullMessage);
        assertEquals(badThrownB.getMessage(), badMessage);

    }
    
    @Test
    void testDataNormalization() {
        int[] testArray = {6, 18, 0, -6, -5, -100, 1000};
        double[] normalizedArrayA = {9.636363636363, 10.72727272727, 9.090909090909, 8.54545454545, 8.63636363636, 0.0, 100.0};
        double[] normalizedArrayB = {0.06, 0.18, 0.0, -0.06, -0.05, -1.0, 10.0};    
        double[] testRunA = assignment1.com.assignment2.Assignment2.normalizeBetween(testArray, 0, 100);
        double[] testRunB = assignment1.com.assignment2.Assignment2.normalizeBetween(testArray, -1, 10);
        assertTrue(testRunA[5] == 0, "Normalization is not working for minimum case");
        assertTrue(testRunA[6] == 100, "Normalization is not working for maximum case");
        assertTrue(testRunB[5] == -1, "normalization is not working for negative minimum value");
        for (int i=0; i < testArray.length; i++) {
            double offsetA = normalizedArrayA[i] - testRunA[i];
            double offsetB = normalizedArrayB[i] - testRunB[i];
            System.out.println(offsetA);
            assertTrue(offsetA == 0.0 || (-0.00001 <= offsetA && offsetA <= 0.0001), "A normalized value was found not to be within range.");
            assertTrue(offsetA == 0.0 || (-0.00001 <= offsetB && offsetB <= 0.0001), "A normalized value was not found to be within range");
        }
    }
	
}
