// =============================================================================
/**
 * The <code>Array2DGrid</code> class. Manages the two-dimensional collection of
 * <code>Cell</code>s.
 * @author Ana Verma averma20@amherst.edu
 **/
// =============================================================================



// =============================================================================
public class Array2DGrid extends Grid{
// =============================================================================


    // =========================================================================

    /**
     * The constructor. Create a grid of <code>Cell</code>s using the
     * constructor method in the <code>Grid</code> super class.Parameters
     * defined in the super class.
     **/
    public Array2DGrid(int rows, int columns, String cellType){
	super(rows, columns, cellType);
    
    }//Array2DGrid()
    // =========================================================================

    // =========================================================================
    /** 
     * The method that creates the 2D array (matrix) that will hold the 
     * <code>Cell</code>s.
     *
     * @param rows The number of rows in the <code>Grid</code>.
     * @param columns The number of columns in the <code>Grid</code>.
     **/
    public void createArray(int rows, int columns){
	_array = new Cell[rows][columns];
    }
    // =========================================================================

    // =========================================================================
    /**
     * Method that populates the matrix that represents the grid.
     *
     * @param row The row of the <code>Cell</code> in the <code>Grid</code>
     * you are populating.
     * @param col The column of the <code>Cell</code> in the <code>Grid</code>
     * you are populating.
     **/   
    public void populate(int row, int col, String cellType){
	_array[row][col]= Cell.create(cellType, this, row, col);
    }
    // =========================================================================

    // =========================================================================
    /**
     * Obtain the <code>Cell</code> at given coordinates.
     *
     * @param row The row of the requested <code>Cell</code>.
     * @param column The column of the requested <code>Cell</code>.
     * @return The requested <code>Cell</code>.
     **/
    public Cell getCell(int row, int column){
	if((row >= 0) && (row < getRows()) && (column >= 0) && (column < getColumns())){
	    return _array[row][column];
	}
	else if(row == -1 || row == getRows() || column == -1 || column == getColumns()){
	    return new ZombieCell();
	}
	else{ 
	    throw new OffTheGridException();
	}
    }//getCell()

    // =========================================================================

    // =========================================================================
    // DATA MEMBERS
    /** 
     * The main two-dimensional array (matrix) which holds the 
     * <code>Cell</code>s.
     **/
    private Cell[][] _array;
    // =========================================================================


// =============================================================================
}//class Array2DGrid
// =============================================================================
