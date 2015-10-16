package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    //1
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	//1
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	//1
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	//1
	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    //1
    @Test
    public void testOnlyComma() {
    	assertEquals(0, Calculator.add(","));
    }

    //2
    @Test
    public void testUnknownNumberOfArguments() {
    	assertEquals(10, Calculator.add("0,1,1,1,1,1,1,1,1,2"));
    }

    //3
    @Test
    public void testWithEnter() {
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    //3
    @Test
    public void testWithOnlyEnter() {
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    //4
    @Test
    public void testDelimiters() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    //4
    @Test
    public void testDelimiters2() {
    	assertEquals(5, Calculator.add("//!\n2!3"));
    }

    //5
    @Test
    public void testNegativeException() {
    	try {
    		Calculator.add("-1,4,-2");
    	}
    	catch(Exception ex) {
    		assertEquals("Negatives not allowed:-1,-2", ex.getMessage());
    	}
    }

    //6
    @Test
    public void testNumberBiggerThan1000() {
    	assertEquals(2, Calculator.add("1001,2"));
    }
}