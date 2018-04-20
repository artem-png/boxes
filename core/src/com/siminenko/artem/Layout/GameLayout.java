package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Listeners.BallonListener;
import com.siminenko.artem.Model.Player;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.ObstacleGenerator;
import com.siminenko.artem.MyGdxGame;

import box2dLight.RayHandler;

/**
 * Created by artem on 3/21/18.
 */

public class GameLayout implements LayoutInterface {
    public World world;
    public RayHandler rayHandler;
    public Box2DDebugRenderer dDebugRenderer;
    Player player;
    ObstacleGenerator obstacleGenerator;
    Background background;
    int timeBeforeDeath = 60;
    int timelapse = 0;

    public static boolean isDispose = false;

    public GameLayout() {
        world = new World(new Vector2(0, -30f), true);
        world.setContactListener(new BallonListener());
        rayHandler = new RayHandler(world);
        dDebugRenderer = new Box2DDebugRenderer();
        player = new Player(world, new Vector2(MyGdxGame.width / 2, 30));
        obstacleGenerator = new ObstacleGenerator(world);
        background = new Background();
    }

    @Override
    public void act(float delta) {
        background.act();
        if (GameLayout.isDispose) {
            if (this.world == null) {
                world = new World(new Vector2(0, -30f), true);
                player = new Player(world, new Vector2(MyGdxGame.width / 2, 30));
                obstacleGenerator = new ObstacleGenerator(world);
                isDispose = false;
            } else {
                this.dispose();
            }
        }
        if (world != null) {
            world.step(1 / (float)(60 + timelapse), 6, 2);
            player.act();
            obstacleGenerator.act();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        player.render(MyGdxGame.batchDynamic);
        obstacleGenerator.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        batch.begin();
        if (world != null) {
           // dDebugRenderer.render(world, MyGdxGame.camera.combined);
        }
    }

    @Override
    public void dispose() {
        timeBeforeDeath--;
        timelapse += 25;
        if (timeBeforeDeath <= 0) {
            player.dispose();
            obstacleGenerator.dispose();
            world.dispose();
            world = null;
            timeBeforeDeath = 60;
            timelapse = 0;
        }
    }
}
