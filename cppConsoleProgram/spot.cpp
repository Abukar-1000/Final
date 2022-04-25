#include <iostream>
#include "spot.h"
#include "node.h"

Spot::Spot() {
	this->node = NULL;
	this->neighbors = NULL;
}
Spot::Spot(Node* node, Spot* neighbors) {
	this->node = node;
	this->neighbors = neighbors;
}
void Spot::setNode(Node* node) {
	this->node = node;
}
void Spot::setNeighbors(Spot* neighbor) {
	this->neighbors = neighbor;
}
Node* Spot::getNode() {
	return this->node;
}
Spot* Spot::getNeighbors() {
	return this->neighbors;
}