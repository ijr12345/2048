import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import java.awt.*;
import java.awt.event.*;

public class GUISetup {
    public JFrame makeFrame() {
        JFrame frame = new JFrame();

        frame.setTitle("2048");
        //frame.setVisible(true);
        frame.setPreferredSize(new Dimension(800,800));
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        return frame;
        //test
    }

    public JLabel addTitle(JFrame frame) {
        JLabel title = new JLabel("2048");
        frame.getContentPane().add(title);
        title.setAlignmentX(frame.getAlignmentX());

        return title;
    }

    public JPanel makeGamePanel(JFrame frame) {
        JPanel gamePanel = new JPanel();


        gamePanel.setLayout(null);

        Border blackline = BorderFactory.createLineBorder(Color.blue);
        gamePanel.setBorder(blackline);

        gamePanel.setMaximumSize(new Dimension(650,650));

        gamePanel.setAlignmentX(frame.getAlignmentX());
        frame.getContentPane().add(gamePanel);

        return gamePanel;

    }


    
}