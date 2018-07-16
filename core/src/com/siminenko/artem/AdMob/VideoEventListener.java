package com.siminenko.artem.AdMob;

/**
 * Created by artem on 7/16/18.
 */

public interface VideoEventListener {
    void onRewardedEvent(String type, int amount);
    void onRewardedVideoAdLoadedEvent();
    void onRewardedVideoAdClosedEvent();
}
