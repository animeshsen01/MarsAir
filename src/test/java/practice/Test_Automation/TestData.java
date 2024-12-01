package practice.Test_Automation;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="getData")
	public Object[] getData()
	{
		Object[] data = new Object[1];
		data[0] = "hello";
		//data[1] = "!@#$";
		return data;
		
	}

}
