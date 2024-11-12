package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelectors {

	public static void main (String[] as) {
		
		Playwright playwright = Playwright.create();
//		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com");
//		page.navigate("https://www.orangehrm.com/");
		page.locator("text=Contact Sales").last().click();
		System.out.println("Page Title on Contact Sales Page : "+ page.title());
		
		
		
	}

}
