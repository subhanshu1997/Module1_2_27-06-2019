package cg;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.management.GarbageCollectorMXBean;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	static Calculator ob;
	
	@BeforeAll ///JUnit4 @BeforeClass
	public static void beforeallTest(){
		System.out.println("Before all Test");
		ob=new Calculator();
	}
	@AfterAll ///jUnit4 AfterClass
	public static void afterAllTest() {
		System.out.println("After all Test");
		ob=null;
	}
	@BeforeEach ///jUnit4 @Before
	public void beforeEachTest(){
		System.out.println("Before each test");
		//ob=new Calculator();
			
	}
	@AfterEach  ///jUnit4 @After
	public void afterEachTest() {
		System.out.println("After each test");
		//ob=null;
		
	}
	@Test
	void testadd() {
		System.out.println("Test Case testadd");
		assertEquals(9,ob.add(5,4));
		
	}
	@RepeatedTest(5)
//	@Test
	void testadd1() {
		System.out.println("Test Case testadd1");
		assertTrue(ob.add(5,4)>0);
		assertTrue(ob.add(-5,4)>=0);
	}
	@Disabled
	@Test
	void testidgenerator(){
		System.out.println("Test Case testidgenerator");
		assertTrue(Calculator.idgenerator()>0 && Calculator.idgenerator()<=1000);
	}
}
