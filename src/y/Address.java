package y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;
public class Address {
	static String h="黑龙江";
    public static JSONObject GetAddress1(String str)
    {

		JSONObject object = new JSONObject();
		//姓名
		int x=str.indexOf('.');
		str=str.substring(0,x);
		int index = str.indexOf(',');
		String name = str.substring(0,index);
		object.put("姓名",name);	
		str = str.substring(index+1);
		
		//获取电话号码
		Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
		Matcher matcher = pattern.matcher(str);
		matcher.find();
			String phone = matcher.group();
			object.put("手机",phone);
			//将电话号码从地址中删除
			str = str.replaceAll(phone, "");
		
		String s="";
		//获取省份
		String province="";
		if(str.indexOf("自治区")!=-1)
		{
			province=str.substring(0, str.indexOf("自治区")+3);
			str=str.substring(str.indexOf("自治区")+3);
		}
		else if(str.indexOf("行政区")!=-1)
		{
			province=str.substring(0, str.indexOf("行政区")+3);
			str=str.substring(str.indexOf("行政区")+3);
		}	
		else if(str.indexOf("省")!=-1)
		{
			province=str.substring(0, str.indexOf("省")+1);
			str=str.substring(str.indexOf("省")+1);
		}
		else if(str.indexOf("北京")!=-1)
			province="北京";
		else if(str.indexOf("天津")!=-1)
			province="天津";
		else if(str.indexOf("上海")!=-1)
			province="上海";
		else if(str.indexOf("重庆")!=-1)
			province="重庆";
		else
		{
			String f="";
			
			f=str.substring(0,3);
			if(f.equals(h))  //h代表黑龙江
			{
				province=str.substring(0,3)+"省";
				str=str.substring(3);
			
			}
			else
			{
				province=str.substring(0,2)+"省";
				str=str.substring(2);
			}
		}
		s+="[\""+province+"\",";
		
		//提取市
		String city="";
		if(str.indexOf("市")!=-1)
		{
			city=str.substring(0, str.indexOf("市")+1);
			str=str.substring(str.indexOf("市")+1);
		}else
		{
			if(str.indexOf("县")!=-1)
			{
				String t="";
				t=str.substring(0, str.indexOf("县")+1);
				int l=t.length();
				if(l>4)
				{
					city=str.substring(0,2)+"市";
					str=str.substring(2);
				}
			}
			else if(str.indexOf("区")!=-1)
			{
				city=str.substring(0,2)+"市";
				str=str.substring(2);
			}
			
		}
		s+="\""+city+"\",";
		
		//提取区县
		String region="";
		if(str.indexOf("区")!=-1)
		{
			region=str.substring(0, str.indexOf("区")+1);
			str=str.substring(str.indexOf("区")+1);
		}else if(str.indexOf("县")!=-1)
		{
			region=str.substring(0, str.indexOf("县")+1);
			str=str.substring(str.indexOf("县")+1);
		}
		else if(str.indexOf("市")!=-1)
		{
			region=str.substring(0, str.indexOf("市")+1);
			str=str.substring(str.indexOf("市")+1);
		}
		s+="\""+region+"\",";
		
		//提取街道/镇
		String town="";
		if(str.indexOf("街道")!=-1)
		{
			town=str.substring(0, str.indexOf("街道")+2);
			str=str.substring(str.indexOf("街道")+2);
		}else if(str.indexOf("镇")!=-1)
		{
			town=str.substring(0, str.indexOf("镇")+1);
			str=str.substring(str.indexOf("镇")+1);
		}
		else if(str.indexOf("乡")!=-1)
		{
			town=str.substring(0, str.indexOf("乡")+1);
			str=str.substring(str.indexOf("乡")+1);
		}
		s+="\""+town+"\",";

		s+="\""+str+"\"]";
		object.put("地址",s);
		return object;
}
    public static JSONObject GetAddress2(String str)
	{
		JSONObject object = new JSONObject();
		//获取姓名
		int x=str.indexOf('.');
		str=str.substring(0,x);
		int index = str.indexOf(',');
		String name = str.substring(0,index);
		object.put("姓名",name);
		
		str = str.substring(index+1);
		
		//获取电话号码
		 // 将给定的正则表达式编译到模式中
		Pattern pattern = Pattern.compile("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}");
		// 创建匹配给定输入与此模式的匹配器。
		Matcher matcher = pattern.matcher(str);
		//查找字符串中是否有符合的子字符串
		while(matcher.find()){
		    //得到电话号码
			String phone = matcher.group();
		
			object.put("手机",phone);
			//将电话号码从地址中切除
			str = str.substring(0,matcher.start(0))+str.substring(matcher.end(0));
			
			break;
		}
		String s="";
		//获取省份
		String province="";
		if(str.indexOf("自治区")!=-1)
		{
			province=str.substring(0, str.indexOf("自治区")+3);
			str=str.substring(str.indexOf("自治区")+3);
		}
		else if(str.indexOf("行政区")!=-1)
		{
			province=str.substring(0, str.indexOf("行政区")+3);
			str=str.substring(str.indexOf("行政区")+3);
		}	
		else if(str.indexOf("省")!=-1)
		{
			province=str.substring(0, str.indexOf("省")+1);
			str=str.substring(str.indexOf("省")+1);
		}
		else if(str.indexOf("北京")!=-1)
			province="北京";
		else if(str.indexOf("天津")!=-1)
			province="天津";
		else if(str.indexOf("上海")!=-1)
			province="上海";
		else if(str.indexOf("重庆")!=-1)
			province="重庆";
		else
		{
			String ff="";
			ff=str.substring(0,3);
			if(ff.equals(h))
			{
				province=str.substring(0,3)+"省";
				str=str.substring(3);
			}
			else
			{
				province=str.substring(0,2)+"省";
				str=str.substring(2);
			}
		}
		s+="[\""+province+"\",";
		
		//提取市
		String city="";
		if(str.indexOf("市")!=-1)
		{
			city=str.substring(0, str.indexOf("市")+1);
			str=str.substring(str.indexOf("市")+1);
		}else
		{
			if(str.indexOf("县")!=-1)
			{
				String tt="";
				tt=str.substring(0, str.indexOf("县")+1);
				int ll=tt.length();
				if(ll>4)
				{
					city=str.substring(0,2)+"市";
					str=str.substring(2);
				}
			}
			else if(str.indexOf("区")!=-1)
			{
				city=str.substring(0,2)+"市";
				str=str.substring(2);
			}
		}
		s+="\""+city+"\",";
		
		//提取区县
		String region="";
		if(str.indexOf("区")!=-1)
		{
			region=str.substring(0, str.indexOf("区")+1);
			str=str.substring(str.indexOf("区")+1);
		}else if(str.indexOf("县")!=-1)
		{
			region=str.substring(0, str.indexOf("县")+1);
			str=str.substring(str.indexOf("县")+1);
		}else if(str.indexOf("市")!=-1)
		{
			region=str.substring(0, str.indexOf("市")+1);
			str=str.substring(str.indexOf("市")+1);
		}
		s+="\""+region+"\",";
		
		//提取街道/镇
		String town="";
		if(str.indexOf("街道")!=-1)
		{
			town=str.substring(0, str.indexOf("街道")+2);
			str=str.substring(str.indexOf("街道")+2);
		}else if(str.indexOf("镇")!=-1)
		{
			town=str.substring(0, str.indexOf("镇")+1);
			str=str.substring(str.indexOf("镇")+1);
		}
		else if(str.indexOf("乡")!=-1)
		{
			town=str.substring(0, str.indexOf("乡")+1);
			str=str.substring(str.indexOf("乡")+1);
		}
		s+="\""+town+"\",";
		
		//提取路
		String way="";
		if(str.indexOf("路")!=-1)
		{
			way=str.substring(0, str.indexOf("路")+1);
			str=str.substring(str.indexOf("路")+1);
		}else if(str.indexOf("街")!=-1)
		{
			way=str.substring(0, str.indexOf("街")+1);
			str=str.substring(str.indexOf("街")+1);
		}else if(str.indexOf("巷")!=-1)
		{
			way=str.substring(0, str.indexOf("巷")+1);
			str=str.substring(str.indexOf("巷")+1);
		}
		s+="\""+way+"\",";
		
		//提取门牌号
		String tablet="";
		if(str.indexOf("号")!=-1)
		{
			tablet=str.substring(0, str.indexOf("号")+1);
			str=str.substring(str.indexOf("号")+1);
		}
		s+="\""+tablet+"\",";
		s+="\""+str+"\"]";
		object.put("地址",s);
		return object;
	}

}
