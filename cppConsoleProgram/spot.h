#pragma once
#ifndef SPOT_H_EXISTS
#define SPOT_H_EXISTS
#include "node.h"

class Spot {
	private:
		Node* node;
		Spot* neighbors;
	public:
		Spot();
		Spot(Node* node, Spot* neighbors);
		void setNode(Node* node);
		void setNeighbors(Spot* neighbors);
		Node* getNode();
		Spot* getNeighbors();
};
#endif // !SPOT_H_EXISTS
