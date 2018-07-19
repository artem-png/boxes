package com.lisuart.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Player;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.ObstacleVerticalPanel;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBlockVertical extends AScenario {

    public SimpleBlockVertical(World world, Player player, ALevel level, int delay, float rotation, Vector2 position, Vector2 speed) {
        this.level = level;
        this.world = world;
        this.player = player;
        ObstacleVerticalPanel o = new ObstacleVerticalPanel(world, position, 0, 0, 0.8f);
        o.setAngularVelocity(rotation);
        o.setVelocity(speed);
        this.objects.add(o);
        this.doDelay = delay;
    }

    public SimpleBlockVertical(World world, Player player, ALevel level, int delay, float rotation, Vector2 position, Vector2 speed, int x, int y, float mass) {
        this.level = level;
        this.world = world;
        this.player = player;
        ObstacleVerticalPanel o = new ObstacleVerticalPanel(world, position, x, y, mass);
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
