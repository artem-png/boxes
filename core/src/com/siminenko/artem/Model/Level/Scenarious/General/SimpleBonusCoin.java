package com.siminenko.artem.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.BonusBig;
import com.siminenko.artem.Model.BonusCoin;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.AScenario;
import com.siminenko.artem.Model.Player;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBonusCoin extends AScenario {

    public SimpleBonusCoin(World world, Player player, ALevel level, int delay, Vector2 position, float rotation) {
        this.level = level;
        this.world = world;
        this.player = player;
        BonusCoin bonusBig = new BonusCoin(world, position);
        bonusBig.getBody().setAngularVelocity(rotation);
        this.objects.add(bonusBig);
        this.doDelay = delay;
    }

    public SimpleBonusCoin(World world, Player player, ALevel level, int delay, Vector2 position, Vector2 speed, float rotation) {
        this.level = level;
        this.world = world;
        this.player = player;
        BonusCoin bonusBig = new BonusCoin(world, position, speed);
        bonusBig.getBody().setAngularVelocity(rotation);
        this.objects.add(bonusBig);
        this.doDelay = delay;
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void action() {
        AObject a = this.objects.firstElement();
        this.objects.remove(a);
        a.getBody().setActive(true);
        this.level.aObjectVector2.add(a);
        isDead = true;
    }
}
