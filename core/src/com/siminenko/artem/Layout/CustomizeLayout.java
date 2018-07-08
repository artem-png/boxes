package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Customize.PurchaseCommon;
import com.siminenko.artem.Model.Customize.PurchaseFootbal;
import com.siminenko.artem.Model.Customize.PurchaseTV;
import com.siminenko.artem.Model.LevelLayout.BackIcon;
import com.siminenko.artem.Model.LevelLayout.LevelGenerator;
import com.siminenko.artem.Model.LevelLayout.TopPanel;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class CustomizeLayout implements LayoutInterface {
    BackIcon backIcon;
    TopPanel topPanel;

    PurchaseFootbal purchaseFootbal;
    PurchaseTV purchaseTV;
    PurchaseCommon purchaseCommon;

    public CustomizeLayout() {
        backIcon = new BackIcon();
        topPanel = new TopPanel();
        MyGdxGame.setUp(15, false);

        purchaseFootbal = new PurchaseFootbal();
        purchaseTV = new PurchaseTV();
        purchaseCommon = new PurchaseCommon();
    }

    public void setLevel(int level) {

    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        backIcon.act();
        topPanel.act();
        purchaseFootbal.act();
        purchaseTV.act();
        purchaseCommon.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        topPanel.render(MyGdxGame.batchDynamic);
        backIcon.render(MyGdxGame.batchDynamic);
        purchaseFootbal.render(MyGdxGame.batchDynamic);
        purchaseTV.render(MyGdxGame.batchDynamic);
        purchaseCommon.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        MyGdxGame.batchFont.begin();
        Tex.smallFont35.draw(MyGdxGame.batchFont, "" + Progress.diamonds, -17, Gdx.graphics.getHeight() - 18 * Tex.y, Gdx.graphics.getWidth(), 1, true);
        MyGdxGame.batchFont.end();
        batch.begin();
        batch.draw(Tex.diamond, MyGdxGame.width / 2 + 1f, MyGdxGame.height - 6, 3, 4);
    }

    @Override
    public void dispose() {
        backIcon.dispose();
        topPanel.dispose();
        purchaseFootbal.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
