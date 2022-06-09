package basics;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadFile {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");

            Download download = page.waitForDownload(() -> {
                page.click("a:text('chromedriver_mac64.zip')");
            });

            System.out.println(download.failure());

            System.out.println(download.url());

            String path = download.path().toString();
            System.out.println(path);

            download.saveAs(Paths.get("Naveen_chrome.zip"));
            System.out.println(download.suggestedFilename());

            page.close();
            browserContext.close();
        }
    }
}
