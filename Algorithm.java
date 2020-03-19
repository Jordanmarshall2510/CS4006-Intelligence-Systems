/*
	The Gang
	****************************
	Marcin Sek 			18254187
	Jordan Marshall 	18256716
	Ademide Adenuga		18220258
	Rioghan Lowry		18226531
	****************************
*/

import java.util.ArrayList;
import java.lang.Math;

public class Algorithm
{
	private ArrayList<Point> open, close;
	private Point start, current, end;

	/**
	 * Algorithm Constructor
	 * 
	 * @param start the start point/node of the algorithm
	 * @param end the end point/goal state of the algorithm
	 */
	public Algorithm(Point start, Point end)
	{
		this.open = new ArrayList<Point>();
		this.close = new ArrayList<Point>();

		this.start = start;
		this.current = start;
		this.end = end;
	}

	/**
	 * Finds the shortest route from given the map
	 * 
	 * @param matrix[][] the map on which the algorithm operates
	 * @return the path from start node to end node given the map
	 */
	public ArrayList<Point> find(int matrix[][])
	{
		current.setScore(current.getG() + manhattenDistance(current, end));
		open.add(current);
		while (!open.isEmpty())
		{
			current = open.get(0);
			for (Point point : open)
			{
				current = point.getScore() > current.getScore() ? current : point;
			}
			if (current.equals(end))
			{
				break;
			}
			ArrayList<Point> newPoints = getPoints(current, matrix);
			for (Point point : newPoints)
			{
				open.add(point);
			}
			close.add(current);
			open.remove(current);
		}

		if (current.equals(end))
		{
			ArrayList<Point> res = new ArrayList<Point>();

			current = current.getParent(); // push 1 gen back (current == end rn)
			while (!current.equals(start))
			{
				res.add(current);
				current = current.getParent();
			}
			return res;
		}
		return null;
	}

	/**
	 * Gets the points that are valid given the current point
	 * 
	 * @param n the point we are currently looking at
	 * @param matrix[][] the map of the world in which the point is located
	 * @return a list of points that are valid given the map and point
	 */
	private ArrayList<Point> getPoints(Point n, int matrix[][])
	{
		ArrayList<Point> points = new ArrayList<Point>();
		
		int row = n.getRow();
		int col = n.getCol();

		if (col + 1 < 8 && matrix[row][col+1] != 9 && !closed(row, col+1))
		{
			Point newPoint = new Point(row, col+1, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (col - 1 >= 0 && matrix[row][col-1] != 9 && !closed(row, col-1))
		{
			Point newPoint = new Point(row, col-1, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (row + 1 < 8 && matrix[row+1][col] != 9 && !closed(row+1, col))
		{
			Point newPoint = new Point(row+1, col, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (row - 1 >= 0 && matrix[row-1][col] != 9 && !closed(row-1, col))
		{
			Point newPoint = new Point(row-1, col, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		return points;
	}

	/**
	 * Gets the Manhatten Distance between two given points
	 * 
	 * @param m point from which we are finding the distance
	 * @param n point to which we are finding the distance
	 * @return the Manhatten Distance between the points
	 */
	private int manhattenDistance(Point m, Point n)
	{
		int distance = (Math.abs(m.getRow()-n.getRow())) + (Math.abs(m.getCol()-n.getCol()));
		return distance;
	}

	/**
	 * Checks if the point has been closed already
	 * 
	 * @param row the row index of the point
	 * @param col the column index of the point
	 * @return boolean has it been closed already by the algorithm
	 */
	private boolean closed(int row, int col)
	{
		for (int i = 0; i < close.size(); i++)
		{
			if (close.get(i).getRow() == row && close.get(i).getCol() == col)
			{
				return true;
			}
		}
		return false;
	}
}