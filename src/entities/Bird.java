package entities;

import utils.Constants;

import java.awt.*;

public class Bird {

    private double x;
    private double y;

    private double velocityY;

    public Bird() {

        this.x = Constants.BIRD_START_X;
        this.y = Constants.BIRD_START_Y;

        this.velocityY = 0;

    }

    public void update() {

        this.velocityY += Constants.GRAVITY;

        this.y += this.velocityY;

    }

    public void jump() {

        this.velocityY = Constants.JUMP_FORCE;

    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.YELLOW);

        g2.fillOval(
                (int)this.x,
                (int)this.y,
                Constants.BIRD_WIDTH,
                Constants.BIRD_HEIGHT
        );

    }

    public Rectangle getBounds() {

        return new Rectangle(
                (int)this.x,
                (int)this.y,
                Constants.BIRD_WIDTH,
                Constants.BIRD_HEIGHT
        );

    }

    public void reset() {

        this.x = Constants.BIRD_START_X;
        this.y = Constants.BIRD_START_Y;
        this.velocityY = 0;

    }

    public double getY() {
        return this.y;
    }

    public double getX() {
        return this.x;
    }

}