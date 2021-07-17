import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class allKeyListener implements KeyListener { 
    ArrayList<GamePiece> allPieces;
    JFrame frame;

    //constructor to access necessary elements 
    public allKeyListener(ArrayList<GamePiece> allpieces, JFrame frame) {
        this.allPieces = allpieces;
        this.frame = frame;
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            makeMove("left");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            makeMove("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            makeMove("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            makeMove("down");
        }

    }

    public void makeMove(String direction) {
        //each piece will move in the determined direction
        for (GamePiece p: allPieces) {
            move(direction, p.getLabel(), frame);
        }
    }

    public void move(String direction, JLabel piece, JFrame frame) {

        // changes in x and y
        //array used to bypass final int requirements in java timer 
        ArrayList<Integer> coordChanges = new ArrayList<>();
        

        //determines X/Y changes in each direction 
        if (direction.equalsIgnoreCase("right")) {
            //first adds change in x direction, then y direction
            coordChanges.add(10);
            coordChanges.add(0);
        }
        if (direction.equalsIgnoreCase("left")) {
            coordChanges.add(-10);
            coordChanges.add(0);
        }
        if (direction.equalsIgnoreCase("up")) {
            coordChanges.add(0);
            coordChanges.add(-10);
        }
        if (direction.equalsIgnoreCase("down")) {
            coordChanges.add(0);
            coordChanges.add(10);
        }


        Timer timer = new Timer(1, new ActionListener() {

            
            //@Override
            public void actionPerformed(ActionEvent e) {

                //moves piece in selected direction
                piece.setLocation(piece.getX() + coordChanges.get(0) , piece.getY() + coordChanges.get(1));


                //prevents piece from moving outside of playing pannel
                if (coordChanges.get(1) == 0 ) {
                    if (piece.getX() == 495 || piece.getX() == 15) {
                        ((Timer)e.getSource()).stop();
                    }
                }
                else {
                    if (piece.getY() == 495 || piece.getY() == 15) {
                        ((Timer)e.getSource()).stop();
                    }
                }
                
                //shows each new location. creating illusion of floating across screen
                frame.validate();
                frame.repaint();
            }
        });

        timer.start();
        
    }
    



}

