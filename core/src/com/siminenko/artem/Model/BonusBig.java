package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Data.BonusBigData;
import com.siminenko.artem.Model.Data.ObstacleBigPanelData;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */
public class BonusBig extends ABonus {
    float sizeX = 5;
    float sizeY = 5;

    public BonusBig(World world, Vector2 position) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sizeX / 2, sizeY / 2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.9f, 1f, 0);
        this.body.setUserData(new BonusBigData(this));
    }

    @Override
    public void act() {
        super.act();
        if (isBonusGiven) {
            timeExpire--;
            if (timeExpire <= 0) {
                this.setDispose(true);
                body.setActive(false);
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!isDisposed) {
            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, timeExpire / timeExpireSetting);
            batch.draw(
                    Tex.present1,
                    this.body.getPosition().x - sizeX / 2f,
                    this.body.getPosition().y - sizeY / 2f,
                    sizeX / 2,
                    sizeY / 2,
                    sizeX,
                    sizeY,
                    Tex.present1.getScaleX(),
                    Tex.present1.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, 1);
        }
    }

    public void handlePlayer(Player player) {
        isBonusGiven = true;
        player.makeBigger(1.5f, 550);
        int count = 60;
        Random r = new Random();
        for (int i = 1; i <= count; i++) {
            float sizeF = (r.nextInt(10) + 4) / 13f;

            GameLayout.effects.effects.add(new EffectSquare(
                    new Vector2(body.getPosition()),
                    new Vector2(sizeF, sizeF),
                    new Vector2(r.nextFloat() / 3.5f * negativeOrPositive(), r.nextFloat() / 3.5f * negativeOrPositive()),
                    new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), 1),
                    0.4f,
                    r.nextInt(100) / 50f,
                    40
            ));
        }
    }


    public int negativeOrPositive() {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
