package jintishimanage;

import net.sourceforge.pinyin4j.*;
import net.sourceforge.pinyin4j.format.*;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

//jintishiJudge.getpinyin(char xx)返回单个字的所有拼音 以 xx.xx.xx.数量 string形式
//jintishiJudge.getyunmu(char xx) 返回单个字的所有韵母 以 xx.xx.xx.数量 string形式
//jintishiJudge.returntype(String xx)返回字符串所对应的诗歌类型
//本算法采用十三辙的方式对近体诗进行格律判断
public class jintishiBase {
	
	static String returnyun(char c){
//		⑴发花辙 包含韵母为 a、ia、ua 的字，如“发、家、花”。 
//		⑵梭波辙 包含韵母为 e、o、uo 的字，如“哥、波、梭”。 
//		⑶也斜辙 包含韵母为 ê、ie、üe 的字，如“唉、斜、约”。 
//		不做 ⑷姑苏辙 包含韵母为 u 的字，如“姑、苏”。 
//		⑸衣期辙 包含韵母为 i、ü 的字，如“衣、十、鱼”。 
//		⑹怀来辙 包含韵母为 ai、uai 的字，如“来、怀”。 
//		⑺灰堆辙 包含韵母为 ei、uei(ui) 的字，如“悲、灰”。 
//		⑻遥迢辙 包含韵母为 ao、iao 的字，如“高、遥”。 
//		⑼由求辙 包含韵母为 ou、iu 的字，如“由、求”。 
//		⑽言前辙 包含韵母为 an、ian、uan、üan 的字，如“班、前、端、冤”。 
//		⑾人辰辙 包含韵母为en in un ün的字,如“人、亲、春、君”。 
//		⑿江阳辙 包含韵母为 ang、iang、uang 的字，如“刚、江、荒”。 
//		⒀中东辙 包含韵母为 eng、ing、weng、ong、iong的字，如“灯、丁、翁、中、穷”。
		StringBuffer buff=new StringBuffer();
		String allyunmu=jintishiBase.getyunmu(c);
		for(int i=0;i<allyunmu.length();i++){
			StringBuffer tmp=new StringBuffer();
			for(;i<allyunmu.length()&&allyunmu.charAt(i)!='.';i++){
				if(allyunmu.charAt(i)>='0'&&allyunmu.charAt(i)<='9'){
					continue;
				}
				tmp.append(allyunmu.charAt(i));
			}
			String str=tmp.toString();
			if(str.equals("a")||str.equals("ia")||str.equals("ua")) buff.append('a');
			else if(str.equals("e")||str.equals("o")||str.equals("uo")) buff.append('b');
			else if(str.equals("ie")||str.equals("ue")) buff.append('c');
			else if(str.equals("u")||str.equals("i")) buff.append('d');
			else if(str.equals("ai")||str.equals("uai")) buff.append('e');
			else if(str.equals("ei")||str.equals("uei")||str.equals("ui")) buff.append('f');
			else if(str.equals("ao")||str.equals("iao")) buff.append('g');
			else if(str.equals("ou")||str.equals("iu")) buff.append('h');
			else if(str.equals("an")||str.equals("ian")||str.equals("uan")) buff.append('i');
			else if(str.equals("en")||str.equals("in")||str.equals("un")) buff.append('j');
			else if(str.equals("ang")||str.equals("iang")||str.equals("uang")) buff.append('k');
			else if(str.equals("eng")||str.equals("ing")||str.equals("ong")||str.equals("iong")) buff.append('l');
			else{
				System.out.print("这种韵在十三辙中找不到正确的对应值:");
				System.out.println(str);
				buff.append('z');
			}
		}
		//处理重复的字符
		String str=buff.toString();
		StringBuffer newbuff=new StringBuffer();
		newbuff.append(str.charAt(0));
		for(int i=1;i<str.length();i++){
			boolean judge=true;
			for(int j=0;j<i;j++){
				if(str.charAt(i)==str.charAt(j)){
					judge=false;
					break;
				}
			}
			if(judge){
				newbuff.append(str.charAt(i));
			}
		}
		return newbuff.toString();
	}
	
	//该函数返回诗歌的类型
		//返回1代表五言绝句
		//返回2代表七言绝句
		//返回3代表五言律诗
		//返回4代表七言律诗
		//返回-1代表不属于近体诗
		static int returntype(String str){
			if(str.length()==20) return 1;
			else if(str.length()==28) return 2;
			else if(str.length()==40) return 3;
			else if(str.length()==56) return 4;
			else return -1;
		}
		
		//返回单个字的所有拼音
		static String getpinyin(char intext){
			StringBuffer target=new StringBuffer();
			HanyuPinyinOutputFormat pinyinoutput=new HanyuPinyinOutputFormat();
			//设置返回的为小写字符
			pinyinoutput.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			//设置返回的为无音调
			pinyinoutput.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
			//设置返回的 u为v
			pinyinoutput.setVCharType(HanyuPinyinVCharType.WITH_V);
			int targetlen=0;
			try{
			String[] tmp=PinyinHelper.toHanyuPinyinStringArray(intext,pinyinoutput);
			for(int i=0;i<tmp.length;i++){
//				boolean judge=true;
//				for(int j=0;j<i;j++){//判断是否和之前的重复
//					if(tmp[i].equals(tmp[j])){
//						judge=false;
//						break;
//					}
//				}
//				if(judge){
				targetlen++;
				target.append(tmp[i]);
				target.append(".");
//				}
			}
			String num=targetlen+"";
			target.append(num);
			}catch(BadHanyuPinyinOutputFormatCombination e){
				e.printStackTrace();
			}
			return target.toString();
		}
		
		static boolean judgeshengmu(char ch){
			//声母如下
			//b、p、m、f、d、t、n、l、g、k、h、j、q、x、zh、ch、sh、z、c、s 、 y、w、r
			//所以首先检测第一个字节是否为b、p、m、f、d、t、n、l、g、k、h、j、q、x、z、c、s 、 y、w、r
			//再检测第二个字节是否为h
			//该函数只检测第一个字节部分
			char [] yunmu={'b','p','m','f','d','t','n','l','g','k','h','j','q','x','z','c','s','y','w','r'};
			for(int i=0;i<20;i++){
				if(ch==yunmu[i]){
					return true;
				}
			}
			return false;
		}
		
		static String getyunmu(char c){
			String str=jintishiBase.getpinyin(c);
			StringBuffer buf=new StringBuffer();
			int len=str.length();
			int num=str.charAt(len-1)-48;//总共有num个发音
			//System.out.print("all:");
			//System.out.println(num);
			for(int i=0;i<len-2;i++){
				if(jintishiBase.judgeshengmu(str.charAt(i))){
					i++;
					if(str.charAt(i)=='h'){
						i++;
					}
					for(;str.charAt(i)!='.'&&i<len-2;i++){
						buf.append(str.charAt(i));
					}
					if(i<len-3)
						buf.append('.');
					//do nothing
				}
				else{
					for(;str.charAt(i)!='.'&&i<len-2;i++){
						buf.append(str.charAt(i));
					}
					if(i<len-3)
						buf.append('.');
					//do nothing
				}
					
			}
			return buf.toString();
		}

		
		//ping return 1,ze return 2,pingze return 3,error return -1
		static int pingze(char c){
			String str=jintishiBase.getpinyin(c);
			int ping=0,ze=0;
			for(int i=0;i<str.length()-2;i++){
				char tmp=str.charAt(i);
				if(tmp=='1'||tmp=='2'||tmp=='5'){
					ping=1;
				}
				if(tmp=='3'||tmp=='4'){					
					ze=1;
				}
			}
			if(ping==0&&ze==0)
				return -1;
			else if(ping==1&&ze==0)
				return  1;
			else if(ping==0&&ze==1)
				return 2;
			else return 3;
		}
		
		static boolean judge_ping(char c){
			String str=jintishiBase.getpinyin(c);
			for(int i=0;i<str.length()-2;i++){
				char tmp=str.charAt(i);
				if(tmp=='1'||tmp=='2'||tmp=='5'){
					return true;
				}
			}
			return false;
		}
		
		static boolean judge_ze(char c){
			//特殊的一些仄声 在古音里面通常以下是发仄生的
			String other_ze="一七八十兀孑勺习夕仆曰什及扑出发札失石节白汁匝竹伏戍伐达杂夹杀夺舌诀决约芍则合宅执吃汐秃足卒局角驳别折灼伯狄即吸劫匣叔竺卓帛国学实直责诘佛屈拔刮拉侠狎押胁杰迭择拍迪析极刷觉急罚逐读哭烛席敌疾积脊捉剥哲捏酌格核贼鸭族渎孰斛淑啄脱掇郭鸽舶职笛袭悉接谍捷辄掐掘菊犊赎幅粥琢厥揭渤割葛筏跋滑猾跌凿博晰棘植殖集逼湿黑答插颊福牍辐督雹厥歇搏窟锡颐楫睫隔谪叠塌漆竭截牒碣摘察辖嫡蜥熟蝠膝瘠骼德蝶瞎额橘辙薛薄缴激擢蟋檄蹶籍黩嚼";
			for(int i=0;i<other_ze.length();i++){
				if(c==other_ze.charAt(i)){
					return true;
				}
			}
			String str=jintishiBase.getpinyin(c);
			boolean judge2=false;
			for(int i=0;i<str.length()-2;i++){
				char tmp=str.charAt(i);
				if(tmp=='2')
					judge2=true;
				if(tmp=='3'||tmp=='4'){
					return true;
				}
				
				//普通话读音为fa、fo的字，都是古入声字（古仄音）。如发、佛、罚、法、伐等。
				if(tmp=='f')
					if(str.charAt(i+1)=='a'||str.charAt(i+1)=='o')
						if(str.charAt(i+2)>='0'&&str.charAt(i+2)<'6')
							return true;
				
				//普通话声母为b、p、d、t、n与韵母“ie”相拼的字除“爹”字外，其余都是古入声字（古仄音）
				if(tmp=='b'||tmp=='p'||tmp=='t'||tmp=='d'||tmp=='n')
						if(str.charAt(i+1)=='i'&&str.charAt(i+2)=='e')
							return true;
				
				//普通话里，凡韵母“ue”的字，除“瘸”、“嗟”字外，其余都是古入声字（古仄音）
				if(tmp=='u'&&str.charAt(i+1)=='e')
					return true;
				
				//普通话里，凡声母d、t、n、l、z、c、s与韵“e”相拼的字，都是古入声字（古仄音）。如策、得、恻、德、勒、讷、责、则、泽、忒、瑟、色等。
				if(tmp=='d'||tmp=='t'||tmp=='n'||tmp=='l'||tmp=='z'||tmp=='c'||tmp=='s')
					if(str.charAt(i+1)=='e'&&str.charAt(i+2)>='0'&&str.charAt(i+2)<'6')
						return true;
		
				//五、普通话里凡声母为k、zh、ch、sh、r与韵母“uo”相拼的字，都是古入声字（古仄音）
				if(tmp=='k'||tmp=='r')
					if(str.charAt(i+1)=='u'&&str.charAt(i+2)=='o')
						return true;
				if(tmp=='z'||tmp=='c'||tmp=='s')
					if(str.charAt(i+1)=='h')
						if(str.charAt(i+2)=='u'&&str.charAt(i+3)=='o')
							return true;
			}
			
				//普通话阳平声（二声）的字里，凡声母为b、d、g、j、z、zh者，都是古入声字（古仄音）。
				if(judge2){
					for(int i=0;i<str.length()-2;i++){
						char tmp=str.charAt(i);
						if(tmp=='b'||tmp=='d'||tmp=='g'||tmp=='j'||tmp=='z')
							return true;
					}
				}
			
			
			return false;
//			if(tmp=='2'){
//				if(tmp=='b'||tmp=='d'||tmp=='g'||tmp=='j'||tmp=='z'){
//					return true;
//				}
//			}
		}
		
	
}
