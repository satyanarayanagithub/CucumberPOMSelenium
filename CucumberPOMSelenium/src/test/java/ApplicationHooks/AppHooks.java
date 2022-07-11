package ApplicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utility.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	

	private DriverFactory DriverF;
	private WebDriver driver;
	private PropertiesReader propReader;
	Properties prop;
	
	@Before(order = 0)
	public void getproperty() {
		
		propReader = new PropertiesReader();
		prop = propReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browsername = prop.getProperty("browser");
		DriverF = new DriverFactory();
	    driver = DriverF.init_driver(browsername);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void teardown(Scenario Scenario) {
		if(Scenario.isFailed()) {
			//take screenshot
			String name = Scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Scenario.attach(sourcePath, "image/png", name);
		}
	}

}
