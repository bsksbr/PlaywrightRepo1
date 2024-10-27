package playwrightpractice;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
public class FirstPlaywrightDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("http://playwright.dev");
		System.out.println("Playwright - Display page title: "+page.title());
		
		// taking screenshots
//		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("FirstScreenshot.png")));
		browser.close();
		playwright.close();
	}

}
