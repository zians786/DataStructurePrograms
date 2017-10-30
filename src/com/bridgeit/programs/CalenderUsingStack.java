package com.bridgeit.programs;

import java.util.Scanner;


import com.bridgeit.utility.CalenderUtility;
import com.bridgeit.utility.Queue;
import com.bridgeit.utility.StackUtility;

public class CalenderUsingStack {

	public static void main(String[] args) throws Exception {
		CalenderUtility utility = new CalenderUtility();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter full year (e.g., 2001): ");
		int year = scan.nextInt();

		System.out.print("Enter month in number between 1 and 12: ");
		int month = scan.nextInt();

		if (month < 1 || month > 12 || year < 1980)
			System.out.println("Wrong input!");
		else {
			String day = "Sun Mon Tue Wed Thu Fri Sat";
			String[] days = day.split(" ");
			Queue daysQueue = new Queue(days.length);
			for (int i = 0; i < days.length; i++) {
				daysQueue.enqueue(days[i]);
			}

			int numberOfDaysInMonth = utility.getNumberOfDaysInMonth(year, month);
			int startDay = utility.getStartDay(year, month);

			Queue dateQueue = new Queue(numberOfDaysInMonth + startDay);
			for (int i = 0; i < startDay; i++) {
				dateQueue.enqueue("  ");
			}
			for (int i = 1; i <= numberOfDaysInMonth; i++) {
				dateQueue.enqueue(i);
			}
			StackUtility daysStack=new StackUtility(daysQueue.getSize());
			StackUtility dateStack=new StackUtility(dateQueue.getSize());
			
			while(!daysQueue.isEmpty()){
				daysStack.push(daysQueue.dequeue());
			}
			
			while(!dateQueue.isEmpty()){
				dateStack.push(dateQueue.dequeue());
			}
			
			System.out.println("         " + utility.getMonthName(month) + " " + year);
			System.out.println("–––––––––––––––––––––––––––––");
			while(!daysStack.isStackEmpty()){
				System.out.print(daysStack.pop()+"  ");
			}
			
		
				for(int i=0;i<startDay;i++){
					System.out.println(dateStack.pop());
				}
				
				while(!dateStack.isStackEmpty()){
					int date=(Integer) dateStack.pop();
					if (date < 10)
						System.out.print( date+"    " );
					else
						System.out.print( date+"   " );
					if ((date + startDay) % 7 == 0)
						System.out.println();
				}}
				System.out.println();
			
			

	}

}
