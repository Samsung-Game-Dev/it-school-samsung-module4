package ru.samsung.gamestudio.game;

import com.badlogic.gdx.Gdx;

public class GameSettings {

    private static final float baseHeight = 560;
    private static final float baseRatio = Gdx.graphics.getHeight() / baseHeight;

    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth() / baseRatio;
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight() / baseRatio;

    public static final String SKIN_PATH = "skin/skin.json";


}
