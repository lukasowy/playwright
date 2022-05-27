package basics;

import com.microsoft.playwright.*;

public class FrameHandle {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext1 = browser.newContext();

            browserContext1.close();
        }
    }
}
