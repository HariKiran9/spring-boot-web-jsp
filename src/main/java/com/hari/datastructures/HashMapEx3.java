package com.hari.datastructures;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx3 {

	public static void main(String[] args) {
		// create a HashMap and add some values
		Map<String, Integer> map = new HashMap<>();
		map.put("key1", 10000);
		map.put("key2", 55000);
		map.put("key3", 44300);
		map.put("key4", 53200);

		// print map details
		System.out.println("HashMap:\n " + map.toString());

		// provide value for new key which is absent
		// using computeIfAbsent method
		Integer ret = map.computeIfAbsent("key5", k -> 2000 + 33000);
		System.out.println("Return : " + ret);
		map.computeIfAbsent("key6", k -> 2000 * 34);

		// print new mapping
		System.out.println("New HashMap:\n " + map);

	}

}
