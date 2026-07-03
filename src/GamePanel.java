import entities.Bird;
import entities.Ground;
import entities.Pipe;
import enums.GameState;
import managers.*;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final Bird bird;
    private final Pipe pipe;
    private final Ground ground;

    private PipeManager pipeManager;
    private CollisionManager collisionManager;
    private ScoreManager scoreManager;


    private Timer timer;

    public GamePanel() {

        setPreferredSize(new Dimension(
                Constants.WINDOW_WIDTH,
                Constants.WINDOW_HEIGHT
        ));

        setBackground(new Color(120,200,255));

        bird = new Bird();
        pipe = new Pipe(Constants.PIPE_SPAWN_X);
        ground = new Ground();

        pipeManager = new PipeManager();
        collisionManager = new CollisionManager();
        scoreManager = new ScoreManager();

        addKeyListener(new InputManager(bird, pipeManager, scoreManager));

        timer = new Timer(1000 / Constants.FPS, e -> {

            switch (GameStateManager.getState()) {

                case GameState.MENU:
                    // Não atualiza o jogo, apenas espera o jogador iniciar.
                    break;

                case GameState.PLAYING:
                    // Atualiza o jogo normalmente.
                    bird.update();
                    pipeManager.update();
                    ground.update();
                    scoreManager.update(bird, pipeManager);
                    break;
                case GameState.GAME_OVER:
                    // Não atualiza o jogo, apenas exibe a tela de game over.
                    break;

            }

            if (collisionManager.check(bird, pipeManager)) {

                //timer.stop();
                GameStateManager.setState(GameState.GAME_OVER);

            }

            repaint();

        });

        timer.start();

    }


/*
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        pipeManager.draw(g2);

        bird.draw(g2);

        ground.draw(g2);

        scoreManager.draw(g2);

    }*/

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        switch (GameStateManager.getState()) {

            case GameState.MENU:

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 40));
                g2.drawString("FLAPPY BIRD", 120, 200);

                g2.setFont(new Font("Arial", Font.PLAIN, 20));
                g2.drawString("Pressione ESPAÇO para jogar", 100, 260);

                break;

            case GameState.PLAYING:

                pipeManager.draw(g2);
                bird.draw(g2);
                ground.draw(g2);
                scoreManager.draw(g2);

                break;

            case GameState.GAME_OVER:

                pipeManager.draw(g2);
                bird.draw(g2);
                ground.draw(g2);
                scoreManager.draw(g2);

                g2.setColor(new Color(0, 0, 0, 150));
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 40));
                g2.drawString("GAME OVER", 110, 250);

                g2.setFont(new Font("Arial", Font.PLAIN, 20));
                g2.drawString("Pressione ESPAÇO para reiniciar", 100, 310);

                break;
        }
    }

}