package com.lisuart.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.BonusBig;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Player;

/**
 * Created by User on 22.04.2018.
 */

public class SimpleBonusBig extends AScenario {

    public SimpleBonusBig(World world, Player player, ALevel level, int delay, Vector2 position, float rotation) {
        this.level = level;
        this.world = world;
        this.player = player;
        BonusBig bonusBig = new BonusBig(world, position);
        bonusBig.getBody().setAngularVelocity(rotation);
        this.objects.add(bonusBig);
        this.doDelay = delay;
    }

    public SimpleBonusBig(World world, Player player, ALevel level, int delay, Vector2 position, float rotation, int time) {
        this.level = level;
        this.world = world;
        this.player = player;
        BonusBig bonusBig = new BonusBig(world, position, time);
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
