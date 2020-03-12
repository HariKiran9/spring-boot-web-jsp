package com.hari.concurrency.parallels;

import java.util.HashSet;
import java.util.Set;

import com.hk.dojo.Employee;

public class HashsetTest {

	public static void main(String[] args) {
		Set<Employee> eList = new HashSet<Employee>();
		eList.add(new Employee("A", 20000));
		eList.add(new Employee("A", 20000));
//		for (int i = 0; i < 100; i++) {
//			eList.add(new Employee("A", 20000));
//			eList.add(new Employee("B", 3000));
//			eList.add(new Employee("C", 15002));
//			eList.add(new Employee("D", 7856));
//			eList.add(new Employee("E", 200));
//			eList.add(new Employee("F", 50000));
//			eList.add(new Employee("F", 50000));
//		}

	}

}
