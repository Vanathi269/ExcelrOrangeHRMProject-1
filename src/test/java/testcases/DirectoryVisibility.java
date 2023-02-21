package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DirectoryVisibility {
	@Test
	public void directoryDetail() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[8]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.getPageSource().contains("Directory");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window,scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//p[text()='Odis  Adalwin ']")).click();
		driver.findElement(By.xpath("(//p[text()='Odis  Adalwin '])[2]")).isEnabled();
		driver.close();
	}
}
