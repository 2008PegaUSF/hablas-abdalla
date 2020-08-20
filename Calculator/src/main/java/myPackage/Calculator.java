/**
 * 
 */
package myPackage;
import java.util.*;

/**
 * @author Abdalla Hablas
 * @date Aug 20, 2020
 */
public class Calculator {
	
	private int firstNum;
	private int secondNum;
	private char operator;
	
	
	public int calculate(String str) {
		
		Scanner scan = new Scanner(str);
		firstNum = scan.nextInt();
		operator = scan.next().charAt(0);
		secondNum = scan.nextInt();
	
		switch (operator) {
		
		// add
		case '+': return firstNum + secondNum;
		
		//sub
		case '-': return firstNum - secondNum;
		
		// multiply
		case '*': return firstNum * secondNum;
		
		// divide
		case '/': return firstNum / secondNum;
		
		//mod
		case '%': return firstNum % secondNum;
		
		default: return -1;
		
		}
	}

	
	
	
}

