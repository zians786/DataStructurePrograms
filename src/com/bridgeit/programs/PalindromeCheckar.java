package com.bridgeit.programs;

import java.util.Arrays;

import java.util.Scanner;

import com.bridgeit.utility.Deque;

public class PalindromeCheckar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string to check Palindrome..");
		String string = scanner.nextLine();
		char[] data = string.toCharArray();
		checkPalindrome(data);

		
	}

	public static void checkPalindrome(char[] word) {
		char[] reverse=new char[word.length];
		Deque deque = new Deque();
		for (char c : word) {
			deque.insertAtFront(c);
		}
		deque.display();
		
		for(int i=0;i<reverse.length;i++){
			reverse[i]=(char)deque.removeAtFront();
		}
		if (Arrays.equals(word, reverse)) {
			System.out.println("Entered string is Palindrome..");
		}else{
			System.out.println("Entered string is not Palindrome..");
		}
	}

}
