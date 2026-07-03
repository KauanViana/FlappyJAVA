package managers;

import entities.Bird;
import entities.Pipe;

import java.awt.*;

public class ScoreManager {

    private int score = 0;

    public void update(Bird bird, PipeManager pipes) {

        for (Pipe pipe : pipes.getPipes()) {

            if (!pipe.isScored()
                    && bird.getX() > pipe.getX()) {

                score++;

                pipe.setScored(true);

            }

        }

    }

    public void reset() {

        score = 0;

    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.WHITE);

        g2.setFont(new Font("Arial",
                Font.BOLD,
                32));

        g2.drawString("" + score,
                220,
                60);

    }

}