package com.swlkr.rickrolld;

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.video);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		VideoView videoView = (VideoView) findViewById(R.id.VideoView);
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);
		videoView.setMediaController(mediaController);
		
		videoView.setVideoURI(
				Uri.parse("android.resource://com.swlkr.rickrolld/" + R.raw.rick_roll));
		videoView.start();
		
		AdManager.setTestDevices( new String[] { 
			      AdManager.TEST_EMULATOR, // Android emulator 
			      "015A6E8B1200B021", // My T-Mobile G1 Test Phone 
			});
			
			AdView adView = (AdView) findViewById(R.id.ad);
			adView.requestFreshAd();
			
			// Set up click listener for rick_roll_button
	        View wtfButton = findViewById(R.id.wtf_button);
	        wtfButton.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.wtf_button:
				Intent myIntent = new Intent(Intent.ACTION_VIEW, 
			            Uri.parse("http://en.m.wikipedia.org/wiki/Rickrolling"));

//			            myIntent.setLaunchFlags(Intent.);
			            this.startActivity(myIntent);
			break;
		}
	}
}
