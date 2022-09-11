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

import com.fasterxml.jackson.databind.ObjectWriter.Prefetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPDFFile {

	public static void main(String[] args) throws InterruptedException {
	
		String location=System.getProperty("user.dir")+"\\Downloads\\";

		//Chrome
		
		  HashMap preferences = new HashMap();
		  preferences.put("plugins.always_open_pdf_externally", true); // for pdf
		  preferences.put("download.default_directory", location);
		  
		  ChromeOptions options = new ChromeOptions(); 
		  options.setExperimentalOption("prefs", preferences);
		  
		  WebDriverManager.chromedriver().setup(); 
		  WebDriver driver = new ChromeDriver(options);
		 
		


		//Edge Browser
		
		  HashMap preference = new HashMap();
		  preference.put("plugins.always_open_pdf_externally", true); // for pdf
		  preference.put("download.default_directory", location);
		  
		  EdgeOptions option = new EdgeOptions(); 
		  options.setExperimentalOption("prefs", preference); 
		  
		  WebDriverManager.edgedriver().setup(); 
		  WebDriver driver1 = new EdgeDriver(option);
		 

		//Firefox
		FirefoxProfile profile = new FirefoxProfile();	..vvvvvvvvvvvvvvvvv	
		profile.setPreference("pdfjs.disabled", true); // for pdf
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/msword");
		profile.setPreference("browser.download.folderList", 2); //0-desktop  1- downloads  2-desired location
		profile.setPreference("browser.download.dir",location);
		
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setProfile(profile);	
		 
		WebDriverManager.firefoxdriver().setup();	
		WebDriver driver2 = new FirefoxDriver(options1);

		driver1.manage().window().maximize();
		driver1.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/"); 
		driver1.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
}
