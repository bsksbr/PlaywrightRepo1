package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandlingExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brCtx= browser.newContext();
		
		Page page=brCtx.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/nested_frames");
		
		// Locate the top frame and access the nested 'left' frame
		FrameLocator leftFrame=page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-left']");
		System.out.println("Left-Frame Text Content ::: "+ leftFrame.locator("body").textContent());
		
		//Locate the top frame and access the nested 'middle' frame
		FrameLocator middleFrame=page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-middle']");
		System.out.println("Middle-Frame Text Content ::: "+middleFrame.locator("body").textContent());
		
		//Locate the top frame then access the nested 'right' frame 
		FrameLocator rightFrame=page.frameLocator("frame[name='frame-top']").frameLocator("frame[name='frame-right']");
		System.out.println("Right-Frame Text Content ::: "+rightFrame.locator("body").textContent());
		
		//Locate the bottom frame and the access the content
		FrameLocator  bottomFrame= page.frameLocator("frame[name='frame-bottom']");
		System.out.println("Bottom Frame Text Content ::: "+ bottomFrame.locator("body").textContent());
		
//		Using Frame 
		String bottomFrame1=page.frame("frame-bottom").locator("body").textContent();
		System.out.println("Bottom_Frm Content Using Frame : : "+bottomFrame1);
		
		Frame topFrame= page.frame("frame-top");
		
		
		String leftFrameTxt = topFrame.frameLocator("frame[name=frame-right]").locator("body").textContent();
		System.out.println("Top_LeftFrame :  -  "+ leftFrameTxt);
		browser.close();
	}

}
