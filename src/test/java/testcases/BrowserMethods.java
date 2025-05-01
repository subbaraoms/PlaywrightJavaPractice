package testcases;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		page.navigate("http://way2automation.com");
		System.out.println(page.title());
		Thread.sleep(4000);
		
		page.navigate("http://google.com");
		System.out.println(page.title());
		Thread.sleep(4000);
		
		page.goBack();
		System.out.println(page.title());
		Thread.sleep(4000);
		
		page.goForward();
		System.out.println(page.title());
		Thread.sleep(4000);
		
		page.reload();
		System.out.println(page.title());
		Thread.sleep(4000);
		
		page.close();
		playwright.close();
	}

}
