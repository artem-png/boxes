package com.siminenko.falldown;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.Layout.PauseLayout;
import com.siminenko.falldown.Layout.WinLayout;

public class MyGdxGame extends ApplicationAdapter implements com.siminenko.falldown.AdMob.VideoEventListener {
    public static SpriteBatch batch;
    public static SpriteBatch batchDynamic;
    public static SpriteBatch batchFont;
    public static OrthographicCamera camera;
    public static com.siminenko.falldown.Layout.LayoutManager layoutManager;
    public static int width;
    public static int height;
    public static com.siminenko.falldown.Config.Tex tex;
    public static com.siminenko.falldown.Config.Progress progress;
    public static com.siminenko.falldown.Config.Info info;

    Sprite whitebg;
    static int time;
    static int timeSetting;
    static boolean isUp = false;

    int rateL = 10;

    static int timeLoad = 0;

    public static com.siminenko.falldown.AdMob.AdsController adsController;

    public static com.siminenko.falldown.AdMob.RewardAds rewardAds;

    public MyGdxGame(com.siminenko.falldown.AdMob.AdsController adsController, com.siminenko.falldown.AdMob.RewardAds rewardAds)
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
        layoutManager = new com.siminenko.falldown.Layout.LayoutManager();
        com.siminenko.falldown.Model.Music.Music.init();
        com.siminenko.falldown.Config.Tex.initLoading();
    }

    public void init() {
        tex = new com.siminenko.falldown.Config.Tex();

        progress = new com.siminenko.falldown.Config.Progress();
        camera = new OrthographicCamera(width, height);
        camera.position.x = width / 2;
        camera.position.y = height / 2;
        batch = new SpriteBatch();
        batchDynamic = new SpriteBatch();

        whitebg = new Sprite(new Texture("menu/whitebg.png"));
        progress.init();
        com.siminenko.falldown.Model.Lost.FailedText.init();
        com.siminenko.falldown.Model.Lost.MenuIcon.init();
        com.siminenko.falldown.Layout.MenuLayout.init();
        com.siminenko.falldown.Layout.LostLayout.init();
        com.siminenko.falldown.Model.Lost.RestartText.init();
        com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker.init();
        com.siminenko.falldown.Layout.GameLayout.init();
        com.siminenko.falldown.Model.Win.CompletedText.init();
        com.siminenko.falldown.Model.Win.NextLevelText.init();
        WinLayout.init();
        com.siminenko.falldown.Model.Menu.LevelText.init();
        com.siminenko.falldown.Layout.LevelsLayout.init();
        com.siminenko.falldown.Model.LevelLayout.TopPanel.init();
        com.siminenko.falldown.Model.LevelLayout.BackIcon.init();
        com.siminenko.falldown.Model.LevelLayout.LevelGenerator.init();
        PauseLayout.init();
        com.siminenko.falldown.Model.Game.PauseIcon.init();
        com.siminenko.falldown.Model.Pause.PausedText.init();
        com.siminenko.falldown.Model.Pause.ContinueButton.init();
        com.siminenko.falldown.Layout.RateLayout.init();
        com.siminenko.falldown.Config.Info.init();
        com.siminenko.falldown.Model.Level.Levels.LevelLoop.initStatic();
        com.siminenko.falldown.Model.Menu.DiamondDisplay.init();
        com.siminenko.falldown.Model.Win.PlusDiamondText.init();
        com.siminenko.falldown.Layout.SettingLayout.init();

        com.siminenko.falldown.Config.Info.addRunNumber();

        layoutManager.push(new com.siminenko.falldown.Layout.MenuLayout());
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
            com.siminenko.falldown.Config.Tex.loadingFont.getData().setScale(0.8f, 0.8f);
            com.siminenko.falldown.Config.Tex.loadingFont.draw(batchFont, "LuSiArt", 0, Gdx.graphics.getHeight()/1.3f, Gdx.graphics.getWidth(), 1, true);
            com.siminenko.falldown.Config.Tex.loadingFont.getData().setScale(0.2f, 0.2f);
            com.siminenko.falldown.Config.Tex.loadingFont.draw(batchFont, "gaming", 0, Gdx.graphics.getHeight()/1.55f, Gdx.graphics.getWidth(), 1, true);
            com.siminenko.falldown.Config.Tex.loadingFont.getData().setScale(1, 1);
            com.siminenko.falldown.Config.Tex.loadingFont.getData().setScale(0.4f, 0.4f);
            com.siminenko.falldown.Config.Tex.loadingFont.draw(batchFont, "loading", 0, Gdx.graphics.getHeight()/5f, Gdx.graphics.getWidth(), 1, true);
            com.siminenko.falldown.Config.Tex.loadingFont.getData().setScale(1, 1);
            batchFont.end();
            return;
        } else if (timeLoad == 1) {
            init();
            timeLoad++;
        }

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            if (layoutManager.vector.lastElement() instanceof com.siminenko.falldown.Layout.GameLayout) {
                layoutManager.push(new PauseLayout(com.siminenko.falldown.Layout.GameLayout.level.level));
            }
        }
        com.siminenko.falldown.Model.Music.Music.act();
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

        if (com.siminenko.falldown.Config.Info.needRateLayout()) {
            rateL--;
            if (rateL == 0 && layoutManager.vector.size() == 1) {
                layoutManager.push(new com.siminenko.falldown.Layout.RateLayout());
            }
        }
    }

    @Override
    public void pause() {
        super.pause();
        if (MyGdxGame.layoutManager == null) {
            return;
        }
        if (MyGdxGame.layoutManager.vector.lastElement() instanceof com.siminenko.falldown.Layout.GameLayout) {
            MyGdxGame.layoutManager.push(new PauseLayout(com.siminenko.falldown.Layout.GameLayout.level.level));
        }
    }

    @Override
    public void dispose() {
        layoutManager.dispose();
    }

    @Override
    public void resume() {
        super.resume();
        tex = new com.siminenko.falldown.Config.Tex();
    }

    @Override
    public void onRewardedEvent(String type, int amount) {
        com.siminenko.falldown.Model.Lost.AdText.isViewed = true;
    }

    @Override
    public void onRewardedVideoAdLoadedEvent() {

    }

    @Override
    public void onRewardedVideoAdClosedEvent() {

    }
}
