package jintishimanage;

//xzppz
//ppzzp
//xppzz
//xzzpp
//xpzzp
//judge_wyls
//参考http://blog.sina.com.cn/s/blog_9beb230d01018ad6.html
public class wuyanlvshi {
	static public boolean judge_wyls(String str){
		if(str.length()==40&&(pingze1(str)||pingze2(str)||pingze3(str)||pingze4(str))){
			if(yayun(str)){
				return true;
			}
		}
		return false;
	}
	
	//偶数句末尾入韵
	static public boolean yayun(String str){
		char no1=str.charAt(9),no2=str.charAt(19),no3=str.charAt(29),no4=str.charAt(39);
		String first=jintishiBase.returnyun(no1),second=jintishiBase.returnyun(no2),third=jintishiBase.returnyun(no3),forth=jintishiBase.returnyun(no4);
		for(int i=0;i<first.length();i++){
			for(int j=0;j<second.length();j++){
				for(int k=0;k<third.length();k++){
					for(int l=0;l<forth.length();l++){
						if(first.charAt(i)==second.charAt(j)&&first.charAt(i)==third.charAt(k)&&first.charAt(i)==forth.charAt(l)&&second.charAt(j)==third.charAt(k)&&second.charAt(j)==forth.charAt(l)&&third.charAt(k)==forth.charAt(l)){
							System.out.println("符合五言诗律押韵规则");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	static public boolean pingze1(String str){
//		x仄平平仄，平平仄仄平。
//		x平平仄仄，x仄仄平平。
//		x仄平平仄，平平仄仄平。
//		x平平仄仄，x仄仄平平。
		String str1=str.substring(0, 5),str2=str.substring(5, 10),str3=str.substring(10,15),str4=str.substring(15,20),str5=str.substring(20, 25),str6=str.substring(25, 30),str7=str.substring(30, 35),str8=str.substring(35, 40);
		if(xzppz(str1)&&ppzzp(str2)&&xppzz(str3)&&xzzpp(str4)&&xzppz(str5)&&ppzzp(str6)&&xppzz(str7)&&xzzpp(str8)){
			System.out.println("符合五言律诗规则1");
			return true;
		}
		return false;
	}
	
	static public boolean pingze2(String str){
//		x平仄仄平，x仄仄平平。
//		x仄平平仄，平平仄仄平。
//		x平平仄仄，x仄仄平平。
//		x仄平平仄，平平仄仄平.
		String str1=str.substring(0, 5),str2=str.substring(5, 10),str3=str.substring(10,15),str4=str.substring(15,20),str5=str.substring(20, 25),str6=str.substring(25, 30),str7=str.substring(30, 35),str8=str.substring(35, 40);
		if(xpzzp(str1)&&xzzpp(str2)&&xzppz(str3)&&ppzzp(str4)&&xppzz(str5)&&xzzpp(str6)&&xzppz(str7)&&ppzzp(str8)){
			System.out.println("符合五言律诗规则2");
			return true;
		}
		return false;
	}
	
	static public boolean pingze3(String str){
//		x平平仄仄，x仄仄平平。
//		x仄平平仄，平平仄仄平。
//		x平平仄仄，x仄仄平平。
//		x仄平平仄，平平仄仄平.
		String str1=str.substring(0, 5),str2=str.substring(5, 10),str3=str.substring(10,15),str4=str.substring(15,20),str5=str.substring(20, 25),str6=str.substring(25, 30),str7=str.substring(30, 35),str8=str.substring(35, 40);
		if(xppzz(str1)&&xzzpp(str2)&&xzppz(str3)&&ppzzp(str4)&&xppzz(str5)&&xzzpp(str6)&&xzppz(str7)&&ppzzp(str8)){
			System.out.println("符合五言律诗规则3");
			return true;
		}
		return false;
	}
	
	static public boolean pingze4(String str){
//		x仄仄平平，平平仄仄平。
//		x平平仄仄，x仄仄平平。
//		x仄平平仄，平平仄仄平。
//		x平平仄仄，x仄仄平平。
		String str1=str.substring(0, 5),str2=str.substring(5, 10),str3=str.substring(10,15),str4=str.substring(15,20),str5=str.substring(20, 25),str6=str.substring(25, 30),str7=str.substring(30, 35),str8=str.substring(35, 40);
		if(xzzpp(str1)&&ppzzp(str2)&&xppzz(str3)&&xzzpp(str4)&&xzppz(str5)&&ppzzp(str6)&&xppzz(str7)&&xzzpp(str8)){
			System.out.println("符合五言律诗规则4");
			return true;
		}
		return	false;
	}
	
	static public boolean xzppz(String str){
		char no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ze(no2)&&jintishiBase.judge_ping(no3)&&jintishiBase.judge_ping(no4)&&jintishiBase.judge_ze(no5)){
			return true;
		}
		return false;
	}
	static public boolean ppzzp(String str){
		char no1=str.charAt(0),no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ping(no1)&&jintishiBase.judge_ping(no2)&&jintishiBase.judge_ze(no3)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ping(no5)){
			return true;
		}
		return false;
	}
	static public boolean xppzz(String str){
		char no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ping(no2)&&jintishiBase.judge_ping(no3)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ze(no5)){
			return true;
		}
		return false;
	}
	
	static public boolean xzzpp(String str){
		char no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ze(no2)&&jintishiBase.judge_ze(no3)&&jintishiBase.judge_ping(no4)&&jintishiBase.judge_ping(no5)){
			return true;
		}
		return false;
	}
	static public boolean xpzzp(String str){
		char no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ping(no2)&&jintishiBase.judge_ze(no3)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ping(no5)){
			return true;
		}
		return false;
	}
}
