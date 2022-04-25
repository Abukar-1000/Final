#include "node.h"
#include <iostream>

Node::Node() {
	this->x = 0;
	this->y = 0;
	this->degree = 0;
	this->orderVisited = 0;
	this->isVisited = false;
	this->nextNode = NULL;
}

Node::Node(int x,int y) {
	this->x = x;
	this->y = y;
	this->degree = 0;
	this->orderVisited = 0;
	this->isVisited = false;
	this->nextNode = NULL;
}

void Node::setDegree(int degree) {
	this->degree = degree;
}
void Node::setX(int x) {
	this->x = x;
}
void Node::setY(int y) {
	this->y = y;
}
void Node::setOrderVisited(int order) {
	this->orderVisited = order;
}
void Node::setIsVisited(bool isVisited) {
	this->isVisited = isVisited;
}
void Node::setNextNode(Node* next) {
	this->nextNode = next;
}

int Node::getX() {
	return this->x;
}
int Node::getY() {
	return this->y;
}
int Node::getDegree() {
	return this->degree;
}
int Node::getOrderVisited() {
	return this->orderVisited;
}
bool Node::getIsVisited() {
	return this->isVisited;
}
Node* Node::getNextNode() {
	return this->nextNode;
}