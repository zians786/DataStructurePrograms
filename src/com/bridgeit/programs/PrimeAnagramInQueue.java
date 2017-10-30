package com.bridgeit.programs;

import java.util.Scanner;


import com.bridgeit.utility.LinkedListUtility;
import com.bridgeit.utility.Queue;
import com.bridgeit.utility.StackUtility;
import com.bridgeit.utility.Utility;

public class PrimeAnagramInQueue {

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
		String str = "";
		for (int i = 0; i < prime.length; i++) {
			str = str + Integer.toString(prime[i]) + " ";
		}
		System.out.println(str.toString());
		String[] strArray = str.split(" ");
		String anagram = "";
		for (int i = 0; i < strArray.length; i++) {
			for (int j = i + 1; j < strArray.length; j++) {
				if (util.anagram(strArray[i], strArray[j])) {
					if (strArray[i].equals(strArray[j])) {

					} else {

						anagram += strArray[i] + " " + strArray[j] + " ";
					}
				}
			}
		}

		String[] anagramString = anagram.split(" ");
		int[] anagramArray = new int[anagramString.length];
		for (int i = 0; i < anagramArray.length; i++) {
			anagramArray[i] = Integer.parseInt(anagramString[i]);
		}
		util.bubbleSort(anagramArray);
		anagramArray = util.removeDuplicate(anagramArray);
		for (int i : anagramArray) {
			linked.insertAtEnd(i);
		}
		System.out.println();
		linked.displayList();
		System.out.println();
		int size = linked.size();
		Queue queue = new Queue(size);
		while (!linked.isEmpty()) {
			queue.enqueue(linked.deleteAtPos(1));
		}
		System.out.println("printing Anagram from Queue -->");

		queue.display();
	}

}
