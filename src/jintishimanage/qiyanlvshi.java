package jintishimanage;

//xpxzppz
//xzppzzp
//xzxppzz
//xpxzzpp
//judge_qyls
public class qiyanlvshi {
	
	static public boolean judge_qyls(String str){
		if(str.length()==56&&(pingze1(str)||pingze2(str)||pingze3(str)||pingze4(str))){
			if(yayun(str)){
				return true;
			}
		}
		return false;
	}

	static public boolean yayun(String str){
		char no1=str.charAt(13),no2=str.charAt(27),no3=str.charAt(41),no4=str.charAt(55);
		String first=jintishiBase.returnyun(no1),second=jintishiBase.returnyun(no2),third=jintishiBase.returnyun(no3),forth=jintishiBase.returnyun(no4);
		for(int i=0;i<first.length();i++){
			for(int j=0;j<second.length();j++){
				for(int k=0;k<third.length();i++){
					for(int l=0;l<forth.length();l++){
						if(first.charAt(i)==second.charAt(j)&&first.charAt(i)==third.charAt(k)&&first.charAt(i)==forth.charAt(l)&&second.charAt(j)==third.charAt(k)&&second.charAt(j)==forth.charAt(l)&&third.charAt(k)==forth.charAt(l)){
							System.out.println("符合七言诗律押韵规则");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	static public boolean pingze1(String str){
//		x平x仄平平仄，x仄平平仄仄平。
//		x仄x平平仄仄，x平x仄仄平平。
//		x平x仄平平仄，x仄平平仄仄平。
//		x仄x平平仄仄，x平x仄仄平平。
		String str1=str.substring(0, 7),str2=str.substring(7, 14),str3=str.substring(14, 21),str4=str.substring(21,28),str5=str.substring(28, 35),str6=str.substring(35, 42),str7=str.substring(42, 49),str8=str.substring(49, 56);
		if(xpxzppz(str1)&&xzppzzp(str2)&&xzxppzz(str3)&&xpxzzpp(str4)&&xpxzppz(str5)&&xzppzzp(str6)&&xzxppzz(str7)&&xpxzzpp(str8)){
			System.out.println("符合七言律诗规则1");
			return true;
		}
		return false;
	}
	
	static public boolean pingze2(String str){
//		x仄平平仄仄平，x平x仄仄平平。
//		x平x仄平平仄，x仄平平仄仄平。
//		x仄x平平仄仄，x平x仄仄平平。 
//		x平x仄平平仄，x仄平平仄仄平.
		String str1=str.substring(0, 7),str2=str.substring(7, 14),str3=str.substring(14, 21),str4=str.substring(21,28),str5=str.substring(28, 35),str6=str.substring(35, 42),str7=str.substring(42, 49),str8=str.substring(49, 56);
		if(xzppzzp(str1)&&xpxzzpp(str2)&&xpxzppz(str3)&&xzppzzp(str4)&&xzxppzz(str5)&&xpxzzpp(str6)&&xpxzppz(str7)&&xzppzzp(str8)){
			System.out.println("符合七言律诗规则2");
			return true;
		}
		return false;
	}
	
	static public boolean pingze3(String str){
//		x仄x平平仄仄，x平x仄仄平平。
//		x平x仄平平仄，x仄平平仄仄平。
//		x仄x平平仄仄，x平x仄仄平平。
//		x平x仄平平仄，x仄平平仄仄平。
		String str1=str.substring(0, 7),str2=str.substring(7, 14),str3=str.substring(14, 21),str4=str.substring(21,28),str5=str.substring(28, 35),str6=str.substring(35, 42),str7=str.substring(42, 49),str8=str.substring(49, 56);
		if(xzxppzz(str1)&&xpxzzpp(str2)&&xpxzppz(str3)&&xzppzzp(str4)&&xzxppzz(str5)&&xpxzzpp(str6)&&xpxzppz(str7)&&xzppzzp(str8)){
			System.out.println("符合七言律诗规则3");
			return true;
		}
		return false;
	}
	
	static public boolean pingze4(String str){
//		x平x仄仄平平，x仄平平仄仄平。
//		x仄x平平仄仄，x平x仄仄平平。
//		x平x仄平平仄，x仄平平仄仄平。
//		x仄x平平仄仄，x平x仄仄平平。
		String str1=str.substring(0, 7),str2=str.substring(7, 14),str3=str.substring(14, 21),str4=str.substring(21,28),str5=str.substring(28, 35),str6=str.substring(35, 42),str7=str.substring(42, 49),str8=str.substring(49, 56);
		if(xpxzzpp(str1)&&xzppzzp(str2)&&xzxppzz(str3)&&xpxzzpp(str4)&&xpxzppz(str5)&&xzppzzp(str6)&&xzxppzz(str7)&&xpxzzpp(str8)){
			System.out.println("符合七言律诗规则1");
			return true;
		}
		return false;
	}
	
	static public boolean xzppzzp(String str){
		char no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4),no6=str.charAt(5),no7=str.charAt(6);
		if(jintishiBase.judge_ze(no2)&&jintishiBase.judge_ping(no3)&&jintishiBase.judge_ping(no4)&&jintishiBase.judge_ze(no5)&&jintishiBase.judge_ze(no6)&&jintishiBase.judge_ping(no7)){
			return true;
		}
		return false;
	}
	
	static public boolean xzxppzz(String str){
		char no2=str.charAt(1),no4=str.charAt(3),no5=str.charAt(4),no6=str.charAt(5),no7=str.charAt(6);
		if(jintishiBase.judge_ze(no2)&&jintishiBase.judge_ping(no4)&&jintishiBase.judge_ping(no5)&&jintishiBase.judge_ze(no6)&&jintishiBase.judge_ze(no7)){
			return true;
		}
		return false;
	}
	
	static public boolean xpxzzpp(String str){
		char no2=str.charAt(1),no4=str.charAt(3),no5=str.charAt(4),no6=str.charAt(5),no7=str.charAt(6);
		if(jintishiBase.judge_ping(no2)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ze(no5)&&jintishiBase.judge_ping(no6)&&jintishiBase.judge_ping(no7)){
			return true;
		}
		return false;
	}
	
	static public boolean xpxzppz(String str){
		char no2=str.charAt(1),no4=str.charAt(3),no5=str.charAt(4),no6=str.charAt(5),no7=str.charAt(6);
		if(jintishiBase.judge_ping(no2)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ping(no5)&&jintishiBase.judge_ping(no6)&&jintishiBase.judge_ze(no7)){
			return true;
		}
		return false;
	}
	
}
