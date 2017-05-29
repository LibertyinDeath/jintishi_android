package com.example.jintishi;

public class JintishiInfo {
	private int id;
	private String title;
	private String body;
	
	public JintishiInfo(int id,String title,String body){
		super();
		this.id=id;
		this.title=title;
		this.body=body;
	}
	public int get_id(){
		return id;
	}
	public void set_id(int id){
		this.id=id;
	}
	public String get_title(){
		return title;
	}
	public void set_title(String title){
		this.title=title;
	}
	public String get_body(){
		return body;
	}
	public void set_body(){
		this.body=body;
	}
	@Override
	public String toString(){
		return "ตฺ"+id+"สื:\n"+title+"\n"+body;
	}
}
