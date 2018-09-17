package projectOne;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestFlightMap {

	@Test
	public void testGetOriginCity() {
		FlightMap fm = new FlightMap(2);
		City c1 = new City();
		c1.setName("boston");
		fm.setOriginCity(c1);
		assertEquals(c1, fm.getOriginCity());
	}
	
	@Test
	public void testGetNumCities() {
		FlightMap fm = new FlightMap(2);
		assertEquals(2, fm.getNumCities());
	}
	
	@Test
	public void testSetOriginCity() {
		FlightMap fm = new FlightMap(2);
		City c1 = new City();
		fm.setOriginCity(c1);
		assertEquals(c1, fm.getOriginCity());
	}
	
	@Test
	public void testAddEdge() {
		FlightMap fm = new FlightMap(2);
		int source = 0;
		int destination = 1;
		fm.addEdge(source, destination);
		ArrayList<Integer> newAL = new ArrayList<Integer>(2);
		newAL.add(1);
		assertEquals(fm.adjacencyList[0], newAL);
	}
}
