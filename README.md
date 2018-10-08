# Conway's Game of Life
---------------------------------------------------------------------------------

*Source Code: From Professor Scott Kaplan, Amherst College*

Array1DGrid: 
* Single, one-dimensional Cell object array implementation of the grid
* @author: Ana Verma
  
Array2DGrid:
* Two-dimensional Cell object matrix implementation of the grid
* @author: Ana Verma

Cell:
* abstract class
* there are multiple cell types
* @primary author: Scott Kaplan
* @author of the abstraction, the countLiveNeighbors, advance, and create method: Ana Verma

ConwayCell
* standard cell of the game
* RULES: 
      (1) alive cell with <2 alive neighbors dies 
      (2) alive cell with 2 or 3 alive neighbors remains alive for the next generation  
      (3) alive cell with >3 alive neighbors dies  
      (4) dead cell with exactly 3 alive neighbors becomes alive  

HighlifeCell

ZombieCell

MyCell

UserInterface

DumbTextUserInterface

SmartTextUserInterface

Game

Grid

Life

OffTheGridException

Support




