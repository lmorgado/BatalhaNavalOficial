package game.controller;

import game.model.Ships;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;



public class Grid {
	
    
	public int columnCount = 15,
        		rowCount = 15;
	
	public List<Cell>grid; 
	
	public int cellWidth,
				cellHeight,
				xOffset,
				yOffset;
		
	
	public Grid ( int screenWidth, int screenHeight ) {

		initializePlayerGrid( screenWidth, screenHeight );
	
	}

	
	private void initializePlayerGrid ( int screenWidth, int screenHeight ) {

		grid = new ArrayList<Cell>( rowCount * columnCount );

		cellWidth = screenWidth / columnCount;
		cellHeight = screenHeight / rowCount;
		xOffset = ( screenWidth -  ( columnCount * cellWidth  ) ) / 2;
		yOffset = ( screenHeight - ( rowCount    * cellHeight ) ) / 2;
	
		
		// Fill the grid 15x15 with their Cells
		if ( grid.isEmpty( ) ) { 

			for ( int i = 0; i < rowCount; i++ )					
				for ( int j = 0; j < columnCount; j++ ) {
					
					Cell cell = new Cell ( xOffset + ( j * cellWidth ), yOffset + ( i * cellHeight ), cellWidth, cellHeight );		
					grid.add ( cell );		    														
				}		
		}    		
					
				
		// Link each grid cell with its neighbors - left, right, up, down neighbors		
		for ( int i = 0; i < rowCount; i++ ) 		     
			for ( int j = 0; j < columnCount; j++ ) {
		    	 		    	 		    	 
		    	if ( i == 0 )  
		    		grid.get( getListIndexFromGridPosition( i, j ) ).previousInColumn = null;
		    		
		    	else
		    		grid.get( getListIndexFromGridPosition( i, j ) ).previousInColumn = grid.get( getListIndexFromGridPosition( i - 1, j ) );		    		 		    	 				    	 				    	 
		    	 	
		    	if ( j == 0 )
		    		grid.get( getListIndexFromGridPosition( i, j ) ).previousInRow = null;
		    		 
		    	else
		    		grid.get( getListIndexFromGridPosition( i, j ) ).previousInRow = grid.get( getListIndexFromGridPosition( i, j - 1 ) );
		    	 			    	 			    	 				    	 
		    	 			    	 	
		    	if ( j == (columnCount - 1) && i != (rowCount - 1) ) {
		    	
		    	 	grid.get( getListIndexFromGridPosition( i, j ) ).nextInRow = null;
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInColumn = grid.get( getListIndexFromGridPosition( i + 1, j ) );
		    	
		    	} else if ( j != (columnCount - 1) && i == (rowCount - 1) ) {
		    		
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInRow = grid.get( getListIndexFromGridPosition( i, j + 1 ) );
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInColumn = null;
		    	
		    	} else if( j == (columnCount - 1) && i == (rowCount - 1) ) {
		    	
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInRow = null;
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInColumn = null;
		    	
		    	} else {
		    		
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInRow = grid.get( getListIndexFromGridPosition ( i, j + 1 ) );
		    		grid.get( getListIndexFromGridPosition( i, j ) ).nextInColumn = grid.get( getListIndexFromGridPosition ( i + 1, j ) );
		    	}	    	 	 
		    	 
		    }											
	}

	
	
	// Given i and j matrix position, return element in this Grid-List
	public int getListIndexFromGridPosition ( int i, int j ) {
		
		return ( i * rowCount + j );			
	}
	
	
	public Point getGridPositionFromClickedPoint ( double x0, double y0 ) {
				
		int i = (int) ( ( y0 - this.yOffset )  / this.cellHeight );
		int j = (int) ( ( x0 - this.xOffset ) / this.cellWidth   );
		
		return new Point (i, j); 			
	
	}
	
	
	// 
	public void setCurrentShipForEachCell ( Ships ship ) {

		for( int i = 0; i < rowCount; i++ )     
			for ( int j = 0; j < columnCount; j++ ) 
				
				grid.get( getListIndexFromGridPosition( i, j ) ).currentChosenShip = ship;
		
	}

		
	// 
	public void initialTheCurrentShipForEachCell() {
		
		for( int i = 0; i < rowCount; i++ ) 	    
			for ( int j = 0; j < columnCount; j++ ) 
				
				grid.get( getListIndexFromGridPosition( i, j ) ).currentChosenShip = null;
	
	}

  
  
    //
	protected void resetShipPlacementOnEachCell() {
	   
	for( int i = 0; i < rowCount; i++ ) 
	    
		for ( int j = 0; j < columnCount; j++ ) {
		
			grid.get( getListIndexFromGridPosition( i, j ) ).currentChosenShip = null;
			grid.get( getListIndexFromGridPosition( i, j ) ).isShipPlacedOn = null;
			grid.get( getListIndexFromGridPosition( i, j ) ).isCyan = true;			
		}	   	
   
	}


	
}
