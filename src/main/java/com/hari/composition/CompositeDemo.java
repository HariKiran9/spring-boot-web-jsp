/**
 * 
 */
package com.hari.composition;

/**
 * @author bc887d
 *
 */
public class CompositeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Part engine = new Engine("DiselEngine", 15000);
		Part trunk = new Trunk("Trunk", 10000);
		Part body = new Body("Body", 12000);

		Car car = new Car("Innova");
		car.addPart(engine);
		car.addPart(trunk);
		car.addPart(body);

		double price = car.getPrice();
		System.out.println(" price :" + price);

		System.out.println("Car name  : " + car.getName());
		System.out.println("Car parts : " + car.getPartNames());
		System.out.println("Car price : " + car.getPrice());

		String s = "I";
		String s1 = s.concat("am").concat("good").concat("boy");
		System.out.println(" s1 : " + s1);

		s = s + "I";
		System.out.println(" s : " + s);

		final String first = "length: 10";
		final String second = "length: " + first.length();
		final String third = "length: " + "10";
		System.out.println("first : " + first + ", second : " + second);
		System.out.println("HashCode1 : " + first.hashCode() + ", HashCode2 : " + second.hashCode() + ", HashCode3 : " + third.hashCode());
		System.out.println("first and second are equal : " + (first == second));
		System.out.println("first and second are equal() : " + (first.equals(second)));
		System.out.println("first and third are equal : " + (first == third));

	}

}
