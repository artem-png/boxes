package com.siminenko.artem.Listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.Ballon;
import com.siminenko.artem.Model.BonusCoin;
import com.siminenko.artem.Model.Data.BallonData;
import com.siminenko.artem.Model.Data.BonusBigData;
import com.siminenko.artem.Model.Data.UserData;
import com.siminenko.artem.Model.Destroyable;
import com.siminenko.artem.Model.Music.Music;
import com.siminenko.artem.Model.Player;

/**
 * Created by artem on 4/19/18.
 */

public class DestroyableListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        if (contact.getFixtureB().getBody().getUserData() instanceof UserData || contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            if (contact.getFixtureB().getBody().getUserData() instanceof BallonData || contact.getFixtureA().getBody().getUserData() instanceof BallonData) {

            } else {
                if (GameLayout.isDispose || GameLayout.isWin) {

                } else {
                    Music.touch();
                }
            }
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof BonusBigData) {
            ((BonusBigData) contact.getFixtureA().getBody().getUserData()).bonusBig.handlePlayer(((UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof BonusBigData && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((BonusBigData) contact.getFixtureB().getBody().getUserData()).bonusBig.handlePlayer(((UserData) contact.getFixtureA().getBody().getUserData()).player);
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof BonusCoin) {
            ((BonusCoin) contact.getFixtureA().getBody().getUserData()).handlePlayer(((UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof BonusCoin && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((BonusCoin) contact.getFixtureB().getBody().getUserData()).handlePlayer(((UserData) contact.getFixtureA().getBody().getUserData()).player);
        }

        if (contact.getFixtureB().getBody().getUserData() instanceof Destroyable && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((Destroyable) contact.getFixtureB().getBody().getUserData()).doDestroy();
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof Destroyable) {
            ((Destroyable) contact.getFixtureA().getBody().getUserData()).doDestroy();
        }

        if (contact.getFixtureA().getBody().getUserData() instanceof AObject && ((AObject) contact.getFixtureA().getBody().getUserData()).isNeedParticles) {
            Tex.createParticles(2, 1f, contact.getFixtureA().getBody().getPosition());
        } else if (contact.getFixtureB().getBody().getUserData() instanceof AObject && ((AObject) contact.getFixtureB().getBody().getUserData()).isNeedParticles) {
            Tex.createParticles(2, 1f, contact.getFixtureB().getBody().getPosition());
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
