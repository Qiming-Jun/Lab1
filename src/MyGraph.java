
public class MyGraph {
	
	class Edges{
		public int Cost;
		public boolean visited; 
		public Edges(){				//初始化图
			this.Cost = 0;
			this.visited = false;
		}
	}
	
//	private int[][] edges;		
	private	Edges[][] edges;		//图结构的邻接矩阵
	private int vertexNum;			//图的结点个数
	
	private int[][] D;				//Folyd算法的最短路径大小矩阵
	private int[][] P;				//Folyd算法的最短路径前置矩阵
	private boolean FloydFlag;		//判断是否经过floyd算法处理过
	
	public MyGraph(final int vertices)
	{
		vertexNum = vertices;
		
	//	edges = new int[vertices][vertices];
		edges = new Edges[vertices][vertices];
		for(int i=0; i<vertices; i++) {
			{
				{
					{
						{
							for(int j=0; j<vertices; j++)
							{
								edges[i][j] = new Edges();
							//	edges[i][j].Cost = 0;
							//	edges[i][j] = 0;
							}
						}
					}
				}
			}
		}
		FloydFlag = false;
		
	}
	
	public final void setEdge(final int i, final int j, final int cost)
	{
	//	edges[i][j] = cost;
		edges[i][j].Cost = cost;
	}
	
	public final int getEdge(final int i, final int j)
	{
	//	return edges[i][j];
		return edges[i][j].Cost;
	}
	
	public final int[] getBridge(final int head, final int tail)
	{
		int[] bridgeList;
		int num = 0;
		int j = 0;
		for(int i=0; i<edges.length; i++) {
			{
				{
					{
						{
							if(head!=i && tail!=i && edges[head][i].Cost!=0 && edges[i][tail].Cost!=0)
						//	if(head!=i && tail!=i && edges[head][i]!=0 && edges[i][tail]!=0)
								num++;
						}
					}
				}
			}
		}
		
		bridgeList = new int[num];
		
		for(int i=0; i<edges.length; i++) {
			{
				{
					{
						{
							//	if(head!=i && tail!=i && edges[head][i]!=0 && edges[i][tail]!=0)
							if(head!=i && tail!=i && edges[head][i].Cost!=0 && edges[i][tail].Cost!=0)
								bridgeList[j++] = i;
						}
					}
				}
			}
		}
		
		return bridgeList;
	}
	
	public final int[] getOutDegree(final int v)
	{
	//	for(int i = 0; i<vertexNum; i++)		//重新初始化visited
	//		for(int j = 0; j<vertexNum; j++)
	//			edges[i][j].Visited = false;
		
		if(v >= vertexNum) {
			return null;
		}
		
		int count1 = 0;
		for(int i = 0; i<vertexNum; i++) {
			{
				{
					{
						{
							if(edges[v][i].Cost != 0)
						//	if(edges[v][i] != 0)
								count1++;				//此处count用来计算出度
						}
					}
				}
			}
		}
		int[] outDegreeList = new int[count1];
		
		int count2 = 0;					//此处count用来给outDegreeList添加元素
		for(int i = 0; i<vertexNum; i++) {
			{
				{
					{
						{
							if(edges[v][i].Cost != 0)			//0  or integer.max
								outDegreeList[count2++] = i;//edges[v][i].Cost;
						}
					}
				}
			}
		}
		
		return outDegreeList;
	}
	
	public final boolean IsVisited(final int head, final int tail)
	{
		if(head>=vertexNum || tail>=vertexNum) {
			return false;
		}
		
		return edges[head][tail].visited;
	}
	
	public final void setVisited(final int head, final int tail, final boolean flag)
	{
		edges[head][tail].visited = flag;
	}
	
	public final void removeVisited()
	{
		for(int i = 0; i<vertexNum; i++) {
			{
				{
					{
						{
							for(int j = 0; j<vertexNum; j++)
								edges[i][j].visited = false;
						}
					}
				}
			}
		}
	}
	
	private void Floyd()
	{
		P = new int[vertexNum][vertexNum];
		D = new int[vertexNum][vertexNum];
		
	     for (int i = 0; i < vertexNum; i++) {//初始化D，p  
	         for (int j = 0; j < vertexNum; j++) {  
	             if (edges[i][j].Cost != 0){
	                 P[i][j] = j;
	                 D[i][j] = edges[i][j].Cost;
	            //     P[i][j] = i==j ? j : -1;
	             }
	             else{
	            	 P[i][j] = i==j ? j : -1;
	             //    P[i][j] = -1;  
	                 D[i][j] = i==j ? 0 : Integer.MAX_VALUE;
	             }
	         }  
	     }  
	  
	     for (int x = 0; x < vertexNum; x++) {//进行Floyd算法，从0到n-1所有可能进行遍历  
	         for (int i = 0; i < vertexNum; i++) {  
	             for (int j = 0; j < vertexNum; j++) {  
	                 if (D[i][x] != Integer.MAX_VALUE && D[x][j] != Integer.MAX_VALUE &&
	                		 D[i][j] > D[i][x] + D[x][j]) {  
	                     D[i][j] = D[i][x] + D[x][j];  
	                     P[i][j] = P[i][x];  
	                 }  
	             }  
	         }  
	     }
	     
	     FloydFlag = true;
	}
	
	public final int[] getDisPath(final int source, final int target)
	{
		if(!FloydFlag) {
			Floyd();
		}
		
		if(source >= vertexNum || target >= vertexNum || P[source][target] == -1) {
			return null;
		}
		
		if(D[source][target] == Integer.MAX_VALUE) {
			return null;
		}
		
		int k = P[source][target];
		
		int count = 0;					//******
		while(k != target){
			k = P[k][target];
			count++;
		}
		int[] path = new int[count+2];	//此段是计数
		
		k = P[source][target];  count = 0;
		path[count++] = source;
		while(k != target){
			path[count++] = k;
			k = P[k][target];
		//	path[count++] = k;
		}
		path[count] = target;
		
		return path;
	}
	
	public final int getDistance(final int source, final int target)
	{
		if(!FloydFlag) {
			Floyd();
		}
		
		return D[source][target];
	}
}







