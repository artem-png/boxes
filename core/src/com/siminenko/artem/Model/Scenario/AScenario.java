package com.siminenko.artem.Model.Scenario;

import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.ObstacleBigPanel;
import com.siminenko.artem.Model.ObstacleCircle;
import com.siminenko.artem.Model.ObstaclePanel;
import com.siminenko.artem.Model.ObstacleTriangle;
import com.siminenko.artem.Model.ObstacleVerticalPanel;

import java.util.Vector;

/**
 * Created by artem on 4/19/18.
 */

public abstract class AScenario {
    final int OBSTACLE_PANEL = 1;
    final int OBSTACLE_BIG_PANEL = 2;
    final int OBSTACLE_CIRCLE = 3;
    final int OBSTACLE_PANEL_VERTICAL = 4;
    final int OBSTACLE_TRIANGLE = 5;
    protected boolean isReady = false;
    protected boolean isDispose = false;

    Vector<ObstacleConfiguration> vector = new Vector<ObstacleConfiguration>();

    public void act() {
        if (vector.size() > 0) {
            vector.firstElement().pause--;
            if (vector.firstElement().pause <= 0) {
                this.isReady = true;
            }
        } else {
            this.isDispose = true;
        }
    }

    public AObject getObject() {
        isReady = false;
        int obj = vector.firstElement().aObject;
        AObject object = null;
        if (obj == OBSTACLE_PANEL) {
            object = new ObstaclePanel(vector.firstElement().world, vector.firstElement().position);
        } else if (obj == OBSTACLE_BIG_PANEL) {
            object = new ObstacleBigPanel(vector.firstElement().world, vector.firstElement().position);
        } else if (obj == OBSTACLE_CIRCLE) {
            object = new ObstacleCircle(vector.firstElement().world, vector.firstElement().position, vector.firstElement().velocity, vector.firstElement().size);
        } else if (obj == OBSTACLE_PANEL_VERTICAL) {
            object = new ObstacleVerticalPanel(vector.firstElement().world, vector.firstElement().position);
        } else if (obj == OBSTACLE_TRIANGLE) {
            object = new ObstacleTriangle(vector.firstElement().world, vector.firstElement().position, 1);
        }
        object.setGravityScale(vector.firstElement().gravityScale);
        vector.remove(vector.firstElement());

        return object;
    }

    public boolean isDispose() {
        return isDispose;
    }

    public boolean isReady() {
        return isReady;
    }
}
