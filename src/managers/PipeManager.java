package managers;

import entities.Pipe;
import utils.Constants;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PipeManager {

    private final List<Pipe> pipes = new ArrayList<>();

    public PipeManager() {

        pipes.add(new Pipe(Constants.PIPE_SPAWN_X));
        pipes.add(new Pipe(Constants.PIPE_SPAWN_X + Constants.PIPE_DISTANCE));
        pipes.add(new Pipe(Constants.PIPE_SPAWN_X + Constants.PIPE_DISTANCE * 2));

    }

    public void update() {

        Iterator<Pipe> iterator = pipes.iterator();

        while (iterator.hasNext()) {

            Pipe pipe = iterator.next();

            pipe.update();

            if (pipe.isOffScreen()) {
                iterator.remove();
            }

        }

        while (pipes.size() < 3) {

            Pipe lastPipe = pipes.get(pipes.size() - 1);
            pipes.add(new Pipe(lastPipe.getX() + Constants.PIPE_DISTANCE));

        }

    }

    public void draw(Graphics2D g2) {

        for (Pipe pipe : pipes)
            pipe.draw(g2);

    }

    public List<Pipe> getPipes() {

        return pipes;

    }

    public void reset(){
        pipes.clear();
        pipes.add(new Pipe(Constants.PIPE_SPAWN_X));
        pipes.add(new Pipe(Constants.PIPE_SPAWN_X + Constants.PIPE_DISTANCE));
        pipes.add(new Pipe(Constants.PIPE_SPAWN_X + Constants.PIPE_DISTANCE * 2));
    }

}