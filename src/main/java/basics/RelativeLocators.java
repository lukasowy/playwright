package basics;

import com.microsoft.playwright.*;

import java.util.List;

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

            String aboveUser = getUserNameAbove("Joe.Root");
            System.out.println(aboveUser);

            String belowUser = getUserNameBelow("Joe.Root");
            System.out.println(belowUser);

            Locator nearLocator = page.locator("td:near(:text('Joe.Root'),120)");
            List<String> nearElementTexts = nearLocator.allInnerTexts();
            nearElementTexts.forEach(System.out::println);

            page.close();
            browserContext.close();
        }
    }

    private static String getUserNameAbove(String userName) {
        return page.locator("a:above(:text('" + userName + "'))").first().textContent();
    }

    private static String getUserNameBelow(String userName) {
        return page.locator("a:below(:text('" + userName + "'))").first().textContent();
    }

    public static void selectUser(String userName) {
        page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
    }

    public static String getUserRole(String userName) {
        return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
    }
}
