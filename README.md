1.Position class
- Stores the position (x and y coordinates). 

2.Player interface
- Interface for the Player, with basic commands.
- 
3.MyPlayer class
- Implements the Player interface;
- Creates the player as a ball on the board;
- Moves the ball;
- Makes sure it does not go out of bounds or through the walls.
- 
4.Map class
- Extends the Pane class;
- Constructs a map from a given text file;
- unit: size of one cell (in pixels);
- size: size of map (number of columns/rows);
- Keeps the data in a two-dimensional array;
- Fills the map;
- Draws the border lines;
- Draws the walls;
- Provides the starting point for the player (ball). 
- 
5.Game class
- JavaFX application;
- Creates the map;
- Creates the player;
- Creates food instance;
- Controls key events;
- The whole game starts as follows: 	> java Game map.txt 
- 
6.Food class
- Responsible for creating food on the board;
- The constructor signature: Food(Map, Player);
- getPoints(): returns total number of points as integer;
- getPosition(): returns the position of the food object.
- 
7.Map text file
- The sample text file is attached;
- 0 - for empty cell, 1 - for wall, and 2 - for the starting point of the player;
