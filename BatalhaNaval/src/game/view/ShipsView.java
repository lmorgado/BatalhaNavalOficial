package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.controller.Cell;
import game.model.Ships;


public class ShipsView extends JPanel {
    
    
    private List<Image> images;
    public TreeMap <String, Ships> shipsSet;
    
    public ShipsView ( ) {
      
//    	
//    	BufferedImage image;
//    	int shipSize;
//    	   	
//    	for ( Map.Entry<String, Ships>entry : shipsSet.entrySet ( ) )  {
//        	
//    		shipSize = entry.getValue ( ).size;
//    		 
//    		System.out.println("Size: " );
//    		
//        	try {
//                   		
//        		if ( shipSize == 1  )
//        			image = ImageIO.read( ShipsView.class.getResource("/resources/Submarine.png") );
//        			       		
//        		else if ( shipSize == 2  )
//        			image = ImageIO.read( ShipsView.class.getResource("/resources/Destroyer.png") );
//        			
//        		else if ( shipSize == 3  )
//        			image = ImageIO.read( ShipsView.class.getResource("/resources/Cruiser.png") );		
//        		
//        		else if ( shipSize == 4 )
//        			image = ImageIO.read( ShipsView.class.getResource("/resources/Battleship.png") );
//        						
//        		else if ( shipSize == 5  )
//        			image = ImageIO.read( ShipsView.class.getResource("/resources/Carrier.png") );
//        	
//        		else
//        			image = null;
//        		
//        		
//        	
//        		images.add(image);        		
//        		
//        	} catch (IOException ioe) {
//               
//        		ioe.printStackTrace();
//            }
//    
//        	System.out.println("Size:2");
//    	
//    	
//    	}
    	
    	
    	
  	
    	
    }

    
    public Dimension getPreferredSize ( ) {
    	
    	return new Dimension (500, 500);
    
    }

    
  
    protected void paintComponent ( Graphics g ) {
        
    	super.paintComponent ( g );     
    	
    	Graphics2D g2d = (Graphics2D) g.create();
    			
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	System.out.println("Size: " + images.size());
    	
    	
   /* 	for ( BufferedImage img : images) {
    		
    		g2d.setColor(Color.BLACK);
    		
    		g2d.drawImage(img, 0, 0, this);
    		
    		
    	}	*/
    		
 
   
    	
    	
    	
    	
    	
    	
    				
						
    	g.dispose();
    
    }



}

