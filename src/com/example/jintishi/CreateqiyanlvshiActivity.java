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
		//获取绝句内容
		title =(EditText) findViewById(R.id.edit_qyls_title);
		lvshi1=(EditText) findViewById(R.id.edit_qyls1);
		lvshi2=(EditText) findViewById(R.id.edit_qyls2);
		lvshi3=(EditText) findViewById(R.id.edit_qyls3);
		lvshi4=(EditText) findViewById(R.id.edit_qyls4);
		//绝句判断按钮，按下判断所做绝句是否正确
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
					Toast.makeText(CreateqiyanlvshiActivity.this, "您还未输入任何文字", Toast.LENGTH_SHORT).show();
					
				}else{
					if(judge){
						Toast.makeText(CreateqiyanlvshiActivity.this, "创作成功，已保存", Toast.LENGTH_LONG).show();
						SQLiteDatabase db=dbHelper.getWritableDatabase();
						ContentValues values=new ContentValues();
						values.put("title", title.getText().toString());
						values.put("body",str);
						db.insert("QYLS", null, values);
					}else{
						Toast.makeText(CreateqiyanlvshiActivity.this, "您的诗句不符合近体诗规则，请查看规则后继续创作，请保存您现在的诗句", Toast.LENGTH_LONG).show();
					}
				}
					
			}
		});

		
		//转到五言绝句判断界面
				Button jueju=(Button) findViewById(R.id.button_wuyanjueju);
				jueju.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreateActivity.class);
						startActivity(intent);
					}
				});
				
				//转到七言绝句判断界面
				Button qiyanjueju=(Button) findViewById(R.id.button_qiyanjueju);
				qiyanjueju.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreateqiyanjuejuActivity.class);
						startActivity(intent);
					}
				});
				
				//转到五言律诗判断界面
				Button wuyanlvshi=(Button)findViewById(R.id.button_wuyanlvshi);
				wuyanlvshi.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreatewuyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//转到七言律诗判断界面
				Button qiyanlvshi=(Button)findViewById(R.id.button_qiyanlvshi);
				qiyanlvshi.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,CreateqiyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//近体诗规则界面
				Button jintishirule=(Button)findViewById(R.id.button_jintishirule);
				jintishirule.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,RuleqiyanlvshiActivity.class);
						startActivity(intent);
					}
				});
				
				//返回主界面
				Button renturnmainactivity=(Button)findViewById(R.id.button_returnmain);
				renturnmainactivity.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(CreateqiyanlvshiActivity.this,BackgroundActivity.class);
						startActivity(intent);
					}
				});
				
				//查看已经保存的七言律诗
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
