import java.util.ArrayList;

public class textAlgorithm
{
	public static void main(String args[])
	{
		int matrix[][] = {{0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,3,0,0},
						  {0,0,9,9,9,0,0,0},
						  {0,0,0,9,0,0,0,0},
						  {0,1,0,9,0,0,0,0},
						  {0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0}};

		Point start = new Point(1, 4);
		Point end = new Point(5, 1);
		Algorithm alg = new Algorithm(start, end);
		ArrayList<Point> path = alg.find(matrix);
		for (Point point : path)
		{
			matrix[point.getRow()][point.getCol()] = 2;
		}

		for (int[] row : matrix)
		{
			for (int val : row)
			{
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}