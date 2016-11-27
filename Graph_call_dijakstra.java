import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class Graph_call_dijakstra {

	/**
	 * finds the minimum and maximum in array
	 * @param arr
	 * @param arr2
	 * @return a String which so describes the minimum and maximum 
	 */
	public static String minMaxPairs(int []arr, int arr2[]){
		int min, max, minI=0, maxI=0;
		int len = arr.length, count = 0;
		count++;
		if (arr[0]<arr[1]){
			min = arr[0];
			minI=0;
			max = arr[1];
			maxI=1;
		}
		else{
			min = arr[1];
			minI=1;
			max = arr[0];
			maxI=0;
		}
		for (int i=2; i<(2*(len/2)); i=i+2){
			count++;
			if(arr[i]<arr[i+1]){
				count = count + 2;
				if(arr[i]<min) { min = arr[i]; minI=i;}
				if(arr[i+1]>max){  max = arr[i+1]; maxI=i+1;}
			}
			else{
				count = count + 2;
				if(arr[i+1]<min){ min = arr[i+1]; minI=i+1;}
				if(arr[i]>max){  max = arr[i]; maxI=i;}				
			}
		}
		// if number of elements is odd, 
		//  we check the last element
		if (len%2!=0){
			count++;
			if (arr[len-1]>max){
				max = arr[len-1];
				maxI=len-1;
			}
			else{
				count++;
				if (arr[len-1]<min){
					min = arr[len-1];		
					minI=len-1;
				}
			}
		}
		String s="diameter="+max+" from "+maxI+" to "+arr2[maxI]+ " radius="
				+min +" from "+minI+" to "+arr2[minI];
		return s;
	}
	public static String statisticOutput(vertex vertexList[]){
		boolean isTie = false;
		int allMax[]=new int[vertexList.length];
		int vertexs[]=new int[vertexList.length];
		for (int i = 0; i < vertexList.length; i++) {
			Dijkstra ds = new Dijkstra(vertexList,i);
			ds.computePaths();
			if(ds.isOk)
				isTie=true;
			allMax[i]=ds.max;
			vertexs[i]=ds.maxV;
		}
		
		
		if(isTie){
		return (" Tie "+minMaxPairs(allMax,vertexs));}
		return (" !Tie "+minMaxPairs(allMax,vertexs));
	}
	
	/**
	 * 
	 * @param s
	 * @param vertexList
	 * @return the result of the dijakstra as string
	 */
	public static String seperator(String s, vertex vertexList[] ){
		String [] arr=s.split(" ");
		String result;
		int firstV=Integer.parseInt(arr[0]);
		int secondV=Integer.parseInt(arr[1]);
		int black_list[]=new int[arr.length-2];
		if(arr.length-2!=0){
			for(int i=2;i<arr.length;i++){
				black_list[i-2]=Integer.parseInt(arr[i]);
				
				
			}
			Dijkstra ds = new Dijkstra(vertexList,firstV);
			result=ds.blacklist(black_list, firstV,secondV,vertexList);
			

		}
		else{
			Dijkstra ds = new Dijkstra(vertexList,firstV); 
			ds.computePaths();
			result=ds.printPaths(secondV);
		}
		return result;
	}

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		String address="C:\\Users\\adi\\Desktop\\G0.txt";
		Graph gph= new Graph(address);
		vertex vertexList[]=gph.getListOfVertexes();
		read_From_Querys rfq =new read_From_Querys("C:\\Users\\adi\\Desktop\\test1.txt");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("creating into "+s);
		try{
			boolean isTie;
			PrintWriter writer = new PrintWriter("graphRes.txt", "UTF-8");
			for(int i=0;i<rfq.getNumOfQueries();i++){
				String res=seperator(rfq.getListOfQueries()[i], vertexList);
				writer.println(res);
			}
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
		
			writer.println("Graph: |V|="+gph.getNumOfVertexes()+" |E|="+gph.getNumOfEdges()
			+statisticOutput(vertexList)+" ,"+totalTime+"ms");
			writer.close();
		}catch (Exception e) {
			System.out.println("error");
		}				
	}
}