package y;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;
public class GetFile {
	public static void main(String[] args) throws IOException {
		 FileReader fileReader = new FileReader("src\\test.txt");
	     BufferedReader buf = new BufferedReader(fileReader);
		 List<JSONObject> ads=new ArrayList<JSONObject>();	
        String lineTex = "";  
        while((lineTex = buf.readLine()) != null){
           //System.out.println(readLine);
       	String flag=lineTex.substring(0,1);
       	String address=lineTex.substring(2);
       	if(flag.equals("1"))
       	{
       		JSONObject ad= Address.GetAddress1(address);
       		ads.add(ad);

       	}
       	else
       	{
       		JSONObject ad= Address.GetAddress2(address);
       		ads.add(ad);
       	}        	
       }
     //写入相应的文件
       FileWriter fw =  new FileWriter("src\\result.json");
       fw.write("[\r\n");
       for(int i=0; i<ads.size(); i++)
       {
       	JSONObject ad=ads.get(i);
       	System.out.println(ad.toString());
  
       	if(i!=ads.size()-1)
       	{
       		fw.write(ad.toString()+",");
       		fw.write("\r\n");
       	}else
       	{
       		fw.write(ad.toString());
       	}
       	
       	
       }
       fw.write("\r\n]");
       fw.close();
       buf.close();
	}
}
