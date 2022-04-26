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
## update the degree
For my algortihm it is crutial that I update the degree after each itteration of my program when a node is visited, any node that has that node as a neighbor should have its degree updated.
I will create a method that takes in a node, then gets the neighbors from my map.
Now having the neighbors I will check their isVisited attribute, if the attribute is false i will incerement a counter, if its true I wont do anything.
Then set the ndoe's degree to counter.

## Discalimer
I am well aware that creating a node instance for each spot on the chess board was unnesisairy for a console program and that I could have done it functionally instead. The reason I did it like this was that I do plan on implementing a gui, and the concept of a linked list is part of my gui. I would create a liked list and traverse it. At each given node in the linked list will figure out wich button to press based on the x & y value of the node.

## Algorithm
1. create a counter variable, will be used to keep track of when each spot on the chess board was visited.
2. create a while loop for the duration of the tour.
3. check if the counter is equal to the total number of nodes, this indicates that all spots have been visited. If so end the loop.
4. check if the current spot which is a node instance, is not null.
5. if it is not null, set current spot orderVisited attribute to the value of the counter variable.
6. Then set current spot isVisited to true.
7. then update the degree of the current spot.
8. Then find the neighbor with the least degree.
9. Then set the current spot to the neighbor with the least degree.
10. if the current spot is null, then we have reached a dead end so end the loop.

