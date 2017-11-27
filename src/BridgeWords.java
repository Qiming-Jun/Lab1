import java.util.Map;

public class BridgeWords {
	private static String txtStr;
	private static String[] strList; 
	private static String[] wordList;
	private static int wordNum;
	
	private static MyGraph g;
	private static Map map;
	
	public static String queryBridgeWords(final String word1, final String word2)
	{
		String strReturn = "";
	//	int v0, v1;
		
		if(!map.containsKey(word1) && !map.containsKey(word2))
		{
			strReturn = "No \"" + word1 + "\" and \"" + word2 +
					"\" in the graph!\r\n";
			return strReturn;
		}
		
		if(!map.containsKey(word1))
		{
			strReturn = "No \"" + word1 + "\" in the graph!\r\n";
			return strReturn;
		}
		
		if(!map.containsKey(word2))
		{
			strReturn = "No \"" + word2 + "\" in the graph!\r\n";
			return strReturn;
		}
		
		int v0 = (int)(map.get(word1));
		int v1 = (int)(map.get(word2));
		int[] bridgeList = g.getBridge(v0, v1);
		
		if(bridgeList.length == 0){
			strReturn = strReturn + "No bridge words from " + 
					"\"" + word1 + "\" to \"" +  word2 + "\"!" + "\r\n";
			return strReturn;
		}
		
		strReturn = strReturn + "The bridge words from \"" + word1 + "\" to \"" 
		+word2 + "\" is: ";
		for(int i = 0; i<bridgeList.length; i++) {
			strReturn = strReturn + wordList[bridgeList[i]] + " ";
		}
		strReturn = strReturn + "\r\n";
		
		return strReturn;
	}

}
