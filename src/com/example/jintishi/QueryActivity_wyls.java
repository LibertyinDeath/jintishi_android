package com.example.jintishi;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QueryActivity_wyls extends Activity{
	List<JintishiInfo> JintishiInfoList;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.query_wyls_layout);
		JintishiInfoList=new ArrayList<JintishiInfo>();
		
		MyDatabaseHelper dbHelper=new MyDatabaseHelper(this, "Jintishi.db", null, 1);
		SQLiteDatabase db=dbHelper.getWritableDatabase();
		Cursor cursor=db.query("WYLS", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				int id=cursor.getInt(cursor.getColumnIndex("id"));
				String title=cursor.getString(cursor.getColumnIndex("title"));
				String body=cursor.getString(cursor.getColumnIndex("body"));
				JintishiInfo info=new JintishiInfo(id, title, body);
				JintishiInfoList.add(info);
				System.out.println(info.toString());
			}while(cursor.moveToNext());
			cursor.close();
			LinearLayout ll=(LinearLayout)findViewById(R.id.ll_wyls);
			for(JintishiInfo info:JintishiInfoList){
				TextView tv=new TextView(this);
				tv.setText(info.toString()+"\n");
				tv.setTextSize(18);
				tv.setTextColor(0xFFFFD700);
				ll.addView(tv);
			}
			TextView tv=new TextView(this);
			tv.setText("\n\n\n");
			ll.addView(tv);
		}else{
			LinearLayout ll=(LinearLayout)findViewById(R.id.ll_wyls);
			TextView tv=new TextView(this);
			tv.setText("����������ʫ����\n\n\n");
			tv.setTextSize(18);
			tv.setTextColor(0xFFFFD700);
			ll.addView(tv);
		}
		
		//��ת�����Ծ����ѯ
		Button query_wyjj=(Button) findViewById(R.id.button_querywyjj);
		query_wyjj.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_wyls.this,QueryActivity_wyjj.class);
				startActivity(intent);
			}
		});
		
		//��ת�����Ծ����ѯ
		Button query_qyjj=(Button) findViewById(R.id.button_queryqyjj);
		query_qyjj.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_wyls.this,QueryActivity_qyjj.class);
				startActivity(intent);
			}
		});
		
		//��ת��������ʫ��ѯ
		Button query_wyls=(Button) findViewById(R.id.button_querywyls);
		query_wyls.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_wyls.this,QueryActivity_wyls.class);
				startActivity(intent);
			}
		});
		
		//��ת��������ʫ��ѯ
		Button query_qyls=(Button) findViewById(R.id.button_queryqyls);
		query_qyls.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_wyls.this,QueryActivity_qyls.class);
				startActivity(intent);
			}
		});
		
		//��������
		Button create=(Button)findViewById(R.id.button_create_wyls);
		create.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_wyls.this,CreatewuyanlvshiActivity.class);
				startActivity(intent);
			}
		});
		
		//����������
		Button returnmain=(Button)findViewById(R.id.button_returnmain);
		returnmain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_wyls.this,CreateqiyanjuejuActivity.class);
				startActivity(intent);
			}
		});
	}
}
