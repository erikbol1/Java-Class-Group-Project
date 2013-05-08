package examples;

public class Fraction {
	//Instance variables
	private int numerator;
	private int denominator;
	
	//Constructors
	public Fraction (){}
	public Fraction (int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	//Getters and setters
	public int getNumerator(){
		return numerator;
	}
	public void setNumerator(int numerator){
		this.numerator = numerator;
	}
	public int getDenominator(){
		return denominator;
	}
	public void setDenominator(int denominator){
		this.denominator = denominator;
	}
	
	//Methods to replace operators
	public Fraction add(Fraction addend){
		//Temp variables used to increase readability
		int tempNumerator = (numerator * addend.denominator) + (addend.numerator * denominator);
		int tempDenominator = addend.denominator * denominator;
		return new Fraction(tempNumerator, tempDenominator);
	}
	public Fraction subtract(Fraction subtrahend){
		//Temp variables used to increase readability
		int tempNumerator = (numerator * subtrahend.denominator) - (subtrahend.numerator * denominator);
		int tempDenominator = subtrahend.denominator * denominator;
		return new Fraction(tempNumerator, tempDenominator);
	}
	public Fraction multiply(Fraction multiplier){
		//Temp variables used to increase readability
		int tempNumerator = numerator * multiplier.numerator;
		int tempDenominator = denominator * multiplier.denominator;
		return new Fraction(tempNumerator, tempDenominator);
	}
	public Fraction divide(Fraction divisor){
		//Temp variables used to increase readability
		int tempNumerator = numerator * divisor.denominator;
		int tempDenominator = denominator * divisor.numerator;
		return new Fraction(tempNumerator, tempDenominator);
	}
	
	//Override toString for well formatted fraction
	@Override
	public String toString(){
		return numerator + "/" + denominator;
	}
}
