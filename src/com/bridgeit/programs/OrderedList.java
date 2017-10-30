package com.bridgeit.programs;
import com.bridgeit.utility.LinkedListUtility;
import com.bridgeit.utility.Utility;
import java.io.*;
import java.util.Scanner;


public class OrderedList {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		LinkedListUtility utility = new LinkedListUtility();
		Utility util = new Utility();
		File file = new File("/root/workspace/TestApp/src/com/bridgeit/testApp/DataStructure/Number.txt");
		
		if(file.exists()){
			if(file.canRead()){
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String data = bufferedReader.readLine();
				String[] word = data.trim().split(",");
				word=util.bubbleSort(word);
				for (String w : word) {
					utility.insertAtEnd(w);
				}
				utility.displayList();
				System.out.println();
				System.out.println(
						"Enter The NUmber.. 'if Number will found then it will be deleted otherwise,it will Add into list'");
				String name = scanner.nextLine();
				int result = utility.findPosition(name);
				if (result != -1) {
					utility.deleteAtPos(result);
					utility.displayList();
				}
				else{
					utility.insertInOrder(name);
					utility.displayList();
				}
				utility.printToFile("/root/workspace/TestApp/src/com/bridgeit/testApp/DataStructure/Number.txt");
				System.out.println();
				System.out.println("Data has been Successfully Written..");
			}
			else {
				System.out.println("File cannot be Read..");
			}
			
		}else
			System.out.println("File not Found");
		

	}

}
