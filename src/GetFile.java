import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class GetFile {
	
	private static String txtStr;
	private static String[] strList; 
	private static String[] wordList;
	private static int wordNum;
	
	private static MyGraph g;
	private static Map map;
	
	private static boolean GetFile(final String fileName) throws IOException {
		File rf0 = new File(fileName);		//�ж��ļ��Ƿ����
		if(!rf0.exists()) {
			return false;
		}
		
		FileInputStream rf = new FileInputStream(fileName);
		
		byte[] buffer = new byte[rf.available()];	//��ȡ���ļ�β
		while(rf.read(buffer)!=-1)
		{
		//	System.out.print(new String(buffer));
			continue;
		}
		txtStr = new String(buffer);
	//	System.out.print(txtStr);		//
		rf.close();
		
		return true;
	}
}
