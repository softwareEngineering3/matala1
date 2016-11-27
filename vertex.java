import java.util.ArrayList;

class vertex {
	public int name;
	public ArrayList<edge> edges;
	public double dist;
	public int previous;
	public boolean visited;
	public int count;
	
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
}

