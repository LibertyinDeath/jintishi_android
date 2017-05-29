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

public class QueryActivity_qyjj extends Activity{
	
	List<JintishiInfo> JintishiInfoList;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.query_qyjj_layout);
		JintishiInfoList=new ArrayList<JintishiInfo>();
		
		MyDatabaseHelper dbHelper=new MyDatabaseHelper(this, "Jintishi.db", null, 1);
		SQLiteDatabase db=dbHelper.getWritableDatabase();
		Cursor cursor=db.query("QYJJ", null, null, null, null, null, null);
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
			LinearLayout ll=(LinearLayout)findViewById(R.id.ll_qyjj);
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
			LinearLayout ll=(LinearLayout)findViewById(R.id.ll_qyjj);
			TextView tv=new TextView(this);
			tv.setText("暂无七言绝句数据\n\n\n");
			tv.setTextSize(18);
			tv.setTextColor(0xFFFFD700);
			ll.addView(tv);
		}
		
		//跳转到五言绝句查询
		Button query_wyjj=(Button) findViewById(R.id.button_querywyjj);
		query_wyjj.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_qyjj.this,QueryActivity_wyjj.class);
				startActivity(intent);
			}
		});
		
		//跳转到七言绝句查询
		Button query_qyjj=(Button) findViewById(R.id.button_queryqyjj);
		query_qyjj.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_qyjj.this,QueryActivity_qyjj.class);
				startActivity(intent);
			}
		});
		
		//跳转到五言律诗查询
		Button query_wyls=(Button) findViewById(R.id.button_querywyls);
		query_wyls.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_qyjj.this,QueryActivity_wyls.class);
				startActivity(intent);
			}
		});
		
		//跳转到七言律诗查询
		Button query_qyls=(Button) findViewById(R.id.button_queryqyls);
		query_qyls.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_qyjj.this,QueryActivity_qyls.class);
				startActivity(intent);
			}
		});
		
		//创作界面
		Button create=(Button)findViewById(R.id.button_create_qyjj);
		create.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_qyjj.this,CreateqiyanjuejuActivity.class);
				startActivity(intent);
			}
		});
		
		//返回主界面
		Button returnmain=(Button)findViewById(R.id.button_returnmain);
		returnmain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(QueryActivity_qyjj.this,CreateqiyanjuejuActivity.class);
				startActivity(intent);
			}
		});
	}
}
