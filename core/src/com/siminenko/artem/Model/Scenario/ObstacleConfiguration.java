package com.siminenko.artem.Model.Scenario;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.ModelGenerator.ObstacleGenerator;

import java.util.Vector;

/**
 * Created by artem on 4/19/18.
 */

public class ObstacleConfiguration {
    public Vector2 position;
    public int aObject;
    public World world;
    public int pause;
    public float size;
    public Vector2 velocity;
    public float gravityScale = 0.9f;

    public ObstacleConfiguration(Vector2 pposition, int aaObject, World wworld, int pause) {
        this.position = pposition;
        this.aObject = aaObject;
        this.world = wworld;
        this.pause = pause;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
