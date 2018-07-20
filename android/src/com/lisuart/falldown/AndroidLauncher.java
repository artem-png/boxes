package com.lisuart.falldown;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.lisuart.falldown.AdMob.RewardAds;
import com.lisuart.falldown.AdMob.VideoEventListener;
import com.lisuart.falldown.AdMob.AdsController;

public class AndroidLauncher extends AndroidApplication implements AdsController, RewardedVideoAdListener, RewardAds {

    private static final String AD_UNIT_ID = "ca-app-pub-6889819481952202/9400154557";
    private static final String APP_ID = "ca-app-pub-6889819481952202~8592892812";


    private static final String BANNER_AD_UNIT_ID = "ca-app-pub-6889819481952202/3851702024";
    private RewardedVideoAd rewardedVideoAd;
    private static final String REWARDED_VIDEO_AD_UNIT_ID = "ca-app-pub-6889819481952202/9400154557";
    private VideoEventListener vel;
    AdView bannerAd;

    public MyGdxGame game;

    public boolean is_video_ad_loaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, APP_ID);

        // Create a gameView and a bannerAd AdView
        this.game = new MyGdxGame(this, this);
        View gameView = initializeForView(game, config);
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
        setupAds();

        // Define the layout
        RelativeLayout layout = new RelativeLayout(this);
        layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layout.addView(bannerAd, params);

        setContentView(layout);
    }

    public void setupAds() {
        bannerAd = new AdView(this);
        bannerAd.setVisibility(View.INVISIBLE);
        bannerAd.setBackgroundColor(0x00000000);
        bannerAd.setAdUnitId(BANNER_AD_UNIT_ID);
        bannerAd.setAdSize(AdSize.SMART_BANNER);
    }

    @Override
    public void showBannerAd() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bannerAd.setVisibility(View.VISIBLE);
                AdRequest.Builder builder = new AdRequest.Builder();
                AdRequest ad = builder.build();
                bannerAd.loadAd(ad);
            }
        });
    }

    public void setVideoEventListener(VideoEventListener listener) {
        this.vel = listener;
    }

    @Override
    public void hideBannerAd() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bannerAd.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void loadRewardedVideoAd() {
        if (!rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    public boolean hasVideoLoaded() {
        return rewardedVideoAd.isLoaded();
    }


    public void showRewardedVideoAd() {
        runOnUiThread(new Runnable() {
            public void run() {
                if (rewardedVideoAd.isLoaded()) {
                    rewardedVideoAd.show();
                } else {
                    loadRewardedVideoAd();
                }
            }
        });
    }


    @Override
    public void onRewarded(RewardItem reward) {
        if (vel != null) {
            // The type and the amount can be set in your AdMob console
            vel.onRewardedEvent(reward.getType(), reward.getAmount());
        }
    }

    // Each time the video ends we need to load a new one
    @Override
    public void onRewardedVideoAdClosed() {
        is_video_ad_loaded = false;
        loadRewardedVideoAd();
        if (vel != null) {
            vel.onRewardedVideoAdClosedEvent();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
        if (vel != null) {
            vel.onRewardedVideoAdLoadedEvent();
        }
        is_video_ad_loaded = true;
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean hasInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null;
    }
}
