package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class EmulateTestsOniPhone {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
        .setDeviceScaleFactor(3)
        .setHasTouch(true)
        .setIsMobile(true)
        .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.0 Mobile/15E148 Safari/604.1")
        .setViewportSize(390, 664));
      Page page = context.newPage();
      page.navigate("https://playwright.dev/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
      assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("How to install Playwright"))).isVisible();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("How to install Playwright")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("How to install Playwright")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Run single test, multiple")).click();
    }
  }
}