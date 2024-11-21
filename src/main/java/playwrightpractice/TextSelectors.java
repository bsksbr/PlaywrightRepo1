package playwrightpractice;

import java.util.Iterator;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

//import com.microsoft.playwright.assertions.PlaywrightAssertions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TextSelectors {

	public static void main (String[] as) {
		
		Playwright playwright = Playwright.create();

		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		
////		Using last() to click the button
//		page.navigate("https://www.orangehrm.com");
//		page.locator("text=Contact Sales").last().click();
//		System.out.println("Page Title on Contact Sales Page : "+ page.title());	
//		assertThat(page.getByLabel("OHRM Platform Section").locator("h4")).containsText("Unlock the Full Potential of OrangeHRM!");
		
		
////		Iterative approach to click the specific button on the web page
//		page.navigate("https://www.orangehrm.com");
//		Locator bookDemoBtnLocator = page.locator("text='Book a Free Demo'");
//		System.out.println("bookDemoButton.count() == " + bookDemoBtnLocator.count());
//
//		for (int i = 0; i < bookDemoBtnLocator.count(); i++) {
//			System.out.println("Text inside each element : "+bookDemoBtnLocator.nth(i).textContent());
//			if(i==1) {
//				bookDemoBtnLocator.nth(i).click();
//			}	
//		}
		
////		Clicking on the exact element and the site have only one match for the given test so navigating to another site
//		
//		page.navigate("https://practicesoftwaretesting.com/");
//		Locator contactLocator = page.locator("text=Contact");
//		System.out.println("page.locator(\"text=Contact\") has text :-: "+ page.locator("text=Contact").textContent());
//		contactLocator.click();
//		System.out.println("Page Title @ Contact page : "+page.title());
//	    assertThat(page.getByRole(AriaRole.HEADING)).containsText("Contact");
		
////		Text selectors using css selectors tags 
//		page.navigate("https://www.orangehrm.com");
////		String bookFreeDemo = page.locator("h1:has-text('Peace of mind is just a few clicks away!')").textContent();
//		String bookFreeDemo = page.locator("div.homepage-slider-content h1:has-text('Peace of mind is just a few clicks away!')").textContent();
//		System.out.println("bookFreeDemo : "+ bookFreeDemo);
//		page.locator("div.btn-toolbar input:has-text('30-Day Free Trial') ").click();
//		System.out.println("Page title After Clicking the button '30-day free Trail' ::- "+page.title());
//		assertThat(page.getByLabel("OHRM Platform Section").locator("h4")).containsText("We Just Need a Few Details.");
//	    assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get Your Free Trial"))).isVisible();

	    
////		Iterate the Locator when more than one locator have same text
//		page.navigate("https://www.orangehrm.com/");
//		Locator privacyPolicyLoc = page.locator("text=Privacy Policy");
//		System.out.println("PP Links Count :: "+ privacyPolicyLoc.count());
//	    
//		for (int i = 0; i < privacyPolicyLoc.count(); i++) {
//			String text = privacyPolicyLoc.nth(i).textContent();
//			if (text.contains("Service Privacy Policy")) {
//				System.out.println("privacyPolicyLoc.nth("+i+") : "+ privacyPolicyLoc.nth(i).textContent()+ " : is going to click in the next step");
//				privacyPolicyLoc.nth(i).click();
//				break;
//			}
//		}
	    
////		using page.locator with text alone:
//		page.navigate("https://www.orangehrm.com");
//		String freeDemoText = page.locator("'Peace of mind is just a few clicks away!'").textContent();
//		System.out.println("freeDemoText : "+freeDemoText);
//
//				
////		Click the Contact sales button using css selectors tags: 
////		Complex CSS Tags:
//		page.navigate("https://practicesoftwaretesting.com/auth/login");
//		String emailLabelText= page.locator("label[for='email']").textContent();
////		page.locator("#navbarSupportedContent > div.d-flex.web-menu-btn > ul > li:nth-child(2) > a").click();
//		System.out.println("Email label Text -=- "+ emailLabelText);
//		
//		String xpathLocatedText=page.locator("//label[@for='email']").textContent();
//		System.out.println("Xpath Value :-:" +xpathLocatedText);
//		System.out.println(page.locator("label").count());
 

//		Find button element using text - css & xpath selectors:
		
		page.navigate("https://practicesoftwaretesting.com/");
	    page.locator("[data-test='search-query']").fill("Hammer");
	    page.locator("input[placeholder='Search']").fill("Rummer");
	    page.locator("//input[@id='search-query']").fill("Grammer");
	    assertThat(page.locator("[data-test='search-submit']")).isVisible();
		page.locator("button:has-text('Search')").click();
		
		
	}

}
