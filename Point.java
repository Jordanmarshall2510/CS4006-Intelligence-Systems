public class Point
{
	private int x;
	private int y;
	private int g; // distance from start
	private int val; // score
	private Point parent;

	public Point(int x, int y, int g)
	{
		this.x = x;
		this.y = y;
		this.g = g;
		this.parent = null;
	}

	public Point(int x, int y, int g, Point parent)
	{
		this.x = x;
		this.y = y;
		this.g = g;
		this.parent = parent;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public int getG()
	{
		return this.g;
	}

	public int getVal()
	{
		return this.val;
	}

	public Point getParent()
	{
		return this.parent;
	}

	public void setX(int newX)
	{
		this.x = newX;
	}

	public void setY(int newY)
	{
		this.y = newY;
	}

	public void setG(int newG)
	{
		this.g = newG;
	}

	public void setVal(int newVal)
	{
		this.val = newVal;
	}

	public boolean equals(Point other)
	{
		return this.x == other.x && this.y == other.y;
	}
}