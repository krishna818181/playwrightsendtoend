package com.qa.opencart.factory;

import com.microsoft.playwright.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PlayWrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    private static ThreadLocal <Browser> tlBrowser = new ThreadLocal<>();// this class helps in execution of parllel tests
    private static ThreadLocal <BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal <Page> tlBrowserpage = new ThreadLocal<>();
    private static ThreadLocal <Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlayWright()
    {
        return tlPlaywright.get();
    }
    public static Browser getBrowser()
    {
        return tlBrowser.get();
    }
    public static BrowserContext getBrowserContext()
    {
        return tlBrowserContext.get();
    }
    public static Page getPage()
    {
        return tlBrowserpage.get();
    }

    public Page initBrowser(Properties prop)
    {

        System.out.println("browser name is...." + prop.getProperty("browser"));
        String browsername = prop.getProperty("browser").trim();
       // playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch (browsername.toLowerCase())
        {
            case"chromium":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case"firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlayWright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case"safari":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlayWright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case"chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            default:
                System.out.println("invalid browser type");
                break;
        }

        /* browserContext = browser.newContext();
         page = browserContext.newPage();
         page.navigate(prop.getProperty("url"));*/

        tlBrowserContext.set(getBrowser().newContext());
        tlBrowserpage.set(getBrowserContext().newPage());
        getPage().navigate(prop.getProperty("url"));

         return getPage();
    }


    /**
     * this method used to initialize properties from config file
     */
    public Properties init_prop() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/kksumanth/Documents/projects/CompleteEndtoEndPlayWrightFrameWork/src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fileInputStream);

        return prop;
    }

    /**
     * take screen shot
     */

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";

        getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
        return path;
    }


}
