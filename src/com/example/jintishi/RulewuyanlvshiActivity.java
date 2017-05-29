package com.example.jintishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RulewuyanlvshiActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.rule_wuyanlvshi_layout);
		
		//����������
		Button returnmain=(Button) findViewById(R.id.button_returnmain);
		returnmain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RulewuyanlvshiActivity.this,BackgroundActivity.class);
				startActivity(intent);
			}
		});
		
		//ǰ�����Ծ������
		Button createwuyanjueju=(Button) findViewById(R.id.button_rule_wuyanjueju);
		createwuyanjueju.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RulewuyanlvshiActivity.this,RulewuyanjuejuActivity.class);
				startActivity(intent);
				
			}
		});
		
		//ǰ�����Ծ������
		Button createqiyanjueju=(Button) findViewById(R.id.button_rule_qiyanjueju);
		createqiyanjueju.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RulewuyanlvshiActivity.this,RuleqiyanjuejuActivity.class);
				startActivity(intent);
				
			}
		});
		
		//ǰ��������ʫ����
		Button createwuyanlvshi=(Button) findViewById(R.id.button_rule_wuyanlvshi);
		createwuyanlvshi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RulewuyanlvshiActivity.this,RulewuyanlvshiActivity.class);
				startActivity(intent);
			}
		});
		
		//ǰ��������ʫ����
		Button createqiyanlvshi=(Button) findViewById(R.id.button_rule_qiyanlvshi);
		createqiyanlvshi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RulewuyanlvshiActivity.this,RuleqiyanlvshiActivity.class);
				startActivity(intent);
			}
		});
		
		//ǰ����������
		Button create=(Button)findViewById(R.id.button_create);
		create.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RulewuyanlvshiActivity.this,CreatewuyanlvshiActivity.class);
				startActivity(intent);
			}
		});
	}
}
