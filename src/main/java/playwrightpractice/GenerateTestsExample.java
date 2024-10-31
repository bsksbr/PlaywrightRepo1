package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class GenerateTestsExample {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").fill("ToDos 1 - Learn GIt and GitHub");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("ToDos 2 - Practice Git and Github Commands");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("ToDos 3 - Learn Junit and TestNg together");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("ToDos - Learn Playwright UI Automation");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("ToDos 5 - Practice Junit and TestNG and implement in Playwright Hands-On");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      assertThat(page.getByText("ToDos 5 - Practice Junit and")).isVisible();
      page.getByText("ToDos 3 - Learn Junit and").click();
      System.out.println("ToDos task completed !!! ");
      
    }
  }
}