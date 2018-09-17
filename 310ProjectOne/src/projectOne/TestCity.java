package projectOne;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class TestCity {

	@Test
	public void testGetName() {
		City c1 = new City();
		c1.setName("boston");
		assertEquals("boston",c1.getName());
	}
	
	@Test
	public void testSetName() {
		City c1 = new City();
		c1.setName("boston");
		assertEquals("boston", c1.getName());
	}
	
	@Test
	public void testGetConnectedCities() {
		City c1 = new City();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("boston", 25);
		c1.connectedCities = hm;
		assertEquals(hm, c1.getConnectedCities());
	}

}
