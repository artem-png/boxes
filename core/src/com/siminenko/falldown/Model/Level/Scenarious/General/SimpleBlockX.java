package com.siminenko.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.Model.ObstacleX;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockX extends com.siminenko.falldown.Model.Level.AScenario {

    public SimpleBlockX(World world, com.siminenko.falldown.Model.Player player, ALevel level, Vector2 position, Vector2 speed, int delay, float initRotation, float rotation, float mass, int type, float size) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.objects.add(new ObstacleX(world, position, speed, initRotation, rotation, mass, type, size));
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
