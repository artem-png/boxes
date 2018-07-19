package com.lisuart.falldown.Model.Customize;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Config.Tex;

/**
 * Created by artem on 7/6/18.
 */

public class APurchaseModel {
    Sprite player;
    Sprite baloon;

    Vector2 position = new Vector2();
    Vector2 bgSize = new Vector2(30, 14);

    Vector2 playerSize = new Vector2();
    Vector2 baloonSize = new Vector2();
    Vector2 buttonSize = new Vector2(8, 8);

    int playerRotation = 0;
    int baloonRotation = 0;

    Vector2 fontPosition = new Vector2();

    Sprite button = new Sprite(new Texture("menu/onCircle.png"));
    Sprite buttonPressed = new Sprite(new Texture("menu/offCircle.png"));

    int theme;

    int price;

    boolean purchased = false;

    float xd = (float) Gdx.graphics.getWidth() / (float) com.lisuart.falldown.MyGdxGame.width;
    float yd = (float) Gdx.graphics.getHeight() / (float) com.lisuart.falldown.MyGdxGame.height;

    public void render(SpriteBatch batch) {
        if (!purchased) {
            batch.setColor(0, 0, 0, 1);
        }
        if (purchased && Progress.theme != theme) {
            batch.setColor(0.7f, 0.7f, 0.7f, 0.4f);
        }
        batch.draw(
                player,
                position.x + 14 + 3 * bgSize.x / 5 - playerSize.x / 2,
                position.y + bgSize.y / 2 - playerSize.y / 2,
                playerSize.x / 2,
                playerSize.y / 2,
                playerSize.x,
                playerSize.y,
                player.getScaleX(),
                player.getScaleY(),
                playerRotation
        );
        batch.draw(
                baloon,
                position.x + 14 + 3 * bgSize.x / 4 - baloonSize.x / 2,
                position.y + bgSize.y / 2 - baloonSize.y / 2,
                baloonSize.x / 2,
                baloonSize.y / 2,
                baloonSize.x,
                baloonSize.y,
                player.getScaleX(),
                player.getScaleY(),
                baloonRotation
        );
        batch.setColor(1, 1, 1, 1);

        if (!purchased) {
            batch.end();
            com.lisuart.falldown.MyGdxGame.batchFont.begin();
            Tex.smallFont35.draw(com.lisuart.falldown.MyGdxGame.batchFont, price + "", fontPosition.x * xd, fontPosition.y * yd, Gdx.graphics.getWidth(), 1, true);
            com.lisuart.falldown.MyGdxGame.batchFont.end();
            batch.begin();
            batch.draw(Tex.diamond, fontPosition.x + 21, fontPosition.y - 5.5f, 2, 3f);
        }
    }

    public void act() {
        if (!purchased && Progress.diamonds >= this.price && Gdx.input.justTouched()) {
            Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > position.x + 14 + 3 * bgSize.x / 5 - playerSize.x / 2 && vector3.x < position.x + 14 + 3 * bgSize.x / 5 - playerSize.x / 2 + playerSize.x + 4) {
                if (vector3.y > position.y + bgSize.y / 2 - playerSize.y / 2 && vector3.y < position.y + bgSize.y / 2 - playerSize.y / 2 + playerSize.y) {
                    Progress.purchase(this.theme);
                    purchased = Progress.themes[theme - 1] == 1;
                    Progress.minusDiamond(this.price);
                }
            }
        } else if (purchased && Gdx.input.justTouched()) {
            Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > position.x + 14 + 3 * bgSize.x / 5 - playerSize.x / 2 && vector3.x < position.x + 14 + 3 * bgSize.x / 5 - playerSize.x / 2 + playerSize.x + 4) {
                if (vector3.y > position.y + bgSize.y / 2 - playerSize.y / 2 && vector3.y < position.y + bgSize.y / 2 - playerSize.y / 2 + playerSize.y) {
                    Progress.setTheme(this.theme);
                }
            }
        }
    }

    public void dispose() {
        button.getTexture().dispose();
        buttonPressed.getTexture().dispose();
    }
}
