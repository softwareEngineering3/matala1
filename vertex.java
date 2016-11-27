import java.util.ArrayList;

class vertex {
	private int name;
	private ArrayList<edge> edges;
	private double dist;
	private int previous;
	private boolean visited;
	private int count;
	
	public vertex(int name, double dist) {
		this.name = name; 
		this.dist = dist;
		previous = -1;
		visited = false;
		edges = new ArrayList<>(); 
		count=0;
	}
	public vertex(vertex v) {
		this.name = v.name; 
		this.dist = v.dist;
		this.previous = v.previous;
		this.visited = v.visited;
		this.count=v.count;
		this.edges = new ArrayList<>();
		for(int i=0;i<v.edges.size();i++){
			this.edges.add(v.edges.get(i));
		}
	}
	public vertex(vertex v,int num) {
		this.name = v.name; 
		this.edges = new ArrayList<>();
		for(int i=0;i<v.edges.size();i++){
			this.edges.add(v.edges.get(i));
		}
	}
	public String toString() {
		String s= "name is" + name+" sons are:"; 
		for(int i=0;i<edges.size();i++)
			s+=edges.get(i).toString();
		return s;
	}
	/**
	 * @return the name
	 */
	public int getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(int name) {
		this.name = name;
	}
	/**
	 * @return the edges
	 */
	public ArrayList<edge> getEdges() {
		return edges;
	}
	/**
	 * @param edges the edges to set
	 */
	public void setEdges(ArrayList<edge> edges) {
		this.edges = edges;
	}
	/**
	 * @return the dist
	 */
	public double getDist() {
		return dist;
	}
	/**
	 * @param dist the dist to set
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}
	/**
	 * @return the previous
	 */
	public int getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}
	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}

