package src;

import java.util.HashMap;
import java.util.Map;

public abstract class MesoSortedAbstract
{
	/**
	 * the abstract method that make sit possible to use in other parts of the code
	 * @param unsorted
	 * the unsorted map that needs to be sorted
	 * @return
	 */
	abstract Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted);
}
