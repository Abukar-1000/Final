#ifndef NODE_H_EXISTS
#define NODE_H_EXISTS

class Node {
	private:
		int x;
		int y;
		int degree;
		int orderVisited;
		bool isVisited;
		Node* nextNode;
	public:
		Node();
		Node(int x, int y);
		void setX(int x);
		void setY(int y);
		void setDegree(int degree);
		void setOrderVisited(int order);
		void setIsVisited(bool visited);
		void setNextNode(Node* next);

		int getX();
		int getY();
		int getDegree();
		int getOrderVisited();
		bool getIsVisited();
		Node* getNextNode();
};
#endif // !NODE_H_EXISTS
