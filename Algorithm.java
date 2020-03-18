import java.util.ArrayList;
import java.lang.Math;

public class Algorithm
{
	private ArrayList<Point> open, close;
	private Point start, current, end;

	public Algorithm(Point start, Point end)
	{
		this.open = new ArrayList<Point>();
		this.close = new ArrayList<Point>();

		this.start = start;
		this.current = start;
		this.end = end;
	}

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

		ArrayList<Point> res = new ArrayList<Point>();

		current = current.getParent(); // push 1 gen back (current == end rn)
		while (!current.equals(start))
		{
			res.add(current);
			current = current.getParent();
		}
		return res;
	}

	private ArrayList<Point> getPoints(Point n, int matrix[][])
	{
		ArrayList<Point> points = new ArrayList<Point>();
		
		int row = n.getRow();
		int col = n.getCol();

		if (col + 1 < 8 && matrix[row][col+1] != 9)
		{
			Point newPoint = new Point(row, col+1, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (col - 1 >= 0 && matrix[row][col-1] != 9)
		{
			Point newPoint = new Point(row, col-1, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (row + 1 < 8 && matrix[row+1][col] != 9)
		{
			Point newPoint = new Point(row+1, col, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (row - 1 >= 0 && matrix[row-1][col] != 9)
		{
			Point newPoint = new Point(row-1, col, n.getG()+1, n);
			newPoint.setScore(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		return points;
	}

	public int manhattenDistance(Point m, Point n)
	{
		int distance = (Math.abs(m.getRow()-n.getRow())) + (Math.abs(m.getCol()-n.getCol()));
		return distance;
	}
}