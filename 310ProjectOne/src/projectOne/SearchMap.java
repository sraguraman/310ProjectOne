package projectOne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;


public class SearchMap {
	public static void main(String[] args) {
		  // The name of the file to open.
        String fileName = "inputfile.txt";

        // This will reference one line at a time
        String line = null;
        String originCity;
        String cityOne;
        String cityTwo;
        String costFromOneToTwo;
        Vector<City> cityList = new Vector<City>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            originCity = bufferedReader.readLine();
            City newCity = new City();
            newCity.name = originCity;
            cityList.add(newCity);
            
            while((line = bufferedReader.readLine()) != null) {
                Scanner scan = new Scanner(line);
                cityOne = scan.next();
                cityTwo = scan.next();
                costFromOneToTwo = scan.next();
                scan.close();
                int trueCost = Integer.parseInt(costFromOneToTwo);
                
   
                found: {
	                for (int i = 0; i < cityList.size(); i++) 
	                		if (cityList.get(i).getName().equals(cityOne))
	                		{
	                			City particularCity = cityList.get(i);
	                			particularCity.getConnectedCities().put(cityTwo, trueCost);
	                			break found;
	                		}
	                City cityToAdd = new City();
	            		cityToAdd.setName(cityOne);
	            		cityToAdd.getConnectedCities().put(cityTwo, trueCost);
	            		cityList.add(cityToAdd);
                }
                
                boolean cityExists = false;
                for (int i = 0; i < cityList.size(); i++)
                {
                		if (cityList.get(i).getName().equals(cityTwo))
                		{
                			cityExists = true;
                			break;
                		}
                }
                
                if (!cityExists)
                {
                		City cityTwoAddition = new City();
                		cityTwoAddition.setName(cityTwo);
                		cityList.add(cityTwoAddition);
                }
            }   
            // Always close files.
            bufferedReader.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        int numberOfVertices = cityList.size();
       
        FlightMap fm = new FlightMap(numberOfVertices);
        fm.setOriginCity(cityList.get(0));
        //int [][]fmMap = fm.getGraphOfCities();
        Hashtable <String, Integer> stringToInt = new Hashtable<String, Integer>();
        
        Vector<String> cityStringNames = new Vector<String>(cityList.size());
        
        for (int i = 0; i < cityList.size(); i++)
        {
        		cityStringNames.add(cityList.get(i).getName());
        		
        }
        
        Collections.sort(cityStringNames);
        CityComparator cc = new CityComparator();
        Collections.sort(cityList, cc);
        
        for (int i = 0; i < cityStringNames.size(); i++)
        {
        		stringToInt.put(cityStringNames.get(i), i);
        }
        
        for (int i = 0; i < cityList.size(); i++)
        {
        		String sourceString = cityList.get(i).getName();
        		
        		HashMap <String, Integer> cityHash = cityList.get(i).getConnectedCities();
        	
        		for (HashMap.Entry<String, Integer> entry : cityHash.entrySet())
        		{
        			int currentSource = stringToInt.get(sourceString);
        			int currentDestination = stringToInt.get(entry.getKey());
        			int currentCost = entry.getValue();
      
        			fm.addEdge(currentSource, currentDestination, currentCost);
        		}
        }
        
        int [][]fmMap = fm.getGraphOfCities();
        
        for (int i = 0; i < fmMap.length; i++) {
            for (int j = 0; j < fmMap[i].length; j++) {
                System.out.print(fmMap[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < cityStringNames.size(); i++)
        {
        		if (fm.getOriginCity().getName().equals(cityStringNames.get(i)))
        		{
        			BFS bfs = new BFS(fmMap, i);
        			break;
        		}
        } 
    }
		// TODO Auto-generated method stub
}


