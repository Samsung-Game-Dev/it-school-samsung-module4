package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.utils.Level;
import ru.samsung.gamestudio.utils.MapManager;

public class GameScreen extends BaseScreen {

    private MapManager mapManager;
    private OrthoCachedTiledMapRenderer mapRenderer;
    private Level level;

    public GameScreen(MyGdxGame myGdxGame) {
        super(myGdxGame);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void show() {
        startGame();
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 0);

        mapRenderer.setView(myGdxGame.camera);
        mapRenderer.render();
        super.render(delta, false);
    }

    private void startGame() {
        loadLevel();
    }

    public void loadLevel() {
        mapManager = new MapManager(level.getPath());
        mapRenderer = new OrthoCachedTiledMapRenderer(mapManager.getMap(), mapManager.getTileScale());
    }

}
