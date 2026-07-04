package utils;

public final class Constants {

    private Constants() {}

    // Janela
    public static final int WINDOW_WIDTH = 480;
    public static final int WINDOW_HEIGHT = 640;
    public static final String WINDOW_TITLE = "Flappy Fairy";

    // Jogo
    public static final int FPS = 60;

    // Passarinho
    public static final int BIRD_WIDTH = 34;
    public static final int BIRD_HEIGHT = 24;

    public static final double GRAVITY = 0.45;
    public static final double JUMP_FORCE = -8.0;

    public static final int BIRD_START_X = 120;
    public static final int BIRD_START_Y = 250;

    // Cano
    public static final int PIPE_WIDTH = 70;
    public static final int PIPE_GAP = 170;
    public static final int PIPE_SPEED = 4;
    public static final int PIPE_SPAWN_X = WINDOW_WIDTH;
    public static final int PIPE_DISTANCE = 220;
    public static final int MAX_PIPES = 3;

    // Chão
    public static final int GROUND_HEIGHT = 80;

}