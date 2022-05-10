package assessedExercise1ADS;

public class Part2 extends Part1 {
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
	public int[] INSERTIONSORT(int[] inputArray) {
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
	
	/*
	 * @param A - array to be sorted
	 * @param p - start index of the array
	 * @param r - end index of the array
	 * @param k - the cutoff value after which we user the insertion sort
	 * 
	 * The quick sort with insertion sort is like first the quick sort
	 * sort the small sizes of arrays in the big array. Then we use 
	 * insertion sort to sort those tiny arrays as if is faster and more
	 * efficient to sort the small arrays.
	 * 
	 * @return the almost sorted array
	 */
	public int[] QUICKSORTHYBRID(int[] A, int p, int r,int k) {
		if(p<r) {
			int q = PARTITION(A, p, r);
			if(r-1-p>=k)
				QUICKSORTHYBRID(A, p, q-1,k);
			if(r-1-p>=k)
				QUICKSORTHYBRID(A, q+1, r,k);
			}
		return A;	
		}
		
	
	/*
	 * @param A - array to be sorted
	 * 
	 * This method calls the quicksorthybrid method to get an almost 
	 * sorted array, further we use insertion sort to sort the array.
	 * Making it much faster since now only elements in the small arrays
	 * are left unsorted. The entire arrays of virtual small arrays are 
	 * all sorted.
	 * 
	 * @return sorted array.
	 */
	public int[] quickSort(int[] A) {
		int [] almostDone = QUICKSORTHYBRID(A, 0, A.length-1,75);
		return INSERTIONSORT(almostDone);
	}
}
