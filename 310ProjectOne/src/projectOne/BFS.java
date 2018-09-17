package projectOne;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public BFS(int [][] flightMatrix, int origin) {
		// TODO Auto-generated constructor stub
		int n = flightMatrix.length;
		
		boolean[] visited = new boolean[n];
		
		Queue<Integer> cityQueue = new LinkedList<Integer>();
		
		cityQueue.add(origin);
		visited[origin] = true;
		
		while (cityQueue.isEmpty() == false)
		{
			int currentCity = cityQueue.peek();
			cityQueue.poll();
			
			System.out.print(currentCity);
			
			for (int i = 0; i < flightMatrix[currentCity].length; i++)
			{
				int neighbor = i;
				int cityCost = flightMatrix[currentCity][i];
				
				if (cityCost == 0)
				{
					continue;
				}
				
				if (visited[neighbor] == false)
				{
					cityQueue.add(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}
}
