
package stats;

/**
 * Stores integer values and calculates their statistics.
 *
 * @author Abhishek Sah
 * @version 1.0
 */
public class Stats {

	private int[] numbers;
	private int count;

	/**
	 * Creates a Stats object with the specified array capacity.
	 *
	 * @param capacity initial array capacity
	 */
	public Stats(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}

		this.numbers = new int[capacity];
		this.count = 0;
	}

	/**
	 * Adds a new value to the array.
	 *
	 * @param number value to add
	 */
	public void addValue(int number) {
		if (count == numbers.length) {
			int[] newNumbers = new int[numbers.length * 2];

			System.arraycopy(numbers, 0, newNumbers, 0, count);

			numbers = newNumbers;
		}

		numbers[count] = number;
		count++;
	}

	/**
	 * Returns the maximum value.
	 *
	 * @return largest stored value
	 * @throws IllegalStateException if no values have been added
	 */
	public int getMax() {
		if (count == 0) {
			throw new IllegalStateException("No values have been added");
		}

		int max = numbers[0];

		for (int i = 1; i < count; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}

		return max;
	}

	/**
	 * Returns the minimum value.
	 *
	 * @return smallest stored value
	 * @throws IllegalStateException if no values have been added
	 */
	public int getMin() {
		if (count == 0) {
			throw new IllegalStateException("No values have been added");
		}

		int min = numbers[0];

		for (int i = 1; i < count; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}

		return min;
	}

	/**
	 * Calculates the average value.
	 *
	 * @return average of all stored values
	 * @throws IllegalStateException if no values have been added
	 */
	public double getAverage() {
		if (count == 0) {
			throw new IllegalStateException("No values have been added");
		}

		return (double) getTotal() / count;
	}

	/**
	 * Calculates the total of all stored values.
	 *
	 * @return sum of stored values
	 */
	public int getTotal() {
		int total = 0;

		for (int i = 0; i < count; i++) {
			total += numbers[i];
		}

		return total;
	}

	/**
	 * Returns the actual number of stored values.
	 *
	 * @return number of values added
	 */
	public int getCount() {
		return this.count;
	}
}
