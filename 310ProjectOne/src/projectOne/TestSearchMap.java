package projectOne;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class TestSearchMap {

	@Test
	public void testGetKeyFromValue() {
		//SearchMap sm = new SearchMap();
		HashMap<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("hello", 6);
		assertEquals("supposed to get 'hello'", "hello", SearchMap.getKeyFromValue(testMap, 6));
	}
}
