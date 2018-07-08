package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseCommon extends APurchaseModel {

    public PurchaseCommon() {
        position = new Vector2(-12, 54);
        player = Tex.player1;
        baloon = Tex.baloon1;
        purchased = true;
        playerSize = new Vector2(10, 11);
        baloonSize = new Vector2(14, 14);
        theme = 0;
        fontPosition.set(position.x + 12, position.y + 7);
    }
}
