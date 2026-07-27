package ru.samsung.gamestudio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.I18NBundle;


public class GameSettings {

    private static final float baseHeight = 560;
    private static final float baseRatio = Gdx.graphics.getHeight() / baseHeight;

    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth() / baseRatio;
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight() / baseRatio;

    public static final String SKIN_PATH = "skin/skin.json";
    private static final String LOCALIZATION_BUNDLE_PATH = "localization/bundle";

    public static I18NBundle localizationBundle = I18NBundle.createBundle(Gdx.files.internal(LOCALIZATION_BUNDLE_PATH));

    public static final int PLAYER_LIVES = 3;

    // Physics settings

    public static final float SCALE = 0.014f;

    public static final short FLOOR_BIT = 1;
    public static final short PLAYER_BIT = 4;
    public static final short ENEMY_BIT = 8;

}
