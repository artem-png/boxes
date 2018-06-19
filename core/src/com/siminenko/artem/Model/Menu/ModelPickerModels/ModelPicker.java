package com.siminenko.artem.Model.Menu.ModelPickerModels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Game.Effects;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

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

    Random random = new Random();

    public ModelPicker() {
        size = new Vector2(12, 15);
        position = new Vector2(MyGdxGame.width / 2 - size.x / 2, MyGdxGame.height / 2 - size.y / 2 + 10);
        rotation = 0;
        scenarious = new Scenarious(position, rotation);
        effects = new Effects();
    }

    public static void init() {
        currentModel = new Sprite(new Texture("player.png"));
    }

    public void act() {
        scenarious.act();
        size = scenarious.modifySize(size);
        rotation = scenarious.modifyRotation(rotation);
        position.set(MyGdxGame.width / 2 - size.x / 2, MyGdxGame.height / 2 - size.y / 2 + 5);
        effects.effects.add(Tex.getParticle(0.8f, new Vector2(this.position.x + this.size.x/2, this.position.y + this.size.y/2), 40));
        effects.act();
    }

    public void render(SpriteBatch batch) {
        effects.render(batch);
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
    }

    public void dispose() {
        effects.dispose();
    }
}
