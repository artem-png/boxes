package com.lisuart.falldown.Model.Customize;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseMinecraft extends APurchaseModel {

    public PurchaseMinecraft() {
        position = new Vector2(-12, 6);
        player = Tex.player4;
        baloon = Tex.baloon4;
        playerSize.set(9, 9f);
        baloonSize = new Vector2(9, 15);
        purchased = Progress.themes[3 - 1] == 1;
        playerRotation = 0;
        theme = 3;
        price = 120;
        fontPosition.set((position.x + 10), (position.y + 9.2f));
    }
}
