import utils.Constants;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow() {

        setTitle(Constants.WINDOW_TITLE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        GamePanel panel = new GamePanel();
        setIconImage(new ImageIcon("./res/sprites/bird.png").getImage());

        add(panel);

        pack();

        setLocationRelativeTo(null);

        setVisible(true);

        panel.requestFocusInWindow();

    }

}