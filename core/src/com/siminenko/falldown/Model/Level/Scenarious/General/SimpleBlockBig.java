package com.siminenko.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Model.Level.ALevel;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockBig extends com.siminenko.falldown.Model.Level.AScenario {

    public SimpleBlockBig(World world, com.siminenko.falldown.Model.Player player, ALevel level, int delay, float rotation) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.objects.add(new com.siminenko.falldown.Model.ObstacleBigPanel(world, getStandartPosition()));
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
