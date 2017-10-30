package com.bridgeit.utility;


import java.util.NoSuchElementException;

public class CashCounterUtility {
	public Node front, rear;
    public int size;
 
    private class Node {
    	int data;
    	Node next;
    	
    }
		
    public CashCounterUtility()
    {
        front = rear = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return front == null;
    }   
    
    public int getSize()
    {
        return size;
    }    
    
    public void insert(int data)
    {
        Node node = new Node();
        node.data=data;
        node.next=null;
        if (rear == null)
        {
            front = rear = node;
        }
        else
        {
            
            rear.next = node;
        }
        size++ ;
    }   
    
   	public Object remove()
    {
        if (isEmpty())
		{
        	throw new NoSuchElementException("Underflow Exception");
		}
        Node ptr = front;
        front = ptr.next;        
        if (front == null)
		{
            rear =null;
		}   
        size-- ; 
        return ptr.data;
    }    
    
    public Object peek()
    {
        if (isEmpty())
		{
            throw new NoSuchElementException("Underflow Exception");
		}
        return front.data;
    }    
    
    public void display()
    {  
		int ptr1 = 0;
        System.out.print("Available Balance = ");
        if (size == 0)
        {
            System.out.print("Empty");
            return ;
        }
        Node ptr = front;
        while (ptr != rear.next)
        { 
        	ptr1=ptr1 + ptr.data;
        	System.out.println(ptr1);
            ptr = ptr.next;
        }
          

    }
    
}