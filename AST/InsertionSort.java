package assessedExercise1ADS;

public class InsertionSort {
	/*
	 * @param A - array to be sorted
	 * 
	 * We start from the first index and move towards right.
	 * The array on the left of the j counter is sorted and 
	 * the one on the right is unsorted. Every value on the
	 * right is compared to the every element in the sorted
	 * array until the its correct position is found.
	 * 
	 * @ return sorted array.
	 */
	public int[] insertionSort(int[] inputArray) {
		int key,i;
		for(int j =1; j<= inputArray.length-1; j++) {
			key = inputArray[j];
			i =  j-1;
			while(i>=0 && inputArray[i] > key) {
				inputArray[i+1] = inputArray[i];
				i--;
			}
			inputArray[i+1] = key;
		}
		return inputArray;
	}
}
