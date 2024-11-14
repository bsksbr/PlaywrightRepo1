package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brCtx=browser.newContext();
		
		Page page=brCtx.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/nested_frames");
//      Access the 'top' frame
        FrameLocator topFrame = page.frameLocator("frame[name='frame-top']");
        
//      Access the 'left' frame
        FrameLocator leftFrame = topFrame.frameLocator("frame[name='frame-left']");
        System.out.println("Left Frame Text : "+leftFrame.locator("body").textContent());
//		Access the 'middle' frame 
        FrameLocator middleFrame = topFrame.frameLocator("frame[name='frame-middle']");
        System.out.println("Middle Frame Text : "+ middleFrame.locator("body").textContent());
//      Access the 'right' frame
        FrameLocator rightFrame = topFrame.frameLocator("frame[name='frame-right']");
        System.out.println("Right Frame Text  : "+ rightFrame.locator("body").textContent());
//      Access the 'botton' frame
        FrameLocator bottomFrame = page.frameLocator("frame[name='frame-bottom']");
        System.out.println("Bottom Frame Text : "+ bottomFrame.locator("body").textContent());
        
        browser.close();
	}

}
