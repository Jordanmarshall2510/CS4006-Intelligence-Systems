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
		ArrayList<Point> res = new ArrayList<Point>();
		current.setVal(current.getG() + manhattenDistance(current, end));
		open.add(current);
		while (!open.isEmpty())
		{
			if (current.equals(end))
			{
				break;
			}
		}
		return res;
	}

	private ArrayList<Point> getPoints(Point n)
	{
		ArrayList<Point> points = new ArrayList<Point>();
		
		int x = n.getX();
		int y = n.getY();
		if (x + 1 < 8)
		{
			Point newPoint = new Point(x+1, y, n.getG()+1);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (x - 1 >= 0)
		{
			Point newPoint = new Point(x-1, y, n.getG()+1);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (y + 1 < 8)
		{
			Point newPoint = new Point(x, y+1, n.getG()+1);
			newPoint.setVal(newPoint.getG() + manhattenDistance(newPoint, end));
			points.add(newPoint);
		}
		if (y - 1 >= 0)
		{
			Point newPoint = new Point(x, y-1, n.getG()+1);
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

/*
        A   B   C   D   E   F   G   H
    1 [  ][  ][  ][  ][  ][  ][  ][  ]
    2 [  ][  ][  ][  ][  ][2 ][  ][  ]
    3 [  ][  ][-1][-1][-1][  ][  ][  ]
    4 [  ][  ][  ][-1][  ][  ][  ][  ]
    5 [  ][  ][  ][-1][  ][  ][  ][  ]
    6 [  ][0 ][  ][-1][  ][  ][  ][  ]
    7 [  ][  ][  ][  ][  ][  ][  ][  ]
    8 [  ][  ][  ][  ][  ][  ][  ][  ]
*/
