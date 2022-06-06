package basics;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Auth {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("http://automationpractice.com/");
            page.click("a:text('Sign in')");
            page.fill("#email", "maniek@gmai.com");
            page.fill("#passwd", "maniek123");
            page.click("#SubmitLogin");

            browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("application.json")));

            page.close();
            browserContext.close();
        }
    }
}
