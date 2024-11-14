package playwrightpractice;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class IframeHandlingExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser and open a new page
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the Employment Application Form URL
            page.navigate("https://www.formsite.com/templates/education/teacher-recommendation-form/");
//          page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Teacher Recommendation Form")).click();
            
            page.locator("img[alt='Teacher Recommendation Form']").click();
            
            page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-1").fill("Senthil");
            
            // Print out a success message (or handle assertions as needed)
            System.out.println("Iframe Identified Successfully!");

            // Close the browser after the test is complete
            browser.close();
        }
    }
}

