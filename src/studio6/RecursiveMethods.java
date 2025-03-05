package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8 ...)
	 */
	public static double geometricSum(int n) {
		if (n <= 0) {
			return 0; // Base case: no terms means sum is 0
		}
		
		
		double sum = Math.pow(.5, n);
		return sum += geometricSum(n-1);
		// Adjusted to start from 1/2
	}

	/**
	 * Recursively draws circles upon circles
	 * 
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
	    if (radius < radiusMinimumDrawingThreshold) {
	        return; 
	    }

	    // Draw the current circle
	    StdDraw.circle(xCenter, yCenter, radius);

	    // Recursive calls for outward-growing circles, placing them at four corners
	    double newRadius = radius / 3.0;
	    circlesUponCircles(xCenter + radius, yCenter, newRadius, radiusMinimumDrawingThreshold); // Right
	    circlesUponCircles(xCenter - radius, yCenter, newRadius, radiusMinimumDrawingThreshold); // Left
	    circlesUponCircles(xCenter, yCenter + radius, newRadius, radiusMinimumDrawingThreshold); // Top
	    circlesUponCircles(xCenter, yCenter - radius, newRadius, radiusMinimumDrawingThreshold); // Bottom
	}


	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but in reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reversedArray = new int[array.length];
		reverseHelper(array, reversedArray, 0);
		return reversedArray;
	}

	private static void reverseHelper(int[] original, int[] reversed, int index) {
		if (index >= original.length) {
			return; // Base case: reached the end of the array
		}
		reversed[original.length - 1 - index] = original[index];
		reverseHelper(original, reversed, index + 1);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p; // Base case: if second number is 0, return first number
		}
		return gcd(q, p % q); // Recursive case: apply Euclidean algorithm
	}
}
