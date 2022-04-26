Skip to line 92 for GUI documnentation.

# Node class
Attributes:
- int x
- int y
- int degree
- int orderVisited
- boolean isVisited
- Node nextNode

### Methods

setX(int x)
:sets the x atribute of a node instance

setY(int y)
: sets the y atribute of a node instance

setDegree(int degree)
: sets the degree atribute of a node instance

setOrderVisited(int order)
: sets the orderVisited atribute of a node instance

setIsVisited(boolean visited)
: sets the isVisited atribute of a node instance

setNextNode(Node* next)
: sets the nextNode atribute of a node instance

getX()
: returns the x atribute of a node instance

getY()
: returns the y atribute of a node instance

getDegree()
: returns the degree atribute of a node instance

getOrderVisited()
: returns the orderVisited atribute of a node instance

getIsVisited()
: returns the isVisited atribute of a node instance

getNextNode()
: returns a node pointer which is the nextNode atribute of a node instance

# Board class
Attributes:
- int x
- int y
- int maxLength
- int totalNodes
- ArrayList<Node> allNodes
- map chessBoard

### Methods
createAllNodes(int x,int y,int counter,ArrayList<Node> allNodes)
: Creats all unique nodes on the heap and stores the pointers inside allNodes attribute.

findNode(int x, int y, int index, Node node)
: Should recursively look for an already existing node with the given x & y attributes, returns a pointer to the instance.

findNeighbors(int x, int y, int index, ArrayList<Node> neighbors)
: Given an x and y value should find all the leagal nodes that can be visited from the current spot.
: Returns a ArrayList containing Node pointers.

connectAllNodes(int x, int y, int counter)
: For all nodes inside allNodes, it should find its neighbors. Then set the nodes degree, then insert the node and its neighbors as a key value pair inside chessBoard.
 
createBoard()
: Simply constructs the board by calling createAllNodes, and connectAllNodes.
 
printBoard()
: prints a numbered grid to the console. Each spot in the grid repreents a spot on a chess board. The numbers assosiated with each spot represents the order in echich it was visited.

paddOutput(int number,String filler)
: At higher board dimensions the printed out put from printBoard becomes unsymetrical and unreadable. This method padds each spot on the grid to make it symetrical.

updateDegree(Node node)
: updates the degree of a given node by checking how many of its neighbors have not been visited. The digree is then reset to the current number of unvisited neighbors.
  
findNeighborWithLeastDegree(Node node)
: Given a node, it will ittereate through all of its neighbors and find the neighbor with the least value in its degree attribute.
: returns a node pointer to the node with the least degree.
  
makeTour(Node startSpot)
: given a starting node, it should traverse the gameboard and try to visit all of the spots. if it can visit a spot, it will alter the node representing the spot by setting its orderVisited attribute to a numeric value. This numeric value is generate by a counter variable.
: returns a linked list containing the sequence of the tour. 

  
  # Gui components

# Disclaimer
There are some ristrictions to the Gui. The first restriction is that the x and y dimensions must be the same or the gui will show an inaccurate tour.
The second restriction is that the dimensions of the board is consistant up to a 32x32 board, everything passed that is undefined. I have managed to make it work on 
a 80x80 board but not consistantly.
 
# AutoTour Class
This class is responsiable for displaying the gui. The gui will consist of multiple buttons on the screen, each button corrisponds to a spot on the gameboard. 
This class is also responsiable for reacting to button clicks, by changing the buttons color to black, inbdicating that it was visited.

Attributes:
- int x
- int y
- int totalButtons
- JButton[] allButtons
- JFrame window
- JPanel gameBoard
### Methods
sleep(int delay)
: Stops the program from running for a given duration (delay in miliseconds).

actionPerformed()
: reacts to a button being pressed on the screen, and alters the buttons color to black.

# launchPage class
The primary purpose of this class is to just collect information to make the program run.
Then return said information in a tuple of 4 elements.

Attributes:
- Tuple<Integer,Integer,Integer,Integer,Integer> positions
- JFrame window
- JPanel inputs
- JTextField boardX
- JLabel boardLable
- JTextField boardY
- JTextField posistionX
- JLabel positionLable
- JTextField positionY
- JLabel delayLable
- JTextField delayInput
- JButton startButton

### Methods
returnValues()
: returns a tuple containing all the information in the fields.

actionPerformed()
: collects all the information from the feild and converts them to integers, then constructs positions tuple with the given information.

# Main class
this class is in charge of running everything together. It waits till the fields from the launchPage has information, once it has the necissary information it starts displaying the tour.

### Methods
static void sleep(int delay)
: Stops the program from running for a given duration (delay in miliseconds).
