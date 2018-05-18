package com.siminenko.artem.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by artem on 3/21/18.
 */

public class Tex {
    public static Sprite baloon1;
    public static Sprite player1;
    public static Sprite circle1;
    public static Sprite circle2;
    public static Sprite rectangle1;
    public static Sprite triangle1;
    public static Sprite present1;

    public static float x = (float) Gdx.graphics.getWidth() / 800;
    public static float y = (float) Gdx.graphics.getHeight() / 480;

    public static short collision1 = 50;
    public static short collision2 = 60;
    public static short collision3 = 70;
    public static short collision4 = 80;
    public static short collision0 = 0;
    public static short collisionMinus1 = -1;

    public Tex() {
        baloon1 = new Sprite(new Texture("baloon.png"));
        present1 = new Sprite(new Texture("present.png"));
        player1 = new Sprite(new Texture("player.png"));
        circle1 = new Sprite(new Texture("circle.png"));
        circle2 = new Sprite(new Texture("circleRed.png"));
        rectangle1 = new Sprite(new Texture("rectanble.png"));
        triangle1 = new Sprite(new Texture("triangle.png"));
    }

    public static BitmapFont generateFont(Color color, int size, String name) {
        FreeTypeFontGenerator.setMaxTextureSize(2048);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(name));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = color;
        BitmapFont font20 = generator.generateFont(parameter);

        return font20;
    }
}
