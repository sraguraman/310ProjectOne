package projectOne;
import java.util.HashMap;


public class City {
	String name;
	HashMap<String, Integer> connectedCities;

	public City() {
		connectedCities = new HashMap<String, Integer>();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public HashMap<String, Integer> getConnectedCities() {
		return connectedCities;
	}

}

