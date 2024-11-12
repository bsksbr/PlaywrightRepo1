package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocatorsByRole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserCtx= browser.newContext();
		Page page=browserCtx.newPage();
		page.navigate("https://www.orangehrm.com");
		
		boolean isElementVisibleByRole;
		
		Locator locateByRoleOptions = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales"));
		if(locateByRoleOptions.isVisible()) 
			System.out.println("Contact Sales button is Visible");
		else 
			System.out.println("Contact Sales button is Not Visible");
		
//		locateByRoleOptions.click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales")).click();
		System.out.println("Page title @ Contact Sales Page : "+page.title());
		
		page.close();
		browserCtx.close();
		browser.close();
		playwright.close();

	}

}
