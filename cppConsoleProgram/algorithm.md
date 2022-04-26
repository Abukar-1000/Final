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
- order visited (int)
- is visited (boolean)
- a pointer to the next node (Node)
