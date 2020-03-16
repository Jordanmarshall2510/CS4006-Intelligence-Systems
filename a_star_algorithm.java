/*

	Obstacle = -1
	Empty = null
	Path = 1
	StartPoint = 0
	EndPoint = 2

	setValue(int [][])
	getValue()
	setStartValue()
	setEndValue()
	setObstacle()
	
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

import java.utils.*;

public class a_star_algorithm
{
	static int[][] matrix = new int[8][8];

	public static void main (String args[])
	{

	}

	public static void setValue(int x, int y, int value){
		matrix [x][y] = value;
	}

	public static int getValue(int x, int y){
		return matrix [x][y];
	}

	public static void setStartValue(int x, int y){
		matrix [x][y] = 0;
	}

	public static void setEndValue(int x, int y){
		matrix [x][y] = 2;
	}

}
