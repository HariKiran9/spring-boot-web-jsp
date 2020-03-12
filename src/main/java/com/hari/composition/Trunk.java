/**
 * 
 */
package com.hari.composition;

/**
 * @author bc887d
 *
 */
public class Trunk implements Part {
	String name;
	double price;

	public Trunk(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hari.composition.Part#getPrice()
	 */
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hari.composition.Part#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
