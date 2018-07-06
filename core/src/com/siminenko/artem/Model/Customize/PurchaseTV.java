package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseTV extends APurchaseModel {

    public PurchaseTV() {
        position = new Vector2(-4, 20);
        player = Tex.player3;
        baloon = Tex.baloon3;
        playerSize.set(11, 4);
        baloonSize = new Vector2(11, 13);
        purchased = Progress.themes[2 - 1] == 1;
        playerRotation = 45;
        theme = 2;
        price = 150;
    }
}
