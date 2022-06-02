package basics;

import com.microsoft.playwright.*;

public class RelativeLocators {

    private static final String URL_ADDRESS = "https://selectorshub.com/xpath-practice-page/";
    private static Page page;

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            page = browserContext.newPage();

            page.navigate(URL_ADDRESS);
            selectUser("Joe.Root");
            selectUser("Jasmine.Morgan");

            String userRole = getUserRole("Joe.Root");
            System.out.println(userRole);

            String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
            System.out.println(aboveUser);

            String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
            System.out.println(belowUser);
            
            page.close();
            browserContext.close();
        }
    }

    public static void selectUser(String userName) {
        page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
    }

    public static String getUserRole(String userName) {
        return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
    }
}
