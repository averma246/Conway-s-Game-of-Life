// =============================================================================
/**
 * The <code>DumbTextUserInterface</code> subclass displays the state of the 
 * grid at each generation in a static manner. It simply prints the
 * "screenshots" of the grid.
 * @author Ana Verma averma20@amherst.edu 
 **/
// =============================================================================


// =============================================================================
public class DumbTextUserInterface extends UserInterface{
// =============================================================================

    /** The constructor that utilizes the constructor in the super class.
     *
     **/
    public DumbTextUserInterface(Game game){
	super(game);

    }//DumbTextUserInterface()
    // =========================================================================


    // =========================================================================

    /**
     * Print the sequence of generations in rapid succession. 
     **/
    public void printGrid(Game _game){
	
	for(int row = 0; row < _game.getRows(); row++){
	    for(int column = 0; column < _game.getColumns(); column++){
		Cell cell = _game.getCell(row, column);
		System.out.print(cell);
	    }
	    // Move to a new line
	    System.out.println();
	}	
    }
    // =========================================================================

    // =========================================================================

// =============================================================================
}// class DumbTextUserInterface
// =============================================================================
