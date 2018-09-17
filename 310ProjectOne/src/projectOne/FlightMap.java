package projectOne;

import java.util.ArrayList;
import java.util.Vector;

public class FlightMap {
	
	City originCity;
	int numCities;
	
	ArrayList<Integer>[] adjacencyList;
	
	Vector<Integer> finalCity = new Vector<Integer>();
	

	@SuppressWarnings("unchecked")
	public FlightMap(int numCities) {
		this.numCities = numCities;
		adjacencyList = new ArrayList[numCities];
		
		for (int i = 0; i < numCities; i++)
		{
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination)
	{
		adjacencyList[source].add(destination);
	}
	
	public void DFShelper(int source, Boolean[] haveVisited)
	{
		haveVisited[source] = true;
		System.out.println(source + " ");
		
		ArrayList<Integer> listOfCities = adjacencyList[source];
		for (Integer i : listOfCities)
		{
			if (!haveVisited[i])
			{
				DFShelper(i, haveVisited);
			}
		}
	}
	
	public void DFS(int source)
	{
		Boolean [] haveVisited = new Boolean[numCities];
		for (int i = 0; i < numCities; i++)
		{
			haveVisited[i] = false;
		}
		
		DFShelper(source, haveVisited);
	}
	
	public void getPaths(int source, int destination)
	{
		Boolean[] haveVisited = new Boolean[numCities];
		int[] currentPath = new int[numCities];
		int index = 0; 
		
		for (int i = 0; i < numCities; i++)
		{
			haveVisited[i] = false;
		}
		
		getPathHelper(source, destination, haveVisited, currentPath, index);
	}
	
	public void getPathHelper(int source, int destination, Boolean[] haveVisited, int [] currentPath, int index)
	{
		haveVisited[source] = true;
		currentPath[index] = source;
		index++;
		
		if (source == destination)
		{
			for (int i = 0; i < index; i++)
			{
				finalCity.add(currentPath[i]);
				//System.out.print(currentPath[i] + " ");
			}
			finalCity.add(999);
			//System.out.println();
		}
		else
		{
			ArrayList<Integer> cityList = adjacencyList[source];
			for (Integer i: cityList)
			{
				if (!haveVisited[i])
				{
					getPathHelper(i, destination, haveVisited, currentPath, index);
				}
			}
			
			index--;
			haveVisited[source] = false;
		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


