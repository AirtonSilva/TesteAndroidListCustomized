package br.edu.ifpb.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.example.exemplotw.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_splash);
		
		new Timer().schedule(new TimerTask() {
			 
            public void run() {
                finish();
 
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 6000);

	}
}
