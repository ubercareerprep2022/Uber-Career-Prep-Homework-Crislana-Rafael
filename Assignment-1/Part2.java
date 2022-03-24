//package Assignment-1;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Part2 {
    public static void main(String[] args) {
		
		
		//sample tests 1
		System.out.println(isStringPermutation("asdf", "fsda"));
		System.out.println(isStringPermutation("asdf", "fsa"));
		System.out.println(isStringPermutation("asdf", "fsax"));
		
		//sample tests 2
		ArrayList<Integer> sample = new ArrayList<>();
		for(int i = 1; i <= 5; i++) {
			sample.add(i);
		}
		
		
		pairsThatEqualSum(sample, 5);
		pairsThatEqualSum(sample, 1);
		pairsThatEqualSum(sample, 7);
	}
	
	public static boolean isStringPermutation(String one, String two) {
		//permutations of the original string should have the same string length
		Hashtable <Character, Integer> strOne = new Hashtable<>();
		Hashtable <Character, Integer> strTwo = new Hashtable<>();
		
		if (one.length() != two.length()) {
			//System.out.println("not a permutation :(");
			return false;
		}
		else {
			//after checking the same string length we can check the of each character and see if both strings have the same occurrences of each character
			for (int i = 0; i < one.length(); i++) {
				if (strOne.containsKey(one.charAt(i))) {
					strOne.put(one.charAt(i), strOne.get(one.charAt(i))+1);
				}
				else {
					strOne.put(one.charAt(i), 1);
				}
			}
			
			for (int i = 0; i < two.length(); i++) {
				if (strTwo.containsKey(two.charAt(i))) {
					strTwo.put(two.charAt(i), strTwo.get(two.charAt(i))+1);
				}
				else {
					strTwo.put(two.charAt(i), 1);
				}
			}
			//System.out.println(strOne.entrySet());
			//System.out.println(strTwo.entrySet());
			
			//we can now go through each key value pair in the first hashtable and see if the second hashtable contains the same occurrence
			//the first instance we don't see a match, we can return false
			
			Set <Character> key1 = strOne.keySet();
			Set <Character> key2 = strTwo.keySet();
			
			for (Character ch: key1) {
				if (!key2.contains(ch)) {
					//System.out.println("you did not pass the permutation check :(");
					return false;
				}
			}
			
			//now we can check if the occurrences of each character match in the first and second strings
			for (Character ch: key1) {
				if (strOne.get(ch) != strTwo.get(ch)) {
					//if the occurrences of a character are not equal they are not permutations so return false
					return false;
				}
			}
			//System.out.println("congrats you passed the permutation check :)");
			return true;
		}
		
	}

	public static ArrayList<Integer[]> pairsThatEqualSum(ArrayList <Integer> inputArray, int targetSum) {
		
		/*
		 * Solution:
		 * sort the list and use one pointer at the beginning of the list and one at the end of the list
		 * while they don't overlap check if the elements at each pointer add to the targetsum
		 * if they add to targetsum put the pair of numbers in an array and add that to the arraylist pairs
		 * 	then increment the beginning pointer by 1 and reset the end pointer to the end of list
		 * else if the sum is less than targetsum increment beginning pointer by 1
		 * else decrement the end pointer by 1
		 */
		
		Collections.sort(inputArray); //sort given list in ascending order
		
		ArrayList <Integer[]> pairs = new ArrayList<>();
		
		int firstPointer = 0;
		int secPointer = inputArray.size() - 1;
		while(firstPointer < secPointer) {
			if(inputArray.get(firstPointer) + inputArray.get(secPointer) == targetSum) {
				Integer [] pair = {inputArray.get(firstPointer), inputArray.get(secPointer)};
				pairs.add(pair);
				firstPointer++;
				secPointer = inputArray.size() - 1;
			}
			else if (inputArray.get(firstPointer) + inputArray.get(secPointer) < targetSum){
				firstPointer++;
			}
			else {
				secPointer--;
			}
			
		}
		
		//Check the output of arraylist
		/*
				for(int i = 0; i < pairs.size(); i++) {
					System.out.print(pairs.get(i)[0]);
					System.out.print(",");
					System.out.print(pairs.get(i)[1]);
					System.out.println();
				}
		*/
		return pairs;
		
		
	}

}
