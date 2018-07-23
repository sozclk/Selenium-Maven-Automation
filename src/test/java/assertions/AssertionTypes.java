package assertions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTypes {

	@Test
	public void test1() {
		SoftAssert soft = new SoftAssert();
		String expectedName = "James";
		int expectedAge = 28;

		soft.assertEquals("Ronaldo", expectedName); // Assert.assertEquals("Ronaldo", expectedName);
		soft.assertEquals(32, expectedAge); // Assert.assertEquals(32, expectedAge);

		System.out.println("Ending the test");
		soft.assertAll();

	}

	@Test
	public void w() {
		System.out.println("second the method starting");
		SoftAssert soft = new SoftAssert();
		String s = "Hi";
		soft.assertEquals("Hello", s, "custom messages");
		soft.assertAll();
	}

	@AfterMethod
	public void ending() {

	}
}
