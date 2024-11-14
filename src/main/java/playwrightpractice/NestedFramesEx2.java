package playwrightpractice;

import com.microsoft.playwright.*;

public class NestedFramesEx2 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the page with nested frames
            page.navigate("https://the-internet.herokuapp.com/nested_frames");

            // Get all frames on the page
            for (Frame frame : page.frames()) {
                System.out.println("Frame Name: " + frame.name());
                System.out.println("Frame URL: " + frame.url());

                // Attempt to get the body content of each frame
                try {
                    String content = frame.locator("body").textContent();
                    System.out.println("Content: " + content);
                } catch (PlaywrightException e) {
                    System.out.println("No accessible content in this frame.");
                }
                System.out.println("-------------------------");
            }

            // Access the main frame
            Frame mainFrame = page.mainFrame();
            System.out.println("Main Frame URL: " + mainFrame.url());
            
            // Close the browser
            browser.close();
        }
    }
}
