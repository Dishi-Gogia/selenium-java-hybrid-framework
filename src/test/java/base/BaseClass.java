package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	 public Logger logger = LogManager.getLogger(this.getClass());
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		 logger.info("===== Test Execution Started =====");
		 
		 String projectPath = System.getProperty("user.dir");
			FileReader file = new FileReader(projectPath + "/src/test/resources/config.properties");
			p = new Properties();
			p.load(file);
		 String execEnv = p.getProperty("Execution_env");
		
		if("remote".equalsIgnoreCase(execEnv)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			 // OS
		    if (os.equalsIgnoreCase("windows")) {
		        capabilities.setPlatform(Platform.WIN11);
		    } else if (os.equalsIgnoreCase("mac")) {
		        capabilities.setPlatform(Platform.MAC);
		    } else {
		        System.out.println("No matching OS");
		        return;
		    }

		    // Browser
		    switch (br.toLowerCase()) {
		        case "chrome":
		            capabilities.setBrowserName("chrome");
		            break;
		        case "edge":
		            capabilities.setBrowserName("MicrosoftEdge");
		            break;
		        case "firefox":
		            capabilities.setBrowserName("firefox");
		            break;
		        default:
		            System.out.println("Invalid Browser name..");
		            return;
		    }

		    URI gridUri = URI.create("http://localhost:4444/wd/hub");
		    URL gridUrl = gridUri.toURL();

		    driver = new RemoteWebDriver(gridUrl, capabilities);

		} else if ("local".equalsIgnoreCase(execEnv)) {

		    switch (br.toLowerCase()) {
		        case "chrome":
		            driver = new ChromeDriver();
		            break;
		        case "edge":
		            driver = new EdgeDriver();
		            break;
		        case "firefox":
		            driver = new FirefoxDriver();
		            break;
		        default:
		            System.out.println("Invalid Browser name..");
		            return;
		    }

		} else {
		    System.out.println("Invalid execution environment: " + execEnv);
		    return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();

		}
		
	
	@AfterClass
	public void closure() {
		driver.quit();
	}

	  public String captureScreen(String tname) throws IOException{
	    	
	    	String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    	
	    	TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	    	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    	
	    	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+ ".png";
	    	File targetFile=new File(targetFilePath);
	    	sourceFile.renameTo(targetFile);
	    	return targetFilePath;
	    }
}
