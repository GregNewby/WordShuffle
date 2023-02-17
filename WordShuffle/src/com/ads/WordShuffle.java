/**
 * 
 */
package com.ads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
	
			if(args.length > 0) {
				
			String data = null;
			
				try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));FileWriter fw = new FileWriter("output.txt");){
					
					if(args.length == 1) {					//PATH IF FILE NAME IS ENTERED AT CLI
						
						data = reader.readLine();
						while(reader.readLine() != null) {
							data.concat(reader.readLine());
						}
						
						String outToFile = new Boolean(isLegitimate(data)).toString();
						fw.write(outToFile);
							
					} else if (args.length == 3) {			//PATH IF THREE ENTRIES ARE ENTERED AT CLI
						String input = args[0] + " " + args[1] + " " + args[2];
						
						System.out.println(isLegitimate(input));
						
						String outToFile = new Boolean(isLegitimate(input)).toString();
						fw.write(outToFile);						
						
					} else {		//ERROR MESSAGE/INSTRUCTIONS
						System.out.println("When running the program enter either the input file name as a command line argument or "
								+ "three entries seperated by spaces to check if they are a legitimate shuffle group");
					}
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}	
			} else {
				System.out.println("When running the program enter either the input file name as a command line argument or "
						+ "three entries seperated by spaces to check if they are a legitimate shuffle group");
			}
	}

}
