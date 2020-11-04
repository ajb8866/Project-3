import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public  class DateTimeThree {
	/*
	 * a private HashMap that holds all of the dates from the given file 
	 */
	 private HashMap<LocalDate, Integer> dateHolder = new HashMap<LocalDate, Integer>();
	 /*
	  * a private TreeMap tha hold all of the dates from dateHolder in sorted order
	  */
	 private Map<LocalDate, Integer> treeMap = new TreeMap<LocalDate, Integer>(dateHolder);
	 /**
	  * a constructor that adds all of the values and keys to dateHolder after turning them into the needed
	  * object type,  for the given file. The adds all the values to a tree list so it 
	  * can be sorted 
	  */
	public DateTimeThree()
	{
		
		try {
			
			  int counter = 1;
		      File myObj = new File("Dates.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		    	  LocalDate dateGiven = LocalDate.parse(myReader.nextLine(),formatter);
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
	
		treeMap.putAll(dateHolder);	

	}

	/**
	 * returns the dateHolder hashMap
	 * @return dateGikder
	 */
	HashMap<LocalDate, Integer> getHashMap()
	{
		return dateHolder;
	}
	/**
	 * a void method that checks to see if the year is a leap year or not as well as calls the helper method differenceGetter 
	 */
	public void compareYear() {
		for (LocalDate i : dateHolder.keySet()) {
			if (i.isLeapYear())
			{
		      System.out.println(i.getYear() + " is a leap year, and Difference: " + differenceGetter(i));
			}
			else 
			{
				System.out.println(i.getYear() + " is not a leap year, and Difference: " + differenceGetter(i));
			}
				
		}
		
		
	}
	/**
	 * returns the difference between the date given and the current date
	 * @param yearNeeded
	 * a LocalDate that is we use to compare to the current date
	 * @return  pInfo
	 */
	public String  differenceGetter(LocalDate yearNeeded)
	{
		LocalDate currentDate = LocalDate.now();
		Period p = Period.between( yearNeeded,currentDate);
		int days = p.getDays();
		int years =  p.getYears();
		int months = p.getMonths();
		String pInfo =  years + " years, " + months + " months, and "+  days  +" days.";
		return pInfo;
	}
	/**
	 * a method that prints  dateHolder in this format key:value
	 */
	public void dateHashMap() 
	{
		for (LocalDate i : dateHolder.keySet()) {
			
			
				System.out.println(i + ":" + dateHolder.get(i) );
			
				
		}
		
		
	}
	

	/**
	 * a void method that prints out dateHolder sorted by its keys
	 */
	public void dateHashMapSorted()
	{
		for (LocalDate i : treeMap.keySet()) {
			
			System.out.println(i + ":" + treeMap.get(i) );
		}
		
	}

}
