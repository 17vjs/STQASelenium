//This Class tests the registration feature of web app on firefox using selenium webdriver.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriver2 {
	public static void main(String []args) {
		System.setProperty("webdriver.gecko.driver", "H:\\WT Assignments\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		String appUrl="http://localhost:8080/JSPDemo/";
		driver.get(appUrl);
		driver.manage().window().maximize();


		//Title check
		String actual_title =driver.getTitle();
		String title="HOME";
		if(actual_title.contentEquals(title))
		{
			System.out.println("Title Verified");
		}
		else
			System.out.println("Title Mismatched");


		//Locating HTMLElements
		WebElement username=driver.findElement(By.name("uname"));
		username.click();
		username.sendKeys("juju@gmail.com");
		WebElement password=driver.findElement(By.name("pass"));
		password.click();
		password.sendKeys("123456");
		System.out.println("Test submitted successfully");

		WebElement register=driver.findElement(By.id("register"));
		register.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to("http://localhost:8080/JSPDemo/");
		System.out.println("Registered successfully");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		System.out.println("Test Script executed successfully");

		System.exit(0);
	}


}
