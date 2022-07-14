package runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import conexoes.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/",
		glue = {"steps"},
		tags = "@teste",
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "html:target/cucumber-report.html"},
		snippets = SnippetType.CAMELCASE
		)

public class Executa extends DriversFactory {
	
	public static void abrirNavegador() {
		
		String url="https://demoqa.com/";
		String navegador="Chrome";
		
		//utilizar ou não o navegador
		boolean headless = false;
		
		if(navegador.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(headless) {
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1400,800");
			}
			driver = new ChromeDriver(options);
			
		}else if(navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/gecko.exe");
			FirefoxOptions options = new FirefoxOptions();
			if(headless) {
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1400,800");
			}
			driver = new FirefoxDriver(options);
			
		}else {
			System.out.println("Digite navegador");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void screenShot(String nomeEvidencia) throws IOException{
		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/evidencias/"+nomeEvidencia+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	public static void fecharNavegador() {
		driver.quit();
	}

}
