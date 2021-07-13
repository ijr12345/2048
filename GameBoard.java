import javax.swing.*;
import javax.swing.border.Border;
//import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

//import java.awt.event.keyEvent; 

public class GameBoard {

    ArrayList <GamePiece> pieces;

    //populates game pannel with game pieces 
    public JPanel makeGameGrid(JPanel gamePanel) {
        pieces = new ArrayList<>();
        
        //makes 1 game piece 
        /*GamePiece piece = new GamePiece();
        JLabel block =  piece.newSlidingPiece(0, 0, 20);
        //block.setLocation(50, 50);
        //block.setSize(50,50);

        pieces.add(piece);

        gamePanel.add(block);
        */
        

        //makes 16 game pieces
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                GamePiece piece = new GamePiece();
                JLabel block =  piece.newSlidingPiece(i, j, 2);

                pieces.add(piece);

                gamePanel.add(block);
            }
        }
        
    
        return gamePanel;

    }

    public ArrayList<GamePiece> getPieces() {
        return pieces;
    } 
    
}



