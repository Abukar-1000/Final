import java.util.*;

public class Board {
    private int x;
    private int y;
    private int maxLength;
    private int totalNodes;
    private ArrayList<Node> allNodes = new ArrayList<Node>();
    private HashMap<Node,ArrayList<Node>> gameboard = new HashMap<Node,ArrayList<Node>>();

    Board(){
        /*
        dafault 8x8 board 
        */
        this.x = 8;
        this.y = 8;
        this.maxLength = this.x - 1;
        this.totalNodes = this.x * this.y;
    }
    Board(int x,int y){
        /*
        If User chooses a different board 
        */
        this.x = x;
        this.y = y;
        this.maxLength = this.x - 1;
        this.totalNodes = this.x * this.y;
    }
    public ArrayList<Node> createAllNodes(int x, int y, int counter,ArrayList<Node> allNodes){
        /* 
        creates all the nodes 
        each node represents a spot on the gameboard
        */
        if (counter == this.totalNodes) {
            return allNodes;
        }
        else if (x > this.maxLength) {
            x = 0;
            return createAllNodes(x, y + 1, counter, allNodes);
        }
        else {
            Node newNode = new Node(x, y);
            allNodes.add(newNode);
            return createAllNodes(x + 1, y, counter + 1, allNodes);
        }
    }
    public Node findNode(int x, int y, int index,Node node){
        /*
        should find an already existing node with the given x,y values
        */
        if (node != null) {
            if ((node.getX() == x) && (node.getY() == y)) {
                return node;
            } else {
                node = this.allNodes.get(index);
                return findNode(x, y, index + 1, node);
            }
        }
        else {
            node = this.allNodes.get(index);
            return findNode(x, y, index + 1, node);
        }
    }
    public ArrayList<Node> findNeighbors(int x, int y, int index, ArrayList<Node> neighbors){
        /*
	given an x and y value should find all the leagal nodes that can be visited from the current spot
	*/
	int size = 8;
	int xOffsets[] = { 1, -1, 1, -1, 2, -2, 2, -2 };
	int yOffsets[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
	if (index == size) {
		return neighbors;
	} else {
		/*
			create new x & y values 
			sanitize x & y values
		*/
		int newX = x + xOffsets[index];
		int newY = y + yOffsets[index];
		if ((newX >= 0) && (newX <= this.maxLength)) {
			if ((newY >= 0) && (newY <= this.maxLength)) {
				Node neighbor = this.findNode(newX, newY, 0, null);
				neighbors.add(neighbor);
			}
		}
		return findNeighbors(x, y, index + 1, neighbors);
	}
    }
    public int connectAllNodes(int x, int y, int counter){
        /*
		from a given node it should 
		find its neighbors
		set the nodes degree
		insert values into gameboard map
	*/
	if (counter == this.totalNodes) {
		return 1;
	}
	else if ( x > this.maxLength) {
		x = 0;
		return connectAllNodes(x, y + 1, counter);
	} 
	else {
		Node currentNode = this.findNode(x, y, 0, null);
        ArrayList<Node> container = new ArrayList<Node>();
		ArrayList<Node> neighbors = this.findNeighbors(x, y, 0, container);
		currentNode.setDegree(neighbors.size());
		this.gameboard.put(currentNode, neighbors);
		return connectAllNodes(x + 1, y, counter + 1);
	}
    }
    public void createBoard() {
        /*
        constructs the gameboard 
        */
        ArrayList<Node> constructor = new ArrayList<Node>();
        this.allNodes = this.createAllNodes(0, 0, 0, constructor);
        this.connectAllNodes(0, 0, 0);      
    }
    public void updateDegree(Node node) {
        /*
            given a node | updates its degree value 
            called if a node is visited
            find node & get neighbors
            check if neighbor has been visited | if so don't increment degree
            increment degree
            set new degree
        */
        int degree = 0;
        ArrayList<Node> neighbors = this.gameboard.get(node);
        for (int index = 0; index < neighbors.size(); ++index) {
            Node currentNode = neighbors.get(index);
            if (currentNode.getIsVisited() == false) {
                degree++;
            }
        }
        node.setDegree(degree);
    }
    public Node findNeighborWithLeastDegree(Node node) {
        /*
            finds the neighbor with the least amount of moves available from it
        */
        int minimum = 10;
        Node result = null;
        ArrayList<Node> neighbors = this.gameboard.get(node);
        for (int index = 0; index < neighbors.size(); ++index) {
            Node currentNode = neighbors.get(index);
            this.updateDegree(currentNode);
            if ((currentNode.getDegree() <= minimum) && (currentNode.getIsVisited() == false)) {
                minimum = currentNode.getDegree();
                result = currentNode;
            }
        }
        return result;
    }
    public int insertNode(Node item,Node linkedList){
        /*
        adds a node to the end of a linked list
        */
        if (item == linkedList){
            return 1;
        }
        if (linkedList.getNextNode() == null){
            linkedList.setNextNode(item);
            return 1;
        } else {
            linkedList = linkedList.getNextNode();
            return insertNode(item, linkedList);
        }
    }
    public void printBoard(){
        /*
            should just print the chess board | and create padding to make the output symetrical
        */
        int counter = 0;
        int boundry = this.maxLength + 1;
        for (int x = 0; x < this.allNodes.size(); ++x) {
            Node currentNode = this.allNodes.get(x);
            if (counter % boundry == 0) {
                System.out.print("\n");
            }
            if (currentNode.getOrderVisited() != 0) {
                int order = currentNode.getOrderVisited();
                if ( order < 10){
                    System.out.print("0" + order + " ");
                } else {
                    System.out.print(order + " ");
                }
            }
            counter++;
        }
    }
    public Node makeTour(Node startSpot){
    /*
	given a starting node | should traverse the board and tour
	*/
	Node currentSpot = startSpot;
    Node path = startSpot;
	int counter = 1;
	boolean keepGoing = true;
	while (keepGoing) {
		if (counter == this.totalNodes) {
			keepGoing = false;
		}
		if (currentSpot != null) {
			currentSpot.setOrderVisited(counter);
			currentSpot.setIsVisited(true);
			this.updateDegree(currentSpot);
			Node nextMove = this.findNeighborWithLeastDegree(currentSpot);
            this.insertNode(currentSpot, path);
			currentSpot = nextMove;
			counter++;
		}
		else {
            /*
            dead end | end loop
             */
			keepGoing = false;
		}
	}
    return path;
    }
    // public static void main(String[] args){
    //     Board gameBoard = new Board(8,8);
    //     gameBoard.createBoard();
    //     Node startSpot = gameBoard.findNode(0, 0, 0, null);
    //     Node path = gameBoard.makeTour(startSpot);
    //     gameBoard.printBoard();
    //     int counter = 0;
    //     while (path != null){
    //         if (counter % 8 == 0){
    //             System.out.print("\n");
    //         }
    //         int index = (path.getY() * 8) + path.getX();
    //         System.out.print("(" + index +")");
    //         path = path.getNextNode();
    //         counter++;
    //     }
    // }
}
