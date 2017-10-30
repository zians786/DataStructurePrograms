package com.bridgeit.programs;

import java.util.Scanner;


import com.bridgeit.utility.LinkedListUtility;
import com.bridgeit.utility.Utility;

public class PrimeAnagram2D {

	public static void main(String[] args) {
		Utility util = new Utility();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Range Of Prime Number from 0 to...");
		int range = scanner.nextInt();
		int[] values = new int[range - 1];
		for (int i = 0; i < range - 1; i++) {
			values[i] = i;
		}
		int[] prime = util.prime(values);
		String str = "";
		for (int i = 0; i < prime.length; i++) {
			str = str + Integer.toString(prime[i]) + " ";
		}
		String[] strArray = str.split(" ");
		String anagram="";
		for (int i = 0; i < strArray.length; i++) {
			for (int j = i + 1; j < strArray.length; j++) {
				if (util.anagram(strArray[i], strArray[j])) {
					if (strArray[i].equals(strArray[j])) {

					} else {
						// System.out.print(" " + strArray[i] + " " +
						// strArray[j]);
						anagram+=strArray[i]+" "+strArray[j]+" ";
						}
				}
			}
		}
		String[] anagramString=anagram.split(" ");
		int[] anagramArray=new int[anagramString.length];
		for(int i=0;i<anagramArray.length;i++){
			anagramArray[i]=Integer.parseInt(anagramString[i]);
		}
		util.bubbleSort(anagramArray);
		anagramArray=util.removeDuplicate(anagramArray);
		
		
		int[][] prime2D = new int[10][100];
		int i = 0, k = 0, temp = 100;
		while (k < anagramArray.length) {
			int j = 0;
			while (k < anagramArray.length && anagramArray[k] < temp) {
				prime2D[i][j++] = anagramArray[k++];
			}	
			temp += 100;
			i++;
		
		}
		for (int y = 0; y < 10; y++) {
			for (int z = 0; z < 100; z++) {
				if (prime2D[y][z] != 0) {
					System.out.print(prime2D[y][z] + "  ");
				}
			}
			System.out.println();
		}


	}

	}
