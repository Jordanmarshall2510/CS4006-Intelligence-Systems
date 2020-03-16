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

		Algorithm alg = new Algorithm(new Point(4, 1, 0), new Point(1, 5, 0));
		ArrayList<Point> path = alg.find(matrix);
		for (Point point : path)
		{
			matrix[point.getY()][point.getX()] = 1;
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