package com.siminenko.falldown.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Model.Data.BonusBigData;
import com.siminenko.falldown.Model.Music.Music;

/**
 * Created by artem on 4/19/18.
 */
public class BonusBig extends ABonus {
    float sizeX = 5;
    float sizeY = 5;

    int time = 550;

    public BonusBig(World world, Vector2 position) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sizeX / 2, sizeY / 2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.9f, 1f, 0);
        this.body.setUserData(new BonusBigData(this));
    }

    public BonusBig(World world, Vector2 position, int time) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sizeX / 2, sizeY / 2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.9f, 1f, 0);
        this.body.setUserData(new BonusBigData(this));
        this.time = time;
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

    public void handlePlayer(com.siminenko.falldown.Model.Player player) {
        if(!isBonusGiven) {
            Music.big();
        }

        isBonusGiven = true;
        player.makeBigger(1.5f, time);
        int count = 60;
    }

}
