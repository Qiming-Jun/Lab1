import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Hello1 {
		private static String txtStr;
		private static String[] strList; 
		private static String[] wordList;
		private static int wordNum;
		
		private static MyGraph g;
		private static Map map;
		
		private static String[] strSplit(final String txtStr_this) {
			StringBuffer tmpStr = new StringBuffer();
			
			for(int i=0; i<txtStr_this.length(); i++)
			{
				char c = txtStr_this.charAt(i);
				if(c>='A' && c<='Z') {
					tmpStr.append((char)(c+32));	//´óÐ´×ÖÄ¸×ªÐ¡Ð´
				} else if(c>='a' && c<='z') {
					tmpStr.append(c);
				} else {
					tmpStr.append(' ');
				}
			}
			
		//	strList = (new String(tmpStr)).split("     |    |   |  | ");
			return (new String(tmpStr)).split("     |    |   |  | ");
		}
		
		public static String GetTxtStr()
		{
			return txtStr;
		}
		
		private static void setGraph()
		{
		//	Map<String,int> map = new HashMap<String,int>();
			map = new HashMap();
			
			wordNum = 0;
			wordList = new String[txtStr.length()];
			for(int i = 0; i<strList.length; i++)
			{
				if(!map.containsKey(strList[i]))
				{
					map.put(strList[i], wordNum);
					wordList[wordNum] = strList[i];
					wordNum++;
					
				}
			}
			
			g = new MyGraph(wordNum);
			for(int i=0; i<strList.length - 1; i++)
			{
				int v0 = (int)(map.get(strList[i]));
				int v1 = (int)(map.get(strList[i+1]));
				int cost = g.getEdge(v0, v1);
				
				g.setEdge(v0, v1, cost+1);
			}
		//	return g;
					
		}
		
		
		public static void InitMain(final String path) throws IOException
		{
			GetFile(path);
			strList = strSplit(txtStr);
			setGraph();
		
		}		
}
