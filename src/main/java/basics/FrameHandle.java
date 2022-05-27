package basics;

import com.microsoft.playwright.*;

public class FrameHandle {

    private static final String URL_ADDRESS = "http://www.londonfreelance.org/courses/frames/index.html";

    public static void main(String[] args) {


        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();

            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);

            FrameLocator frameLocator = page.frameLocator("//frame[@name='main']");
            String h2 = frameLocator.locator("h2").textContent();
            System.out.println(h2);

            page.close();
            browserContext.close();
        }
    }
}
