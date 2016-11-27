package test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
	}
	
	@Test
	public void testSeperator() {
		
	}
	
	

}
