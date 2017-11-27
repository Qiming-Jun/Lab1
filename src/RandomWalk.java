import java.util.Map;
import java.util.Random;

public class RandomWalk {
	
	private static String txtStr;
	private static String[] strList; 
	private static String[] wordList;
	private static int wordNum;
	
	private static MyGraph g;
	private static Map map;
	
	public static String randomWalk()
	{
		g.removeVisited();
		
		String walkStr = "";
		Random r = new Random();
		
		int index1 = r.nextInt(wordNum);	//��������������
		walkStr = walkStr + wordList[index1] + " ";
		do{
			int[] outDegreeList = g.getOutDegree(index1);	//��øö������
			if(outDegreeList.length == 0) {
				break;
			}
			
			int index2 = outDegreeList[r.nextInt(outDegreeList.length)];
					//��outDegreeList�����ѡ��һ��Ԫ��
			walkStr = walkStr + wordList[index2] + " ";
			
			if(g.IsVisited(index1, index2)) {
				break;
			}
			
			g.setVisited(index1, index2, true);
			
			index1  = index2;
		}while(true);
		
		return walkStr + "\r\n";
	}
}
