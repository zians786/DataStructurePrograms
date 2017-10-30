package com.bridgeit.programs;

import java.util.*;


import com.bridgeit.utility.StackUtility;

public class BalancedParenthesis {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Equation..");
		String data = scanner.nextLine();
		char[] equation = data.toCharArray();
		
		StackUtility utility = new StackUtility(equation.length);
		for(int i=0,j=1;i<equation.length;i++){
			if(equation[i]=='('){
				utility.push(i);
			}
			else if(equation[i]==')'){
				System.out.println(j+" Parenthesis Starts from index "+utility.pop()+" ends on index "+i);
				j++;
			}
		}
		if(utility.isStackEmpty()){
			System.out.println("Equation is in Balanced Form..");
		}
		else
			System.out.println("Equation is not Balanced Form..");
		
	}
}
