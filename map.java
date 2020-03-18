import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
public class map extends Application
{
    int matrix[][] =     {{0,0,0,0,1,0,0,0},
						  {0,0,0,0,0,0,0,0},
						  {0,0,9,9,9,0,0,0},
						  {0,0,0,9,0,0,0,0},
						  {0,0,0,9,0,0,0,0},
						  {0,0,0,0,0,0,0,0},
						  {0,0,0,3,0,0,0,0},
						  {0,0,0,0,0,0,0,0}};

    GridPane grid = new GridPane();
    Button buttons[][] = new Button[8][8];
    int row;
    int col;

    @Override
    public void start(Stage board)
    {
       
        for (row = 0; row < buttons.length; row++)
        {
            for (col = 0; col < buttons[row].length; col++)
            {      
                buttons[row][col] = new Button("", null);
                buttons[row][col].setPrefSize(100, 100);
                buttons[row][col].setStyle("-fx-background-color: grey; -fx-border-color: white;");
                grid.add(buttons[row][col], col, row);
            }
        }

        Point start = new Point(4, 0, 0);
		Point end = new Point(3, 6, 0);
		Algorithm alg = new Algorithm(start, end);
		ArrayList<Point> path = alg.find(matrix);
		for (Point point : path)
		{
			matrix[point.getY()][point.getX()] = 2;
		}

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
    // start = 1, end = 3, path = 2, obsticle = 9
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
                }
            }
        }
    }
}