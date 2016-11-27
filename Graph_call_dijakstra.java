import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class Graph_call_dijakstra {

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







//		///////tests////////////////////////
//				Dijkstra ds = new Dijkstra(vertexList,0); // not always starts in 0
//				ds.computePaths();
//				System.out.println("0 to 3");
//				ds.printPaths(3);
//				ds.init(vertexList, 1);
//				ds.computePaths();
//				System.out.println("1 to 1");
//		
//				ds.printPaths(1);
//				int black_list[]={5};
//				System.out.println("1 to 0, no 5");
//				ds.blacklist(black_list, 1,0,vertexList);
//				ds.init(vertexList, 1);
//				System.out.println("1 to 5");
//				ds.computePaths();
//				ds.printPaths(5);
//				int [] array={3,4};
//				System.out.println("0 to 5 not 3,4");
//				ds.blacklist(array, 0,5,vertexList);
//				int [] array2={3,4,5};
//				System.out.println("0 to 1 not 3,4,5");
//				ds.blacklist(array2, 0,1,vertexList);
//				int [] array3={3,4};
//				System.out.println("3 to 1 not 3,4");
//				ds.blacklist(array3, 3,1,vertexList);
//				int [] array4={4};
//				System.out.println("3 to 1 not 4");
//				ds.blacklist(array4, 3,1,vertexList);
//		
//				System.out.println("4 to 5");
//				ds.init(vertexList, 4);
//				ds.computePaths();
//				ds.printPaths(5);
//		
//				int [] array5={4};
//				System.out.println("4 to 4 not 4");
//				ds.blacklist(array5, 4,4,vertexList);
//				System.out.println("3 to 2");
//				ds.init(vertexList, 3);
//				ds.computePaths();
//				ds.printPaths(2);
//				int [] array6={1,0};
//				System.out.println("4 to 5 not 1,0");
//				ds.blacklist(array6, 4,5,vertexList);
//				int [] array7={0};
//				System.out.println("2 to 3 not 0");
//				ds.blacklist(array7, 2,3,vertexList);
//				int [] array8={2,0,1};
//				System.out.println("3 to 5 not 0");
//				ds.blacklist(array8, 3,5,vertexList);
				
				
	}
}