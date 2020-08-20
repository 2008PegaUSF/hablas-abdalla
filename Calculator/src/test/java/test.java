import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import myPackage.Calculator;


/**
 * @author Abdalla Hablas
 * @date Aug 20, 2020
 */
public class test {
	
	Calculator cal = new Calculator();
	
	@Test
	public void addTest() {
		Assertions.assertEquals(8, cal.calculate("5 + 3"));
		
	}
	
	@Test
	public void subTest() {
		Assertions.assertEquals(2, cal.calculate("5 - 3"));
	}
	
	@Test
	public void multplyTest() {
		Assertions.assertEquals(15, cal.calculate("5 * 3"));
		
	}
	
	@Test
	public void divideTest() {
		Assertions.assertEquals(2, cal.calculate("6 / 3"));
		
	}
	
	@Test
	public void modTest() {
		Assertions.assertEquals(1, cal.calculate("5 % 2"));
	
	}

}
