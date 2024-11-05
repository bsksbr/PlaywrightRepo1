package playwrightpractice;

import com.microsoft.playwright.*;
/*
 * BrowserContext - BrowserContexts provide a way to operate multiple independent browser sessions.
 * URL: https://playwright.dev/java/docs/api/class-browsercontext
 * 
 * In the below example using one browser profile I have created 3 browser context and each act as a independent sessions.
 * 
 * 
 * */

public class BrowserContextDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brctx1 = browser.newContext();
		Page page1= brctx1.newPage();
		page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		page1.getByPlaceholder("Your Full Name*").click();
		page1.getByPlaceholder("Your Full Name*").fill("Senthil");
		System.out.println("Playwright - Display First BrowserContext's page title: "+page1.title());

		BrowserContext brctx2 = browser.newContext();
		Page page2= brctx2.newPage();
		page2.navigate("http://playwright.dev");
		System.out.println("Playwright - Display Second BrowserContext's page title: "+page2.title());
		
		BrowserContext brctx3 = browser.newContext();
		Page page3= brctx3.newPage();
		page3.navigate("http://automationpractice.com/");
		System.out.println("Playwright - Display Third BrowserContext's page title: "+page3.title());
		
		
		page1.clock();
		brctx1.close();
		
		page2.clock();
		brctx2.close();
		
		page3.clock();
		brctx3.close();
		
		
		browser.close();
		playwright.close();
	}

}
