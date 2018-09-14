package projectOne;

public class FlightMap {
	
	City originCity;
	int numCities;
	int [][] graphOfCities;

	public FlightMap(int numCities) {
		graphOfCities = new int[numCities][numCities];
		// TODO Auto-generated constructor stub
	}
	
	public void setOriginCity(City c) {
		originCity = c;
	}
	
	City getOriginCity() {
		return this.originCity;
	}
	
	int getNumCities() {
		return this.numCities;
	}
	
	int [][] getGraphOfCities() {
		return this.graphOfCities;
	}
	
	void addEdge(int source, int destination, int cost)
	{
		graphOfCities[source][destination] = cost;
	}
	
	int returnCost(int source, int destination)
	{
		return graphOfCities[source][destination];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


