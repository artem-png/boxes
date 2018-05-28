package com.siminenko.artem.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.AScenario;
import com.siminenko.artem.Model.ObstacleTriangle;
import com.siminenko.artem.Model.ObstacleVerticalPanel;
import com.siminenko.artem.Model.Player;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockTriangle extends AScenario {

    public SimpleBlockTriangle(World world, Player player, ALevel level, int delay, float rotation, float initRotation, Vector2 position, Vector2 speed, float mass) {
        this.level = level;
        this.world = world;
        this.player = player;
        ObstacleTriangle o = new ObstacleTriangle(world, position, 1, speed, initRotation, rotation, mass);
        o.setAngularVelocity(rotation);
        o.setVelocity(speed);
        this.objects.add(o);
        this.doDelay = delay;
    }

    public SimpleBlockTriangle(World world, Player player, ALevel level, int delay, float rotation, float initRotation, Vector2 position, Vector2 speed, float mass, int size) {
        this.level = level;
        this.world = world;
        this.player = player;
        ObstacleTriangle o = new ObstacleTriangle(world, position, size, speed, initRotation, rotation, mass);
        o.setAngularVelocity(rotation);
        o.setVelocity(speed);
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
