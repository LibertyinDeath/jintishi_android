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

public class CreateqiyanlvshiActivity extends Activity{
	private MyDatabaseHelper dbHelper;
	private EditText title;
	private EditText lvshi1;
	private EditText lvshi2;
	private EditText lvshi3;
	private EditText lvshi4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.qiyanlvshi_layout);
		dbHelper=new MyDatabaseHelper(this,"Jintishi.db",null,1);
		//��ȡ��������
		title =(EditText) findViewById(R.id.edit_qyls_title);
		lvshi1=(EditText) findViewById(R.id.edit_qyls1);
		lvshi2=(EditText) findViewById(R.id.edit_qyls2);
		lvshi3=(EditText) findViewById(R.id.edit_qyls3);
		lvshi4=(EditText) findViewById(R.id.edit_qyls4);
		//�����жϰ�ť�������ж����������Ƿ���ȷ
		Button funjj=(Button)findViewById(R.id.button_funjj);
		funjj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				StringBuffer strbuf=new StringBuffer();
				strbuf.append(lvshi1.getText().toString());
				strbuf.append(lvshi2.getText().toString());
				strbuf.append(lvshi3.getText().toString());
				strbuf.append(lvshi4.getText().toString());
//				
				final String str=strbuf.toString();
				boolean judge=jintishimanage.qiyanlvshi.judge_qyls(str);
				if(str.length()==0){
					Toast.makeText(CreateqiyanlvshiActivity.this, "����δ�����κ�����", Toast.LENGTH_SHORT).show();
					
				}else{
					if(judge){
						Toast.makeText(CreateqiyanlvshiActivity.this, "�����ɹ����ѱ���", Toast.LENGTH_LONG).show();
						SQLiteDatabase db=dbHelper.getWritableDatabase();
						ContentValues values=new ContentValues();
						values.put("title", title.getText().toString());
						values.put("body",str);
						db.insert("QYLS", null, values);
					}else{
						Toast.makeText(CreateqiyanlvshiActivity.this, "����ʫ�䲻���Ͻ���ʫ������鿴���������������뱣�������ڵ�ʫ��", Toast.LENGTH_LONG).show();
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
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreateActivity.class);
						startActivity(intent);
					}
				});
				
				//ת�����Ծ����жϽ���
				Button qiyanjueju=(Button) findViewById(R.id.button_qiyanjueju);
				qiyanjueju.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreateqiyanjuejuActivity.class);
						startActivity(intent);
					}
				});
				
				//ת��������ʫ�жϽ���
				Button wuyanlvshi=(Button)findViewById(R.id.button_wuyanlvshi);
				wuyanlvshi.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreatewuyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//ת��������ʫ�жϽ���
				Button qiyanlvshi=(Button)findViewById(R.id.button_qiyanlvshi);
				qiyanlvshi.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreateqiyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//����ʫ�������
				Button jintishirule=(Button)findViewById(R.id.button_jintishirule);
				jintishirule.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,RuleqiyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//����������
				Button renturnmainactivity=(Button)findViewById(R.id.button_returnmain);
				renturnmainactivity.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,BackgroundActivity.class);
						startActivity(intent);
					}
				});
				
				//�鿴�Ѿ������������ʫ
				Button query=(Button)findViewById(R.id.button_saveqyls);
				query.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,QueryActivity_qyls.class);
						startActivity(intent);
					}
				});
		
	}
}
