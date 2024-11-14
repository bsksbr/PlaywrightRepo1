package playwrightpractice;

import com.microsoft.playwright.*;

import com.microsoft.playwright.*;

public class FrameHandlingExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the target URL
            page.navigate("https://the-internet.herokuapp.com/nested_frames");

            // Use FrameLocator to access the "frame-bottom" frame directly
            FrameLocator bottomFrameLocator = page.frameLocator("frame[name='frame-bottom']");
            String bottomFrameText = bottomFrameLocator.locator("body").textContent();
            System.out.println("Bottom Frame Content: " + bottomFrameText);

            // Access the top frame, then locate nested frames within it
            FrameLocator topFrameLocator = page.frameLocator("frame[name='frame-top']");

            // Within "frame-top", access the "frame-left"
            FrameLocator leftFrameLocator = topFrameLocator.frameLocator("frame[name='frame-left']");
            String leftFrameText = leftFrameLocator.locator("body").textContent();
            System.out.println("Left Frame Content: " + leftFrameText);

            // Access "frame-middle" within "frame-top"
            FrameLocator middleFrameLocator = topFrameLocator.frameLocator("frame[name='frame-middle']");
            String middleFrameText = middleFrameLocator.locator("body").textContent();
            System.out.println("Middle Frame Content: " + middleFrameText);

            // Access "frame-right" within "frame-top"
            FrameLocator rightFrameLocator = topFrameLocator.frameLocator("frame[name='frame-right']");
            String rightFrameText = rightFrameLocator.locator("body").textContent();
            System.out.println("Right Frame Content: " + rightFrameText);

            // Close the browser
            browser.close();
        }
    }
}

