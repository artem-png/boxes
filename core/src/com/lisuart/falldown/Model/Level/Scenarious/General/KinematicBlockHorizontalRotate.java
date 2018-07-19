package com.lisuart.falldown.Model.Level.Scenarious.General;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Level.ALevel;

/**
 * Created by User on 22.04.2018.
 */

public class KinematicBlockHorizontalRotate extends AScenario {

    public KinematicBlockHorizontalRotate(
            World world,
            com.lisuart.falldown.Model.Player player,
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
        this.objects.add(new com.lisuart.falldown.Model.StaticVerticalPanelRotate(
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
        AObject a = this.objects.firstElement();
        this.objects.remove(a);
        a.getBody().setActive(true);
        this.level.aObjectVector2.add(a);
        isDead = true;
    }
}
