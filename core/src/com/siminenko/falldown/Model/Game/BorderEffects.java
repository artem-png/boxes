package com.siminenko.falldown.Model.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class BorderEffects {
    public Sprite freezBG;
    float freezAlpha = 0;

    boolean freesUp = false;
    boolean freesDown = false;

    public void init() {
        freezBG = new Sprite(new Texture("freezBG.png"));
    }

    public void act() {
        if (freesUp) {
            freezAlpha += 0.02;
            com.siminenko.falldown.Layout.GameLayout.speed += 4;
            if (freezAlpha > 1) {
                freezAlpha = 1;
                freesUp = false;
            }
        }

        if (freesDown) {
            freezAlpha -= 0.02;
            com.siminenko.falldown.Layout.GameLayout.speed -= 4;
            if (freezAlpha < 0) {
                freezAlpha = 0;
                freesDown = false;
            }
        }
    }

    public void reset() {
        freesUp = false;
        freezAlpha = 0;
        freesDown = false;
    }

    public void setFreezUp() {
        freesUp = true;
    }

    public void setFreezDown() {
        freesDown = true;
    }

    public void render(SpriteBatch batch) {
        if (com.siminenko.falldown.Layout.GameLayout.speed > com.siminenko.falldown.Layout.GameLayout.speedSetting) {
            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, freezAlpha);
            batch.draw(this.freezBG, -2, 0, MyGdxGame.width + 2, MyGdxGame.height);
            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, 1);
        }
    }

    public void dispose() {
    }
}
