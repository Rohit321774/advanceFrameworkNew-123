package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid {
	@Test
	public void sampleSeleniumGrid() throws MalformedURLException
	{
		URL url=new URL("http://192.168.1.39:4444");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chorme");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		driver.get("https://www.amazon.in");
	}

}
