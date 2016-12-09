package game.controller;

import game.model.Ships;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class Cell extends Rectangle2D.Double {
		
	
	public boolean isWhite;
	public boolean isRed;
	public boolean isCyan;
			
	public Cell previousInRow;
	public Cell previousInColumn;
	public Cell nextInRow;
	public Cell nextInColumn;
	
	public Cell CheckingCell;	
	
	public Color cellColorForShip = new Color ( 0, 0, 0 );
	
	public Ships currentChosenShip = null;
	public Ships isShipPlacedOn = null;
	
	JTextPane label;
    boolean isHit = false;
	

    public Cell( int x0, int y0, int width, int height ) {
		
			super(x0, y0, width, height );
		
			isCyan = true;
			isWhite = false;
			isRed = false;				
			CheckingCell = this;
}
	

	public boolean isCellEnoughAndNotTaken() {
       
		if ( currentChosenShip.orientation_horizontal == true ) {
		         		
			for( int i = 0; i < currentChosenShip.size; i++ ) {
			          
				if( CheckingCell == null ) 			        	  	
					return false;
			          
				 else 
			     	CheckingCell = CheckingCell.nextInRow;				         
			}
		         		              
			
			CheckingCell = this;
		         		        
				
			for( int i = 0; i < currentChosenShip.size; i++ ) {
			          
		    	if( CheckingCell.isShipPlacedOn != null )        	 			        	 
			        	  return false;
			         
		        else     	 
		        	CheckingCell = CheckingCell.nextInRow;
    
			}	         
		       		      		        	
			CheckingCell = this;
		     						
			} else { /*Vertical Position */
		    	 
		    	for( int i = 0;  i < currentChosenShip.size; i++ ) {
			      
		    		if(CheckingCell == null) 			     	  
			        	  return false;
			        
		    		  else 			        	 
			        	  CheckingCell = CheckingCell.nextInColumn;			               
		    	 }
		         
		    	 
		    	CheckingCell = this;
		         
		    	 
		    	for( int i = 0; i < currentChosenShip.size; i++ ) {
			          
		    		 if( CheckingCell.isShipPlacedOn != null ) 			        	  
			        	  return false;			          
		    		 
		    		 else 			        	
						  CheckingCell = CheckingCell.nextInColumn;			         		    		 
			          
		    	 }	    
		               
		    	CheckingCell = this;
		     
			}		
			
		return true;
}



	public boolean hasCellSomeNeighbors() {
		
	
		if (  currentChosenShip.orientation_horizontal == true ) {
        
			if ( CheckingCell.previousInRow != null ) /*Has left neighbor?*/
				return false;	
		
			for ( int i = 0;  i < currentChosenShip.size; i++) {
	          			
				if ( ( CheckingCell.nextInColumn != null ) || (CheckingCell.previousInColumn != null) ) 	        	  				
					return false;
	          
				else    	  
					CheckingCell = CheckingCell.nextInRow;			 
			}
       
				
        if ( CheckingCell.nextInRow != null) /*Has right neighbor?*/
        	return false;
	
	  
		} else {
    	 
    	 
		  if ( CheckingCell.previousInColumn != null ) /*Has down neighbor?*/
				return false;	
		  		  
		  for ( int i = 0; i < currentChosenShip.size ; i++ ) {
	         		 
    		 if ( ( CheckingCell.nextInRow != null ) || ( CheckingCell.previousInRow != null ) ) 	        	  
    			 return false;
	        
    		  else 	        	 
    			 CheckingCell = CheckingCell.nextInColumn;
	         	          
    	 }
         
		  if( CheckingCell.nextInColumn != null ) /*Has up neighbor?*/
				return false;	 
		  
	  }		

		CheckingCell = this;   
	  
		return true;

}
				

	
	
	
	// Check to Cruiser...
	
	

	
	
	
	
	
	
	
	public void getHit() {

		this.isCyan = false;

		if ( this.isShipPlacedOn != null ) 
			this.isRed = true;

		else 
			this.isWhite = true;
	
	
		isHit = true;

	
	/*	if( this.isShipPlacedOn != null ) {

			this.isShipPlacedOn.setHit();

			if( this.isShipPlacedOn.isSunk() ) 
				this.label.setText(label.getText() + "\n" + this.isShipPlacedOn.name + " Sunk");	
		} */

	}



}
