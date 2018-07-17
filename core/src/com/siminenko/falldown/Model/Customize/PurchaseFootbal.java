package com.siminenko.falldown.Model.Customize;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseFootbal extends APurchaseModel {

    public PurchaseFootbal() {
        position = new Vector2(-12, 38);
        player = com.siminenko.falldown.Config.Tex.player2;
        baloon = com.siminenko.falldown.Config.Tex.baloon2;
        playerSize = new Vector2(11, 11);
        baloonSize = new Vector2(8f, 14);
        purchased = com.siminenko.falldown.Config.Progress.themes[0] == 1;
        theme = 1;
        price = 60;
        fontPosition.set((position.x + 10), (position.y + 9.7f));
    }
}
