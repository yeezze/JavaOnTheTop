package com.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//import com.google.android.youtube.player.YouTubeBaseActivity;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//public class SubActivity_menu extends YouTube{
//    //객체 선언
//    YouTubePlayerView playerView;
//    YouTubePlayer player;
//    //유튜브 API KEY와 동영상 ID 변수 설정
//    private static String API_KEY = "AIzaSyDD4A9AgBx0zoLl8zI4mzZziY291dzPARk";
//    //https://www.youtube.com/watch?v=hl-ii7W4ITg ▶ 유튜브 동영상 v= 다음 부분이 videoId
//    private static String videoId = "hl-ii7W4ITg";    //DB 연결하여 수정해야
//    //logcat 사용 설정
//    private static final String TAG = "MainActivity";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initPlayer();
//        Button btnPlay = findViewById(R.id.youtubeBtn);
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                playVideo();
//            }
//        });
//    }
//    private void playVideo() {
//        if(player != null) {
//            if(player.isPlaying()) {
//                player.pause();
//            }
//            player.cueVideo(videoId);
//        }
//    }
//    //유튜브 플레이어 메서드
//    private void initPlayer() {
//        playerView = findViewById(R.id.youTubePlayerView);
//        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                player = youTubePlayer;
//                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
//                    @Override
//                    public void onLoading() {
//                    }
//
//                    @Override
//                    public void onLoaded(String id) {
//                        Log.d(TAG, "onLoaded: " + id);
//                        player.play();
//                    }
//
//                    @Override
//                    public void onAdStarted() {
//                    }
//
//                    @Override
//                    public void onVideoStarted() {
//                    }
//
//                    @Override
//                    public void onVideoEnded() {
//                    }
//
//                    @Override
//                    public void onError(YouTubePlayer.ErrorReason errorReason) {
//                        Log.d(TAG, "onError: " + errorReason);
//                    }
//                });
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//            }
//        });
//    }
//}
