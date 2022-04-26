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
