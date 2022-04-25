import java.util.*;

public class ConsoleMain {
    public Tuple1<Integer,Integer> getStartingPositions(String input){
        System.out.println(input);
        Scanner scanner = new Scanner(System.in);
        String stringDimensions = scanner.nextLine();
        String[] container = stringDimensions.split(",");
        //scanner.close();
        int xValue = Integer.parseInt(container[0]);
        int yValue = Integer.parseInt(container[1]);
        Tuple1<Integer,Integer> result = new Tuple1<Integer,Integer>(xValue,yValue);
        return result;
    }
    public static void main(String[] args){
        ConsoleMain tools = new ConsoleMain();
        int boardXPosition;
        int boardYPositions;
	    int startingXPosition;
        int startingYPosition;
        Tuple1<Integer,Integer> boardPositions = tools.getStartingPositions("Enter Board Dimensions:    ");
        boardXPosition = boardPositions.getFirst();
        boardYPositions = boardPositions.getSecond();
        Board gameBoard = new Board(boardXPosition,boardYPositions);
        gameBoard.createBoard();
        Tuple1<Integer, Integer> startingPositions = tools.getStartingPositions("Enter Starting x,y:    ");
        startingXPosition = startingPositions.getFirst();
        startingYPosition = startingPositions.getSecond();
        Node startingSpot = gameBoard.findNode(startingXPosition, startingYPosition, 0, null);
        gameBoard.makeTour(startingSpot);
        gameBoard.printBoard();
    }
}
