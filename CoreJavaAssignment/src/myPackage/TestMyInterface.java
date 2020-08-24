/**
 * 
 */
package myPackage;

/**
 * @author Abdalla Hablas
 * @date Aug 23, 2020
 */
public class TestMyInterface implements MyMethods {

	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public double division(double a, double b) {
		return a/b;
	}
	

}
