package com.example.jintishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import android.view.View.OnClickListener;

public class BackgroundActivity extends Activity{
	
	private MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.background_layout);
		dbHelper=new MyDatabaseHelper(this,"Jintishhi.db",null,1);
		Button buttoncreate=(Button) findViewById(R.id.button_create);
		
		//button_create
		buttoncreate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dbHelper.getWritableDatabase();
				// TODO Auto-generated method stub
				Intent intent=new Intent(BackgroundActivity.this,CreateActivity.class);
				startActivity(intent);
			}
		});
		
		//πÊ‘Ú∞¥≈•
		Button buttonrule=(Button)findViewById(R.id.button_rule);
		buttonrule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dbHelper.getWritableDatabase();
				Intent intent=new Intent(BackgroundActivity.this,RulewuyanjuejuActivity.class);
				startActivity(intent);
			}
		});
	}
}
