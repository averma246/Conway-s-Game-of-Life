// =============================================================================
/**
 * The abstract <code>UserInterface</code> for the <i>Game of Life</i>.  A
 * <code>UserInterface</code> subclass controls the progression from one 
 * generation to the next, displaying the state at each generation.
 * @author Scott F Kaplan (professor)
 **/
// =============================================================================

// =============================================================================
abstract public class UserInterface {
// =============================================================================



    // =========================================================================
    /**
     * The constructor.  Hold onto a pointer to the <code>Game</code> for which
     * this <code>UserInterface</code> is providing interaction.
     *
     * @param game The <code>Game</code> whose state to draw.
     **/
    public UserInterface (Game game) {

	_game = game;

    } // UserInterface ()
    // =========================================================================



    // =========================================================================
    /**
     * Call on the abstract method that would lead to the printGrid methods in 
     * the subclasses and display the state of the  <code>Cell</code>s in the 
     * <code>Grid</code>.
     **/
    public void display () {
	System.out.println("Generation = " + _game.getGeneration() + 
			   ", Population = " + _game.getPopulation());
	printGrid(_game);

    } // display ()
    // =========================================================================



    // =========================================================================
    /**
     * Keep control of the program until it is time to advance the state of the
     * <code>Game</code>.
     **/
    public void triggerMove () {

	// Do nothing.  Just let it advance as quickly as it wants.
	
    }
    // =========================================================================
    /**
     * Abstract method that is defined in the subclasses. Those defined methods
     * print out the grid.
     **/
    abstract void printGrid(Game _game);


    // =========================================================================
    // DATA MEMBERS

    /**
     * The <code>Game</code> that this interface is controlling.
     **/
    Game _game;
    // =========================================================================



// =============================================================================
} // class UserInterface
// =============================================================================
