import javax.swing.*;

//import org.graalvm.compiler.lir.CompositeValue.Component;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public void play() {
        GUISetup newGame = new GUISetup();
        
        
        JFrame frame = newGame.makeFrame();

        //add game title
        newGame.addTitle(frame);
        
        //spacing within main frame (formatting)
        frame.add(Box.createRigidArea(new Dimension(5,5)));

        //adding game pannel
        JPanel gamePanel = newGame.makeGamePanel(frame);

        //initializes game logic 
        GameLogic newGameLogic = new GameLogic();
        

        //adding squares to game pannel
        GameBoard newBoard = new GameBoard();
        JPanel completeGamePanel = newBoard.makeGameGrid(gamePanel, newGameLogic);




        frame.pack();
        frame.setVisible(true);
        //MyKeyListener l = new MyKeyListener(newBoard.getPieces(), frame, newGameLogic);
        //frame.addKeyListener(l);
        //GamePiece l = new GamePiece();
        allKeyListener l = new allKeyListener(newBoard.getPieces(), frame);
        frame.addKeyListener(l);

        frame.repaint();

        //testinggg branch once again 
        

        


        

        
        
    }
}
    
