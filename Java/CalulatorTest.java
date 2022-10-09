package Java;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalulatorTest {

	@Test
	public void testValidArgument() {
		Calulator calc = new Calulator();
		String input1="2*+6";
		String input2="2*673 +56*test";
		String input3="2*675+45-";
		String input4="2*4";
		String input5="2*872-500+75";
		String input6="467+45-90*4";
		String[] seperateInput1 = input1.split("");
		String[] seperateInput2 = input2.split("");
		String[] seperateInput3 = input3.split("");
		String[] seperateInput4 = input4.split("");
		String[] seperateInput5 = input5.split("");
		String[] seperateInput6 = input6.split("");
		assertEquals("Testing double operator case: 2*+6",false,calc.validArgument(seperateInput1));
		assertEquals("Testing with letters case: 2*673 +56*test",false,calc.validArgument(seperateInput2));
		assertEquals("Testing ending the equation with operator case: 2*675+45-",false,calc.validArgument(seperateInput3));
		assertEquals("Testing standard case: 2*4",true,calc.validArgument(seperateInput4));
		assertEquals("Testing standard, longer case: 2*872-500+75",true,calc.validArgument(seperateInput5));
		assertEquals("Testing different, standard, longer case: 467+45-90*4",true,calc.validArgument(seperateInput6));
		
	}
	
	@Test
	public void testIsDigit() {
		Calulator calc = new Calulator();
		String input1="t";
		String input2="T";
		String input3="!";
		String input4="@";
		String input5="3";
		String input6="9";
		assertEquals("Testing with lower case: t",false,calc.isDigit(input1));
		assertEquals("Testing with upper case: T",false,calc.isDigit(input2));
		assertEquals("Testing special character case: !",false,calc.isDigit(input3));
		assertEquals("Testing special character case: @",false,calc.isDigit(input4));
		assertEquals("Testing normal case: 3",true,calc.isDigit(input5));
		assertEquals("Testing normal case: 9",true,calc.isDigit(input6));
	}

	@Test
	public void testIsOperator() {
		Calulator calc = new Calulator();
		String input1="t";
		String input2="T";
		String input3="4";
		String input4="3";
		String input5="*";
		String input6="+";
		assertEquals("Testing with lower case: t",false,calc.isOperator(input1));
		assertEquals("Testing with upper case: T",false,calc.isOperator(input2));
		assertEquals("Testing number case: 4",false,calc.isOperator(input3));
		assertEquals("Testing another number case: 3",false,calc.isOperator(input4));
		assertEquals("Testing multiplication case: *",true,calc.isOperator(input5));
		assertEquals("Testing addition case: +",true,calc.isOperator(input6));
	}

	@Test
	public void testIsLast() {
		Calulator calc = new Calulator();
		String input1="2*4+";
		String input2="2*872-500+75*";
		String input3="2*675+45-";
		String input4="2*4";
		String input5="2*872-500+75";
		String input6="467+45-90*4";
		String[] seperateInput1 = input1.split("");
		String[] seperateInput2 = input2.split("");
		String[] seperateInput3 = input3.split("");
		String[] seperateInput4 = input4.split("");
		String[] seperateInput5 = input5.split("");
		String[] seperateInput6 = input6.split("");
		assertEquals("Testing with ending in + case: +",true,calc.isLast(seperateInput1));
		assertEquals("Testing with ending in * case: *",true,calc.isLast(seperateInput2));
		assertEquals("Testing with ending in - case: -",true,calc.isLast(seperateInput3));
		assertEquals("Testing normal case: ",false,calc.isLast(seperateInput4));
		assertEquals("Testing normal case: ",false,calc.isLast(seperateInput5));
		assertEquals("Testing normal case: ",false,calc.isLast(seperateInput6));
	}

	@Test
	public void evenBrackets() {
		Calulator calc = new Calulator();
		String input1="(2*4+";
		String input2="(2*872-500)+(75*";
		String input3="()2*(675+45)-(";
		String input4="(2*4)";
		String input5="(2*872)-500+75";
		String input6="467+(45-90)*4";
		String[] seperateInput1 = input1.split("");
		String[] seperateInput2 = input2.split("");
		String[] seperateInput3 = input3.split("");
		String[] seperateInput4 = input4.split("");
		String[] seperateInput5 = input5.split("");
		String[] seperateInput6 = input6.split("");
		assertEquals("Testing with ending in + case: +",false,calc.evenBrackets(seperateInput1));
		assertEquals("Testing with ending in * case: *",false,calc.evenBrackets(seperateInput2));
		assertEquals("Testing with ending in - case: -",false,calc.evenBrackets(seperateInput3));
		assertEquals("Testing normal case: ",true,calc.evenBrackets(seperateInput4));
		assertEquals("Testing normal case: ",true,calc.evenBrackets(seperateInput5));
		assertEquals("Testing normal case: ",true,calc.evenBrackets(seperateInput6));
	}
}
