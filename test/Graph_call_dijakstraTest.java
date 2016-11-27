package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.prism.impl.VertexBuffer;

import src.Graph_call_dijakstra;




public class Graph_call_dijakstraTest {

	@Test
	public void testMinMaxPairs() {
		int[] a = {1,2,3,4,5};
		int[] b = {0,0,0,0,0};
		String value = Graph_call_dijakstra.minMaxPairs(a, b);
		String  check = "diameter=5 from 4 to 0 radius=1 from 0 to 0";
		assertEquals(value, check);
	}
	
	@Test
	public void testStatisticOutput() {
		src.Vertex[] vertexList = new src.Vertex[3];
		vertexList[0] = new src.Vertex(0, Double.POSITIVE_INFINITY);
		vertexList[1] = new src.Vertex(1, Double.POSITIVE_INFINITY);
		vertexList[2] = new src.Vertex(2, Double.POSITIVE_INFINITY);
		String value = Graph_call_dijakstra.statisticOutput(vertexList);
		String check =  " Tie diameter=-1 from 0 to -1 radius=-1 from 1 to -1";
		assertEquals(value,check);
	}
	
	@Test
	public void testSeperator() {
		
	}
	
	

}
