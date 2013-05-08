package examples;

public class FractionConsole {
	
	public static void main(String[] args) {
		//Create two fractions
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(3, 5);
		
		//Output results
		System.out.println(f1.add(f2));
		System.out.println(f1.subtract(f2));
		System.out.println(f1.divide(f2));
		System.out.println(f1.multiply(f2));
	}
}
