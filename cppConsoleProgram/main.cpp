#include <iostream>
#include <map>
#include <tuple>
#include <vector>
#include "node.h"
#include "spot.h"
#include "board.h"
#include <sstream>
#include <typeinfo>

std::tuple<int,int> getStartingPositions(std::string text) {
	int values[2] = {};
	std::cout << text;
	std::string input;
	std::stringstream converter;
	std::stringstream container;
	std::getline(std::cin, input);
	container << input;
	int index = 0;
	while (std::getline(container, input, ',')) {
		converter << input;
		converter >> values[index];
		converter.clear();
		index++;
	}
	return std::make_tuple(values[0], values[1]);
}
int main() {
	int boardXPosition,boardYPositions;
	int startingXPosition, startingYPosition;
	std::tuple<int, int> boardPositions;
	std::tuple<int, int> startingPositions;
	boardPositions = getStartingPositions("Enter Board Dimensions x,y:	");
	boardXPosition = std::get<0>(boardPositions);
	boardYPositions = std::get<1>(boardPositions);
	Board gameBoard(boardXPosition,boardYPositions);
	gameBoard.createBoard();
	startingPositions = getStartingPositions("Enter Starting Position x,y:	");
	startingXPosition = std::get<0>(startingPositions);
	startingYPosition = std::get<1>(startingPositions);
	Node* startSpot = gameBoard.findNode(startingXPosition, startingYPosition, 0, NULL);
	gameBoard.makeTour(startSpot);
	gameBoard.printBoard();
	//std::cout << "refreshed";
	return 0;
}