package managers;

import enums.GameState;

public class GameStateManager {
    private static GameState state = GameState.MENU;

    public static GameState getState() {
        return GameStateManager.state;
    }

    public static void setState(GameState state) {
        GameStateManager.state = state;
        System.out.println(GameStateManager.getState());
    }
}
