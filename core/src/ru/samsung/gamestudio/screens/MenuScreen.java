package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.ui.screens.MenuUi;


public class MenuScreen extends BaseScreen {

    private final MenuUi menuUi;

    public MenuScreen(MyGdxGame myGdxGame) {
        super(myGdxGame);

        menuUi = new MenuUi(myGdxGame.skin);
        baseStage.addActor(menuUi);

        setListeners();
    }

    private void updateList() {

        String[] levelsArray = new String[]{
                "First fight",
                "Revenge of pit",
                "The empire strikes",
                "Attack of stars",
                "Attack of stars",
                "Attack of stars",
                "Attack of stars"
        };

        menuUi.listView.setItems(levelsArray);
    }

    @Override
    public void show() {
        super.show();
        updateList();
    }

    @Override
    public void dispose() {
        super.dispose();
        menuUi.dispose();
    }

    private void setListeners() {
        menuUi.exitButton.addListener(onButtonExitClickedListener);
        menuUi.startButton.addListener(onButtonStartClickedListener);
        menuUi.settingsButton.addListener(onButtonSettingsClickedListener);
    }

    ClickListener onButtonExitClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            Gdx.app.exit();
        }
    };

    ClickListener onButtonStartClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            myGdxGame.setScreen(myGdxGame.gameScreen);
        }
    };

    ClickListener onButtonSettingsClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            myGdxGame.setScreen(myGdxGame.settingsScreen);
        }
    };
}
