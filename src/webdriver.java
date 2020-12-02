//This Class tests the login,home page and exit feature of web app on firefox using selenium webdriver.

import java.sql.Connection;
import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriver {
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

		//		Checking database
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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.navigate().to("http://localhost:8080/JSPDemo/result.jsp");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement exit=driver.findElement(By.linkText("Exit"));
		exit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		System.out.println("Test Script executed successfully");

		System.exit(0);
	}


}
