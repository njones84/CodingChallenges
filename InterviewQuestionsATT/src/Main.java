import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		
		List<List<Integer>> highestSumList = new ArrayList<List<Integer>>();
		highestSumList.add(Arrays.asList(1, 0, 0, 0));
		highestSumList.add(Arrays.asList(2, 5, 0, 0));
		highestSumList.add(Arrays.asList(3, 2, 1, 0));
		highestSumList.add(Arrays.asList(1, 3, 2, 1));
		highestSumList.add(Arrays.asList(1, 3, 2, 20));

		// funny sort test case
		System.out.println("FUNNY SORT TEST CASES");
		System.out.println("Expected result: [19, 12, 1, 2, 8, 7, 3, 5]");
		System.out.println("Result: " + funnySort(new ArrayList<Integer>() {
			{
				add(1);
				add(7);
				add(2);
				add(3);
				add(19);
				add(5);
				add(8);
				add(12);
			}
		}).toString());
		System.out.println("Expected result: [9999999, 43, -4, 1, 34, 8, 3, 5]");
		System.out.println("Result: " + funnySort(new ArrayList<Integer>() {
			{
				add(5);
				add(3);
				add(1);
				add(8);
				add(43);
				add(9999999);
				add(-4);
				add(34);
			}
		}).toString());
		System.out.println("Expected result: [123492314, 91293, -1, 0, 63456, 23432, 1324, 2342]");
		System.out.println("Result: " + funnySort(new ArrayList<Integer>() {
			{
				add(2342);
				add(63456);
				add(123492314);
				add(91293);
				add(0);
				add(-1);
				add(23432);
				add(1324);
			}
		}).toString());
		System.out.println("Expected result: [-1, -3, -949, -393, -5, -34, -234, -98]");
		System.out.println("Result: " + funnySort(new ArrayList<Integer>() {
			{
				add(-234);
				add(-3);
				add(-949);
				add(-34);
				add(-393);
				add(-1);
				add(-5);
				add(-98);
			}
		}).toString());
		
		System.out.println("");
		
		// distant odd numbers test case
		System.out.println("DISTANT ODD NUMBERS TEST CASES");
		System.out.println("Expected Result: WILL VARY");
		System.out.println("Result: " + distantODDNumbers(new ArrayList<Integer>() {
			{
				add(4);
				add(3);
				add(5);
				add(2);
				add(3);
				add(8);
				add(9);
				add(4);
				add(2);
				add(8);
				add(7);
				add(5);
				add(11);
				add(42);
				add(6);
				add(0);
			}
		}).toString());
		System.out.println("Expected Result: WILL VARY");
		System.out.println("Result: " + distantODDNumbers(new ArrayList<Integer>() {
			{
				add(2);
				add(6);
				add(1);
				add(9);
				add(6);
				add(23);
				add(12);
				add(9);
				add(8);
				add(4);
				add(2);
				add(0);
				add(11);
				add(53);
				add(2);
				add(1);
			}
		}).toString());
		System.out.println("Expected Result: WILL VARY");
		System.out.println("Result: " + distantODDNumbers(new ArrayList<Integer>() {
			{
				add(9);
				add(2);
				add(1);
				add(94);
				add(45);
				add(74);
				add(1);
				add(5);
				add(6);
				add(87);
				add(1);
				add(3);
				add(89);
				add(32);
				add(21);
				add(9);
			}
		}).toString());
		System.out.println("Expected Result: WILL VARY");
		System.out.println("Result: " + distantODDNumbers(new ArrayList<Integer>() {
			{
				add(5);
				add(64);
				add(49);
				add(34);
				add(2);
				add(1);
				add(8);
				add(9);
				add(5);
				add(435);
				add(123);
				add(56);
				add(123);
				add(563);
				add(9);
				add(1);
			}
		}).toString());
		
		System.out.println("");
		
		// anagram test case
		System.out.println("ANAGRAM TEST CASES");
		System.out.println("Expected result: true");
		System.out.println(isAnagram("yyby", "zzzc", -1));
		System.out.println("Expected result: true");
		System.out.println(isAnagram("Jonathan Smith", "Mith Than Jonas", 0));
		System.out.println("Expected result: false");
		System.out.println(isAnagram("racecar", "notaracecar", 4));
		System.out.println("Expected result: false");
		System.out.println(isAnagram("Nicolas Jones", "Nic0las Jones", 0));
		System.out.println("Expected result: true");
		System.out.println(isAnagram("wwby", "ayyd", -2));
		
		System.out.println("");
		
		// highest sum in list test case
		System.out.println(highestSumList(highestSumList).toString());
		
		System.out.println("");
		
		// primes test case
		System.out.println("PRIMES TEST CASES");
		System.out.println("Expected result: 2 + 7");
		System.out.println("Result: " + sumOfPrimes(9));
		System.out.println("Expected result: 13");
		System.out.println("Result: " + sumOfPrimes(13));
		System.out.println("Expected result: 2 + 19");
		System.out.println("Result: " + sumOfPrimes(21));
		System.out.println("Expected result: 2 + 3 + 79");
		System.out.println("Result: " + sumOfPrimes(84));
		System.out.println("Expected result: 3 + 19 + 829");
		System.out.println("Result: " + sumOfPrimes(851));

	}

	// TIME COMPLEXITY OF THIS METHOD IS O(n^2) where n = list length
	public static List<Integer> funnySort(List<Integer> unsorted) {

		List<Integer> sorted = new ArrayList<Integer>();
		int length = unsorted.size();
		int l = 1;
		int s = 0;

		// finished sort order should be: largest, 2nd largest, smallest, 2nd smallest, 3rd largest, 4th largest, 3rd smallest, 4th smallest
		// length = n; n-1, n-2, n-(n-0), n-(n-1), n-3, n-4, n-(n-2), n-(n-3)
		// list of size 6 should be: 5, 4, 0, 1, 3, 2

		// Dynamically generate the positions needed based on the lists length
		int[] positions = new int[length];
		for (int i = 0; i < length; i++) {

			// We want to swap from beginning to the end of the list every 2 elements so we
			// do a modular operation on 4 since we have two different formulas
			if (i % 4 < 2)
				positions[i] = length - l++;
			else {
				positions[i] = length - (length - s++);
			}
		}
		
		// Do bubble sort and then just move them in the order we need them to be
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (unsorted.get(i) > unsorted.get(j)) {
					int temp = unsorted.get(i);
					unsorted.set(i, unsorted.get(j));
					unsorted.set(j, temp);
				}
			}
		}

		// Add the numbers to a new list in the desired order
		for (int x : positions)
			sorted.add(unsorted.get(x));

		return sorted;
	}

	// TIME COMPLEXITY IS O(n)
	// NOTE - The distance between 2 odd numbers may vary depending on original list size but odd numbers will never appear beside each other
	public static List<Integer> distantODDNumbers(List<Integer> original) {
		
		int minDistance = 0;
		List<Integer> oddNumbers = new ArrayList<Integer>();
		
		// Idea 1: Just loop through the list and swap numbers until no odd numbers are beside each other and then try to maximize distance
		// Idea 2: Sort the list and count the amount of odd numbers then swap based on amount of odd numbers
		// Idea 3: Find odd number, determine closest odd number, move each other away
		// THERE SHOULD ALWAYS BE A ODD NUMBER ON BOTH ENDS OF THE LIST
		// [4, 3, 5, 2, 3, 8, 9, 4, 2] -> [3, 4, 2, 5, 8, 4, 3, 2, 9]
		
		// go through list and get the positions of all odd numbers
		for (int i = 0; i < original.size(); i++)
			if (original.get(i) % 2 == 1)
				oddNumbers.add(original.remove(i--));

		// get max distance based off list size and number of odd numbers
		minDistance = (int) Math.ceil((double) original.size() / oddNumbers.size());
		int ogOddSize = oddNumbers.size();
		
		// if all numbers are odd return array immediately since they cant be distanced
		if (minDistance == 0)
			return original;
		
		// now that we have the max distance, go through the list and sort them accordingly
		for (int i = 0; i < original.size(); i+=minDistance) {
			
			if (oddNumbers.isEmpty())
				break;
			
			if (oddNumbers.size() == 1)
				original.add(original.size(), oddNumbers.remove(0));
			else if (oddNumbers.size() <= ogOddSize / 2)
				original.add(i + minDistance, oddNumbers.remove(0));
			else
				original.add(i, oddNumbers.remove(0));
			
		}
		
		return original;
	}

	// TIME COMPLEXITY OF THIS METHOD IS O(n) where n = list length
	public static boolean isAnagram(String a, String b, int x) {

		// convert both strings to character arrays
		char[] stringA = a.toLowerCase().replace(" ", "").toCharArray();
		char[] stringB = b.toLowerCase().replace(" ", "").toCharArray();
		
		// check if they have the same length, if not it is impossible to be an anagram
		if (stringA.length != stringB.length)
			return false;
		
		int count = 0;
		
		// do the character shifting
		for (int i = 0; i < stringA.length; i++) {
			char newC = stringA[i];
			
			if (x > 0)
				newC += x;
			else if (x < 0)
				newC -= x;
			
			if (newC > 'z')
				newC = 'a';
			else if (newC < 'a')
				newC = 'z';
			
			stringA[i] = newC;
			
			// char can be kept track of in the form of an integer
			count += stringA[i];
			count -= stringB[i];
		}

		// if the counter is 0, then both arrays had the same amount of letters and the same amount of specific letters
		if (count == 0)
			return true;
		else
			return false;
		
	}

	// NOT DONE - Compiles but doesn't return the highest desired sum. This is easily accomplished with more structure, I'm having a hard time visualizing my code
	// 			  since this is just a graph theory problem and is solved with a depth-first search algorithm.
	public static List<Integer> highestSumList(List<List<Integer>> matrix) {

		// IDEA 1 - Recursion
		// IDEA 2 - Graph Theory problem, use a queue
		// IDEA 3 - Loop regularly and ignore edge cases
		
		List<Integer> answer = new ArrayList<Integer>();
		
		int columnDepth = 0;
		int highestSum = 0;
		int l = matrix.size();
		int w = matrix.get(0).size();
		
		highestSum += matrix.get(0).get(0);
		
		// loop through each row and determine the highest number we can select without going backwards in the column
		for (int i = 0; i < l; i++) {
			List<Integer> innerList = matrix.get(i);
			int highestRowNumber = 0;
			for (int j = columnDepth; j < w; j++) {
				if (innerList.get(j) == 0)
					continue;
				if (i + 1 < l && j + 1 < w && j <= columnDepth + 1) {
					List<Integer> nextRow = matrix.get(i + 1);
					
					if (nextRow.get(j) < nextRow.get(j + 1)) {
						highestRowNumber = nextRow.get(j + 1);
						columnDepth = j + 1;
						answer.add(highestRowNumber);
					}
					else {
						highestRowNumber = nextRow.get(j);
						columnDepth = j;
						answer.add(highestRowNumber);
					}
				}
			}
			highestSum += highestRowNumber;
		}

		return answer;
	}

	// TIME COMPLEXITY OF THIS METHOD IS O(n) where n = number height
	public static List<Integer> sumOfPrimes(int number) {

		// IDEA 1 - Prime numbers are either n, n-2, and n-3 + x + n-x (which are also prime)
		// IDEA 2 - make a list of all prime numbers below our given number, then loop through the list
		//          of numbers and see if there are any matches between the number and the difference needed
		// IDEA 3 - Have a premade list of primes and then make the summation of the numbers based on the primes needed
		
		List<Integer> result = new ArrayList<Integer>();

		// 1st Case: check if number is prime initially
		if (checkPrime(number))
			result.add(number);
		
		// 2nd Case: check if number - 2 is prime (Example - 25 = 23 - 2)
		else if (checkPrime(number - 2)) {
			result.add(2);
			result.add(number - 2);
		}
		// 3rd Case: Subtract 3 from odd number to make it even, then do case 2 on it over and over
		else {
			number -= 3;
			result.add(3);
			for (int i = 0; i < number; i++)
				if (checkPrime(i) && checkPrime(number - i)) {
					result.add(i);
					result.add(number - i);
					break;
				}
		}
		
		return result;
	}
	
	public static boolean checkPrime(int number) {
		
		if (number == 0 || number == 1)
			return false;
		
		for (int i = 2; i * i <= number; ++i)
			if (number % i == 0)
				return false;
		
		return true;
		
	}
}
