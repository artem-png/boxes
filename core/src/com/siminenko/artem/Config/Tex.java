package com.siminenko.artem.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.EffectSquare;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 3/21/18.
 */

public class Tex {
    public static Sprite baloon1;
    public static Sprite baloon2;
    public static Sprite baloon3;
    public static Sprite player1;
    public static Sprite player2;
    public static Sprite player3;
    public static Sprite circle1;
    public static Sprite circleDestroyable;
    public static Sprite circle2;
    public static Sprite rectangle1;
    public static Sprite rectangleGrey;
    public static Sprite triangle1;
    public static Sprite present1;
    public static Sprite crest1;
    public static Sprite crestDestroyable;
    public static Sprite shield;
    public static Sprite diamond;
    public static Sprite cog;

    public static Sprite button;
    public static Sprite buttonPressed;

    public static BitmapFont failedWinFont;
    public static BitmapFont smallFont28;
    public static BitmapFont smallFont3;
    public static BitmapFont smallFont35;

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
        baloon2 = new Sprite(new Texture("ballonBall.png"));
        baloon3 = new Sprite(new Texture("baloon3.png"));
        present1 = new Sprite(new Texture("present.png"));
        player1 = new Sprite(new Texture("player.png"));
        player2 = new Sprite(new Texture("playerBall.png"));
        player3 = new Sprite(new Texture("player3.png"));
        circle1 = new Sprite(new Texture("circle.png"));
        circle2 = new Sprite(new Texture("circleRed.png"));
        rectangle1 = new Sprite(new Texture("rectanble.png"));
        rectangleGrey = new Sprite(new Texture("rectangleGrey.png"));
        triangle1 = new Sprite(new Texture("triangle.png"));
        crest1 = new Sprite(new Texture("crest.png"));
        circleDestroyable = new Sprite(new Texture("circleDestroyable.png"));
        crestDestroyable = new Sprite(new Texture("crestDestroyable.png"));
        shield = new Sprite(new Texture("shield.png"));
        diamond = new Sprite(new Texture("diamond.png"));
        cog = new Sprite(new Texture("cog.png"));
        button = new Sprite(new Texture("menu/circleOrangeLight.png"));
        buttonPressed = new Sprite(new Texture("menu/circleOrangeDark.png"));
        float xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        failedWinFont = Tex.generateFont(Color.WHITE, (int) (7 * xd), "bigfont.ttf");
        smallFont28 = Tex.generateFont(Color.WHITE, (int) (2.8f * xd), "smallfont.ttf");
        smallFont3 = Tex.generateFont(Color.WHITE, (int) (3 * xd), "smallfont.ttf");
        smallFont35 = Tex.generateFont(Color.WHITE, (int) (3.5f * xd), "bigfont.ttf");

    }

    public static BitmapFont generateFont(Color color, int size, String name) {
        FreeTypeFontGenerator.setMaxTextureSize(1024);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(name));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = color;
        return generator.generateFont(parameter);
    }

    public static int negativeOrPositive() {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void createParticles(int count, float sizeMulti, Vector2 position) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            float sizeF = (random.nextInt(10) + 4) / 13f * sizeMulti;
            GameLayout.effects.effects.add(new EffectSquare(
                    new Vector2(position),
                    new Vector2(sizeF, sizeF),
                    new Vector2(random.nextFloat() / 3.5f * Tex.negativeOrPositive(), random.nextFloat() / 3.5f * Tex.negativeOrPositive()),
                    new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1),
                    0.3f,
                    random.nextInt(100) / 50f,
                    40
            ));
        }
    }

    public static EffectSquare getParticle(float sizeMulti, Vector2 position, int time) {
        Random random = new Random();
        float sizeF = (random.nextInt(10) + 4) / 13f * sizeMulti;
        EffectSquare effectSquare = new EffectSquare(
                new Vector2(position),
                new Vector2(sizeF, sizeF),
                new Vector2(random.nextFloat() / 3.5f * Tex.negativeOrPositive(), random.nextFloat() / 3.5f * Tex.negativeOrPositive()),
                new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1),
                0.3f,
                random.nextInt(100) / 50f,
                time
        );
        return effectSquare;
    }
}
