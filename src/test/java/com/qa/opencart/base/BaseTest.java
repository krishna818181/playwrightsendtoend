package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlayWrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {


    protected PlayWrightFactory pf;
    protected Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Properties prop;

    @BeforeClass
    public void setup() throws IOException {
        pf = new PlayWrightFactory();
        prop =  pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);

    }


    @AfterTest
    public void tearDown()
    {
        page.context().browser().close();
    }
}
