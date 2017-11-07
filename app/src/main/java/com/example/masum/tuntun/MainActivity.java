package com.example.masum.tuntun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity{

    private String API_KEY = BuildConfig.YOUTUBE_API_KEY;
    private WebView youtubeView;
    String url = "https://www.youtube.com/channel/UCDBe0rHYN0isC-3F-92FpXQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load youtube channel
        youtubeView = findViewById(R.id.youtubeView);
        WebSettings settings = youtubeView.getSettings();
        settings.setJavaScriptEnabled(true);
        youtubeView.loadUrl(url);
        youtubeView.setWebViewClient(new MyWebViewClient());

    }

    @Override
    public void onBackPressed() {
        if(youtubeView.canGoBack()){
            youtubeView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
