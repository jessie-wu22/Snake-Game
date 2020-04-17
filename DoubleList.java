/**
 * CS 1027 Assignment 3 
 * Student Number: 251085957
 * @author Jessie Wu
 * 
 * This class represents a doubly linked list of nodes 
 * and creates the head, rear, and numDataItem variables and methods that manipulate the contents in doubly linked list snakeBody
 */


public class DoubleList<T> 
{
	/**
	 * variable references first node in the list
	 */
	private DoubleNode<T> head; 
	
	/**
	 * variable references last node in the list
	 */
	private DoubleNode<T> rear;
	
	
	/**
	 * variable represents number of nodes in the list
	 */
	private int numDataItems;
	
	/**
	 * creates an empty doubly linked list
	 */
	public DoubleList()
	{
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	/**
	 * Method which adds node storing newData to the list 
	 * @param index
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void addData (int index, T newData) throws InvalidPositionException
	{

		if (index < 0  || index > numDataItems) // given conditions of an invalid index 
		{
			throw new InvalidPositionException("Invalid position");
		}		
		
		// newNode is added to the beginning of the list 
		else if (index == 0) 
		{
			DoubleNode<T> newNode = new DoubleNode <T>(newData); // creates node newNode to be inserted for the data newData
			
			int current = 1; // indicates current index position in list, start at index position 1 as we want to insert the data after index
			DoubleNode<T> currentNode = head; // creates doubleNode object currentNode pointing to first index head position
			
			if (numDataItems == 0) // checks if list is empty
			{
				head = rear = newNode;
				numDataItems++;
			}
			
			else
			{
				newNode.setNext(head);
				newNode.setPrev(null);
				head.setPrev(newNode);
				head = newNode; // head pointer to newNode
				numDataItems++;
			}
		}
		
		
		else if (index == numDataItems) // newNode is added to the end of the list
		{
			DoubleNode<T> newNode = new DoubleNode <T>(newData); // creates node newNode to be inserted for the data newData
			
			int current = 1; // indicates current index position in list, start at index position 1 as we want to insert the data after index
			DoubleNode<T> currentNode = head; // creates doubleNode object currentNode pointing to first index head position
			
			rear.setNext(newNode);
			newNode.setPrev(rear);
			newNode.setNext(null);
			rear = newNode;
			numDataItems++;
		}
		
		// newNode is added to middle of the list 
		else 
		{
			DoubleNode<T> newNode = new DoubleNode <T>(newData); // creates node newNode to be inserted for the data newData
			
			int current = 1; // indicates current index position in list, start at index position 1 as we want to insert the data after index
			DoubleNode<T> currentNode = head; // creates doubleNode object currentNode pointing to first index head position
			
			current = 1;
			while (current != index)
			{
				currentNode = currentNode.getNext();
				current++;
			}
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
			newNode.setPrev(currentNode);
			currentNode.getNext().setPrev(newNode);
			numDataItems++;
			}
		}
		
	/**
	 * Method that returns the node at given position index of the list 
	 * @param index
	 * @return currentNode
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException
	{
		if (index < 0  || index > numDataItems)
		{
			throw new InvalidPositionException("Invalid position");
		}
	
		DoubleNode<T> currentNode = head;
		int current = 0; // keeps track of position of currentNode in the list 
		
		while (current != index) 
		{
			currentNode = currentNode.getNext(); // moves through list until target index is reached
			current++; 
		}
		return currentNode;
	}
	
	/**
	 * Method removes the node in position index of the list
	 * @param index
	 * @throws InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException
	{
		
		if (index < 0 || index >= numDataItems)
		{
			throw new InvalidPositionException("Invalid position");
		}
		
		// newNode is removed beginning of the list
		if (index == 0)  
		{
			if (numDataItems == 0) 
			{
				head = rear = null;
				numDataItems--;
			}
			
			else
			{
				head = head.getNext();
				head.setPrev(null);
				numDataItems--;
			}
		}
		
		// newNode is removed from end of the list
		else if (index == numDataItems - 1) 
		{
			rear = rear.getPrev();
			rear.setNext(null);
			numDataItems--;
		}
		
		// newNode is removed from middle of list 
		else 
		{
			DoubleNode<T> currentNode = head; 
			int current = 0;  
			
			while (current != index)
			{
				currentNode = currentNode.getNext(); 
				current++;
			}
			DoubleNode<T> next = currentNode.getNext(); // sets node object next to be the node after currentNode
			currentNode.getPrev().setNext(next);
			next.setPrev(currentNode.getPrev());
			numDataItems--;
		}
	}
	
	/**
	 * Method returns the data stored in the node located in position index 
	 * @param index
	 * @return the retrieved target data 
	 * @throws InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException
	{
		if (index < 0  || index >= numDataItems)
		{
			throw new InvalidPositionException("Invalid position");
		}
		
		DoubleNode<T> currentNode = head;
		int current = 0;
		
		while (current != index) 
		{
			currentNode = currentNode.getNext();
			current++; 
		}
		return currentNode.getData();
	}
	
	/**
	 * Method sets the data newData to replace the data stored in the position index node
	 * @param index
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void setData(int index, T newData) throws InvalidPositionException
	{
				
		if (index < 0  || index >= numDataItems)
		{
			throw new InvalidPositionException("Invalid position");
		}
		
		DoubleNode<T> currentNode = head;
		int current = 0;
		
		while (current != index)
		{
			currentNode = currentNode.getNext();
			current++;
		}
		currentNode.setData(newData);
	}
}
