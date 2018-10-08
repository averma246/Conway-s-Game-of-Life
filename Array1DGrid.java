// =============================================================================
/**
 * The <code>Array1DGrid</code> class. Manages the one-dimensional collection 
 * of <code>Cell</code>s.
 * @author Ana Verma averma20@amherst.edu
 **/
// =============================================================================



// =============================================================================
public class Array1DGrid extends Grid{
// =============================================================================


    // =========================================================================

    /**
     * The constructor. Create a grid of <code>Cell</code>s using the 
     * constructor method in the <code>Grid</code> super class.Parameters 
     * defined in the super class.
     **/
    public Array1DGrid (int rows, int columns, String cellType){
	super(rows, columns, cellType);

    }// Array1DGrid()
    // =========================================================================

    // =========================================================================
    /**
     * The method that creates the 1D array that will hold the 
     * <code>Cell</code>s.
     * 
     * @param rows The number of rows in the <code>Grid</code>.
     * @param columns The number of columns in the <code>Grid</code>.
     **/
    public void createArray(int rows, int columns){
	_array = new Cell[rows*columns];
    }
    // =========================================================================

    // =========================================================================
    /**
     * Method that populates the main array (the array representing the grid.
     *
     * @param row The row of the <code>Cell</code> in the <code>Grid</code>
     * you are populating.
     * @param col The column of the <code>Cell</code> in the <code>Grid</code>
     * you are populating.
     **/
    public void populate(int row, int col,String cellType){
	_array[row*getColumns()+col] = Cell.create(cellType, this, row, col);
    }
    // =========================================================================

    // =========================================================================
    /**
     * Obtain the <code>Cell</code> at given coordinates.
     *
     * A ZombieCell is returned if the requested cell lies along the *outside*
     * border of the grid
     *
     * @param row The row of the requested <code>Cell</code>.
     * @param column The column of the requested <code>Cell</code>.
     * @return The requested <code>Cell</code>.
     **/
    public Cell getCell(int row, int column){
	if((row>=0) && (row < getRows()) && (column >= 0) && (column < getColumns())){
	    return _array[row*getColumns()+column];
	}
	else if(row == -1 || row == getRows() || column == -1 || column == getColumns()){
	    return new ZombieCell();
	}
	else {
	    System.out.println("row: " + row +", column: "+column);
	    throw new OffTheGridException();
	}
    }//getCell()


    // =========================================================================

    // =========================================================================
    // DATA MEMBERS

    /**
     * The main one-dimensional array which holds the <code>Cell</code>s.
     **/
    private Cell[] _array;
    // =========================================================================


// =============================================================================
}//class Array1DGrid
// =============================================================================
