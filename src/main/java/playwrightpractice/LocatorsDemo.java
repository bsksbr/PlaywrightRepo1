package playwrightpractice;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;
import com.microsoft.playwright.options.WaitForSelectorState;

/*
 * Locators Practice Demo
 * https://playwright.dev/java/docs/locators
 * 
 * 
 * 
 * */

public class LocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// Locators - Locate the element and elements from the web pages
		
		BrowserContext brCtx1 = browser.newContext();
		Page page=brCtx1.newPage();
		page.navigate("https://www.orangehrm.com/");
		
//		getByRole option suggested by Playwright after analysing the match when I tried with [page.locator("text = Book a Free Demo").first()]
//		For interactive elements like button, a, input, etc. use role locators.
//		Locator locByRole=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book a Free Demo"));
//		locByRole.hover();
//		locByRole.click();
		
		
//		Locator contactSales=page.locator("text = Contact Sales").last();
//		System.out.println("Locators Count : "+ contactSales.count());
//		System.out.println("ListOfLocators found by Playwright : "+ contactSales);
//		contactSales.hover();
//		contactSales.click();
		
//      getByText() - Advised to use getByText for non-interactive elements like div, span, p 
//		
		Locator button = page.getByText("Book a Free Demo").last();
		if (!button.isVisible()) {
		    System.out.println("Element is not visible.");
		} else {
			System.out.println("\n\n\n Element is visible. \n\n\n");
			button.hover();
		    button.click();
		}

		
//		Locator bookDemo=page.locator("text = Book a Free Demo").last();
//		System.out.println("Locators Count : "+ bookDemo.count());
//		System.out.println("ListOfLocators found by Playwright : "+ bookDemo);
//		bookDemo.hover();
//		bookDemo.click();
		
//		Multiple Elements:
		
		Locator countryOptionsLoc = page.locator("select#Form_getForm_Country option");
		page.waitForTimeout(1000);

//		System.out.println("Country Option Count ============: "+ countryOptionsLoc.allInnerTexts());
//		System.out.println("countryOptionsLoc.all().size ++ = "+ countryOptionsLoc.all().size());
		System.out.println("Country Option Count : "+ countryOptionsLoc.count());
		
//		Iterating the options
//		for (int i = 0; i < countryOptionsLoc.count(); i++) {
//			System.out.print(countryOptionsLoc.nth(i).textContent());
//		}

//		List of String
		List<String> optionsTestList = countryOptionsLoc.allTextContents();
//		for (String string : optionsTestList) 
//			System.out.print(string);
		
//		Lamda Expression - Foreach - Iteration 
		optionsTestList.forEach(ele -> System.out.print(ele));
						
//		Iterating the options
		System.out.print("5th Element : "+countryOptionsLoc.nth(5).textContent());
//		for (int i = 0; i < countryOptionsLoc.count(); i++) {
//			System.out.print(countryOptionsLoc.nth(i).textContent());
//		}
	}

}
