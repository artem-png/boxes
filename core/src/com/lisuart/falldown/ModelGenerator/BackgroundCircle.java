package com.lisuart.falldown.ModelGenerator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by artem on 4/20/18.
 */

public class BackgroundCircle {
    public Sprite white;
    public Sprite grey;
    Vector<Vector2> circles = new Vector<Vector2>();
    public boolean isPair = false;

    float deltaConstant = 0.1f;
    float deltaAdditional = 0;

    float a = 0.1f;
    float ac = 0.1f;

    public BackgroundCircle(int i) {
        if (i == 1) {
            white = new Sprite(new Texture("menu/whiteCircle.png"));
            grey = new Sprite(new Texture("menu/greyCircle.png"));
        } else if (i == 2) {
            white = new Sprite(new Texture("menu/circlePurpleLight.png"));
            grey = new Sprite(new Texture("menu/circlePurpleDark.png"));
        } else if (i == 3) {
            white = new Sprite(new Texture("menu/circleOrangeLight.png"));
            grey = new Sprite(new Texture("menu/circleOrangeDark.png"));
        }

        circles.add(new Vector2(140, 0));
        circles.add(new Vector2(120, 0));
        circles.add(new Vector2(100, 0));
        circles.add(new Vector2(80, 0));
        circles.add(new Vector2(60, 0));
        circles.add(new Vector2(40, 0));
        circles.add(new Vector2(20, 0));
        circles.add(new Vector2(0, 0));
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < circles.size(); i++) {
            if (i % 2 == 1) {
                if (isPair) {
                    batch.draw(white, com.lisuart.falldown.MyGdxGame.width / 2 - circles.get(i).x / 2, com.lisuart.falldown.MyGdxGame.height / 2 - circles.get(i).x / 2 + 3, circles.get(i).x, circles.get(i).x);
                } else {
                    batch.draw(grey, com.lisuart.falldown.MyGdxGame.width / 2 - circles.get(i).x / 2, com.lisuart.falldown.MyGdxGame.height / 2 - circles.get(i).x / 2 + 3, circles.get(i).x, circles.get(i).x);
                }
            } else {
                if (isPair) {
                    batch.draw(grey, com.lisuart.falldown.MyGdxGame.width / 2 - circles.get(i).x / 2, com.lisuart.falldown.MyGdxGame.height / 2 - circles.get(i).x / 2 + 3, circles.get(i).x, circles.get(i).x);
                } else {
                    batch.draw(white, com.lisuart.falldown.MyGdxGame.width / 2 - circles.get(i).x / 2, com.lisuart.falldown.MyGdxGame.height / 2 - circles.get(i).x / 2 + 3, circles.get(i).x, circles.get(i).x);
                }
            }
        }
    }

    public void act() {
        a += ac;
        deltaAdditional = (float)Math.cos(a);
        if (deltaAdditional < 0) {
            deltaAdditional = deltaAdditional /2;
        }
        if (deltaAdditional + deltaConstant > 0.23 || deltaAdditional + deltaConstant < -0.23f) {
            for (int i = 0; i < circles.size(); i++) {
                circles.get(i).add(deltaAdditional + deltaConstant, 0);
            }
        }
        if (circles.firstElement().x > com.lisuart.falldown.MyGdxGame.height + 85) {
            circles.remove(circles.firstElement());
            circles.add(new Vector2(10, 0));
            isPair = !isPair;
        }
    }

    public void  dispose()
    {
        white.getTexture().dispose();
        grey.getTexture().dispose();
    }
}
