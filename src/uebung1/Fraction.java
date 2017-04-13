package uebung1;

/**
 * Fraction handles all fraction related tasks.
 * 
 * @author scew1011
 */
public class Fraction {

	//numerator and denominator of fraction
	private int numerator;
	private int denominator;

	/**
	 * Constructs fraction object with 1 as default for both numerator and
	 * denominator.
	 */
	public Fraction() {
		numerator = 1;
		denominator = 1;
	}

	/**
	 * Constructs fraction object with given variables for numerator and
	 * denominator.
	 * 
	 * @param numerator
	 *            for fraction, any integer possible
	 * @param denominator
	 *            for fraction, any integer except 0 possible
	 */
	public Fraction(int numerator, int denominator) {
		if (denominator != 0) {
			this.numerator = numerator;
			this.denominator = denominator;
			reduceFraction();
		}
	}

	/**
	 * Reads out fraction in command line.
	 */
	public void getFraction() {
		System.out.println(numerator + "/" + denominator);
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	/**
	 * Addition of one fraction with the other. Reduces fraction to lowest
	 * common denominator afterwards.
	 * 
	 * @param fraction
	 *            that is added onto used fraction
	 */
	public void addition(Fraction fraction) {
		this.numerator = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
		this.denominator = this.denominator * fraction.denominator;
		this.reduceFraction();
	}

	/**
	 * Addition of one fraction with the other. Reduces fraction to lowest
	 * common denominator afterwards.
	 * 
	 * @param numerator
	 *            used to create fraction for addition
	 * @param denominator
	 *            used to create fraction for addition
	 */
	public void addition(int numerator, int denominator) {
		Fraction fraction = new Fraction(numerator, denominator);
		this.addition(fraction);
	}

	/**
	 * Subtracts given fraction from the other. Reduces fraction to lowest
	 * common denominator afterwards.
	 * 
	 * @param fraction
	 *            used in subtraction as fraction subtracted
	 */
	public void subtraction(Fraction fraction) {
		this.numerator = (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator);
		this.denominator = this.denominator * fraction.denominator;
		this.reduceFraction();
	}

	/**
	 * Subtracts given fraction from the other. Reduces fraction to lowest
	 * common denominator afterwards.
	 * 
	 * @param numerator
	 *            used to create fraction that is subtracted
	 * @param denominator
	 *            used to create fraction that is subtracted
	 */
	public void subtraction(int numerator, int denominator) {
		Fraction fraction = new Fraction(numerator, denominator);
		this.subtraction(fraction);
	}

	/**
	 * Multiplies both fraction, then reduces to lowest common denominator.
	 * 
	 * @param fraction
	 *            used for multiplication
	 */
	public void multiplication(Fraction fraction) {
		this.numerator = this.numerator * fraction.numerator;
		this.denominator = this.denominator * fraction.denominator;
		this.reduceFraction();
	}

	/**
	 * Multiplies both fraction, then reduces to lowest common denominator.
	 * 
	 * @param numerator
	 *            used to create fraction used in multiplication
	 * @param denominator
	 *            used to create fraction used in multiplication
	 */
	public void multiplication(int numerator, int denominator) {
		Fraction fraction = new Fraction(numerator, denominator);
		this.multiplication(fraction);
	}

	/**
	 * Divides fraction by given fraction. Reduces to lowest common denominator
	 * afterwards.
	 * 
	 * @param fraction
	 *            used as divisor
	 */
	public void division(Fraction fraction) {
		int tempDenom = fraction.numerator;
		int tempNumer = fraction.denominator;
		numerator = numerator * tempNumer;
		denominator = denominator * tempDenom;
		reduceFraction();
	}

	/**
	 * Divides fraction by given fraction. Reduces to lowest common denominator
	 * afterwards.
	 * 
	 * @param numerator
	 *            used to create divisor fraction
	 * @param denominator
	 *            used to create divisor fraction
	 */
	public void division(int numerator, int denominator) {
		Fraction fraction = new Fraction(numerator, denominator);
		this.division(fraction);
	}

	/**
	 * Reduces fraction to lowest common denominator.
	 */
	private void reduceFraction() {
		for (int i = 2; i < denominator; i++) {
			while (denominator % i == 0 && numerator % i == 0) {
				denominator = denominator / i;
				numerator = numerator / i;
			}
		}
	}
	
	public static void main (String args[]) {
		Fraction fraction1 = new Fraction(1,2);
		Fraction fraction2 = new Fraction(1,4);
		fraction1.getFraction();
		fraction1.addition(fraction2);
		fraction1.getFraction();
		fraction1.multiplication(fraction1);
		fraction1.getFraction();
		fraction1.division(fraction2);
		fraction1.getFraction();
	}
}
