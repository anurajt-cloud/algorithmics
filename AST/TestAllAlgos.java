package assessedExercise1ADS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestAllAlgos {
	public int[] readFile(String file) {
		String fileName = "./Files/"+file;
		//System.out.println(fileName);
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
	
	public void testPart1(String filename) {
		int[] testArray = this.readFile(filename);
		Part1 runner = new Part1();
		
		boolean check = false;
		
		double StartTime = System.nanoTime();
		int[] newArray = runner.quickSort(testArray);
		double FinalTime = System.nanoTime ()-StartTime;
		
		check = this.TestSortAlgorithm(newArray);
		
		System.out.println(filename+": "+FinalTime+" nanoseconds | "+"Sort Status: "+check);
	}
	
	public void testPart2(String filename) {
		int[] testArray = this.readFile(filename);
		Part2 runner = new Part2();
		
		boolean check = false;
		
		double StartTime = System.nanoTime();
		int[] newArray = runner.quickSort(testArray);
		double FinalTime = System.nanoTime()-StartTime;
		
		check = this.TestSortAlgorithm(newArray);
		
		System.out.println(filename+": "+FinalTime+" nanoseconds | "+"Sort Status: "+check);
	}
	
	public void testPart3(String filename) {
		int[] testArray = this.readFile(filename);
		Part3 runner = new Part3();
		
		boolean check = false;
		
		double StartTime = System.nanoTime();
		int[] newArray = runner.quickSort(testArray);
		double FinalTime = System.nanoTime()-StartTime;
		
		check = this.TestSortAlgorithm(newArray);
		
		System.out.println(filename+": "+FinalTime+" nanoseconds | "+"Sort Status: "+check);
	}
	public void testPart4(String filename) {
		int[] testArray = this.readFile(filename);
		Part4 runner = new Part4();
		
		boolean check = false;
		
		double StartTime = System.nanoTime();
		int[] newArray = runner.quickSort(testArray);
		double FinalTime = System.nanoTime()-StartTime;
		
		check = this.TestSortAlgorithm(newArray);
		
		System.out.println(filename+": "+FinalTime+" nanoseconds | "+"Sort Status: "+check);
	}
	
	public void mergeSortTimeTest(String filename) {
		int[] testArray = this.readFile(filename);
		MergeSort runner = new MergeSort();
		
		boolean check = false;
		
		double StartTime = System.nanoTime();
		int[] newArray = runner.mergeSort(testArray);
		double FinalTime = System.nanoTime()-StartTime;
	
		check = this.TestSortAlgorithm(newArray);
		
		System.out.println(filename+": "+FinalTime+" nanoseconds | "+"Sort Status: "+check);
	}
	
	public void insertionSortTimeTest(String filename) {
		int[] testArray = this.readFile(filename);
		Part2 runner = new Part2();
		
		boolean check = false;
		
		double StartTime = System.nanoTime();
		int[] newArray = runner.INSERTIONSORT(testArray);
		double FinalTime = System.nanoTime()-StartTime;
		
		check = this.TestSortAlgorithm(newArray);
		
		System.out.println(filename+": "+FinalTime+" nanoseconds | "+"Sort Status: "+check);
	}
	
	public boolean TestSortAlgorithm(int[] inputArray) {
		for(int i=0;i<inputArray.length-1;i++) {
			if(inputArray[i] > inputArray[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] arg) {
		String[] TestFiles = {"int10.txt","int50.txt","int100.txt","int1000.txt","int20k.txt","dutch.txt","int500k.txt","intBig.txt"};
		TestAllAlgos tester = new TestAllAlgos();
		System.out.println("__________________________________________________");
		System.out.println("QuickSort : Part 1");
		for(String s:TestFiles) {
			tester.testPart1(s);
		}
		System.out.println("__________________________________________________");
		System.out.println("QuickSort : Part 2");
		for(String s:TestFiles) {
			tester.testPart2(s);
		}
		System.out.println("__________________________________________________");
		System.out.println("QuickSort : Part 3");
		for(String s:TestFiles) {
			tester.testPart3(s);
		}
		System.out.println("__________________________________________________");
		System.out.println("QuickSort : Part 4");
		for(String s:TestFiles) {
			tester.testPart4(s);
		}
		System.out.println("__________________________________________________");
		System.out.println("Merge Sort");
		for(String s:TestFiles) {
			tester.mergeSortTimeTest(s);;
		}
		System.out.println("__________________________________________________");
		System.out.println("Insertion Sort");
		for(String s:TestFiles) {
			tester.insertionSortTimeTest(s);
		}
	}
}
