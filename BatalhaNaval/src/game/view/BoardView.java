package game.view;

import game.controller.Cell;
import game.controller.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class BoardView extends JPanel {
    	             
	public Grid cells;	
	     
	public BoardView ( ) {
        		
		this.setBackground (Color.CYAN);
       	 			
	}
            	
	public Dimension getPreferredSize ( ) {           
	
		return new Dimension (500, 500);        		
	}

             
	public void invalidate ( ) {      
		
		super.invalidate ( );    
	} 
        
        
	protected void paintComponent(Graphics g) {
            
		super.paintComponent(g);		
		Graphics2D g2d = (Graphics2D) g.create();  
		Color testColorForShip = new Color (0, 0, 0);
		        	
		for (Cell cell : cells.grid) {
			
			if ( cell.cellColorForShip != testColorForShip  )
				g2d.setColor( cell.cellColorForShip );
						
			if( cell.isWhite)
				g2d.setColor(Color.WHITE);
         	
			else if ( cell.isRed )
				g2d.setColor ( Color.RED );
         	
			else if ( cell.isCyan )
				g2d.setColor ( Color.CYAN );
         	
			g2d.fill(cell);
       
		}
					
		g2d.setColor(Color.BLACK);
			
        for (Cell cell : cells.grid)
        	g2d.draw(cell);
            
        g2d.dispose();
	
	}
	

	
}
