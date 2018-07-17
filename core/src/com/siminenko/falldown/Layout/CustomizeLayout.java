package com.siminenko.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Model.Customize.PurchaseFootbal;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class CustomizeLayout implements LayoutInterface {
    com.siminenko.falldown.Model.LevelLayout.BackIcon backIcon;
    com.siminenko.falldown.Model.LevelLayout.TopPanel topPanel;

    PurchaseFootbal purchaseFootbal;
    com.siminenko.falldown.Model.Customize.PurchaseTV purchaseTV;
    com.siminenko.falldown.Model.Customize.PurchaseCommon purchaseCommon;

    public CustomizeLayout() {
        backIcon = new com.siminenko.falldown.Model.LevelLayout.BackIcon();
        topPanel = new com.siminenko.falldown.Model.LevelLayout.TopPanel();
        MyGdxGame.setUp(15, false);

        purchaseFootbal = new PurchaseFootbal();
        purchaseTV = new com.siminenko.falldown.Model.Customize.PurchaseTV();
        purchaseCommon = new com.siminenko.falldown.Model.Customize.PurchaseCommon();
        MyGdxGame.adsController.showBannerAd();
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
        Tex.smallFont35.draw(MyGdxGame.batchFont, "" + com.siminenko.falldown.Config.Progress.diamonds, -.0f, Gdx.graphics.getHeight() - 8 * Tex.y, Gdx.graphics.getWidth(), 1, true);
        MyGdxGame.batchFont.end();
        batch.begin();
        batch.draw(Tex.diamond, MyGdxGame.width / 2 - 1.45f, MyGdxGame.height - 7.7f, 3, 4);
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
