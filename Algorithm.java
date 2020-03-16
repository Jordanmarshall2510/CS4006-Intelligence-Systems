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
		current.setVal(current.getG() + manhattenDistance(current, end));
		open.add(current);
		while (!open.isEmpty())
		{
			current = open.get(0);
			for (Point point : open)
			{
				current = point.getVal() > current.getVal() ? current : point;
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
		
		int x = n.getX();
		int y = n.getY();
		if (x + 1 < 8 && matrix[y][x+1] != 9)
		{
			Point newPoint = new Point(x+1, y, n.getG()+1, n);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (x - 1 >= 0 && matrix[y][x-1] != 9)
		{
			Point newPoint = new Point(x-1, y, n.getG()+1, n);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (y + 1 < 8 && matrix[y+1][x] != 9)
		{
			Point newPoint = new Point(x, y+1, n.getG()+1, n);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (y - 1 >= 0 && matrix[y-1][x] != 9)
		{
			Point newPoint = new Point(x, y-1, n.getG()+1, n);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		return points;
	}

	public int manhattenDistance(Point m, Point n)
	{
		int distance = (Math.abs(m.getX()-n.getX())) + (Math.abs(m.getY()-n.getY()));
		return distance;
	}
}
