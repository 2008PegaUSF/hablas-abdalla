/**
 * 
 */
package myPackage;
import myOtherPackage.Float;
import java.util.ArrayList;

/**
 * @author Abdalla Hablas
 * @date Aug 18, 2020
 */
public class Driver {

	public static void main(String[] args) throws Exception {
		
		Homework homework = new Homework();
		Employee e1 = new Employee ("adam", "engineering", 28);
		Employee e2 = new Employee ("fatma", "HR", 22);
		
		// test Q1
		int [] a = {1,0,5,6,3,2,3,7,9,8,4};// data
		
		int[] b = homework.bubbleSort(a); // sort
		for (int i: b) {
			System.out.print(i); // print all
		}
		
		// test Q2
		System.out.println();
		homework.fibNumber(25);
		
		// test Q3
		System.out.println("\n"+ homework.reverseString("Hello"));

		//test Q4
		System.out.println(homework.nFactorial(5));
		
		// test Q5 
		System.out.println(homework.subString("Hello", 3));
		
		// test Q6
		System.out.println(homework.isEven(4));
		
		//test Q7
		if (homework.compare(e1, e2) == 0) System.out.println(e1.toString());
		else System.out.println(e2.toString());
		
		//test Q8
		ArrayList<String> test = homework.palindromes("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		for (String i: test) System.out.print(i+",");
		
		
		//test Q9 
		System.out.println();
		homework.printPrime();
		
		// test Q10
		System.out.println("\n" + homework.min(4, 6));
		
		//test Q11
		System.out.println(Float.a);
		System.out.println(Float.b);
		
		//test Q12
		homework.printEven();
		
		// test Q13
		System.out.println();
		homework.displayTriangle();
		
		// test Q14
		homework.switchTest(1);
		homework.switchTest(2);
		homework.switchTest(3);
		
		// Q15 test 
		TestMyInterface testInterface = new TestMyInterface();
		System.out.println(testInterface.addition(3, 5));
		System.out.println(testInterface.subtraction(10, 5));
		System.out.println(testInterface.multiplication(5, 7));
		System.out.println(testInterface.division(15.0, 5.0));
		
		// test Q17 
		System.out.println(homework.interest());
		
		// test Q18
		TestMyAbstract testAbstract = new TestMyAbstract();
		System.out.println("does string have upper case: " + testAbstract.checkUpperCase("Hello World"));
		System.out.println(testAbstract.convertToUpper("java is cool"));
		testAbstract.convertToInteger("610");
		
		// test Q19
		homework.question19();
		
		// test Q20
		System.out.println();
		homework.readFile("Data.txt");
		
	}

}
