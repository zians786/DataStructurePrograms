package com.bridgeit.programs;

import java.util.Scanner;


import com.bridgeit.utility.LinkedListUtility;
import com.bridgeit.utility.Utility;

public class PrimeInRange {

	public static void main(String[] args) throws Exception {
		Utility util = new Utility();
		LinkedListUtility linked = new LinkedListUtility();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Range Of Prime Number from 0 to...");
		int range = scanner.nextInt();
		int[] values = new int[range - 1];
		for (int i = 0; i < range - 1; i++) {
			values[i] = i;
		}
		int[] prime = util.prime(values);
		int[][] prime2D = new int[10][50];
		int i = 0, k = 0, temp = 100;
		while (k < prime.length) {
			int j = 0;
			while (k < prime.length && prime[k] < temp) {
				prime2D[i][j++] = prime[k++];
			}
			temp += 100;
			i++;
		}
		for (int y = 0; y < 10; y++) {
			for (int z = 0; z < 25; z++) {
				if (prime2D[y][z] != 0) {
					System.out.print(prime2D[y][z] + "  ");
				}
			}
			System.out.println();
		}

	}

}
