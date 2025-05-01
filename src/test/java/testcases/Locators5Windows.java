package testcases;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Locators5Windows {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/browser-windows");
		System.out.println(page.title());
		Thread.sleep(5000);
		
		Page popup = page.waitForPopup(() -> {
			page.locator("//*[@id='windowButton']").click();
		});
		
		Thread.sleep(5000);
		
		System.out.println(popup.locator("//*[@id='sampleHeading']").innerText());
		Thread.sleep(2000);
		
		popup.close();
		Thread.sleep(2000);
		page.close();
		Thread.sleep(2000);
		browser.close();
		Thread.sleep(2000);
		playwright.close();
	}

}
