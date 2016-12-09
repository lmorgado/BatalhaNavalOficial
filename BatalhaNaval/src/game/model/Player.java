package game.model;

import game.view.BoardView;
import game.view.ShipsView;

import game.controller.Cell;
import game.controller.Grid;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextPane;



public class Player  {
	
	
	boolean GameIsStart = false;
    boolean GameIsOver = false;

	String name;
	int score = 0;
	String result;
	
	Player self = this;
	
	Ships AirCarrier = new Ships ( 5, "Aircraft Carrier" );
   
	Ships []BatleShip = { new Ships ( 4, "BattleShip1" ), 
			              new Ships ( 4, "BattleShip2" ) };
    
	
	Ships []Cruiser = { new Ships ( 3, "Cruiser1" ), 
			            new Ships ( 3, "Cruiser2" ), 
			            new Ships ( 3, "Cruiser3" ), 
			            new Ships ( 3, "Cruiser4" ), 
			            new Ships ( 3, "Cruiser5" ) };
   
    
    Ships []Destroyer = { new Ships ( 2, "Destroyer1" ), 
    		              new Ships ( 2, "Destroyer2" ), 
    		              new Ships ( 2, "Destroyer3" ) };
    
   
    Ships []Submarine = { new Ships ( 1, "Submarine1" ), 
    		              new Ships ( 1, "Submarine2" ), 
    		              new Ships ( 1, "Submarine3" ), 
    		              new Ships ( 1, "Submarine4" ) };
        
       
    TreeMap <String, Ships> ships = new TreeMap <String, Ships> ();
    
    JLabel lblScore = new JLabel ( "Score:" );
		 
    ArrayList <Cell> enemyCells = new ArrayList <Cell> ();
    
    Ships currentClickedShip = null;
      
    public JTextPane  messageBox = new JTextPane();
        
    JButton right   = new JButton ( "Tabuleiro Pronto!" );
    JButton start   = new JButton ( "Começar Jogo!"     );
	JButton rotate  = new JButton ( "Rotate Ships!"     );
    JButton reset   = new JButton ( "Reset Ships!"      );
    
    // JButton save     = new JButton ( "Save the game!"    );
    	
    Grid  gridPlayer; 
    
    public ShipsView playerShipButtons; 
    		   
    public BoardView playerBoard;
    
    Cell currentCell = null; 
    
    Grid enemyGrid = null; 
       


    public Player (  ) {
        
    	putShipsIntoTreeMap ( );   	
    	gridPlayer = new Grid ( 500, 500 );    	
    	
    	playerBoard = new BoardView ( );  	
    	playerShipButtons = new ShipsView (); 	
    	playerBoard.cells =  gridPlayer;  		
    	playerShipButtons.shipsSet = ships;        
    	 	
    	setPlayerControlOnShipButtons ( );
    	
    	//setPlayerControlOnPanelButtons ( );
    	
    	setPlayerControlOnGrid ( );
    	   
    }
    
    
    
    private void putShipsIntoTreeMap ( ) {
		
    	
    	ships.put ( AirCarrier.name, AirCarrier );
    	
    	//System.out.println( AirCarrier.name);
    	
    	
    	for( int i = 0; i < 2; i++ ) {    		
    		ships.put ( BatleShip[i].name, BatleShip[i] );
    	
    		//System.out.println( BatleShip[i].name);
    	}	
    	
    	for( int i = 0; i < 3; i++ )  {   		
    		ships.put ( Destroyer[i].name, Destroyer[i] );
    	
    		//System.out.println( Destroyer[i].name);
    	
    	}
    	
    	for( int i = 0; i < 4; i++ )    { 		
    		ships.put ( Submarine[i].name, Submarine[i] );
    	
    	
    		//System.out.println( Submarine[i].name);
    	}
    	
    	
       	for( int i = 0; i < 5; i++ )     {		
    		ships.put ( Cruiser[i].name, Cruiser[i] );
       
    		//System.out.println( Cruiser[i].name);
       	}		
	
    
    
    }
    
    
    
	private void setPlayerControlOnShipButtons ( ) {
				
		playerShipButtons.addMouseListener( listenerForShipButton );			
											
	}
    
    
/*	private void setPlayerControlOnPanelButtons ( ) {
		
    	//rotate.addActionListener ( listenerForRotateButton );
    	//reset.addActionListener  ( listenerForResetButton  );
    	//start.addActionListener  ( listenerForStartButton  );
    	
    	//right.addActionListener  ( listenerForRightButton  );    	
    	//save.addActionListener   ( listenerForSaveButton   );
    	//save.setEnabled(false);
    	    	
	} */

    
    
	public void setPlayerControlOnGrid ( ) {
    	       
		playerBoard.addMouseListener( listener_gridForPutShips );
			
	}

    
	public void putEnemyGridIntoArrayList ( ) {
		
		for( int i = 0; i < enemyGrid.rowCount; i++ ) 	
				for ( int j = 0; j < enemyGrid.columnCount; j++ ) 
					enemyCells.add( enemyGrid.grid.get( enemyGrid.getListIndexFromGridPosition ( i, j ) ) );
			
	}

	
	
    public void setPlayerControlOnEnemyGrid ( JComponent enemyBoard ) {
		
    	// enemyBoard.addMouseListener(listenerForEnemyGrid);
						
	}

	
   
	public void DisableShipButton ( Ships shipButton ) {
		
		shipButton.isShipButtonEnable = false;
		
	}

	
	public void EnableShipButton ( Ships shipButton ) {
		
		shipButton.isShipButtonEnable = true;
		
	}

	
	public void DisableButton( JButton button ) {
		
    	button.setEnabled(false);
		
	}
	
	public void EnableButton( JButton button ) {
		
    	button.setEnabled(true);
		
	}

	
	
	public void putShipOnGrid ( ) {
		   	 
	    for ( int i = 0; i < currentClickedShip.size; i++) {
        
	    	currentCell.isShipPlacedOn = currentClickedShip;
	    	currentCell.cellColorForShip = currentClickedShip.shipColor;
	    	
	    	if ( currentClickedShip.orientation_horizontal == true )    	
	    		currentCell = currentCell.nextInRow;
	    	
	    	else
	    		currentCell = currentCell.nextInColumn;
	    			  
	    }
	   
    }
    	
	
	
	public boolean AllShipsAreSetOnBoard ( ) {
				
		for ( Map.Entry<String,Ships>entry : ships.entrySet() ) 	
			if ( entry.getValue().isShipButtonEnable )
				return false;			
							
		DisableButton ( rotate );		
		DisableButton ( reset  );		
		EnableButton ( right );
		
		return true;
		
	}
	
 
	
	public boolean AllShipsAreSunk ( ) {
	 
		if ( AirCarrier.isSunk 
			 && BatleShip[0].isSunk && BatleShip[1].isSunk 
			 && Destroyer[0].isSunk && Destroyer[1].isSunk && Destroyer[2].isSunk  
			 && Submarine[0].isSunk && Submarine[1].isSunk && Submarine[2].isSunk && Submarine[3].isSunk 
			 && Cruiser[0].isSunk   && Cruiser[1].isSunk   && Cruiser[2].isSunk   && Cruiser[3].isSunk && Cruiser[4].isSunk )
	
			return true;
	 
		else
			return false;
 
	}
    
    
    MouseAdapter listener_gridForPutShips = new MouseAdapter ( ) {
    	
		
		public void mouseClicked ( MouseEvent e ) {
    		
			
    		if ( !GameIsStart&&GameIsOver == false ) {
    		
    			Point selectedCell = null; /* selected point */              
    			
     			if ( e.getX() >= gridPlayer.xOffset && e.getY() >= gridPlayer.yOffset ) { /* get selected point */

     				int i = ( e.getX() - gridPlayer.xOffset ) / gridPlayer.cellWidth;
     				int j = ( e.getY() - gridPlayer.yOffset ) / gridPlayer.cellHeight;
     				     				
     					if ( i >= 0 && j >= 0 && i < gridPlayer.rowCount && j < gridPlayer.columnCount)   						     						
     						selectedCell = gridPlayer.getGridPositionFromClickedPoint ( e.getX(), e.getY() );   			  			
     			
     			} /* end get selected point */
    			
     			
     			currentCell = gridPlayer.grid.get ( gridPlayer.getListIndexFromGridPosition ( selectedCell.x, selectedCell.y ) ); /* get selected cell from selected point */
     			   						
     			
     			try {
     			     			
     				if (  currentCell.currentChosenShip != null ||  currentCell.currentChosenShip.isShipButtonEnable ) /* set ship on grid  */
     				
     					if ( currentCell.isCellEnoughAndNotTaken ( ) && !currentCell.hasCellSomeNeighbors() ) { /* verify if possible */
    					  					
     						putShipOnGrid();
    					
     						messageBox.setText( currentCell.currentChosenShip.name + " is successfully put ");
    					
     						gridPlayer.initialTheCurrentShipForEachCell();
    					
     						DisableShipButton ( currentCell.currentChosenShip );
     				
     					} else 
     						messageBox.setText("No enough space to put the ship"); 
     			    			     				     			
     			} catch (Exception exception) {
     			
     				//messageBox.setText("Please select a ship!");   /* END set ship on grid  */ 			
     				System.out.println("Please select a ship!");
     			
     			}
     				
     		}
    		     		    		    		
    		playerBoard.repaint();
    				
		}  /* END mouse clicked method */
    		
  
    	// this is for highlight effect
		public void mouseEntered (MouseEvent e)  {  }		
		public void mouseExited  (MouseEvent e)  {  }
    	    	
    };
    
    

    
    MouseAdapter listenerForShipButton = new MouseAdapter ( ) {
    	
    	public void mouseClicked ( MouseEvent event ) {
    		
    		Point point = event.getPoint();
    		
    		for ( Map.Entry<String, Ships>entry : ships.entrySet ( ) )  			
    			if ( entry.getValue ( ).shipButton.contains ( point ) )				
    				
    				if ( entry.getValue ( ).isShipButtonEnable ) {
    					
    					messageBox.setText ( entry.getValue ( ).name + " is chosen" );
    					currentClickedShip = entry.getValue ( );
    					gridPlayer.setCurrentShipForEachCell ( entry.getValue ( ) );
    					
    				}
    				
    	
    		playerShipButtons.repaint();
    	   	
    	}			
    				
   };
    

   
   
   
   
}


