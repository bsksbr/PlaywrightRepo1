package playwrightpractice;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class FrameLocatorAndFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bctx=browser.newContext();
		
		Page page = bctx.newPage();
		
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		
//		Using CSS 
		
		String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(" css: frameLocator and h2 : "+ header);
		
		String h2 = page.frame("main").locator("h2").textContent();
		System.out.println(" css: frame command and h2 : "+ h2);

		
//		Using Xpath
		
		String header1 = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
		System.out.println("Xpath frameLocator and h2 : "+ header1);

		
	}

}
