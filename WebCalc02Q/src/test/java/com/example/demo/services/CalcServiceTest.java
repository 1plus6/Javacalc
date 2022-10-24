package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcServiceTest {

	
	private CalcService service = new CalcService();
	
	@Test
	void testCalculateAdd()	{ //１ケース
		String actual = service.calculateAdd("3", "1");
		assertEquals("4", actual);
	}

//	actual=実在の、存在してる
//	assertEquals(a, b)　＝　aとbが正しい
	@Test
	void testCalculateSubtract() {
		String actual = service.calculateSubtract("4" , "1");
		assertEquals("3", actual);
	}

	@Test
	void testCalculateMultiply() {
		String actual = service.calculateMultiply("3" ,"1");
		assertEquals("3", actual);
	}

	@Test
	void testCalculateDivide() {
		String actual = service.calculateDivide("4", "2");
		assertEquals("2.0000000", actual);
	}

//	try catchのcatchがテストされていないから、それをテストする物をつくる
	
	@Test
	void testCalculateAdderror()	{ //１ケース
		String actual = service.calculateAdd("@", "1");
		assertEquals("Aderror", actual);
	}

	@Test
	void testCalculateSubtracterror() {
		String actual = service.calculateSubtract("@" , "1");
		assertEquals("Suerror", actual);
	}

	@Test
	void testCalculateMultiplyerror() {
		String actual = service.calculateMultiply("@" ,"1");
		assertEquals("Muerror", actual);
	}

	@Test
	void testCalculateDivideerror() {
		String actual = service.calculateDivide("@", "2");
		assertEquals("Dierror", actual);
	}

	
}
