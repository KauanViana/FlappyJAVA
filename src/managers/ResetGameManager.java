package managers;

import entities.Bird;
import entities.Pipe;

public class ResetGameManager {
    public ResetGameManager(Bird bird, PipeManager pipeManager, ScoreManager scoreManager) {
        bird.reset();
        pipeManager.reset();
        scoreManager.reset();


    }
}
