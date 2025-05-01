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

public class Locators2Select {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/books");
		System.out.println(page.title());
		Thread.sleep(2000);
		
		page.selectOption("//select", "25");
		Thread.sleep(2000);
		
		page.selectOption("//select", new SelectOption().setValue("100"));
		Thread.sleep(2000);
		
		page.selectOption("//select", new SelectOption().setIndex(2));
		Thread.sleep(2000);
		
		page.selectOption("//select", new SelectOption().setLabel("50 rows"));
		Thread.sleep(2000);
		
		Locator values = page.locator("//select/option");
		System.out.println("Count of Dropdown values : " + values.count());
		for(int i=0; i<values.count(); i++) 
			System.out.println(values.nth(i).innerText());
		
		List<ElementHandle> values2 = page.querySelectorAll("//select/option");
		System.out.println("Count of Dropdown values : " + values2.size());
		for(ElementHandle  value : values2) 
			System.out.println(value.innerText());
		
		page.close();
		playwright.close();
	}

}
