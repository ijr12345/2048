import javax.swing.*;
import javax.swing.border.Border;
//import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Random;

//import java.awt.event.keyEvent; 

public class GameBoard {

    ArrayList <GamePiece> pieces;

    //populates game pannel with game pieces 
    public JPanel makeGameGrid(JPanel gamePanel, GameLogic gameLogic) {
        pieces = new ArrayList<>();
        
        //generate random starting piece location
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);

        //creates initial game piece 
        GamePiece piece = new GamePiece();
        JLabel block =  piece.newSlidingPiece(0, 0, 6);
        pieces.add(piece);

        //update game logic grid
        gameLogic.updateSpace(0, 0, 2);

        gamePanel.add(block);


        GamePiece piece2 = new GamePiece();
        JLabel block2 =  piece2.newSlidingPiece(0, 1, 2);
    
        //allKeyListener l = new allKeyListener();
        //piece2

        pieces.add(piece2);

        //update game logic grid
        gameLogic.updateSpace(0, 1, 2);

        gamePanel.add(block2);
        
        

        //makes 16 game pieces
        /*
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                GamePiece piece = new GamePiece();
                JLabel block =  piece.newSlidingPiece(i, j, 2);

                pieces.add(piece);

                gamePanel.add(block);
            }
        }
        */
        
    
        return gamePanel;

    }

    public ArrayList<GamePiece> getPieces() {
        return pieces;
    } 
    
}



