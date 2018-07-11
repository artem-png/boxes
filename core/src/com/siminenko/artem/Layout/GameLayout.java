package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Listeners.DestroyableListener;
import com.siminenko.artem.Model.Game.BorderEffects;
import com.siminenko.artem.Model.Game.Effects;
import com.siminenko.artem.Model.Game.PauseIcon;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Menu.DiamondDisplay;
import com.siminenko.artem.Model.Menu.PlayButton.SettingButton;
import com.siminenko.artem.Model.Music.Music;
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
    public static Effects effects;
    public static BorderEffects borderEffects;
    public static DiamondDisplay diamondDisplay;
    Player player;
    Background background;
    PauseIcon pauseIcon;
    int timeBeforeDeath = 60;
    int timelapse = 0;

    int timeSetting = 15;

    int timeSettingEnd = 60;

    public static boolean isDispose = false;

    public static boolean isDisposeAnimation = false;

    public static boolean isWin = false;

    public static ALevel level;

    public static int speedSetting = 60;
    public static int speed = speedSetting;

    public boolean isInfinite = false;

    public GameLayout(ALevel level) {
        world = new World(new Vector2(0, -10f), true);
        world.setContactListener(new DestroyableListener());
        rayHandler = new RayHandler(world);
        player = new Player(world, new Vector2(MyGdxGame.width / 2, 30), level);
        background = new Background();
        diamondDisplay = new DiamondDisplay();
        if (this.level != null) {
            level.dispose();
        }
        this.level = level;
        this.level.setPlayer(player);
        this.level.init();
        this.level.afterInit();
        GameLayout.isDisposeAnimation = false;
        pauseIcon = new PauseIcon(level.level);
        MyGdxGame.setUp(15, false);
        Music.stopMusic();
        Music.musicGame();
    }

    public static void init() {
        dDebugRenderer = new Box2DDebugRenderer();
        effects = new Effects();
        borderEffects = new BorderEffects();
        borderEffects.init();
    }

    @Override
    public void act(float delta) {
        background.act();
        effects.act();
        diamondDisplay.act();
        if (GameLayout.isDispose) {
            if (!isDisposeAnimation) {
                MyGdxGame.setUp(60, true);
            }
            isDisposeAnimation = true;
            if (death()) {
                GameLayout.isDisposeAnimation = false;
                GameLayout.isDispose = false;
                GameLayout.isWin = false;
                timeBeforeDeath = 60;
                timelapse = 0;
                timeSetting = 15;
                timeSettingEnd = 60;
                speed = speedSetting;
                player.dispose();
                player = new Player(world, new Vector2(MyGdxGame.width / 2, 30), level);
                player.setInActive(120);
                this.level.setPlayer(player);
                borderEffects.reset();
                timelapse = 0;
                MyGdxGame.layoutManager.push(new LostLayout(level.level));
                return;
            }
        }
        world.step(1 / (float) (speed + timelapse), 60, 60);
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
            if (!isWin) {
                MyGdxGame.setUp(60, true);
            }
            isWin = true;
            if (win()) {
                isWin = false;
                speed = speedSetting;
                borderEffects.reset();
                Music.win();

                MyGdxGame.layoutManager.set(new WinLayout(level.level + 1, level.newVictory));
            }
        }
        borderEffects.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        level.renderBG(MyGdxGame.batchDynamic);
        effects.render(MyGdxGame.batchDynamic);
        player.render(MyGdxGame.batchDynamic);
        level.render(MyGdxGame.batchDynamic);
        diamondDisplay.render(MyGdxGame.batchDynamic);
        pauseIcon.render(MyGdxGame.batchDynamic);
        borderEffects.render(MyGdxGame.batchDynamic);
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
        effects.dispose();
        borderEffects.dispose();
        background.dispose();
        pauseIcon.dispose();
        world.dispose();
        rayHandler.dispose();
        GameLayout.isWin = false;
        GameLayout.isDispose = false;
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
