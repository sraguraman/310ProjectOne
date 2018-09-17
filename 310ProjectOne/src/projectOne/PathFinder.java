package projectOne;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class PathFinder {

	public PathFinder() {
		// TODO Auto-generated constructor stub
	}
	
	public void printPath(Vector<Integer> path)
	{
		int size = path.size();
		for (int i = 0; i < size; i++)
		{
			System.out.println(path.get(i));
		}
	}
	
	public int notVisited(int x, Vector<Integer> path)
	{
		int pathSize = path.size();
		for (int i = 0; i < pathSize; i++)
		{
			if (path.get(i) == x)
			{
				return 0;
			}
		}
		return 1;
	}
	
	public void findPaths(int [][]cityMatrix, int source, int destination, int numVertices)
	{
		Stack<Integer> currentPath = new Stack<Integer>();
		currentPath.add(source);
		Boolean [] visited = new Boolean [numVertices];
		visited[source] = true;
		
		if (source == destination)
		{
			visited[source] = false;
		}
		
		if (source == destination && currentPath.size() == 0)
		{
			
		}
		
	}
	
	
	public void findPaths(int [][]cityMatrix, int source, int destination)
	{
		Queue<Vector<Integer>> pathQueue = new LinkedList<Vector<Integer>>();
		
		Vector<Integer> path = new Vector<Integer>();
		path.add(source);
		
		pathQueue.add(path);
		
		while (!(pathQueue.isEmpty()))
		{
			path = pathQueue.peek();
			pathQueue.poll();
			
			int last = path.get(path.size() - 1);
			
			if (last == destination)
			{
				printPath(path);
			}
			
			for (int i = 0; i < cityMatrix[last].length; i++)
			{
				if (notVisited(cityMatrix[last][i], path) != 0)
				{
					Vector<Integer> newPath = new Vector<Integer>(path);
					newPath.add(cityMatrix[last][i]);
					
					pathQueue.add(newPath);
				}
			}
		}
	}
	/*
	public Vector<Integer> printPaths(int [][] cityMatrix, int source, int destination, int numCities)
	{
		Vector<Integer> cityVector = new Vector<Integer>();
		
		Stack<Integer> cityStack = new Stack<Integer>();
		cityStack.add(source);
		
		Boolean [] presentInStack = new Boolean[numCities];
		
		presentInStack[source] = true;
		
		if (source == destination)
		{
			while (!cityStack.isEmpty())
			{
				cityVector.add(cityStack.pop());
			}
		}
		else 
		{
			for (int v = 0; v < numCities; v++)
			{
				if ((cityMatrix[source][v] != 0) && (presentInStack[v] == false))
				{
					printPaths(cityMatrix, source, destination, numCities);
				}
			}
		}
		
		cityStack.pop();
		presentInStack[source] = false;
		
		return cityVector;
	}
	*/

}
