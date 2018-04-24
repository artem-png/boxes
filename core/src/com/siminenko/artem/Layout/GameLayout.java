package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Listeners.BallonListener;
import com.siminenko.artem.Model.Game.PauseIcon;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Player;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.MyGdxGame;

import box2dLight.RayHandler;

/**
 * Created by artem on 3/21/18.
 */

public class GameLayout implements LayoutInterface {
    public static World world;
    public static RayHandler rayHandler;
    public static Box2DDebugRenderer dDebugRenderer;
    Player player;
    Background background;
    Sprite whitebg;
    PauseIcon pauseIcon;
    int timeBeforeDeath = 60;
    int timelapse = 0;

    int timeSetting = 15;
    int timePressed = timeSetting;

    int timeSettingEnd = 60;
    int timePressedEnd = timeSettingEnd;

    public static boolean isDispose = false;

    public static boolean isWin = false;

    ALevel level;

    public GameLayout(ALevel level) {
        player = new Player(world, new Vector2(MyGdxGame.width / 2, 30));
        background = new Background();
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
        this.level = level;
        this.level.setPlayer(player);
        this.level.init();
        pauseIcon = new PauseIcon(level.level);
    }

    public static void init() {
        world = new World(new Vector2(0, -20f), true);
        world.setContactListener(new BallonListener());
        rayHandler = new RayHandler(world);
        dDebugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void act(float delta) {
        background.act();
        if (GameLayout.isDispose && death()) {
            GameLayout.isDispose = false;
            MyGdxGame.layoutManager.set(new LostLayout(level.level));
            return;
        }
        world.step(1 / (float) (60 + timelapse), 6, 2);
        if (!pauseIcon.isPressed) {
            player.act();
        } else {
            player.stop();
        }
        level.act();
        pauseIcon.act();
        if (timeSetting >= 0) {
            timeSetting--;
        }
        if (level.isComplete()) {
            isWin = true;
            if (win()) {
                isWin = false;
                MyGdxGame.layoutManager.set(new WinLayout(level.level + 1));
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        player.render(MyGdxGame.batchDynamic);
        level.render(MyGdxGame.batchDynamic);
        pauseIcon.render(MyGdxGame.batchDynamic);
        if (timeSetting > 0) {
            Color c = MyGdxGame.batchDynamic.getColor();
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, (float) timeSetting / (float) timePressed);
            MyGdxGame.batchDynamic.draw(this.whitebg, - 10, 0, MyGdxGame.width + 20, MyGdxGame.height);
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1);
        }
        if (isWin || isDispose) {
            Color c = batch.getColor();
            float alpha = 1f - (float) timeSettingEnd / (float) timePressedEnd;
            if (alpha >= 0.9f) {
                alpha = 1f;
            }
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, alpha);
            MyGdxGame.batchDynamic.draw(this.whitebg, -10, -10, MyGdxGame.width + 20, MyGdxGame.height + 20);
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1);
        }
        MyGdxGame.batchDynamic.end();
        batch.begin();
        //dDebugRenderer.render(world, MyGdxGame.camera.combined);
    }

    public boolean win() {
        timeSettingEnd --;
        if (timeSettingEnd <= 0) {
            return true;
        }

        return false;
    }

    public boolean death() {
        timeBeforeDeath--;
        timelapse += 25;
        timeSettingEnd --;
        if (timeSettingEnd <= 0) {
            return true;
        }

        return false;
    }

    @Override
    public void dispose() {
        player.dispose();
        level.dispose();
    }
}
