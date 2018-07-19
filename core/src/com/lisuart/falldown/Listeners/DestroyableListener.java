package com.lisuart.falldown.Listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.lisuart.falldown.Model.AObject;
import com.lisuart.falldown.Model.BonusCoin;
import com.lisuart.falldown.Model.Data.BallonData;
import com.lisuart.falldown.Model.Data.UserData;
import com.lisuart.falldown.Model.Music.Music;
import com.lisuart.falldown.Model.Player;

/**
 * Created by artem on 4/19/18.
 */

public class DestroyableListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        if (contact.getFixtureB().getBody().getUserData() instanceof UserData || contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            if (
                    contact.getFixtureB().getBody().getUserData() instanceof BallonData
                    || contact.getFixtureA().getBody().getUserData() instanceof BallonData
                    || contact.getFixtureB().getBody().getUserData() instanceof BonusCoin
                    || contact.getFixtureA().getBody().getUserData() instanceof BonusCoin
                    || contact.getFixtureA().getBody().getUserData() instanceof com.lisuart.falldown.Model.Data.BonusBigData
                    || contact.getFixtureB().getBody().getUserData() instanceof com.lisuart.falldown.Model.Data.BonusBigData
                    ) {

            } else {
                if (com.lisuart.falldown.Layout.GameLayout.isDispose || com.lisuart.falldown.Layout.GameLayout.isWin) {

                } else {
                    Music.touch();
                }
            }
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof com.lisuart.falldown.Model.Data.BonusBigData) {
            ((com.lisuart.falldown.Model.Data.BonusBigData) contact.getFixtureA().getBody().getUserData()).bonusBig.handlePlayer(((UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof com.lisuart.falldown.Model.Data.BonusBigData && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((com.lisuart.falldown.Model.Data.BonusBigData) contact.getFixtureB().getBody().getUserData()).bonusBig.handlePlayer(((UserData) contact.getFixtureA().getBody().getUserData()).player);
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof BonusCoin) {
            ((BonusCoin) contact.getFixtureA().getBody().getUserData()).handlePlayer(((UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof BonusCoin && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((BonusCoin) contact.getFixtureB().getBody().getUserData()).handlePlayer(((UserData) contact.getFixtureA().getBody().getUserData()).player);
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof com.lisuart.falldown.Model.Destroyable && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((com.lisuart.falldown.Model.Destroyable) contact.getFixtureB().getBody().getUserData()).doDestroy();
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof com.lisuart.falldown.Model.Destroyable) {
            ((com.lisuart.falldown.Model.Destroyable) contact.getFixtureA().getBody().getUserData()).doDestroy();
        }

        if (contact.getFixtureA().getBody().getUserData() instanceof AObject && ((AObject) contact.getFixtureA().getBody().getUserData()).isNeedParticles) {
            com.lisuart.falldown.Config.Tex.createParticles(2, 1f, contact.getFixtureA().getBody().getPosition());
        } else if (contact.getFixtureB().getBody().getUserData() instanceof AObject && ((AObject) contact.getFixtureB().getBody().getUserData()).isNeedParticles) {
            com.lisuart.falldown.Config.Tex.createParticles(2, 1f, contact.getFixtureB().getBody().getPosition());
        }
    }

    @Override
    public void endContact(Contact contact) {
        if ((contact.getFixtureB().getBody().getUserData() instanceof UserData || contact.getFixtureA().getBody().getUserData() instanceof UserData)) {
            contact.setRestitution(0);
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        if (!Player.isTouch && (contact.getFixtureB().getBody().getUserData() instanceof UserData || contact.getFixtureA().getBody().getUserData() instanceof UserData)) {
            Player.isTouch = true;
        }

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
