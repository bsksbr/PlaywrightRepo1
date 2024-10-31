package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;


// Passing the Environment variable PWDBUG=1 to run in run configuration for debug mode from Playwright Server 
// https://playwright.dev/java/docs/codegen#recording-a-test


public class GenerateTestsExampleDebugMode {
	
	public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").fill("First Task");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("2nd task");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("third task");
      page.getByPlaceholder("What needs to be done?").press("Enter");
    }
  }
}