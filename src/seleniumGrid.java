//This Class tests the login and home page of web app on firefox using selenium grid.

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class seleniumGrid {
	public static WebDriver driver;
	public static void main(String []args) throws MalformedURLException,InterruptedException{
		System.setProperty("webdriver.gecko.driver", "H:\\WT Assignments\\geckodriver.exe");
		String URL="http://192.168.44.1:8080/JSPDemo/";
		String Node="http://192.168.44.1:4444/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.firefox();
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.navigate().to(URL);
		Thread.sleep(1000);

		//Title check
		String actual_title =driver.getTitle();
		String title="HOME";
		if(actual_title.contentEquals(title))
		{
			System.out.println("Title Verified");
		}
		else
			System.out.println("Title Mismatched");

		//Checking database
		Connection conn = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dbUrl, user, pass);

			if (conn != null) {
				System.out.print("Connected successfully to database");
			}
		}catch(Exception e) {
			System.out.print("Connection Failed");
		}


		//Locating HTMLElements
		WebElement username=driver.findElement(By.name("uname"));
		username.click();
		username.sendKeys("x@gmail.com");
		WebElement password=driver.findElement(By.name("pass"));
		password.click();
		password.sendKeys("123456");
		System.out.println("Test submitted successfully");

		WebElement login=driver.findElement(By.id("login"));

		login.click();

		System.out.println("Logged in successfully");

		WebElement option2=driver.findElement(By.id("o2"));
		option2.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement next=driver.findElement(By.id("next"));
		next.click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		driver.quit();
		System.out.println("Test Script executed successfully");


		System.exit(0);

	}


}
