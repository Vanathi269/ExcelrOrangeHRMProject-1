package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PasswordChange {
	@Test(priority = 18)
	public void changePassword() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[text()='Change Password']")).click();
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("admin123");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@class='oxd-toast-container oxd-toast-container--bottom']")).isEnabled();
		driver.close();

	}
}
