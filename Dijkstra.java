

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
	public void  init(vertex[] vs, int source){
		this.source = source;
		vertices = new   vertex[vs.length];
		for (int i=0; i<vs.length; i++){ //should we do this??
			vertices[i] =new vertex( vs[i]);
			vertices[i].count=0;
		}
	}

	public void computePaths(){
		isOk=true;

		vertex s = vertices[source];
		s.dist = 0;
		HeapMin Q = new HeapMin();
		Q.minHeapInsert(s);
		for (int i=1; i<vertices.length; i++){
			Q.minHeapInsert(vertices[i]);
		}
		
		
		while (!Q.isEmpty()) {
			vertex u = Q.heapExtractMin();
			// Visit each edge exiting u
			
			for (edge e : u.edges){
				vertex v = vertices[e.getVert()];
				if (!v.visited){
					double distU = u.dist + e.getWeight();
					if (distU < v.dist) {//relaxation
						v.dist = distU ;
						v.previous = vertices[u.name].name;
						Q.heapDecreaseKey(v);
						v.count=u.count+1;
						
						
					}
					else{
						isOk=false;
					}
					if(max<v.count){
						maxV=v.name;
						max=v.count;
					}
				}
			}
			u.visited = true;
			

		}
		

	}/////

	public void printWeights(){
		System.out.print("weights: ");
		for (vertex v : vertices) {
			System.out.println(v.dist + ", ");
		}
		System.out.println();
	}
	
	
	
	public String getPath(int v){
		int t = v;
		String ans = t + "";
		while(t != source){
			if(vertices[t].previous==-1){
				System.out.println("could not find a way  "+v+" from "+source);

				return null;}
			t = vertices[t].previous;
			ans = t + "->" + ans;
		}
		return ans;
	}
	public String printPaths(int v){
		
		String stringRes;
			if(vertices[v].previous!=-1||source==vertices[v].name){
				String s=getPath(vertices[v].name);
				stringRes=source+" " + vertices[v].name+" " + vertices[v].dist;}
				//System.out.println("price from "+source+" to " + vertices[v].name+" = " + vertices[v].dist + ", path: " +  getPath(vertices[v].name));}
			else{
				stringRes="could not find a way "+vertices[v].name+" from "+source;
				//System.out.println("could not find a way  "+vertices[v].name+" from "+source);
			}
			return stringRes;
				
	}

	public String blacklist(int [] black_list,int source, int dest, vertex[] vs){
		//init(vs, source);
		String arrayToString="";
		for(int vert:black_list){
			vertices[vert].visited=true;
			vertices[vert].dist=Double.MAX_VALUE;
			vertices[vert].previous=-1;
			vertices[vert].edges.clear();
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
/*
			OUTPUT inint1
		weights: 0.0, 7.0, 9.0, 20.0, 20.0, 11.0, 
		price of 0 = 0.0, path: 0
		price of 1 = 7.0, path: 0->1
		price of 2 = 9.0, path: 0->2
		price of 3 = 20.0, path: 0->2->3
		price of 4 = 20.0, path: 0->2->5->4
		price of 5 = 11.0, path: 0->2->5

		 	OUTPUT inint2
		weights: 0.0, 8.0, 9.0, 7.0, 5.0, 
		price of 0 = 0.0, path: 0
		price of 1 = 8.0, path: 0->4->1
		price of 2 = 9.0, path: 0->4->1->2
		price of 3 = 7.0, path: 0->4->3
		price of 4 = 5.0, path: 0->4
 */



