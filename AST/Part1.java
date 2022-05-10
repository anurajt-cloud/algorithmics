package assessedExercise1ADS;

public class Part1 {
	/*
	 * @param p - start index of the array A
	 * @param r - end index of the array
	 * @param A - array to be sorted
	 * 
	 * The function uses the above parameters to divide the
	 * array into two half's where the first part contains 
	 * all the elements less than the pivot x, and second half
	 * contains all the values greater than the value at pivot x.
	 * The pivot is selected to be the right most index.
	 * 
	 * @return returns the index of the pivot.
	 */
	public int PARTITION(int[] A, int p, int r) {
		int x = A[r], i = p-1;
		for(int j=p; j<=r-1; j++) {
			if(A[j] <= x) {
				i++;
				SWAP(A, i, j);
			}
		}
		SWAP(A,i+1,r);
		return i+1;
	}
	
	/*
	 * @param A - array to be sorted
	 * @param p - start index of the array
	 * @param r - end index of the array 
	 * 
	 * This method uses two recursive calls to itself to sort
	 * each of the sub-arrays. Finally returns the sorted array.
	 * 
	 * @return - the sorted array.
	 */
	public int[] QUICKSORT(int[] A, int p, int r) {
		if(p<r) {
			int q = PARTITION(A, p, r);
			QUICKSORT(A, p, q-1);
			QUICKSORT(A, q+1, r);
		}
		return A;
	}
	
	/*
	 * Wrapper method for quick sort.
	 */
	public int[] quickSort(int[] A) {
		return QUICKSORT(A, 0, A.length-1);
	}
	
	/*
	 * @param A - the array in which the elements need to be sorted.
	 * @param i - index of the element to be sorted.
	 * @param j - index of the element to be sorted.
	 * 
	 * Swaps the respective elements at i and j in the array.
	 */
	protected void SWAP(int[] A,int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
