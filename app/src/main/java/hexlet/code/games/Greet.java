package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.GameRound;

public final class Greet {

    private final Engine engine;

    public Greet(Engine injectedEngine) {
        this.engine = injectedEngine;
        runGame();
    }

    public void runGame() {
        engine.play(new GameRound());
    }
}
