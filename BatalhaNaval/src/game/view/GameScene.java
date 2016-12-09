package game.view;

import game.model.Player;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class GameScene {

    public static void main(String[] args) {    
    
    	new GameScene();
   
    }

    
    public GameScene() {
        
    	EventQueue.invokeLater(new Runnable() {
           
            public void run() {
                
            	try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               
            	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) { }

                JFrame frame = new JFrame("TestBoardView");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout());
                
                Player p = new Player();
            
                
                
                
                //frame.getContentPane().add(new BoardView()); 
               // frame.getContentPane().add(p.playerBoard);
                
               frame.getContentPane().add(p.playerShipButtons);
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
   }

}