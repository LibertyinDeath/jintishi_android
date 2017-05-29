package jintishimanage;


//调用static public boolean judge_wyjj(String str)方法即可判断一首诗是不是属于五言绝句

//xzppz
//ppxzp
//ppzzp
//xppzz
//xzzpp
//pppzz
//xpzzp
//rule_one(String str)	(pingze1,yun1)
//rule_two(String str)	(pingze2,yun2) 
//rule_three(String str)	(pingze3,yun3) 
//rule_four(String str)	(pingze4,yun4)
//judge_wyjj(String str)
public class wuyanjueju {
	
	static public boolean judge_wyjj(String str){
	if(str.length()==20&&(rule_one(str)||rule_two(str)||rule_three(str)||rule_four(str))){
		return true;
	}
		return false;
	}
	
	static public boolean rule_one(String str){
//		x仄平平仄，平平x仄平
//		x平平仄仄，x仄仄平平
//		二四局末尾押韵
		if(yun1(str)&&pingze1(str)){
			System.out.println("符合五言规则1:x仄平平仄，平平x仄平。x平平仄仄，x仄仄平平。二四句末尾押韵");
			return true;
		}
		return false;
	}
	
	static public boolean rule_two(String str){
//		x仄仄平平，平平x仄平
//		x平平仄仄，x仄仄平平
//		一二四句末尾押韵
		if(yun2(str)&&pingze2(str)){
			System.out.println("符合五言规则2：x仄仄平平，平平x仄平。x平平仄仄，x仄仄平平。一二四句末尾押韵");
			return true;
		}
		return false;
	}
	
	static public boolean  rule_three(String str){
//		x平平仄仄，x仄仄平平
//		x仄平平仄，平平x仄平
//		二四句末尾押韵
		if(yun3(str)&&pingze3(str)){
			System.out.println("符合五言规则3：x平平仄仄，x仄仄平平。x仄平平仄，平平x仄平。二四句末尾押韵");
			return true;
		}
		return false;
	}
	
	static public boolean rule_four(String  str){
//		平平x仄平，x仄仄平平
//		x仄平平仄，平平x仄平
//		一二四句末尾押韵
		if(yun4(str)&&pingze4(str)){
			System.out.println("符合五言规则4：平平x仄平，x仄仄平平。x仄平平仄，平平x仄平。一二四句末尾押韵");
			return true;
		}
		return false;
	}
	//二四句末尾押韵
	static public boolean yun1(String str){
		char target_first=str.charAt(9),target_second=str.charAt(19);
		String first=jintishiBase.returnyun(target_first),second=jintishiBase.returnyun(target_second);
		for(int i=0;i<first.length();i++){
			for(int j=0;j<second.length();j++){
				if(first.charAt(i)==second.charAt(j)){
					return true;
				}
			}
		}
		return false;
	}
	//一二四句末尾押韵
	static public boolean yun2(String str){
		char target_first=str.charAt(4),target_second=str.charAt(9),target_third=str.charAt(19);
		String first=jintishiBase.returnyun(target_first),second=jintishiBase.returnyun(target_second),third=jintishiBase.returnyun(target_third);
		for(int i=0;i<first.length();i++){
			for(int j=0;j<second.length();j++){
				for(int k=0;k<third.length();k++){
					if(first.charAt(i)==second.charAt(j)&&first.charAt(i)==third.charAt(k)&&second.charAt(j)==third.charAt(k)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//二四句末尾押韵
	static public boolean yun3(String str){
		char target_first=str.charAt(9),target_second=str.charAt(19);
		String first=jintishiBase.returnyun(target_first),second=jintishiBase.returnyun(target_second);
		for(int i=0;i<first.length();i++){
			for(int j=0;j<second.length();j++){
				if(first.charAt(i)==second.charAt(j)){
					return true;
				}
			}
		}
		return false;
	}
	
	//一二四句末尾押韵
		static public boolean yun4(String str){
			char target_first=str.charAt(4),target_second=str.charAt(9),target_third=str.charAt(19);
			String first=jintishiBase.returnyun(target_first),second=jintishiBase.returnyun(target_second),third=jintishiBase.returnyun(target_third);
			for(int i=0;i<first.length();i++){
				for(int j=0;j<second.length();j++){
					for(int k=0;k<third.length();k++){
						if(first.charAt(i)==second.charAt(j)&&first.charAt(i)==third.charAt(k)&&second.charAt(j)==third.charAt(k)){
							return true;
						}
					}
				}
			}
			return false;
		}
		
	static public boolean pingze1(String str){
		//	x仄平平仄，平平x仄平
		//	x平平仄仄，x仄仄平平
		String str1=str.substring(0, 5),str2=str.substring(5,10),str3=str.substring(10, 15),str4=str.substring(15, 20);
		if(xzppz(str1)&&ppxzp(str2)&&xppzz(str3)&&xzzpp(str4)){
			//System.out.println("suc:1");
			return true;
		}
		//System.out.println("err:1");
		return false;
	}
	
	static public boolean pingze2(String str){
		//x仄仄平平，平平x仄平
		//x平平仄仄，x仄仄平平
		String str1=str.substring(0, 5),str2=str.substring(5,10),str3=str.substring(10, 15),str4=str.substring(15, 20);
		if(xzzpp(str1)&&ppxzp(str2)&&xppzz(str3)&&xzzpp(str4)){
			//System.out.println("suc:2");
			return true;
		}
		//System.out.println("err:2");
		return false;
	}
	
	static public boolean pingze3(String str){
		//x平平仄仄，x仄仄平平
		//x仄平平仄，平平x仄平
		String str1=str.substring(0, 5),str2=str.substring(5,10),str3=str.substring(10, 15),str4=str.substring(15, 20);
		if(xppzz(str1)&&xzzpp(str2)&&xzppz(str3)&&ppxzp(str4)){
			//System.out.println("suc:3");
			return true;
		}
		//System.out.println("err:3");
		return false;
	}
	
	static public boolean pingze4(String str){
		//平平x仄平，x仄仄平平
		//x仄平平仄，平平x仄平
		String str1=str.substring(0, 5),str2=str.substring(5,10),str3=str.substring(10, 15),str4=str.substring(15, 20);
		if(ppxzp(str1)&&xzzpp(str2)&&xzppz(str3)&&ppxzp(str4)){
			//System.out.println("suc:4");
			return true;
		}
		//System.out.println("err:4");
		return false;
	}
	
	static public boolean xzppz(String str){
		char no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ze(no2)&&jintishiBase.judge_ping(no3)&&jintishiBase.judge_ping(no4)&&jintishiBase.judge_ze(no5)){
			return true;
		}
		return false;
	}
	
	static public boolean ppxzp(String str){
		char no1=str.charAt(0),no2=str.charAt(1),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ping(no1)&&jintishiBase.judge_ping(no2)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ping(no5)){
			return true;
		}
		return false;
	}
	
//	static public boolean ppzzp(String str){
//		char no1=str.charAt(0),no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
//		if(jintishiBase.judge_ping(no1)&&jintishiBase.judge_ping(no2)&&jintishiBase.judge_ze(no3)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ping(no5)){
//			return true;
//		}
//		return false;
//	}
	
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
	
	static public boolean pppzz(String str){
		char no1=str.charAt(0),no2=str.charAt(1),no3=str.charAt(2),no4=str.charAt(3),no5=str.charAt(4);
		if(jintishiBase.judge_ping(no1)&&jintishiBase.judge_ping(no2)&&jintishiBase.judge_ping(no3)&&jintishiBase.judge_ze(no4)&&jintishiBase.judge_ze(no5)){
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
