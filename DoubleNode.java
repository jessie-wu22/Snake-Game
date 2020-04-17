/**
 * CS 1027 Assignment 3 
 * Student Number: 251085957
 * @author Jessie Wu
 * 
 * This class represents the nodes in a doubly linked list
 * and creates variables next, prev, and data, methods that initialize new nodes, and methods that act on nodes in a list 
 */


public class DoubleNode<T>
{
	/** 
	 * variable that references the next node in the list
	 */
	private DoubleNode<T> next;
	
	/**
	 * variable that references previous node in the list
	 */
	private DoubleNode<T> prev;
	
	/**
	 * represents the data stored in this node
	 */
	private T data; 
	
	/**
	 * method creates an empty node with all null instance variables
	 */
	public DoubleNode()
	{
		next = null;
		prev = null;
		data = null;
	}
	
	/**
	 * method creates a node storing the given data
	 */
	public DoubleNode(T newData)
	{
		next = null;
		prev = null;
		data = newData;
	}
	
	/**
	 * method that returns value of next
	 */
	public DoubleNode<T> getNext()
	{
		return next;
	}
	
	/**
	 * method that returns value of prev
	 */
	public DoubleNode<T> getPrev()
	{
		return prev;
	}
	
	/**
	 * method that returns the value of data
	 */
	public T getData()
	{
		return data; 
	}
	
	/**
	 * method that stores nextNode in next
	 */
	public void setNext(DoubleNode<T> nextNode)
	{
		next = nextNode;
	}
	
	/**
	 * method that stores prevNode in prev
	 */
	public void setPrev(DoubleNode<T> prevNode)
	{
		prev = prevNode;
	}
	
	/**
	 * method that stores newData in data
	 */
	public void setData(T newData)
	{
		data = newData;
	}
}
