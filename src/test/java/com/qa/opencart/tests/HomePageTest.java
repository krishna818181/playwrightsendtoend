package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {



    @Test
    public void homePageTitleTest()
    {
        String actualtitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageUlrTest()
    {
        String actualurl = homePage.getHomePageUrl();
        Assert.assertEquals(actualurl,prop.getProperty("url"));
    }

    @Test (dataProvider = "getProductData")
    public void searchTest(String getproduct)
    {
        String getsearchdetail = homePage.doSearch(getproduct);
        Assert.assertEquals(getsearchdetail,"Search - "+getproduct);
    }

    @DataProvider
    public Object[] [] getProductData()
    {
        return new Object[][]
                {
                        {"macbook"},
                        {"iMac"}
                };
    }







}
