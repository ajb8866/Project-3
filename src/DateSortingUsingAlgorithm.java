
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class DateSortingUsingAlgorithm {

	/** 
	 * a private HashMap that holds all of the dates
	 */
	private HashMap<LocalDate, Integer> dateHolder = new HashMap<LocalDate, Integer>();
	/**
	 * a private ArrayList that holds all of the dateHolder keys as well as what will be actually
	 * sorted
	 */
	private ArrayList<LocalDate> sortDateHolder = new ArrayList<LocalDate>();
	/*
	 * a constructor that fills dateHolder and sortDateHolder
	 */
	public DateSortingUsingAlgorithm()
	{
		try {
			
			  int counter = 1;
		      File myObj = new File("SortingDates.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    	  String data = myReader.nextLine();
				   data = data.trim();
				   data = data.replace(" ", "");
		    	  LocalDate dateGiven = LocalDate.parse(data,formatter);
		    	  dateHolder.put(dateGiven,counter);
		    	  ++counter;

		      }
		  
		      myReader.close();
		  }  
		catch (FileNotFoundException e) 
		{
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		for (LocalDate date : dateHolder.keySet())
		{
			sortDateHolder.add(date);
		}
	
	}
	/*
	 * a void method that sorts sortDateHolder in descending order and then prints out sortDateHolder
	 */
	public void dateHashMapSortedDescending()
	{
		 int num;
		 int i;
		 int j;
		 LocalDate temp;
		  
		    num = sortDateHolder.size();
		 
	
		    for (i = 0; i < ( num - 1 ); i++) {
		    	
		    
		      for (j = 1; j < num - i; j++)
		      {
		    	
			    	  
			        if ((sortDateHolder.get(j-1).compareTo(sortDateHolder.get(j)) <= -1)) 
			        {
			          temp = sortDateHolder.get(j-1);
			          sortDateHolder.set((j-1), sortDateHolder.get(j));
			          sortDateHolder.set((j), temp);
			        }
		      }
		    }
		    for(int x =0; x < sortDateHolder.size(); ++x)
		    {
		    	System.out.println(sortDateHolder.get(x));
		    }
		
	
		
	}
	/*
	 * a void method that sorts sortDateHoder in ascending order and then prints out sortDateGolder
	 */

	public void dateHashMapSorted() {
		 int num;
		 int i;
		 int j;
		 LocalDate temp;
		  
		    num = sortDateHolder.size();
		 
	
		    for (i = 0; i < ( num - 1 ); i++) {
		    	
		    
		      for (j = 1; j < num - i; j++)
		      {
		    	
			    	  
			        if ((sortDateHolder.get(j-1).compareTo(sortDateHolder.get(j)) >= 1)) 
			        {
			          temp = sortDateHolder.get(j-1);
			          sortDateHolder.set((j-1), sortDateHolder.get(j));
			          sortDateHolder.set((j), temp);
			        }
		      }
		    }
		    for(int x =0; x < sortDateHolder.size(); ++x)
		    {
		    	System.out.println(sortDateHolder.get(x));
		    }
	}
		
	
	
}