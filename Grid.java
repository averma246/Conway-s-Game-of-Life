// =============================================================================
/**
 * The abstract <code>Grid</code> class.  Manage a two or one-dimensional 
 * collection of <code>Cell</code>s.
 * @author Scott F. Kaplan (professor)
 * edited by Ana Verma averma20@amherst.edu
 **/
// =============================================================================



// =============================================================================
abstract public class Grid {
// =============================================================================


    // =========================================================================
    /**
     * The constructor.  Create a grid of <code>Cell</code>s, in their default
     * initial states.
     *
     * @param rows The number of rows in the known region.
     * @param columns The number of columns in the known region.
     * @param cellType The kind of cell with which to populate the grid.
     **/
    public Grid (int rows, int columns, String cellType) {

	// Ensure that the sizes are valid.
	if ((rows <= 0) || (columns <= 0)) {
	    Support.abort("Cannot construct a grid of size " +
			  rows +
			  ", " +
			  columns);
	}
	_rows = rows;
	_columns = columns;

	// Create the underlying 2-D or 1-D array that will track the Cells.
	createArray(rows, columns);

	// Create the Cells, all in their default states.
	for (int row = 0; row < rows; row += 1) {
	    for (int col = 0; col < columns; col += 1) {
		populate(row,col,cellType);
	    }
	}

    } // Grid()
    // =========================================================================

    // =========================================================================
    
    /**   
     * Create the <code>Grid</code> based on the grid and cell type.
     * @param rows The max number of rows the grid will have.
     * @param columns The max number of columns the grid will have.
     * @param cellType The type of <code>Cell</code>s the grid will contain.
     * @param gridType The type of grid that will be created (either 2D or 1D)
     * @return The created <code>Grid</code>.
     **/

    public static Grid create(int rows, int columns, String cellType, String gridType){
	if(gridType.equals("Array1D")){
	    return new Array1DGrid(rows, columns, cellType);
	}

	//safe to use just "else" instead of "else if(gridType.equals("Array2D")) because the only valid entries for gridType are Array1D and Array2D (any other string for gridType is restricted in Life.java)
	else {
	    return new Array2DGrid(rows, columns, cellType);
	}
    }
    // =========================================================================
   
    // =========================================================================

    /**
     * Provide the number of rows in the known region of the grid.
     *
     * @return The number of rows in the known region.
     **/
    public int getRows () {

	return _rows;

    } // getRows ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide the number of columns in the known region of the grid.
     *
     * @return The number of rows in the known region.
     **/
    public int getColumns () {

	return _columns;

    } // getColumns ()
    // =========================================================================



    // =========================================================================
    /**
     * Obtain the <code>Cell</code> at given coordinates.
     *
     * @param row The row of the requested <code>Cell</code>.
     * @param column The column of the requested <code>Cell</code>.
     * @return Nothing. It is an abstract method. Method defined in the two 
     * subclasses.
     **/ 
    abstract Cell getCell (int row, int column);

     // getCell()
    // =========================================================================
 
    // =========================================================================
    /** Abstract method to populate the grid with <code>Cell</code>s.
     *
     * @param row The row of the <code>Cell</code>.
     * @param col The column of the <code>Cel</code>.
     * @return Nothing. Abstract method -- defined in the two subclasses.
     **/
    abstract void populate(int row, int col, String cellType);
    

    // =========================================================================

    // =========================================================================

    /** Abstract method to create the type of array underlying the grid.
     * 
     * @param rows The number of rows the <code>Grid</code> has.
     * @param columns The number of columns the <code>Grid</code> has.
     * @return Nothing. Abstract method -- type of arrays (1D or 2D) defined 
     * within the two subclasses.
     **/
    abstract void createArray(int rows, int columns);
    
    
    // =========================================================================

    // =========================================================================
    // DATA MEMBERS
    
    /**
     * Whether to provide debugging information.
     **/
    private final static boolean _debug = false;

    private int _rows;
    private int _columns;
    // =========================================================================
    


// =============================================================================
} // class Grid
// =============================================================================
