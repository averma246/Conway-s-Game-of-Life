//==============================================================================
/**
 * A <code>ConwayCell</code> is a specific type of <code>Cell</code>.
 * source code provided by professor, edited by Ana Verma 
 * averma20@amherst.edu
 **/
//==============================================================================

//==============================================================================
public class ConwayCell extends Cell{
    //==========================================================================

    
    //==========================================================================
    
    /**
     * The specialized constructor. Creat a new, intially-dead ConwayCell.
     * @param grid The <code>Grid</code> that contains this cell.
     * @param row The row coordinate of this cell within its <code>Grid</code>.
     * @param column The column coordinate of this cell within its 
     * <code>Grid</code>. 
     **/
 
    public ConwayCell(Grid grid, int row, int col){
	
	//uses the constructor that is actually within the Cell class
	super(grid, row, col);
    }
    //ConwayCell()
    //==========================================================================


    //==========================================================================
    /**
     * Provide a textual representation of the cell's state.
     *
     * @return One particular '+' to represent liveness, and '-' to
     *         represent deadness.
     **/
    public String toString () {
	
	if (_isAlive) {
	    return "+";
	} 
	else {
	    return "-";
	}
	
    }
    //==========================================================================
    
    //==========================================================================
    /**
     * Based on its neighbors' states, calculate what this cell's state will be
     * in the <i>next</i> generation.  Here, the Conway rules are that <i>a live
     * cell with 2 or 3 live neighbors remains alive, a dead cell with 3 live
     * neighbors becomes alive, and all other cells will die</i>.
     **/
    
    public void evolve(){
	int liveN = getLiveNeighbors();
	boolean alive = isAlive();
    
	if(liveN==3){ 
	    _willBeAlive = true;
	}
	else if(alive && liveN == 2){
	    _willBeAlive = true;
	}
	else{
	    _willBeAlive = false;
	}
    }
    //evolve()
    //==========================================================================


    //==========================================================================


//==========================================================================
}//class ConwayCell
//==========================================================================
