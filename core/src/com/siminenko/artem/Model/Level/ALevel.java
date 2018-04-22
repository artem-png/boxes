package com.siminenko.artem.Model.Level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.Player;

import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public abstract class ALevel {
    public Player player;
    public Vector<AScenario> aScenarioVector2 = new Vector<AScenario>();
    public Vector<AObject> aObjectVector2 = new Vector<AObject>();
    public int level;

    public abstract void init();

    public void act() {
        if (aScenarioVector2.size() > 0) {
            aScenarioVector2.firstElement().act();
            if (aScenarioVector2.firstElement().doDelay <= 0) {
                aScenarioVector2.firstElement().action();
                if (aScenarioVector2.firstElement().isDead) {
                    aScenarioVector2.remove(aScenarioVector2.firstElement());
                }
            }
        }
        for (int i = 0; i < aObjectVector2.size(); i++) {
            aObjectVector2.get(i).act();
        }
        for (int i = aObjectVector2.size() - 1; i >= 0; i--) {
            if (aObjectVector2.get(i).isAway()) {
                aObjectVector2.get(i).dispose();
                aObjectVector2.remove(i);
            }
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void render(SpriteBatch b) {
        if (aScenarioVector2.size() > 0) {
            aScenarioVector2.firstElement().render(b);
        }
        for (int i = 0; i < aObjectVector2.size(); i++) {
            aObjectVector2.get(i).render(b);
        }
    }

    public void dispose() {
        for (int i = 0; i < aScenarioVector2.size(); i ++) {
            aScenarioVector2.get(i).dispose();
        }
        for (int i = 0; i < aObjectVector2.size(); i++) {
            aObjectVector2.get(i).dispose();
        }
    }

    public boolean isComplete() {
        boolean result = this.aScenarioVector2.size() == 0 && this.aObjectVector2.size() == 0;
        if (result) {
            afterWin();
        }
        return result;
    }

    public abstract void afterWin();

    public void setNumber(int level) {
        this.level = level;
    }
}
