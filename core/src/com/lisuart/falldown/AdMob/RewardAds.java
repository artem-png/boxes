package com.lisuart.falldown.AdMob;

/**
 * Created by artem on 7/16/18.
 */

public interface RewardAds {
    public boolean hasVideoLoaded();

    public void loadRewardedVideoAd();

    public void showRewardedVideoAd();

    public void setVideoEventListener(VideoEventListener listener);
}
