package playwrightpractice;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class DropdownExample {
    public static void main(String[] args) {
        // Initialize Playwright and create a new browser/page instance
        try (Playwright playwright = Playwright.create()) {
    		Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    		
    		// Locators - Locate the element and elements from the web pages
    		
    		BrowserContext brCtx1 = browser.newContext();
    		Page page=brCtx1.newPage();
//            Page page = playwright.chromium().launch().newPage();
            page.navigate("https://www.orangehrm.com/"); 
            
            
            Locator button = page.getByText("Book a Free Demo").last();
    		if (!button.isVisible()) {
    		    System.out.println("Element is not visible.");
    		} else {
    			System.out.println("\n\n\n Element is visible. \n\n\n");
    			button.hover();
    		    button.click();
    		}

            // Wait for the dropdown to appear by checking visibility directly with Locator
            Locator dropdown = page.locator("select#Form_getForm_Country"); // Replace with actual dropdown selector
            dropdown.waitFor(new Locator.WaitForOptions().setTimeout(5000)); // Waits up to 5 seconds
            

            // Locate the options within the dropdown
            Locator options = dropdown.locator("option");

            // Ensure options are present (adjust timeout if needed for dynamic loading)
//            while (options.count() == 0) {
//                page.waitForTimeout(200); // Short delay to allow time for options to load
//            }

            // Retrieve the values of all options in the dropdown
            List<String> dropdownValues = (List<String>) options.evaluateAll("options => options.map(option => option.value)");

            // Print the dropdown values
            System.out.println("Dropdown Values : " + dropdownValues.size());
//            dropdownValues.forEach(System.out::println);
        }
    }
}
