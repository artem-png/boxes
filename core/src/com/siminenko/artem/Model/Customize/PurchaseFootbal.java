package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseFootbal extends APurchaseModel {

    public PurchaseFootbal() {
        position = new Vector2(-4, 37);
        player = Tex.player2;
        baloon = Tex.baloon2;
        playerSize = new Vector2(10, 10);
        baloonSize = new Vector2(7.5f, 13);
        purchased = Progress.themes[0] == 1;
        theme = 1;
        price = 100;
    }
}
