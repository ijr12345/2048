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
            move(10, "x");
        }

        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            move(-10, "x");
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            move(-10, "y");
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            move(10, "y");
        }


    }

    //method that enables movement of each game piece
    //numchanges --> specifies num of pixels each piece should move each millisecond (+/-)
    //direction --> specifies X/Y direction of movement
    public void move(int numChange, String direction) {

        JLabel block = pieces.get(12).getLabel();
        Container parent = block.getParent();
        
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


    }

    //constructor to add array list of game pieces and main jframe 
    public MyKeyListener(ArrayList<GamePiece> pieces, JFrame frame) {
        this.pieces = pieces;
        this.frame = frame;

    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
