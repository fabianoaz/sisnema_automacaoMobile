package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
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
		driver.findElementById("com.android.calculator2:id/digit_2").click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElementById("com.android.calculator2:id/digit_3").click();
		driver.findElementByAccessibilityId("equals").click();

		MobileElement el10 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
		el10.click();

		System.out.println(el10.getText());

		Assert.assertEquals("5", el10.getText());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
