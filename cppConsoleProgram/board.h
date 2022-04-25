#include "node.h"
#include <iostream>
#include <vector>
#include <map>
#ifndef BOARD_H_EXISTS
#define BOARD_H_EXISTS

class Board {
	private:
		int x;
		int y;
		int maxLength;
		int totalNodes;
		std::vector<Node*> allNodes;
		std::map<Node*, std::vector<Node*>> chessBoard;
	public:
		Board();
		Board(int x, int y);
		~Board();
		std::vector<Node*> createAllNodes(int x,int y,int counter,std::vector<Node*> allNodes);
		Node* findNode(int x, int y, int index, Node* node);
		std::vector<Node*> findNeighbors(int x, int y, int index, std::vector<Node*> neighbors);
		void connectAllNodes(int x, int y, int counter);
		void createBoard();
		void printBoard();
		std::string padOutput(int number,std::string filler);
		void updateDegree(Node* node);
		Node* findNeighborWithLeastDegree(Node* node);
		void makeTour(Node* startSpot);
};
#endif // !BOARD_H_EXISTS

