//Bozhidar Stoyanov 0353616
//This is a Linked List Stack class
//It creates Linked Stack with the function of
//pop(), push(char c), peek(). The linked list stack is used to store data.
//It stores it in a way in which one can only access, or remove an element from the top of the stack,
//as well; if adding more elements one can only add them at the top of the stack.

import java.util.*;

public class LLStack
{

	class Node
	{
		char data; //each node stores data of type char
		Node link; 
	
	}

	private Node first; //first node in the stack

	public LLStack()
	{
		first = null; //set to null
	}

	public void push(char x) //push parameter value x into our stack
	{
		Node n = new Node(); //create new node
		n.data = x;
		n.link = first;
		first = n; //set that node with x data as the first node, or on top of the stack
	}

	public int peek() //peek into the first value
	{
		if (first == null)
		{	
			throw new NoSuchElementException(); //node not found
		}
		else
		{
			char value = first.data;
			return value; //return variable called value which stores the data of the first(head) node
		}
	}

	public int pop() //pop the stack
	{
		if (first == null)
		{
			throw new NoSuchElementException(); //no element found exception
		}
		else
		{
			Node temp = first; //store the first(head) node into a temp node which will be used to return the data from it underneath
			first = first.link; //assign the first node to our second node, since we are popping(or removing) our first node in the LinkedStack
			return temp.data; //return the data of our top(head) node
		}
	}
	

}