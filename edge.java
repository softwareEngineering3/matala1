public class edge {


		public  int vert;
		public double weight;
		public edge(int v, double w){ 
			vert = v; 
			weight = w; 
		}
		public void setPrice(double w){  
			weight = w; 
		}
		public edge(edge edge){ 
			vert = edge.vert; 
			weight = edge.weight; 
		}

	@Override
		public String toString() {
			return "edge [vert=" + vert + ", weight=" + weight + "]";
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
