

import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra {
	vertex[] vertices;
	int source;
	int max, maxV;
	boolean isOk;
	
	
	public Dijkstra(vertex[] vs, int source){
		max=-1;
		maxV=-1;
		this.source = source;
		vertices = new   vertex[vs.length];
		for (int i=0; i<vs.length; i++){
			vertices[i] =new vertex(vs[i]) ;
		}
	}
	
	// in case that the dijakstra obj already exists
	public void  init(vertex[] vs, int source){
		this.source = source;
		vertices = new   vertex[vs.length];
		for (int i=0; i<vs.length; i++){ 
			vertices[i] =new vertex( vs[i]);
			vertices[i].setCount(0);
		}
	}

	/**
	 * the function which compute the paths from certain way
	 */
	public void computePaths(){
		isOk=true;

		vertex s = vertices[source];
		s.setDist(0);
		HeapMin Q = new HeapMin();
		Q.minHeapInsert(s);
		for (int i=1; i<vertices.length; i++){
			Q.minHeapInsert(vertices[i]);
		}
		
		
		while (!Q.isEmpty()) {
			vertex u = Q.heapExtractMin();
			// Visit each edge exiting u
			
			for (edge e : u.getEdges()){
				vertex v = vertices[e.getVert()];
				if (!v.isVisited()){
					double distU = u.getDist() + e.getWeight();
					if (distU < v.getDist()) {//relaxation
						v.setDist(distU) ;
						v.setPrevious(vertices[u.getName()].getName());
						Q.heapDecreaseKey(v);
						v.setCount(u.getCount()+1);
						
						
					}
					else{
						isOk=false;
					}
					if(max<v.getCount()){
						maxV=v.getName();
						max=v.getCount();
					}
				}
			}
			u.setVisited(true);
			

		}
		

	}
	
	/**
	 * prints the weights of the vertices 
	 */
	public void printWeights(){
		System.out.print("weights: ");
		for (vertex v : vertices) {
			System.out.println(v.getDist() + ", ");
		}
		System.out.println();
	}
	
	
	
	public String getPath(int v){
		int t = v;
		String ans = t + "";
		while(t != source){
			if(vertices[t].getPrevious()==-1){
				System.out.println("could not find a way  "+v+" from "+source);

				return null;}
			t = vertices[t].getPrevious();
			ans = t + "->" + ans;
		}
		return ans;
	}
	
	/**
	 * print certain path from v vertex to source
	 * @param v
	 * @return
	 */
	public String printPaths(int v){
		
		String stringRes;
			if(vertices[v].getPrevious()!=-1||source==vertices[v].getName()){
				String s=getPath(vertices[v].getName());
				stringRes=source+" " + vertices[v].getName()+" " + vertices[v].getDist();}
			else{
				stringRes="could not find a way "+vertices[v].getName()+" from "+source;
			}
			return stringRes;
				
	}

	
	/**
	 * the function which handle blacklists
	 * @param black_list
	 * @param source
	 * @param dest
	 * @param vs
	 * @return
	 */
	public String blacklist(int [] black_list,int source, int dest, vertex[] vs){
		//init(vs, source);
		String arrayToString="";
		for(int vert:black_list){
			vertices[vert].setVisited(true);
			vertices[vert].setDist(Double.MAX_VALUE);
			vertices[vert].setPrevious(-1);
			vertices[vert].getEdges().clear();
			arrayToString+=" "+ vert+" ";
		}
		computePaths();
		String s=printPaths(dest);
		int count = 0, i=0;
		while(count<2){
			if(s.charAt(i)==' ')
				count++;
			i++;
		}
		String sBegin = s.substring(0,i);
	    String sEnd = s.substring(i);
	    return sBegin + arrayToString + sEnd;
		
	}
	
	
	public static void main(String[] args) {

	}

}



