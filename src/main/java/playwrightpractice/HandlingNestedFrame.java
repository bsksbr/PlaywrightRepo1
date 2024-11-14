package playwrightpractice;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;

/*
 * Nested Frames
 * 
 * Frames with name can be traverse through Frame class 
 * 
 * But nested frames we can only traverse through FrameLocator class		
 * 
 * */
public class HandlingNestedFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brCtx = browser.newContext();
		Page page = brCtx.newPage();
		
		 // Navigate to the nested frames page
		page.navigate("https://the-internet.herokuapp.com/nested_frames");
//		page.waitForLoadState();
		// Access the bottom frame
		Frame bottomFrame= page.frame("frame-bottom");
		
		// Print content from the bottom frame
		System.out.println("Bottom Frame Content: "+bottomFrame.locator("body").textContent());
		
		
		// Access the top frame
		String leftFrametxt = page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-left']").locator("body").textContent();
		System.out.println("Left Frame txt: "+leftFrametxt);

		String middleFrametxt = page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-middle']").locator("body").textContent();
		System.out.println("Middle Frame txt: "+middleFrametxt);
		
		String rightFrametxt = page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-right']").locator("body").textContent();
		System.out.println("Middle Frame txt: "+rightFrametxt);
		
		
	}

}
