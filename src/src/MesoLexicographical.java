package src;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	/**
	 * a TreeMap that is filled with all the values of a given aHashMap and then sorts
	 */
	Map<String, Integer> treeMap = new TreeMap<String, Integer> ();
	/*
	 * a constructor that fills treeMap and then prints it out
	 * @param asciiVal
	 * the HashMap given by the user
	 */
			MesoLexicographical(HashMap<String, Integer> asciiVal) {
				treeMap.putAll(asciiVal);
				for(String key: treeMap.keySet())
				{
					System.out.println(key + " ");
				}
	}


	/**
	 * a Map method that returns the sorted map from the given map
	 * @param unsorted
	 * the unsorted map given
	 * @return treeMap
	 */
	@Override
	 Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		return treeMap;
	}

}