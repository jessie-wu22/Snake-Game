/**
 * CS 1027 Assignment 3 
 * Student Number: 251085957
 * @author Jessie Wu
 * 
 * This class tracks the changing information about the snake as it moves, grows, and shrinks
 */


public class SnakeLinked 
{
	/**
	 * Variable representing number of tiles on the board the snake occupies 
	 */
	int snakeLength;
	
	/**
	 * Variable representing the doubly linked list that stores the tile positions that the snake body occupies on the game board
	 */
	DoubleList<Position>snakeBody;
	
	/**
	 * Constructor initializes snakeLength and snakeBody
	 * @param row
	 * @param col
	 */
	public SnakeLinked(int row, int col)
	{
		snakeLength = 1;
		snakeBody = new DoubleList(); // initializes snakeBody to contain DoubleList of nodes
		Position pos = new Position(row, col); // object pos stores values row and col
		snakeBody.addData(0, pos); // Position object pos is stored in the first node
	}
	
	/**
	 * Method returns values of instance variable snakeLength
	 * @return snakeLength
	 */
	public int getLength()
	{
		return snakeLength;
	}
	
	/**
	 * Method returns the Position object stored in the node of a given index called index
	 * @param index
	 * @return
	 */
	public Position getPosition(int index)
	{
		if (index < 0 || index >= snakeLength) 
		{
			return null;
		}
		
		else 
		{
			return snakeBody.getData(index);
		}
	}
	
	/**
	 * Method determines whether or not object pos is in the doubly linked list of snakeBody
	 * @param pos
	 * @return true if found in the list and false otherwise
	 */
	public boolean snakePosition(Position pos)
	{
		boolean positionFound = false;
	
		for (int index = 0; index < snakeLength; index++)
		{
			if (pos.equals(snakeBody.getData(index)))
			{
				positionFound = true;
			}
		}
		return positionFound;
	}
	
	/**
	 * Method tracks the changes in the position of snake head
	 * @param direction
	 * @return new position of the snake head
	 */
	public Position newHeadPosition(String direction) 
	{		
		int headRow, headCol; // creates new variables to store position of current head in row and column
		if (direction.equals("up")) {
			headRow = snakeBody.getData(0).getRow()-1; // decreases row position value by one, moving along a y-axis 
			headCol = snakeBody.getData(0).getCol(); // no changes to column position 		
			return new Position(headRow, headCol);
		}
		
		else if(direction.equals("down")) {
			headRow = snakeBody.getData(0).getRow()+1; // increases row position value by one, moving along a y-axis 
			headCol = snakeBody.getData(0).getCol(); // no changes to column position
			return new Position(headRow, headCol);
		}
		
		else if(direction.equals("right")){
			headRow = snakeBody.getData(0).getRow(); // no changes to row position
			headCol = snakeBody.getData(0).getCol()+1; // increases column position value by one, moving along a x-axis 
			return new Position(headRow, headCol);
		}
		
		else {
			headRow = snakeBody.getData(0).getRow(); // no changes to row position
			headCol = snakeBody.getData(0).getCol()-1; // decreases column position value by one, moving along y-axis 
			return new Position(headRow, headCol);
		}
	}
	
	/**
	 * Method that moves snake in a specified direction
	 * @param direction
	 */
	public void moveSnakeLinked(String direction)
	{		
		Position newHead = newHeadPosition(direction); // creates Position object newHead which gets coordinates of position of new head newHead
		snakeBody.addData(0, newHead); // sets newHeadPosition data in newHead to point to position 0 in list to become new head
	
		snakeBody.removeData(snakeLength); // removes the data in the last index position of the list with snakeLength representing new list length with newHead
	}
	
	/**
	 * Method decreases the length of snake by 1 and deletes last node in the doubly linked list snakeBody
	 */
	public void shrink()
	{
		snakeLength--;
	}
	
	/**
	 * Method increases the length of snake by 1 and moves snake head in the specified direction, where last node is not lost 
	 * @param direction
	 */
	public void grow(String direction)
	{
		snakeLength++;
		
		Position newHead = newHeadPosition(direction); // creates Position object newHead which gets coordinates of position of new head newHead
		snakeBody.addData(0, newHead); // sets newHeadPosition data in newHead to point to position 0 in list to become new head
	}	
}

