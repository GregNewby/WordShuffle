/**
 * 
 */
package com.ads;

/**
 * @author gnewby
 *
 * For a given two original words and a Shuffle*, determines whether the shuffle is
 * “legitimate” (i.e. produced correctly). The input of your program is a file “input.txt” 
 * or command line arguments , which contains 3 entries (separated by a space): two 
 * original words and the shuffle. The output of your program is a file “output.txt", 
 * which should contain either CORRECT, if the shuffle is produced correctly from two 
 * original words, or INCORRECT otherwise. 
 * 
 */
public class WordShuffle {
	
	public static boolean isLegitimate(String input) {
		String[] inputArr = input.split(" ");
		int j = 0,k = 0;
		boolean flag = true;
		for(int i = 0; i < inputArr[2].length() ; i++) {
			flag = true;
				// if j is still within the length of the first word and and the 
				// character in the joined word is == the first word  at index j
				if( j < inputArr[0].length() && inputArr[2].charAt(i) == inputArr[0].charAt(j)) {
					j++;
					continue;
				}

				// if k is still within the length of the second word and and the 
				// character in the joined word is == the second word  at index k
				else if(k < inputArr[1].length() && inputArr[2].charAt(i) == inputArr[1].charAt(k)) {
					k++;
					continue;
				}else {
					flag = false;
				}
			
			if(!flag) return false;
		}
		return true;
	}

	public static void main(String[] args) {
	
		System.out.println(isLegitimate("TOURNAMENT DINNER DINTOUR"));
	}

}
