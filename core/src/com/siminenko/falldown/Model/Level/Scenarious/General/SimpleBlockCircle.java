package com.siminenko.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Model.Level.ALevel;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockCircle extends com.siminenko.falldown.Model.Level.AScenario {

    public SimpleBlockCircle(World world, com.siminenko.falldown.Model.Player player, ALevel level, int delay, int size, Vector2 speed, Vector2 position) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.objects.add(new com.siminenko.falldown.Model.ObstacleCircle(world, position, speed, size));
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
