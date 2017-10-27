// =============================================================================
/**
 * A <code>Cell</code> keeps track of its own liveness.  It also can determine
 * its own evolution by examining its neighbors and applying its survival rules.
 * Source code provided by Scott F. Kaplan (professor) and edited by Ana Verma 
 * averma20@amherst.edu
 **/
// =============================================================================



// =============================================================================
abstract public class Cell {
// =============================================================================

    

    // =========================================================================
    /**
     * The specialized constructor.  Create a new, initially-dead cell.
     *
     * @param grid The <code>Grid</code> that contains this cell.
     * @param row The row coordinate of this cell within its <code>Grid</code>.
     * @param column The column coordinate of this cell within its
     *               <code>Grid</code>.
     **/
    public Cell (Grid grid, int row, int column) {

	// Set the initial state to be dead.
	_isAlive = false;

	// Store the grid and the coorindates within that grid.
	_grid = grid;
	_row = row;
	_column = column;

    } // Cell()
    // =========================================================================
    /**Constructor with no parameters. Created for the purpose of the 
     * <code>ZombieCell</code>
     **/
    public Cell(){}
    
    
    // =========================================================================
    /**
     * Indicate whether this cell is currently dead or alive.
     *
     * @return <code>true</code> if the cell is alive; <code>false</code> if it
     *         is dead.
     **/
    public boolean isAlive () {

	return _isAlive;

    } // isAlive()
    // =========================================================================



    // =========================================================================
    /**
     * Set the cell to be alive.
     **/
    public void makeAlive () {

	_isAlive = true;
	
    } // makeAlive ()
    // =========================================================================



    // =========================================================================
    /**
     * Set the cell to be dead.
     **/
    public void makeDead () {

	_isAlive = false;
	
    } // makeDead ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide the row coordinate of this cell in its <code>Grid</code>.
     *
     * @return The row coordinate of this cell.
     **/
    public int getRow () {

	return _row;

    } // getRow ()
    // =========================================================================




    // =========================================================================
    /**
     * Provide the column coordinate of this cell in its <code>Grid</code>.
     *
     * @return The column coordinate of this cell.
     **/
    public int getColumn () {

	return _column;

    } // getColumn ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide a textual representation of the cell's state.Abstract method-- 
     * defined in subclasses.
     *
     * @return One particular character to represent liveness, another to
     *         represent deadness.  The characters chosen depend on the type of
     *         cell, and thus are determined by the subclasses.
     **/
    abstract public String toString ();
   
    // =========================================================================



    // =========================================================================
    /**
     * Traverse the standard neighborhood (the surrounding 8 <code>Cell</code>s
     * in the <code>Grid</code>) and count the number of neighbors that are
     * alive.
     *
     * @return The number of live neighbors in the standard neighborhood.
     **/
    private int countLiveNeighbors () {

	int liveNeighbors = 0;
	int r = _row;
	int c = _column;

	for(int i = r-1;i <= r+1; i += 1){
	    for(int j = c-1;j <= c+1; j += 1){
		try{
		    if(_grid.getCell(i,j) != null && _grid.getCell(i,j).isAlive()){
			liveNeighbors+=1;
		    }
		}
		catch(OffTheGridException e){
		    Support.abort("Something went wrong. Row: " + i + " Column: " + j + "\n Exiting now...");   
		}
	    }
	}
	
	if(_isAlive){
	    return liveNeighbors-1; //the -1 accounts for the cell itself (don't want to include it in the count)
	}
	else{
	    return liveNeighbors;
	}
    }
    
    //==========================================================================

    // =========================================================================
    /**
     * Used to access the number of live neigbors of a cell from outside 
     * the <code>Cell</code> class.
     *
     * @return The number of live neighbors the <code>Cell</code> has.
     **/
    public int getLiveNeighbors(){
	return countLiveNeighbors();
    }

    
    // =========================================================================
    /**
     * Based on its neighbors' states, calculate what this cell's state will be
     * in the <i>next</i> generation.Abstract method -- defined in subclasses.
     * Can only determine the state of a cell in the next generation based 
     * on what type of cell the <code>Cell</code> is.
     **/
    abstract public void evolve (); 
    
    
    // evolve ()
    // =========================================================================
    
    
    
    // =========================================================================
    /**
     * Advance to the next generation.  That is, adopt as the current
     * liveness whatever was calculated by <code>evolve()</code>.
     **/
    public void advance () {
	
	if(_willBeAlive && !_isAlive){
	    makeAlive();
	}
	else if(!_willBeAlive){
	    makeDead();
	}
	
    }
    // =========================================================================



    // =========================================================================
    /**
     *Creates the <code>Cell</code> at the given row and column within the 
     *grid of the given cell type.
     * @param cellType The type of cell the <code>Grid</code> consists of.
     * @param grid The main <code>Grid</code>.
     * @param row The row of the <code>Cell</code>.
     * @param col The column of the <code>Cell</code>.
     **/
    public static Cell create(String celltype,Grid grid,int row,int col){
	if(celltype.equals("Highlife")){
	    return new HighlifeCell(grid,row,col);
	}
	else if(celltype.equals("Conway")){
	    return new ConwayCell(grid,row,col);
	}
	else if(celltype.equals("My")){
	    return new MyCell(grid,row,col);
	}
	else{
	    return null;
	}
    }
    // =========================================================================

    // =========================================================================

    // DATA MEMBERS

    /**
     * The current liveness.
     **/
    boolean _isAlive;

    /**
     * The liveness in the next generation.
     **/
    boolean _willBeAlive;

    /**
     * The <code>Grid</code> that contains this cell.
     **/
    Grid _grid;

    /**
     * The cell's row coordinate within its <code>Grid</code>.
     **/
    int _row;

    /**
     * The cell's column coordinate within its <code>Grid</code>.
     **/
    int _column;
    // =========================================================================



// =============================================================================
} // class Cell
// =============================================================================
