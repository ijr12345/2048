import javax.swing.*;
import java.awt.*;

public class GUISetup {
    public JFrame makeFrame() {
        JFrame frame = new JFrame();

        frame.setTitle("2048");
        frame.setVisible(true);

        return frame;
    }
}