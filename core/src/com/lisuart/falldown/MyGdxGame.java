package com.lisuart.falldown;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.AdMob.AdsController;
import com.lisuart.falldown.AdMob.RewardAds;
import com.lisuart.falldown.AdMob.VideoEventListener;
import com.lisuart.falldown.Config.Info;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Config.Tex;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Layout.LayoutManager;
import com.lisuart.falldown.Layout.LevelsLayout;
import com.lisuart.falldown.Layout.LostLayout;
import com.lisuart.falldown.Layout.MenuLayout;
import com.lisuart.falldown.Layout.RateLayout;
import com.lisuart.falldown.Layout.SettingLayout;
import com.lisuart.falldown.Model.Game.PauseIcon;
import com.lisuart.falldown.Model.Level.Levels.LevelLoop;
import com.lisuart.falldown.Model.LevelLayout.BackIcon;
import com.lisuart.falldown.Model.LevelLayout.LevelGenerator;
import com.lisuart.falldown.Model.LevelLayout.TopPanel;
import com.lisuart.falldown.Model.Lost.AdText;
import com.lisuart.falldown.Model.Lost.FailedText;
import com.lisuart.falldown.Model.Lost.MenuIcon;
import com.lisuart.falldown.Model.Lost.RestartText;
import com.lisuart.falldown.Model.Menu.DiamondDisplay;
import com.lisuart.falldown.Model.Menu.LevelText;
import com.lisuart.falldown.Model.Menu.ModelPickerModels.ModelPicker;
import com.lisuart.falldown.Model.Music.Music;
import com.lisuart.falldown.Model.Pause.ContinueButton;
import com.lisuart.falldown.Model.Pause.PausedText;
import com.lisuart.falldown.Model.Win.CompletedText;
import com.lisuart.falldown.Model.Win.NextLevelText;
import com.lisuart.falldown.Model.Win.PlusDiamondText;
import com.lisuart.falldown.Layout.PauseLayout;
import com.lisuart.falldown.Layout.WinLayout;

public class MyGdxGame extends ApplicationAdapter implements VideoEventListener {
    public static SpriteBatch batch;
    public static SpriteBatch batchDynamic;
    public static SpriteBatch batchFont;
    public static OrthographicCamera camera;
    public static LayoutManager layoutManager;
    public static int width;
    public static int height;
    public static Tex tex;
    public static Progress progress;
    public static Info info;

    Sprite whitebg;
    static int time;
    static int timeSetting;
    static boolean isUp = false;

    int rateL = 10;

    static int timeLoad = 0;

    public static AdsController adsController;

    public static RewardAds rewardAds;

    public MyGdxGame(AdsController adsController, RewardAds rewardAds)
    {
        this.adsController = adsController;
        this.rewardAds = rewardAds;
        this.rewardAds.setVideoEventListener(this);
    }

    @Override
    public void create() {
        width = 45;
        height = 80;
        batch = new SpriteBatch();
        batchFont = new SpriteBatch();
        layoutManager = new LayoutManager();
        Music.init();
        Tex.initLoading();
    }

    public void init() {
        tex = new Tex();

        progress = new Progress();
        camera = new OrthographicCamera(width, height);
        camera.position.x = width / 2;
        camera.position.y = height / 2;
        batch = new SpriteBatch();
        batchDynamic = new SpriteBatch();

        whitebg = new Sprite(new Texture("menu/whitebg.png"));
        progress.init();
        FailedText.init();
        MenuIcon.init();
        MenuLayout.init();
        LostLayout.init();
        RestartText.init();
        ModelPicker.init();
        GameLayout.init();
        CompletedText.init();
        NextLevelText.init();
        WinLayout.init();
        LevelText.init();
        LevelsLayout.init();
        TopPanel.init();
        BackIcon.init();
        LevelGenerator.init();
        PauseLayout.init();
        PauseIcon.init();
        PausedText.init();
        ContinueButton.init();
        RateLayout.init();
        Info.init();
        LevelLoop.initStatic();
        DiamondDisplay.init();
        PlusDiamondText.init();
        SettingLayout.init();

        Info.addRunNumber();

        layoutManager.push(new MenuLayout());
        Gdx.input.setCatchBackKey(true);
    }

    public static void setUp(int time, boolean isUp) {
        MyGdxGame.isUp = isUp;
        MyGdxGame.time = time;
        MyGdxGame.timeSetting = time;
    }

    @Override
    public void render() {
        if (timeLoad == 0) {
            Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            timeLoad++;
            batchFont.begin();
            Tex.loadingFont.getData().setScale(0.8f, 0.8f);
            Tex.loadingFont.draw(batchFont, "LuSiArt", 0, Gdx.graphics.getHeight()/1.3f, Gdx.graphics.getWidth(), 1, true);
            Tex.loadingFont.getData().setScale(0.2f, 0.2f);
            Tex.loadingFont.draw(batchFont, "gaming", 0, Gdx.graphics.getHeight()/1.55f, Gdx.graphics.getWidth(), 1, true);
            Tex.loadingFont.getData().setScale(1, 1);
            Tex.loadingFont.getData().setScale(0.4f, 0.4f);
            Tex.loadingFont.draw(batchFont, "loading", 0, Gdx.graphics.getHeight()/5f, Gdx.graphics.getWidth(), 1, true);
            Tex.loadingFont.getData().setScale(1, 1);
            batchFont.end();
            return;
        } else if (timeLoad == 1) {
            init();
            timeLoad++;
        }

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            if (layoutManager.vector.lastElement() instanceof GameLayout) {
                layoutManager.push(new PauseLayout(GameLayout.level.level));
            }
        }
        Music.act();
        camera.update();
        time--;

        batch.setProjectionMatrix(camera.combined);
        batchDynamic.setProjectionMatrix(camera.combined);
        batch.begin();
        layoutManager.render(batch);
        batch.end();
        layoutManager.act(Gdx.graphics.getDeltaTime());
        batchDynamic.begin();
        if (time > 0) {
            if (isUp) {
                batchDynamic.setColor(1, 1, 1, 1f - (float) time / (float) timeSetting);
            } else {
                batchDynamic.setColor(1, 1, 1, (float) time / (float) timeSetting);
            }
            batchDynamic.draw(whitebg, -5, -5, width + 10, height + 10);
        }
        batchDynamic.end();
        batchDynamic.setColor(batchDynamic.getColor().r, batchDynamic.getColor().g, batchDynamic.getColor().b, 1);

        if (Info.needRateLayout()) {
            rateL--;
            if (rateL == 0 && layoutManager.vector.size() == 1) {
                layoutManager.push(new RateLayout());
            }
        }
    }

    @Override
    public void pause() {
        super.pause();
        if (MyGdxGame.layoutManager == null) {
            return;
        }
        if (MyGdxGame.layoutManager.vector.lastElement() instanceof GameLayout) {
            MyGdxGame.layoutManager.push(new PauseLayout(GameLayout.level.level));
        }
    }

    @Override
    public void dispose() {
        layoutManager.dispose();
    }

    @Override
    public void resume() {
        super.resume();
        tex = new Tex();
    }

    @Override
    public void onRewardedEvent(String type, int amount) {
        AdText.isViewed = true;
    }

    @Override
    public void onRewardedVideoAdLoadedEvent() {

    }

    @Override
    public void onRewardedVideoAdClosedEvent() {

    }
}
