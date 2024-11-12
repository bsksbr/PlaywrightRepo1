package playwrightpractice;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsROL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext = browser.newContext();
		Page page = brContext.newPage();
		page.navigate("https://playwright.dev/java/");
		
//		--------Locate elements by 'alt' text
		
		Locator altTextLocator = page.getByAltText("Playwright logo");
		altTextLocator.click();
		page.reload();
		System.out.println("Page title ---- After AltText Locator - Playwright Logo image clicked  :: "+page.title());
		
//		--------Locate element by 'title' text
		page.navigate("https://www.orangehrm.com/");
		
		Locator titleLocator= page.getByTitle("Human Resources Management Software | OrangeHRM");
		
		System.out.println("Count : "+titleLocator.textContent());
		if (titleLocator.isVisible()) {
            System.out.println("Title Locator Content: " + titleLocator.textContent());
        } else {
            System.out.println("Element with specified title not found.");
            System.out.println("titleLocator.count() : "+ titleLocator.count());
    		System.out.println("Page Title   :>>>>> "+page.title());
        }
		
	}

}
