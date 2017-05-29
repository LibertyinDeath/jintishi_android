package com.example.jintishi;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import jintishimanage.*;

public class CreateqiyanjuejuActivity extends Activity{
	private MyDatabaseHelper dbHelper;
	private EditText title;
	private EditText jueju1;
	private EditText jueju2;
	private EditText jueju3;
	private EditText jueju4;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.qiyanjueju_layout);
		dbHelper=new MyDatabaseHelper(this,"Jintishi.db",null,1);
		//��ȡ��������
		title =(EditText) findViewById(R.id.edit_qiyanjueju_title);
		jueju1=(EditText) findViewById(R.id.edit_qiyanjueju1);
		jueju2=(EditText) findViewById(R.id.edit_qiyanjueju2);
		jueju3=(EditText) findViewById(R.id.edit_qiyanjueju3);
		jueju4=(EditText) findViewById(R.id.edit_qiyanjueju4);
		
		Button funqyjj=(Button)findViewById(R.id.button_funqyjj);
		funqyjj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StringBuffer strbuf=new StringBuffer();
				
				strbuf.append(jueju1.getText().toString());
				strbuf.append(jueju2.getText().toString());
				strbuf.append(jueju3.getText().toString());
				strbuf.append(jueju4.getText().toString());
				
				final String str=strbuf.toString();
				boolean judge=jintishimanage.qiyanjueju.judge_qyjj(str);
				if(str.length()==0){
					Toast.makeText(CreateqiyanjuejuActivity.this, "����δ�����κ�����", Toast.LENGTH_SHORT).show();
				}else{
					if(judge){
						Toast.makeText(CreateqiyanjuejuActivity.this, "�����ɹ����ѱ���", Toast.LENGTH_LONG).show();
						SQLiteDatabase db=dbHelper.getWritableDatabase();
						ContentValues values=new ContentValues();
						values.put("title", title.getText().toString());
						values.put("body",str);
						db.insert("QYJJ", null, values);
						
							
					}else{
						Toast.makeText(CreateqiyanjuejuActivity.this, "����ʫ�䲻���Ͻ���ʫ������鿴���������������뱣�������ڵ�ʫ��", Toast.LENGTH_LONG).show();
					}
				}
				
			}
		});
		
		//ת�����Ծ����жϽ���
		Button jueju=(Button) findViewById(R.id.button_wuyanjueju);
		jueju.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(CreateqiyanjuejuActivity.this,CreateActivity.class);
				startActivity(intent);
			}
		});
		
		//ת�����Ծ����жϽ���
		Button qiyanjueju=(Button) findViewById(R.id.button_qiyanjueju);
		qiyanjueju.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(CreateqiyanjuejuActivity.this,CreateqiyanjuejuActivity.class);
				startActivity(intent);
			}
		});
		
		//ת��������ʫ�жϽ���
				Button wuyanlvshi=(Button)findViewById(R.id.button_wuyanlvshi);
				wuyanlvshi.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanjuejuActivity.this,CreatewuyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//ת��������ʫ�жϽ���
				Button qiyanlvshi=(Button)findViewById(R.id.button_qiyanlvshi);
				qiyanlvshi.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanjuejuActivity.this,CreateqiyanlvshiActivity.class);
						startActivity(intent);
					}
					
				});
				
				//����ʫ�������
				Button jintishirule=(Button)findViewById(R.id.button_jintishirule);
				jintishirule.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanjuejuActivity.this,RuleqiyanjuejuActivity.class);
						startActivity(intent);
					}
				});
				
				//����������
				Button renturnmainactivity=(Button)findViewById(R.id.button_returnmain);
				renturnmainactivity.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanjuejuActivity.this,BackgroundActivity.class);
						startActivity(intent);
					}
				});
				
				//�鿴�Ѿ���������Ծ���
				Button query=(Button)findViewById(R.id.button_saveqyjj);
				query.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanjuejuActivity.this,QueryActivity_qyjj.class);
						startActivity(intent);
					}
				});
	}
	
}
