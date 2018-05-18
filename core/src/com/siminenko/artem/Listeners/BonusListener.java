package com.siminenko.artem.Listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.siminenko.artem.Model.Data.BonusBigData;
import com.siminenko.artem.Model.Data.UserData;

/**
 * Created by artem on 4/19/18.
 */

public class BonusListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        if (contact.getFixtureB().getBody().getUserData() instanceof UserData && contact.getFixtureA().getBody().getUserData() instanceof BonusBigData) {
            ((BonusBigData) contact.getFixtureA().getBody().getUserData()).bonusBig.handlePlayer(((UserData) contact.getFixtureB().getBody().getUserData()).player);
        }
        if (contact.getFixtureB().getBody().getUserData() instanceof BonusBigData && contact.getFixtureA().getBody().getUserData() instanceof UserData) {
            ((BonusBigData) contact.getFixtureB().getBody().getUserData()).bonusBig.handlePlayer(((UserData) contact.getFixtureA().getBody().getUserData()).player);
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
