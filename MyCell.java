// =============================================================================
/**
 * A <code>MyCell</code> is  a specific type of <code>Cell</code>.
 * @author Ana Verma averma20@amherst.edu
 **/
// =============================================================================

// =============================================================================
public class MyCell extends Cell{
    // =========================================================================

    // =========================================================================
    /**
     * The specialized constructor. Create a new, initially-dead MyCell.Utilizes
     * the constructor in the super class, <code>Cell</code>.
     *
     * @param grid The <code>Grid</code> that contains this cell.
     * @param row The row coordinate of this cell within its <code>Grid</code>.
     * @param column The column coordinate of this cell within its 
     * <code>Grid</code>.
     **/
    public MyCell(Grid grid, int row, int col){
	//uses the constructor in the Cell super class.
	super(grid,row,col);
    }
    //MyCell()
    // =========================================================================

    // =========================================================================
    /**
     * Provide a textual representation of the cell's state.
     *
     * @return One particular '*' to represent liveness and '_' to 
     *         represent deadness.
     **/
    public String toString(){
	if(_isAlive){
	    return "*";
	}
	else{
	    return "_";
	}
    }

    // =========================================================================

    // =========================================================================
    /**
     * Based on its neighbors' states, calculate what this cell's state will be
     * in the <i>next</i> generation.  Here, the MyCell rules are that <i>a 
     * live cell with 2,3,or 4 live neighbors remains alive, a dead cell with
     * 2, 4, 6, or 8 live neighbors becomes alive, and all other cells will 
     * die</i>.
     **/
    
    public void evolve(){
	int liveN = getLiveNeighbors();
	boolean alive = isAlive();

	if((liveN == 2 || liveN == 4 || liveN == 6 || liveN == 8) && !alive){
	    //here the !alive condition is necessary so that an alive cell with 8 alive neighbors doesn't remain alive
	    _willBeAlive = true;
	}

	else if((liveN == 2 || liveN == 3 || liveN == 4) && alive){
	    //here the alive condition is necessary so that a dead cell with only 3 alive neighbors doesn't become alive
	    _willBeAlive = true;
	}

	else{
	    _willBeAlive = false;
	}
    }
    //evolve()
    // =========================================================================

    // =========================================================================

// =============================================================================
} //class MyCell
// =============================================================================
