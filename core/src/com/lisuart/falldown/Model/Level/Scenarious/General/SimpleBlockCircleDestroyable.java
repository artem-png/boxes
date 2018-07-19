package com.lisuart.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Player;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.ObstacleCircle;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockCircleDestroyable extends AScenario {

    public SimpleBlockCircleDestroyable(World world, Player player, ALevel level, int delay, int size, Vector2 speed, Vector2 position, int iterations) {
        this.level = level;
        this.world = world;
        this.player = player;
        ObstacleCircle obstacleCircle = new ObstacleCircle(world, position, speed, size);
        obstacleCircle.iterations = iterations;
        this.objects.add(obstacleCircle);
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
