import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import java.awt.*;
import java.awt.event.*;

public class GamePiece {
//public class GamePiece implements KeyListener {


    int row;
    int col;
    int value;
    JLabel label;


    public JLabel newSlidingPiece(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        
        JLabel piece = new JLabel(String.valueOf(value));
        this.label = piece;

        Border blackLine = BorderFactory.createLineBorder(Color.red);
        piece.setBorder(blackLine);
        piece.setSize(140,140);

        //x, y 
        piece.setLocation(col * 160 + 15, row * 160 + 15);

        return piece;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setValue(int value) {
        this.value = value;
        label.setText(String.valueOf(value));
    }

    public int getRow() {
        return row;
    }

    /*public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //move(-10, "x", 0);
            label.setLocation(175, 175);

        }
    }
    */




    
}



/*

0,0  0,1  0,2
1,0  1,1  1,2
2,0  2,1  2,2




*/
