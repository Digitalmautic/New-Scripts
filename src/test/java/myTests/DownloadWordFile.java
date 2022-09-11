package myTests;

//Mime types
//http://www.sitepoint.com/web-foundations/mime-types-complete-list/

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) throws InterruptedException {        	..vvvvvvvvvvvvvvvvv	
	
		String location=System.getProperty("user.dir")+"\\Downloads\\";

		//Chrome
				
		  HashMap preferences = new HashMap();
		  preferences.put("download.default_directory", location);
		  
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("prefs", preferences);
		  
		  WebDriverManager.chromedriver().setup(); 
		  WebDriver driver = new ChromeDriver(options);
		 
		 //Edge Browser
		
		  HashMap preferences1 = new HashMap();
		  preferences1.put("download.default_directory", location);
		  
		  EdgeOptions options1 = new EdgeOptions();
		  options.setExperimentalOption("prefs", preferences);
		  
		  WebDriverManager.edgedriver().setup(); 
		  WebDriver driver1 = new EdgeDriver(options1);
		 
		 

		//Firefox
			
			  FirefoxProfile profile = new FirefoxProfile();
			  profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/msword"); 
			  profile.setPreference("browser.download.folderList",2); //0-desktop 1- downloads 2-desired location
			  profile.setPreference("browser.download.dir",location);
			  
			  FirefoxOptions options2 = new FirefoxOptions(); options2.setProfile(profile);
			  
			  WebDriverManager.firefoxdriver().setup(); 
			  WebDriver driver2 = new FirefoxDriver(options2);
			 

		driver.manage().window().maximize();
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/"); //Doc
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
}
