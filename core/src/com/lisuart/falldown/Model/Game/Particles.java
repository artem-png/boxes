package com.lisuart.falldown.Model.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Model.Particle;

import java.util.Random;
import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public class Particles {
    Vector<Particle> particleCircle = new Vector<Particle>();
    Vector<Particle> particleTriangle = new Vector<Particle>();
    Vector<Particle> particleSquare = new Vector<Particle>();
    int timeoutSetting = 1;
    int timeout = timeoutSetting;

    int maxParticles = 15;


    public void act() {
        timeout--;
        if (timeout < 0) {
            timeout = timeoutSetting;
            if (particleCircle.size() + particleTriangle.size() + particleSquare.size() < maxParticles) {
                Random random = new Random();
                int result = random.nextInt(3);
                if (result == 0) {
                    particleSquare.add(new Particle(com.lisuart.falldown.Config.Tex.rectangle1));
                }
                if (result == 1) {
                    particleCircle.add(new Particle(com.lisuart.falldown.Config.Tex.circle1));
                }
                if (result == 2) {
                    particleTriangle.add(new Particle(com.lisuart.falldown.Config.Tex.triangle1));
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = particleCircle.size() - 1; i >= 0; i--) {
            particleCircle.get(i).act();
            if (particleCircle.get(i).isDead()) {
                particleCircle.remove(i);
            } else {
                particleCircle.get(i).render(batch);
            }
        }

        for (int i = particleSquare.size() - 1; i >= 0; i--) {
            particleSquare.get(i).act();
            if (particleSquare.get(i).isDead()) {
                particleSquare.remove(i);
            } else {
                particleSquare.get(i).render(batch);
            }
        }

        for (int i = particleTriangle.size() - 1; i >= 0; i--) {
            particleTriangle.get(i).act();
            if (particleTriangle.get(i).isDead()) {
                particleTriangle.remove(i);
            } else {
                particleTriangle.get(i).render(batch);
            }
        }
    }
}
