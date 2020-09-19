package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalculadorTest {
	private AndroidDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "Calculator");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	@Test
	public void sampleTest() {
		MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("equals");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
		el10.click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
