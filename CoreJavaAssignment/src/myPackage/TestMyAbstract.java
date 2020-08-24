/**
 * 
 */
package myPackage;

/**
 * @author Abdalla Hablas
 * @date Aug 23, 2020
 */
public class TestMyAbstract extends MyAbstract{

	@Override
	public boolean checkUpperCase(String s) {
		// test if any character in the string is between DEC 65 and DEC 90 (upper case ascii)
		for (int i=0; i<s.length(); i++) {
			if ((int)s.charAt(i) >= 65 && ((int)s.charAt(i) <= 90)) return true;
		}
		return false;
	}

	@Override
	public String convertToUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	public void convertToInteger(String s) {
		System.out.println(Integer.valueOf(s) +10);
	}
	

}
