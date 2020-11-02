package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MesoEquivalent {
	/**
	 * a private string variable that represents the string value of the given MesoStation id
	 */
	String stID;
	/**
	 * a HashMap that holds all of the stIDHolder keys and the average letter as the value 
	 */
	HashMap<String, Integer> stIDHolder = new HashMap<String, Integer>();
	/**
	 * a TreeMap that holds all of the stIDHolder information in a sorted manner;
	 */
	Map<String, Integer> treeMap = new TreeMap<String, Integer>();
	/**
	 * a constructor that, sets stID value to the one given, fills stIDholder with values and keys made from the text file
	 * and then fills treeMap with the same information
	 * @param stId
	 * The station ID given
	 */
	public MesoEquivalent(String stId) {
		this.stID = stId;
		try {
			
			  int counter = 2;
		      File myObj = new File("Mesonet.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  int avgHolder;
		    	  String data = myReader.nextLine();
				  data = data.trim();
				  MesoAsciiCal asciiAverage = new MesoAsciiCal(new MesoStation(data.split(" ")[0]));
				  avgHolder = asciiAverage.calAverage();
				  if (counter > 4)
					  stIDHolder.put(data.split(" ")[0],avgHolder);
				  ++counter;
	

		      }
		  
		      myReader.close();
		  }  
		catch (FileNotFoundException e) 
		{
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	
		

		
	}
/**
 * creates a Hash map filled with all of the stations that have the same stations ID average as the one its called on
 * @return stIDNearAvg
 */
	public HashMap<String, Integer> calAsciiEqual() {
		
		MesoAsciiCal asciiAverage = new MesoAsciiCal(new MesoStation(stID));
		int avgHolder =  asciiAverage.calAverage();
		HashMap<String, Integer> stIDNearAvg = new HashMap<String, Integer>();
		for (String i : stIDHolder.keySet()) 
		{
			if (stIDHolder.get(i) == avgHolder)
				stIDNearAvg.put(i, avgHolder);
			
		}
		
		return stIDNearAvg;
	}

}
