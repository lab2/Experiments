package ch.codespin.java.umock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ch.codespin.java.umock.Mock;

public class uMockJavaTests {
	Mock person;

	@Test
	public void testName() {
		person = new Mock();
		person.setProperty("name", "miragogi");
		assertTrue(person.getProperty("name") == "miragogi");
	}

	@Test
	public void testAge() {
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("age", 32);
		person = new Mock(data);
		assertTrue(((Number) person.getProperty("age")).intValue() == 32);
	}

	@Test
	public void testAccount() {
		person = new Mock();
		person.setProperty("account", -900);
		assertTrue(((Number) person.getProperty("account")).intValue() <= -900);
	}
}