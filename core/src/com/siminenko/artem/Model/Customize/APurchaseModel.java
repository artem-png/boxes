package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

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

    Sprite button = new Sprite(new Texture("menu/onCircle.png"));
    Sprite buttonPressed = new Sprite(new Texture("menu/offCircle.png"));

    int theme;

    int price;

    boolean purchased = false;

    float xd = Gdx.graphics.getWidth() / MyGdxGame.width;
    float yd = Gdx.graphics.getHeight() / MyGdxGame.height;

    public void render(SpriteBatch batch) {
        String text = "";
        batch.draw(
                player,
                position.x + 14 + 3 * bgSize.x / 5 - playerSize.x /2,
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
                position.x + 14 +  3 * bgSize.x / 4 - baloonSize.x /2,
                position.y + bgSize.y / 2 - baloonSize.y / 2,
                baloonSize.x / 2,
                baloonSize.y / 2,
                baloonSize.x,
                baloonSize.y,
                player.getScaleX(),
                player.getScaleY(),
                baloonRotation
        );
        if (!purchased) {
            if (Progress.diamonds >= this.price) {
                batch.draw(
                        Tex.button,
                        position.x + 19 - buttonSize.x / 2,
                        position.y + bgSize.y / 2 - buttonSize.y / 2,
                        buttonSize.x,
                        buttonSize.y
                );
                text = "" + this.price;
            } else {
                batch.draw(
                        buttonPressed,
                        position.x + 19 - buttonSize.x / 2,
                        position.y + bgSize.y / 2 - buttonSize.y / 2,
                        buttonSize.x,
                        buttonSize.y
                );
                text = "" + this.price;
            }
        } else {
            if (Progress.theme == theme) {
                batch.draw(
                        button,
                        position.x + 19 - buttonSize.x / 2,
                        position.y + bgSize.y / 2 - buttonSize.y / 2,
                        buttonSize.x,
                        buttonSize.y
                );
                text = "ON";
            } else {
                batch.draw(
                        buttonPressed,
                        position.x + 19 - buttonSize.x / 2,
                        position.y + bgSize.y / 2 - buttonSize.y / 2,
                        buttonSize.x,
                        buttonSize.y
                );
                text = "OFF";
            }
        }
        batch.end();
        MyGdxGame.batchFont.begin();
        Tex.smallFont35.draw(MyGdxGame.batchFont, text, (position.x - 3.1f) * xd, (position.y + (theme == 0 ? 9.5f : (theme == 1 ? 9.2f : 8.9f))) * yd, Gdx.graphics.getWidth(), 1, true);
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void act() {
        if (!purchased && Progress.diamonds >= this.price && Gdx.input.justTouched()) {
            Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > position.x + 19 - buttonSize.x / 2 && vector3.x < position.x + 19 - buttonSize.x / 2 + buttonSize.x) {
                if (vector3.y > position.y + bgSize.y / 2 - buttonSize.y / 2 && vector3.y < position.y + bgSize.y / 2 - buttonSize.y / 2 + buttonSize.y) {
                    Progress.purchase(this.theme);
                    purchased = Progress.themes[theme - 1] == 1;
                    Progress.minusDiamond(this.price);
                }
            }
        } else if (purchased && Gdx.input.justTouched()) {
            Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > position.x + 19 - buttonSize.x / 2 && vector3.x < position.x + 19 - buttonSize.x / 2 + buttonSize.x) {
                if (vector3.y > position.y + bgSize.y / 2 - buttonSize.y / 2 && vector3.y < position.y + bgSize.y / 2 - buttonSize.y / 2 + buttonSize.y) {
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
