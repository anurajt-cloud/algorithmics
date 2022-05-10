package assessedExercise1ADS;

import java.util.Arrays;

public class MergeSort {
	// Merge Algorithm
	public static void MERGE(int[] A, int p, int q, int r) {
		int n1 = q - p + 1, n2 = r - q;
		
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		for(int i=0; i<n1 ; i++) 
			L[i] = A[i];
		for(int j=0; j<n2 ; j++) 
			R[j] = A[q+1+j];
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i=0,j=0;
		
		for(int k=p; k<=r ;k++) {
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i+=1;
			}
			else {
				A[k] = R[j];
				j+=1;
			}
		}
	}
	
	public static int[] MERGESORT(int[] A, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			MERGESORT(A, p, q);
			MERGESORT(A, q+1, r);
			MERGE(A, p, q, r);
		}
		return A;
	}
	
	public int[] mergeSort(int[] A) {
		return MERGESORT(A, 0, A.length-1);
	}
	
	public static void main(String[] arg) {
		int[] A = {8,6,7,3,5,1,2,4,9,0};
		System.out.println(Arrays.toString(MERGESORT(A, 0, 9)));
	}

}
