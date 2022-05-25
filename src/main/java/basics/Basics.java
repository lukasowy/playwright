package basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class Basics {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
            lp.setChannel("chrome");
            lp.setHeadless(false);
            Browser browser = playwright.chromium().launch(lp);
            Page page = browser.newPage();
            page.navigate("https://www.amazon.com");

            String title = page.title();
            System.out.println(title);

            String url = page.url();
            System.out.println(url);

            browser.close();
        }
    }

}
