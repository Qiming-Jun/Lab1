import java.util.Map;

public class ShortestPath {
	
	private static String txtStr;
	private static String[] strList; 
	private static String[] wordList;
	private static int wordNum;
	
	private static MyGraph g;
	private static Map map;
	
	public static String calcShortestPath(final String word1, final String word2)
	{
		if(!map.containsKey(word1) || !map.containsKey(word2)) {
			return "Words not exist!\r\n";
		}
		
		int v0 = (int)map.get(word1);
		int v1 = (int)map.get(word2);
		
		int[] path = g.getDisPath(v0, v1);
		
		if(path==null) {
			return "No path from "+"\""+word1+"\" to \""+word2+"\"!\r\n";
		}
		
		String pathStr = "";
		int i;
		for(i = 0; i<path.length - 1; i++){
			pathStr = pathStr + wordList[path[i]] + " -> ";
		}
		pathStr = pathStr + wordList[path[i]] + "\r\n";
		
		return pathStr;
		
	}
	
	public static String calcShortestPath(final String word)
	{
		if(!map.containsKey(word)) {
			return "Words not exist!\r\n";
		}
		
		int v = (int)map.get(word);
	//	int v1 = (int)map.get(word2);
		String pathStr = "";
		for(int i = 0; i<wordNum; i++){
		//	if(g.getEdge(v, i)==0)	continue;
			
			int[] path = g.getDisPath(v, i);
			if(path==null)
			 {
				continue;	//两单词之间无路径
			}
			
			pathStr = pathStr + wordList[v] + " to " + wordList[i] + ": ";
			int j;
			for(j = 0; j<path.length - 1; j++){
				pathStr = pathStr + wordList[path[j]] + " -> ";
			}
			pathStr = pathStr + wordList[path[j]] + "\r\n\n";
			
		}
		
		return pathStr;
		
	}
}
