package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import static android.view.View.GONE;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.TaskCompletedInterface {

    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        if (BuildConfig.FLAVOR.equals("free")) {
            CreateAds.initAdView(rootView);
        }

        rootView.findViewById(R.id.tellJokeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar = rootView.findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(rootView.getContext(), MainActivityFragment.this).execute();
            }
        });

        return rootView;
    }

    @Override
    public void onTaskCompleted(String returnData) {
        progressBar.setVisibility(GONE);
    }

}
