package com.lisuart.falldown.Model.Menu.ModelPickerModels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Model.Game.Effects;

/**
 * Created by User on 21.04.2018.
 */

public class ModelPicker {
    static Sprite currentModel;
    Vector2 position;
    Vector2 size;
    float rotation;
    Scenarious scenarious;
    Effects effects;

    public ModelPicker() {
        size = new Vector2(12, 15);
        position = new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - size.x / 2, com.lisuart.falldown.MyGdxGame.height / 2 - size.y / 2 + 3);
        rotation = 0;
        scenarious = new Scenarious(position, rotation);
        effects = new Effects();
        if (Progress.theme == 0) {
            currentModel = com.lisuart.falldown.Config.Tex.player1;
            size = new Vector2(12, 15);
        } else if (Progress.theme == 1) {
            currentModel = com.lisuart.falldown.Config.Tex.player2;
            size = new Vector2(14, 14);
        } else if (Progress.theme == 2) {
            currentModel = com.lisuart.falldown.Config.Tex.player3;
            size = new Vector2(20, 7);
        }  else if (Progress.theme == 3) {
            currentModel = com.lisuart.falldown.Config.Tex.player4;
            size = new Vector2(13, 13);
        }
    }

    public static void init() {

    }

    public void act() {
        scenarious.act();
        rotation = scenarious.modifyRotation(rotation);
        position.set(com.lisuart.falldown.MyGdxGame.width / 2 - size.x / 2, com.lisuart.falldown.MyGdxGame.height / 2 - size.y / 2 + 3);
        effects.effects.add(com.lisuart.falldown.Config.Tex.getParticle(0.8f, new Vector2(this.position.x + this.size.x / 2, this.position.y + this.size.y / 2), 40));
        effects.act();

        size = scenarious.modifySize(size);
    }

    public void render(SpriteBatch batch) {
        effects.render(batch);
        if (Progress.theme == 0) {
            batch.draw(
                    currentModel,
                    position.x,
                    position.y,
                    size.x / 2,
                    size.y / 2 - 1,
                    size.x,
                    size.y,
                    currentModel.getScaleX(),
                    currentModel.getScaleY(),
                    rotation
            );
        } else if (Progress.theme == 1) {
            batch.draw(
                    currentModel,
                    position.x,
                    position.y,
                    size.x / 2,
                    size.y / 2,
                    size.x,
                    size.y,
                    currentModel.getScaleX(),
                    currentModel.getScaleY(),
                    rotation
            );
        } else if (Progress.theme == 2) {
            batch.draw(
                    currentModel,
                    position.x,
                    position.y,
                    size.x / 2,
                    size.y / 2,
                    size.x,
                    size.y,
                    currentModel.getScaleX(),
                    currentModel.getScaleY(),
                    rotation
            );
        } else if (Progress.theme == 3) {
            batch.draw(
                    currentModel,
                    position.x,
                    position.y,
                    size.x / 2,
                    size.y / 2,
                    size.x,
                    size.y,
                    currentModel.getScaleX(),
                    currentModel.getScaleY(),
                    rotation
            );
        }
    }

    public void dispose() {
        effects.dispose();
    }
}
