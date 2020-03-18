import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import java.util.Arrays;

public class map extends Application
{
	int matrix[][] = new int[8][8];

	GridPane grid = new GridPane();
	Button buttons[][] = new Button[8][8];
	int row;
	int col;
	int letter;
	boolean startExist = false, endExist = false, pathExist = false;
	Point start, end;

	@Override
	public void start(Stage board)
	{
		for(int row[] : matrix)
		{
			Arrays.fill(row, 0);
		}

		for (row = 0; row < buttons.length; row++)
		{
			for (col = 0; col < buttons[row].length; col++)
			{      
				buttons[row][col] = new Button("", null);
				buttons[row][col].setPrefSize(100, 100);
				buttons[row][col].setStyle("-fx-background-color: grey; -fx-border-color: white;");
				grid.add(buttons[row][col], col, row);

				buttons[row][col].setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e){
						if (!pathExist)
						{
							if(!endExist)
							{
								for (int row = 0; row < buttons.length; row++)
								{
									for (int col = 0; col < buttons[row].length; col++)
									{
										if (buttons[row][col] == e.getSource() && !startExist && matrix[row][col] == 0)
										{
											setStartColour(row, col);
											start = new Point(row, col);
											startExist = true;
											matrix [row][col] = 1;
										}
										else if(buttons[row][col] == e.getSource()&& matrix[row][col] == 0)
										{
											setEndColour(row, col);
											end = new Point(row, col);
											endExist = true;
											matrix [row][col] = 3;
										}
									}
								}
							}
							else
							{
								Algorithm alg = new Algorithm(start, end);
								ArrayList<Point> path = alg.find(matrix);
								for (Point point : path)
								{
									matrix[point.getRow()][point.getCol()] = 2;
								}
								buttonChecker();
								pathExist = true;
							}
						}
						else
						{
							for (int row[] : matrix)
							{
								Arrays.fill(row, 0);
							}
							startExist = false;
							endExist = false;
							pathExist = false;
							genObstacle();
							buttonChecker();
						}
					}
				});
			}
		}

		genObstacle();
		buttonChecker();
	   
		Scene scene = new Scene(grid, 800, 800);
	   
		board.setTitle("A* Algorithm");
		board.setScene(scene);
		board.show();
	}

	public void setObstacleColour(int row, int col){
		buttons[row][col].setStyle("-fx-background-color: black; -fx-border-color: white;");
	}
   
	public void setStartColour(int row, int col){
		buttons[row][col].setStyle("-fx-background-color: green; -fx-border-color: white;");
	}

	public void setEndColour(int row, int col){
		buttons[row][col].setStyle("-fx-background-color: red; -fx-border-color: white;");
	}

	public void setPathColour(int row, int col){
		buttons[row][col].setStyle("-fx-background-color: blue; -fx-border-color: white;");
	}

	public void setDefaultColour(int row, int col){
		buttons[row][col].setStyle("-fx-background-color: grey; -fx-border-color: white;");
	}

	public void buttonChecker(){
		for (int x = 0; x < matrix.length; x++)
		{
			for (int y = 0; y < matrix[x].length; y++)
			{
				if(matrix[x][y]==1){
					setStartColour(x, y);
				}else if(matrix[x][y]==3){
					setEndColour(x, y);
				}else if(matrix[x][y]==2){
					setPathColour(x, y);
				}else if(matrix[x][y]==9){
					setObstacleColour(x, y);
				}else if(matrix[x][y]==0){
					setDefaultColour(x, y);
				}
			}
		}
	}

	public void genObstacle(){
		int letter, row, col;
		// Num gens
		letter =(int)(Math.random()* 4); // 0 -> 3
		row = (int)(Math.random() * 8); // 0 -> 7
		col = (int)(Math.random() * 8); // 0 -> 7
	
		if(letter == 0){
			if(row+2 > 7){
				row = 5;
			}
			if (col+2 > 7)
			{
				col = 5;
			}
			
			for(int i = 0; i < 3; i++ ){
                matrix [row][col+i] = 9;
                matrix [row+i][col+1] = 9;
            }

			//T

        }
        else if(letter == 1){
			//I
			if (row+2 > 7)
			{
				row = 5;
			}

			for (int i = 0; i < 3; i++)
			{
				matrix[row+i][col] = 9;
			}
		}
		else if(letter == 2)
		{
			//L
			if (row+2 > 7)
			{
				row = 5;
			}
			if (col+1 > 7)
			{
				col = 6;
			}

			for (int i = 0; i < 3; i++)
			{
				matrix[row+i][col] = 9;
			}
			matrix[row+2][col+1] = 9;
        }
        else if(letter == 3)
		{
			//Random
			for(int i = 0; i < 25; i++){
                matrix [(int)(Math.random() * 8)][(int)(Math.random() * 8)] = 9;
            }
        }
    
	}
}