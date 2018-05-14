package com.udacity.gradle.builditbigger;

import android.view.View;

import com.google.android.gms.ads.AdRequest;

public class CreateAds {

    public static void initAdView(View rootView) {
        com.google.android.gms.ads.AdView mAdView = rootView.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(rootView.getContext().getString(R.string.test_device_id))
                .build();

        mAdView.loadAd(adRequest);
    }
}
