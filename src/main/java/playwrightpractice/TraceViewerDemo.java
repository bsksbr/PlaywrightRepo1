package playwrightpractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

/*
 * TraceViewer - to check the script execution trace & logs with timeline view of each steps.
 * 
 * https://playwright.dev/java/docs/trace-viewer-intro  
 * 
 * Playwright Trace Viewer is a GUI tool that lets you explore recorded Playwright traces of your tests 
 * meaning you can go back and forward though each action of your test and visually 
 * see what was happening during each action.
 * 
 * */

public class TraceViewerDemo {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByText("This is just a demo of TodoMVC for testing, not the real TodoMVC app. todos").click();
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").fill("T1");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("T2");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("T3");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("T4");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("T5");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByText("T2").click();
      page.locator("li").filter(new Locator.FilterOptions().setHasText("T2")).getByLabel("Toggle Todo").check();
      
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete")).click();
      
      // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}