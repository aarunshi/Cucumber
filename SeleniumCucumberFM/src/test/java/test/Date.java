package test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Date {

	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, IOException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	//	Process process=Runtime.getRuntime().exec("file path of exe or .bat files");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgifederal.secure.force.com");
		Thread.sleep(60000);
		for ( int i =1;i<24;i++)
		{
			
			//Thread.sleep(5000);
		WebElement we = driver.findElement(By.xpath("//*[@id='ctl00_nav_side1']/ul/div"));
		System.out.println("got element");
		String text = we.getText();
		
		if( text.contains("May"))
		{
			//Runtime.getRuntime().exec("C:\\Users\\Aarav\\Downloads\\kumud.bat");
			System.out.println("May date is--"+ text);
			//driver.navigate().refresh();
			//process.getClass().newInstance(); 
			Thread.sleep(120000);
			System.out.println("out of sleep");
			driver.navigate().refresh();
			
		}
		else
		{
			System.out.println("Apr date is--"+text);
			Runtime.getRuntime().exec("C:\\Users\\Aarav\\Downloads\\kumud.bat");
			
			
			
			
			//break;
			//System.out.println("Apr date is--"+text);
		}
		
		
		
	}
		
	}

}
