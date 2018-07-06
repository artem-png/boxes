package com.siminenko.artem.Model.Customize;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by artem on 7/6/18.
 */

public class APurchaseModel {
    Sprite bg;
    Sprite player;
    Sprite baloon;

    Vector2 position = new Vector2();
    Vector2 bgSize = new Vector2(30, 14);

    Vector2 playerSize = new Vector2();
    Vector2 baloonSize = new Vector2();

    int playerRotation = 0;
    int baloonRotation = 0;

    public void render(SpriteBatch batch) {
//        batch.draw(
//                bg,
//                position.x + 14,
//                position.y,
//                bgSize.x,
//                bgSize.y
//        );
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
    }

    public void act() {

    }

    public void dispose() {
        bg.getTexture().dispose();
    }
}
