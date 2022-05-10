package assessedExercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DR {

	public DR() {
	}
	
	/*
	 * Method used to read in integer values from the file and put them into an integer array.
	 * 
	 * @param file - name of the file containing the integers.
	 * 
	 * @returns An integer array containing the numbers.
	 */
	public int[] readFile(String file) {
		String fileName = "./Files/"+file;
		List<String> tesArray = new ArrayList<String>();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while((line = reader.readLine()) != null) {
				tesArray.add(line);
			}
			reader.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		// Converting the array to an integer.
		int[] testArray = new int[tesArray.size()];
		for(int i = 0; i<tesArray.size() ; i++ ) {
			testArray[i] = Integer.parseInt(tesArray.get(i));
		}
		
		return testArray;
	}
	
	/*
	 * Method used to generate a binary search tree containing the integer values.
	 * 
	 * @param intArray - Array of integers.
	 * 
	 * @returns A BST containing the integer values.
	 */
	public BST createBST(int[] intArray) {
		BST newTree = new BST();
		for(int val: intArray) {
			newTree.add(val);
		}
		return newTree;
	}
	
	/*
	 * Method used to generate a doubly linked list containing integer values.
	 * 
	 * @param intArray - Array of integers
	 * 
	 * @returns A doubly linked list with integer.
	 */
	public DoublyLinkedList createList(int[] intArray) {
		DoublyLinkedList newList = new DoublyLinkedList();
		for(int val:intArray) {
			newList.add(val);
		}
		return newList;
	}
	
	/*
	 * Method used to produce random numbers between a range.
	 * 
	 * @param min - Lowest value in range
	 * @param max - Highest value in the range
	 * 
	 * @returns A random integer value.
	 */
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int random = rand.nextInt((max-min)+1)+min;
		return random;
	}

	public static void main(String[] arg) {
		
		DR run = new DR();
		// Array containing the 20k numbers
		int[] testArray = run.readFile("int20k.txt");
		// Adding the values into the BST
		BST testBST = run.createBST(testArray);
		// Adding the values into the doubly linked list
		DoublyLinkedList testList = run.createList(testArray);
		
		// Generating random numbers
		int[] randomValues = new int[100];
		for(int i=0; i<100;i++) {
			randomValues[i] = randInt(0, 49999);
		}
		// Sum of times for 100 elements to be searched in the ADTs
		double sumTimeBST = 0;
		double sumTimeList = 0;
		
		for(int val:randomValues) {
			// Time taken for the search in BST
			double startTime = System.nanoTime();
			testBST.isElement(val);
			double endTime = System.nanoTime();
			sumTimeBST += (endTime-startTime);
			// Time taken for the search in list
			double startTimea = System.nanoTime();
			testList.search(val);
			double endTimea = System.nanoTime();
			sumTimeList += (endTimea-startTimea);
		}
		// Calculating the average time for the search
		double averageTimeBST = sumTimeBST/100;
		double averageTimeList = sumTimeList/100;
		// Printing out the details
		System.out.println("Average time for BST: "+averageTimeBST+" nanoseconds");
		System.out.println("Average time for List: "+averageTimeList+" nanoseconds");
		System.out.println("Tree Height:"+testBST.setSize()+ " List Size: "+testList.setSize());
		System.out.println("Tree Height: "+testBST.getHeight(testBST.root));
	}
	
	
}
