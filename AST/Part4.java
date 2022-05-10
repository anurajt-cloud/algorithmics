package assessedExercise1ADS;

public class Part4 extends Part1{
	
	/*
	 * @param A - array to be sorted
	 * @param p - start index of the array
	 * @param r - end index of the array
	 * 
	 * The method recursively sorts the array provided, the
	 * first recursive call sorts the left sub-array and the 
	 * second recursive call sorts the right sub-array. The 
	 * NewPointer array contains the current ltI and gtI indexes.
	 * The terminating condition for this recursive function is 
	 * when r becomes less than or equal to p.
	 * 
	 * @return sorted array
	 */
	public int[] quicksort(int[] A,int p,int r) {
		if(r<=p) {
			return A;
		}
		
		int[] NewPointer = partition(A, p, r);
		quicksort(A, p, NewPointer[0]-1);
		quicksort(A, NewPointer[1]+1, r);
		return A;
	}
	
	/*
	 * @param A - array to be sorted
	 * @param p - start index of the array
	 * @param r - end index of the array
	 * 
	 * Here we choose the pivot to be the value at the left
	 * most index. The ltI and gtI are index to the regions 
	 * that contain all the value less than and greater than 
	 * the pivot value. The i index marks the index from where
	 * all the values are equal to our pivot. Hence the array gets
	 * divided into three parts the first being [p...ltI-1] which contains
	 * all the values less than our pivot value, [gtI+1...r] which contains
	 * all the values greater than our pivot value and [ltI...gtI] which contain 
	 * all the values equal to the pivot value.
	 * 
	 * @return list containing the ltI and gtI indexes.
	 */
	public int[] partition(int[] A,int p,int r) {
		int ltI = p,gtI = r,pivot=A[p],i=p;
		while(i<=gtI) {
			if(A[i]<pivot) {
				SWAP(A, ltI, i);
				ltI++;
				i++;
			}
			else if(A[i]> pivot) {
				SWAP(A, i, gtI);
				gtI--;
			}
			else {
				i++;
			}
		}
		return new int[] {ltI,gtI};
	}
	
	/*
	 * The wrapper function for the 3 way quick sort.
	 */
	public int[] quickSort(int[] A) {
		return quicksort(A, 0, A.length-1);
	}
	
}
