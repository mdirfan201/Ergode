package com.ErgodeITTestRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.utility.captureutility;

public class AddToCart {
	static WebDriver driver;
	static Logger log= Logger.getLogger(ErgodeRegisterAccount.class);
	@Test
	public void ClickonAddToCart() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\ErgodeAutomationTest\\Browser-Driver\\chromedriver.exe");
		log.info("****************Opening the Chrome Browser******************");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://ergodeinc.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String title= driver.getTitle();
		System.out.println("The Current Page Title is====>"+ title);
		
		driver.findElement(By.xpath("//li[@id='nav-menu-item-2363']//a[text()='Portfolio']")).click();
		String portfoliotitle= driver.getTitle();
		System.out.println("The Portfolio Page Title is====>"+ portfoliotitle);
		
		//captureutility.CaptureScreenShot(driver, "Portfolio Page");
		
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//div[@class='project-box ergodebooks eds-on-scroll eds-scroll-visible animated fadeIn delay1 duration1']//a[text()='Visit Site']")).click();
		Actions action= new Actions(driver);
		WebElement Ergodebook= driver.findElement(By.xpath("//h4[text()='Ergode Books']"));
		action.moveToElement(Ergodebook).build().perform();
		//captureutility.CaptureScreenShot(driver, "ErgodebookPage");
		driver.findElement(By.xpath("//a[@href='http://ergodebooks.com/']	")).click();
		
		Thread.sleep(3000);
		//captureutility.CaptureScreenShot(driver, "ErgodebookPage");
		
		Set<String> windowsIDs=driver.getWindowHandles();
		System.out.println("Total number of Id of Multiple Windiows====>" + windowsIDs.size());
		List<String> windowIDsList= new ArrayList(windowsIDs);
		String ListparentID=windowIDsList.get(0);
		String ListchildID=windowIDsList.get(1);
		System.out.println("ListParent window ID is====> "+ ListparentID);
		System.out.println("Listchild window ID is====> "+ ListchildID);
		driver.switchTo().window(ListchildID);
		System.out.println("Child window title is ===>" + driver.getTitle());
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,350)");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/div[5]/input")).click();
		Thread.sleep(3000);
		captureutility.CaptureScreenShot(driver, "AddTocart");
		
	}
	
	

}
