//
//package practice.Appium_IOS_Android;
//
//import java.io.IOException;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import io.appium.java_client.ios.IOSDriver;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Scenario;
//
//public class Hooks extends BaseIOS{
//	
//	@AfterStep
//	public void addScreenshot(Scenario scenario) throws IOException{
//		IOSDriver driver=DesiredCapabilities("UIKitCatalog");
//		//validate if scenario has failed
//		if(scenario.isFailed()) {
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", "image"); 
//		}
//		
//	}
//
//}
