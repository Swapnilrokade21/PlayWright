package parameterisation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterFromXML {
	@Parameters({"browser","env"})
	@Test()
	public void test(String browser,String env) throws InterruptedException
	{
		System.out.println(browser+"::"+env);
		Thread.sleep(3000);
	}

}
