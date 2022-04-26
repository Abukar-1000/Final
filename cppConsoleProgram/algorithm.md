# Goals
To solve the knights tour puzzle.
The knights piece must visit every spot on a chess board once and only once.
# Inputs
x,y input that represents the dimensions for the chess board.
x,y input that represents the starting spot on the chess board.

# Outputs
Should print a grid representing the chess board.
Each spot on the grid corrisponds to the same position on a chess board.
Each spot will have a numeric value indicating when it was visited.
# steps

First create a node class. Each instance of the node class will represent a position on the chess board.
Each Node instance will have:
- x position (int)
- y position (int)
- degree (int)
- order visited (int)
- is visited (boolean)
- a pointer to the next node (Node)

Next I created the board class, which will represent the chess Board.
Attributes of the board class will be:
- x dimension (int)
- y dimension (int)
- maxLength (int)
- total Nodes (int)
- container for all my unique nodes
- map connecting the chess board

Contructing the board:
Using the x and y dimension properties, I will construct the dimension of the game board.
Then knowing the Area of the gameboad I can construct all of the unique nodes that I will need.

There are 3 crutial steps to ensure my algorithm works:
- create unique nodes.
- construct my map
  - set the degree of each node 
- update the degree of each node 

## Create Unique Nodes
I decided to make sure the Node instances should be unique because I will be using them as keys inside my map.
When the key is passed into the dictionary it will return a container containing instances of Nodes containing valid positions I can visit.
To make sure I am only using already created Nodes, I will implement a method findNode and it will take in x and y values in its perameters.
Then it will recursively search my container of nodes for a node with the given x and y values. It will then return that node.
## Constructing my map
Next I will have a method to construct my map. It will take in a node's x & y values, and then mathamatically apply offsets to generate legal positions.
Then I will find the nodes with the given legal position and create a container containing all the nodes that have legal positions.
Then set the nodes degree to how many legal positons can be visited from it.
lastly insert the pair into the map {node,container of neighbnors}.
