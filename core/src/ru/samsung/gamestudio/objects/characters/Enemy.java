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

import static ru.samsung.gamestudio.game.GameSettings.ENEMY_BIT;
import static ru.samsung.gamestudio.game.GameSettings.SCALE;

public class Enemy extends PhysicalActor implements Disposable {

    private enum State {IDLE, RUNNING, DEAD}

    private Animation<TextureRegion> idleAnimation;
    private TextureRegionDrawable drawable;

    private final int walkLength;
    private final float tileScale;

    private float timer;
    private State state;

    public Enemy(World world, Rectangle bounds, int walkLength, float tileScale) {

        this.walkLength = walkLength;
        this.tileScale = tileScale;

        setPhysicalObject(
                new PhysicalObject.PhysicalObjectBuilder(world, BodyDef.BodyType.DynamicBody)
                        .addCircularFixture(bounds.getHeight() / 2, ENEMY_BIT)
                        .setInitialPosition(bounds.x + bounds.getWidth() / 2, bounds.y + bounds.getHeight() / 2)
                        .build(this)
        );

        createAnimations();
        timer = 0;
        state = State.IDLE;
        setSize(bounds.getWidth() * tileScale, bounds.getHeight() * tileScale);
    }

    private void createAnimations() {
        Texture texture = new Texture(GameResources.ENEMY_TILESET_PATH);
        Array<TextureRegion> frames = new Array<>();
        drawable = new TextureRegionDrawable();
        setDrawable(drawable);

        for (int i = 0; i < 8; i++) {
            frames.add(new TextureRegion(texture, i * 34, 0, 34, 30));
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
