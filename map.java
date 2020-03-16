import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
 
public class map extends Application
{  

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

        setObstacleColour(2,2);
        setObstacleColour(2,3);
        setObstacleColour(2,4);
        setObstacleColour(3,3);
        setObstacleColour(4,3);
        setObstacleColour(5,3);

        setStartColour(1,5);
        setEndColour(5,1);


       
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
}