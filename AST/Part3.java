package assessedExercise1ADS;


public class Part3 extends Part1 {
	/*
	 * @param A - array to be sorted
	 * @param p - start index of the array
	 * @param r - end index of the array
	 * 
	 * Get the median pivot in the end index of array A,
	 * works the same way as the partition of regular quick
	 * sort to partition the array into two sub-arrays.
	 * 
	 * @return the index of the pivot
	 */
	public int PARTITIONPART3(int[] A, int p, int r) {
		int x = selectPivot(A, p, r), i = p-1;
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
	 * @param A - Array to be sorted
	 * @param p - start index of the array
	 * @param r - end index of the array
	 * 
	 * This method recursively sorts the array in place. The 
	 * first recursive call sorts the left sub-array whereas
	 * second one sorts the right sub-array.
	 * 
	 * @return The sorted array
	 */
	public int[] QUICKSORTPART3(int[] A, int p, int r) {
		if(p<r) {
			int q = PARTITIONPART3(A, p, r);
			QUICKSORTPART3(A, p, q-1);
			QUICKSORTPART3(A, q+1, r);
		}
		
		return A;
	}
	
	/*
	 * @param A - array from which the pivot should be chosen
	 * @param p - start index of the array.
	 * @param r - end index of the array.
	 * 
	 * The method chooses the pivot as the median of the values 
	 * at the start, middle and the end indexes.
	 * 
	 * @return the pivot value chosen
	 */
	public int selectPivot(int[] A,int p,int r) {
		int middleIndex = (p+r)/2;
		if(A[p]>A[middleIndex]) {
			SWAP(A, p, middleIndex);
		}
		if(A[p]>A[r]) {
			SWAP(A, p, r);
		}
		if(A[middleIndex]>A[r]) {
			SWAP(A, middleIndex, r);
		}
		SWAP(A, middleIndex, r);
		return A[r];
	}
	
	/*
	 * Wrapper method for quickSort
	 */
	public int[] quickSort(int[] A) {
		return QUICKSORTPART3(A, 0, A.length-1);
	}
	
	/*
	 * @param length - It is the length of the bad array
	 * 
	 * makeBadArray creates an array of the size requested, 
	 * this array when run with the median quick-sort degrades
	 * it have a quadratic running time.
	 * 
	 * @return Bad array
	 */
	public int[] makeBadArray(int length) {
		int[] arr = new int[length];
		int i = -1,j = length;
		for(int k = length-1; k>=0;k--) {
			if(k%2==0) {
				i++;
				arr[i] = k;
			}
			else {
				j--;
				arr[j] = k;
			}
		}
		return arr;
	}
	
}
