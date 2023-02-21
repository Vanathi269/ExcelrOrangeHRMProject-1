package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditNationality {
	
@Test(priority = 5)
	public void editNationanality() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Nationalities']")).click();
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[4]")).click();
		WebElement write= driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		write.clear();
		write.sendKeys("India");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.getPageSource().contains("India");
		driver.close();

}
}