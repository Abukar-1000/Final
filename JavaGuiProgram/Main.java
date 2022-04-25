
public class Main {
    
    public static void sleep(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args){
        launchPage launcher = new launchPage();
        while (launcher.returnValues() == null){
            Main.sleep(1000);
        }
        Tuple<Integer,Integer,Integer,Integer,Integer> positions = launcher.returnValues();
        int xDimension = positions.getFirst();
        int yDimension = positions.getSecond();
        int xStartingSpot = positions.getThird();
        int yStartingSpot = positions.getFourth();
        int delayInMs = positions.getFifth();
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
