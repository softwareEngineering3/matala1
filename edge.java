public class edge {


		public  int vert;
		public double weight;
		
		/**
		 * constructor of edge 
		 * @param v
		 * @param w
		 */
		
		public edge(int v, double w){ 
			System.out.println("h");
			vert = v; 
			weight = w; 
		}
		
		/**
		 * setter to price of edge
		 * @param w
		 */
		public void setPrice(double w){  
			weight = w; 
		}
		public edge(edge edge){ 
			vert = edge.vert; 
			weight = edge.weight; 
		}

	@Override
	/**
	 * toString function
	 * @return string
	 */
		public String toString() {
			return "edge [vert=" + vert + ", weight=" + weight + "]";
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
