package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.Listeners.class) invoked from testngListeners.xml
public class ListenerDemo2 {
	
	@Test
	public void test4() {
		System.out.println("I'm inside test4");
	}
	
	@Test
	public void test5() {
		System.out.println("I'm inside test5");
	}
	
	@Test
	public void test6() {
		System.out.println("I'm inside test6");
		throw new SkipException("This test is skipped");
	}
	
}
