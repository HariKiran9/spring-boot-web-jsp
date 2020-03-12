/**
 * 
 */
package com.hari.composition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bc887d
 *
 */
public class Car implements Part {

	List<Part> parts;
	String name;

	public Car(String name) {
		this.name = name;
		parts = new ArrayList<Part>();
	}

	public void addPart(Part part) {
		parts.add(part);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hari.composition.Part#getPrice()
	 */
	@Override
	public double getPrice() {
		double price = 0;
		for (Part part : this.parts) {
			price += part.getPrice();
		}
		return price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hari.composition.Part#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	public String getPartNames() {
		StringBuilder sb = new StringBuilder();
		for (Part part : parts) {
			sb.append(part.getName()).append(" ");
		}
		return sb.toString();
	}

}
