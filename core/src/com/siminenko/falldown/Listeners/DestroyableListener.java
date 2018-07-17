package com.siminenko.falldown.Listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Layout.GameLayout;
import com.siminenko.falldown.Model.Data.BonusBigData;
import com.siminenko.falldown.Model.Destroyable;

/**
 * Created by artem on 4/19/18.
 */

public class DestroyableListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        if (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData || contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData) {
            if (
                    contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.BallonData
                    || contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.BallonData
                    || contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.BonusCoin
                    || contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.BonusCoin
                    || contact.getFixtureA().getBody().getUserData() instanceof BonusBigData
                    || contact.getFixtureB().getBody().getUserData() instanceof BonusBigData
                    ) {

            } else {
                if (GameLayout.isDispose || GameLayout.isWin) {

                } else {
                    com.siminenko.falldown.Model.Music.Music.touch();
                }
            }
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData && contact.getFixtureA().getBody().getUserData() instanceof BonusBigData) {
            ((BonusBigData) contact.getFixtureA().getBody().getUserData()).bonusBig.handlePlayer(((com.siminenko.falldown.Model.Data.UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof BonusBigData && contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData) {
            ((BonusBigData) contact.getFixtureB().getBody().getUserData()).bonusBig.handlePlayer(((com.siminenko.falldown.Model.Data.UserData) contact.getFixtureA().getBody().getUserData()).player);
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData && contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.BonusCoin) {
            ((com.siminenko.falldown.Model.BonusCoin) contact.getFixtureA().getBody().getUserData()).handlePlayer(((com.siminenko.falldown.Model.Data.UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.BonusCoin && contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData) {
            ((com.siminenko.falldown.Model.BonusCoin) contact.getFixtureB().getBody().getUserData()).handlePlayer(((com.siminenko.falldown.Model.Data.UserData) contact.getFixtureA().getBody().getUserData()).player);
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof Destroyable && contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData) {
            ((Destroyable) contact.getFixtureB().getBody().getUserData()).doDestroy();
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData && contact.getFixtureA().getBody().getUserData() instanceof Destroyable) {
            ((Destroyable) contact.getFixtureA().getBody().getUserData()).doDestroy();
        }

        if (contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.AObject && ((com.siminenko.falldown.Model.AObject) contact.getFixtureA().getBody().getUserData()).isNeedParticles) {
            Tex.createParticles(2, 1f, contact.getFixtureA().getBody().getPosition());
        } else if (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.AObject && ((com.siminenko.falldown.Model.AObject) contact.getFixtureB().getBody().getUserData()).isNeedParticles) {
            Tex.createParticles(2, 1f, contact.getFixtureB().getBody().getPosition());
        }
    }

    @Override
    public void endContact(Contact contact) {
        if ((contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData || contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData)) {
            contact.setRestitution(0);
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        if (!com.siminenko.falldown.Model.Player.isTouch && (contact.getFixtureB().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData || contact.getFixtureA().getBody().getUserData() instanceof com.siminenko.falldown.Model.Data.UserData)) {
            com.siminenko.falldown.Model.Player.isTouch = true;
        }

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
