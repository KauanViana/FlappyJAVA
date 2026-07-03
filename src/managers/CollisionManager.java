package managers;

import entities.Bird;
import entities.Pipe;
import enums.GameState;
import utils.Constants;

public class CollisionManager {

    public boolean check(Bird bird, PipeManager manager) {
        if (GameStateManager.getState() == GameState.PLAYING) {

            if (bird.getY() < 0)
                return true;

            if (bird.getY() + Constants.BIRD_HEIGHT >
                    Constants.WINDOW_HEIGHT - Constants.GROUND_HEIGHT)
                return true;

            for (Pipe pipe : manager.getPipes()) {

                if (bird.getBounds().intersects(pipe.getTopBounds()))
                    return true;

                if (bird.getBounds().intersects(pipe.getBottomBounds()))
                    return true;

            }

        }
        return false;

    }

}