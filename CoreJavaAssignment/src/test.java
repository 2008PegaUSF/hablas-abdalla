import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import myPackage.*;

/**
 * 
 */

/**
 * @author Abdalla Hablas
 * @date Aug 23, 2020
 */
class test {

	Homework test = new Homework();
	TestMyInterface testInterface = new TestMyInterface();
	TestMyAbstract testAbstract = new TestMyAbstract();
	Employee e1 = new Employee ("adam", "engineering", 28);
	Employee e2 = new Employee ("fatma", "HR", 22);

	// test Q1
	@Test
	public void q1Test() {
		int[] data = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] sorted = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		Assertions.assertArrayEquals(sorted, test.bubbleSort(data));
	}

	// test Q2
	@Test
	public void q2Test() {
		String expected = "0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		test.fibNumber(25);
		Assertions.assertEquals(expected, output.toString());
	}

	// test Q3
	@Test
	public void q3Test() {
		Assertions.assertEquals("olleh", test.reverseString("hello"));
	}

	// test Q4
	@Test
	public void q4Test() {
		Assertions.assertEquals(120, test.nFactorial(5));
	}

	// test Q5
	@Test
	public void q5Test() {
		Assertions.assertEquals("hel", test.subString("hello", 3));
	}

	// test Q6
	@Test
	public void q6Test() {
		Assertions.assertTrue(test.isEven(4));
	}

	// test Q7
	@Test
	public void q7Test() {
		Assertions.assertEquals(0, test.compare(e1, e2));
	}

	// test Q8
	@Test
	public void q8Test() {
		ArrayList<String> excpected = new ArrayList<>();
		excpected.add("madam");
		excpected.add("civic");
		excpected.add("radar");
		excpected.add("kayak");
		excpected.add("refer");
		excpected.add("did");
		Assertions.assertEquals(excpected, test.palindromes("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak",
				"john", "refer", "billy", "did"));
	}

	// test Q9
	@Test
	public void q9Test() {
		String expected = "2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		test.printPrime();
		Assertions.assertEquals(expected, output.toString());
	}

	// test Q10
	@Test
	public void q10Test() {
		Assertions.assertEquals(4, test.min(10, 4));
	}

	// test Q12
	@Test
	public void q12Test() {
		String expected = "2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		test.printEven();
		Assertions.assertEquals(expected, output.toString());
	}

	// test Q13
	@Test
	public void q13Test() {
		String expected = "0\n10\n101\n0101\n";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		test.displayTriangle();
		Assertions.assertEquals(expected, output.toString());
	}

	// test Q14
	@Test
	public void q14Test() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		test.switchTest(1);
		Assertions.assertEquals("square root of 16 is : 4.0\n", output.toString());
	}

	// test Q15
	@Test
	public void q15Test() {
		Assertions.assertEquals(8, testInterface.addition(3, 5));
		Assertions.assertEquals(5, testInterface.subtraction(10, 5));
		Assertions.assertEquals(35, testInterface.multiplication(7, 5));
		Assertions.assertEquals(3.0, testInterface.division(15.0, 5.0));

	}

	// test Q18
	@Test
	public void q18Test() {
		Assertions.assertTrue(testAbstract.checkUpperCase("Hello World"));
		Assertions.assertEquals("HELLO", testAbstract.convertToUpper("Hello"));
	}

	// test Q17
//	@Test
//	public void q17Test() {
//		System.out.println("please enter principal, rate, and time in years:");
//		Assertions.assertEquals(5, test.interest());
//	}

}
