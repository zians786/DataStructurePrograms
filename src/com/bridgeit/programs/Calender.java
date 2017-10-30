package com.bridgeit.programs;

import java.util.Scanner;


import com.bridgeit.utility.CalenderUtility;

public class Calender {

	public static void main(String[] args) {
		CalenderUtility utility=new CalenderUtility();
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter full year (e.g., 2001): ");
		int year = scan.nextInt();

		System.out.print("Enter month in number between 1 and 12: ");
		int month = scan.nextInt();

		if (month < 1 || month > 12 || year < 1980)
			System.out.println("Wrong input!");
		else
			utility.printMonth(year, month);

	}

}


