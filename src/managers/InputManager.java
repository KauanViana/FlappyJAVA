package managers;

import entities.Bird;
import enums.GameState;
import utils.SfxPlayer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class InputManager extends KeyAdapter {

    private final Bird bird;
    private final PipeManager pipeManager;
    private final ScoreManager scoreManager;


    public InputManager(Bird bird, PipeManager pipeManager, ScoreManager scoreManager) {
        System.out.println(GameStateManager.getState());

        this.bird = bird;
        this.pipeManager = pipeManager;
        this.scoreManager = scoreManager;

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            
            switch (GameStateManager.getState()) {

                case GameState.MENU:
                    GameStateManager.setState(GameState.PLAYING);
                    new SfxPlayer("click.wav", -15.0f);
                    break;

                case GameState.PLAYING:
                    bird.jump();
                    break;

                case GameState.GAME_OVER:
                    new ResetGameManager(bird, pipeManager, scoreManager);
                    GameStateManager.setState(GameState.MENU);
                    break;
            }
        }
    }

}