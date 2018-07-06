package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseCommon extends APurchaseModel {

    public PurchaseCommon() {
        position = new Vector2(-4, 54);
        player = Tex.player1;
        baloon = Tex.baloon1;
        purchased = true;
        playerSize = new Vector2(9, 10);
        baloonSize = new Vector2(13f, 13);
        theme = 0;
    }
}
