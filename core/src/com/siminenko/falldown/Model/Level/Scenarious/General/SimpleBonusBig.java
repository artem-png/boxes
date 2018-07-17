package com.siminenko.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBonusBig extends com.siminenko.falldown.Model.Level.AScenario {

    public SimpleBonusBig(World world, com.siminenko.falldown.Model.Player player, com.siminenko.falldown.Model.Level.ALevel level, int delay, Vector2 position, float rotation) {
        this.level = level;
        this.world = world;
        this.player = player;
        com.siminenko.falldown.Model.BonusBig bonusBig = new com.siminenko.falldown.Model.BonusBig(world, position);
        bonusBig.getBody().setAngularVelocity(rotation);
        this.objects.add(bonusBig);
        this.doDelay = delay;
    }

    public SimpleBonusBig(World world, com.siminenko.falldown.Model.Player player, com.siminenko.falldown.Model.Level.ALevel level, int delay, Vector2 position, float rotation, int time) {
        this.level = level;
        this.world = world;
        this.player = player;
        com.siminenko.falldown.Model.BonusBig bonusBig = new com.siminenko.falldown.Model.BonusBig(world, position, time);
        bonusBig.getBody().setAngularVelocity(rotation);
        this.objects.add(bonusBig);
        this.doDelay = delay;
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void action() {
        com.siminenko.falldown.Model.AObject a = this.objects.firstElement();
        this.objects.remove(a);
        a.getBody().setActive(true);
        this.level.aObjectVector2.add(a);
        isDead = true;
    }
}
