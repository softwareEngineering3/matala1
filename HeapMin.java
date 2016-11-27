
public class HeapMin {

	double _positiveInfinity = Double.POSITIVE_INFINITY;
	final int INIT_SIZE = 10;
	private vertex _a[];
	private int _size;
	
	public HeapMin(vertex arr[]){
		_size = arr.length;
		_a = new vertex[_size];
		for (int i=0; i<_size; i++){
			_a[i]=arr[i];
		}
	}
	
	public HeapMin(){
		_a = new vertex[0];
	}
	
	/** returns the heap size*/
	public int getSize(){return _size;}
	
	/** returns the heap array */
	public vertex[] getA(){ return _a;}
	

	/** parent returns the parent of name  i*/
	private  int parent(int i){return (i-1)/2;}

	/** leftChild returns the left child of name  i*/
	private  int leftChild(int i){return 2*i+1;}
	
	/** rightChild returns the right child of name  i*/
	private  int rightChild(int i){return 2*i+2;}
	
	/** returns the heap minimum */
	public vertex heapMinimum(){return _a[0];}
	
	/** returns true if the heap is empty, otherwise false */
	public boolean isEmpty(){
		boolean ans = false;
		if (_size == 0) ans = true;
		return ans;
	}
	
	/** the minHeapfy function maintains the min-heap property */
	private void minHeapify(int v, int heapSize){
		int smallest;
		int left = leftChild(v);
		int right = rightChild(v);
		if (left<heapSize && _a[left].getDist()<_a[v].getDist()){
			smallest = left;
		}
		else{
			smallest = v;
		}
		if (right<heapSize && _a[right].getDist()<_a[smallest].getDist()){
			smallest = right;
		}
		if (smallest!=v){
			exchange(v, smallest);
			minHeapify(smallest, heapSize);
		}		
	}
	
	/** the heap minimum element extraction */
	public vertex heapExtractMin(){
		double min = _positiveInfinity; 
		vertex v=null;
		if (!isEmpty()){
			v=new vertex(_a[0]);
			min = v.getDist();
			_a[0]=_a[_size-1];
			_size = _size-1;
			minHeapify(0, _size);
		}
		return v;
	}
	
	/** the heapDecreaseKey implements the Decrease Key operation*/
	public void heapDecreaseKey(vertex node){
		int v = node.getName();
		int i = 0;
		while (i<_size && v!=_a[i].getName()) i++;
		if (node.getDist() <_a[i].getDist()){
			_a[i] = node;
			while (i>0 && _a[parent(i)].getDist()>_a[i].getDist()){
				exchange(i, parent(i));
				i = parent(i);
			}
		}
	}
	
	/** minHeapInsert function implements the Insert-Key operation*/
	public void minHeapInsert(vertex node){
		resize(1);
		_a[_size-1] = new vertex(node);
		_a[_size-1].setDist(_positiveInfinity);
		heapDecreaseKey(node);
	}
	
	/** increment an array*/
	private void resize(int increment){
		vertex temp[] = new vertex[_size+increment];
		for (int i=0; i<_size; i++){
			temp[i]=_a[i];
		}
		_a = temp;
		_size = _size+increment;
	}	
	
	/** exchange two array elements*/
	private void exchange(int i, int j){
		vertex t = _a[i];
		_a[i] = _a[j];
		_a[j] = t;
	}
	
	/*	*//** print a heap array **//*
	public void print(){
		for (int i=0; i<_size; i++){
			System.out.print(_a[i]+"; ");
		}
		System.out.println();
	}*/
	
	public boolean contains(int name){
		boolean ans = false;
		for (int i=0; !ans && i<_size; i++){
			if (_a[i].getName() == name) ans = true;
		}
		return ans;
	}
	
	/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex nodes1[] = {new Vertex(16,0),
						 new Vertex(5,1),
						 new Vertex(8,2),
						 new Vertex(4,3),
						 new Vertex(2,4),
						 new Vertex(1,5)}; 
		//int nodes1[] = {16,8,4,2,1}; 
		//int nodes2[] = {5,13,2,25,7,17,2,8,4}; 
		//int nodes3[] = {16,14,10,8,7,9,3,2,4,1}; 
		HeapMin hp = new HeapMin(nodes1);
		hp.buildMinHeap();
		hp.print();
		Vertex node = new Vertex(3,nodes1.length);
		hp.minHeapInsert(node);
		hp.print();
		System.out.println("min = "+ hp.heapExtractMin());
		hp.print();
		System.out.println("min = "+ hp.heapExtractMin());
		hp.print();
/// heap sort

		HeapMin hps = new HeapMin(nodes1);
		hps.heapSort();
		hps.print();
	}
	 */
}
