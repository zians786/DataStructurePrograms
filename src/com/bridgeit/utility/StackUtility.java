package com.bridgeit.utility;

import java.util.*;

  
	 
  public class StackUtility <T> {
	 
	    private int stackSize;
	    private T[] stackArr;
	    private int top;
	     
	    public StackUtility(int size) {
	        stackSize = size;
	        stackArr = (T[]) new Object[stackSize];
	        top = -1;
	    }
	 
	    
	    public void push(T entry){
	     
	    	if(isStackFull()){
	            System.out.println(("Stack is full.."));
	            
	        }
	    	else{
	        //System.out.println("Adding: "+entry);
	        stackArr[++top] = entry;
	    }
	    }
	 
	    public T pop() throws Exception {
	        if(isStackEmpty()){
	            throw new Exception("Stack is empty. Can not remove element.");
	        }
	        T entry = stackArr[top--];
	       // System.out.println("Removed entry: "+entry);
	        return entry;
	    }
	     
	    
	    public T peek() {
	        return stackArr[top];
	    }
	 
	    public boolean isStackEmpty() {
	        return (top == -1);
	    }
	 
	    
	    public boolean isStackFull() {
	        return (top == stackSize - 1);
	    }
 }
