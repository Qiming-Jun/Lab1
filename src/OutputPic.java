import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class OutputPic {
	private static String txtStr;
	private static String[] strList; 
	private static String[] wordList;
	private static int wordNum;
	
	private static MyGraph g;
	private static Map map;
	
	OutputPic(final String pathDir) throws IOException{
		 File DotFile = new File(pathDir + "Graph.dot");
		 FileWriter NewFile = new FileWriter(DotFile);
        NewFile.write("digraph abc{\r\n\tnode [shape=\"record\"];\r\n\t");
        
        for(int i = 0; i<wordNum; i++) {
			NewFile.write(wordList[i]+";\r\n\t");
		}
        
        for(int i = 0; i<wordNum; i++) {
			for(int j = 0; j<wordNum; j++)
				 if(g.getEdge(i, j)!=0)
					 NewFile.write(wordList[i]+"->"+wordList[j]
							 +" [ label = \""+g.getEdge(i, j)+"\" ];\r\n\t");
		}
        NewFile.write("}");
        NewFile.close();

	}
}
