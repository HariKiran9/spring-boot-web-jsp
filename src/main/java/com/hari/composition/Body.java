/**
 * 
 */
package com.hari.composition;

/**
 * @author bc887d
 *
 */
public class Body implements Part {

	String name;
	double price;

	public Body(String name, double price) {
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
		return this.price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hari.composition.Part#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
