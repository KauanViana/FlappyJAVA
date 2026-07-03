package entities;

import utils.Constants;

import java.awt.*;

public class Ground {

    private int x;

    public Ground() {

        this.x = 0;

    }

    public void update() {

        this.x -= Constants.PIPE_SPEED;

        if (this.x <= -Constants.WINDOW_WIDTH) {

            this.x = 0;

        }

    }

    public void draw(Graphics2D g2) {

        g2.setColor(new Color(222, 190, 120));

        g2.fillRect(
                this.x,
                Constants.WINDOW_HEIGHT - Constants.GROUND_HEIGHT,
                Constants.WINDOW_WIDTH,
                Constants.GROUND_HEIGHT
        );

        g2.fillRect(
                this.x + Constants.WINDOW_WIDTH,
                Constants.WINDOW_HEIGHT - Constants.GROUND_HEIGHT,
                Constants.WINDOW_WIDTH,
                Constants.GROUND_HEIGHT
        );

    }

}