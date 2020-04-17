/**
 * CS 1027 Assignment 3
 * By: Jessie Wu 
 * Student Number: 251085957
 */

/** 
 * This class describes the position of the snake on the board.
 */

public class Position 
{
	private int positionRow; /** Position of square along all rows */
	private int positionColumn; /** Position of square along all columns */
	int newRow; /** New value of row position */
	int newCol; /** New value of column position */
	
	public Position(int row, int col) /** Constructor for class Position where values are passed to store into row and col parameters*/
	{
		positionRow = row; 
		positionColumn = col;
	}
	
	public int getRow()  /** Returns value of positionRow */
	{	
		return positionRow;
	}
	
	public int getCol()  /** Returns value of positionColumn */
	{
		return positionColumn;
	}
	
	
	public void setRow(int newRow)  /** Stores the value of newRow in positionRow */
	{
		positionRow = newRow;		
	}
	
	public void setCol(int newCol)  /** Stores the value of newCol in positionColumn */
	{
		positionColumn = newCol;
	}
	
	public boolean equals(Position otherPosition)  /** Determines if board position of target object is the same as position of another object */
	{
		if (this.positionRow == otherPosition.positionRow && this.positionColumn == otherPosition.positionColumn) {
			return true;
		}
		else {
			return false;
		}
	}
}
