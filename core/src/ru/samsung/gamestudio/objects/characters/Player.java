package ru.samsung.gamestudio.objects.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import ru.samsung.gamestudio.game.GameResources;
import ru.samsung.gamestudio.objects.PhysicalObject;

import static ru.samsung.gamestudio.game.GameSettings.*;

public class Player extends PhysicalActor implements Disposable {

    private enum State {JUMPING, IDLE, RUNNING, ATTACKING, DEAD, GETTING_DAMAGE}

    private Animation<TextureRegion> idleAnimation;
    private TextureRegionDrawable drawable;

    private final float tileScale;

    private float timer;
    private State state;
    private int leftLives;

    public Player(World world, Rectangle bounds, float tileScale) {
        this.tileScale = tileScale;

        setPhysicalObject(
                new PhysicalObject.PhysicalObjectBuilder(world, BodyDef.BodyType.DynamicBody)
                        .addCircularFixture(bounds.getHeight() / 2, PLAYER_BIT)
                        .setInitialPosition(bounds.x + bounds.getWidth() / 2, bounds.y + bounds.getHeight() / 2)
                        .build(this)
        );

        createAnimations();
        timer = 0;
        state = State.IDLE;
        leftLives = PLAYER_LIVES;
        setSize(bounds.getWidth() * 2 * tileScale, bounds.getHeight() * tileScale);
    }

    private void createAnimations() {
        Texture texture = new Texture(GameResources.PLAYER_TILESET_PATH);
        Array<TextureRegion> frames = new Array<>();
        drawable = new TextureRegionDrawable();
        setDrawable(drawable);

        for (int i = 0; i < 5; i++) {
            frames.add(new TextureRegion(texture, 64 * i, 4 * 40, 64, 40));
        }

        idleAnimation = new Animation<>(0.15f, frames, Animation.PlayMode.LOOP);

    }

    @Override
    public void act(float delta) {
        TextureRegion region = idleAnimation.getKeyFrame(timer);

        timer += delta;
        drawable.setRegion(region);

        setPosition(
                (getPhysicalObject().getBody().getPosition().x) / SCALE * tileScale - getWidth() / 2,
                (getPhysicalObject().getBody().getPosition().y) / SCALE * tileScale - getHeight() / 1.5f
        );
    }

    @Override
    public void dispose() {
        idleAnimation.getKeyFrame(0).getTexture().dispose();
    }
}
