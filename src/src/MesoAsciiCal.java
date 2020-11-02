package src;

public class MesoAsciiCal extends MesoAsciiAbstract 
{

	/**
	 * a private string variable that represents the string value of the given MesoStation id
	 */
	private String stID = "";
	/**
	 * a final variable that is Norman Station letter average
	 */
	final int NRMN_AVG = 79;
	/**
	 * a constructor that sets the stID to whatever the string representation mesoStation is
	 * @param mesoStation4
	 * a Mesostation object that is used to get the stID 
	 */
	public MesoAsciiCal(MesoStation mesoStation) {
		 this.stID =  mesoStation.getStID();
		}

	/*
	 * a method that returns an int which represents the  value ascii letter average between the Norman station and the stID station
	 * @return totalAvg
	 */
	@Override
	public int calAverage() {
		int floorAverage = 0;
		int ceilingAverage = 0;
		int averagePlaceCounter = 0;
		double totalASCHolder = 0;
		int totalAvg = 0;

		for (int x = 0; x < stID.length(); ++x)
		{
			char placeholder = stID.charAt(x);
			int intPlaceHolder = placeholder;
			totalASCHolder += intPlaceHolder;
		}
		
		floorAverage = (int) Math.floor(totalASCHolder/4);
		ceilingAverage = (int) Math.ceil(totalASCHolder/4);	
		
		if (((totalASCHolder/4) - (int)(totalASCHolder/4)) < .25)
		{
			averagePlaceCounter = floorAverage;
		}
		else if (((totalASCHolder/4) - (int)(totalASCHolder/4)) >= .25)
		{
			averagePlaceCounter = ceilingAverage;
		}
		
		
		if ((((averagePlaceCounter+(double)NRMN_AVG)/2) - (int)((averagePlaceCounter+(double)NRMN_AVG)/2)) < .25)
		{
			totalAvg = (int) Math.floor((averagePlaceCounter+(double)NRMN_AVG)/2);
		}
		else if (((averagePlaceCounter+(double)NRMN_AVG)/2) - (int)((averagePlaceCounter+(double)NRMN_AVG)/2) >= .25)
		{
			totalAvg  = (int) Math.ceil((averagePlaceCounter+(double)NRMN_AVG)/2);	
		}
		
		return totalAvg;
	}
   
}