package jintishimanage;

import net.sourceforge.pinyin4j.*;
import net.sourceforge.pinyin4j.format.*;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

//jintishiJudge.getpinyin(char xx)返回单个字的所有拼音 以 xx.xx.xx.数量 string形式
//jintishiJudge.getyunmu(char xx) 返回单个字的所有韵母 以 xx.xx.xx.数量 string形式
//jintishiJudge.returntype(String xx)返回字符串所对应的诗歌类型


public class pinyinfun {

	public static void main(String[] args) {

		
		String str1="白日依山尽黄河入海流欲穷千里目更上一层楼";//五言绝句规则1
		String str2="北斗七星高哥舒夜带刀至今窥牧马不敢过临洮";//五言绝句规则2
		String str3="鸣筝金粟柱素手玉房前欲得周郎顾时时误拂弦";//五言绝句规则3
		String str4="花明绮陌春柳拂御沟新为报辽阳客流芳不待人";//五言绝句规则4
		
		String str5="独在异乡为异客每逢佳节倍思亲遥知兄弟登高处遍插茱萸少一人";//七言绝句规则1
		String str6="君问归期未有期巴山夜雨涨秋池何当共剪西窗烛却话巴山夜雨时";//七言绝句规则2
		String str7="禁门宫树月痕过媚眼惟看宿鹭窠斜拔玉钗灯影畔剔开红焰救飞蛾";//七言绝句规则3
		String str8="秦时明月汉时关万里长征人未还但使龙城飞将在不教胡马度阴山";//七言绝句规则4
		
		String str9="细草微风岸危樯独夜舟星垂平野阔月涌大江流名岂文章著官应老病休飘飘何所似天地一沙鸥";//五言律诗规则1
		
		String test="禁门宫树月痕过媚眼惟看宿鹭窠斜拔玉钗灯影畔剔开红焰救飞蛾";
		String str="巴山楚水凄凉地二十三年弃置身怀旧空吟闻笛赋到乡翻似烂柯人沉舟侧畔千帆过病树前头万木春今日听君歌一曲暂凭杯酒长精神";
		

//		System.out.println(jintishiBase.returnyun('舟'));
//		System.out.println(jintishiBase.returnyun('流'));
//		System.out.println(jintishiBase.returnyun('休'));
//		System.out.println(jintishiBase.returnyun('鸥'));
//		System.out.println(wuyanlvshi.yayun("细草微风岸危樯独夜舟星垂平野阔月涌大江流名岂文章著官应老病休飘飘何所似天地一沙鸥"));
		System.out.println(qiyanjueju.judge_qyjj(str2));


		
		
	}

}
//System.out.println(jintishiBase.returntype(str));
//char target='和';
//System.out.println(jintishiBase.getpinyin(target));
//String test="123456";
//int num=test.charAt(5)-48;
//System.out.println(wuyanjueju.judge_wyjj(str));
//System.out.println(jintishiBase.returnyun('和'));
//String str="e";