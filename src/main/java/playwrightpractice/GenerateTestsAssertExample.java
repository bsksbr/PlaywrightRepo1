package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class GenerateTestsAssertExample {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").fill("Task 1");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("Task 2");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("Task 3");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("Task 4");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("Task 5");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("task 2");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByText("task 2", new Page.GetByTextOptions().setExact(true)).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete")).click();
      page.getByText("Task 5").click();
      assertThat(page.getByText("Task 5")).isVisible();
      page.getByText("Task 5").click();
      assertThat(page.getByText("Task 3")).isVisible();
      assertThat(page.locator("body")).containsText("Task 5");
    }
  }
}