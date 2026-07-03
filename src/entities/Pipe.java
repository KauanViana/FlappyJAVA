package entities;

import utils.Constants;

import java.awt.*;
import java.util.Random;

public class Pipe {

    private int x;
    private int gapY;

    private boolean scored;

    private final Random random = new Random();

    public Pipe(int startX) {

        this.scored = false;

        this.x = startX;

        randomizeGap();

    }

    private void randomizeGap() {

        this.gapY = random.nextInt(250) + 120;

    }

    public void update() {

        this.x -= Constants.PIPE_SPEED;

    }

    public void draw(Graphics2D g2) {

        g2.setColor(new Color(30, 180, 40));

        // Cano superior
        g2.fillRect(
                this.x,
                0,
                Constants.PIPE_WIDTH,
                this.gapY
        );

        // Cano inferior
        g2.fillRect(
                this.x,
                this.gapY + Constants.PIPE_GAP,
                Constants.PIPE_WIDTH,
                Constants.WINDOW_HEIGHT
        );

    }

    public Rectangle getTopBounds() {

        return new Rectangle(
                this.x,
                0,
                Constants.PIPE_WIDTH,
                this.gapY
        );

    }

    public Rectangle getBottomBounds() {

        return new Rectangle(
                this.x,
                this.gapY + Constants.PIPE_GAP,
                Constants.PIPE_WIDTH,
                Constants.WINDOW_HEIGHT
        );

    }

    public boolean isOffScreen() {

        return this.x + Constants.PIPE_WIDTH < 0;

    }

    public int getX() {

        return this.x;

    }

    public boolean isScored() {
        return this.scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

}