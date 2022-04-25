#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <exception>
#include "board.h"
#include "node.h"

Board::Board() {
	this->x = 8;
	this->y = 8;
	this->maxLength = this->x - 1;
	this->totalNodes = this->x * this->y;
}
Board::Board(int x, int y) {
	this->x = x;
	this->y = y;
	this->maxLength = x - 1;
	this->totalNodes = x * y;
}
Board::~Board() {
	for (auto node : this->allNodes) {
		free(node);
	}
	this->allNodes.clear();
}
std::vector<Node*> Board::createAllNodes(int x, int y, int counter,std::vector<Node*> allNodes) {
	if (counter == this->totalNodes) {
		return allNodes;
	}
	else if (x > this->maxLength) {
		x = 0;
		return createAllNodes(x, y + 1, counter, allNodes);
	}
	else {
		Node* newNode = new Node(x, y);
		allNodes.push_back(newNode);
		//free(newNode);
		return createAllNodes(x + 1, y, counter + 1, allNodes);
	}
}
Node* Board::findNode(int x, int y, int index,Node* node) {
	/*
	* should find a node with the given x,y values from allocated nodes on the heap
	*/
	if (node != NULL) {
		if ((node->getX() == x) && (node->getY() == y)) {
			return node;
		} else {
			node = this->allNodes[index];
			return findNode(x, y, index + 1, node);
		}
	}
	else {
		node = this->allNodes[index];
		return findNode(x, y, index + 1, node);
	}
}
std::vector<Node*> Board::findNeighbors(int x, int y, int index, std::vector<Node*> neighbors) {
	/*
	given an x and y value should find all the leagal nodes that can be visited from the current spot
	*/
	const int size = 8;
	int xOffsets[size] = { 1, -1, 1, -1, 2, -2, 2, -2 };
	int yOffsets[size] = { 2, 2, -2, -2, 1, 1, -1, -1 };
	if (index == size) {
		return neighbors;
	} else {
		/*
			create new x & y values 
			sanitize x & y values
		*/
		int newX = x + xOffsets[index];
		int newY = y + yOffsets[index];
		if ((newX >= 0) && (newX <= this->maxLength)) {
			if ((newY >= 0) && (newY <= this->maxLength)) {
				Node* neighbor = this->findNode(newX, newY, 0, NULL);
				neighbors.push_back(neighbor);
			}
		}
		return findNeighbors(x, y, index + 1, neighbors);
	}
}
void Board::connectAllNodes(int x, int y, int counter) {
	/*
		from a given node it should 
		find its neighbors
		set the nodes degree
		insert values into gameboard map
	*/
	if (counter == this->totalNodes) {
		return;
	}
	else if ( x > this->maxLength) {
		x = 0;
		return connectAllNodes(x, y + 1, counter);
	} 
	else {
		Node* currentNode = this->findNode(x, y, 0, NULL);
		std::vector<Node*> neighbors = this->findNeighbors(x, y, 0, neighbors);
		currentNode->setDegree(neighbors.size());
		this->chessBoard.insert({ currentNode,neighbors });
		return connectAllNodes(x + 1, y, counter + 1);
	}
}
void Board::createBoard() {
	/*
	constructs the gameboard 
	*/
	std::vector<Node*> constructor;
	this->allNodes = this->createAllNodes(0, 0, 0, constructor);
	this->connectAllNodes(0, 0, 0);
	
}
std::string Board::padOutput(int number,std::string filler) {
	/*
	based on the max number of nudes 
	should padd the input number
	*/
	std::string maxNumber;
	std::string result = "";
	std::stringstream container;
	container << this->totalNodes;
	container >> maxNumber;
	if (number > 0) {
		std::string input;
		container.clear();
		container << number;
		container >> input;
		int padding = maxNumber.length() - input.length();
		for (int x = 0; x < padding; ++x) {
			result += filler;
		}
		result += input;
		return result;
	}
	else {
		int padding = maxNumber.length();
		for (int x = 0; x < padding; ++x) {
			result += filler;
		}
		return result;
	}
}
void Board::printBoard() {
	/*
		should just print the chess board | and create padding to make the output symetrical
	*/
	int counter = 0;
	int boundry = this->maxLength + 1;
	for (int x = 0; x < this->allNodes.size(); ++x) {
		Node* currentNode = this->allNodes[x];
		if (counter % boundry == 0) {
			std::cout << "\n";
		}
		if (currentNode->getOrderVisited() != 0) {
			int order = currentNode->getOrderVisited();
			std::cout << this->padOutput(order,"0") << " ";
		}
		else {
			int order = currentNode->getOrderVisited();
			std::cout << this->padOutput(order,"X") << " ";
		}
		counter++;
	}
}
void Board::updateDegree(Node* node) {
	/*
		given a node | updates its degree value 
		called if a node is visited
		find node & get neighbors
		check if neighbor has been visited | if so don't increment degree
		increment degree
		set new degree
	*/
	int degree = 0;
	std::vector<Node*> neighbors = this->chessBoard.find(node)->second;
	for (int index = 0; index < neighbors.size(); ++index) {
		Node* currentNode = neighbors[index];
		if (currentNode->getIsVisited() == false) {
			degree++;
		}
	}
	node->setDegree(degree);
}
Node* Board::findNeighborWithLeastDegree(Node* node) {
	/*
		finds the neighbor with the least amount of moves available from it
	*/
	int minimum = 10;
	Node* result = NULL;
	std::vector<Node*> neighbors = this->chessBoard.find(node)->second;
	for (int index = 0; index < neighbors.size(); ++index) {
		Node* currentNode = neighbors[index];
		this->updateDegree(currentNode);
		if ((currentNode->getDegree() <= minimum) && (currentNode->getIsVisited() == false)) {
			minimum = currentNode->getDegree();
			result = currentNode;
		}
	}
	return result;
}
void Board::makeTour(Node* startSpot) {
	/*
	given a starting node | should traverse the board and tour
	*/
	Node* currentSpot = startSpot;
	int counter = 1;
	bool keepGoing = true;
	while (keepGoing) {
		if (counter == this->totalNodes) {
			keepGoing = false;
		}
		if (currentSpot != NULL) {
			currentSpot->setOrderVisited(counter);
			currentSpot->setIsVisited(true);
			this->updateDegree(currentSpot);
			Node* nextMove = this->findNeighborWithLeastDegree(currentSpot);
			currentSpot = nextMove;
			counter++;
		}
		else {
			std::cout << "cant complete tour from here :( -> try another spot. \nHeres my best attempt:";
			keepGoing = false;
		}
	}
}