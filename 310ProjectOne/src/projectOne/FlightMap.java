package projectOne;

public class FlightMap {
	
	City originCity;
	int numCities;
	int [][] graphOfCities;

	public FlightMap(City oc, int nc, int [][] goc) {
		this.originCity = oc;
		this.numCities = nc;
		this.graphOfCities = goc;
		// TODO Auto-generated constructor stub
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


