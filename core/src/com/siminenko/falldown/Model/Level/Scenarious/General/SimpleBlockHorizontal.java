package com.siminenko.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.Model.ObstaclePanel;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockHorizontal extends com.siminenko.falldown.Model.Level.AScenario {

    public SimpleBlockHorizontal(World world, com.siminenko.falldown.Model.Player player, ALevel level, int delay, float rotation, Vector2 position, Vector2 speed, int x, int y) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.objects.add(new ObstaclePanel(world, position, speed, rotation, x, y));
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
