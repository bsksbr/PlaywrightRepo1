package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/*
 * 
 * PlaywrightDOC : https://playwright.dev/java/docs/locators#locate-by-text
 * Locate by text - Find an element by the text it contains. You can match by a substring, exact string, or a regular expression when using Page.getByText().
 * 
 * -------------------------------------------------------------------------------------------------
 * Most of the time .last() will working fine and not the .first() method when use getByText()
 *
 * ChatGPT reply :
 * Why .last() Works 
 * If .last() works consistently, it’s likely because:
 * 		The last occurrence of the element is visible and fully interactable by the time your script executes.
 * 		There’s no overlay or hidden status affecting the last element, while the first might be affected.
 * 
 * */

public class LocatorsByText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bctx= browser.newContext();
		Page page = bctx.newPage();
		page.navigate("https://www.orangehrm.com/");
		Locator firstContactSalesButton = page.getByText("Contact Sales").first();
        Locator lastContactSalesButton = page.getByText("Contact Sales").last();

        System.out.println("Book a Free Demo  ---> Assertion Started:  ...");
        
        assertThat(page.getByText("Book a Free Demo").last()).isVisible();
        
        System.out.println("... : Assertion Closed ");
        
        
        System.out.println("Is first Contact Sales button visible? " + firstContactSalesButton.isVisible());
        System.out.println("Is last Contact Sales button visible? " + lastContactSalesButton.isVisible());

		
        if (firstContactSalesButton.isVisible()) {
            firstContactSalesButton.scrollIntoViewIfNeeded();
            System.out.println("Inside first contact sales button");
            firstContactSalesButton.click();
        } else if (lastContactSalesButton.isVisible()) {
            lastContactSalesButton.scrollIntoViewIfNeeded();
            System.out.println("Inside last contact sales button");
            lastContactSalesButton.click();
        } else {
            System.out.println("Neither first nor last Contact Sales button is visible!");
        }

        
		System.out.println("Contact Sales - Page Title " + page.title());

	}

}
