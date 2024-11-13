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
		page.navigate("https://practicesoftwaretesting.com/");
		
		Locator titleLocator= page.getByTitle("Practice Software Testing - Toolshop");
		
		if (titleLocator.isVisible()) {
			System.out.println("Element with getByTitle Found");
			
            System.out.println("Title Locator toString: " + titleLocator.toString());
            titleLocator.click();
            System.out.println("Title Locator got clicked successfully " );
        } else {
            System.out.println("Element with specified title not found.");
            System.out.println("titleLocator.count() : "+ titleLocator.count());
    		System.out.println("Page Title   :>>>>> "+page.title());
        }
//		-------Locate by label -----------------------------
		page.navigate("https://practicesoftwaretesting.com/auth/login");
		page.getByLabel("Email address *").fill("example@mail.com");
		System.out.println("getByLabel :::  - Entered Eamil Address element which have Label attributes");
		
//		-------- Locate by Placeholder ---------------------
		page.getByPlaceholder("Your password").fill("mypassword");
		System.out.println("getByPlaceholder :::  - Entered passwrod  in the text element which Placeholder attributes");
		
		
	}

}
