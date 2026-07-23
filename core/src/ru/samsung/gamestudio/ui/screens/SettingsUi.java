package ru.samsung.gamestudio.ui.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import ru.samsung.gamestudio.ui.UiComponent;
import ru.samsung.gamestudio.ui.components.LiveBackground;

public class SettingsUi extends UiComponent {

    private final int LABEL_HEIGHT = 100;
    private final int BUTTON_WIDTH = 160;
    private final int BUTTON_HEIGHT = 70;
    private final int BUTTON_PADDING = 20;

    public TextButton homeButton;
    public TextButton resetLevelsButton;
    public LiveBackground liveBackground;

    public SettingsUi(Skin skin) {
        super();

        homeButton = new TextButton("home", skin);
        resetLevelsButton = new TextButton("reset levels", skin);
        Label titleLabel = new Label("Settings", skin, "labelTitle");
        LiveBackground liveBackground = new LiveBackground();

        addActor(liveBackground);

        add(titleLabel).height(LABEL_HEIGHT);
        row();
        add(resetLevelsButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT);
        row();
        add(homeButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT).padTop(BUTTON_PADDING);
        row();
    }

    @Override
    public void dispose() {
        liveBackground.dispose();
    }
}
