package com.lisuart.falldown;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

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
	private static final String BANNER_AD_UNIT_ID = "ca-app-pub-6889819481952202/3851702024";
	private RewardedVideoAd adRewardedVideoView;
	private static final String REWARDED_VIDEO_AD_UNIT_ID = "ca-app-pub-6889819481952202/9400154557";
	private VideoEventListener vel;
	AdView bannerAd;

	public MyGdxGame game;

	public boolean is_video_ad_loaded;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		// Create a gameView and a bannerAd AdView
		this.game = new MyGdxGame(this, this);
		View gameView = initializeForView(game, config);
		setupRewarded();
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

	public void setVideoEventListener (VideoEventListener listener) {
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
		adRewardedVideoView.loadAd(REWARDED_VIDEO_AD_UNIT_ID, new AdRequest.Builder().build());
	}

	public void setupRewarded() {
		adRewardedVideoView = MobileAds.getRewardedVideoAdInstance(this);
		adRewardedVideoView.setRewardedVideoAdListener(this);
		loadRewardedVideoAd();
	}

	public boolean hasVideoLoaded(){
		if(is_video_ad_loaded) {
			return true;
		}
		runOnUiThread(new Runnable() {
			public void run() {
				if (!adRewardedVideoView.isLoaded()) {
					loadRewardedVideoAd();
				}
			}
		});
		return false;
	}


	public void showRewardedVideoAd(){
		runOnUiThread(new Runnable() {
			public void run() {
				if (adRewardedVideoView.isLoaded()) {
					adRewardedVideoView.show();
				} else {
					loadRewardedVideoAd();
				}
			}
		});
	}


	@Override
	public void onRewarded(RewardItem reward) {
		if(vel != null) {
			// The type and the amount can be set in your AdMob console
			vel.onRewardedEvent(reward.getType(), reward.getAmount());
		}
	}

	// Each time the video ends we need to load a new one
	@Override
	public void onRewardedVideoAdClosed() {
		is_video_ad_loaded = false;
		loadRewardedVideoAd();
		if(vel != null) {
			vel.onRewardedVideoAdClosedEvent();
		}
	}

	@Override
	public void onRewardedVideoAdLoaded() {
		if(vel != null) {
			vel.onRewardedVideoAdLoadedEvent();
		}
		is_video_ad_loaded = true;
	}

	@Override
	public void onRewardedVideoAdOpened() {

	}

	@Override
	public void onRewardedVideoStarted() {

	}


	@Override
	public void onRewardedVideoAdLeftApplication() {

	}

	@Override
	public void onRewardedVideoAdFailedToLoad(int i) {
		System.out.println(
				123123123
		);
	}
}
