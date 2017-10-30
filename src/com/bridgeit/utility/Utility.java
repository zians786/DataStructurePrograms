package com.bridgeit.utility;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Utility {

	public static double startWatch() {
		double start = System.currentTimeMillis();
		return start;
	}

	public double elapseTime(double start) {
		double now = System.currentTimeMillis();
		return (now - start) / 1000;
	}

	public <E> void generic2DArrayDisplay(E[][] element) {
		PrintWriter writer = new PrintWriter(System.out);
		for (int i = 0; i < element.length; i++) {
			for (int j = 0; j < element.length; j++) {
				writer.print(element[i][j] + " ");
			}
			writer.println();
		}
		writer.flush();
	}

	public static double sqrt(double number) {
		double t = number;
		double epsilon = 1e-15;
		while (Math.abs(t - number / t) > t * epsilon) {
			t = (number + (t * t)) / (2 * t);
		}
		return t;
	}

	public void permutation(String pattern, int first, int last) {
		if (first == last) {
			System.out.println(pattern);
		} else {
			for (int i = first; i <= last; i++) {
				pattern = swap(pattern, first, i);
				permutation(pattern, first + 1, last);
				pattern = swap(pattern, first, i);
			}
		}
	}

	public static String swap(String pattern, int first, int last) {
		char[] copy = pattern.toCharArray();
		char temp = copy[first];
		copy[first] = copy[last];
		copy[last] = temp;

		return String.valueOf(copy);
	}

	public static int binaryToDecimal(String binary) {
		int data = Integer.parseInt(binary);
		int number = 0, pow = 0;
		while (data > 0) {
			number += (data % 2) * Math.pow(2, pow);
			pow++;
			data = data / 10;
		}
		return number;
	}

	public static String decimalToBinary(int number) {
		String value = "";
		while (number > 0) {
			int digit = number % 2;
			value = digit + "" + value;
			number = number / 2;
		}
		int requiredPad = 8 - value.length();
		char[] padding = new char[requiredPad];
		Arrays.fill(padding, '0');
		String padString = String.valueOf(padding);
		value = padString + value;

		return value;

	}

	public  void primeFactors(int number) {
		while (number % 2 == 0) {
			System.out.print(2 + " ");
			number /= 2;
		}
		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			while (number % i == 0) {
				System.out.print(i + " ");
				number /= i;
			}
		}
		if (number > 2)
			System.out.print("Prime Factors are " + number);
	}

	public static boolean checkPrime(int number) {
		if (number == 0 || number == 1) {
			return false;
		}

		int m = number / 2;
		for (int i = 2; i <= m; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int[] prime(int[] number) {
		int count = 0;
		for (int i = 0; i < number.length; i++) {
			if (checkPrime(number[i])) {
				count++;
			}
		}

		int j = 0;
		int[] data = new int[count];
		for (int i = 0; i < number.length; i++) {
			if (checkPrime(number[i])) {
				data[j++] = number[i];
			}
		}
		return data;
	}

	public int[] palindrome(int[] number) {
		int count = 0;
		for (int i = 0; i < number.length; i++) {
			if (checkPalindrome(number[i])) {
				count++;
			}

		}
		int j = 0;
		int[] data = new int[count];
		for (int i = 0; i < number.length; i++) {
			if (checkPalindrome(number[i])) {

				data[j++] = number[i];
			}
		}
		return data;
	}

	public static boolean checkPalindrome(int number) {
		int copy = number;
		int reverse = 0;
		int carry;
		while (number > 0) {
			carry = number % 10;
			reverse = reverse * 10 + carry;
			number = number / 10;
		}
		if (reverse == copy) {
			return true;
		} else
			return false;
	}

	public static boolean anagram(String string1, String string2) {
		char a[] = string1.toCharArray();
		char b[] = string2.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		String str1 = String.valueOf(a);
		String str2 = String.valueOf(b);

		if (str1.equals(str2))
			return true;
		return false;
	}

	public static int[] removeDuplicate(int[] number) {
		int k = 1;
		for (int i = 1; i < number.length; i++) {
			int value = number[i];
			if (value == number[i - 1]) {
				i++;
			} else {
				number[k] = value;
				k++;
			}
		}
		int[] unique = new int[k];
		for (int i = 0; i < unique.length; i++) {
			unique[i] = number[i];
		}
		return unique;
	}

	public <E extends Comparable<E>> int binarySearch(E find, E[] array) {
		int first = 0, last = array.length - 1, mid;
		while (first <= last) {
			mid = (first + last) / 2;

			if (array[mid].compareTo(find) == 0) {
				return mid;
			} else if (array[mid].compareTo(find) < 0) {
				first = mid + 1;
			} else
				last = mid - 1;
		}

		return -1;
	}

	/*
	 * public int binarySearch(int find, int[] a) { int
	 * first=0,last=a.length-1,mid; while(first<=last){ mid=(first+last)/2;
	 * 
	 * if(a[mid]==find){ return mid; } else if(a[mid]<find){ first=mid+1; } else
	 * last=mid-1; }
	 * 
	 * return -1; }
	 */

	/*
	 * public void insertionSort(int[] a){ for(int i=1;i<a.length;i++){ int j=i;
	 * int element=a[i]; while(j>0 && a[j-1]>element){ a[j]=a[j-1]; j--; }
	 * 
	 * a[j]=element;
	 * 
	 * } for(int i=0;i<a.length;i++){ System.out.println(a[i]); }
	 * 
	 * }
	 */

	public static int integerSort(int number) {
		int sorted = 0;
		String value = Integer.toString(number);
		Integer[] copy = new Integer[value.length()];
		int i = 0;
		while (number > 0) {
			copy[i++] = number % 10;
			number /= 10;
		}
		insertionSort(copy);
		for (Integer d : copy) {
			sorted = sorted * 10 + d;
		}

		return sorted;
	}

	public static <E extends Comparable<E>> E[] insertionSort(E[] array) {
		for (Integer i = 1; i < array.length; i++) {
			Integer j = i;
			E element = array[i];
			while (j > 0 && array[j - 1].compareTo(element) > 0) {
				array[j] = array[j - 1];
				j--;
			}

			array[j] = element;

		}
		return array;
	}

	public <E extends Comparable<E>> E[] bubbleSort(E[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					E temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		return array;
	}

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public void findYourNumber( int n) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Given Range of Number is 0 to " + n + "\nThink One Number in between this range..");
		int first = 0, last=n;
		String ch = "yes";
		while ((n-1) != 0) {

			System.out.println("Is the Number between '" + first + "' '" + last + "' Type 'yes' for Yes , 'no' for No");

			if (ch.equals(scan.nextLine())) {
				last = (first + last) / 2;
				// System.out.println((first+last)/2);
			} else {

				int temp = (last - first) / 2;
				first = last + 1;
				last = first + temp;
				// System.out.println((first-last)/2);
			}
			n--;

		}
		System.out.println("Is the Number between '" + first + "' '" + last + "' Type 'yes' for Yes , 'no' for No");

		if (ch.equals(scan.nextLine())) {
			System.out.println("Your Number is --> " + first);
		} else {
			System.out.println("Your Number is --> " + (first + 1));
		}
	}

	public int dayOfWeek(int month, int day, int year) {
		int y0 = year - (14 - month) / 12;
		int x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (day + x + (31 * m0) / 12) % 7;

		return d0;

	}

	public static void monthlyPayment(double principalAmount, double year, double rate) {
		double payment;
		double n = 12 * year;
		double r = rate / (12 * 100);

		payment = (principalAmount * r) / (1 - Math.pow((1 + r), (-r)));
		System.out.println("Monthly Payment is as Follow.. " + payment);
	}

}