/**
 * 
 */
package myPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Abdalla Hablas
 * @date Aug 18, 2020
 */
public class Homework implements Comparator<Employee> {

	// Q1
	// -------------------------------------------------------------------------------
	public int[] bubbleSort(int[] data) {
		int temp;
		int lastSwap;
		int end = data.length - 1;
		while (end > 1) {
			lastSwap = 0;
			for (int j = 0; j < end; j++) {
				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
					lastSwap = j + 1;
				}
			}
			end = lastSwap;
		}
		return data;
	}

	// Q2
	// -------------------------------------------------------------------------------
	// print fib sequence
	public void fibNumber(int number) {
		for (int i = 0; i < number; i++) {
			System.out.print(fibNumberHelper(i) + ",");
		}
	}

	// compute the fib number [ fn = f(n-1)+ f(n-2)]
	private int fibNumberHelper(int n) {
		if (n <= 1)
			return n; // base case
		else
			return (fibNumberHelper(n - 1) + fibNumberHelper(n - 2));
	}

	// Q3
	// -------------------------------------------------------------------------------

	public String reverseString(String s) {
		int lowIndex = 0;
		int highIndex = s.length() - 1;
		char[] sArray = s.toCharArray();
		while (lowIndex < highIndex) {
			// use xor to swap without temp variable
			sArray[lowIndex] ^= sArray[highIndex];
			sArray[highIndex] ^= sArray[lowIndex];
			sArray[lowIndex] ^= sArray[highIndex];

			lowIndex++; // Increment lowIndex
			highIndex--; // decrement highIndex
		}
		return String.valueOf(sArray);
	}

	// Q4
	// -------------------------------------------------------------------------------
	public int nFactorial(int n) {
		if (n <= 1)
			return 1;
		return n * nFactorial(n - 1);
	}

	// Q5
	// -------------------------------------------------------------------------------
	public String subString(String str, int idx) {
		char[] data = new char[str.length()];
		for (int i = 0; i < idx; i++) {
			data[i] = str.charAt(i); // copy substring data to an array
		}
		return String.copyValueOf(data, 0, idx); // copy only from index 0 to index needed and convert to string
	}

	// Q6
	// -------------------------------------------------------------------------------
	public boolean isEven(int n) {
		return ((n / 2) * 2 == n); // divide number by 2 and multiply by 2
	}

	// Q7
	// -------------------------------------------------------------------------------
	@Override
	public int compare(Employee e1, Employee e2) {
		// compare names
		if (e1.getName().charAt(0) < (e2.getName().charAt(0)))
			return 0;
		else if(e1.getName().charAt(0) > (e2.getName().charAt(0)))
			return 1;
		// compare department
		if(e1.getDepartment().charAt(0) < (e2.getDepartment().charAt(0)))
			return 0;
		else if (e1.getDepartment().charAt(0) > (e2.getDepartment().charAt(0)))
			return 1;
		// compare ages
		if (e1.getAge() > e2.getAge())
			return 0;
		else if (e1.getAge() < e2.getAge())
			return 1;
		return 0;
	}
	
	// Q8
	// -------------------------------------------------------------------------------
	public ArrayList<String> palindromes(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
			String s8, String s9, String s10, String s11) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> palindromesList = new ArrayList<>();
		// store strings into an array list
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		list.add(s8);
		list.add(s9);
		list.add(s10);
		list.add(s11);

		// find the palindromes and store them into another array list
		for (String i : list) {
			if (checkPalindromes(i))
				palindromesList.add(i);
		}

		return palindromesList;

	}

	// check for palindromes
	public boolean checkPalindromes(String s) {
		// base case
		if (s.length() == 0 || s.length() == 1)
			return true;

		// continue to check beginning and end of the string
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return checkPalindromes(s.substring(1, s.length() - 1));
		}

		// not palindromes
		return false;
	}

	// Q9
	// -------------------------------------------------------------------------------
	public void printPrime() {
		// store 1 to 100 into an array list
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++)
			list.add(i);
		// check for prime and print
		for (Integer n : list) {
			if (primeCheck(n))
				System.out.print(n + ",");
		}
	}

	// primeCheck
	public boolean primeCheck(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// Q10
	// -------------------------------------------------------------------------------
	public int min(int a, int b) {
		return (a > b) ? b : a;
	}

	// Q12
	// -------------------------------------------------------------------------------
	public void printEven() {
		// fill array with numbers from 1 to 100
		int[] data = new int[100];
		for (int i = 0; i < 100; i++) {
			data[i] = i + 1;
		}
		// print even
		for (int i : data) {
			if (i % 2 == 0)
				System.out.print(i + ",");
		}
	}

	// Q13
	// -------------------------------------------------------------------------------
	public void displayTriangle() {
		int a = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(a);
				a = 1 - a;
			}
			System.out.println();
		}
	}

	// Q14
	// -------------------------------------------------------------------------------
	public void switchTest(int a) {
		switch (a) {
		// find square root of 4
		case 1:
			System.out.println("square root of 16 is : " + Math.sqrt(16));
			break;
		case 2:
			System.out.println(java.time.LocalDate.now());
			break;
		case 3:
			String s = "I am learning Core Java";
			String[] split = new String[2];
			split[0] = s.substring(0, s.length() / 2); // first half
			split[1] = s.substring(s.length() / 2, s.length()); // second half
			for (String i : split)
				System.out.println(i);
			break;
		default:
			break;
		}
	}

	// Q16
	// -------------------------------------------------------------------------------

	// Q17
	// -------------------------------------------------------------------------------
	public double interest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter principal: ");
		double principal = scan.nextDouble();
		System.out.println("Enter rate: ");
		double rate = scan.nextDouble();
		System.out.println("Enter time in years: ");
		int time = scan.nextInt();
		scan.close();
		return (principal * rate * time);
	}

	// Q19
	// -------------------------------------------------------------------------------
	public void question19() {
		// create an arraylist and load it with numbers from 1 to 10
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add(i);

		// traverse the list and display it, add even numbers, add odd numbers, and
		// remove primes
		int even = 0;
		int odd = 0;
		for (Integer a : list) {
			System.out.print(a + ",");
			if (a % 2 == 0)
				even += a;
			if (a % 2 != 0)
				odd += a;
			if (!primeCheck(a))
				temp.add(a);
		}

		// display sum of even, sum of odds, and list with no primes
		System.out.println("\nsum of even numbers is: " + even);
		System.out.println("sum of odd numbers is: " + odd);
		list = temp;
		for (Integer a : list)
			System.out.print(a + ",");
	}

	// Q20
	// -------------------------------------------------------------------------------
	public void readFile(String fileName) throws Exception {
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			System.out.println("Name: " + scan.next());
		}
		scan.close();
	}

}
