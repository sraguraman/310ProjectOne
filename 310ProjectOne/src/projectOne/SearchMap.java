package projectOne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        boolean cityExists = false;
        

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
                
                for (int i = 0; i < cityList.size(); i++)
                {
                		if (cityList.get(i).getName().equals(cityOne))
                		{
                			City particularCity = cityList.get(i);
                			particularCity.getConnectedCities().put(cityTwo, trueCost);
                			cityExists = true; 
                			break;
                		}
                } 
  
                if (cityExists)
                {
                		City cityToAdd = new City();
                		cityToAdd.setName(cityOne);
                		cityToAdd.getConnectedCities().put(cityTwo, trueCost);
                		cityList.add(cityToAdd);
                }
              
            }   
            // Always close files.
            bufferedReader.close();  
            
            for (int i = 0; i < cityList.size(); i++)
            {
            		System.out.println(cityList.get(i).getName());
 
            }
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
    }
		// TODO Auto-generated method stub

}


