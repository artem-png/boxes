package com.lisuart.falldown.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Data.UserData;
import com.lisuart.falldown.Model.Level.ALevel;

/**
 * Created by artem on 4/19/18.
 */
public class Player extends AObject {
    int fingerDistance = Gdx.graphics.getHeight() / 15;
    com.lisuart.falldown.Model.Ballon ballon;

    int touchDelay = 10;

    Vector3 touch = new Vector3();
    Vector2 bodyTouch = new Vector2();
    Vector2 lastTouch = new Vector2();

    // triangle
    float x0 = 0f;
    float y0 = 3f;
    float x1 = -2.9f;
    float y1 = -1.8f;
    float x2 = 2.9f;
    float y2 = -1.8f;

    float ballRadius = 2.8f;

    float prymoX = 5.5f;
    float prymoY = 1.8f;

    float square = 2.8f;

    // triangle big
    float bigMultiplier = 2.0f;

    boolean isBigger = false;
    boolean isBig = false;
    boolean isSizeModified = false;
    int timeBigger = 0;

    public static boolean isTouch = false;

    Sprite sprite;

    int baloonInactive = 0;

    public Player(World world, Vector2 position, ALevel level) {
        this.world = world;
        if (com.lisuart.falldown.Config.Progress.theme == 0) {
            sprite = com.lisuart.falldown.Config.Tex.player1;
        } else if (com.lisuart.falldown.Config.Progress.theme == 1) {
            sprite = com.lisuart.falldown.Config.Tex.player2;
        } else if (com.lisuart.falldown.Config.Progress.theme == 2) {
            sprite = com.lisuart.falldown.Config.Tex.player3;
        } else if (com.lisuart.falldown.Config.Progress.theme == 3) {
            sprite = com.lisuart.falldown.Config.Tex.player4;
        }

        toNormal(position);
        this.body.setUserData(new UserData(this));
        this.body.setGravityScale(0);
        ballon = new com.lisuart.falldown.Model.Ballon(world, new Vector2(position.x, 6), level);
        this.body.setActive(true);
    }

    public void setInActive(int time)
    {
        baloonInactive = time;
        this.ballon.body.setActive(false);
    }

    @Override
    public void act() {
        input();
        if (baloonInactive > 0) {
            baloonInactive--;
            if (baloonInactive == 0) {
                this.ballon.body.setActive(true);
            }
        }
        ballon.act();
        if (body.getAngularVelocity() > 0) {
            body.setAngularVelocity(body.getAngularVelocity() - 0.01f);
            if (body.getAngularVelocity() < 0) {
                body.setAngularVelocity(0);
            }
        }
        if (body.getAngularVelocity() < 0) {
            body.setAngularVelocity(body.getAngularVelocity() + 0.01f);
            if (body.getAngularVelocity() > 0) {
                body.setAngularVelocity(0);
            }
        }

        if (body.getPosition().x < 0) {
            body.setTransform(0, body.getPosition().y, body.getAngle());
        }
        if (body.getPosition().x > com.lisuart.falldown.MyGdxGame.width) {
            body.setTransform(com.lisuart.falldown.MyGdxGame.width, body.getPosition().y, body.getAngle());
        }

        if (body.getPosition().y < 0) {
            body.setTransform(body.getPosition().x, 0, body.getAngle());
        }
        if (body.getPosition().y > com.lisuart.falldown.MyGdxGame.height) {
            body.setTransform(body.getPosition().x, com.lisuart.falldown.MyGdxGame.height, body.getAngle());
        }

        if (isBigger) {
            isBigger = false;
            toBig();
        }

        if (isSizeModified) {
            timeBigger--;
            if (timeBigger <= 0) {
                toNormal(body.getPosition());
                isBigger = false;
                isSizeModified = false;
            }
        }

        if (GameLayout.isWin) {
            com.lisuart.falldown.Config.Tex.createParticles(5, 1f, this.body.getPosition());
        }
    }

    public void stop() {
        this.body.setLinearVelocity(0, 0);
    }

    @Override
    public void render(SpriteBatch batch) {
        ballon.render(batch);
        float multi = 1;
        if (isBig) {
            multi = bigMultiplier;
        }
        if (com.lisuart.falldown.Config.Progress.theme == 0) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x + x1 * multi,
                    this.body.getPosition().y + y1 * multi,
                    sprite.getOriginX(),
                    sprite.getOriginY(),
                    -x1 * multi + x2 * multi,
                    y0 * 2 * multi,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        } else if (com.lisuart.falldown.Config.Progress.theme == 1) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x - ballRadius * multi,
                    this.body.getPosition().y - ballRadius * multi,
                    ballRadius * multi,
                    ballRadius * multi,
                    ballRadius * multi * 2,
                    ballRadius * multi * 2,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        } else if (com.lisuart.falldown.Config.Progress.theme == 2) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x - prymoX * multi,
                    this.body.getPosition().y - prymoY * multi,
                    prymoX * multi,
                    prymoY * multi,
                    prymoX * multi * 2,
                    prymoY * multi * 2,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        }  else if (com.lisuart.falldown.Config.Progress.theme == 3) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x - square * multi,
                    this.body.getPosition().y - square * multi,
                    square * multi,
                    square * multi,
                    square * multi * 2,
                    square * multi * 2,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        }
    }

    public void dispose() {
        ballon.dispose();
        shape.dispose();
        this.world.destroyBody(body);
    }

    public void input() {
        if (this.isDisposed) {
            return;
        }
        touchDelay--;
        if (Gdx.input.justTouched()) {
            touch = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            bodyTouch = new Vector2(body.getPosition().x, body.getPosition().y);
        }
        if (touchDelay <= 0 && Gdx.input.isTouched() && !Gdx.input.justTouched()) {
            Vector2 currentPosition1 = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            Vector3 currentPosition = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(currentPosition1.x, currentPosition1.y, 0));
            currentPosition.set(currentPosition.x + (bodyTouch.x - touch.x), currentPosition.y + (bodyTouch.y - touch.y), 0);
            float x = -(body.getPosition().x - currentPosition.x) * 20;
            float y = -(body.getPosition().y - currentPosition.y) * 20;
            this.body.setLinearVelocity(x, y);

            if (!isTouch) {
                float xd = -(body.getPosition().x - currentPosition.x) / 12;
                float yd = -(body.getPosition().y - currentPosition.y) / 12;
                if (Math.abs(xd) + Math.abs(yd) > 0.7) {
                    this.body.setTransform(this.body.getPosition().x + xd, this.body.getPosition().y + yd, body.getAngle());
                }
            }
        } else {
            this.body.setLinearVelocity(0, 0);
        }
        if (this.body.getAngularVelocity() > 10) {
            this.body.setAngularVelocity(this.body.getAngularVelocity() - 0.05f);
        }
        isTouch = false;
    }

    public void makeBigger(float percent, int time) {
        if (!isSizeModified) {
            isBigger = true;
            isSizeModified = true;
            timeBigger = time;
        }
    }

    public void toBig() {
        if (com.lisuart.falldown.Config.Progress.theme == 0) {
            PolygonShape shape = new PolygonShape();
            Vector2[] vector2 = new Vector2[3];
            vector2[0] = new Vector2(x0 * bigMultiplier, y0 * bigMultiplier);
            vector2[1] = new Vector2(x1 * bigMultiplier, y1 * bigMultiplier);
            vector2[2] = new Vector2(x2 * bigMultiplier, y2 * bigMultiplier);
            shape.set(vector2);
            this.shape = shape;
        } else if (com.lisuart.falldown.Config.Progress.theme == 1) {
            CircleShape shape = new CircleShape();
            shape.setRadius(ballRadius * bigMultiplier);
            this.shape = shape;
        } else if (com.lisuart.falldown.Config.Progress.theme == 2) {
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(prymoX * bigMultiplier, prymoY * bigMultiplier);
            this.shape = shape;
        } else if (com.lisuart.falldown.Config.Progress.theme == 3) {
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(square * bigMultiplier, square * bigMultiplier);
            this.shape = shape;
        }
        isBig = true;

        this.createObject(body.getPosition(), this.shape, GameLayout.world, 0.30f, 0.5f, 0f);
        this.body.setActive(true);
        com.lisuart.falldown.Config.Tex.createParticles(30, 1, body.getPosition());

        sprite.setOrigin(x2 * bigMultiplier, -y2 * bigMultiplier);
        this.body.setUserData(new UserData(this));
    }

    public void toNormal(Vector2 position) {
        if (com.lisuart.falldown.Config.Progress.theme == 0) {
            PolygonShape shape = new PolygonShape();
            Vector2[] vector2 = new Vector2[3];
            vector2[0] = new Vector2(x0, y0);
            vector2[1] = new Vector2(x1, y1);
            vector2[2] = new Vector2(x2, y2);
            shape.set(vector2);
            this.shape = shape;
        } else if (com.lisuart.falldown.Config.Progress.theme == 1) {
            CircleShape shape = new CircleShape();
            shape.setRadius(ballRadius);
            this.shape = shape;
        } else if (com.lisuart.falldown.Config.Progress.theme == 2) {
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(prymoX, prymoY);
            this.shape = shape;
        } else if (com.lisuart.falldown.Config.Progress.theme == 3) {
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(square, square);
            this.shape = shape;
        }
        isBig = false;

        this.createObject(position, this.shape, GameLayout.world, 0.2f, 0.3f, 0.0f);
        this.body.setActive(true);
        com.lisuart.falldown.Config.Tex.createParticles(30, 1, body.getPosition());

        sprite.setOrigin(x2, -y2);
        this.body.setUserData(new UserData(this));
    }
}
