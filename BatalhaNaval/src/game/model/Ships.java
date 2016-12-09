package game.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.TreeMap;



public class Ships {
	
	
	public int size = 0;
	public String name;
	public boolean orientation_horizontal = true;
	
	public Rectangle2D.Double shipButton;
	boolean isSunk = false;		
	
	public boolean isShipButtonEnable = true;
	
	Color shipColor = new Color(0,0,0);		
	
	boolean []getHit;
	int hitIndex = 0;
	
	
	
	public Ships ( int size, String name ) {		
		
		this.size = size;	
		this.name = name;
		
		getHit = new boolean[size];		
        
		for(int i = 0; i < this.size; i++) {
      
        	getHit[i]=false;
        }
		
		setShipshipColors ( );
		setShipButtons ( );
	}
		

	
	private void setShipshipColors ( ) {
		
		if(size == 5) 		
			this.shipColor = new Color(176,196,222);
			
		 else if(size == 4) 
			this.shipColor = new Color(143,188,143);
		
		 else if(size == 3) 
			this.shipColor = new Color(255,215,0);
		
		 else if(size == 2) 
			this.shipColor = new Color(188,143,143);
		
		 else if(size == 1) 	
			this.shipColor = new Color(160,32,240);
		
	}



	public void Rotate() {
		
		orientation_horizontal = !orientation_horizontal;				
	}
	
	
    
	public void setShipButtons ( ) {
    	  		
		if ( size == 5 ) /* Carrier Ship */
			shipButton = new Rectangle2D.Double(10, 30, 50,50);		
		
		else if ( size == 4 && name.equals("BattleShip1") ) 
			shipButton = new Rectangle2D.Double(10,80, 50, 50);
		
		else if ( size == 4 && name.equals("BattleShip2") ) 
			shipButton = new Rectangle2D.Double(30,80, 50, 50);
		
		else if ( size == 3 && name.equals("Cruiser 1") ) 
			shipButton = new Rectangle2D.Double(10,130, 50, 50);
		
		else if ( size == 3 && name.equals("Cruiser 2") ) 
			shipButton = new Rectangle2D.Double(30,130,50,50);
		
		else if ( size == 3 && name.equals("Cruiser 3") ) 
			shipButton = new Rectangle2D.Double(50,130,50,50);
		
		else if ( size == 3 && name.equals("Cruiser 4") ) 
			shipButton = new Rectangle2D.Double(70,130,50,50);
		
		else if ( size == 3 && name.equals("Cruiser 5") ) 
			shipButton = new Rectangle2D.Double(90,130,50,50);
				
		else if ( size == 2 && name.equals("Destroyer1") )
			shipButton = new Rectangle2D.Double(10,180,50,50);		 
		
		else if ( size == 2 && name.equals("Destroyer2") )
			shipButton = new Rectangle2D.Double(30,180,50,50);	
		
		else if ( size == 2 && name.equals("Destroyer3") )
			shipButton = new Rectangle2D.Double(50,180,5,5);	
		
		else if ( size == 1 && name.equals("Submarine1") )
			shipButton = new Rectangle2D.Double(10,230,5,5);
		
		else if ( size == 1 && name.equals("Submarine2") )
			shipButton = new Rectangle2D.Double(30,230,5,5);
		
		else if ( size == 1 && name.equals("Submarine3") )
			shipButton = new Rectangle2D.Double(50,230,5,5);
		
		else if ( size == 1 && name.equals("Submarine4") )
			shipButton = new Rectangle2D.Double(70,230,5,5);
		
		
    }
	
    
	public boolean isSunk() {
    	
		int sunkIndex = 0;
    	
		for( int i = 0; i < this.size; i++ ) 
    		if( this.getHit[i] == true ) 
    			sunkIndex = sunkIndex + 1;
    		    	
    	 if(sunkIndex == this.size) {
    		
			 this.isSunk = true;
    		 return true;
    	 }
    	 
		 return false;   	
    }


	
	public void setHit() {
		
		try {	
		
			this.getHit[hitIndex] = true;
			hitIndex = hitIndex + 1;		
		
		} catch(Exception e) { }		
	
	}
	

	
	
	public Ships getShipButton ( TreeMap <String, Ships> ships, Point pointClicked ) {
				
		if ( isShipButtonEnable == false ) 
			return null;
						
		
		for ( Map.Entry<String, Ships>entry : ships.entrySet ( ) )  			
			if ( entry.getValue ( ).shipButton.contains ( pointClicked ) )				
				return entry.getValue();
								
		
		return null;	
		
				
	}
	
		
}
