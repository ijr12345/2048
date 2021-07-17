import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;

//import java.util.Timer;

public class MyKeyListener implements KeyListener {
    ArrayList<GamePiece> pieces;
    JFrame frame;
    GameLogic gameLogic;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            /*JFrame test = new JFrame();
            test.setVisible(true);

            test.setTitle(String.valueOf(pieces.get(0).getRow()));
            test.setVisible(true);
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            */
            
            //removes a jlabel
            /*Container parent = pieces.get(0).getLabel().getParent();
            parent.remove(pieces.get(0).getLabel());
            parent.validate();
            parent.repaint();
            */


            /*JLabel block = pieces.get(0).getLabel();
            Container parent = block.getParent();
            //parent.remove(block);


            Timer timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.remove(block);
                    parent.validate();
                    parent.repaint();
                }
            });
            timer.start();
            */

            //changes value/text in a game piece
            /*
            JLabel block = pieces.get(0).getLabel();
            Container parent = block.getParent();

            //int xLocation2 = (String) xLocation;
            pieces.get(0).setValue(pieces.size());
            //parent.setLocation(53, 100);
            //block.setLocation(xLocation +150, yLocation );
            
            parent.validate();
            parent.repaint();
            */

            //move a piece
            move(10, "x", 0);
        }

        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            move(-10, "x", 0);
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            move(-10, "y", 0);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            /*for (int i = 0; i < pieces.size(); i++) {
                move(10, "y", 1);
            }
            */
            move(10, "y", 0);
            move(10, "y", 1);

        }


    }

    //method that enables movement of each game piece
    //numchanges --> specifies num of pixels each piece should move each millisecond (+/-)
    //direction --> specifies X/Y direction of movement
    public void move(int numChange, String direction, int piece) {

        JLabel block = pieces.get(piece).getLabel();
        Container parent = block.getParent();

        if (invalidMove(block.getX(), block.getY(), numChange, direction)) {}

        else {
        
            //determines pixel change and in what direction
            int xChange = 0;
            int yChange = 0;
            if (direction.equalsIgnoreCase("x")) {
                xChange = numChange;
            }
            else {
                yChange = numChange;
            }

            //assigns values to 'final' types 
            final int xChange1 = xChange;
            final int yChange1 = yChange;
            

            Timer timer = new Timer(1, new ActionListener() {
                int count = 0;

                @Override
                public void actionPerformed(ActionEvent e) {

                    //moves piece 
                    block.setLocation(block.getX() + xChange1 , block.getY() + yChange1);

                    //iterates 16 times, each time moving given distance
                    count++;
                    if (count == 16) {
                        ((Timer)e.getSource()).stop();
                    }
                    
                    
                    //shows each new location. creating illusion of floating across screen
                    parent.validate();
                    parent.repaint();
                }
            });

            timer.start();
            pieces.get(0).setValue(block.getY());
        }




    }

    //constructor to add array list of game pieces and main jframe 
    public MyKeyListener(ArrayList<GamePiece> pieces, JFrame frame,GameLogic gameLogic) {
        this.pieces = pieces;
        this.frame = frame;
        this.gameLogic = gameLogic;
    }

    //row/col --> coords of current piece
    //change and direction --> where the piece will move to 
    public boolean invalidMove(int xCoord, int yCoord, int change, String direction) {
        //out of plating grid
        if (yCoord == 15 && change < 0 && direction.equalsIgnoreCase("y")) {
            return true;
        }
        if (yCoord == 495 && change > 0 && direction.equalsIgnoreCase("y")) {
            return true;
        }
        if (xCoord == 15 && change < 0 && direction.equalsIgnoreCase("x")) {
            return true;
        }
        if (xCoord == 495 && change > 0 && direction.equalsIgnoreCase("x")) {
            return true;
        }

        

        return false;


    }



    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
