package com.olamide.udacity.havealaugh.free;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.olamide.jokedisplay.JokeActivity;
import com.olamide.udacity.havealaugh.EndpointsAsyncTask;
import com.olamide.udacity.havealaugh.JokeAsyncTask;
import com.olamide.udacity.havealaugh.JokeAsynctaskInterface;
import com.olamide.udacity.havealaugh.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements JokeAsynctaskInterface {

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);


        ButterKnife.bind(this, root);

        new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred"));


        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        return root;
    }

    @OnClick(R.id.bt_tell_joke)
    public void tellJoke(){

        pbLoading.setVisibility(View.VISIBLE);
        new JokeAsyncTask(this).execute();
    }

    @Override
    public void didplayJoke(String joke) {
        pbLoading.setVisibility(View.INVISIBLE);
        Toast.makeText(getContext(), joke, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getContext(), JokeActivity.class);
        //intent.putExtra(JokeActivity.JOKE_AUTHOR_KEY, joke.getAuthor());
        intent.putExtra(JokeActivity.JOKE_CONTENT_KEY, joke);
        getContext().startActivity(intent);


    }
}






