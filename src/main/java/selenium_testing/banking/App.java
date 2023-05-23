package selenium_testing.banking;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        System.out.println( "Hello World!!!" );
        
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--headless");
        ChromeOptions.addArguments("--no-sandbox");
        ChromeOptions.addArguments("--disable-dev-shm-usage");
        ChromeOptions.addArguments("--remote-allow-origins=*");
        
        WebDriver driver = new ChromeDriver(ChromeOptions);
        driver.get("http://44.215.127.121:8081/contact.html");
        driver.findElement(By.name("Name")).sendKeys("Nikhil");
       
        driver.findElement(By.name("Phone Number")).sendKeys("12345678");
        driver.findElement(By.name("Email")).sendKeys("nikhil@gmail.com");
        driver.findElement(By.name("Message")).sendKeys("want a bank account");
        String message =
                driver.findElement(By.id("message")).getText();
                if(message.equals("Message Sent")) {
                System.out.println("Script executed Successfully");
                }
                else {
                System.out.println("Script failed");
                }
                
                System.out.println("Taking Screenshot as proof");
                //take the screenshot of the testcase
             
                
                TakesScreenshot scrShot = ((TakesScreenshot)driver);
                
                File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
                
                File destFile = new File("C:\\reports\\test.jpg");
                
                FileUtils.copyFile(screenShot, destFile);
                
                Thread.sleep(3000);
                driver.quit();
                
    }
}
