package com.example.jintishi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	public static final String CREATE_WYJJ="create table WYJJ("
			+"id integer primary key autoincrement,"
			+"title text,"
			+"body text)";
	
	public static final String CREATE_QYJJ="create table QYJJ("
			+"id integer primary key autoincrement,"
			+"title text,"
			+"body text)";
	
	public  static final String CREATE_WYLS="create table WYLS("
			+"id integer primary key autoincrement,"
			+"title text,"
			+"body text)";
	
	public static final String CREATE_QYLS="create table QYLS("
			+"id integer primary key autoincrement,"
			+"title text,"
			+"body text)";
	
	private Context mContext;
	
	public MyDatabaseHelper(Context context,String name,CursorFactory factory,int version){
		super(context,name,factory,version);
		mContext=context;
	}
	
	@Override
	public  void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_WYJJ);
		db.execSQL(CREATE_QYJJ);
		db.execSQL(CREATE_WYLS);
		db.execSQL(CREATE_QYLS);
		Toast.makeText(mContext, "创建成功", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
		
	}
}
