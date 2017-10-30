package com.bridgeit.utility;

import java.util.*;

/*  Class Node  */

/*  Class Dequeue  */

public class Deque<E> extends Node

{

	private Node front, rear;

	private int size;

	/* Constructor */

	public Deque()

	{

		front = null;

		rear = null;

		size = 0;

	}

	/* Function to check if queue is empty */

	public boolean isEmpty()

	{

		return front == null;

	}

	/* Function to get the size of the queue */

	public int getSize()

	{

		return size;

	}

	/* Clear dequeue */

	public void clear()

	{

		front = null;

		rear = null;

		size = 0;

	}

	/* Function to insert an element at begining */

	public void insertAtFront(E val)

	{

		Node nptr = new Node(null, val);

		size++;

		if (front == null)

		{

			front = nptr;

			rear = front;

		}

		else

		{

			nptr.setLink(front);

			front = nptr;

		}

	}

	/* Function to insert an element at end */

	public void insertAtRear(E val)

	{

		Node nptr = new Node(null, val);

		size++;

		if (rear == null)

		{

			rear = nptr;

			front = rear;

		}

		else

		{

			rear.setLink(nptr);

			rear = nptr;

		}

	}

	/* Function to remove front element from the queue */

	public E removeAtFront()

	{

		if (isEmpty())

			throw new NoSuchElementException("Underflow Exception");

		Node ptr = front;

		front = ptr.getLink();

		if (front == null)

			rear = null;

		size--;

		return (E) ptr.getData();

	}

	/* Function to remove rear element from the queue */

	public E removeAtRear()

	{

		if (isEmpty())

			throw new NoSuchElementException("Underflow Exception");

		E ele = (E) rear.getData();

		Node s = front;

		Node t = front;

		while (s != rear)

		{

			t = s;

			s = s.getLink();

		}

		rear = t;

		rear.setLink(null);

		size--;

		return ele;

	}

	/* Function to check the front element of the queue */

	public E peekAtFront()

	{

		if (isEmpty())

			throw new NoSuchElementException("Underflow Exception");

		return (E) front.getData();

	}

	/* Function to check the front element of the queue */

	public E peekAtRear()

	{

		if (isEmpty())

			throw new NoSuchElementException("Underflow Exception");

		return (E) rear.getData();

	}

	/* Function to display the status of the queue */

	public void display()

	{

		System.out.print("\nDequeue = ");

		if (size == 0)

		{

			System.out.print("Empty\n");

			return;

		}

		Node ptr = front;

		while (ptr != rear.getLink())

		{

			System.out.print(ptr.getData() + " ");

			ptr = ptr.getLink();

		}

		System.out.println();

	}

}