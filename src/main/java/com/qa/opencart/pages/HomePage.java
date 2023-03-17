package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    // 1. here locators should be declared in string
    private String search = "input[name='search']"; //css selector
    private String searchIcon = "div#search button"; //css selector
    private String searchPageHeader = "div#content h1"; //css selector

    // 2. page constructor
    public HomePage(Page page)
    {
        this.page = page;
    }

    //3. page actions/methods

    public String getHomePageTitle()
    {
       return page.title();
    }

    public String getHomePageUrl()
    {
        return page.url();
    }

    public String doSearch(String productname)
    {
        page.fill(search,productname);
        page.click(searchIcon);
        return page.textContent(searchPageHeader);

    }

    /*public LoginPage navigateToLoginPage()
    {
        page.click(myAccount);
        page.click(loginBtn);
        return new LoginPage(page);
    }*/

}
