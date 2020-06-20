package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import domain.StackArray;

public class StackArrayTest {

	private static StackArray stackArray;

	@BeforeAll
	public static void initialize() {
		stackArray = new StackArray();
	}

	@Test
	public void pushTest() {
		StackArrayTest.stackArray.makeEmpty();

		int valueTested = 1;
		StackArrayTest.stackArray.push(valueTested);
		int result = StackArrayTest.stackArray.peek();

		StackArrayTest.stackArray.makeEmpty();

		assertEquals(valueTested, result);
	}

	@Test
	public void pushListaVaziaTest() {
		StackArrayTest.stackArray.makeEmpty();

		int result = StackArrayTest.stackArray.peek();

		assertEquals(-1, result);
	}

	@Test
	public void pushRemoveElementoTest() {
		StackArrayTest.stackArray.makeEmpty();

		for (int i = 1; i < 11; i++) {
			StackArrayTest.stackArray.push(i);
		}

		int valueRemoved = StackArrayTest.stackArray.pop();
		int result = StackArrayTest.stackArray.peek();

		StackArrayTest.stackArray.makeEmpty();

		assertNotEquals(valueRemoved, result);
	}

	@Test
	public void comparebleTest() {
		StackArrayTest.stackArray.makeEmpty();

		int[] arrayTest = new int[10];

		for (int i = 0; i < 10; i++) {
			StackArrayTest.stackArray.push(i);
			arrayTest[i] = i;
		}

		int resultPop = StackArrayTest.stackArray.pop();
		int resultPop2 = StackArrayTest.stackArray.pop();

		StackArrayTest.stackArray.makeEmpty();

		assertAll(
					() -> assertEquals(arrayTest[resultPop], resultPop),
					() -> assertEquals(arrayTest[resultPop2], resultPop2)
				);
	}

	@Test
	public void removidoDaOrdemCorretaTest() {
		StackArrayTest.stackArray.makeEmpty();

		int[] arrayTest = new int[10];

		for (int i = 0; i < 10; i++) {
			StackArrayTest.stackArray.push(i);
			arrayTest[i] = i;
		}

		int resultPop = StackArrayTest.stackArray.pop();
		int resultPop2 = StackArrayTest.stackArray.pop();

		StackArrayTest.stackArray.makeEmpty();

		assertAll(
					() -> assertEquals(arrayTest[arrayTest.length - 1], resultPop),
					() -> assertEquals(arrayTest[arrayTest.length - 2], resultPop2)
				);
	}

	@Test
	public void isFullTest() {

		StackArray st = new StackArray(5);
		boolean result = st.isFull();

		for (int i = 0; i < 5; i++) {
			st.push(i);
		}

		boolean result2 = st.isFull();
		st.push(6);
		boolean result3 = st.isFull();

		assertAll(
					() -> assertEquals(false, result), 
					() -> assertEquals(true, result2),
					() -> assertEquals(false, result3)
				);
	}
	
	@Test
	public void isEmptyTest() {
		StackArrayTest.stackArray.makeEmpty();
		
		boolean result = StackArrayTest.stackArray.isEmpty();
		
		assertTrue(result);
	}
	
	@Test
	public void makeEmptyTest() {
		StackArrayTest.stackArray.makeEmpty();
		StackArrayTest.stackArray.push(1);
		
		boolean result = StackArrayTest.stackArray.isEmpty();
		
		assertFalse(result);
	}
	
	@Test
	public void popTest() {
		int value = 1, value2 = 2;
		StackArrayTest.stackArray.makeEmpty();
		StackArrayTest.stackArray.push(value);
		StackArrayTest.stackArray.push(value2);
		int result = StackArrayTest.stackArray.pop();
		
		StackArrayTest.stackArray.makeEmpty();
		int result2 = StackArrayTest.stackArray.pop();
				
		assertAll(
					() -> assertEquals(value2, result),
					() -> assertEquals(-1, result2)
				);
	}
	
	@Test
	public void peekTest() {
		int value = 1;
		StackArrayTest.stackArray.makeEmpty();
		
		StackArrayTest.stackArray.push(value);
		int result = StackArrayTest.stackArray.peek();
		
		assertEquals(value, result);

	}
	
	@Test
	public void maxSizeTest() {
		StackArray st = new StackArray(5);
		
		int result = st.getMaxSize();
		int result2 = StackArrayTest.stackArray.getMaxSize();
		
		assertAll(
					() -> assertEquals(5, result),
					() -> assertEquals(10, result2)
				);

	}

}
