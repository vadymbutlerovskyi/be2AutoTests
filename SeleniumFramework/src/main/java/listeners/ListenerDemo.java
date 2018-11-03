package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.Listeners.class) invoked from testngListeners.xml
public class ListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("I'm inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("I'm inside test2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		System.out.println("I'm inside test3");
		throw new SkipException("This test is skipped");
	}
	
}
