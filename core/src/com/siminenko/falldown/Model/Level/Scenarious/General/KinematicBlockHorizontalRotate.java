package com.siminenko.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.Model.Player;
import com.siminenko.falldown.Model.StaticVerticalPanelRotate;

/**
 * Created by User on 22.04.2018.
 */

public class KinematicBlockHorizontalRotate extends com.siminenko.falldown.Model.Level.AScenario {

    public KinematicBlockHorizontalRotate(
            World world,
            Player player,
            ALevel level,
            int delay,
            Vector2 position,
            Vector2 speed,
            float initRotation,
            float finishRotation,
            float rotationSpeed,
            int pause,
            int sizeX,
            int sizeY,
            float restitution
    ) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.objects.add(new StaticVerticalPanelRotate(
                world,
                position,
                speed,
                initRotation,
                finishRotation,
                rotationSpeed,
                pause,
                sizeX,
                sizeY,
                restitution
        ));
        this.doDelay = delay;

        this.isKinematic = true;
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
