package com.example.jintishi;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class IndexActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.index);
		final Intent intent=new Intent(IndexActivity.this,BackgroundActivity.class);
		Timer timer=new Timer();
		TimerTask task=new TimerTask(){
			@Override
			public void run(){
				startActivity(intent);
				IndexActivity.this.finish();
			}
		};
		timer.schedule(task, 3000);
	}
}
