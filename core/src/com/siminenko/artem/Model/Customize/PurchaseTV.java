package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class PurchaseTV extends APurchaseModel {

    public PurchaseTV() {
        position = new Vector2(-4, 37);
        System.out.println(123);
        bg = new Sprite(new Texture("bg/" + "lightpink" + "-" + "lightgreen" + ".png"));
        player = Tex.player3;
        baloon = Tex.baloon3;
        playerSize.set(13, 5);
        baloonSize = new Vector2(11, 12);

        playerRotation = 45;
    }

    public void act() {

    }
}
