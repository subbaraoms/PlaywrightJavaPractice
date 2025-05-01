package testcases;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.way2automation.com/way2auto_jquery/index.php");
		System.out.println(page.title());
		Thread.sleep(2000);
		
		//page.locator("id=identifierId").type("subbaraoms554");
		page.locator("//input[@name='name']").type("Playwright");
		Thread.sleep(2000);
		page.locator("//input[@name='phone']").type("1234567890");
		page.locator("//input[@name='email']").type("playwright@test.com");
		page.locator("//input[@name='city']").type("Chennai");
		page.type("(//input[@name='username'])[2]", "test");
		page.type("(//input[@name='password'])[2]", "test");
		page.locator("(//input[@value='Submit'])[2]").click();
		Thread.sleep(5000);
		
		System.out.println(page.locator("//p[contains(text(),'dummy form')]").innerText());
		page.close();
		playwright.close();
	}

}
