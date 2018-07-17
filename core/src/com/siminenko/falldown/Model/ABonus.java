package com.siminenko.falldown.Model;

/**
 * Created by artem on 4/19/18.
 */

public abstract class ABonus extends AObject {
    public boolean isBonusGiven = false;
    public float timeExpireSetting = 30f;
    public float timeExpire = timeExpireSetting;

    public abstract void handlePlayer(Player player);

}
