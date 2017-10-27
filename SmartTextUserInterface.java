// =============================================================================
/**
 * The <code>SmartTextUserInterface</code> subclass displays the state of the 
 * grid at each generation in a dynamic manner. It re-prints the grid on top of 
 * the previous print to "animate" the cells dying and being born.
 * @author Ana Verma averma20@amherst.edu
 **/
// =============================================================================


// =============================================================================
public class SmartTextUserInterface extends UserInterface{
// =============================================================================

    /** The constructor that utilizes the constructor in the super class.
     *
     **/
    public SmartTextUserInterface(Game game){
	super(game);

    }//SmartTextUserInterface()
    // =========================================================================


    // =========================================================================
    /**
     * Print the sequence of generations on top of the preeviously printed
     * grid.
     **/
    public void printGrid(Game _game){
	
	try{
	    //controls the speed at which the grid is reprinted
	    Thread.sleep(250);
	}catch(InterruptedException e){
	    Support.abort("Something went wrong");
	}
	
	for(int row = 0; row < _game.getRows(); row++){
	    for(int column = 0; column < _game.getColumns(); column++){
		Cell cell = _game.getCell(row, column);
		System.out.print(cell);
	    }
	    //Move to a new line
	    System.out.println();
	}
	
	//the number of rows the cursor has to "jump up" in order to reprint the grid from the top left corner
	int rows = _game.getRows() + 1;
	System.out.print("\u001b[" + rows + "A");
    }

    // =========================================================================

    // =========================================================================


// =============================================================================
}// class SmartTextUserInterface
// =============================================================================
