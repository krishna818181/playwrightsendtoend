package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.qa.opencart.factory.PlayWrightFactory.takeScreenshot;

public class LoginPageTest extends BaseTest {


    @Test(priority = 1)
    public void loginPageNavigationTest()
    {
       /*oginPage =  homePage.navigateToLoginPage();
       String gettile = loginPage.loginPageTitle();
       System.out.println(gettile);
       Assert.assertEquals(gettile, AppConstants.LOGIN_PAGE_TITLE);
       loginPage.getForgotPasswordLink();*/

        loginPage = new LoginPage(page);
        String gettile = loginPage.loginPageTitle();
        System.out.println(gettile);
        Assert.assertEquals(gettile, AppConstants.LOGIN_PAGE_TITLE);

    }

    @Test(priority = 2)
    public void checkForgotPassword_LinkExists()
    {
        Assert.assertTrue(loginPage.getForgotPasswordLink());

    }

    @Test(priority = 3)
    public void userLoginIn()
    {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password")));
    }

}
