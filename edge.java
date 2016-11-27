public class edge {


		private  int vert;
		private double weight;
		
		public int getVert() {
			return vert;
		}

		public void setVert(int vert) {
			this.vert = vert;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		/**
		 * constructor of edge 
		 * @param v
		 * @param w
		 */
		
		public edge(int v, double w){ 
			
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
