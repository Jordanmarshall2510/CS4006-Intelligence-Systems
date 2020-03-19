/*
	The Gang
	****************************
	Marcin Sek 			18254187
	Jordan Marshall 	18256716
	Ademide Adenuga		18220258
	Rioghan Lowry		18226531
	****************************
*/

public class Point
{
	private int row;
	private int col;
	private int g;
	private int score;
	private Point parent;

	/**
	 * Point Constructor
	 * 
	 * @param row the index of the row in which the point is
	 * @param col the index of the col in which the point is
	 */
	public Point(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.g = 0;
		this.parent = null;
	}

	/**
	 * Point Constructor
	 * 
	 * @param row the index of the row in which the point is
	 * @param col the index of the col in which the point is
	 * @param g the distance of the point away from the start point
	 */
	public Point(int row, int col, int g, Point parent)
	{
		this.row = row;
		this.col = col;
		this.g = g;
		this.parent = parent;
	}

	/**
	 * Gets the row of the point
	 * 
	 * @return the row index of the point
	 */
	public int getRow()
	{
		return this.row;
	}

	/**
	 * Gets the col of the point
	 * 
	 * @return the column index of the point
	 */
	public int getCol()
	{
		return this.col;
	}

	/**
	 * Gets the g of the point
	 * 
	 * @return the distance from this point to the start point
	 */
	public int getG()
	{
		return this.g;
	}

	/**
	 * Gets the score of the point
	 * 
	 * @return the score of the point (G + Manhattan distance to end)
	 */
	public int getScore()
	{
		return this.score;
	}

	/**
	 * Gets the previous node
	 * 
	 * @return the parent node of the point
	 */
	public Point getParent()
	{
		return this.parent;
	}

	/**
	 * Sets the row to a new value
	 * 
	 * @param newRow new value for our row field
	 */
	public void setRow(int newRow)
	{
		this.row = newRow;
	}

	/**
	 * Sets the col to new value
	 * 
	 * @param newCol new value for our col field
	 */
	public void setCol(int newCol)
	{
		this.col = newCol;
	}

	/**
	 * Sets the g field to a new value
	 * 
	 * @param newG new value for the g field
	 */
	public void setG(int newG)
	{
		this.g = newG;
	}

	/**
	 * Sets the score field to a new value
	 * 
	 * @param newScore new value for the score field
	 */
	public void setScore(int newScore)
	{
		this.score = newScore;
	}

	/**
	 * Checks if two Points are the same
	 * 
	 * @param other point to compare to this point
	 * @return true or false depending on whether they are the same or not
	 */
	public boolean equals(Point other)
	{
		return this.row == other.row && this.col == other.col;
	}
}