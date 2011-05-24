package com.swlkr.rickrolld;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class RickRoll extends Activity implements OnClickListener {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/shanghai.ttf");
		TextView tv = (TextView) findViewById(R.id.main_title_textview);
		tv.setTypeface(tf);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		
        
        // Set up click listener for rick_roll_button
        View rickRollButton = findViewById(R.id.rick_roll_button);
        rickRollButton.setOnClickListener(this);
    }
    
    public void onClick(View v){
    	switch(v.getId()){
    		case R.id.rick_roll_button:
    			Intent i = new Intent(this, Video.class);
    			startActivity(i);
    			break;
    	}
    }
}