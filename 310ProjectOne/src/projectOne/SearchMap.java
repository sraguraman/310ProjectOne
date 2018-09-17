package projectOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


public class SearchMap {
	public static Object getKeyFromValue(Map hm, Object value) {
	    for (Object o : hm.keySet()) 
	    {
	      if (hm.get(o).equals(value)) 
	      {
	        return o;
	      }
	    }
	    return null;
	}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
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
        		System.out.println(cityList.get(i).getConnectedCities());
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
        			//int currentCost = entry.getValue();
      
        			fm.addEdge(currentSource, currentDestination);
        		}
        }
        
       
        int originInteger = stringToInt.get(fm.getOriginCity().getName());
        
        for (int i = 0; i < cityList.size(); i++)
        {
        		//System.out.println(originInteger + "|" + i);
        		fm.getPaths(originInteger, i);
        		
        }
        
        Vector<Integer> finalList = fm.finalCity;
        System.out.println(finalList);
      
        
        for (int i = 0; i < finalList.size(); i++)
        {
        		if (finalList.get(i) == originInteger && finalList.get(i+1) == 9999)
        		{
        			finalList.remove(i);
        			finalList.remove(i);
        		}
        }
        
        
        for (int i = 0; i < finalList.size(); i++)
        {
        		int finalCost = 0;
        		while (finalList.get(i) != 9999)
        		{
        			int intToConvert = finalList.get(i);
        			String trueCity = (String) getKeyFromValue(stringToInt, intToConvert);
        			for (int x = 0; x < cityList.size(); x++)
        			{
        				if (cityList.get(x).name.equals(trueCity))
        				{
        					for (Map.Entry<String, Integer> entry : cityList.get(x).connectedCities.entrySet()) 
        					{
        						String connectedCity = (String) getKeyFromValue(stringToInt, finalList.get(i+1));
        						if (connectedCity.equals(entry.getKey()))
        						{
        							finalCost += entry.getValue();
        						}
        					}
        				}
        			}
        			System.out.println(finalCost);
        		}
        		i++;
        		finalCost = 0;
        }
        
        
       
        
       
        
        /*
       // int [][]fmMap = fm.getGraphOfCities();
        
        for (int i = 0; i < fmMap.length; i++) {
            for (int j = 0; j < fmMap[i].length; j++) {
                System.out.print(fmMap[i][j] + " ");
            }
            System.out.println();
        }
        */
        /*
        int originInteger = stringToInt.get(fm.getOriginCity().getName());
        BFS bfs = new BFS(fmMap, originInteger);
        	Vector<Integer> cityOrder = bfs.realBFS(fmMap, originInteger);
        	Vector<String> destinations = new Vector<String>();
        	for (int x = 0; x < cityOrder.size(); x++)
        	{
        		destinations.add((String) getKeyFromValue(stringToInt, cityOrder.get(x)));
        	}    
        	
        destinations.remove(fm.getOriginCity().getName());
        	PathFinder pf = new PathFinder();
        
        for (int i = 0; i < destinations.size(); i++)
        {
         	pf.findPaths(fmMap, originInteger, stringToInt.get(destinations.get(i)));
        }
        */
       
        	
    }
		// TODO Auto-generated method stub
}


