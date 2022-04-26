# Goals
To solve the knights tour puzzle.
The knights piece must visit every spot on a chess board once and only once.
# Inputs
x,y input that represents the dimensions for the chess board.
x,y input that represents the starting spot on the chess board.

# Outputs
Should display a window containing button.
Each button represents a spot on a chess board.
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

## GUI implementation
Instead of having my algorithm run in a main class I split my algorithm into two parts.
The first part is to grab information about the tour from the user. 
This will have its own window and class to complete it.
The user will be expected to provid:
- board x dimension
- board y dimension
- starting x spot on the board
- starting y spot on the board
- delay between each step of the tour.
Once this information is gathered it is stored inside a tuple containing all 5 attributes.
Then the tuple will be returned.

The second part is to actually display the tour.
To do this first I will have the board class return a linked list containing the sequence of the tour.
I will construct a gui with just buttons on the screen.
Then I will traverse through the linked list and use each node's x & y attribute to select a button to pick.
When selecting a button to pick, all the buttons on the screen are in a single array and so each button will be chosen based on it's index.
To generate the index of the button I will use the equation ((Node.y * board.x) + Node.x)
Once I have the index of the button, I will click it and make its color turn black, indicating that it has been visited.
Then the program will delay based on how long the user wants to delay each button press. 
Once the linked list has been traversed all nodes that have been visited will be black, and the ones that have not been visited will be their normal color.

Lastly to glue this together I will have a main class that will first open the launch page and will wait for user to give inputs to the program.
Once the program has the inputs that it needs it will open another window and display the tour.
