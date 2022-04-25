
public class CreatTour {

    private Tuple<Integer,Integer,Integer,Integer,Integer> positions;
    CreatTour(Tuple<Integer,Integer,Integer,Integer,Integer> position){
        this.positions = position;
        int xDimension = this.positions.getFirst();
        int yDimension = this.positions.getSecond();
        int xStartingSpot = this.positions.getThird();
        int yStartingSpot = this.positions.getFourth();
        int delayInMs = this.positions.getFifth();
        int area = xDimension * yDimension;
        
        Board gameBoard = new Board(xDimension,yDimension);
        gameBoard.createBoard();
        Node startSpot = gameBoard.findNode(xStartingSpot, yStartingSpot, 0, null);
        Node path = gameBoard.makeTour(startSpot);
        gameBoard.printBoard();
        AutoTour auto = new AutoTour(xDimension,yDimension);
        for (int x = 0; x < area; ++x){
            int index = (path.getY() * xDimension) + path.getX();
            auto.clickButton(index,delayInMs);
            path = path.getNextNode();
        }
    }
}
