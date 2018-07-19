package com.lisuart.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Model.Customize.PurchaseCommon;
import com.lisuart.falldown.Model.Customize.PurchaseTV;
import com.lisuart.falldown.Model.LevelLayout.BackIcon;
import com.lisuart.falldown.Model.LevelLayout.TopPanel;

/**
 * Created by artem on 3/21/18.
 */

public class CustomizeLayout implements LayoutInterface {
    BackIcon backIcon;
    TopPanel topPanel;

    com.lisuart.falldown.Model.Customize.PurchaseFootbal purchaseFootbal;
    PurchaseTV purchaseTV;
    PurchaseCommon purchaseCommon;

    public CustomizeLayout() {
        backIcon = new BackIcon();
        topPanel = new TopPanel();
        com.lisuart.falldown.MyGdxGame.setUp(15, false);

        purchaseFootbal = new com.lisuart.falldown.Model.Customize.PurchaseFootbal();
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
        com.lisuart.falldown.MyGdxGame.batchDynamic.begin();
        topPanel.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        backIcon.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        purchaseFootbal.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        purchaseTV.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        purchaseCommon.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        com.lisuart.falldown.MyGdxGame.batchDynamic.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        com.lisuart.falldown.Config.Tex.smallFont35.draw(com.lisuart.falldown.MyGdxGame.batchFont, "" + Progress.diamonds, -.0f, Gdx.graphics.getHeight() - 8 * com.lisuart.falldown.Config.Tex.y, Gdx.graphics.getWidth(), 1, true);
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
        batch.draw(com.lisuart.falldown.Config.Tex.diamond, com.lisuart.falldown.MyGdxGame.width / 2 - 1.45f, com.lisuart.falldown.MyGdxGame.height - 7.7f, 3, 4);
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
