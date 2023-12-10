package ch.codespin.java.umock

import ch.codespin.java.umock.Mock

public class MockTest extends GroovyTestCase{ 
	Mock insurance
	Mock driver = new Mock()
	Mock kid = new Mock()
	
	public void setUp(){
		Random rand = new Random()  
		insurance = new Mock(name: "brokenleg")
		driver.age = 23
		driver.sex = "M"
		kid.toys = rand.nextInt(10) 
	}
	public void testInsuranceName() {
		assertTrue insurance.name == "brokenleg"
	}	
	public void testDriverAge() {
		assert driver.age < 30
		assertEquals driver.sex, "M"
	}	
	public void testKidToys() {
		assertFalse kid.toys > 10
		assertTrue kid.toys < 10
	}	
	public void testKidAgeNullException() {
		shouldFail(NullPointerException) { kid.age * 2 }
	}	
}
