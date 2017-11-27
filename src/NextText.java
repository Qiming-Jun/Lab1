import java.util.Map;

public class NextText {
	
	private static String txtStr;
	private static String[] strList; 
	private static String[] wordList;
	private static int wordNum;
	
	private static MyGraph g;
	private static Map map;
	
	public static String generateNewText(final String inputText)
	{
		String[] inputTxtList = Hello1.strSplit(inputText);
		StringBuffer newString = new StringBuffer();
		
		if(inputTxtList.length == 1)
		 {
			return inputTxtList[0];	//只有一个单词的情况
		}
		
		int i;
		for(i = 0; i<inputTxtList.length - 1; i++){
			String word1 = inputTxtList[i];
			String word2 = inputTxtList[i+1];
			newString.append(word1+" ");
			
			if(map.containsKey(word1) && map.containsKey(word2)){
				int[] bridgeList =g.getBridge((int)map.get(word1), (int)map.get(word2));
				if(bridgeList.length != 0){
					newString.append(wordList[bridgeList[0]]+" ");
				}
			}
		}
		newString.append(inputTxtList[i]);
		
		return (new String(newString));
	}
}
