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
* RULES: (1) dead cell with exactly 3 or 6 alive neighbors becomes alive, (2) alive cell with exactly 2 or 3 alive neighbors remains alive, (3) cells are dead under all other circumstances

ZombieCell
* cell that is always dead
* the "cells" that lie along the border of the grid are all zombieCells 

MyCell
* cell with rules set by me (Ana Verma)
* RULES: (1) alive cell with exactly 2,3,or 4 alive neighbors remains alive, (2) dead cell with exactly 2, 4, 6, or 8 alive neighbors becomes alive, (3) cells are dead under all other circumstances
 
UserInterface
* abstract class used to print the state of the game
* @primary author: Scott Kaplan
* @author of abstraction: Ana Verma

DumbTextUserInterface
*  prints, as a log, the sequence of generations in rapid succession
* @author: Scott Kaplan

SmartTextUserInterface
* similar to DumbTextUserInterface, except the generations are not printed in succession, they are printed on top of each other to mimic movement
* @primary author (code shared with DumbTextUserInterface): Scott Kaplan
* @author of change between the two interfaces: Ana Verma

Game
* the high-level director of this cellular simulation
* creates the Grid of Cells
* responsible for evolving all the Cells for the number of generations requested by the user and prints them 
* @primary author: Scott Kaplan
* @author of evolve() and getPopulation(): Ana Verma

Grid
* two-dimensional container of Cell objects
* @author: Scott Kaplan

Life
* simple class containing the main() method that gets the program started
* creates a Game object and then calls play() on that object to get the program moving
* @author: Scott Kaplan

OffTheGridException
* exception that is thrown when the coordinates are out of the range of the grid and its bounding frame
* @author: Ana Verma

Support
* assist in aborting the program
* @author: Scott Kaplan




