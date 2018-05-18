package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/19/18.
 */

public abstract class ABonus extends AObject {
    public boolean isBonusGiven = false;
    public float timeExpireSetting = 30f;
    public float timeExpire = timeExpireSetting;

    public abstract void handlePlayer(Player player);

}
