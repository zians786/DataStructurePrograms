package com.bridgeit.programs;

import com.bridgeit.utility.LinkedListUtility;
import java.io.*;
import java.util.Scanner;

public class UnOrderedList {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		LinkedListUtility utility = new LinkedListUtility();
		File file = new File("/root/workspace/TestApp/src/com/bridgeit/testApp/Programs/text.txt");
		if (file.exists()) {
			if (file.canRead()) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String data = bufferedReader.readLine();
				String[] word = data.trim().split(",");
				for (String w : word) {
					utility.insertAtEnd(w);
				}
				utility.displayList();
				System.out.println();
				System.out.println(
						"Enter The Name.. 'if name will found then it will be deleted otherwise,it will Add into list'");
				String name = scanner.nextLine();
				int result = utility.findPosition(name);
				if (result != -1) {
					utility.deleteAtPos(result);
					utility.displayList();
				} else {
					utility.insertAtEnd(name);
					utility.displayList();
				}
				utility.printToFile("/root/workspace/TestApp/src/com/bridgeit/testApp/Programs/text.txt");
				System.out.println();
				System.out.println("Data has been Successfully Written..");
			} else {
				System.out.println("File Cant be Read..");
			}
		} else {
			System.out.println("File not Found..");
		}

	}

}
