package com.siminenko.artem.ModelGenerator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 4/20/18.
 */

public class Background {
    // white - FFFFFF
    // lightpink - FEDDEC
    // lightblue - DFDCFC
    // lightyellow - FBFAE0
    // lightgreen - F4FBF1
    final int WHITE = 1;
    final int LIGHTPINK = 2;
    final int LIGHTBLUE = 3;
    final int LIGHTYELLOW = 4;
    final int LIGHTGREEN = 5;

    Random random = new Random();

    Sprite sprite1;
    int sa;
    int sb;
    Sprite sprite2;
    int sa2;
    int sb2;

    Vector2 sprite1Position = new Vector2(0, 0);
    Vector2 sprite2Position = new Vector2(0, MyGdxGame.height);

    public Background() {
        sa = this.getNewNumber(10000);
        sb = this.getNewNumber(sa);

        this.sprite1 = getSprite(sa, sb);

        sa2 = sb;
        sb2 = this.getNewNumber(sa2);

        this.sprite2 = getSprite(sa2, sb2);
    }

    public void render(SpriteBatch batch) {
        batch.draw(sprite1, sprite1Position.x, sprite1Position.y, MyGdxGame.width, MyGdxGame.height + 2);
        batch.draw(sprite2, sprite2Position.x, sprite2Position.y, MyGdxGame.width, MyGdxGame.height + 2);
    }

    public void act() {
        sprite1Position.y -= 0.3f;
        sprite2Position.y -= 0.3f;

        if (sprite1Position.y < -MyGdxGame.height) {
            sprite1.getTexture().dispose();
            sa = sb2;
            sb = this.getNewNumber(sa);
            sprite1 = getSprite(sa, sb);
            sprite1Position.y = MyGdxGame.height;
        } else if (sprite2Position.y < -MyGdxGame.height) {
            sprite2.getTexture().dispose();
            sa2 = sb;
            sb2 = this.getNewNumber(sa2);
            this.sprite2 = getSprite(sa2, sb2);
            sprite2Position.y = MyGdxGame.height;
        }
    }

    public Sprite getSprite(int a, int b) {
        return new Sprite(new Texture("bg/" + this.getPartFromInt(a) + "-" + this.getPartFromInt(b) + ".png"));
    }

    public int getNewNumber(int notthis) {
        int a = notthis;
        while (a == notthis) {
            a = random.nextInt(5) + 1;
        }

        return a;
    }

    public String getPartFromInt(int color) {
        if (color == WHITE) {
            return "white";
        } else if (color == LIGHTBLUE) {
            return "lightblue";
        } else if (color == LIGHTPINK) {
            return "lightpink";
        } else if (color == LIGHTYELLOW) {
            return "lightyellow";
        } else if (color == LIGHTGREEN) {
            return "lightgreen";
        }

        return "";
    }
}
