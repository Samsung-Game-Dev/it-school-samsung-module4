package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.ui.screens.SettingsUi;
public class SettingsScreen extends BaseScreen {

    private final SettingsUi settingsUi;

    public SettingsScreen(MyGdxGame myGdxGame) {
        super(myGdxGame);

        settingsUi = new SettingsUi(myGdxGame.skin);
        baseStage.addActor(settingsUi);

        setListeners();
    }

    @Override
    public void dispose() {
        super.dispose();
        settingsUi.dispose();
    }

    private void setListeners() {
        settingsUi.homeButton.addListener(onButtonHomeClicked);
        settingsUi.resetLevelsButton.addListener(onButtonResetLevelsClicked);
    }

    ClickListener onButtonHomeClicked = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            myGdxGame.setScreen(myGdxGame.menuScreen);
        }
    };

    ClickListener onButtonResetLevelsClicked = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {

        }
    };

}

