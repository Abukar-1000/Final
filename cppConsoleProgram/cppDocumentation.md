# Disclaimer
I just realised while uploading to tesla this moring that I was compiling to c++ 14 on my machine and my program was incompatable with c++ 11. Unfortunately I was getting a std bad alloc error.
The program does run sometimes, but it is very likely that you will run into the same issue. In the event that you do run into this issue, I rewrote the program in java and that one works just fine.

# Node class
Attributes:
- int x
- int y
- int degree
- int orderVisited
- bool isVisited
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

setIsVisited(bool visited)
: sets the isVisited atribute of a node instance

setNextNode(Node* next)
: sets the nextNode atribute of a node instance

getX()
: gets the x atribute of a node instance

getY()
: gets the y atribute of a node instance

getDegree()
: gets the degree atribute of a node instance

getOrderVisited()
: gets the orderVisited atribute of a node instance

getIsVisited()
: gets the isVisited atribute of a node instance

getNextNode()
: gets the nextNode atribute of a node instance

