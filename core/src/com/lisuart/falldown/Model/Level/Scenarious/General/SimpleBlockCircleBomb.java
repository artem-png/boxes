package com.lisuart.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.ObstacleCircleBomb;
import com.lisuart.falldown.Model.Player;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockCircleBomb extends AScenario {

    public SimpleBlockCircleBomb(World world, Player player, ALevel level, int delay, int size, Vector2 speed, Vector2 position, float mass, int triangles, int expTime) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.gravityScale = 0.7f;
        ObstacleCircleBomb o = new ObstacleCircleBomb(world, position, speed, size, mass, triangles, expTime);
        o.setGravityScale(this.gravityScale);
        o.setLevel(level);
        this.objects.add(o);
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
