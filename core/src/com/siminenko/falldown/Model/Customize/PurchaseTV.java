package com.siminenko.falldown.Model.Customize;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseTV extends APurchaseModel {

    public PurchaseTV() {
        position = new Vector2(-12, 22);
        player = Tex.player3;
        baloon = Tex.baloon3;
        playerSize.set(12, 4.5f);
        baloonSize = new Vector2(12, 14);
        purchased = com.siminenko.falldown.Config.Progress.themes[2 - 1] == 1;
        playerRotation = 45;
        theme = 2;
        price = 100;
        fontPosition.set((position.x + 14), (position.y + 7.5f));
    }
}
