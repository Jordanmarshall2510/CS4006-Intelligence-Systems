public class Point
{
	private int x;
	private int y;
	private int val;

	public Point(int x, int y, int val)
	{
		this.x = x;
		this.y = y;
		this.val = val;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public int getVal()
	{
		return this.val;
	}

	public void setX(int newX)
	{
		this.x = newX;
	}

	public void setY(int newY)
	{
		this.y = newY;
	}

	public void setVal(int newVal)
	{
		this.val = newVal;
	}
}