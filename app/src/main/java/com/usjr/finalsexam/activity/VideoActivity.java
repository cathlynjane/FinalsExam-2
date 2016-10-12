package com.usjr.finalsexam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.usjr.finalsexam.R;

public class VideoActivity extends YouTubeBaseActivity{

    private YouTubePlayerView                   mYouTubePlayerView;
    private YouTubePlayer.OnInitializedListener mYoutubeInitializeListener;

    private static final int RECOVERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();

        if (intent == null || !intent.hasExtra("VID_ID")) {
            throw new RuntimeException("VideoActivity should accept a VID_ID passed as Intent argument");
        }

        final String videoId = intent.getStringExtra("VID_ID");

        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayerView);

        mYoutubeInitializeListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.setPlayerStateChangeListener(mYoutubeInitializeListener);
                youTubePlayer.setPlaybackEventListener(mYoutubeInitializeListener);
                youTubePlayer.loadVideo("aSdFg123");
            }

            @Override
            public void onInitializationFailure(Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {
                
            }
        };

        mYouTubePlayerView.initialize(
"AIzaSyBkO-xekoxTzDKdC9jR2KCwT-B1lmFbIlI",
        mYoutubeInitializeListener);
        }
}
